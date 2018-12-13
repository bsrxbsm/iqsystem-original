package com.gluxen.dao;

import com.gluxen.PO.RecipeDetail;
import com.gluxen.PO.RecipeDetailExample;
import org.springframework.stereotype.Repository;

/**
 * RecipeDetailDAO继承基类
 */
@Repository
public interface RecipeDetailDAO extends MyBatisBaseDao<RecipeDetail, Long, RecipeDetailExample> {
}