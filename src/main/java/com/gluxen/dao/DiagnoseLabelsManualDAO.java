package com.gluxen.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/27.
 */
public interface DiagnoseLabelsManualDAO {
    /**
     * 获取所有病人的诊断标签
     * @return
     */
    List<String> getDiagnoseLabels();

    /**
     * 获取某个病人所有的诊断标签
     * @return
     */
    List<String> getOnePatientLabels(@Param(value="patientId") Long patientId);

    /**
     * 获某次问诊的诊断标签
     * @return
     */
    List<String> getInquiryLabels(@Param(value="inquiryId") Long inquiryId);

}
