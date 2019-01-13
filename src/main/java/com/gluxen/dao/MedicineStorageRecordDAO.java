package com.gluxen.dao;

import com.gluxen.PO.MedicineStorageRecord;
import com.gluxen.PO.MedicineStorageRecordExample;
import org.springframework.stereotype.Repository;

/**
 * MedicineStorageRecordDAO继承基类
 */
@Repository
public interface MedicineStorageRecordDAO extends MyBatisBaseDao<MedicineStorageRecord, Integer, MedicineStorageRecordExample> {
}