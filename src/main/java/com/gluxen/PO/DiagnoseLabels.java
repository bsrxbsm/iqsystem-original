package com.gluxen.PO;

import java.io.Serializable;

/**
 * diagnose_labels
 * @author 
 */
public class DiagnoseLabels implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 诊断标签
     */
    private String diagnoseLabels;

    /**
     * 问诊id
     */
    private Long inquiryId;

    /**
     * 病人id
     */
    private Long patientId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnoseLabels() {
        return diagnoseLabels;
    }

    public void setDiagnoseLabels(String diagnoseLabels) {
        this.diagnoseLabels = diagnoseLabels;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DiagnoseLabels other = (DiagnoseLabels) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDiagnoseLabels() == null ? other.getDiagnoseLabels() == null : this.getDiagnoseLabels().equals(other.getDiagnoseLabels()))
            && (this.getInquiryId() == null ? other.getInquiryId() == null : this.getInquiryId().equals(other.getInquiryId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDiagnoseLabels() == null) ? 0 : getDiagnoseLabels().hashCode());
        result = prime * result + ((getInquiryId() == null) ? 0 : getInquiryId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", diagnoseLabels=").append(diagnoseLabels);
        sb.append(", inquiryId=").append(inquiryId);
        sb.append(", patientId=").append(patientId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}