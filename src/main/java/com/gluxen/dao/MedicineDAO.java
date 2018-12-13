package com.gluxen.dao;

import com.gluxen.PO.Medicine;
import com.gluxen.PO.MedicineExample;
import org.springframework.stereotype.Repository;

/**
 * MedicineDAO继承基类
 */
@Repository
public interface MedicineDAO extends MyBatisBaseDao<Medicine, Integer, MedicineExample> {
}