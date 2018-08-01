package kr.or.ddit.ioc.service;

import kr.or.ddit.ioc.dao.IocDaoInf;

public interface IocServiceInf {
	String hello();

	
	public IocDaoInf getIocDao();

	public void setIocDao(IocDaoInf iocDao);
	
	
	
}
