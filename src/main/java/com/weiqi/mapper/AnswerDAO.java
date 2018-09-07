package com.weiqi.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.weiqi.model.Answer;

/**
 * AnswerDAO继承基类
 */
@Repository
public interface AnswerDAO extends MyBatisBaseDao<Answer, Integer> {
	
	List<Answer> listAnswer();
	
}