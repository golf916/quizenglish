package com.weiqi.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weiqi.model.Question;
import com.weiqi.service.QuestionService;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {

	private static final String QUESTION_VIEW_PATH_NAME = "questionView";
	private static final String QUESTION_FORM_PATH_NAME = "questionForm";
	private static final String QUESTION_LIST_PATH_NAME = "questionList";
	private static final String REDIRECT_TO_QUESTION_URL = "redirect:/question";

	@Autowired
	private QuestionService questionService;

	@RequestMapping(method = RequestMethod.GET)
	public String getQuestionList(ModelMap map) {
		List<Question> questionList = questionService.getAllQuestion();
		map.addAttribute("questionList", questionService.getAllQuestion());
		return QUESTION_LIST_PATH_NAME;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createQuestionForm(ModelMap map) {
		map.addAttribute("question", new Question());
//		map.addAttribute("action", "create");
		return QUESTION_FORM_PATH_NAME;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postQuestion(@ModelAttribute Question question) {
		question.setCreatetime(new Date());
		if (question.getId() != null) {
			questionService.update(question);
		} else {
			questionService.insertByQuestion(question);
		}
		return REDIRECT_TO_QUESTION_URL;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewQuestion(@PathVariable Integer id, ModelMap map) {
		Question question = questionService.findQAById(id);
		map.addAttribute("question", question);
		return QUESTION_VIEW_PATH_NAME;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateQuestion(@PathVariable Integer id, ModelMap map) {
		map.addAttribute("question", questionService.findById(id));
		map.addAttribute("action", "update");
		return QUESTION_FORM_PATH_NAME;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String putQuestion(@ModelAttribute Question question) {
		questionService.update(question);
		return REDIRECT_TO_QUESTION_URL;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuestion(@PathVariable Integer id) {
		questionService.delete(id);
		return REDIRECT_TO_QUESTION_URL;
	}

}
