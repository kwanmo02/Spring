package kr.or.ddit.ioc.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.ioc.service.IocServiceInf;


@Repository("iocDao")	//id="iocDao"
public class IocDao implements IocDaoInf{

	@Override
	public String hello() {
		return "sayHello";
	}

}
