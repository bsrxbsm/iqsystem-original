package com.gluxen.VO.RecipePrice;

import com.gluxen.PO.Medicine;
import com.gluxen.PO.RecipeDetail;
import com.gluxen.VO.ViceRecipeVO;

import java.math.BigDecimal;
import java.util.List;

public class MainRecipePriceVO {
    /**
     * 付数
     */
    private Integer amount;
    /**
     * 药方细节对象列表
     */
    private List<MedicinePriceVO> medicineList;

    /**
     * 副方列表
     */
    private List<ViceRecipePriceVO> viceReList;
    /**
     * 单付总价
     */
    private Double unitPrice;
    /**
     * 该主方的总价（不包含主方所含的副方）
     */
    private  Double totalPrice;

    /**
     * 总价（包含主方所含的副方）
     * @return
     */
    private Double totalPriceIncludeVice;

    public Double getTotalPriceIncludeVice() {
        return totalPriceIncludeVice;
    }

    public void setTotalPriceIncludeVice(Double totalPriceIncludeVice) {
        this.totalPriceIncludeVice = totalPriceIncludeVice;
    }

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

    public List<ViceRecipePriceVO> getViceReList() {
        return viceReList;
    }

    public void setViceReList(List<ViceRecipePriceVO> viceReList) {
        this.viceReList = viceReList;
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
