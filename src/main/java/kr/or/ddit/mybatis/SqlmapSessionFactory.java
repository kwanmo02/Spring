package kr.or.ddit.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlmapSessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	
	static{
			//kr/or/ddit/config/spring/root-context.xml
		//kr/or/ddit/config/spring/servlet-context.xml
		//kr/or/ddit/config/mybatis/mybatis-config.xml
		String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
	
}
