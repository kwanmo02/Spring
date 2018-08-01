package kr.or.ddit.ioc.javaConfig;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.javaconfig.javaAnnotationConfig;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={javaAnnotationConfig.class})	//얘내 두개에 의해서 컨테이너가 갖춰진것
public class javaAnnotationConfigTest {
	
	
	//iocDao, iocAnnotationDao주입
	@Resource(name="iocDao")
	private IocDaoInf iocDao;
	
	@Resource(name="iocService")
	private IocServiceInf iocService;
	
	
	@Test
	public void test() {
		/***Given***/

		/***When***/

		/***Then***/
		assertEquals("sayHello", iocDao.hello());
		assertEquals("sayHello", iocService.hello());
		assertEquals(iocDao.hello(), iocService.hello());
		
		
		
		//iocDao.hello(); : "sayHello"
		//iocService.hello(); : "sayHello"
		//iocDao, iocService.getIocDao();
	}

}
