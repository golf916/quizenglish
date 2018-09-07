package com.weiqi.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weiqi.model.Answer;
import com.weiqi.model.Question;
import com.weiqi.service.AnswerService;
import com.weiqi.service.QuestionService;

@Controller
@RequestMapping(value = "/answer")
public class AnswerController {

	private static final String ANSWER_FORM_PATH_NAME = "answerForm";
	private static final String ANSWER_LIST_PATH_NAME = "answerList";
	private static final String REDIRECT_TO_ANSWER_URL = "redirect:/answer";

	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAnswerList(ModelMap map) {
		map.addAttribute("answerList", answerService.findAll());
		return ANSWER_LIST_PATH_NAME;
	}

	@RequestMapping(value = "/qa/{questionId}", method = RequestMethod.GET)
	public String viewQuestionAnswer(@PathVariable Integer questionId, ModelMap map) {
//		map.addAttribute("answer", new Answer());
//		map.addAttribute("action", "create");
		Question question = questionService.findQAById(questionId);
		map.addAttribute("question", question);
		return ANSWER_FORM_PATH_NAME;
	}
	
	@RequestMapping(value = "/create/{questionId}", method = RequestMethod.GET)
	public String createAnswerForm(@PathVariable Integer questionId, ModelMap map) {
		map.addAttribute("answer", new Answer());
		map.addAttribute("action", "create");
		Question question = questionService.findById(questionId);
		map.addAttribute("question", question);
		return ANSWER_FORM_PATH_NAME;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postAnswer(@ModelAttribute Answer answer) {
		answer.setCreatetime(new Date());
		if (answer.getId() != null) {
			answerService.update(answer);
		} else {
			answerService.insertByAnswer(answer);
		}
		return REDIRECT_TO_ANSWER_URL;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable Integer id, ModelMap map) {
		map.addAttribute("answer", answerService.findById(id));
		map.addAttribute("action", "update");
		return ANSWER_FORM_PATH_NAME;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String putAnswer(@ModelAttribute Answer answer) {
		answerService.update(answer);
		return REDIRECT_TO_ANSWER_URL;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteAnswer(@PathVariable Integer id) {
		answerService.delete(id);
		return REDIRECT_TO_ANSWER_URL;
	}

}
