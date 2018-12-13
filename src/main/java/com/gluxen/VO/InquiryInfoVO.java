package com.gluxen.VO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
public class InquiryInfoVO {
    /**
     * 主方列表
     */
    private List<MainRecipeVO> mainReList;

    /**
     * 问诊Id
     */
    private Long inquiryId;


    /**
     * 病情描述
     */
    private String description;

    /**
     * 诊断标签
     */
    private String diagnoseLabel;

    /**
     * 病人姓名
     */
    private String pName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 来源地
     */
    private String resisdence;

    /**
     * 问诊日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String date;

    /**
     * more accurate time
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String inquiryDate;

    /**
     * 年龄
     */
    private String age;

    /**
     * 药方附数
     */
    private Integer amount;

    /**
     * 次数
     */
    private Long times;

    public String getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }


    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public List<MainRecipeVO> getMainReList() {
        return mainReList;
    }

    public void setMainReList(List<MainRecipeVO> mainReList) {
        this.mainReList = mainReList;
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

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getResisdence() {
        return resisdence;
    }

    public void setResisdence(String resisdence) {
        this.resisdence = resisdence;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
