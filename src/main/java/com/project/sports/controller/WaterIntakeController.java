package com.project.sports.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.sports.domain.PersonalManagement;
import com.project.sports.domain.WaterIntake;
import com.project.sports.service.PersonalManagementService;
import com.project.sports.service.WaterIntakeService;

@Controller
@RequestMapping(value = "/water")
public class WaterIntakeController {

	private static final Logger logger = LoggerFactory.getLogger(BbsFrController.class);

	@Autowired
	private WaterIntakeService WaterService;
	@Autowired
	private PersonalManagementService pmService;
	
	
	@RequestMapping(value = "/calendar")
	public String water1() {
		return "sports_water/Water_Calendar";
	}


	/*
	 * @PostMapping(value = "/wateradd")
	 * 
	 * @ResponseBody public String add(WaterIntake water, HttpServletRequest
	 * request, HttpSession session) throws Exception {
	 * 
	 * String date = water.getTime_start(); logger.info("date:" + date);
	 * water.setUser_id((String) session.getAttribute("USER_ID"));
	 * 
	 * WaterService.Waterinsert(water); logger.info("water:" + water); return
	 * "redirect:calendar"; }
	 */
	
	@GetMapping(value = "/getCalendar")
	@ResponseBody
	public List<Map<String,Object>> Calendar(String dateString, HttpSession session) {
		String id = (String) session.getAttribute("USER_ID");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("dateString", dateString);
		
		return pmService.getCalendar(map);
		
	}
}