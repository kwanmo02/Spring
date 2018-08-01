package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;


// 전체 학생 정보를 조회한다.
public interface StudentDaoInf {
	/**
	 * 
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC21
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 조회
	 */
	List<StudentVo> selectAllStudents();
	
	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC21
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 학생조회
	 */
	StudentVo getStudent(int id);
	
	/**
	 * 
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC21
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 학생조회
	 */
	StudentVo getStudent(StudentVo vo);
	
	
	
	
	/**
	* Method : getStudentPageList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC21
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 :	학생 페이지 리스트 조회
	*/
	List<StudentVo> getStudentPageList(Map<String, Integer> map);
	
	
	int getStudentTotCnt();
	
	/**
	 * 
	* Method : studentUpdate
	* 최초작성일 : 2018. 7. 17.
	* 작성자 : PC21
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 학생 정보 업데이트
	 */
	int studentUpdate(StudentVo studentVo);

}
