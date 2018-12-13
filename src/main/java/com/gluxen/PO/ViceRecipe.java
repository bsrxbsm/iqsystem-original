package com.gluxen.PO;

import java.io.Serializable;

/**
 * vice_recipe
 * @author 
 */
public class ViceRecipe implements Serializable {
    /**
     * 副方ID
     */
    private Long viceRecipeId;

    /**
     * 主方ID
     */
    private Long recipeId;

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

    public Long getViceRecipeId() {
        return viceRecipeId;
    }

    public void setViceRecipeId(Long viceRecipeId) {
        this.viceRecipeId = viceRecipeId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
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
        ViceRecipe other = (ViceRecipe) that;
        return (this.getViceRecipeId() == null ? other.getViceRecipeId() == null : this.getViceRecipeId().equals(other.getViceRecipeId()))
            && (this.getRecipeId() == null ? other.getRecipeId() == null : this.getRecipeId().equals(other.getRecipeId()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getIsStock() == null ? other.getIsStock() == null : this.getIsStock().equals(other.getIsStock()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getViceRecipeId() == null) ? 0 : getViceRecipeId().hashCode());
        result = prime * result + ((getRecipeId() == null) ? 0 : getRecipeId().hashCode());
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
        sb.append(", viceRecipeId=").append(viceRecipeId);
        sb.append(", recipeId=").append(recipeId);
        sb.append(", remarks=").append(remarks);
        sb.append(", amount=").append(amount);
        sb.append(", isStock=").append(isStock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}