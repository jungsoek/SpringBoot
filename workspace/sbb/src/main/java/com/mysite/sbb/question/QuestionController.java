package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;
	
	@GetMapping("/question/list")
	@ResponseBody
	public String list(Model model) {

		List<Question> questionList = this.questionService.getList();

		model.addAttribute("questionList", questionList);

		System.out.println("questionList : " + questionList);

		return "question_list";
	}

	@GetMapping(value = "/question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		Question question = this.questionService.getQuestion(id);
		System.out.println("question : " + question);
		return "question_detail";
	}
	
	
}
