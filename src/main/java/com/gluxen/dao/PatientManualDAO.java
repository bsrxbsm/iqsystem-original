package com.gluxen.dao;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
public interface PatientManualDAO {
    /**
     * 获取病人列表
     * @param pName
     * @return
     */
    List<JSONObject> getPatientList(@Param(value="pName") String pName);


    /**
     * 有重复条件时，获取复诊病人列表
     * @param patient
     * @return
     */
    List<JSONObject> getRevisitList(Patient patient);
}
