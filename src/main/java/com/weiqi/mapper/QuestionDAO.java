package com.weiqi.mapper;

import com.weiqi.model.Question;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * QuestionDAO继承基类
 */
@Repository
public interface QuestionDAO extends MyBatisBaseDao<Question, Integer> {
	
	List<Question> listQuestion();
	
}