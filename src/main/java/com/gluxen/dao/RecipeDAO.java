package com.gluxen.dao;

import com.gluxen.PO.Recipe;
import com.gluxen.PO.RecipeExample;
import org.springframework.stereotype.Repository;

/**
 * RecipeDAO继承基类
 */
@Repository
public interface RecipeDAO extends MyBatisBaseDao<Recipe, Long, RecipeExample> {
}