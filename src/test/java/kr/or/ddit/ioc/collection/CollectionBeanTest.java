package kr.or.ddit.ioc.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {

	//before annotation을 통해 스프링 ioc 컨테이너 생성
	ApplicationContext context;
	
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-collection.xml");
	}
	
	
	//spring container 정상 생성 확인
	@Test
	public void springContainerTest(){
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(context);
		assertTrue(context.getBeanDefinitionCount()>=1);
	}
	
	
	
	
	
	
	@Test
	public void listTest() {
		/***Given***/
		//spring ioc 컨테이너 생성(before)
		
		/***When***/
		//CollectionBean을 dl
		//collectionBean 객체의 getList()를 통해 list객체 받기
		
		CollectionBean collectionBean = (CollectionBean)context.getBean("collectionBean", CollectionBean.class);
		List<CollectionBean> list = collectionBean.getList();
		
		/***Then***/
		//List.get(0) == brown / List.get(1) == cony / List.get(2) == sally
		
		assertEquals("brown", list.get(0));
		assertEquals("cony", list.get(1));
		assertEquals("sally", list.get(2));
	}
	
	
	@Test
	public void setTest(){
		/***Given***/

		/***When***/
		CollectionBean collectionBean = (CollectionBean)context.getBean("collectionBean");
		Set sets = collectionBean.getSets();
		
		/***Then***/
		assertTrue(sets.contains("cony"));
		assertTrue(sets.contains("sally"));
		assertTrue(sets.contains("brown"));
	}
	
	@Test
	public void mapTest(){
		/***Given***/

		/***When***/
		CollectionBean collectionBean = (CollectionBean)context.getBean("collectionBean");
		Map map = collectionBean.getMap();
		
		/***Then***/
		assertEquals("sally", map.get("ranger1"));
		assertEquals("brown", map.get("ranger2"));
		assertEquals("cony", map.get("ranger3"));
	}
	
	
	//properties 주입 테스트
	@Test
	public void propTest(){
		/***Given***/
		//spring container 생성 테스트

		/***When***/
		//CollectionBean DL(컨테이너에 설정된 빈을 참조)
		//collectionBean의 pros 속성 확인
		CollectionBean collectionBean = (CollectionBean)context.getBean("collectionBean");
		/*CollectionBean collectionBean = context.getBean("colelctionBean", CollectionBean.class);*/
		
		Properties prop = collectionBean.getPros();
		
		/***Then***/
		assertEquals("brown", prop.get("ranger1"));
		assertEquals("cony", prop.get("ranger2"));
		assertEquals("sally", prop.get("ranger3"));
	}
	
	

}
