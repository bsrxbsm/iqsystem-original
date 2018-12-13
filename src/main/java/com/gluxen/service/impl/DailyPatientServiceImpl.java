package com.gluxen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gluxen.PO.DailyPatient;
import com.gluxen.PO.DailyPatientExample;
import com.gluxen.PO.DiagnoseLabelsExample;
import com.gluxen.dao.DailyPatientDAO;
import com.gluxen.dao.DailyPatientManualDAO;
import com.gluxen.dao.DiagnoseLabelsDAO;
import com.gluxen.service.DailyPatientService;
import com.gluxen.util.CommonUtil;
import com.gluxen.util.constants.ErrorEnum;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
@Service
public class DailyPatientServiceImpl implements DailyPatientService{
    @Autowired
    private DailyPatientManualDAO dailyPatientManualDAO;

    @Autowired
    private DailyPatientDAO dailyPatientDAO;

    @Autowired
    private DiagnoseLabelsDAO diagnoseLabelsDAO;

    /**
     * 获取每日病人列表
     * @param pName
     * @param startDate
     * @param endDate
     * @param keyWords
     * @return
     */

    @Override
    public JSONObject  getDailyPatientList(String pName,String startDate,String endDate,String keyWords,Integer pageNum,Integer pageSize,Long pId,String startAge,String endAge,String residence,String gender){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<JSONObject> dailyPatientList;

        Integer startYear = 0,startMonth = 0,startDay = 0,endYear = 200,endMonth = 12,endDay = 31;

        if(startAge != null && !startAge.equals("")){
            String ageUnit = startAge.replaceAll("[(\\u4e00-\\u9fa5)]+", "-");
            String ageUnit1 = startAge.replaceAll("[\\d]+", "-");

            try{
                String[] unitList = ageUnit1.substring(1).split("-");
                String[] ageList = ageUnit.substring(0,ageUnit.length()-1).split("-");
                if(unitList.length != ageList.length || unitList.length > 3 || unitList.length == 0){
                    return CommonUtil.errorJson(ErrorEnum.E_90022);
                }
                if(unitList.length >= 1){

                    if(unitList[0].equals("岁")){
                        startYear = Integer.valueOf(ageList[0]);
                    }else if(unitList[0].equals("月")){
                        startMonth = Integer.valueOf(ageList[0]);
                    }else if(unitList[0].equals("天")){
                        startDay = Integer.valueOf(ageList[0]);
                    }else{
                        return CommonUtil.errorJson(ErrorEnum.E_90022);
                    }

                    if(unitList.length >= 2){

                        if(unitList[0].equals("岁") && unitList[1].equals("月")){
                            startMonth = Integer.valueOf(ageList[1]);
                        }else if(unitList[0].equals("月") && unitList[1].equals("天")){
                            startDay = Integer.valueOf(ageList[1]);
                        }else{
                            return CommonUtil.errorJson(ErrorEnum.E_90022);
                        }

                        if(unitList.length == 3){
                            if(unitList[0].equals("岁") && unitList[1].equals("月") && unitList[2].equals("天")){
                                startDay = Integer.valueOf(ageList[2]);
                            }else{
                                return CommonUtil.errorJson(ErrorEnum.E_90022);
                            }
                        }
                    }
                }
            }catch (StringIndexOutOfBoundsException e){
                e.printStackTrace();
                return CommonUtil.errorJson(ErrorEnum.E_90022);
            }



        }

        if(endAge != null && !endAge.equals("")){
            String ageUnit = endAge.replaceAll("[(\\u4e00-\\u9fa5)]+", "-");
            String ageUnit1 = endAge.replaceAll("[\\d]+", "-");
            try{
                String[] unitList = ageUnit1.substring(1).split("-");
                String[] ageList = ageUnit.substring(0,ageUnit.length()-1).split("-");
                if(unitList.length != ageList.length || unitList.length > 3 || unitList.length == 0){
                    return CommonUtil.errorJson(ErrorEnum.E_90022);
                }
                if(unitList.length >= 1){
                    if(unitList[0].equals("岁")){
                        endYear = Integer.valueOf(ageList[0]);
                    }else if(unitList[0].equals("月")){
                        endYear = 0;
                        endMonth = Integer.valueOf(ageList[0]);
                    }else if(unitList[0].equals("天")){
                        endYear = 0;
                        endMonth = 0;
                        endDay = Integer.valueOf(ageList[0]);
                    }else{
                        return CommonUtil.errorJson(ErrorEnum.E_90022);
                    }

                    if(unitList.length >= 2){

                        if(unitList[0].equals("岁") && unitList[1].equals("月")){
                            endMonth = Integer.valueOf(ageList[1]);
                        }else if(unitList[0].equals("月") && unitList[1].equals("天")){
                            endDay = Integer.valueOf(ageList[1]);
                        }else{
                            return CommonUtil.errorJson(ErrorEnum.E_90022);
                        }

                        if(unitList.length == 3){
                            if(unitList[0].equals("岁") && unitList[1].equals("月") && unitList[2].equals("天")){
                                endDay = Integer.valueOf(ageList[2]);
                            }else{
                                return CommonUtil.errorJson(ErrorEnum.E_90022);
                            }
                        }
                    }
                }
            }catch (StringIndexOutOfBoundsException e){
                e.printStackTrace();
                return  CommonUtil.errorJson(ErrorEnum.E_90022);
            }

        }


        try{
            if(startDate != null && endDate != null ) {
                Date sDate = sDateFormat.parse(startDate + " 00:00:00");
                Date eDate = sDateFormat.parse(endDate + " 00:00:00");

                Calendar c = Calendar.getInstance();
                c.setTime(eDate);
                c.add(Calendar.DAY_OF_MONTH, 1);
                eDate = c.getTime();


                PageHelper.startPage(pageNum,pageSize);
                dailyPatientList = dailyPatientManualDAO.getDailyPatientList(pName,sDateFormat.format(sDate),sDateFormat.format(eDate),keyWords,pId,startYear,startMonth,startDay,endYear,endMonth,endDay,residence,gender);
            }else {



                PageHelper.startPage(pageNum,pageSize);
                dailyPatientList = dailyPatientManualDAO.getDailyPatientList(pName,startDate,endDate,keyWords,pId,startYear,startMonth,startDay,endYear,endMonth,endDay,residence,gender);
            }

            JSONObject data = new JSONObject();

            PageInfo<JSONObject> dailyPatientPageInfo = new PageInfo<>(dailyPatientList);


            data.put("pageInfo",dailyPatientPageInfo);
            return CommonUtil.successJson(data);
        }catch (ParseException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90021);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90021);
        }
    }

    /**
     * 获取需要填写问诊问题的病人列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public JSONObject getQuestionPatientList(Integer pageNum,Integer pageSize){
        JSONObject data = new JSONObject();
        PageHelper.startPage(pageNum,pageSize);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<JSONObject> patientList = dailyPatientManualDAO.getQuestionPatientList(df.format(new Date()));
        PageInfo<JSONObject> patientPageInfo = new PageInfo<>(patientList);
        data.put("pageInfo",patientPageInfo);
        return CommonUtil.successJson(data);
    }

    /**
     * 删除某一位病人的某一条病历
     * @param inquiryId
     * @return
     */
    @Override
    public JSONObject deleteDailyPatient(Long inquiryId){
        DailyPatientExample dailyPatientExample = new DailyPatientExample();
        dailyPatientExample.createCriteria().andInquiryIdEqualTo(inquiryId);
        DiagnoseLabelsExample diagnoseLabelsExample = new DiagnoseLabelsExample();
        diagnoseLabelsExample.createCriteria().andInquiryIdEqualTo(inquiryId);
        try{
            List<DailyPatient> dailyPatientList =  dailyPatientDAO.selectByExample(dailyPatientExample);

            /**
             * 更新次数大于此次删除的病历的次数为i-1
             */
            if(dailyPatientList.get(0) != null){
                Long times = dailyPatientList.get(0).getTimes();
                Long patientId = dailyPatientList.get(0).getPatientId();
                DailyPatientExample dailyPatientExample2 = new DailyPatientExample();
                dailyPatientExample2.createCriteria().andPatientIdEqualTo(patientId);
                dailyPatientList = dailyPatientDAO.selectByExample(dailyPatientExample2);
                for(int i=0;i<dailyPatientList.size();i++){
                    DailyPatient dailyPatientToUpdateTimes = dailyPatientList.get(i);
                    if(dailyPatientToUpdateTimes.getTimes()>times){
                        dailyPatientToUpdateTimes.setTimes(dailyPatientToUpdateTimes.getTimes()-1);
                        dailyPatientDAO.updateByPrimaryKeySelective(dailyPatientToUpdateTimes);
                    }
                }
            }

            dailyPatientDAO.deleteByExample(dailyPatientExample);
            diagnoseLabelsDAO.deleteByExample(diagnoseLabelsExample);
        }catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(ErrorEnum.E_90020);

        }
        return CommonUtil.successJson();
    }


}
