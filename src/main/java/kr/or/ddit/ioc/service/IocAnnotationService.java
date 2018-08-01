package kr.or.ddit.ioc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.ioc.dao.IocDaoInf;

@Service("iocAnnotationService") //spring bean id = "iocAnnotationService"
public class IocAnnotationService implements IocServiceInf{
	
	@Resource(name="iocDao")	// 밑에다 넣어라!
	private IocDaoInf iocDao;	// <----얘한테
	
	
	public IocAnnotationService(){
		
	}
	
	
	
	//생성자를 통한 주입
	public IocAnnotationService(IocDaoInf iocDao){
		this.iocDao = iocDao;
	}
	
	//setter를 통한 주입
	
	@Override
	public String hello() {
		return iocDao.hello();
	}

	
	
	
	public IocDaoInf getIocDao() {
		return iocDao;
	}

	public void setIocDao(IocDaoInf iocDao) {
	/*	this.iocDao = iocDao;*/
	}
	
	
	
	
	

}
