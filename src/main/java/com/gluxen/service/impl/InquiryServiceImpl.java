package com.gluxen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.*;
import com.gluxen.VO.*;
import com.gluxen.VO.RecipePrice.InquiryPriceVO;
import com.gluxen.VO.RecipePrice.MainRecipePriceVO;
import com.gluxen.VO.RecipePrice.MedicinePriceVO;
import com.gluxen.VO.RecipePrice.ViceRecipePriceVO;
import com.gluxen.dao.*;
import com.gluxen.service.InquiryService;
import com.gluxen.util.CommonUtil;
import com.gluxen.util.StringDate;
import com.gluxen.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;




import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
@Service
public class InquiryServiceImpl implements InquiryService{
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private DailyPatientDAO dailyPatientDAO;

    @Autowired
    private RecipeDAO recipeDAO;

    @Autowired
    private RecipeDetailDAO recipeDetailDAO;

    @Autowired
    private ViceRecipeDAO viceRecipeDAO;

    @Autowired
    private ViceRecipeDetailDAO viceRecipeDetailDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private DiagnoseLabelsDAO diagnoseLabelsDAO;

    @Autowired
    private DiagnoseLabelsManualDAO diagnoseLabelsManualDAO;

    @Autowired
    private MedicineDAO medicineDAO;

    /**
     * 新建问诊记录
     * @param patientId
     * @return
     */
    @Override
    public JSONObject newInquiry(Long patientId){
        try{
            DailyPatient dailyPatient = new DailyPatient();

            dailyPatient.setPatientId(patientId);

            SimpleDateFormat df = new SimpleDateFormat(FORMAT_LONG);
            Calendar calendar = Calendar.getInstance();
            dailyPatient.setIqDate(calendar.getTime());

            DailyPatientExample dailyPatientExample = new DailyPatientExample();
            dailyPatientExample.createCriteria().andPatientIdEqualTo(patientId);
            Long count = dailyPatientDAO.countByExample(dailyPatientExample);
            dailyPatient.setTimes(count+1);

            if(0==count){
                dailyPatient.setType("初诊");
            }else{
                dailyPatient.setType("复诊");
            }
            PatientExample patientExample = new PatientExample();
            patientExample.createCriteria().andPatientIdEqualTo(patientId);
            List<Patient> patientList = patientDAO.selectByExample(patientExample);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if(patientList.get(0).getBirthday()!=null){
                JSONObject jsonObject = countAge(sdf.format(patientList.get(0).getBirthday()),null);
                dailyPatient.setCountAge(jsonObject.getString("tag"));
                dailyPatient.setYear(jsonObject.getInteger("year"));
                dailyPatient.setMonth(jsonObject.getInteger("month"));
                dailyPatient.setDay(jsonObject.getInteger("day"));
            }


            dailyPatientDAO.insert(dailyPatient);


            JSONObject data = new JSONObject();
            data.put("inquiryId",dailyPatient.getInquiryId());

            return CommonUtil.successJson(data);
        }catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90006);
        }

    }

    /**
     * 新增或者更新病情描述、药方
     * @param inquiryInfoVO
     * @return
     */
    @Override
    public JSONObject postInquiryInfo(InquiryInfoVO inquiryInfoVO){
        /**
         * 填充问诊ID和病情描述
         */
        DailyPatient dailyPatient = new DailyPatient();
        dailyPatient.setInquiryId(inquiryInfoVO.getInquiryId());
        dailyPatient.setDescription(inquiryInfoVO.getDescription());
        //dailyPatientDAO.updateByPrimaryKeySelective(dailyPatient);

        /**
         * get new inquiryDate and update the dailyPatient's date
         */
        String inquiryDate = inquiryInfoVO.getInquiryDate();
        Date newDate = StringDate.praseLongDate(inquiryDate);
        dailyPatient.setIqDate(newDate);

        //JSONObject amountJSON = new JSONObject();

        /**
         * 删除问诊ID为此次问诊ID的药方，数据库中级联删除
         */
        RecipeExample recipeExample = new RecipeExample();
        recipeExample.createCriteria().andInquiryIdEqualTo(dailyPatient.getInquiryId());
        recipeDAO.deleteByExample(recipeExample);

        /**
         * 获取前台主方
         */
        List<MainRecipeVO> mainRecipeVOList = inquiryInfoVO.getMainReList();
        String  amountString = "";

        for(int i = 0; i < mainRecipeVOList.size(); i++){
            /**
             * 用于药方记录付数
             */
            List<Integer> amountList = new ArrayList<Integer>();
            Integer amountNum = 0;

            MainRecipeVO mainRecipeVO = mainRecipeVOList.get(i);
            Recipe recipe = new Recipe();
            /**
             * 填写除主键之外的信息
             */
            recipe.setInquiryId(dailyPatient.getInquiryId());
            if(mainRecipeVO.getAmount()!=null){
                recipe.setAmount(mainRecipeVO.getAmount());
            }else{
                recipe.setAmount(0);
            }

            if(mainRecipeVO.getIsStock()){
                recipe.setIsStock(1);
            }else{
                recipe.setIsStock(0);
            }
            recipe.setRemarks(mainRecipeVO.getRemarks());

            if(mainRecipeVO.getAmount()!=null){
                amountList.add(amountList.size(),mainRecipeVO.getAmount());
                //amountNum = amountNum + mainRecipeVO.getAmount();
            }else{
                amountList.add(amountList.size(),0);
            }



            /**
             * 提交主方，返回主方ID
             */
            recipeDAO.insert(recipe);
            Long recipeId = recipe.getRecipeId();

            /**
             * 获取主方细节
             */
            List<String> details = mainRecipeVO.getMainMeList();
            for(int count = 0; count < details.size();count++){
                try {
                    /**
                     * 正则表达式分割汉字和数字
                     */
                    Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+(\\.)?(\\d+)?");
                    Matcher m = p.matcher( details.get(count) );
                    m.find();
                    String medicine = m.group(0);
                    m.find();
                    Integer dose = Integer.parseInt(m.group(0));

                    /**
                     * 填写药名、剂量、主方ID，提交
                     */
                    RecipeDetail recipeDetail = new RecipeDetail();
                    recipeDetail.setMedicine(medicine);
                    recipeDetail.setDose(dose);
                    recipeDetail.setRecipeId(recipeId);
                    recipeDetailDAO.insert(recipeDetail);
                }catch (IllegalStateException e){
                    e.printStackTrace();
                    return CommonUtil.errorJson(ErrorEnum.E_90018);
                }


            }

            /**
             * 获取前台副方
             */
            List<ViceRecipeVO> viceRecipeVOList = mainRecipeVO.getViceReList();
            for(int j = 0;j < viceRecipeVOList.size();j++){
                ViceRecipeVO viceRecipeVO = viceRecipeVOList.get(j);
                ViceRecipe viceRecipe = new ViceRecipe();
                /**
                 * 填写主键之外的其他信息并提交
                 */
                viceRecipe.setRecipeId(recipeId);
                viceRecipe.setAmount(viceRecipeVO.getAmount());

                if(viceRecipeVO.getIsStock()){
                    viceRecipe.setIsStock(1);
                }else{
                    viceRecipe.setIsStock(0);
                }
                viceRecipe.setRemarks(viceRecipeVO.getRemarks());
                viceRecipeDAO.insert(viceRecipe);
                Long viceRecipeId = viceRecipe.getViceRecipeId();
                if(viceRecipe.getAmount()!=null){
                    amountNum = amountNum + viceRecipe.getAmount();
                }

                if(viceRecipeVO.getAmount()!=null){
                    amountList.add(amountList.size(),viceRecipeVO.getAmount());
                }else{
                    amountList.add(amountList.size(),0);
                }



                List<String> viceDetails = viceRecipeVO.getViceMeList();
                for(int count = 0; count < viceDetails.size();count++) {
                    try{
                        /**
                         * 正则表达式分割汉字和数字
                         */
                        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+(\\.)?(\\d+)?");
                        Matcher m = p.matcher(viceDetails.get(count));
                        m.find();
                        String medicine = m.group(0);
                        m.find();
                        Integer dose = Integer.parseInt(m.group(0));

                        /**
                         * 填写药名、剂量、副方ID，提交
                         */
                        ViceRecipeDetail viceRecipeDetail = new ViceRecipeDetail();
                        viceRecipeDetail.setDose(dose);
                        viceRecipeDetail.setMedicine(medicine);
                        viceRecipeDetail.setViceRecipeId(viceRecipeId);
                        viceRecipeDetailDAO.insert(viceRecipeDetail);
                    }catch (IllegalStateException e){
                        e.printStackTrace();
                        return CommonUtil.errorJson(ErrorEnum.E_90018);
                    }
                }
            }
            /**
             * 获得药方数量的JSON
             */
//            amountJSON.put("receipe"+String.valueOf(i),amountList);
//            if(amountNum!=0){
//                if(amountString.equals("")){
//                    amountString=amountString+String.valueOf(amountNum);
//                }else{
//                    amountString = amountString + "+"+String.valueOf(amountNum);
//                }
//                dailyPatient.setAmount(amountString);
//            }
            Integer amount = null;
            if(inquiryInfoVO.getAmount()!=null){
                amount = inquiryInfoVO.getAmount();
            }
            dailyPatient.setAmount(String.valueOf(amount));
            if(dailyPatient.getAmount() == null){
                dailyPatient.setAmount("0");
            }

            /**
             * 更新病人的病历年龄
             */
            if(newDate != null){
                Long inquiryId = inquiryInfoVO.getInquiryId();
                DailyPatientExample dailyPatientExample = new DailyPatientExample();
                dailyPatientExample.createCriteria().andInquiryIdEqualTo(inquiryId);
                List<DailyPatient> dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample);
                DailyPatient dailyPatient1 = dailyPatientList.get(0);
                Long pId = dailyPatient1.getPatientId();

                PatientExample patientExample = new PatientExample();
                patientExample.createCriteria().andPatientIdEqualTo(pId);
                List<Patient> patientList = patientDAO.selectByExample(patientExample);
                Patient patient = patientList.get(0);
                Date birth = patient.getBirthday();

                if(newDate.before(birth) ){
                    return CommonUtil.errorJson(ErrorEnum.E_90023);
                }

                JSONObject jsonobject = countAge(StringDate.getShortDate(birth),StringDate.getShortDate(newDate));
//                System.out.println(StringDate.getShortDate(birth)+"-"+StringDate.getShortDate(iqdate));
//                System.out.println(jsonobject);
                dailyPatient.setDay(jsonobject.getInteger("day"));
                dailyPatient.setMonth(jsonobject.getInteger("month"));
                dailyPatient.setYear(jsonobject.getInteger("year"));
                dailyPatient.setCountAge(jsonobject.getString("tag"));
            }
            dailyPatientDAO.updateByPrimaryKeySelective(dailyPatient);
        }
        return CommonUtil.successJson();
    }

    /**
     * 获取问诊信息
     * @param inquiryId
     * @return
     */
    @Override
    public JSONObject getInquiryInfo(Long inquiryId){
        JSONObject data = new JSONObject();
        data.put("inquiryInfo",getInquiryInfoVO(inquiryId));
        return CommonUtil.successJson(data);
    }


    /**
     * 获取病人最近一次的问诊信息
     * @param patientId
     * @return
     */
    @Override
    public JSONObject getLatestInquiryInfo(Long patientId){
        DailyPatientExample dailyPatientExample = new DailyPatientExample();
        dailyPatientExample.setOrderByClause("iq_date ASC");
        dailyPatientExample.createCriteria().andPatientIdEqualTo(patientId);



        List<DailyPatient> dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample);
        /**
         * 最后一个即为最新的
         */

        if(dailyPatientList.size() >= 2){
            JSONObject jsonObject =  getInquiryInfo(dailyPatientList.get(dailyPatientList.size()-2).getInquiryId());
            JSONObject data = jsonObject.getJSONObject("data");
            JSONObject inquiryInfo = data.getJSONObject("inquiryInfo");
            inquiryInfo.put("times",(Long)inquiryInfo.get("times")+1);
            inquiryInfo.put("inquiryDate",StringDate.getLongDate(dailyPatientList.get(dailyPatientList.size()-1).getIqDate()));
            inquiryInfo.put("date",StringDate.getShortDate(dailyPatientList.get(dailyPatientList.size()-1).getIqDate()));
            data.put("inquiryInfo",inquiryInfo);
            jsonObject.put("data",data);
            return jsonObject;
        }else {
            return CommonUtil.successJson();
        }
    }





    /**
     * 新增/修改病人问诊问题答案
     * @param anserListVO
     * @return
     */
    @Override
    public JSONObject postInquiryAnswer(AnserListVO anserListVO){
        Long inquiryId = anserListVO.getInquiryId();
        List<AnswerVO> answerVOList = anserListVO.getAnswerVOList();

        /**
         * 先删掉该ID对应的问题记录
         */
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andInquiryIdEqualTo(inquiryId);
        questionDAO.deleteByExample(questionExample);


        for(int i=0;i < answerVOList.size();i++){
            AnswerVO answerVO = answerVOList.get(i);
            Question question = new Question();
            /**
             * 补全问题的信息
             */
            question.setInquiryId(inquiryId);
            question.setAnswer(answerVO.getAnswer());
            question.setQuestionLabel(answerVO.getQuestionLabel());
            question.setRemark(answerVO.getRemark());
            question.setStem(answerVO.getStem());
            /**
             * 插入问题信息
             */
            questionDAO.insert(question);

        }
        /**
         * 将病人问诊问题填写标志置为1
         */
        DailyPatient dailyPatient = new DailyPatient();
        dailyPatient.setQuestionFlag(1);
        dailyPatient.setInquiryId(inquiryId);
        dailyPatientDAO.updateByPrimaryKeySelective(dailyPatient);

        return  CommonUtil.successJson();
    }

    /**
     * 获取某次问诊的问题答案
     * @param inquiryId
     * @return
     */
    @Override
    public JSONObject getInquiryAnswer(Long inquiryId){
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andInquiryIdEqualTo(inquiryId);
        List<Question> questionList = questionDAO.selectByExample(questionExample);
        List<AnswerVO> answerVOList = new ArrayList<AnswerVO>();

        for(int i = 0;i < questionList.size();i++){
            Question question = questionList.get(i);
            AnswerVO answerVO = new AnswerVO();

            answerVO.setQuestionLabel(question.getQuestionLabel());
            answerVO.setStem(question.getStem());
            answerVO.setRemark(question.getRemark());
            answerVO.setAnswer(question.getAnswer());

            answerVOList.add(answerVOList.size(),answerVO);
        }

        AnserListVO anserListVO = new AnserListVO();

        anserListVO.setInquiryId(inquiryId);
        anserListVO.setAnswerVOList(answerVOList);
        JSONObject data = new JSONObject();
        data.put("AnswerList",anserListVO);

        return CommonUtil.successJson(data);
    }

    /**
     * 读取文件到数据库
     * @param file
     */
    @Override
    public JSONObject getObjFromFile(MultipartFile file){
        int numOfPatient = 0;
        try {
            File f = null;
            InputStream ins = file.getInputStream();
            f = new File(file.getOriginalFilename());
            inputStreamToFile(ins, f);
            FileInputStream in = new FileInputStream(f);
            File del = new File(f.toURI());
            del.delete();
            ObjectInputStream ois=new ObjectInputStream(in);

            SaveToFileVO saveToFileVO=(SaveToFileVO) ois.readObject();              //读出对象

            List<PatientVO> patientVOList = saveToFileVO.getPatientVOList();




            for(int count=0;count<patientVOList.size();count++){
                /**
                 * 得到病人基本信息和问题
                 */
                PatientVO patientVO = patientVOList.get(count);
                Patient patient = patientVO.getPatient();
                System.out.println(patient.getPname());


                /**
                 * 设定筛选条件筛选符合条件的病人
                 */
                PatientExample patientExample = new PatientExample();
                patientExample.createCriteria().andPnameEqualTo(patient.getPname()).andAgeEqualTo(patient.getAge())
                        .andGenderEqualTo(patient.getGender());
//                        .andBirthdayEqualTo(patient.getBirthday())
//                        .andSourceCityEqualTo(patient.getSourceCity())
                if(patient.getSourceCity()!=null){
                    patientExample.createCriteria().andSourceProvinceEqualTo(patient.getSourceProvince());
                    patientExample.createCriteria().andSourceCityEqualTo(patient.getSourceCity());
                }else{
                    patientExample.createCriteria().andSourceProvinceEqualTo(1);
                    patientExample.createCriteria().andSourceCityEqualTo(patient.getSourceProvince());
                    patient.setSourceCity(patient.getSourceProvince());
                    patient.setSourceProvince(1);
                }
                List<Patient> patientList = patientDAO.selectByExample(patientExample);

                /**
                 * 该标志代表同一天没有重复条件的病人
                 */
                int flag = 0;
                for(int counta=0;counta<patientList.size();counta++){
                    Patient oldPatient = patientList.get(counta);
                    Long patientId = oldPatient.getPatientId();
                    /**
                     * 设定病人ID和问诊日期两个筛选条件，筛选在就诊日期就诊过的病人
                     */
                    DailyPatientExample dailyPatientExample = new DailyPatientExample();
                    dailyPatientExample.createCriteria().andPatientIdEqualTo(patientId).andIqDateEqualTo(patient.getIqDate());
                    List<DailyPatient> dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample);
                    flag = dailyPatientList.size()+flag;
                }
                /**
                 * flag大于1代表符合条件的病人出现在了同一天，不再更新
                 */
                if(flag > 1){
                    continue;
                }


                /**
                 * 如果没有出现同一天有相应条件的病人，再次循环，寻找哪个符合条件的病人出现在了这一天
                 */
                for(int counta=0;counta<patientList.size();counta++){
                    Patient oldPatient = patientList.get(counta);
                    Long patientId = oldPatient.getPatientId();
                    DailyPatientExample dailyPatientExample = new DailyPatientExample();
                    /**
                     * 设定病人ID和问诊日期两个筛选条件，筛选在就诊日期就诊过的病人
                     */
                    dailyPatientExample.createCriteria().andPatientIdEqualTo(patientId).andIqDateEqualTo(patient.getIqDate());
                    List<DailyPatient> dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample);

                    /**
                     * 同一天只有一个筛选结果才更新病人信息和问诊问题
                     */
                    if(dailyPatientList.size()==1){
                        patient.setId(oldPatient.getId());
                        patient.setPatientId(oldPatient.getPatientId());
                        patientDAO.updateByPrimaryKeySelective(patient);
                        numOfPatient++;


                        Long inquiryId = dailyPatientList.get(0).getInquiryId();
                        /**
                         * 先删除病人可能存在的问题
                         */
                        QuestionExample questionExample = new QuestionExample();
                        questionExample.createCriteria().andInquiryIdEqualTo(inquiryId);
                        questionDAO.deleteByExample(questionExample);

                        /**
                         * 插入新的
                         */
                        List<Question> questionList = patientVO.getQuestionList();
                        for(int countc = 0; countc < questionList.size();countc++){
                            Question question = questionList.get(countc);
                            question.setInquiryId(inquiryId);
                            question.setQuestionId(null);
                            questionDAO.insert(question);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90017);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90017);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90017);
        }catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90017);

        }
        JSONObject data = new JSONObject();
        data.put("count",numOfPatient);
        return CommonUtil.successJson(data);
    }

    /**
     * 提交诊断标签
     * @param labelsVO
     * @return
     */
    @Override
    public JSONObject postDiagnoseLabels(LabelsVO labelsVO){
        List<String> diagnoseLabelsList = labelsVO.getDiagnoseLabels();
        Long patientId = labelsVO.getPatientId();
        Long inquiryId = labelsVO.getInquiryId();

        /**
         * 删除所有问诊id为当前问诊ID的诊断标签
         */
        if(diagnoseLabelsList!=null){
            DiagnoseLabelsExample diagnoseLabelsExample = new DiagnoseLabelsExample();
            diagnoseLabelsExample.createCriteria().andInquiryIdEqualTo(inquiryId);
            diagnoseLabelsDAO.deleteByExample(diagnoseLabelsExample);
            String description = "";
            for(int count = 0;count < diagnoseLabelsList.size();count++){
                if(count == 0){
                    description = description + diagnoseLabelsList.get(count);
                }else if(count==1){
                    description = description + "," + diagnoseLabelsList.get(count);
                }
                DailyPatient dailyPatient = new DailyPatient();
                dailyPatient.setDiagnoseLabel(description);
                dailyPatient.setInquiryId(inquiryId);
                dailyPatientDAO.updateByPrimaryKeySelective(dailyPatient);

                DiagnoseLabels diagnoseLabels = new DiagnoseLabels();
                diagnoseLabels.setDiagnoseLabels(diagnoseLabelsList.get(count));
                diagnoseLabels.setPatientId(patientId);
                diagnoseLabels.setInquiryId(inquiryId);
                diagnoseLabelsDAO.insert(diagnoseLabels);
            }
        }
        return CommonUtil.successJson();
    }

    /**
     * 获取所有病人的诊断标签
     * @return
     */
    @Override
    public JSONObject getDiagnoseLabels(){
        JSONObject data = new JSONObject();
        List<String> diagnoseLabels = diagnoseLabelsManualDAO.getDiagnoseLabels();
        data.put("diagnoseLabels",diagnoseLabels);
        return CommonUtil.successJson(data);
    }

    /**
     * 获取某个病人的标签
     * @param patientId
     * @return
     */
    @Override
    public JSONObject getOnePatientLabels(Long patientId){
        JSONObject data = new JSONObject();
        List<String> diagnoseLabels = diagnoseLabelsManualDAO.getOnePatientLabels(patientId);
        data.put("diagnoseLabels",diagnoseLabels);
        return CommonUtil.successJson(data);
    }

    /**
     * 获取某次问诊的标签
     * @param inquiryId
     * @return
     */
     public JSONObject getInquiryLabels(Long inquiryId){
         JSONObject data = new JSONObject();
         List<String> diagnoseLabels = diagnoseLabelsManualDAO.getInquiryLabels(inquiryId);
         data.put("diagnoseLabels",diagnoseLabels);
         return CommonUtil.successJson(data);
     }

    public JSONObject getLatestLabels(Long patientId){
        DailyPatientExample dailyPatientExample = new DailyPatientExample();
        dailyPatientExample.createCriteria().andPatientIdEqualTo(patientId);
        List<DailyPatient> dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample);
        /**
         * 最后一个即为最新的
         */


        if(dailyPatientList.size() >= 2){
            return  getInquiryLabels(dailyPatientList.get(dailyPatientList.size()-2).getInquiryId());
        }else {
            return CommonUtil.successJson();
        }
    }


    @Override
    public InquiryInfoVO getInquiryInfoVO(Long inquiryId){
        InquiryInfoVO inquiryInfoVO = new InquiryInfoVO();

        /**
         * 获取问诊记录
         */
        DailyPatient dailyPatient = dailyPatientDAO.selectByPrimaryKey(inquiryId);

        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientIdEqualTo(dailyPatient.getPatientId());
        List<Patient> patientList = patientDAO.selectByExample(patientExample);
        if(patientList.size()>=1){


            inquiryInfoVO.setpName(patientList.get(0).getPname());
            inquiryInfoVO.setAge(dailyPatient.getCountAge());
            if(dailyPatient.getAmount()!=null && !dailyPatient.getAmount().equals("null") ){
                dailyPatient.getAmount();
                inquiryInfoVO.setAmount(Integer.valueOf(dailyPatient.getAmount()));
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            inquiryInfoVO.setDate(df.format(dailyPatient.getIqDate()));
            inquiryInfoVO.setGender(patientList.get(0).getGender());
            inquiryInfoVO.setInquiryDate(df1.format(dailyPatient.getIqDate()));
            inquiryInfoVO.setResisdence(patientList.get(0).getResidence());
            List<String> diagnoseLabels = diagnoseLabelsManualDAO.getInquiryLabels(inquiryId);
            String labels = "";
            for(int i = 0;i<diagnoseLabels.size();i++){
                if(i==0){
                    labels = labels + diagnoseLabels.get(i);
                }else{
                    labels = labels + "，" + diagnoseLabels.get(i);
                }
            }
            inquiryInfoVO.setDiagnoseLabel(labels);
        }


        inquiryInfoVO.setDescription(dailyPatient.getDescription());

        inquiryInfoVO.setInquiryId(inquiryId);

        inquiryInfoVO.setTimes(dailyPatient.getTimes());

        /**
         * 获得主方列表
         */
        RecipeExample recipeExample = new RecipeExample();
        recipeExample.createCriteria().andInquiryIdEqualTo(inquiryId);
        List<Recipe> recipeList = recipeDAO.selectByExample(recipeExample);
        List<MainRecipeVO> mainRecipeVOList = new ArrayList<MainRecipeVO>();

        for(int i = 0;i < recipeList.size();i++){
            /**
             * 填充主方的非列表信息
             */
            Recipe recipe = recipeList.get(i);
            MainRecipeVO mainRecipeVO = new MainRecipeVO();
            mainRecipeVO.setRemarks(recipe.getRemarks());
            mainRecipeVO.setAmount(recipe.getAmount());
            if(recipe.getIsStock()==1){
                mainRecipeVO.setIsStock(true);
            }else if(recipe.getIsStock()==0){
                mainRecipeVO.setIsStock(false);
            }

            /**
             * 获取主方的药方细节并填充
             */
            RecipeDetailExample recipeDetailExample = new RecipeDetailExample();
            recipeDetailExample.createCriteria().andRecipeIdEqualTo(recipe.getRecipeId());
            List<RecipeDetail> recipeDetails = recipeDetailDAO.selectByExample(recipeDetailExample);
            List<String> medicineDetail = new ArrayList<String>();



            for(int j = 0;j < recipeDetails.size();j++){
                RecipeDetail recipeDetail = recipeDetails.get(j);
                String medicine = recipeDetail.getMedicine();
                if(medicine.equals("生蒲黄") || medicine.equals("炒蒲黄")
                        || medicine.equals("生龙骨") || medicine.equals("生牡蛎")
                        || medicine.equals("生龙牡")  || medicine.equals("石决明")
                        || medicine.equals("海金沙")  || medicine.equals("车前子")){
                    recipeDetail.setRemark("纱布包煎");
                }else if(medicine.equals("制附片")||medicine.equals("制白附子")){
                    recipeDetail.setRemark("另包，先煮2小时");
                }else if(medicine.equals("白晒参")||medicine.equals("高丽参")||medicine.equals("红参")){
                    recipeDetail.setRemark("另包，先煮30分钟");
                }else if(medicine.equals("生大黄")){
                    recipeDetail.setRemark("先煮5分钟，待用");
                }else if(medicine.equals("阿胶")){
                    recipeDetail.setRemark("另包，先煮待用");
                }
                Integer dose = recipeDetail.getDose();
                medicineDetail.add(medicineDetail.size(), medicine+String.valueOf(dose));
                recipeDetail.setMedicine(medicine+String.valueOf(dose));
                recipeDetails.set(j,recipeDetail);
            }
            //mainRecipeVO.setMedecine(medicineDetail);
            /**
             * 填充主方细节对象列表
             */
            mainRecipeVO.setRecipeDetailList(recipeDetails);


            /**
             * 获取主方的副方并填充
             */
            ViceRecipeExample viceRecipeExample = new ViceRecipeExample();
            viceRecipeExample.createCriteria().andRecipeIdEqualTo(recipe.getRecipeId());
            List<ViceRecipe> viceRecipeList = viceRecipeDAO.selectByExample(viceRecipeExample);
            List<ViceRecipeVO> viceRecipeVOList = new ArrayList<ViceRecipeVO>();

            for(int j = 0;j < viceRecipeList.size();j++){
                ViceRecipe viceRecipe = viceRecipeList.get(j);
                ViceRecipeVO viceRecipeVO = new ViceRecipeVO();

                /**
                 * 填充副方基本信息
                 */
                if(viceRecipe.getIsStock()==1){
                    viceRecipeVO.setIsStock(true);
                }else{
                    viceRecipeVO.setIsStock(false);
                }
                viceRecipeVO.setAmount(viceRecipe.getAmount());
                viceRecipeVO.setRemarks(viceRecipe.getRemarks());

                List<String> viceDetail = new ArrayList<String>();

                ViceRecipeDetailExample viceRecipeDetailExample = new ViceRecipeDetailExample();
                viceRecipeDetailExample.createCriteria().andViceRecipeIdEqualTo(viceRecipe.getViceRecipeId());
                List<ViceRecipeDetail> viceRecipeDetailList = viceRecipeDetailDAO.selectByExample(viceRecipeDetailExample);

                /**
                 * 填充副方细节
                 */
                for(int count=0 ;count<viceRecipeDetailList.size(); count++){
                    ViceRecipeDetail viceRecipeDetail = viceRecipeDetailList.get(count);
                    String medicine = viceRecipeDetail.getMedicine();
                    if(medicine.equals("生蒲黄") || medicine.equals("炒蒲黄")
                            || medicine.equals("生龙骨") || medicine.equals("生牡蛎")
                            || medicine.equals("生龙牡")  || medicine.equals("石决明")
                            || medicine.equals("海金沙")  || medicine.equals("车前子")){
                        viceRecipeDetail.setRemark("纱布包煎");
                    }else if(medicine.equals("制附片")||medicine.equals("制白附子")){
                        viceRecipeDetail.setRemark("另包,先煮2小时");
                    }else if(medicine.equals("白晒参")||medicine.equals("高丽参")||medicine.equals("红参")){
                        viceRecipeDetail.setRemark("另包,先煮30分钟");
                    }else if(medicine.equals("生大黄")){
                        viceRecipeDetail.setRemark("先煮5分钟,待用");
                    }else if(medicine.equals("阿胶")){
                        viceRecipeDetail.setRemark("另包,先煮待用");
                    }
                    Integer dose = viceRecipeDetail.getDose();
                    viceDetail.add(viceDetail.size(),medicine+String.valueOf(dose));
                    viceRecipeDetail.setMedicine(medicine+String.valueOf(dose));
                    viceRecipeDetailList.set(count,viceRecipeDetail);
                }
                //viceRecipeVO.setMedecine(viceDetail);
                /**
                 * 填充副方对象列表
                 */
                viceRecipeVO.setViceRecipeDetailList(viceRecipeDetailList);
                /**
                 * 副方列表加一
                 */
                viceRecipeVOList.add(viceRecipeVOList.size(),viceRecipeVO);

            }
            /**
             * 填充主方的副方列表
             */
            mainRecipeVO.setViceReList(viceRecipeVOList);
            /**
             * 主方列表加一
             */
            mainRecipeVOList.add(mainRecipeVOList.size(),mainRecipeVO);
        }
        /**
         * 填充问诊信息的主方列表
         */
        inquiryInfoVO.setMainReList(mainRecipeVOList);
        return inquiryInfoVO;
    }

    private static void inputStreamToFile(InputStream ins,File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private String countAge(Date form){
//        String age = "";
//        int year = 0;
//        int month = 0;
//        int day = 0;
//        if(form == null){
//            age = age + 0;
//        } else {
//            Calendar c1 = Calendar.getInstance();
//            Calendar c2 = Calendar.getInstance();
//            c1.setTime(form);
//            c2.setTime(new Date());
//            if (c1.after(c2)) {
//                throw new IllegalArgumentException("生日不能超过当前日期");
//            }
//            int from_year = c1.get(Calendar.YEAR);
//            int from_month = c1.get(Calendar.MONTH)+1;
//            int from_day = c1.get(Calendar.DAY_OF_MONTH);
//            System.out.println("以前："+from_year + "-" + from_month + "-" + from_day);
//            int MaxDayOfMonth = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
//            int to_year = c2.get(Calendar.YEAR);
//            int to_month = c2.get(Calendar.MONTH)+1;
//            int to_day = c2.get(Calendar.DAY_OF_MONTH);
//            System.out.println("现在："+to_year+"-"+to_month+"-"+to_day);
//            year = to_year - from_year;
//            if(c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR) < 0){
//                year = year -1;
//            }
//            if(year < 1){// 小于一岁要精确到月份和天数
//                System.out.println("--------");
//                if(to_month - from_month > 0){
//                    month = to_month -from_month;
//                    if(to_day - from_day < 0){
//                        month = month - 1;
//                        day = to_day -from_day + MaxDayOfMonth;
//                    } else {
//                        day= to_day -from_day;
//                    }
//                }else if(to_month - from_month==0){
//                    if(to_day - from_day > 0){
//                        day = to_day -from_day;
//                    }
//                }
//            }
//            if(year >= 1){
//                age = age + year + "岁";
//            }else if(month > 0) {
//                age = age + month + "个月" + day + "天";
//            }else {
//                age = age + day + "天";
//            }
//        }
//        //System.out.println(year + "--" + month + "--" + day);
//        return age;
//    }
//    public String countAge(Date birthday){
//        Calendar now = Calendar.getInstance();
//        Calendar b = Calendar.getInstance();
//        b.setTime(birthday);
//        int year = now.get(Calendar.YEAR) - b.get(Calendar.YEAR);
//        int month = now.get(Calendar.MONTH) - b.get(Calendar.MONTH);
//        int day = now.get(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH);
//
//        if (month < 0) {
//            month = 12 - b.get(Calendar.MONTH) + now.get(Calendar.MONTH);
//            year -= 1;
//        }
//
//
//        if (day < 0) {
//            day = b.getMaximum(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH) + now.get(Calendar.DAY_OF_MONTH);
//            month -= 1;
//        }
//
//        System.out.println(String.valueOf(year) +","+ String.valueOf(month) +","+ String.valueOf(day));
//
//
//        if(year > 1){
//            return String.valueOf(year) + "岁";
//        } else if(month > 0){
//            return String .valueOf(month) + "月";
//        }else {
//            return String.valueOf(day) + "天";
//        }
//
//    }

    public static JSONObject countAge(String date,String inquiryDate) {
        JSONObject jsonObject = new JSONObject();

        String[] data = date.split("-");

        if (data.length < 3) return jsonObject;


        Calendar birthday = new GregorianCalendar(Integer.valueOf(data[0]), Integer.valueOf(data[1])-1, Integer.valueOf(data[2]));
        Calendar now = Calendar.getInstance();
        if(inquiryDate != null){
            String[] data1 = inquiryDate.split("-");
            now = new GregorianCalendar(Integer.valueOf(data1[0]), Integer.valueOf(data1[1])-1, Integer.valueOf(data1[2]));
        }

        int day = now.get(Calendar.DAY_OF_MONTH) - birthday.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH) - birthday.get(Calendar.MONTH);

        int year = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        //按照减法原理，先day相减，不够向month借；然后month相减，不够向year借；最后year相减。
        if (day < 0) {
            month -= 1;
            now.add(Calendar.MONTH, -1);//得到上一个月，用来得到上个月的天数。
            day = day + now.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        if (month < 0) {
            month = (month + 12) % 12;
            year--;
        }
        jsonObject.put("year",year);
        jsonObject.put("month",month);
        jsonObject.put("day",day);

        System.out.println("年龄：" + year + "岁" + month + "月" + day + "天");
        StringBuffer tag = new StringBuffer();
        if (year > 5) {
            tag.append(year + "岁");
            jsonObject.put("tag",String.valueOf(tag));
            return jsonObject;
        }
        if(year <= 5 && year >= 1){
            tag.append(year + "岁" + month + "月");
            jsonObject.put("tag",String.valueOf(tag));
        }

        if (year < 1 && month >= 0) {
            tag.append(month + "月" + day + "天");
            jsonObject.put("tag",String.valueOf(tag));
            return jsonObject;
        }
//        if (year < 1 && month < 1 && day >= 0) {
//            tag.append(day + "天");
//            return String.valueOf(tag);
//        }
//        if (year == 0 && month == 0 && day == 0) {
//            tag.append("0天");
//        }
        return jsonObject;
    }


    @Override
    public void updateAge(){
        DailyPatientExample dailyPatientExample = new DailyPatientExample();
        List<DailyPatient> dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample);
        for(int i = 0;i < dailyPatientList.size();i++){
            DailyPatient dailyPatient = dailyPatientList.get(i);
            Long pId = dailyPatient.getPatientId();
            PatientExample patientExample = new PatientExample();
            patientExample.createCriteria().andPatientIdEqualTo(pId);
            List<Patient> patientList = patientDAO.selectByExample(patientExample);
            Patient patient = patientList.get(0);
            Date birth = patient.getBirthday();
            Date iqdate = dailyPatient.getIqDate();
            JSONObject jsonobject = countAge(StringDate.getShortDate(birth),StringDate.getShortDate(iqdate));
            System.out.println(StringDate.getShortDate(birth)+"-"+StringDate.getShortDate(iqdate));
            System.out.println(jsonobject);
            dailyPatient.setDay(jsonobject.getInteger("day"));
            dailyPatient.setMonth(jsonobject.getInteger("month"));
            dailyPatient.setYear(jsonobject.getInteger("year"));
            dailyPatient.setCountAge(jsonobject.getString("tag"));
            dailyPatientDAO.updateByPrimaryKey(dailyPatient);
        }
    }


    /**
     * 获取指定问诊所开药方的价格
     *
     * @param inquiryId
     * @return
     */
    @Override
    public JSONObject getRecipesPrice(Long inquiryId) {
        JSONObject data = new JSONObject();
        MedicineExample medicineExample = new MedicineExample();
        medicineExample.createCriteria().andIdIsNotNull();
        List<Medicine> medicineList = medicineDAO.selectByExample(medicineExample);
        ConcurrentHashMap<String,Double> medicines = new ConcurrentHashMap<>(300);
        for (int i = 0; i <medicineList.size() ; i++) {
            Medicine medicine = medicineList.get(i);
            medicines.put(medicine.getMedicineName(), medicine.getMedicinePrice());
        }//medicines即为包含药名和单价的键值对列表

        InquiryPriceVO inquiryPriceVO = new InquiryPriceVO();
        /**
         * 获取问诊记录
         */
        DailyPatient dailyPatient = dailyPatientDAO.selectByPrimaryKey(inquiryId);
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientIdEqualTo(dailyPatient.getPatientId());
        List<Patient> patientList = patientDAO.selectByExample(patientExample);
        if(patientList.size()>=1){
            inquiryPriceVO.setpName(patientList.get(0).getPname());
            inquiryPriceVO.setAge(dailyPatient.getCountAge());
            /*if(dailyPatient.getAmount()!=null && !dailyPatient.getAmount().equals("null") ){
                dailyPatient.getAmount();
                inquiryInfoVO.setAmount(Integer.valueOf(dailyPatient.getAmount()));
            }*/
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            inquiryPriceVO.setGender(patientList.get(0).getGender());
            inquiryPriceVO.setInquiryDate(df1.format(dailyPatient.getIqDate()));
            inquiryPriceVO.setResisdence(patientList.get(0).getResidence());
        }
        inquiryPriceVO.setInquiryId(inquiryId);
        inquiryPriceVO.setTimes(dailyPatient.getTimes());
        /*
        获取主方和副方
         */
        RecipeExample recipeExample = new RecipeExample();
        recipeExample.createCriteria().andInquiryIdEqualTo(inquiryId);
        List<Recipe> recipeList = recipeDAO.selectByExample(recipeExample);
        List<MainRecipePriceVO> mainRecipePriceVOList = new ArrayList<MainRecipePriceVO>();

        for(int i = 0;i < recipeList.size();i++){
            Recipe recipe = recipeList.get(i);
            MainRecipePriceVO mainRecipePriceVO = new MainRecipePriceVO();
            mainRecipePriceVO.setAmount(recipe.getAmount());
            /**
             * 获取主方的药方细节并填充
             */
            RecipeDetailExample recipeDetailExample = new RecipeDetailExample();
            recipeDetailExample.createCriteria().andRecipeIdEqualTo(recipe.getRecipeId());
            List<RecipeDetail> recipeDetails = recipeDetailDAO.selectByExample(recipeDetailExample);
            //主方中的药品列表
            List<MedicinePriceVO> mainMedicinePriceVO = new ArrayList<MedicinePriceVO>();
            for(int j = 0;j < recipeDetails.size();j++){
                RecipeDetail recipeDetail = recipeDetails.get(j);
                MedicinePriceVO medicinePriceVO = new MedicinePriceVO();
                medicinePriceVO.setMedicine(recipeDetail.getMedicine());
                medicinePriceVO.setDoes(recipeDetail.getDose());
                medicinePriceVO.setUnitPrice(medicines.get(medicinePriceVO.getMedicine()));//该药品的单价
                medicinePriceVO.setTotalPrice(medicinePriceVO.getDoes()*medicinePriceVO.getUnitPrice());//单价*数量=该药的总价
                //mainMedicinePriceVO.set(j,medicinePriceVO);
                mainMedicinePriceVO.add(medicinePriceVO);
            }
            /**
             * 填充主方中的药品列表
             */
            mainRecipePriceVO.setMedicineList(mainMedicinePriceVO);


            /**
             * 获取主方的副方并填充
             */
            ViceRecipeExample viceRecipeExample = new ViceRecipeExample();
            viceRecipeExample.createCriteria().andRecipeIdEqualTo(recipe.getRecipeId());
            List<ViceRecipe> viceRecipeList = viceRecipeDAO.selectByExample(viceRecipeExample);
            //List<ViceRecipeVO> viceRecipeVOList = new ArrayList<ViceRecipeVO>();
            if(viceRecipeList.size()>0){
                List<ViceRecipePriceVO> viceRecipePriceVOS = new ArrayList<ViceRecipePriceVO>();
                for(int j = 0;j < viceRecipeList.size();j++){
                    ViceRecipe viceRecipe = viceRecipeList.get(j);
                    ViceRecipePriceVO viceRecipePriceVO = new ViceRecipePriceVO();
                    //ViceRecipeVO viceRecipeVO = new ViceRecipeVO();

                    /**
                     * 填充副方基本信息
                     */
                    viceRecipePriceVO.setAmount(viceRecipe.getAmount());
                    List<MedicinePriceVO> viceMedicinePriceVOList = new ArrayList<MedicinePriceVO>();//该副方中的药品列表

                    ViceRecipeDetailExample viceRecipeDetailExample = new ViceRecipeDetailExample();
                    viceRecipeDetailExample.createCriteria().andViceRecipeIdEqualTo(viceRecipe.getViceRecipeId());
                    List<ViceRecipeDetail> viceRecipeDetailList = viceRecipeDetailDAO.selectByExample(viceRecipeDetailExample);

                    /**
                     * 填充副方细节
                     */

                    for(int count=0 ;count<viceRecipeDetailList.size(); count++){
                        ViceRecipeDetail viceRecipeDetail = viceRecipeDetailList.get(count);
                        MedicinePriceVO medicinePriceVO = new MedicinePriceVO();
                        medicinePriceVO.setMedicine(viceRecipeDetail.getMedicine());
                        medicinePriceVO.setDoes(viceRecipeDetail.getDose());
                        medicinePriceVO.setUnitPrice(medicines.get(medicinePriceVO.getMedicine()));//该药品的单价
                        medicinePriceVO.setTotalPrice(medicinePriceVO.getDoes()*medicinePriceVO.getUnitPrice());//单价*数量=该药的总价
                        //viceMedicinePriceVOList.set(count,medicinePriceVO);
                        viceMedicinePriceVOList.add(medicinePriceVO);
                    }
                    Double unitPrice = 0d;
                    //计算该副方的单付价格
                    for (int k = 0; k < viceMedicinePriceVOList.size(); k++) {
                        unitPrice+=viceMedicinePriceVOList.get(k).getTotalPrice();//加上每一种药的总价
                    }

                    /**
                     * 填充副方对象列表
                     */
                    viceRecipePriceVO.setMedicineList(viceMedicinePriceVOList);
                    viceRecipePriceVO.setUnitPrice(unitPrice);//该副方的单付价格
                    viceRecipePriceVO.setTotalPrice(unitPrice*viceRecipePriceVO.getAmount());//该副方的价格
                    /**
                     * 副方列表加一
                     */
                    viceRecipePriceVOS.add(viceRecipePriceVO);

                }
                /**
                 * 填充主方的副方列表
                 */
                mainRecipePriceVO.setViceReList(viceRecipePriceVOS);
            }
            /**
             * 填充主方的单付价格
             */
            Double unitPrice = 0d;
            for (int j = 0; j < mainRecipePriceVO.getMedicineList().size(); j++) {
                unitPrice+=mainRecipePriceVO.getMedicineList().get(j).getTotalPrice();
            }
            mainRecipePriceVO.setUnitPrice(unitPrice);
            /**
             * 填充主方的总价格（不包含副方价格）
             */
            Double totalPrice = mainRecipePriceVO.getAmount()*unitPrice;
            mainRecipePriceVO.setTotalPrice(totalPrice);
            /**
             * 填充主方的总价格（包含副方）
             */
            Double totalPriceIncludeVice = totalPrice;
            if (mainRecipePriceVO.getViceReList()!=null && mainRecipePriceVO.getViceReList().size()>0){
                for (int j = 0; j < mainRecipePriceVO.getViceReList().size(); j++) {
                    totalPriceIncludeVice+=mainRecipePriceVO.getViceReList().get(j).getTotalPrice();
                }
            }
            mainRecipePriceVO.setTotalPriceIncludeVice(totalPriceIncludeVice);
            /**
             * 主方列表加一
             */
            mainRecipePriceVOList.add(mainRecipePriceVO);
        }
        /**
         * 填充问诊信息的主方列表
         */
        inquiryPriceVO.setMainReList(mainRecipePriceVOList);
        /**
         * 填充该问诊所开所有药方的总费用
         */
        Double price = 0d;
        for (int i = 0; i < inquiryPriceVO.getMainReList().size(); i++) {
            price+=inquiryPriceVO.getMainReList().get(i).getTotalPriceIncludeVice();
        }
        inquiryPriceVO.setPrice(price);
        inquiryPriceVO.setAmount(dailyPatient.getAmount());

        data.put("inquiryPrice",inquiryPriceVO);
        return CommonUtil.successJson(data);
    }

    public static void main(String []args){
        InquiryServiceImpl inquiryService = new InquiryServiceImpl();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = df.parse("1966-02-05");
            Date date1 = df.parse("2018-11-24");
            System.out.println(inquiryService.countAge(df.format(date),null).getString("tag"));
        }catch (ParseException e){
            e.printStackTrace();
        }


    }
}
