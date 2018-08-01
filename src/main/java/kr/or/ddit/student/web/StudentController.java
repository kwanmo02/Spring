package kr.or.ddit.student.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/student")
@Controller("studentController")
public class StudentController {
	@Resource(name="studentService")
	private StudentServiceInf studentService;
	
	//학생 리스트 처리
	@RequestMapping("/list")
	public String StudentList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="10")int pageSize,
			Model model){
		
		//page, pageSize parameter 확인
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		
		Map<String, Object> resultMap = studentService.getStudentPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		
		return "student/list";
	}
	
	@RequestMapping("/detail")
	public String detail(StudentVo vo, Model model){
		
		/*StudentServiceInf studentService = new StudentService();*/
/*		StudentVo studentVo = studentService.getStudent(id);*/	
		StudentVo studentVo = studentService.getStudent(vo);
		
		//request.setAttribute("studentVo", studentVo);
		model.addAttribute("studentVo", studentVo);
		
		//request.getRequestDispatcher("/student/studentDetail.jsp").forward(request, response);
		return "student/detail";
	}
	
}
