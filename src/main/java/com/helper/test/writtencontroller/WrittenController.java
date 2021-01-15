package com.helper.test.writtencontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helper.test.written.dto.WrittenTestDTO;
import com.helper.test.written.service.WrittenService;

@Controller
public class WrittenController {
	
	@Autowired
	WrittenService service;
	
	@RequestMapping("insertWrittenQuiz")
	public String insertWrittenQuiz() {
		
		return "written/insertWrittenQuiz";
	}
	
	@RequestMapping(value = "insertWrittenName",
			produces = "application/json;charset=utf-8")
	@ResponseBody
	public String insertWrittenName(WrittenTestDTO dto) throws Exception {
		
		if(dto.getTest_name()==null) {
			ObjectMapper mapper = new ObjectMapper();
			String nameList = mapper.writeValueAsString(getWrittenNameList());
			
			return nameList;
		}
		service.insertWrittenName(dto);
		ObjectMapper mapper = new ObjectMapper();
		String nameList = mapper.writeValueAsString(getWrittenNameList());
		
		return nameList;
	}
	
	
	public ArrayList<WrittenTestDTO> getWrittenNameList(){
		
		return service.getWrittenNameList();
	}
	
}
