package kr.or.ddit.lpord.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.lpord.model.LprodVo;
import kr.or.ddit.lpord.service.LprodServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lprod")
@Controller("lprodController")
public class LprodController {
		
	@Resource(name="lprodService")
	private LprodServiceInf lprodService;
	
	
	
	//상품 리스트 처리
	@RequestMapping("/list")
	public String LprodList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="10")int pageSize,
			Model model){
		//page, pageSize parameter 확인
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		Map<String, Object> resultMap = lprodService.getLprodPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		
		
		return "lprod/list";
		
		
	}
	
	
	/*
	public String detail(LprodVo vo , Model model){
		
		LprodVo lprodVo = lprodService.getLprod(vo);
		
		model.addAttribute("lprodVo", lprodVo);
		
		return "lprod/detail";
		
	}
	*/
	
	
	
	
	
}
