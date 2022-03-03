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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.sports.domain.Member;
import com.project.sports.domain.PersonalManagement;
import com.project.sports.domain.Sports;
import com.project.sports.domain.WaterIntake;
import com.project.sports.service.MemberService;
import com.project.sports.service.PersonalManagementService;
import com.project.sports.service.WaterIntakeService;

@Controller
@RequestMapping(value="/pm")
public class PersonalManagementController {
	
	private static final Logger logger	
	= LoggerFactory.getLogger(BbsFrController.class);

	@Autowired
	private PersonalManagementService pmService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private WaterIntakeService WaterService;
	
	/*
	 * @RequestMapping(value="/view") public String list(){ return
	 * "sports_management/personal_management"; }
	 */
	
	@RequestMapping(value="/select")
	@ResponseBody
	public List<Sports> select(String select) {
		List<Sports> list = pmService.getSelect(select);
		logger.info("select=" + select);
		for(Sports value : list) {
		logger.info("스포츠명="+value.getSPORTS_NAME());
		logger.info("칼로리:" + value.getCAL());
		}
		return list;
	}	
	
	@PostMapping(value="/add")
	@ResponseBody
	public String add(PersonalManagement pm,  HttpSession session,
					 @RequestParam(value="time", defaultValue="0",required=false)
					  int time,
					 @RequestParam(value="sports_name", required=false)
					  String sports_name,
					 @RequestParam(value="cal", required=false) 
					  int cal,
					 @RequestParam(value="sports_img", required=false)
					  String sports_img){
		
			pm.setSPORTS_NAME(sports_name);
			pm.setPM_KCAL(cal * time);
			pm.setSPORTS_IMG(sports_img);
			pm.setUSER_ID((String)session.getAttribute("USER_ID"));
			pmService.insertPM(pm);
			
		return "success";
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Map<String, Object> getList(
				//PersonalManagement pm, 
				HttpSession session,
				@RequestParam(value="page",defaultValue="1",required=false) int page,
				@RequestParam(value="limit",defaultValue="3",required=false) int limit
				){
		String id =(String)session.getAttribute("USER_ID");
		logger.info("id : " + id);
		limit = 3;	// 한 화면에 출력할 레코드 개수
		int listcount =pmService.getListCount(id); //총 리스트 수를 받아옴
		//총 페이지 수
		int maxpage = (listcount + limit -1) / limit;
		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = ((page - 1) / 10) * 10 + 1;
		//현재 페이지에 보여줄 마지막 페이지 수 (10, 20, 30 등...)
		int endpage = startpage + 10 - 1;
		if(endpage > maxpage)
		  endpage = maxpage;
		List<PersonalManagement> list = pmService.getList(id,page, limit);
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("page",page);
		map.put("maxpage",maxpage);
		map.put("startpage",startpage);
		map.put("endpage",endpage);
		map.put("listcount",listcount);
		map.put("list",list);
		
		logger.info("page : " + map.get("page"));
		logger.info("maxpage : " + map.get("maxpage"));
		logger.info("startpage : " + map.get("startpage"));
		logger.info("endpage : " + map.get("endpage"));
		logger.info("listcount : " + map.get("listcount"));
		for(PersonalManagement p : list) {			
			logger.info("list : " + p.getPM_KCAL());
			logger.info("list : " + p.getPM_NO());
			logger.info("list : " + p.getSPORTS_IMG());
			logger.info("list : " + p.getSPORTS_NAME());
			logger.info("list : " + p.getUSER_ID());
		}
		//pm.setUSER_ID((String)session.getAttribute("USER_ID"));
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public void delete(@RequestParam(value="num", required=false) int num) {
		int result = pmService.delete(num);
		logger.info("result=" + result);
		logger.info("num=" + num);
	}
	
	
	@PostMapping(value="/wateradd")
	@ResponseBody
	public Map<String, Object> add(WaterIntake water, HttpSession session, Member member,
			@RequestParam(value="title", defaultValue="0", required=false)
			String title
			){
		String id =(String)session.getAttribute("USER_ID");
		water.setUser_id(id);
		water.setTitle(title);
		logger.info("title"+title);
		int count = WaterService.doughnutlistcount(id);
		if(count > 0) {  //이미 테이블에 물섭취 정보 존재
			//해당 row를 업데이트
			WaterService.waterUpdate(water);//추가
		}else{ //테이블에 물섭취 정보 없음
			//새로운 insert 수행
			WaterService.wateradd(water);//추가
		}
		
		float result = WaterService.DoughnutList(id);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("title", result);
		logger.info("water : " + result);
		return map;
	}
	
	@RequestMapping(value="/doughnut")
	public String view(Model md, HttpSession session) {
		float title = (float) 0.0;
		String id =(String)session.getAttribute("USER_ID");
		Member member = memberService.member_info(id);
		int count = WaterService.doughnutlistcount(id);
		if(count > 0) {
			title = WaterService.DoughnutList(id);
		}
		md.addAttribute("goaldata", member.getUSER_WWEIGHT() * 0.033);
		md.addAttribute("title", title);
		return "sports_management/personal_management";
	}
	
	@PostMapping(value="/delWater")
	@ResponseBody
	public void delWater(@RequestParam(value ="title", required= false) String title,
			 			HttpSession session) {
		String id =(String)session.getAttribute("USER_ID");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("title", title);
		int delresult = WaterService.delWater(map);
		logger.info("delresult=" + delresult);
		logger.info("title=" + title);
	}
	
	
	}
	 



