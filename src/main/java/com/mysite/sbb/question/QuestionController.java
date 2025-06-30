package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// @RequestMapping을 이용하여 프리픽스(prefix 접두사) 지정
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

	// Controller 에 있는 Repository 기능을 모두 Service 에게 전달
	private final QuestionService questionService;

	// 질문 목록
	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionlist = this.questionService.getList();
		model.addAttribute("questionList", questionlist);
		return "question_list";
	}

	// 상세 조회
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question qd = this.questionService.getQuestion(id);
		model.addAttribute("question", qd);
		return "question_detail";
	}

	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}

	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		// TODO 질문 저장 (Service 처리)
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list"; // 질문 저장 후 질문 목록으로 이동
	}
}
