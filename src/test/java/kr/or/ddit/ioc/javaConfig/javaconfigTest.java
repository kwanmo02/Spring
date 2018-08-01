package kr.or.ddit.ioc.javaConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.javaconfig.javaConfig;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



//junit환경에서 스프링컨테이너를 구성하게끔 하는 설정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={javaConfig.class})
public class javaconfigTest {
	private ApplicationContext context;
	
	//iocDao, iocService
	@Resource(name="iocDao")
	private IocDaoInf iocDao;
	
	@Resource(name="iocService")
	private IocServiceInf iocService;
	
	
	@Before
	public void setup(){
		
	}
	
	
	@Test
	public void test() {
		/***Given***/
		//iocDao, iocService가 정상적으로 주입 되었는지 확인
		//스프링 컨테이너에 DL --> @Resource(name="스프링 빈")을 통해 주입
		
		/***When***/

		/***Then***/
		
		assertEquals("sayHello", iocDao.hello());
		assertEquals("sayHello", iocService.hello());
		
		assertEquals(iocDao, iocService.getIocDao());
		
		//iocDao.hello(); : "sayHello"
		//iocService.hello(); : "sayHello"
		//iocDao, iocService.getIocDao();
	}

}
