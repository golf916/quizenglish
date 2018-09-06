package com.weiqi.service;

import java.util.List;

import com.weiqi.model.Question;

public interface QuestionService {

	void insertByQuestion(Question question);
	
	List<Question> findAll();
//	
//	User update(User user);
//	
//	User delete(Long id);
//	
//	User findById(Long id);
}
