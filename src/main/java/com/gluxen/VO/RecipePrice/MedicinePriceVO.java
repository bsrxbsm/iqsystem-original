package com.gluxen.VO.RecipePrice;

import com.gluxen.PO.Medicine;

import java.math.BigDecimal;

public class MedicinePriceVO {
    /**
     * 该药品的名称
     */
    private String medicine;
    /**
     * 药方中药品的数量/g
     */
    private int does;
    /**
     * 该药品的单价
     */
    private Double unitPrice;
    /**
     * 单价x数量=总价
     */
    private Double totalPrice;

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getDoes() {
        return does;
    }

    public void setDoes(int does) {
        this.does = does;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
