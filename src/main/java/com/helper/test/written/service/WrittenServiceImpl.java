package com.helper.test.written.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helper.test.written.dao.WrittenDAO;
import com.helper.test.written.dto.WrittenTestDTO;

@Service
public class WrittenServiceImpl implements WrittenService{
	@Autowired
	WrittenDAO dao;
	
	public void insertWrittenName(WrittenTestDTO dto) {
		dao.insertWrittenName(dto);
	}
	
	public ArrayList<WrittenTestDTO> getWrittenNameList(){
		return dao.getWrittenNameList();
	}
}
