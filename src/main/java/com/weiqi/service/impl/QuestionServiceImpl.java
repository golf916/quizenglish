package com.weiqi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weiqi.mapper.QuestionDAO;
import com.weiqi.model.Question;
import com.weiqi.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDAO questionDAO;
	
	public void insertByQuestion(Question question) {
		questionDAO.insert(question);
	}
	
	@Override
	public List<Question> findAll(){
		return questionDAO.listQuestion();
	}
//	
//	@Override
//	public User update(User user){
//		
//	}
//	
//	@Override
//	public User delete(Long id){
//		
//	}
//	
//	@Override
//	public User findById(Long id){
//		return userDAO.selectByPrimaryKey(id);
//	}
	
}
