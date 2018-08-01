package kr.or.ddit.ioc.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration	
@ComponentScan(basePackages={"kr.or.ddit.ioc"})	//얘 밑에 있는 것들을 일단 스캔함.
//@component, @controller, @service, @Repository
public class javaAnnotationConfig {
	
}
