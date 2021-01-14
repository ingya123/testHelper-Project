package com.helper.test.writtencontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WrittenController {
	
	@Autowired
	DriverManagerDataSource datasources;
	
	
}
