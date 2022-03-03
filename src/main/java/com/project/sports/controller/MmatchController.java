package com.project.sports.controller;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.sports.domain.MatchAppReq;
import com.project.sports.domain.MatchInfo;
import com.project.sports.domain.Mentee;
import com.project.sports.domain.Mentor;
import com.project.sports.domain.Sports;
import com.project.sports.service.MmatchService;
import com.project.sports.task.SendSms;

@Controller
@RequestMapping(value= {"/mmatch","/mypage"})
public class MmatchController {
	private static final Logger logger = LoggerFactory.getLogger(MmatchController.class);
	
	@Autowired
	private MmatchService mmatchservice;
	
	@Value("${savefoldername}")
	private String saveFolder;

	//멘토 글 작성
	@RequestMapping(value = "/mentorWrite", method = RequestMethod.GET)
	public String mentorWrite() {
		return "sport_menMatch/sports_mentor_write";
	}
		
	//멘토 글 작성
	@RequestMapping(value = "/menteeWrite", method = RequestMethod.GET)
	public String menteeWrite() {
		return "sport_menMatch/sports_mentee_write";
	}
	
	//멘토 글 리스트 보기
	@RequestMapping(value = "/mentorPage", method = RequestMethod.GET)
	public ModelAndView mentorlist(
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			ModelAndView mv)
	{
	    int listcount = mmatchservice.getMentorListCount(); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getMentorList(page, limit); //리스트를 받아옴
	    
	    mv.setViewName("sport_menMatch/sports_mentor");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("mentorlist",mentorlist);
	    mv.addObject("saveFolder",saveFolder);
		/*
		 * logger.info("page : " +page); logger.info("maxpage : " +maxpage);
		 * logger.info("startpage : " +startpage); logger.info("endpage : " +endpage);
		 * logger.info("listcount : " +listcount); for(Mentor m : mentorlist) {
		 * logger.info("사진 : " +m.getMentor_pic1()); logger.info("종목 : "
		 * +m.getSports_name()); logger.info("시 : " +m.getCity()); logger.info("군구 : "
		 * +m.getSigungu()); logger.info("인원 : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
		return mv;
	}
	
	//멘티 글 리스트 보기
	@RequestMapping(value = "/menteePage", method = RequestMethod.GET)
	public ModelAndView menteelist(
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			ModelAndView mv)
	{
	    int listcount = mmatchservice.getMenteeListCount(); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getMenteeList(page, limit); //리스트를 받아옴
	    
	    mv.setViewName("sport_menMatch/sports_mentee");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("menteelist",menteelist);
	    mv.addObject("saveFolder",saveFolder);
		
	   
		
		/*
		 * logger.info("page : " +page); logger.info("maxpage : " +maxpage);
		 * logger.info("startpage : " +startpage); logger.info("endpage : " +endpage);
		 * logger.info("listcount : " +listcount); for(Mentee m : menteelist) {
		 * logger.info("사진 : " +m.getMentee_pic1());
		 * logger.info("종목 : "+m.getSports_name()); logger.info("시 : " +m.getCity());
		 * logger.info("군구 : "+m.getSigungu()); logger.info("code: " +
		 * m.getMentee_code()); } logger.info("saveFolder : " +saveFolder);
		 */
		 
		 
		return mv;
	}
	
	
	//멘토 글 리스트 보기(ajax)
	@RequestMapping(value = "/mentorPage_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> mentorlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="search_field" ,defaultValue="") String search_field,
			@RequestParam(value="search_word" ,defaultValue="") String search_word)
	{
	    
	    int listcount = mmatchservice.getSearchMentorListCount(search_field,search_word); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getSearchMentorList(page, limit,search_field,search_word); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("mentorlist",mentorlist);
	    map.put("saveFolder",saveFolder);
	    map.put("search_field",search_field);
	    map.put("search_word",search_word);
		/*
		 * logger.info("page : " +page); logger.info("maxpage : " +maxpage);
		 * logger.info("startpage : " +startpage); logger.info("endpage : " +endpage);
		 * logger.info("listcount : " +listcount); for(Mentor m : mentorlist) {
		 * logger.info("사진 : " +m.getMentor_pic1()); logger.info("종목 : "
		 * +m.getSports_name()); logger.info("시 : " +m.getCity()); logger.info("군구 : "
		 * +m.getSigungu()); logger.info("인원 : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
	    return map;
	}
	
	//멘티 글 리스트 보기(ajax)
	@RequestMapping(value = "/menteePage_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> menteelistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="search_field" ,defaultValue="") String search_field,
			@RequestParam(value="search_word" ,defaultValue="") String search_word)
	{
	    int listcount = mmatchservice.getSearchMenteeListCount(search_field,search_word); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getSearchMenteeList(page, limit,search_field,search_word); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("menteelist",menteelist);
	    map.put("saveFolder",saveFolder);
	    map.put("search_field",search_field);
	    map.put("search_word",search_word);
		/*
		 * logger.info("page : " +page); logger.info("maxpage : " +maxpage);
		 * logger.info("startpage : " +startpage); logger.info("endpage : " +endpage);
		 * logger.info("listcount : " +listcount); for(Mentor m : mentorlist) {
		 * logger.info("사진 : " +m.getMentor_pic1()); logger.info("종목 : "
		 * +m.getSports_name()); logger.info("시 : " +m.getCity()); logger.info("군구 : "
		 * +m.getSigungu()); logger.info("인원 : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
	    return map;
	}
	//sport 종목 가져오기(이름만)
	@GetMapping("/sportlist")
	@ResponseBody
	public List<String> Sportlist(int selType) {
		logger.info("seltype :" + selType);
		List<String> list = mmatchservice.getSportlist(selType);
		/*
		 * for(String value : list) logger.info("value :" + value);
		 */
		return list;
	}
	
	//sport 종목 가져오기(이름,img 데이터 response)
	@GetMapping("/sportDeatilList")
	@ResponseBody
	public List<Sports> SportDetailList(int selType) {
		logger.info("seltype :" + selType);
		List<Sports> list = mmatchservice.getSportDeatilList(selType);
		/*
		 * for(Sports sp : list) { logger.info("value :" + sp.getSPORTS_NAME());
		 * logger.info("value :" + sp.getSPORTS_IMG()); }
		 */		
		return list;
	}
	
	//주소(시) 종목 가져오기
	@GetMapping("/siList")
	@ResponseBody
	public List<String> silist() {
		logger.info("si List");
		List<String> list = mmatchservice.getSilist();
		/*
		 * for(String value : list) logger.info("value :" + value);
		 */
		return list;
	}
	
	//주소(동) 종목 가져오기
	@GetMapping("/dongList")
	@ResponseBody
	public List<String> donglist(String selType) {
		logger.info("dongtype :" + selType);
		List<String> list = mmatchservice.getDonglist(selType);
		/*
		 * for(String value : list) logger.info("value :" + value);
		 */
		return list;
	}
	
	//멘토글 수정 진행
	@PostMapping("/mentorModifyAction")
	public String mentorModifyAction(Mentor mentor,String[] mentor_yoil,
			String[] mentor_startTime,String[] mentor_endTime,String[] check,
			RedirectAttributes rattr,Model mv,HttpServletRequest request) throws Exception{

		MultipartFile uploadfile1 =mentor.getUploadfile1();
		MultipartFile uploadfile2 =mentor.getUploadfile2();
		MultipartFile uploadfile3 =mentor.getUploadfile3();
		String mentorDate="";
		String url="";
		//1.파일 삭제 : ''
		//2.기존파일 그대로 : '기존파일이름'
		//3.파일 변경 : 'no'
		
		if(!check[0].equals("no") && !check[0].equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("1번 파일 : 기존 파일 그대로 사용합니다." + check[0]);
			mentor.setMentor_origin_pic1(check[0]);
		}else {
			if(uploadfile1 != null && !uploadfile1.isEmpty()) { //파일이 변경된 경우
				logger.info("1번 파일이 변경되었습니다." + check[0]);
				String fileName = uploadfile1.getOriginalFilename(); //원래 파일명
				mentor.setMentor_origin_pic1(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile1.transferTo(new File(saveFolder + fileDBName));
				mentor.setMentor_pic1(fileDBName);
			}else { //파일을 선택하지 않은 경우
				logger.info("1번 선택 파일이 없습니다." + check[0]);
				mentor.setMentor_origin_pic1("");
				mentor.setMentor_pic1("");
			}
		}
		
		if(!check[1].equals("no") && !check[1].equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("2번 파일 : 기존 파일 그대로 사용합니다." + check[1]);
			mentor.setMentor_origin_pic2(check[1]);
		}else {
			if(uploadfile2 != null && !uploadfile2.isEmpty()) { //파일이 변경된 경우
				logger.info("2번 파일이 변경되었습니다." + check[1]);
				String fileName = uploadfile2.getOriginalFilename(); //원래 파일명
				mentor.setMentor_origin_pic2(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile2.transferTo(new File(saveFolder + fileDBName));
				mentor.setMentor_pic2(fileDBName);
			}else { //파일을 선택하지 않은 경우
				logger.info("2번 선택 파일이 없습니다." + check[1]);
				mentor.setMentor_origin_pic2("");
				mentor.setMentor_pic2("");
			}
		}
		
		if(!check[2].equals("no") && !check[2].equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("3번 파일 : 기존 파일 그대로 사용합니다." + check[2]);
			mentor.setMentor_origin_pic3(check[2]);
		}else {
			if(uploadfile3 != null && !uploadfile3.isEmpty()) { //파일이 변경된 경우
				logger.info("3번 파일이 변경되었습니다." + check[2]);
				String fileName = uploadfile3.getOriginalFilename(); //원래 파일명
				mentor.setMentor_origin_pic3(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile3.transferTo(new File(saveFolder + fileDBName));
				mentor.setMentor_pic3(fileDBName);
			}else { //파일을 선택하지 않은 경우
				logger.info("3번 선택 파일이 없습니다." + check[2]);
				mentor.setMentor_origin_pic3("");
				mentor.setMentor_pic3("");
			}
		}
		
		for(int i=0; i<mentor_yoil.length; i++) {
			mentorDate += mentor_yoil[i]+"/"+ mentor_startTime[i]+"/"+mentor_endTime[i];
			if((i+1) < mentor_yoil.length)
				mentorDate += ",";
		}
		mentor.setMentor_date(mentorDate);
		
		
		  logger.info(mentor.getUser_id()); logger.info(mentor.getMentor_title());
		  logger.info(mentor.getSports_name()); logger.info(mentor.getCity());
		  logger.info(mentor.getSigungu()); logger.info(mentor.getMentor_loc_detail());
		  logger.info("금액 : " + mentor.getMentor_amount()); logger.info("인원 : " +
		  mentor.getMentor_number()); logger.info(mentor.getMentor_caution());
		  logger.info(mentor.getMentor_career()); logger.info(mentor.getMentor_date());
		 
		int result = mmatchservice.modifyMentorWriting(mentor);
		if(result == 1 ) {
			logger.info("멘토 공고글 수정  성공");
			url ="redirect:mentorPage";
			rattr.addFlashAttribute("result","modifySuccess");
		}else{
			logger.info("멘토 공고글 수정  실패");
			mv.addAttribute("url",request.getRequestURI());
			mv.addAttribute("message","멘토 공고글 수정 실패");
			url = "error/error";
		}
		return url;
	}
	
	//멘티글 수정 진행
	@PostMapping("/menteeModifyAction")
	public String menteeModifyAction(Mentee mentee,String[] mentee_yoil,
			String[] mentee_startTime,String[] mentee_endTime,String check,
			RedirectAttributes rattr,Model mv,HttpServletRequest request) throws Exception{

		MultipartFile uploadfile1 =mentee.getUploadfile1();
		String menteeDate="";
		String url="";
		//1.파일 삭제 : ''
		//2.기존파일 그대로 : '기존파일이름'
		//3.파일 변경 : '변경파일이름'
		if(check !=null && !check.equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("기존 파일 그대로 사용합니다." + check);
			mentee.setMentee_origin_pic1(check);
		}else {
			if(uploadfile1 != null && !uploadfile1.isEmpty()) { //파일이 변경된 경우
				logger.info("파일이 변경되었습니다." + check);
				String fileName = uploadfile1.getOriginalFilename(); //원래 파일명
				mentee.setMentee_origin_pic1(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile1.transferTo(new File(saveFolder + fileDBName));
				mentee.setMentee_pic1(fileDBName);
			}else { //파일을 선택하지 않은 경우
				logger.info("선택 파일이 없습니다." + check);
				mentee.setMentee_origin_pic1("");
				mentee.setMentee_pic1("");
			}
		}
		
		
		for(int i=0; i<mentee_yoil.length; i++) {
			menteeDate += mentee_yoil[i]+"/"+ mentee_startTime[i]+"/"+mentee_endTime[i];
			if((i+1) < mentee_yoil.length)
				menteeDate += ",";
		}
		mentee.setMentee_date(menteeDate);
		
		
		/*
		 * logger.info(mentee.getUser_id()); logger.info(mentee.getMentee_title());
		 * logger.info(mentee.getSports_name()); logger.info(mentee.getCity());
		 * logger.info(mentee.getSigungu()); logger.info(mentee.getMentee_loc_detail());
		 * logger.info(mentee.getMentee_date()); logger.info("금액 : " +
		 * mentee.getMentee_amount()); logger.info(mentee.getMentee_gender());
		 * logger.info(mentee.getMentee_req());
		 */
		 
		int result = mmatchservice.modifyMenteeWriting(mentee);
		if(result == 1 ) {
			rattr.addFlashAttribute("result","modifySuccess");
			logger.info("멘티 공고글 수정  성공");
			url ="redirect:menteePage";
		}else{
			logger.info("멘티 공고글 수정  실패");
			mv.addAttribute("url",request.getRequestURI());
			mv.addAttribute("message","멘티 공고글 수정 실패");
			url = "error/error";
		}
		return url;
	}
	
	//멘토 작성 글 추가
	@PostMapping("/addWMentor")
	public String addMetorWriting(Mentor mentor,String[] mentor_yoil,
			String[] mentor_startTime,String[] mentor_endTime,
			RedirectAttributes rattr) throws Exception{

		MultipartFile uploadfile1 =mentor.getUploadfile1();
		MultipartFile uploadfile2 =mentor.getUploadfile2();
		MultipartFile uploadfile3 =mentor.getUploadfile3();
		String mentorDate="";
		
		if(!uploadfile1.isEmpty()) {
			String fileName = uploadfile1.getOriginalFilename(); //원래파일명
			mentor.setMentor_origin_pic1(fileName); //원래 파일명 저장
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName1 = " + fileDBName);
			
			//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile1.transferTo(new File(saveFolder+fileDBName));
			
			//바뀐 파일명으로 저장
			mentor.setMentor_pic1(fileDBName);
		}
		
		if(!uploadfile2.isEmpty()) {
			String fileName = uploadfile2.getOriginalFilename(); //원래파일명
			mentor.setMentor_origin_pic2(fileName); //원래 파일명 저장
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName2 = " + fileDBName);
			
			//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile2.transferTo(new File(saveFolder+fileDBName));
			
			//바뀐 파일명으로 저장
			mentor.setMentor_pic2(fileDBName);
		}
		
		if(!uploadfile3.isEmpty()) {
			String fileName = uploadfile3.getOriginalFilename(); //원래파일명
			mentor.setMentor_origin_pic3(fileName); //원래 파일명 저장
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName3 = " + fileDBName);
			
			//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile3.transferTo(new File(saveFolder+fileDBName));
			
			//바뀐 파일명으로 저장
			mentor.setMentor_pic3(fileDBName);
		}
		for(int i=0; i<mentor_yoil.length; i++) {
			mentorDate += mentor_yoil[i]+"/"+ mentor_startTime[i]+"/"+mentor_endTime[i];
			if((i+1) < mentor_yoil.length)
				mentorDate += ",";
		}
		mentor.setMentor_date(mentorDate);
		
		
		/*
		 * logger.info(mentor.getUser_id()); logger.info(mentor.getMentor_title());
		 * logger.info(mentor.getSports_name()); logger.info(mentor.getCity());
		 * logger.info(mentor.getSigungu()); logger.info(mentor.getMentor_loc_detail());
		 * logger.info("금액 : " + mentor.getMentor_amount()); logger.info("인원 : " +
		 * mentor.getMentor_number()); logger.info(mentor.getMentor_caution());
		 * logger.info(mentor.getMentor_career()); logger.info(mentor.getMentor_date());
		 */
		 
		int result = mmatchservice.insertMentorWriting(mentor);
		if(result == 1 ) {
			rattr.addFlashAttribute("result","writeSuccess");
		}
		//Thread.sleep(3000); //2초 대기
		return "redirect:mentorPage";
	}
	
	//멘티 작성 글 추가
	@PostMapping("/addWMentee")
	public String addMetorWriting(Mentee mentee,String[] mentee_yoil,
			String[] mentee_startTime,String[] mentee_endTime,
			RedirectAttributes rattr) throws Exception{

		MultipartFile uploadfile1 =mentee.getUploadfile1();
		String mentorDate="";
		
		if(!uploadfile1.isEmpty()) {
			String fileName = uploadfile1.getOriginalFilename(); //원래파일명
			mentee.setMentee_origin_pic1(fileName); //원래 파일명 저장
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName1 = " + fileDBName);
			
			//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile1.transferTo(new File(saveFolder+fileDBName));
			
			//바뀐 파일명으로 저장
			mentee.setMentee_pic1(fileDBName);
		}
		for(int i=0; i<mentee_yoil.length; i++) {
			mentorDate += mentee_yoil[i]+"/"+ mentee_startTime[i]+"/"+mentee_endTime[i];
			if((i+1) < mentee_yoil.length)
				mentorDate += ",";
		}
		mentee.setMentee_date(mentorDate);
		
		
		/*
		 * logger.info(mentee.getUser_id()); logger.info(mentee.getMentee_title());
		 * logger.info(mentee.getSports_name()); logger.info(mentee.getCity());
		 * logger.info(mentee.getSigungu()); logger.info(mentee.getMentee_loc_detail());
		 * logger.info("금액 : " + mentee.getMentee_amount());
		 * logger.info(mentee.getMentee_req()); logger.info(mentee.getMentee_date());
		 */
		 
		int result = mmatchservice.insertMenteeWriting(mentee);
		if(result == 1 ) {
			rattr.addFlashAttribute("result","writeSuccess");
		}
		//Thread.sleep(3000); //2초 대기
		return "redirect:menteePage";
	}
	//랜덤 파일 이름 저장(동일 파일 이름 관리를 위한)
	private String fileDBName(String fileName , String saveFolder) {
		//새로운 폴더 이름 : 오늘 년+월+일
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		
		String homedir  = saveFolder + year +"-"+month+"-"+date;
		logger.info(homedir);
		File path1 = new File(homedir);
		if(!(path1.exists())) {
			path1.mkdir();
		}
		
		//난수를 구합니다.
		Random r = new Random();
		int random = r.nextInt(100000000);
		
		/* 확장자 구하기 */
		int index = fileName.lastIndexOf(".");
		
		//문자열에서 특정 문자열의 위치 값(index)를 반환합니다.
		//indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
		//lastIndexOf는 마지막에 발견되는 문자열의 index를 반환합니다.
		//(파일명에 점이 여러개 있을 경우 맨마지막에 발견되는 문자열의 위치를 리턴합니다.)
		
		logger.info("index = " + index);
		
		String fileExtension = fileName.substring(index+1);
		logger.info("fileExtension = " + fileExtension);
		
		//새로운 파일 명 
		String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		logger.info("refileName = " + refileName);
		
		//오라클 디비에 저장될 파일 명
		String fileDBName = "/" + year +"-"+month+"-"+date + "/" + refileName;
		logger.info("fileDBName = " + fileDBName);
		return fileDBName;
		
	}
	
	//특정 글 상세보기(멘토)
	@GetMapping("/sportDetail")
	@ResponseBody
	public Mentor Detail(String code){
		return mmatchservice.getMentorDetail(code);
	}
	
	//특정 글 상세보기(멘티)
	@GetMapping("/menteeDetail")
	@ResponseBody
	public Mentee menteeDetail(String code){
		return mmatchservice.getMenteeDetail(code);
	}
	
	//특정 멘토 글 신청하기
	@PostMapping("/ApplyWMentor")
	@ResponseBody
	public int applyWritingMentor(String id,String code){
		int result = mmatchservice.checkApply(id,code);
		if(result == 1) {
			return 0;
		}else {
			return mmatchservice.ApplyMentor(id,code);			
		}
	}
	
	//특정 멘티 글 신청하기
	@PostMapping("/ApplyWMentee")
	@ResponseBody
	public int applyWritingMentee(String id,String code){
		int result = mmatchservice.checkApply(id,code);
		if(result == 1) {
			return 0;
		}else {
			return mmatchservice.ApplyMentee(id,code);			
		}
	}
	//특정 멘토글 삭제하기
	@PostMapping("/delWMentor")
	@ResponseBody
	public int deleteWritingMentor(String code){
		int result = mmatchservice.deleteMentor(code);
		MatchInfo matchInfo = new MatchInfo();
		matchInfo.setMatch_code(code);
		matchInfo.setMatch_state(3);
		if(result == 1) {
			//해당글에 신청한 유저(1)들에게 신청 거절상태(3)로 변경
			mmatchservice.changeApplyState(matchInfo);
		}
		return result;
	}
	//특정 멘티글 삭제하기
	@PostMapping("/delWMentee")
	@ResponseBody
	public int deleteWritingMentee(String code){
		int result = mmatchservice.deleteMentee(code);
		MatchInfo matchInfo = new MatchInfo();
		matchInfo.setMatch_code(code);
		matchInfo.setMatch_state(3);
		if(result == 1) {
			//해당글에 신청한 유저(1)들에게 신청 거절상태(3)로 변경
			mmatchservice.changeApplyState(matchInfo);
		}
		return result;
	}
	
	//특정 멘토 글 수정 페이지 이동
	@GetMapping("/mentorModify")
	public ModelAndView mentorModify(String code,ModelAndView mv,HttpServletRequest request) {
		Mentor mentordata = mmatchservice.getMentorDetail(code);	
		if(mentordata==null) {
			//에러처리
			logger.info("mentor_modify_view 실패");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURI());
			mv.addObject("message","멘토공고글 수정 뷰 실패입니다.");
		}else {
			logger.info("mentor_modify_view 성공");
			mv.setViewName("sport_menMatch/sports_mentor_modify");
			mv.addObject("mentordata",mentordata);
		}
		return mv;
	}	
	
	//특정 멘티 글 수정 페이지 이동
	@GetMapping("/menteeModify")
	public ModelAndView menteeModify(String code,ModelAndView mv,HttpServletRequest request) {
		Mentee menteedata = mmatchservice.getMenteeDetail(code);	
		if(menteedata==null) {
			//에러처리
			logger.info("mentee_modify_view 실패");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURI());
			mv.addObject("message","멘티 공고글 수정 뷰 실패입니다.");
		}else {
			logger.info("mentee_modify_view 성공");
			mv.setViewName("sport_menMatch/sports_mentee_modify");
			mv.addObject("menteedata",menteedata);
		}
		return mv;
	}	
	
	//sport 종목 가져오기(이름만)
	@GetMapping("/getsubjectList")
	@ResponseBody
	public Map<String,Object> getSubjectList(String subject) {
		int seltype = mmatchservice.getSport(subject);
		List<String> list = mmatchservice.getSportlist(seltype);
		
		logger.info("getSubjectList :" + subject);
		logger.info("getSubjectList :" +seltype);
	    Map<String,Object> map = new HashMap<String,Object>();
	    map.put("list",list);
	    map.put("seltype",seltype);
		return map;
	}
	
	//마이페이지의 멘토 글 리스트 보기
	@RequestMapping(value = "/mmwriteList", method = RequestMethod.GET)
	public ModelAndView MypageMentorlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount1 = mmatchservice.getMyMentorListCount(id); //총 리스트 수를 받아옴
	    int listcount2 = mmatchservice.getMyMenteeListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage1 = (listcount1 + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage1 = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage1 = startpage1 + 10 -1;
	    
	    if(endpage1 > maxpage1)
	    	endpage1 = maxpage1;
	    
	    
	    //총 페이지 수
	    int maxpage2 = (listcount2 + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage2 = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage2 = startpage2 + 10 -1;
	    
	    if(endpage2 > maxpage2)
	    	endpage2 = maxpage2;
	    
	    List<Mentor> mentorlist = mmatchservice.getMyMentorList(page,limit,id); //리스트를 받아옴
	    List<Mentee> menteelist = mmatchservice.getMyMenteeList(page, limit,id); //리스트를 받아옴
	    
	    mv.setViewName("sports_mypage/mypage_mymmwritelist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage1",maxpage1);
	    mv.addObject("startpage1",startpage1);
	    mv.addObject("endpage1",endpage1);
	    mv.addObject("listcount1",listcount1);
	    mv.addObject("maxpage2",maxpage2);
	    mv.addObject("startpage2",startpage2);
	    mv.addObject("endpage2",endpage2);
	    mv.addObject("listcount2",listcount2);
	    mv.addObject("mentorlist",mentorlist);
	    mv.addObject("menteelist",menteelist);
	    mv.addObject("saveFolder",saveFolder);
		
		return mv;
	}
	
/*	
	//마이페이지의 멘토 글 리스트 보기
	@RequestMapping(value = "/mentorwriteList", method = RequestMethod.GET)
	public ModelAndView MypageMentorlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount = mmatchservice.getMyMentorListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getMyMentorList(page,limit,id); //리스트를 받아옴
	    mv.setViewName("sports_mypage/mypage_mentorwritelist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("mentorlist",mentorlist);
	    mv.addObject("saveFolder",saveFolder);

		return mv;
	}
*/
/*
	//마이페이지의 멘티 글 리스트 보기
	@RequestMapping(value = "/menteewriteList", method = RequestMethod.GET)
	public ModelAndView MypageMenteelist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getMyMenteeList(page, limit,id); //리스트를 받아옴
	   
	    mv.setViewName("sports_mypage/mypage_menteewritelist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("menteelist",menteelist);
	    mv.addObject("saveFolder",saveFolder);

		return mv;
	}
*/	
	
	//마이페이지의 신청 글 리스트 보기(ajax)
	@RequestMapping(value = "/mentorwriteList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMentorlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getMyMentorList(page, limit,id); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("mentorlist",mentorlist);
	    map.put("saveFolder",saveFolder);
		/*
		 * logger.info("page : " +page); logger.info("maxpage : " +maxpage);
		 * logger.info("startpage : " +startpage); logger.info("endpage : " +endpage);
		 * logger.info("listcount : " +listcount); for(Mentor m : mentorlist) {
		 * logger.info("사진 : " +m.getMentor_pic1()); logger.info("종목 : "
		 * +m.getSports_name()); logger.info("시 : " +m.getCity()); logger.info("군구 : "
		 * +m.getSigungu()); logger.info("인원 : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
	    return map;
	}
	
	//마이페이지의 멘티 글 리스트 보기(ajax)
	@RequestMapping(value = "/menteewriteList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMenteelistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getMyMenteeList(page, limit,id); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("menteelist",menteelist);
	    map.put("saveFolder",saveFolder);
	    return map;
	}
	
	
	//마이페이지의 신청 리스트 보기(멘토/멘티 글 신청)
	@RequestMapping(value = "/mmApplyList", method = RequestMethod.GET)
	public ModelAndView MypageMentorApplylist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount1 = mmatchservice.getMyMentorAppListCount(id); //총 리스트 수를 받아옴
	    int listcount2 = mmatchservice.getMyMenteeAppListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage1 = (listcount1 + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage1 = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage1 = startpage1 + 10 -1;
	    
	    if(endpage1 > maxpage1)
	    	endpage1 = maxpage1;
	    
	    
	    //총 페이지 수
	    int maxpage2 = (listcount2 + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage2 = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage2 = startpage2 + 10 -1;
	    
	    if(endpage2 > maxpage2)
	    	endpage2 = maxpage2;
	    
	    List<MatchAppReq> mentorApplylist = mmatchservice.getMyMentorAppList(page,limit,id); //리스트를 받아옴
	    List<MatchAppReq> menteeApplylist = mmatchservice.getMyMenteeAppList(page, limit,id); //리스트를 받아옴
	    
	    mv.setViewName("sports_mypage/mypage_mymmApplist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage1",maxpage1);
	    mv.addObject("startpage1",startpage1);
	    mv.addObject("endpage1",endpage1);
	    mv.addObject("listcount1",listcount1);
	    mv.addObject("maxpage2",maxpage2);
	    mv.addObject("startpage2",startpage2);
	    mv.addObject("endpage2",endpage2);
	    mv.addObject("listcount2",listcount2);
	    mv.addObject("mentorApplylist",mentorApplylist);
	    mv.addObject("menteeApplylist",menteeApplylist);
		return mv;
	}
	
	
	/*
	//마이페이지의 신청 리스트 보기(멘토글 신청)
	@RequestMapping(value = "/mentorApplyList", method = RequestMethod.GET)
	public ModelAndView MypageMentorApplylist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorAppListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> applylist = mmatchservice.getMyMentorAppList(page, limit,id); //리스트를 받아옴
	   
	    mv.setViewName("sports_mypage/mypage_myMentorApplylist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("applylist",applylist);
		return mv;
	}
	*/
	
	//마이페이지의 요청 글 리스트 보기(멘토글 신청 ajax)
	@RequestMapping(value = "/mentorApplyList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMentorApplylistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorAppListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> applylist = mmatchservice.getMyMentorAppList(page, limit,id); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("applylist",applylist);
	    return map;
	}
	/*
	//마이페이지의 신청 리스트 보기(멘글에 대한 신청)
	@RequestMapping(value = "/menteeApplyList", method = RequestMethod.GET)
	public ModelAndView MypageMenteeApplylist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeAppListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> applylist = mmatchservice.getMyMenteeAppList(page, limit,id); //리스트를 받아옴
	   
	    mv.setViewName("sports_mypage/mypage_myMenteeApplylist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("applylist",applylist);
		return mv;
	}
	*/
	//마이페이지의 신청 글 리스트 보기(멘티글 신청 ajax)
	@RequestMapping(value = "/menteeApplyList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMenteeApplylistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeAppListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> applylist = mmatchservice.getMyMenteeAppList(page, limit,id); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("applylist",applylist);
	    return map;
	}
	
	//신청 취소(신청 요청 테이블 열 삭제)
	@PostMapping("/cancelApply")
	@ResponseBody
	public int cancelApply(String code,HttpSession session){
		String id =(String)session.getAttribute("USER_ID");
		int result = mmatchservice.cancelApply(code,id);
		return result;
	}
	//마이페이지의 요청 리스트 보기(멘토/멘티 글 신청)
	@RequestMapping(value = "/mmReqList", method = RequestMethod.GET)
	public ModelAndView MypageMentorReqlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount1 = mmatchservice.getMyMentorReqListCount(id); //총 리스트 수를 받아옴
	    int listcount2 = mmatchservice.getMyMenteeReqListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage1 = (listcount1 + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage1 = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage1 = startpage1 + 10 -1;
	    
	    if(endpage1 > maxpage1)
	    	endpage1 = maxpage1;
	    
	    
	    //총 페이지 수
	    int maxpage2 = (listcount2 + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage2 = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage2 = startpage2 + 10 -1;
	    
	    if(endpage2 > maxpage2)
	    	endpage2 = maxpage2;
	    
	    List<MatchAppReq> mentorReqlylist = mmatchservice.getMyMentorReqList(page,limit,id); //리스트를 받아옴
	    List<MatchAppReq> menteeReqlylist = mmatchservice.getMyMenteeReqList(page, limit,id); //리스트를 받아옴
	    
	    mv.setViewName("sports_mypage/mypage_mymmReqlist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage1",maxpage1);
	    mv.addObject("startpage1",startpage1);
	    mv.addObject("endpage1",endpage1);
	    mv.addObject("listcount1",listcount1);
	    mv.addObject("maxpage2",maxpage2);
	    mv.addObject("startpage2",startpage2);
	    mv.addObject("endpage2",endpage2);
	    mv.addObject("listcount2",listcount2);
	    mv.addObject("mentorReqlylist",mentorReqlylist);
	    mv.addObject("menteeReqlylist",menteeReqlylist);
		return mv;
	}
	
	
/*
	//마이페이지의  내게 한 요청 리스트 보기(내가쓴 멘토글에 대한 요청 )
	@RequestMapping(value = "/mentorReqList", method = RequestMethod.GET)
	public ModelAndView MypageMentorReqlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorReqListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> reqlist = mmatchservice.getMyMentorReqList(page, limit,id); //리스트를 받아옴
	   
	    mv.setViewName("sports_mypage/mypage_myMentorReqlist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("reqlist",reqlist);
		return mv;
	}
	*/
	//마이페이지의 내게 한 요청 리스트 보기(내가쓴 멘토글에 대한 요청 ajax)
	@RequestMapping(value = "/mentorReqList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMentorReqlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorReqListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> reqlist = mmatchservice.getMyMentorReqList(page, limit,id); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("reqlist",reqlist);
	    return map;
	}
/*	
	//마이페이지의 내게 한 요청 리스트 보기(내가쓴 멘티글에 대한 요청)
	@RequestMapping(value = "/menteeReqList", method = RequestMethod.GET)
	public ModelAndView MypageMenteeReqlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeReqListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> reqlist = mmatchservice.getMyMenteeReqList(page, limit,id); //리스트를 받아옴
	   
	    mv.setViewName("sports_mypage/mypage_myMenteeReqlist");
	    mv.addObject("page",page);
	    mv.addObject("maxpage",maxpage);
	    mv.addObject("startpage",startpage);
	    mv.addObject("endpage",endpage);
	    mv.addObject("listcount",listcount);
	    mv.addObject("reqlist",reqlist);
		return mv;
	}
	*/
	//마이페이지의  내게 한 요청 리스트 보기(내가쓴 멘티글에 대한 요청 ajax)
	@RequestMapping(value = "/menteeReqList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMenteeReqlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeReqListCount(id); //총 리스트 수를 받아옴
	    //총 페이지 수
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //현재 페이지에 보여줄 시작 페이지 수 (1,11,21 등등)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //현재 페이지에 보내줄 마지막 페이지 수 (10,20.30 등등)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> reqlist = mmatchservice.getMyMenteeReqList(page, limit,id); //리스트를 받아옴
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("reqlist",reqlist);
	    return map;
	}
	//요청에 대한 대답 처리 (수락/거절)
	@PostMapping("/responsRequest")
	@ResponseBody
	public int responseRequest(int state,String code,String id,String tel){
		MatchInfo matchInfo = new MatchInfo();
		SendSms sms =new SendSms();
		String message="";
		matchInfo.setMatch_state(state);
		matchInfo.setMatch_code(code);
		matchInfo.setUser_id(id);
		if(state == 2) {
			message=id+"님의 멘티/멘토 매칭 신청이 거절되었습니다.(상세 내용은 웹확인)";
		}else if(state ==3){
			message=id+"님의 멘티/멘토 매칭 신청이 수락되었습니다.(상세 내용은 웹확인)";
		}
		//유료 서비스라 테스트 아닐떄는 주석 처리
		//sms.sendSmsData(tel, message);
	    return mmatchservice.changeApplyState(matchInfo);
	}
}
