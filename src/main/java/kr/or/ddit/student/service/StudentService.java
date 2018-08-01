package kr.or.ddit.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

@Service("studentService")
public class StudentService implements StudentServiceInf{

	StudentDaoInf dao = new StudentDao();
	@Override
	public List<StudentVo> selectAllStudents() {
		return dao.selectAllStudents();
	}
	
	@Override
	public StudentVo getStudent(int id) {
		return dao.getStudent(id);
	}
	
	@Override
	public StudentVo getStudent(StudentVo vo) {
		return dao.getStudent(vo);
	}

	@Override
	public Map<String, Object> getStudentPageList(Map<String, Integer> map) {
		StudentDao studentDao = new StudentDao();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//학생 페이지 리스트 조회
		List<StudentVo> studentList = studentDao.getStudentPageList(map);
		resultMap.put("studentList", studentList);
		
		//학생 전체 건수 조회
		int totCnt = studentDao.getStudentTotCnt();
		resultMap.put("totCnt", totCnt);
		
		//페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));	
		return  resultMap;
	}
	
	
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC21
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션 문자열 생성
	*/
	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if(mod > 0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page==1 ? 1:page-1;
		int PagePlus = page==cnt? cnt:page+1;
		
		pageNaviStr.append("<li><a href=\"/student/list?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		for(int i = 1; i<=cnt; i++){
			///studentList?page=3&pageSize=10
			String activeClass = "";
			if ( i == page)
				activeClass = " class=\"active\"";
			
				pageNaviStr.append("<li" + activeClass + "><a href=\"/student/list?page=" + i + 
									"&pageSize=" + pageSize + "\">" + i + "</a></li>");
			
		}
		pageNaviStr.append("<li><a href=\"/student/list?page=" + PagePlus + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		
		return dao.studentUpdate(studentVo);
	}
	
	

}
