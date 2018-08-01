package kr.or.ddit.lpord.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lpord.dao.LprodDao;
import kr.or.ddit.lpord.dao.LprodDaoInf;
import kr.or.ddit.lpord.model.LprodVo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service("lprodService")
public class LprodService implements LprodServiceInf{

	LprodDaoInf dao = new LprodDao();	
	
	@Override
	public List<LprodVo> selectAllLprod() {
		
		return dao.selectAllLprod();
	}

	@Override
	public Map<String, Object> getLprodPageList(Map<String, Integer> map) {
		LprodDao lprodDao = new LprodDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//상품 페이지 리스트 조회
		List<LprodVo> pageList = lprodDao.getLprodPageList(map);
		resultMap.put("pageList", pageList);
		
		
		//상품 전체 건수 조회
		int totCnt = lprodDao.getLprodTotCnt();
		resultMap.put("totCnt", totCnt);
		
		//페이지 네비게이션 html생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}
	
	
	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if(mod > 0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page==1 ? 1:page-1;
		int PagePlus = page==cnt? cnt:page+1;
		
		pageNaviStr.append("<li><a href=\"lprodList?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		for(int i = 1; i<=cnt; i++){
			///studentList?page=3&pageSize=10
			String activeClass = "";
			if ( i == page)
				activeClass = " class=\"active\"";
			
				pageNaviStr.append("<li" + activeClass + "><a href=\"/lprodList?page=" + i + 
									"&pageSize=" + pageSize + "\">" + i + "</a></li>");
			
		}
		pageNaviStr.append("<li><a href=\"lprodList?page=" + PagePlus + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}

	@Override
	public LprodVo getLprod(LprodVo vo) {
		return dao.getLprod(vo);
	}

	
}
