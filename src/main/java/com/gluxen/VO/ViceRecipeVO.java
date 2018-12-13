package com.gluxen.VO;

import com.gluxen.PO.ViceRecipeDetail;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
public class ViceRecipeVO {
    /**
     * 付数
     */
    private Integer amount;

    /**
     * 是否入库
     */
    private Boolean isStock;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 药方细节列表
     */
    private List<String> viceMeList;

    /**
     * 副方细节对象列表
     */
    private List<ViceRecipeDetail> viceRecipeDetailList;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getIsStock() {
        return isStock;
    }

    public void setIsStock(Boolean isStock) {
        this.isStock = isStock;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<String> getViceMeList() {
        return viceMeList;
    }

    public void setViceMeList(List<String> medecine) {
        this.viceMeList = medecine;
    }

    public List<ViceRecipeDetail> getViceRecipeDetailList() {
        return viceRecipeDetailList;
    }

    public void setViceRecipeDetailList(List<ViceRecipeDetail> viceRecipeDetailList) {
        this.viceRecipeDetailList = viceRecipeDetailList;
    }
}
