package com.gluxen.dao;

import com.gluxen.PO.ViceRecipe;
import com.gluxen.PO.ViceRecipeExample;
import org.springframework.stereotype.Repository;

/**
 * ViceRecipeDAO继承基类
 */
@Repository
public interface ViceRecipeDAO extends MyBatisBaseDao<ViceRecipe, Long, ViceRecipeExample> {
}