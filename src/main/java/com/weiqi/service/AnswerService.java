package com.weiqi.service;

import java.util.List;

import com.weiqi.model.Answer;

public interface AnswerService {

	void insertByAnswer(Answer answer);
	
	List<Answer> findAll();
	
	void update(Answer answer);
	
	void delete(Integer id);
	
	Answer findById(Integer id);
}
