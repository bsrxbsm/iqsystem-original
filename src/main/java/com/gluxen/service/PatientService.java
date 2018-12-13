package com.gluxen.service;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.Patient;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/5.
 */
public interface PatientService {

    /**
     * 新增病人获取ID
     *
     * @return
     */
    Long getNewPid(Patient patient);

    /**
     * 新增病人
     *
     * @param patient
     * @return
     */
    JSONObject newPatient(Patient patient);


    /**
     * 复诊输入病人条件查询
     *
     * @param patient
     * @return
     */
    JSONObject revisit(Patient patient);


    /**
     * 获取地址列表
     * @return
     */
    JSONObject getPlace();


    /**
     * 获取病人列表
     * @return
     */
    JSONObject getPatientList(String pName,Integer pageSize,Integer pageNum);


    /**
     * 获取病人基本信息
     * @param pId
     * @return
     */
    JSONObject getPatientInfo(Long pId);

    /**
     * 更新病人基本信息
     * @param patient
     * @return
     */
    JSONObject updatePatientInfo(Patient patient);


    /**
     * 复诊时，有重复条件者获取病人列表
     */
    JSONObject getRevisitList(Patient patient,Integer pageSize,Integer pageNum);


    /**
     * 删除病人
     * @param patientId
     * @return
     */
    JSONObject deletePatient(Long patientId);

    /**
     * 将选中的病人的病历保存到Word文档
     */
    void saveObjToWord(List<Long> inquiryIdList, boolean all,Long patientId, HttpServletResponse response);
}
