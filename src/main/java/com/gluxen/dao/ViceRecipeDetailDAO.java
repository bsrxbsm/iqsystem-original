package com.gluxen.dao;

import com.gluxen.PO.ViceRecipeDetail;
import com.gluxen.PO.ViceRecipeDetailExample;
import org.springframework.stereotype.Repository;

/**
 * ViceRecipeDetailDAO继承基类
 */
@Repository
public interface ViceRecipeDetailDAO extends MyBatisBaseDao<ViceRecipeDetail, Long, ViceRecipeDetailExample> {
}