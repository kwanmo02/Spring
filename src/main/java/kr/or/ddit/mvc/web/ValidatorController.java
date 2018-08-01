package kr.or.ddit.mvc.web;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.mvc.model.ValidVo;
import kr.or.ddit.mvc.model.ValidVoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/valid")
@Controller
public class ValidatorController {
	
	//화면을 먼저 새로 만든다.
	
	@RequestMapping("/view")
	public String view(){
		
		return "mvc/valid/view";
		
	}
	
	//받는 녀석
	@RequestMapping("/submit")
	public String submit(ValidVo validVo
						, BindingResult errors
						, Model model){ //bindResult 객체는 검증하기 위한 vo객체의 바로 뒤에 선언되어야 한다!!
		
		new ValidVoValidator().validate(validVo, errors);
		
		
		if (errors.hasErrors()) {
			model.addAttribute("errorMsg", "에러가 발생하였습니다.");
		}
		
		model.addAttribute("validVo", validVo);

		return "mvc/valid/view";
	}
}
