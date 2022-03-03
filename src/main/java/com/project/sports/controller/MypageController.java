package com.project.sports.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/mypage")
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	//글 목록 보기
	@RequestMapping(value = "/main")
	public ModelAndView mainPage(ModelAndView mv , HttpSession session) {
		
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		logger.info("마이페이지세션" + session);
		
		
		
		mv.addObject("sessionid",sessionid);
		

		mv.setViewName("sports_mypage/mypage_main");
		return mv;
	}

}
