package com.gluxen.PO;

import java.io.Serializable;

/**
 * recipe
 * @author 
 */
public class Recipe implements Serializable {
    /**
     * 药方ID
     */
    private Long recipeId;

    /**
     * 问诊Id
     */
    private Long inquiryId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 付数
     */
    private Integer amount;

    /**
     * 是否入库
     */
    private Integer isStock;

    private static final long serialVersionUID = 1L;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getIsStock() {
        return isStock;
    }

    public void setIsStock(Integer isStock) {
        this.isStock = isStock;
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
        Recipe other = (Recipe) that;
        return (this.getRecipeId() == null ? other.getRecipeId() == null : this.getRecipeId().equals(other.getRecipeId()))
            && (this.getInquiryId() == null ? other.getInquiryId() == null : this.getInquiryId().equals(other.getInquiryId()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getIsStock() == null ? other.getIsStock() == null : this.getIsStock().equals(other.getIsStock()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecipeId() == null) ? 0 : getRecipeId().hashCode());
        result = prime * result + ((getInquiryId() == null) ? 0 : getInquiryId().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getIsStock() == null) ? 0 : getIsStock().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recipeId=").append(recipeId);
        sb.append(", inquiryId=").append(inquiryId);
        sb.append(", remarks=").append(remarks);
        sb.append(", amount=").append(amount);
        sb.append(", isStock=").append(isStock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}