package com.helper.test.testquiz.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.helper.test.image.SmarteditorVO;
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
	@ResponseBody
	public void insertQuizContent(TestQuizDTO dto) {
		service.insertQuizContent(dto);
	}
	
	
	
	@RequestMapping(value="/singleImageUploader.do")
	public String simpleImageUploader(
		HttpServletRequest req, SmarteditorVO smarteditorVO) 
        	throws UnsupportedEncodingException{
	String callback = smarteditorVO.getCallback();
	String callback_func = smarteditorVO.getCallback_func();
	String file_result = "";
	String result = "";
	MultipartFile multiFile = smarteditorVO.getFiledata();
	try{
		if(multiFile != null && multiFile.getSize() > 0 && 
        		StringUtils.isNotBlank(multiFile.getName())){
			if(multiFile.getContentType().toLowerCase().startsWith("image/")){
            	String oriName = multiFile.getName();
                String uploadPath = req.getSession().getServletContext().getRealPath("/img");
                String path = uploadPath + "/smarteditor/";
                File file = new File(path);
                if(!file.exists()){
                file.mkdirs();
                }
                String fileName = UUID.randomUUID().toString();
                smarteditorVO.getFiledata().transferTo(new File(path + fileName));
                file_result += "&bNewLine=true&sFileName=" + oriName + 
                			   "&sFileURL=/img/smarteditor/" + fileName;
			}else{
				file_result += "&errstr=error";
			}
		}else{
			file_result += "&errstr=error";
		}
	} catch (Exception e){
		e.printStackTrace();
	}
	result = "redirect:" + callback + 
			 "?callback_func=" + URLEncoder.encode(callback_func,"UTF-8") + file_result;
	return result;
}
}
