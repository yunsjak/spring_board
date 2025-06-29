package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DateNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;

	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	public Question getQuestion(Integer id) {
		Optional<Question> qo = this.questionRepository.findById(id);
		if (qo.isPresent()) {
			return qo.get();
		} else {
			throw new DateNotFoundException("question not found");
		}
	}
}
