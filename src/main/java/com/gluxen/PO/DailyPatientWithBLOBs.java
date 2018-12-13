package com.gluxen.PO;

import java.io.Serializable;

/**
 * daily_patient
 * @author 
 */
public class DailyPatientWithBLOBs extends DailyPatient implements Serializable {
    /**
     * 病情描述
     */
    private String description;

    /**
     * 诊断标签
     */
    private String diagnoseLabel;

    private static final long serialVersionUID = 1L;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnoseLabel() {
        return diagnoseLabel;
    }

    public void setDiagnoseLabel(String diagnoseLabel) {
        this.diagnoseLabel = diagnoseLabel;
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
        DailyPatientWithBLOBs other = (DailyPatientWithBLOBs) that;
        return (this.getInquiryId() == null ? other.getInquiryId() == null : this.getInquiryId().equals(other.getInquiryId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getIqDate() == null ? other.getIqDate() == null : this.getIqDate().equals(other.getIqDate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDiagnoseLabel() == null ? other.getDiagnoseLabel() == null : this.getDiagnoseLabel().equals(other.getDiagnoseLabel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInquiryId() == null) ? 0 : getInquiryId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getIqDate() == null) ? 0 : getIqDate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDiagnoseLabel() == null) ? 0 : getDiagnoseLabel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", description=").append(description);
        sb.append(", diagnoseLabel=").append(diagnoseLabel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}