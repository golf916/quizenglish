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
	public List<Question> getAllQuestion(){
		return questionDAO.getAllQuestion();
	}
	
	@Override
	public List<Question> findAll(){
		return questionDAO.listQuestion();
	}
	
	@Override
	public void update(Question question){
		questionDAO.updateByPrimaryKey(question);
	}
	
	@Override
	public void delete(Integer id){
		questionDAO.deleteByPrimaryKey(id);
	}
	
	@Override
	public Question findById(Integer id){
		return questionDAO.selectByPrimaryKey(id);
	}

	@Override
	public Question findQAById(Integer questionId) {
		return questionDAO.findQAById(questionId);
	}
	
}
