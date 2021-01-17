package com.helper.test.testquiz.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.helper.test.testquiz.dto.TestQuizDTO;

@Repository
public interface TestQuizDAO {
	
	@Insert("insert into test_quiz(name, quiz, answer, test_type) values(#{name},#{quiz},#{answer},#{test_type})")
	public void insertQuizContent(TestQuizDTO dto);
}
