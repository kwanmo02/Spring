package kr.or.ddit.ioc.annotation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import annotation.AnnotationBean;

public class AnnotationBeanTest {
	private ApplicationContext context;
	
	//spring container 생성(application-annotation.xml)
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-annotation.xml");
	}
	
	
	@Test
	public void test() {
		/***Given***/
		//spring container 생성
		
		/***When***/
		//annotationBean DL
		AnnotationBean annotationBean = (AnnotationBean) context.getBean("annotationBean");
		//context.getBean은 xml말고 class파일 에서도 가져올 수 있다. @Component("annotationBean") <----
		
		/***Then***/
		//name 속성 비교
		assertEquals("brown", annotationBean.getName());
	}

}
