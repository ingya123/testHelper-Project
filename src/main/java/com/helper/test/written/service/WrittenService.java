package com.helper.test.written.service;

import java.util.ArrayList;

import com.helper.test.written.dto.WrittenTestDTO;

public interface WrittenService {
	public void insertWrittenName(WrittenTestDTO dto);
	
	public ArrayList<WrittenTestDTO> getWrittenNameList();
}
