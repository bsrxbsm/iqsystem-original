package com.gluxen.dao;

import com.gluxen.PO.Patient;
import com.gluxen.PO.PatientExample;
import org.springframework.stereotype.Repository;

/**
 * PatientDAO继承基类
 */
@Repository
public interface PatientDAO extends MyBatisBaseDao<Patient, Long, PatientExample> {
}