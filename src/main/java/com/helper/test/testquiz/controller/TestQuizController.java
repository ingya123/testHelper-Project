package com.helper.test.testquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.test.testquiz.dto.TestQuizDTO;
import com.helper.test.testquiz.service.TestQuizService;

@Controller
public class TestQuizController {
	@Autowired
	TestQuizService service;
	
	@RequestMapping("insertQuiz")
	public String insertQuiz() {
		return "quiz/insertQuiz";
	}
	
	@RequestMapping(value="insertQuizContent",
					produces = "application/json;charset=utf-8")
	public void insertQuizContent(TestQuizDTO dto) {
		service.insertQuizContent(dto);
	}
}
