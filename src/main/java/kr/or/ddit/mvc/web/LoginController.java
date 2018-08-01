package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.member.model.MemberVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	

	@RequestMapping("/view")
	public String login(Model model) {

		return "login/login";
	}
	
	//로그인 처리
	//@RequestMapping("/loginProcess")
	public String loginProcess(HttpServletRequest request){
		
		String userId = request.getParameter("mem_id");
		String password = request.getParameter("password");

		//logger : userId, password
		logger.debug("{}", userId);
		logger.debug("{}", password);
		
		
		//정상접속완료
		
		// WEB-INF/view/main    .jsp
		return "main"; 	//main.jsp로 요청
	}
	
	//@RequestMapping("/loginProcess")
	public String loginProcess(MemberVo memVo){
		
		
		logger.debug("{}", memVo.getMem_id() +  "{}",memVo.getPass());
		
		
		
		//정상접속완료
		
		// WEB-INF/view/main    .jsp
		return "main"; 	//main.jsp로 요청
	}
	
	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess2(MemberVo memVo){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main"); //return "main";
		
		mav.addObject("from", "modelAndView");
		
		logger.debug("{}", memVo.getMem_id() +  "{}",memVo.getPass());
		
		//정상접속완료
		
		return mav; 	//main.jsp로 요청
	}

	
	
}