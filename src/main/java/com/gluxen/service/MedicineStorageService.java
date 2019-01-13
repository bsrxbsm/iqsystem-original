package com.gluxen.service;

import com.alibaba.fastjson.JSONObject;
import com.gluxen.PO.MedicineStorageRecord;
import com.gluxen.VO.MedicineStorageRecordVO;

import java.util.List;

public interface MedicineStorageService {
    /**
     * 多个药品入库记录
     * @param medicineStorageRecordS
     */
    JSONObject postMedicineStorageRecord(List<MedicineStorageRecord> medicineStorageRecordS);

    /**
     * 获取多个药品的库存数量
     */
    JSONObject getMedicineStock(String medicines);

    /**
     * 查询入库的记录
     */
    JSONObject getMedicineStorageRecords(String medicineName,String startDate,String endDate);
}
