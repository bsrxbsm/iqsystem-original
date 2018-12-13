package com.gluxen.dao;

import com.gluxen.PO.Question;
import com.gluxen.PO.QuestionExample;
import org.springframework.stereotype.Repository;

/**
 * QuestionDAO继承基类
 */
@Repository
public interface QuestionDAO extends MyBatisBaseDao<Question, Long, QuestionExample> {
}