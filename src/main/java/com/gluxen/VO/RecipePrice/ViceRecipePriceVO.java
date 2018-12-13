package com.gluxen.VO.RecipePrice;

import java.util.List;

public class ViceRecipePriceVO {
    /**
     * 付数
     */
    private Integer amount;
    /**
     * 药方细节对象列表
     */
    private List<MedicinePriceVO> medicineList;

    /**
     * 单付总价
     */
    private Double unitPrice;
    /**
     * 该副方的总价=单付总价x付数
     */
    private  Double totalPrice;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<MedicinePriceVO> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<MedicinePriceVO> medicineList) {
        this.medicineList = medicineList;
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
