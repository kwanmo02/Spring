package kr.or.ddit.lpord.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.lpord.model.LprodVo;
import kr.or.ddit.mybatis.SqlmapSessionFactory;

public class LprodDao implements LprodDaoInf {
private SqlSessionFactory sqlSessionFactory = SqlmapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<LprodVo> selectAllLprod() {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<LprodVo> lprodList = session.selectList("lprod.selectAllLprod");
		session.close();
		
		return lprodList;
	}

	@Override
	public List<LprodVo> getLprodPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = session.selectList("lprod.getLprodPageList", map);
		session.close();
		
		return lprodList;
	}

	@Override
	public int getLprodTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int lprodTotCntList = session.selectOne("lprod.getLprodTotCnt");
		session.close();
		return lprodTotCntList;
	}

	@Override
	public LprodVo getLprod(LprodVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		LprodVo lprodVo = session.selectOne("lprod.selectLprod");
		session.close();
		
		return lprodVo;
	}
}
