package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
//		System.out.println("index");
		return "sbb 프로젝트 시작해보자!"; // "index" --> 템플릿 파일
	}

	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
