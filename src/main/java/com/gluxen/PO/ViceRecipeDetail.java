package com.gluxen.PO;

import java.io.Serializable;

/**
 * vice_recipe_detail
 * @author 
 */
public class ViceRecipeDetail implements Serializable {
    /**
     * 明细ID
     */
    private Long detailId;

    /**
     * 药方ID
     */
    private Long viceRecipeId;

    /**
     * 药品名称
     */
    private String medicine;

    /**
     * 药品剂量
     */
    private Integer dose;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getViceRecipeId() {
        return viceRecipeId;
    }

    public void setViceRecipeId(Long viceRecipeId) {
        this.viceRecipeId = viceRecipeId;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        ViceRecipeDetail other = (ViceRecipeDetail) that;
        return (this.getDetailId() == null ? other.getDetailId() == null : this.getDetailId().equals(other.getDetailId()))
            && (this.getViceRecipeId() == null ? other.getViceRecipeId() == null : this.getViceRecipeId().equals(other.getViceRecipeId()))
            && (this.getMedicine() == null ? other.getMedicine() == null : this.getMedicine().equals(other.getMedicine()))
            && (this.getDose() == null ? other.getDose() == null : this.getDose().equals(other.getDose()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDetailId() == null) ? 0 : getDetailId().hashCode());
        result = prime * result + ((getViceRecipeId() == null) ? 0 : getViceRecipeId().hashCode());
        result = prime * result + ((getMedicine() == null) ? 0 : getMedicine().hashCode());
        result = prime * result + ((getDose() == null) ? 0 : getDose().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailId=").append(detailId);
        sb.append(", viceRecipeId=").append(viceRecipeId);
        sb.append(", medicine=").append(medicine);
        sb.append(", dose=").append(dose);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}