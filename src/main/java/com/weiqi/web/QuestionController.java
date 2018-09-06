package com.weiqi.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weiqi.model.Question;
import com.weiqi.service.QuestionService;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
	
	private static final String QUESTION_FORM_PATH_NAME = "questionForm";
    private static final String QUESTION_LIST_PATH_NAME = "questionList";
    private static final String REDIRECT_TO_QUESTION_URL = "redirect:/question";

    @Autowired
    private QuestionService questionService;
    
	 @RequestMapping(method = RequestMethod.GET)
	    public String getQuestionList(ModelMap map) {
	        map.addAttribute("questionList",questionService.findAll());
	        return QUESTION_LIST_PATH_NAME;
	    }
	 
	    @RequestMapping(value = "/create", method = RequestMethod.GET)
	    public String createQuestionForm(ModelMap map) {
	        map.addAttribute("question", new Question());
	        map.addAttribute("action", "create");
	        return QUESTION_FORM_PATH_NAME;
	    }
	    
	    @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public String postBook(@ModelAttribute Question question) {
	    	question.setCreatetime(new Date());
	        questionService.insertByQuestion(question);
	        return REDIRECT_TO_QUESTION_URL;
	    }
	    
}
