package com.gluxen.VO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MedicineStorageRecordVO {
    /**
     * 入库的药品名称
     */
    private Integer medicineId;
    /**
     * 入库的数量
     */
    private int stock;
    /**
     * 入库的日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String date;
    /**
     * 药品的供应商
     */
    private String supplier;


    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int amount) {
        this.stock = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
