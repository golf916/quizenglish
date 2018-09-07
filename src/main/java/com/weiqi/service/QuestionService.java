package com.weiqi.service;

import java.util.List;

import com.weiqi.model.Question;

public interface QuestionService {

	void insertByQuestion(Question question);
	
	List<Question> getAllQuestion();
	
	List<Question> findAll();
	
	void update(Question question);
	
	void delete(Integer id);
	
	Question findById(Integer id);

	Question findQAById(Integer questionId);
}
