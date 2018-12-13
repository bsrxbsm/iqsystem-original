package com.gluxen.PO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * medicine
 * @author 
 */
public class Medicine implements Serializable {
    /**
     * 药的id
     */
    private Integer id;

    /**
     * 药名
     */
    private String medicineName;

    /**
     * 药品单价
     */
    private Double medicinePrice;

    /**
     * 药品库存
     */
    private Integer medicineStock;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public Integer getMedicineStock() {
        return medicineStock;
    }

    public void setMedicineStock(Integer medicineStock) {
        this.medicineStock = medicineStock;
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
        Medicine other = (Medicine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMedicineName() == null ? other.getMedicineName() == null : this.getMedicineName().equals(other.getMedicineName()))
            && (this.getMedicinePrice() == null ? other.getMedicinePrice() == null : this.getMedicinePrice().equals(other.getMedicinePrice()))
            && (this.getMedicineStock() == null ? other.getMedicineStock() == null : this.getMedicineStock().equals(other.getMedicineStock()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMedicineName() == null) ? 0 : getMedicineName().hashCode());
        result = prime * result + ((getMedicinePrice() == null) ? 0 : getMedicinePrice().hashCode());
        result = prime * result + ((getMedicineStock() == null) ? 0 : getMedicineStock().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicineName=").append(medicineName);
        sb.append(", medicinePrice=").append(medicinePrice);
        sb.append(", medicineStock=").append(medicineStock);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}