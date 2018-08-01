package kr.or.ddit.ioc.placeholder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcInfoTest {
	ApplicationContext context;
	
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-placehoder.xml");
	}
	
	
	@Test
	public void test() {
		/***Given***/

		/***When***/
		JdbcInfo jdbcInfo = (JdbcInfo)context.getBean("jdbcInfo");

		/***Then***/
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", jdbcInfo.getUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", jdbcInfo.getDriver());
		assertEquals("pc21", jdbcInfo.getUsername());
		assertEquals("java", jdbcInfo.getPassword());
	}

}
