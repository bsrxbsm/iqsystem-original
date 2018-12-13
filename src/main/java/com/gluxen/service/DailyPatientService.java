package com.gluxen.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
public interface DailyPatientService {

    /**
     * 获取每日病人列表
     * @param pName
     * @param startDate
     * @param endDate
     * @param keyWords
     * @return
     */
    JSONObject getDailyPatientList(String pName,String startDate,String endDate,String keyWords,Integer pageNum,Integer pageSize,Long pId,String startAge,String endAge,String residence,String gender);


    /**
     * 获取当日需要填写问诊问题的病人
     * @param pageNum
     * @param pageSize
     * @return
     */
    JSONObject getQuestionPatientList(Integer pageNum,Integer pageSize);


    /**
     * 删除某个病人的某一条病历
     * @param inquiryId
     * @return
     */
    JSONObject deleteDailyPatient(Long inquiryId);
}
