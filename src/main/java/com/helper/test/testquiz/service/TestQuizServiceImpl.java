package com.helper.test.testquiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helper.test.testquiz.dao.TestQuizDAO;
import com.helper.test.testquiz.dto.TestQuizDTO;

@Service
public class TestQuizServiceImpl implements TestQuizService{
	@Autowired
	TestQuizDAO dao;
	
	public void insertQuizContent(TestQuizDTO dto) {
		dao.insertQuizContent(dto);
	}
}
