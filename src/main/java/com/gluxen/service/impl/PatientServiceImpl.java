package com.gluxen.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gluxen.PO.Patient;
import com.gluxen.PO.PatientExample;
import com.gluxen.VO.InquiryInfoVO;
import com.gluxen.dao.DataStatisticsDAO;
import com.gluxen.dao.PatientDAO;
import com.gluxen.dao.PatientManualDAO;
import com.gluxen.dao.PlaceDAO;
import com.gluxen.service.InquiryService;
import com.gluxen.service.PatientService;
import com.gluxen.util.CommonUtil;
import com.gluxen.util.StringDate;
import com.gluxen.util.StringTools;
import com.gluxen.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.gluxen.util.CommonUtil.printToWord;
import static com.gluxen.util.constants.ErrorEnum.E_90005;

/**
 * Created by Yang Xing Luo on 2018/8/5.
 */
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private  PatientDAO patientDAO;

    @Autowired
    private PatientManualDAO patientManualDAO;

    @Autowired
    private PlaceDAO placeDAO;

    @Autowired
    private DataStatisticsDAO dataStatisticsDAO;

    @Autowired
    private InquiryService inquiryService;
    /**
     * 生成病人Id
     * @param patient
     * @return
     */
    @Override
    public Long getNewPid(Patient patient){
        PatientExample ex = new PatientExample();

        ex.createCriteria().andInsertDateEqualTo(new Date());

        long count = patientDAO.countByExample(ex);

        String date = StringDate.getDate();

        String serial =  String.format("%02d", count+1); //高位补0

        String gender = "";

        if(patient.getGender().equals("男")){

            gender = "1";

        }else{

            gender = "0";

        }

        String age = String.format("%03d", patient.getAge());

        return Long.parseLong(date + serial + gender + age);
    }

    /***
     * 新增病人
     * @param patient
     * @return
     */
    @Override
    public JSONObject newPatient(Patient patient){
        Long patientId = getNewPid(patient);
        patient.setPatientId(patientId);
        patient.setInsertDate(new Date());
        patient.setDeleteFlag(0);
        Integer sourceProvince = patient.getSourceProvince();
        Integer sourceCity = patient.getSourceCity();

        Date birthday = patient.getBirthday();


        String cityName = "";
        String provName = "";
        if(sourceCity!=null){
            cityName = placeDAO.getCityName(sourceCity.toString());
            provName = placeDAO.getProvName(sourceProvince.toString());
        }else{
            provName = placeDAO.getCityName(sourceProvince.toString());
            patient.setSourceCity(sourceProvince);
            patient.setSourceProvince(1);
        }
        String residence =  provName + "/" + cityName;
        patient.setResidence(residence);

        try{
            patientDAO.insert(patient);
            JSONObject pId = new JSONObject();
            pId.put("pId",patientId);
            return CommonUtil.successJson(pId);
        }catch (RuntimeException e){
            e.printStackTrace();
            return CommonUtil.errorJson(E_90005);
        }

    }

    /**
     * 复诊
     * @param patient
     * @return
     */
    @Override
    public JSONObject revisit(Patient patient){
        PatientExample ex = new PatientExample();

        PatientExample.Criteria criteria = ex.createCriteria();

        if(!StringTools.isNullOrEmpty(patient.getPname())){
            criteria.andPnameLike("%" + patient.getPname()+ "%");
        }

        if(!StringTools.isNullOrEmpty(patient.getGender())){
            criteria.andGenderEqualTo(patient.getGender());
        }

        if(!StringTools.isNullOrEmpty(patient.getAge())){
            criteria.andAgeEqualTo(patient.getAge());
        }

        if(!StringTools.isNullOrEmpty(patient.getBirthday())){
            criteria.andBirthdayEqualTo(patient.getBirthday());
        }

        if(!StringTools.isNullOrEmpty(patient.getSourceProvince())&&!StringTools.isNullOrEmpty(patient.getSourceCity())){
            criteria.andSourceCityEqualTo(patient.getSourceCity());
            criteria.andSourceProvinceEqualTo(patient.getSourceProvince());
        }
        /**
         * 没有被删除的
         */
        criteria.andDeleteFlagEqualTo(0);


        Long count = patientDAO.countByExample(ex);
        List<Patient> patientList = patientDAO.selectByExample(ex);


        JSONObject data = new JSONObject();

        if(1 == count){
            data.put("isRepeat",0);
            data.put("pId",patientList.get(0).getPatientId());
        }else if(0 == count){
            data.put("isRepeat",2);
        }else {
            data.put("isRepeat",1);
        }

        return CommonUtil.successJson(data);

    }

    /**
     * 同时获取城市和省份
     * @return
     */
    @Override
    public JSONObject getPlace(){
        JSONObject returnData = new JSONObject();
        List<JSONObject> placeList = placeDAO.getPlace();
        returnData.put("placeList",placeList);
        return CommonUtil.successJson(returnData);
    }

    /**
     * 获取病人列表
     * @param pName
     * @param pageSize
     * @param pageNum
     */
    @Override
    public JSONObject getPatientList(String pName, Integer pageSize, Integer pageNum){
        JSONObject data = new JSONObject();
        PageHelper.startPage(pageNum,pageSize);
        List<JSONObject> patientList = patientManualDAO.getPatientList(pName);

        PageInfo<JSONObject> patientPageInfo = new PageInfo<>(patientList);

        data.put("pageInfo",patientPageInfo);

        return CommonUtil.successJson(data);
    }


    /**
     * 获取病人信息
     * @param pId
     * @return
     */
    @Override
    public JSONObject getPatientInfo(Long pId){
        JSONObject data = new JSONObject();
        PatientExample ex = new PatientExample();
        ex.createCriteria().andPatientIdEqualTo(pId);
        List<Patient> patient = patientDAO.selectByExample(ex);
        data.put("patientInfo",patient.get(0));
        return CommonUtil.successJson(data);
    }

    /**
     * 按patientId为条件更新病人信息，忽略null
     * @param patient
     * @return
     */
    @Override
    public JSONObject updatePatientInfo(Patient patient){
        PatientExample patientExample = new PatientExample();
        PatientExample.Criteria criteria = patientExample.createCriteria();
        criteria.andPatientIdEqualTo(patient.getPatientId());

        Integer sourceProvince = patient.getSourceProvince();
        Integer sourceCity = patient.getSourceCity();
        String cityName = "";
        String provName = "";
        if(sourceCity!=null){
            cityName = placeDAO.getCityName(sourceCity.toString());
            provName = placeDAO.getProvName(sourceProvince.toString());
        }else{
            provName = placeDAO.getCityName(sourceProvince.toString());
            patient.setSourceCity(sourceProvince);
            patient.setSourceProvince(1);
        }
        String residence =  provName + "/" + cityName;
        patient.setResidence(residence);
        patient.setResidence(residence);

        patientDAO.updateByExampleSelective(patient,patientExample);

        return CommonUtil.successJson();
    }

    /**
     * 在首页点击复诊时，有重复条件病人，获取病人列表
     * @param patient
     * @return
     */
    @Override
    public JSONObject getRevisitList(Patient patient,Integer pageSize,Integer pageNum){
        JSONObject data = new JSONObject();
        PageHelper.startPage(pageNum,pageSize);
        List<JSONObject> patientList = patientManualDAO.getRevisitList(patient);
        PageInfo<JSONObject> patientPageInfo = new PageInfo<>(patientList);

        data.put("pageInfo",patientPageInfo);
        return CommonUtil.successJson(data);
    }


    /**
     * 删除病人
     * @param patientId
     * @return
     */
    @Override
    public JSONObject deletePatient(Long patientId){
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientIdEqualTo(patientId);

        Patient patient = new Patient();
        patient.setDeleteFlag(1);

        patientDAO.updateByExampleSelective(patient,patientExample);
        return CommonUtil.successJson();
    }

    /**
     * 将选中的病人的病历保存到Word文档
     */
    @Override
    public void saveObjToWord(List<Long> inquiryIdList, boolean all,Long patientId, HttpServletResponse response){
            ArrayList<InquiryInfoVO> inquiryInfoVOArrayList = new ArrayList<InquiryInfoVO>();
            if(all){
                if(patientId!=null) {
                    inquiryIdList = dataStatisticsDAO.getAllId(patientId);
                }else{
                    inquiryIdList = dataStatisticsDAO.getAllId(null);
                }
            }
            for(int i = 0;i < inquiryIdList.size();i++){
                System.out.println(i);
                inquiryInfoVOArrayList.add(inquiryInfoVOArrayList.size(),inquiryService.getInquiryInfoVO(inquiryIdList.get(i)));
            }
            //todo:导入到word文档
            Long date = new Date().getTime();
            String filename = date+".doc";
            try {
                printToWord(filename,inquiryInfoVOArrayList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" +StringDate.getShortDate(new Date())+"patientList"+".doc");
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(filename)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            File file = new File(filename);
            if (file.exists()&&file.isFile()){
                file.delete();
            }
        }


    }
}
