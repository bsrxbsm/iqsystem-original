package com.gluxen.dao;

import com.gluxen.PO.DailyPatient;
import com.gluxen.PO.DailyPatientExample;
import org.springframework.stereotype.Repository;

/**
 * DailyPatientDAO继承基类
 */
@Repository
public interface DailyPatientDAO extends MyBatisBaseDao<DailyPatient, Long, DailyPatientExample> {
}