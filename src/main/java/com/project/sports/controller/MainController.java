package com.project.sports.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.sports.domain.Sports;
import com.project.sports.service.MainService;

@Controller
@RequestMapping(value="/main")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainService mainservice;
	
	//�� ��� ����
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public ModelAndView mainPage(ModelAndView mv) {
		mv.setViewName("main");
		return mv;
	}
	
	//��õ � ��������(ajax)
	@RequestMapping(value = "/recommSport", method = RequestMethod.GET)
	@ResponseBody
	public List<Sports> smentorlistAjax(int state){
		logger.info("recommand : "  + state);
	    return mainservice.getRecommSportlList(state); //����Ʈ�� �޾ƿ�
	}
}
