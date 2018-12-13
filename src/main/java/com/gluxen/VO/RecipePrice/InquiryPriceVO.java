package com.gluxen.VO.RecipePrice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gluxen.VO.MainRecipeVO;

import java.math.BigDecimal;
import java.util.List;

public class InquiryPriceVO {
    /**
     * 主方列表
     */
    private List<MainRecipePriceVO> mainReList;

    /**
     * 问诊Id
     */
    private Long inquiryId;

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
    private String amount;

    /**
     * 次数
     */
    private Long times;

    /**
     *该问诊的药方的总费用
     */
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<MainRecipePriceVO> getMainReList() {
        return mainReList;
    }

    public void setMainReList(List<MainRecipePriceVO> mainReList) {
        this.mainReList = mainReList;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResisdence() {
        return resisdence;
    }

    public void setResisdence(String resisdence) {
        this.resisdence = resisdence;
    }


    public String getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }
}
