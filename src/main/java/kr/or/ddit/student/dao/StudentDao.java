package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlmapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlmapSessionFactory.getSqlSessionFactory();
	/**
	 * 
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
		
		
	}
	
	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		StudentVo vo = session.selectOne("student.selectStudent", id);	//인자 넘기는것 신경써서 넣어주기.
		return vo;
	}

	@Override
	public StudentVo getStudent(StudentVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		StudentVo studentVo = session.selectOne("student.selectStudent2", vo);
		return studentVo;
	}
	
	
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC21
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	*/
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList", map);
		session.close();
		
		return studentList; 
	}

	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int studenTotCntList = session.selectOne("student.getStudentTotCnt");
		session.close();
		
		return studenTotCntList;
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updatecnt =session.update("student.studentUpdate", studentVo);
		session.commit();
		session.close();
		
		return updatecnt;
	}
}












