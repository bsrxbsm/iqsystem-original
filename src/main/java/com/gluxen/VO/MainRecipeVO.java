package com.gluxen.VO;

import com.gluxen.PO.RecipeDetail;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2018/8/7.
 */
public class MainRecipeVO {
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
    private List<String> mainMeList;


    /**
     * 药方细节对象列表
     */
    private List<RecipeDetail> recipeDetailList;

    /**
     * 副方列表
     */
    private List<ViceRecipeVO> viceReList;


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

    public List<String> getMainMeList() {
        return mainMeList;
    }

    public void setMainMeList(List<String> medecine) {
        this.mainMeList = medecine;
    }

    public List<ViceRecipeVO> getViceReList() {
        return viceReList;
    }

    public void setViceReList(List<ViceRecipeVO> viceReList) {
        this.viceReList = viceReList;
    }

    public List<RecipeDetail> getRecipeDetailList() {
        return recipeDetailList;
    }

    public void setRecipeDetailList(List<RecipeDetail> recipeDetailList) {
        this.recipeDetailList = recipeDetailList;
    }
}
