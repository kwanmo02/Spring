package kr.or.ddit.lprod;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.lpord.model.LprodVo;
import kr.or.ddit.student.model.StudentVo;

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
/*
spring controller test 설정

1. Spring을 junit에서 사용할 수 있도록 설정 @Runwith(SpringJunit4ClassRunner.class)
2. Spring 설정 파일 설정 : @ContextConfiguration
3. Spring container가 웹 어플리케이션 컨텍스트로 생성될 수 있도록 설정 : @WebAppConfiguration

4. 스프링 웹 환경과 동일하게 요청할 수 있도록 dispactcherServlet 역할을 하는 MokMvc 객체생성
 --> MockMvc를 생성하기 위해서는 WebApplicationContext객체가 필요

*/
import org.springframework.web.servlet.ModelAndView;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/servlet-context.xml",
								"classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration
public class LprodControllerTest {

	@Resource
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void lprodListTest() throws Exception{
		/***Given***/
		MvcResult result = mvc.perform(get("/lprod/list").param("page", "1").param("pageSize", "10")).andReturn();

		/***When***/
		
		/***Then***/
		ModelAndView mav = result.getModelAndView();
		assertEquals("lprod/list", mav.getViewName());
		
		List<LprodVo> lprodList = (List<LprodVo>) mav.getModel().get("pageList");
		
		assertEquals(10, lprodList.size());
		assertTrue((Integer)mav.getModel().get("totCnt") > 10);
		assertNotNull(mav.getModel().get("pageNavi"));
		
	}
	
	
	
	/*
	@Test
	public void lprodDetailTest() throws Exception{
		*//***Given***//*
		MvcResult result = mvc.perform(get("/lprod/detail").param("lprod_id", "8")).andReturn();
		
		*//***When***//*
		ModelAndView mav = result.getModelAndView();
		LprodVo lprodVo = (LprodVo)mav.getModel().get("lprodVo");
		

		*//***Then***//*
		assertNotNull(mav);
		assertEquals("lprod/detail", mav.getViewName());
		assertEquals("도서", lprodVo.getLprod_nm());
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	

}
