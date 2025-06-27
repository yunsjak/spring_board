package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	// DI(2개의 객체 주입)
	private final QuestionService questionservice;
	private final AnswerService answerService;

	@PostMapping("/create/{id}")
	public String create(Model model, @PathVariable("id") Integer id, @RequestParam(value = "content") String content) {
		Question question = this.questionservice.getQuestion(id);
		// todo: 답변 저장
		this.answerService.create(question, content);
		return String.format("redirect:/question/detail/%s", id);
	}
}