package com.weiqi.mapper;

import com.weiqi.model.Quiz;
import org.springframework.stereotype.Repository;

/**
 * QuizDAO继承基类
 */
@Repository
public interface QuizDAO extends MyBatisBaseDao<Quiz, Integer> {
}