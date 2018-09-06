package com.weiqi.mapper;

import com.weiqi.model.Answer;
import org.springframework.stereotype.Repository;

/**
 * AnswerDAO继承基类
 */
@Repository
public interface AnswerDAO extends MyBatisBaseDao<Answer, Integer> {
}