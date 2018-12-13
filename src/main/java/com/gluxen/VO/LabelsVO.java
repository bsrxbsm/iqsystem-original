package com.gluxen.VO;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/27.
 */
public class LabelsVO {
    private List<String> diagnoseLabels;

    private Long patientId;

    private Long inquiryId;

    public List<String> getDiagnoseLabels() {
        return diagnoseLabels;
    }

    public void setDiagnoseLabels(List<String> diagnoseLabels) {
        this.diagnoseLabels = diagnoseLabels;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }
}
