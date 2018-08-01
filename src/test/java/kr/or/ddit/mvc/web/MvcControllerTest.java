package kr.or.ddit.mvc.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml","classpath:kr/or/ddit/config/spring/servlet-context.xml"})

@WebAppConfiguration
public class MvcControllerTest {

	@Resource
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Test
	public void pathVariableTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/mvc/pathvariable/25")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		
		/***Then***/
		assertEquals("mvc/view", mav.getViewName());
		assertEquals("25", mav.getModel().get("boardNum"));
	}

	
	
	//multipart view test
	@Test
	public void multipartViewTest() throws Exception{
		/***Given***/
		MvcResult result = mockMvc.perform(get("/mvc/multipart/view")).andReturn();
		/***When***/
		ModelAndView mav = result.getModelAndView();
		
		/***Then***/
		assertEquals("mvc/multipartView", mav.getViewName());
	}
	
	
	
	
	
	
	
	
	
}
