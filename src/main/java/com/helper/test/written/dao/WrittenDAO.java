package com.helper.test.written.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.helper.test.written.dto.WrittenTestDTO;

@Repository
public interface WrittenDAO {
	
	@Insert("insert into written_test(test_name) values(#{test_name})")
	public void insertWrittenName(WrittenTestDTO dto);
	
	@Select("select test_name from written_test")
	public ArrayList<WrittenTestDTO> getWrittenNameList();
}
