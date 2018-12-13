package com.gluxen.dao;

import com.gluxen.PO.DiagnoseLabels;
import com.gluxen.PO.DiagnoseLabelsExample;
import org.springframework.stereotype.Repository;

/**
 * DiagnoseLabelsDAO继承基类
 */
@Repository
public interface DiagnoseLabelsDAO extends MyBatisBaseDao<DiagnoseLabels, Long, DiagnoseLabelsExample> {
}