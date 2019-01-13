package com.gluxen.PO;

import java.io.Serializable;
import java.util.Date;

/**
 * medicine_storage_record
 * @author 
 */
public class MedicineStorageRecord implements Serializable {
    /**
     * 药品入库记录id
     */
    private Integer id;

    /**
     * 药品的入库数量（g）
     */
    private Integer stock;

    /**
     * 药品的入库时间
     */
    private Date date;

    /**
     * 药品的id
     */
    private Integer medicineId;

    /**
     * 药品的供货厂家
     */
    private String supplier;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
        MedicineStorageRecord other = (MedicineStorageRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getMedicineId() == null ? other.getMedicineId() == null : this.getMedicineId().equals(other.getMedicineId()))
            && (this.getSupplier() == null ? other.getSupplier() == null : this.getSupplier().equals(other.getSupplier()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getMedicineId() == null) ? 0 : getMedicineId().hashCode());
        result = prime * result + ((getSupplier() == null) ? 0 : getSupplier().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stock=").append(stock);
        sb.append(", date=").append(date);
        sb.append(", medicineId=").append(medicineId);
        sb.append(", supplier=").append(supplier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}