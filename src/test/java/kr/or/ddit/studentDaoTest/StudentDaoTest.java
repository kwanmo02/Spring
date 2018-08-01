package kr.or.ddit.studentDaoTest;

import static org.junit.Assert.assertEquals;			//원래 static은 class. 해서 불러야 되는데 귀찮아서 이렇게 만듬 밑에 assert이거
//이 위에꺼는 window - preferences - favorite에서 추가해줄 수 있다.

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	
//	@Before --> @Test --> @After 	(Test메서드가 실행되는 단계)
//	@Before - @Test - @After
//	중복되는 구현체에 대해서는 @Before 어노테이션이 붙은 SetUp메서드에 위임
//	모든 메소드에서 StudentDao 객체를 참조할 수 있는 끔 클래스 변수로 생성할 필요가 있고
//	클래스 변수를 setUp메소드에서 초기화하는 로직이 필요하다.
//	테스트 메소드에서 생성했던 StudentDao를 생성하는 로직은 삭제해준다.
//	테스트 메서드의 실행순서는 무작위이다.
	
	private StudentDaoInf studentDao;
	
	@Before
	public void Setup(){
		studentDao = new StudentDao();
	}

	/**
	 * 
	* Method : selectAllStudentsTest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC21
	* 변경이력 :
	* Method 설명 : 전체학생정보 조회
	 */
	@Test
	public void selectAllStudentsTest() {
		
		/***Given***/
//		StudentDaoInf studentDao = new StudentDao();

		/***When***/
		List<StudentVo> studentList = studentDao.selectAllStudents();
		
		for(StudentVo vo : studentList)
			System.out.println(vo);
		
		
		/***Then***/
		assertEquals(25, studentList.size());
	}
	
	@Test
	public void getStudentTest(){
		/***Given***/
//		StudentDaoInf studentDao = new StudentDao();
		int id = 8;
		
		StudentVo studentVo = new StudentVo();
		studentVo.setId(9);
		studentVo.setName("차득림");
		studentVo.setCall_cnt(0);
		
		/***When***/
		StudentVo vo = studentDao.getStudent(id);
		StudentVo vo2 = studentDao.getStudent(studentVo);
		System.out.println(vo);
		System.out.println(vo2);
		
		/***Then***/
		assertEquals("너도돼지야", vo.getName());
		assertEquals("차득림", vo2.getName());

	}
	
	@Test
	public void getStudentPageListTest(){
		
		
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);

		/***When***/
		List<StudentVo> pageList = studentDao.getStudentPageList(map);
		
				
				
		/***Then***/
		assertEquals(10	, pageList.size());
	}
	
	
	@Test
	public void getStudentTotCntTest(){
		/***Given***/
		
		/***When***/
		
		/***Then***/

	}
	
	
	@Test
	public void updateResultTest(){
		/***Given***/
		StudentVo vo = new StudentVo();
		vo.setId(2);
		vo.setAddr1("청주시 흥덕구 가경동");
		vo.setAddr2("형석1차 105동 1308호");
		vo.setName("뿡뿡이");
		vo.setZipcd("34940");
		vo.setPic("cony.png");
		vo.setPicpath("D:\\A_TeachingMaterial\\7.Jspspring\\fileUpload");
		vo.setPicname("231192e4-67a9-4766-b25f-2e7a21732054");
		
		
		/***When***/
		int count = studentDao.studentUpdate(vo);
		
		/***Then***/
		assertEquals(1, count);
	
		
	}

}
