package com.gluxen.PO;

import java.io.Serializable;
import java.util.Date;

/**
 * daily_patient
 * @author 
 */
public class DailyPatient implements Serializable {
    /**
     * 问诊Id
     */
    private Long inquiryId;

    /**
     * 病人Id
     */
    private Long patientId;

    /**
     * 报到日期
     */
    private Date iqDate;

    /**
     * 诊号类别
     */
    private String type;

    /**
     * 病情描述
     */
    private String description;

    /**
     * 诊断标签
     */
    private String diagnoseLabel;

    /**
     * 次数
     */
    private Long times;

    /**
     * 药方付数
     */
    private String amount;

    /**
     * 是否填写问诊问题
     */
    private Integer questionFlag;

    /**
     * 年龄
     */
    private String countAge;

    /**
     * 岁
     */
    private Integer year;

    /**
     * 月
     */
    private Integer month;

    /**
     * 天
     */
    private Integer day;

    private static final long serialVersionUID = 1L;

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

    public Date getIqDate() {
        return iqDate;
    }

    public void setIqDate(Date iqDate) {
        this.iqDate = iqDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getQuestionFlag() {
        return questionFlag;
    }

    public void setQuestionFlag(Integer questionFlag) {
        this.questionFlag = questionFlag;
    }

    public String getCountAge() {
        return countAge;
    }

    public void setCountAge(String countAge) {
        this.countAge = countAge;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
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
        DailyPatient other = (DailyPatient) that;
        return (this.getInquiryId() == null ? other.getInquiryId() == null : this.getInquiryId().equals(other.getInquiryId()))
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getIqDate() == null ? other.getIqDate() == null : this.getIqDate().equals(other.getIqDate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDiagnoseLabel() == null ? other.getDiagnoseLabel() == null : this.getDiagnoseLabel().equals(other.getDiagnoseLabel()))
            && (this.getTimes() == null ? other.getTimes() == null : this.getTimes().equals(other.getTimes()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getQuestionFlag() == null ? other.getQuestionFlag() == null : this.getQuestionFlag().equals(other.getQuestionFlag()))
            && (this.getCountAge() == null ? other.getCountAge() == null : this.getCountAge().equals(other.getCountAge()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInquiryId() == null) ? 0 : getInquiryId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getIqDate() == null) ? 0 : getIqDate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDiagnoseLabel() == null) ? 0 : getDiagnoseLabel().hashCode());
        result = prime * result + ((getTimes() == null) ? 0 : getTimes().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getQuestionFlag() == null) ? 0 : getQuestionFlag().hashCode());
        result = prime * result + ((getCountAge() == null) ? 0 : getCountAge().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", inquiryId=").append(inquiryId);
        sb.append(", patientId=").append(patientId);
        sb.append(", iqDate=").append(iqDate);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append(", diagnoseLabel=").append(diagnoseLabel);
        sb.append(", times=").append(times);
        sb.append(", amount=").append(amount);
        sb.append(", questionFlag=").append(questionFlag);
        sb.append(", countAge=").append(countAge);
        sb.append(", year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", day=").append(day);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}