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

	//���� �� �ۼ�
	@RequestMapping(value = "/mentorWrite", method = RequestMethod.GET)
	public String mentorWrite() {
		return "sport_menMatch/sports_mentor_write";
	}
		
	//���� �� �ۼ�
	@RequestMapping(value = "/menteeWrite", method = RequestMethod.GET)
	public String menteeWrite() {
		return "sport_menMatch/sports_mentee_write";
	}
	
	//���� �� ����Ʈ ����
	@RequestMapping(value = "/mentorPage", method = RequestMethod.GET)
	public ModelAndView mentorlist(
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			ModelAndView mv)
	{
	    int listcount = mmatchservice.getMentorListCount(); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getMentorList(page, limit); //����Ʈ�� �޾ƿ�
	    
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
		 * logger.info("���� : " +m.getMentor_pic1()); logger.info("���� : "
		 * +m.getSports_name()); logger.info("�� : " +m.getCity()); logger.info("���� : "
		 * +m.getSigungu()); logger.info("�ο� : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
		return mv;
	}
	
	//��Ƽ �� ����Ʈ ����
	@RequestMapping(value = "/menteePage", method = RequestMethod.GET)
	public ModelAndView menteelist(
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			ModelAndView mv)
	{
	    int listcount = mmatchservice.getMenteeListCount(); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getMenteeList(page, limit); //����Ʈ�� �޾ƿ�
	    
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
		 * logger.info("���� : " +m.getMentee_pic1());
		 * logger.info("���� : "+m.getSports_name()); logger.info("�� : " +m.getCity());
		 * logger.info("���� : "+m.getSigungu()); logger.info("code: " +
		 * m.getMentee_code()); } logger.info("saveFolder : " +saveFolder);
		 */
		 
		 
		return mv;
	}
	
	
	//���� �� ����Ʈ ����(ajax)
	@RequestMapping(value = "/mentorPage_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> mentorlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="search_field" ,defaultValue="") String search_field,
			@RequestParam(value="search_word" ,defaultValue="") String search_word)
	{
	    
	    int listcount = mmatchservice.getSearchMentorListCount(search_field,search_word); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getSearchMentorList(page, limit,search_field,search_word); //����Ʈ�� �޾ƿ�
	    
	    
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
		 * logger.info("���� : " +m.getMentor_pic1()); logger.info("���� : "
		 * +m.getSports_name()); logger.info("�� : " +m.getCity()); logger.info("���� : "
		 * +m.getSigungu()); logger.info("�ο� : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
	    return map;
	}
	
	//��Ƽ �� ����Ʈ ����(ajax)
	@RequestMapping(value = "/menteePage_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> menteelistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="6", required=false) int limit,
			@RequestParam(value="search_field" ,defaultValue="") String search_field,
			@RequestParam(value="search_word" ,defaultValue="") String search_word)
	{
	    int listcount = mmatchservice.getSearchMenteeListCount(search_field,search_word); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getSearchMenteeList(page, limit,search_field,search_word); //����Ʈ�� �޾ƿ�
	    
	    
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
		 * logger.info("���� : " +m.getMentor_pic1()); logger.info("���� : "
		 * +m.getSports_name()); logger.info("�� : " +m.getCity()); logger.info("���� : "
		 * +m.getSigungu()); logger.info("�ο� : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
	    return map;
	}
	//sport ���� ��������(�̸���)
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
	
	//sport ���� ��������(�̸�,img ������ response)
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
	
	//�ּ�(��) ���� ��������
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
	
	//�ּ�(��) ���� ��������
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
	
	//����� ���� ����
	@PostMapping("/mentorModifyAction")
	public String mentorModifyAction(Mentor mentor,String[] mentor_yoil,
			String[] mentor_startTime,String[] mentor_endTime,String[] check,
			RedirectAttributes rattr,Model mv,HttpServletRequest request) throws Exception{

		MultipartFile uploadfile1 =mentor.getUploadfile1();
		MultipartFile uploadfile2 =mentor.getUploadfile2();
		MultipartFile uploadfile3 =mentor.getUploadfile3();
		String mentorDate="";
		String url="";
		//1.���� ���� : ''
		//2.�������� �״�� : '���������̸�'
		//3.���� ���� : 'no'
		
		if(!check[0].equals("no") && !check[0].equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("1�� ���� : ���� ���� �״�� ����մϴ�." + check[0]);
			mentor.setMentor_origin_pic1(check[0]);
		}else {
			if(uploadfile1 != null && !uploadfile1.isEmpty()) { //������ ����� ���
				logger.info("1�� ������ ����Ǿ����ϴ�." + check[0]);
				String fileName = uploadfile1.getOriginalFilename(); //���� ���ϸ�
				mentor.setMentor_origin_pic1(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile1.transferTo(new File(saveFolder + fileDBName));
				mentor.setMentor_pic1(fileDBName);
			}else { //������ �������� ���� ���
				logger.info("1�� ���� ������ �����ϴ�." + check[0]);
				mentor.setMentor_origin_pic1("");
				mentor.setMentor_pic1("");
			}
		}
		
		if(!check[1].equals("no") && !check[1].equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("2�� ���� : ���� ���� �״�� ����մϴ�." + check[1]);
			mentor.setMentor_origin_pic2(check[1]);
		}else {
			if(uploadfile2 != null && !uploadfile2.isEmpty()) { //������ ����� ���
				logger.info("2�� ������ ����Ǿ����ϴ�." + check[1]);
				String fileName = uploadfile2.getOriginalFilename(); //���� ���ϸ�
				mentor.setMentor_origin_pic2(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile2.transferTo(new File(saveFolder + fileDBName));
				mentor.setMentor_pic2(fileDBName);
			}else { //������ �������� ���� ���
				logger.info("2�� ���� ������ �����ϴ�." + check[1]);
				mentor.setMentor_origin_pic2("");
				mentor.setMentor_pic2("");
			}
		}
		
		if(!check[2].equals("no") && !check[2].equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("3�� ���� : ���� ���� �״�� ����մϴ�." + check[2]);
			mentor.setMentor_origin_pic3(check[2]);
		}else {
			if(uploadfile3 != null && !uploadfile3.isEmpty()) { //������ ����� ���
				logger.info("3�� ������ ����Ǿ����ϴ�." + check[2]);
				String fileName = uploadfile3.getOriginalFilename(); //���� ���ϸ�
				mentor.setMentor_origin_pic3(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile3.transferTo(new File(saveFolder + fileDBName));
				mentor.setMentor_pic3(fileDBName);
			}else { //������ �������� ���� ���
				logger.info("3�� ���� ������ �����ϴ�." + check[2]);
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
		  logger.info("�ݾ� : " + mentor.getMentor_amount()); logger.info("�ο� : " +
		  mentor.getMentor_number()); logger.info(mentor.getMentor_caution());
		  logger.info(mentor.getMentor_career()); logger.info(mentor.getMentor_date());
		 
		int result = mmatchservice.modifyMentorWriting(mentor);
		if(result == 1 ) {
			logger.info("���� ����� ����  ����");
			url ="redirect:mentorPage";
			rattr.addFlashAttribute("result","modifySuccess");
		}else{
			logger.info("���� ����� ����  ����");
			mv.addAttribute("url",request.getRequestURI());
			mv.addAttribute("message","���� ����� ���� ����");
			url = "error/error";
		}
		return url;
	}
	
	//��Ƽ�� ���� ����
	@PostMapping("/menteeModifyAction")
	public String menteeModifyAction(Mentee mentee,String[] mentee_yoil,
			String[] mentee_startTime,String[] mentee_endTime,String check,
			RedirectAttributes rattr,Model mv,HttpServletRequest request) throws Exception{

		MultipartFile uploadfile1 =mentee.getUploadfile1();
		String menteeDate="";
		String url="";
		//1.���� ���� : ''
		//2.�������� �״�� : '���������̸�'
		//3.���� ���� : '���������̸�'
		if(check !=null && !check.equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("���� ���� �״�� ����մϴ�." + check);
			mentee.setMentee_origin_pic1(check);
		}else {
			if(uploadfile1 != null && !uploadfile1.isEmpty()) { //������ ����� ���
				logger.info("������ ����Ǿ����ϴ�." + check);
				String fileName = uploadfile1.getOriginalFilename(); //���� ���ϸ�
				mentee.setMentee_origin_pic1(fileName);
				String fileDBName = fileDBName(fileName, saveFolder);
				uploadfile1.transferTo(new File(saveFolder + fileDBName));
				mentee.setMentee_pic1(fileDBName);
			}else { //������ �������� ���� ���
				logger.info("���� ������ �����ϴ�." + check);
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
		 * logger.info(mentee.getMentee_date()); logger.info("�ݾ� : " +
		 * mentee.getMentee_amount()); logger.info(mentee.getMentee_gender());
		 * logger.info(mentee.getMentee_req());
		 */
		 
		int result = mmatchservice.modifyMenteeWriting(mentee);
		if(result == 1 ) {
			rattr.addFlashAttribute("result","modifySuccess");
			logger.info("��Ƽ ����� ����  ����");
			url ="redirect:menteePage";
		}else{
			logger.info("��Ƽ ����� ����  ����");
			mv.addAttribute("url",request.getRequestURI());
			mv.addAttribute("message","��Ƽ ����� ���� ����");
			url = "error/error";
		}
		return url;
	}
	
	//���� �ۼ� �� �߰�
	@PostMapping("/addWMentor")
	public String addMetorWriting(Mentor mentor,String[] mentor_yoil,
			String[] mentor_startTime,String[] mentor_endTime,
			RedirectAttributes rattr) throws Exception{

		MultipartFile uploadfile1 =mentor.getUploadfile1();
		MultipartFile uploadfile2 =mentor.getUploadfile2();
		MultipartFile uploadfile3 =mentor.getUploadfile3();
		String mentorDate="";
		
		if(!uploadfile1.isEmpty()) {
			String fileName = uploadfile1.getOriginalFilename(); //�������ϸ�
			mentor.setMentor_origin_pic1(fileName); //���� ���ϸ� ����
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName1 = " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile1.transferTo(new File(saveFolder+fileDBName));
			
			//�ٲ� ���ϸ����� ����
			mentor.setMentor_pic1(fileDBName);
		}
		
		if(!uploadfile2.isEmpty()) {
			String fileName = uploadfile2.getOriginalFilename(); //�������ϸ�
			mentor.setMentor_origin_pic2(fileName); //���� ���ϸ� ����
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName2 = " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile2.transferTo(new File(saveFolder+fileDBName));
			
			//�ٲ� ���ϸ����� ����
			mentor.setMentor_pic2(fileDBName);
		}
		
		if(!uploadfile3.isEmpty()) {
			String fileName = uploadfile3.getOriginalFilename(); //�������ϸ�
			mentor.setMentor_origin_pic3(fileName); //���� ���ϸ� ����
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName3 = " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile3.transferTo(new File(saveFolder+fileDBName));
			
			//�ٲ� ���ϸ����� ����
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
		 * logger.info("�ݾ� : " + mentor.getMentor_amount()); logger.info("�ο� : " +
		 * mentor.getMentor_number()); logger.info(mentor.getMentor_caution());
		 * logger.info(mentor.getMentor_career()); logger.info(mentor.getMentor_date());
		 */
		 
		int result = mmatchservice.insertMentorWriting(mentor);
		if(result == 1 ) {
			rattr.addFlashAttribute("result","writeSuccess");
		}
		//Thread.sleep(3000); //2�� ���
		return "redirect:mentorPage";
	}
	
	//��Ƽ �ۼ� �� �߰�
	@PostMapping("/addWMentee")
	public String addMetorWriting(Mentee mentee,String[] mentee_yoil,
			String[] mentee_startTime,String[] mentee_endTime,
			RedirectAttributes rattr) throws Exception{

		MultipartFile uploadfile1 =mentee.getUploadfile1();
		String mentorDate="";
		
		if(!uploadfile1.isEmpty()) {
			String fileName = uploadfile1.getOriginalFilename(); //�������ϸ�
			mentee.setMentee_origin_pic1(fileName); //���� ���ϸ� ����
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName1 = " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile1.transferTo(new File(saveFolder+fileDBName));
			
			//�ٲ� ���ϸ����� ����
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
		 * logger.info("�ݾ� : " + mentee.getMentee_amount());
		 * logger.info(mentee.getMentee_req()); logger.info(mentee.getMentee_date());
		 */
		 
		int result = mmatchservice.insertMenteeWriting(mentee);
		if(result == 1 ) {
			rattr.addFlashAttribute("result","writeSuccess");
		}
		//Thread.sleep(3000); //2�� ���
		return "redirect:menteePage";
	}
	//���� ���� �̸� ����(���� ���� �̸� ������ ����)
	private String fileDBName(String fileName , String saveFolder) {
		//���ο� ���� �̸� : ���� ��+��+��
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
		
		//������ ���մϴ�.
		Random r = new Random();
		int random = r.nextInt(100000000);
		
		/* Ȯ���� ���ϱ� */
		int index = fileName.lastIndexOf(".");
		
		//���ڿ����� Ư�� ���ڿ��� ��ġ ��(index)�� ��ȯ�մϴ�.
		//indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�,
		//lastIndexOf�� �������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�.
		//(���ϸ� ���� ������ ���� ��� �Ǹ������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
		
		logger.info("index = " + index);
		
		String fileExtension = fileName.substring(index+1);
		logger.info("fileExtension = " + fileExtension);
		
		//���ο� ���� �� 
		String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		logger.info("refileName = " + refileName);
		
		//����Ŭ ��� ����� ���� ��
		String fileDBName = "/" + year +"-"+month+"-"+date + "/" + refileName;
		logger.info("fileDBName = " + fileDBName);
		return fileDBName;
		
	}
	
	//Ư�� �� �󼼺���(����)
	@GetMapping("/sportDetail")
	@ResponseBody
	public Mentor Detail(String code){
		return mmatchservice.getMentorDetail(code);
	}
	
	//Ư�� �� �󼼺���(��Ƽ)
	@GetMapping("/menteeDetail")
	@ResponseBody
	public Mentee menteeDetail(String code){
		return mmatchservice.getMenteeDetail(code);
	}
	
	//Ư�� ���� �� ��û�ϱ�
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
	
	//Ư�� ��Ƽ �� ��û�ϱ�
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
	//Ư�� ����� �����ϱ�
	@PostMapping("/delWMentor")
	@ResponseBody
	public int deleteWritingMentor(String code){
		int result = mmatchservice.deleteMentor(code);
		MatchInfo matchInfo = new MatchInfo();
		matchInfo.setMatch_code(code);
		matchInfo.setMatch_state(3);
		if(result == 1) {
			//�ش�ۿ� ��û�� ����(1)�鿡�� ��û ��������(3)�� ����
			mmatchservice.changeApplyState(matchInfo);
		}
		return result;
	}
	//Ư�� ��Ƽ�� �����ϱ�
	@PostMapping("/delWMentee")
	@ResponseBody
	public int deleteWritingMentee(String code){
		int result = mmatchservice.deleteMentee(code);
		MatchInfo matchInfo = new MatchInfo();
		matchInfo.setMatch_code(code);
		matchInfo.setMatch_state(3);
		if(result == 1) {
			//�ش�ۿ� ��û�� ����(1)�鿡�� ��û ��������(3)�� ����
			mmatchservice.changeApplyState(matchInfo);
		}
		return result;
	}
	
	//Ư�� ���� �� ���� ������ �̵�
	@GetMapping("/mentorModify")
	public ModelAndView mentorModify(String code,ModelAndView mv,HttpServletRequest request) {
		Mentor mentordata = mmatchservice.getMentorDetail(code);	
		if(mentordata==null) {
			//����ó��
			logger.info("mentor_modify_view ����");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURI());
			mv.addObject("message","�������� ���� �� �����Դϴ�.");
		}else {
			logger.info("mentor_modify_view ����");
			mv.setViewName("sport_menMatch/sports_mentor_modify");
			mv.addObject("mentordata",mentordata);
		}
		return mv;
	}	
	
	//Ư�� ��Ƽ �� ���� ������ �̵�
	@GetMapping("/menteeModify")
	public ModelAndView menteeModify(String code,ModelAndView mv,HttpServletRequest request) {
		Mentee menteedata = mmatchservice.getMenteeDetail(code);	
		if(menteedata==null) {
			//����ó��
			logger.info("mentee_modify_view ����");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURI());
			mv.addObject("message","��Ƽ ����� ���� �� �����Դϴ�.");
		}else {
			logger.info("mentee_modify_view ����");
			mv.setViewName("sport_menMatch/sports_mentee_modify");
			mv.addObject("menteedata",menteedata);
		}
		return mv;
	}	
	
	//sport ���� ��������(�̸���)
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
	
	//������������ ���� �� ����Ʈ ����
	@RequestMapping(value = "/mmwriteList", method = RequestMethod.GET)
	public ModelAndView MypageMentorlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount1 = mmatchservice.getMyMentorListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    int listcount2 = mmatchservice.getMyMenteeListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage1 = (listcount1 + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage1 = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage1 = startpage1 + 10 -1;
	    
	    if(endpage1 > maxpage1)
	    	endpage1 = maxpage1;
	    
	    
	    //�� ������ ��
	    int maxpage2 = (listcount2 + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage2 = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage2 = startpage2 + 10 -1;
	    
	    if(endpage2 > maxpage2)
	    	endpage2 = maxpage2;
	    
	    List<Mentor> mentorlist = mmatchservice.getMyMentorList(page,limit,id); //����Ʈ�� �޾ƿ�
	    List<Mentee> menteelist = mmatchservice.getMyMenteeList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
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
	//������������ ���� �� ����Ʈ ����
	@RequestMapping(value = "/mentorwriteList", method = RequestMethod.GET)
	public ModelAndView MypageMentorlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount = mmatchservice.getMyMentorListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getMyMentorList(page,limit,id); //����Ʈ�� �޾ƿ�
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
	//������������ ��Ƽ �� ����Ʈ ����
	@RequestMapping(value = "/menteewriteList", method = RequestMethod.GET)
	public ModelAndView MypageMenteelist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getMyMenteeList(page, limit,id); //����Ʈ�� �޾ƿ�
	   
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
	
	//������������ ��û �� ����Ʈ ����(ajax)
	@RequestMapping(value = "/mentorwriteList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMentorlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentor> mentorlist = mmatchservice.getMyMentorList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
	    
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
		 * logger.info("���� : " +m.getMentor_pic1()); logger.info("���� : "
		 * +m.getSports_name()); logger.info("�� : " +m.getCity()); logger.info("���� : "
		 * +m.getSigungu()); logger.info("�ο� : " +m.getMentor_number()); }
		 * logger.info("saveFolder : " +saveFolder);
		 */
	    return map;
	}
	
	//������������ ��Ƽ �� ����Ʈ ����(ajax)
	@RequestMapping(value = "/menteewriteList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMenteelistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<Mentee> menteelist = mmatchservice.getMyMenteeList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
	    
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
	
	
	//������������ ��û ����Ʈ ����(����/��Ƽ �� ��û)
	@RequestMapping(value = "/mmApplyList", method = RequestMethod.GET)
	public ModelAndView MypageMentorApplylist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount1 = mmatchservice.getMyMentorAppListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    int listcount2 = mmatchservice.getMyMenteeAppListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage1 = (listcount1 + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage1 = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage1 = startpage1 + 10 -1;
	    
	    if(endpage1 > maxpage1)
	    	endpage1 = maxpage1;
	    
	    
	    //�� ������ ��
	    int maxpage2 = (listcount2 + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage2 = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage2 = startpage2 + 10 -1;
	    
	    if(endpage2 > maxpage2)
	    	endpage2 = maxpage2;
	    
	    List<MatchAppReq> mentorApplylist = mmatchservice.getMyMentorAppList(page,limit,id); //����Ʈ�� �޾ƿ�
	    List<MatchAppReq> menteeApplylist = mmatchservice.getMyMenteeAppList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
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
	//������������ ��û ����Ʈ ����(����� ��û)
	@RequestMapping(value = "/mentorApplyList", method = RequestMethod.GET)
	public ModelAndView MypageMentorApplylist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorAppListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> applylist = mmatchservice.getMyMentorAppList(page, limit,id); //����Ʈ�� �޾ƿ�
	   
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
	
	//������������ ��û �� ����Ʈ ����(����� ��û ajax)
	@RequestMapping(value = "/mentorApplyList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMentorApplylistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorAppListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> applylist = mmatchservice.getMyMentorAppList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
	    
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
	//������������ ��û ����Ʈ ����(��ۿ� ���� ��û)
	@RequestMapping(value = "/menteeApplyList", method = RequestMethod.GET)
	public ModelAndView MypageMenteeApplylist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeAppListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> applylist = mmatchservice.getMyMenteeAppList(page, limit,id); //����Ʈ�� �޾ƿ�
	   
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
	//������������ ��û �� ����Ʈ ����(��Ƽ�� ��û ajax)
	@RequestMapping(value = "/menteeApplyList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMenteeApplylistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeAppListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> applylist = mmatchservice.getMyMenteeAppList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("applylist",applylist);
	    return map;
	}
	
	//��û ���(��û ��û ���̺� �� ����)
	@PostMapping("/cancelApply")
	@ResponseBody
	public int cancelApply(String code,HttpSession session){
		String id =(String)session.getAttribute("USER_ID");
		int result = mmatchservice.cancelApply(code,id);
		return result;
	}
	//������������ ��û ����Ʈ ����(����/��Ƽ �� ��û)
	@RequestMapping(value = "/mmReqList", method = RequestMethod.GET)
	public ModelAndView MypageMentorReqlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
		logger.info("user id : " + id);
	    int listcount1 = mmatchservice.getMyMentorReqListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    int listcount2 = mmatchservice.getMyMenteeReqListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage1 = (listcount1 + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage1 = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage1 = startpage1 + 10 -1;
	    
	    if(endpage1 > maxpage1)
	    	endpage1 = maxpage1;
	    
	    
	    //�� ������ ��
	    int maxpage2 = (listcount2 + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage2 = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage2 = startpage2 + 10 -1;
	    
	    if(endpage2 > maxpage2)
	    	endpage2 = maxpage2;
	    
	    List<MatchAppReq> mentorReqlylist = mmatchservice.getMyMentorReqList(page,limit,id); //����Ʈ�� �޾ƿ�
	    List<MatchAppReq> menteeReqlylist = mmatchservice.getMyMenteeReqList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
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
	//������������  ���� �� ��û ����Ʈ ����(������ ����ۿ� ���� ��û )
	@RequestMapping(value = "/mentorReqList", method = RequestMethod.GET)
	public ModelAndView MypageMentorReqlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorReqListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> reqlist = mmatchservice.getMyMentorReqList(page, limit,id); //����Ʈ�� �޾ƿ�
	   
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
	//������������ ���� �� ��û ����Ʈ ����(������ ����ۿ� ���� ��û ajax)
	@RequestMapping(value = "/mentorReqList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMentorReqlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMentorReqListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> reqlist = mmatchservice.getMyMentorReqList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
	    
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
	//������������ ���� �� ��û ����Ʈ ����(������ ��Ƽ�ۿ� ���� ��û)
	@RequestMapping(value = "/menteeReqList", method = RequestMethod.GET)
	public ModelAndView MypageMenteeReqlist(
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			@RequestParam(value="page" ,defaultValue="1", required=false) int page,
			HttpSession session,
			ModelAndView mv)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeReqListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;

	    List<MatchAppReq> reqlist = mmatchservice.getMyMenteeReqList(page, limit,id); //����Ʈ�� �޾ƿ�
	   
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
	//������������  ���� �� ��û ����Ʈ ����(������ ��Ƽ�ۿ� ���� ��û ajax)
	@RequestMapping(value = "/menteeReqList_ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> MypageMenteeReqlistAjax(int page,
			@RequestParam(value="limit" ,defaultValue="4", required=false) int limit,
			HttpSession session)
	{
		String id =(String)session.getAttribute("USER_ID"); 
	    int listcount = mmatchservice.getMyMenteeReqListCount(id); //�� ����Ʈ ���� �޾ƿ�
	    //�� ������ ��
	    int maxpage = (listcount + limit - 1) /limit;
	    
	    //���� �������� ������ ���� ������ �� (1,11,21 ���)
	    int startpage = ((page-1) / 10) * 10 + 1;
	    
	    //���� �������� ������ ������ ������ �� (10,20.30 ���)
	    int endpage = startpage + 10 -1;
	    
	    if(endpage > maxpage)
	    	endpage = maxpage;
	    
	    List<MatchAppReq> reqlist = mmatchservice.getMyMenteeReqList(page, limit,id); //����Ʈ�� �޾ƿ�
	    
	    
	    Map<String,Object> map = new HashMap<String,Object>();

	    map.put("page",page);
	    map.put("maxpage",maxpage);
	    map.put("startpage",startpage);
	    map.put("endpage",endpage);
	    map.put("listcount",listcount);
	    map.put("reqlist",reqlist);
	    return map;
	}
	//��û�� ���� ��� ó�� (����/����)
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
			message=id+"���� ��Ƽ/���� ��Ī ��û�� �����Ǿ����ϴ�.(�� ������ ��Ȯ��)";
		}else if(state ==3){
			message=id+"���� ��Ƽ/���� ��Ī ��û�� �����Ǿ����ϴ�.(�� ������ ��Ȯ��)";
		}
		//���� ���񽺶� �׽�Ʈ �ƴҋ��� �ּ� ó��
		//sms.sendSmsData(tel, message);
	    return mmatchservice.changeApplyState(matchInfo);
	}
}
