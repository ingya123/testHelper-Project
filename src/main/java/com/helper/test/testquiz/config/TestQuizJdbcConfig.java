package com.helper.test.testquiz.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("com.helper.test.testquiz.dao")
public class TestQuizJdbcConfig {
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("testHelper");
		ds.setPassword("1234");

		return ds;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	
	@Bean
	public SqlSession  sqlsession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
}
