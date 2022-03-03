package com.project.sports.controller;

import java.io.File;  
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.sports.domain.MailVO;
import com.project.sports.domain.Match;
import com.project.sports.domain.Match_Apply;
import com.project.sports.domain.Match_Deadline;
import com.project.sports.domain.Sports;
import com.project.sports.service.MatchService;
import com.project.sports.task.SendMail;
 
@Controller
@RequestMapping(value={"/match","/mypage"})
public class MatchController {
	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
	
	@Autowired
	private MatchService matchservice;
	
	@Autowired
	private SendMail sendMail;
	
	
	
	
	private ModelAndView pageSet(int num, int page, String page_name) {
		int limit = 5; // 한 화면에 출력할 레코드 갯수
		int listcount = matchservice.getListCount(num); //총 리스트 수를 받아옴
		int maxpage = (listcount + limit - 1) / limit; //총페이지 수
		int startpage = ((page -1) /10) *10 +1; //현재 페이지에 보여줄 시작 페이지 수(1,11,21, 등..)
		int endpage = startpage + 10 - 1; //현재 페이지에 보여줄 마지막 페이지 수 (10,20,30 등..)
		
		if(endpage > maxpage)
		   endpage = maxpage;
		
		List<Match> matchlist = matchservice.getMatchList(page, limit, num);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName(page_name);
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage", endpage);
		mv.addObject("listcount", listcount);
		mv.addObject("matchlist", matchlist);
		mv.addObject("limit", limit);
		
		logger.info("" + matchlist);
		return mv;
	}
	
	
  @RequestMapping(value = "/baseball", method = RequestMethod.GET) public
  ModelAndView baseball(
			@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num = 2;   //sport_num =1
		String page_name = "sport_match/match_baseball";
		return pageSet(num, page, page_name);
		
	}
	
	@RequestMapping(value = "/football", method = RequestMethod.GET)
	public ModelAndView football(@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num=3;
		String page_name ="sport_match/match_football";
		return pageSet(num, page, page_name);
	}
	
	@RequestMapping(value = "/basketball", method = RequestMethod.GET)
	public ModelAndView basketball(@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num=4;
		String page_name ="sport_match/match_basketball";
		return pageSet(num, page, page_name);
	}
	
	@RequestMapping(value = "/golf", method = RequestMethod.GET)
	public ModelAndView golf(@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num = 10;
		String page_name ="sport_match/match_golf";
		return pageSet(num, page, page_name);
	}
	
	@RequestMapping(value = "/bowling", method = RequestMethod.GET)
	public ModelAndView bowling(@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num = 9;
		String page_name ="sport_match/match_bowling";
		return pageSet(num, page, page_name);
	}
	
	@RequestMapping(value = "/tennis", method = RequestMethod.GET)
	public ModelAndView tennis(@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num = 8;   //sport_num 확인
		String page_name = "sport_match/match_tennis";
		return pageSet(num, page, page_name);
	}
	
	@RequestMapping(value = "/badminton", method = RequestMethod.GET)
	public ModelAndView badminton(@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num = 7;
		String page_name= "sport_match/match_badminton";
		return pageSet(num, page, page_name);
	}
	
	
	@RequestMapping(value = "/tabletennis", method = RequestMethod.GET)
	public ModelAndView tabletennis(@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num = 6;
		String page_name=  "sport_match/match_tabletennis";
		return pageSet(num, page, page_name);
	}
	
	@RequestMapping(value = "/volleyball", method = RequestMethod.GET)
	public ModelAndView vallyball(@RequestParam(value="page",defaultValue="1",required=false) int page,
			ModelAndView mv) {
		int num = 5;   //sport_num 확인
		String page_name = "sport_match/match_volleyball";
		return pageSet(num, page, page_name);
	}
	
	@RequestMapping(value="/mainPage",method=RequestMethod.GET)
	public ModelAndView mainPage(
			@RequestParam(value="page",defaultValue="1",required=false) int page, ModelAndView mv) {
		int num = 1;   //sport_num =1
		String page_name = "sport_match/Sport_matching";
		return pageSet(num, page, page_name);
	}
	
	
	@RequestMapping(value = "/selSportName", method = RequestMethod.POST, produces="application/text;charset=utf8")
	@ResponseBody
	public String selSportName(@RequestBody Sports param) throws Exception {
		return matchservice.selSportName(param);
	}
	
	@RequestMapping(value = "/selRegi", method = RequestMethod.POST)
	@ResponseBody
	public List<Match> selRegi(@RequestParam(value="REGISTER_NUM",defaultValue="1")int REGISTER_NUM) throws Exception {
		logger.info("register_num" + REGISTER_NUM);
		return matchservice.selRegi(REGISTER_NUM);
	}
	
	@RequestMapping(value="/Regi",method=RequestMethod.POST)
	public String add(Match match, HttpServletRequest request) throws Exception{
		matchservice.insertMatch(match); // 저장 메서드 호출
		return "redirect:baseball";
	}
	
	@RequestMapping(value="/SearchList",method=RequestMethod.GET)
	@ResponseBody
	public List<Match> search(
			@RequestParam(value="SPORT_NUM",defaultValue="1")int num,
			@RequestParam(value="MATCH_ADR",defaultValue="지역",required=false)String MATCH_ADR,
			@RequestParam(value="MATCH_DTL_ADR",defaultValue="세부지역",required=false)String MATCH_DTL_ADR,
			@RequestParam(value="MATCH_TIME",defaultValue="",required=false)String MATCH_TIME,
			@RequestParam(value="MATCH_PRS",defaultValue="0",required=false)int MATCH_PRS,
			@RequestParam(value="MATCH_SKL",defaultValue="",required=false)String MATCH_SKL
			) {
		System.out.println("SearchList");
		
		List<Match> matchlist = matchservice.getSearchList(num, MATCH_ADR, MATCH_DTL_ADR, MATCH_TIME, MATCH_PRS, MATCH_SKL);
		
		return matchlist;
	}
	
	@RequestMapping(value="/RegiUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String Regiupdate(@RequestParam(value="REGISTER_ID") String REGISTER_ID, 
							@RequestParam(value="REGISTER_NUM",defaultValue="1")int REGISTER_NUM,
							Match_Apply match_apply)throws Exception{
		matchservice.ApplyMatch(match_apply);
		int result =  matchservice.RegiupdateMatch(REGISTER_NUM);
		String email = matchservice.getemail(REGISTER_ID);
		if(result ==0) {
		logger.info("신청실패");
			return "0";
		}
		else {
		logger.info("신청성공");
		MailVO vo = new MailVO();
		vo.setTo(email);
		vo.setSubject("[운동챙기조]" + REGISTER_ID + "님 등록하신 매칭에 신청내역이 있습니다.");
		logger.info("email : "+email);
		vo.setContent(REGISTER_ID + "님 등록하신 매칭에 신청내역이 있습니다.");
		logger.info("email : "+REGISTER_ID );
		sendMail.sendMail(vo);
		return "1";
		}
	}
	
	@RequestMapping(value = "/mymatching", method = RequestMethod.GET)
	public ModelAndView mymatching(ModelAndView mv, HttpSession session) throws Exception{
		
		
		String id =(String)session.getAttribute("USER_ID");
		List<Match> RegiList = matchservice.getRegiList(id);
		List<Match> ApplyList = matchservice.getApplyList(id);
		List<Match> DeadList = matchservice.getDeadList(id);
		
		
		mv.setViewName("sports_mypage/mypage_mymatching");
		mv.addObject("RegiList", RegiList);
		mv.addObject("ApplyList", ApplyList);
		mv.addObject("DeadList", DeadList);
		return mv;
	}
	
	@RequestMapping(value="/MactingUpdate",method=RequestMethod.POST)
	@ResponseBody
	public String MactingUpdate(Match match)throws Exception{
		int result =  matchservice.MactingUpdate(match);
		logger.info("result :" +result);
		if(result ==0) {
		logger.info("수정실패");
			return "0";
		}
		else {
		logger.info("수정성공");
		return "1";
		}
	}
	
	@RequestMapping(value="/Regidelete", method=RequestMethod.POST)
	@ResponseBody
	public String Regidelete(@RequestParam(value="REGISTER_NUM",defaultValue="1")int REGISTER_NUM) {
		int result = matchservice.Regidelete(REGISTER_NUM);
		logger.info("result삭제 :" +result);
		if(result ==0) {
		logger.info("삭제실패");
			return "0";
		}
		else {
		logger.info("삭제성공");
		return "1";
		}
	}
	
	
	@RequestMapping(value="/deadLine",method=RequestMethod.POST)
	@ResponseBody
	public String deadLine(@RequestParam(value="REGISTER_NUM",defaultValue="1")int REGISTER_NUM,
						   @RequestParam(value="SPORT_NUM",defaultValue="1")int SPORT_NUM
							)throws Exception{
		logger.info("REGISTER_NUM"+ REGISTER_NUM );
		logger.info("SPORT_NUM : "+ SPORT_NUM );
		String APPLY_ID =  matchservice.getApplyID(REGISTER_NUM);
		logger.info("apply _id :" + APPLY_ID);
		String REGISTER_ID =  matchservice.getRegiID(REGISTER_NUM);
		logger.info("REGISTER_ID : "+ REGISTER_ID );
		int applyresult =  matchservice.ApplyupdateMatch(REGISTER_NUM);
		logger.info("applyresult :" + applyresult);
		int regiresult = matchservice.Regifinalupdate(REGISTER_NUM);
		logger.info("regiresult :" + regiresult);
		matchservice.DeadMatch(SPORT_NUM, APPLY_ID, REGISTER_ID, REGISTER_NUM);
		String Regiemail = matchservice.getemail(REGISTER_ID);
		String Applyemail = matchservice.getemail(APPLY_ID);
		String Regimobile = matchservice.getMobile(REGISTER_ID);
		String Applymobile = matchservice.getMobile(APPLY_ID);
		logger.info("등록이메일 : " + Regiemail);
		logger.info("신청이메일 : " + Applyemail);
		logger.info("등록번호 : " + Regimobile);
		logger.info("신청번호 : " + Applymobile);
		MailVO Re = new MailVO();
		MailVO App = new MailVO();
		Re.setTo(Regiemail);
		App.setTo(Applyemail);
		Re.setSubject("[운동챙기조]" + REGISTER_ID + "님 응답하신 매칭입니다.");
		Re.setContent(REGISTER_ID + " 님 응답하신 매칭의 상대방 번호입니다." +"아이디 :  "+APPLY_ID + "   전화번호 :  "+Applymobile);
		App.setSubject("[운동챙기조]" + APPLY_ID + "님이 신청하신 매칭입니다.");
		App.setContent(APPLY_ID + "님 신청하신 매칭의 상대방 번호입니다." +"아이디 :  "+REGISTER_ID + "   전화번호 :  "+Regimobile);
		sendMail.sendMail(Re);
		sendMail.sendMail(App);
		if(regiresult ==0) {
			logger.info("응답실패");
				return "0";
			}
			else {
			logger.info("응답성공");
			return "1";
			}
		}
	}
