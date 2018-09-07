package com.weiqi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weiqi.mapper.AnswerDAO;
import com.weiqi.model.Answer;
import com.weiqi.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerDAO answerDAO;
	
	public void insertByAnswer(Answer answer) {
		answerDAO.insert(answer);
	}
	
	@Override
	public List<Answer> findAll(){
		return answerDAO.listAnswer();
	}
	
	@Override
	public void update(Answer answer){
		answerDAO.updateByPrimaryKey(answer);
	}
	
	@Override
	public void delete(Integer id){
		answerDAO.deleteByPrimaryKey(id);
	}
	
	@Override
	public Answer findById(Integer id){
		return answerDAO.selectByPrimaryKey(id);
	}
	
}
