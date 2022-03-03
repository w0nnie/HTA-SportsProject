package com.project.sports.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.sports.domain.DealAuction;
import com.project.sports.domain.DealDirect;
import com.project.sports.domain.DealPoint;
import com.project.sports.domain.DealQuestion;
import com.project.sports.service.MyDealService;

@Controller
@RequestMapping(value="/Mydeal")
public class MydealController {
	
	private static final Logger logger
	= LoggerFactory.getLogger(MydealController.class);
	
	@Autowired
	private MyDealService MyDealService;

	//메인 페이지 리스트
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public ModelAndView mypage1(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			 ModelAndView mv ,
			 HttpSession session) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		// 내 거래내역 분류별 갯수
		int BUY_BIDDING = MyDealService.BUY_BIDDINGcount(sessionid);
		int BUY_BIDCOM = MyDealService.BUY_BIDCOMcount(sessionid);
		int BUY_BIDFAIL = MyDealService.BUY_BIDFAILcount(sessionid);
		int BUY_DELIVERY = MyDealService.BUY_DELIVERYcount(sessionid);
		int BUY_QUESTION = MyDealService.BUY_QUESTIONcount(sessionid);
		int SELL_BIDDING = MyDealService.SELL_BIDDINGcount(sessionid);
		int SELL_BIDCOM = MyDealService.SELL_BIDCOMcount(sessionid);
		int SELL_DELIVERY = MyDealService.SELL_DELIVERYcount(sessionid);
		int SELL_QUESTION = MyDealService.SELL_QUESTIONcount(sessionid);
		
		int BUY_QUESTION2 = MyDealService.BUY_QUESTIONcount2(sessionid);
		int SELL_QUESTION2 = MyDealService.SELL_QUESTIONcount2(sessionid);
		
		//경매거래 장바구니
		List<DealAuction> Auction = new ArrayList<DealAuction>();
		Auction = MyDealService.AuctionCartList(sessionid);
		
		//현재 포인트 조회
		int nowpoint = MyDealService.nowpoint(sessionid);
		
		
		
		
		mv.addObject("BUY_BIDDING",BUY_BIDDING);
		mv.addObject("BUY_BIDCOM",BUY_BIDCOM);
		mv.addObject("BUY_BIDFAIL",BUY_BIDFAIL);
		mv.addObject("BUY_DELIVERY",BUY_DELIVERY);
		mv.addObject("SELL_BIDDING",SELL_BIDDING);
		mv.addObject("SELL_BIDCOM",SELL_BIDCOM);
		mv.addObject("SELL_DELIVERY",SELL_DELIVERY);
		mv.addObject("BUY_QUESTION",BUY_QUESTION);
		mv.addObject("SELL_QUESTION",SELL_QUESTION);
		mv.addObject("BUY_QUESTION2",BUY_QUESTION2);
		mv.addObject("SELL_QUESTION2",SELL_QUESTION2);
		mv.addObject("sessionid",sessionid);
		mv.addObject("Auction" , Auction);
		mv.addObject("nowpoint" , nowpoint);
		
		mv.setViewName("sports_mypage/mypage_mydeal_main");
		
		return mv;
		
	}
	//장바구니 직거래 선택시 메인페이지
	@RequestMapping(value="/main2",method=RequestMethod.GET)
	public ModelAndView mypage2(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			 ModelAndView mv ,
			 HttpSession session) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		// 내 거래내역 분류별 갯수
		int BUY_BIDDING = MyDealService.BUY_BIDDINGcount(sessionid);
		int BUY_BIDCOM = MyDealService.BUY_BIDCOMcount(sessionid);
		int BUY_BIDFAIL = MyDealService.BUY_BIDFAILcount(sessionid);
		int BUY_DELIVERY = MyDealService.BUY_DELIVERYcount(sessionid);
		int BUY_QUESTION = MyDealService.BUY_QUESTIONcount(sessionid);
		int SELL_BIDDING = MyDealService.SELL_BIDDINGcount(sessionid);
		int SELL_BIDCOM = MyDealService.SELL_BIDCOMcount(sessionid);
		int SELL_DELIVERY = MyDealService.SELL_DELIVERYcount(sessionid);
		int SELL_QUESTION = MyDealService.SELL_QUESTIONcount(sessionid);
		int BUY_QUESTION2 = MyDealService.BUY_QUESTIONcount2(sessionid);
		int SELL_QUESTION2 = MyDealService.SELL_QUESTIONcount2(sessionid);
		
		//직거래 장바구니
		List<DealDirect> Direct = new ArrayList<DealDirect>();
		Direct = MyDealService.DirectCartList(sessionid);
		
		
		
		mv.addObject("BUY_BIDDING",BUY_BIDDING);
		mv.addObject("BUY_BIDCOM",BUY_BIDCOM);
		mv.addObject("BUY_BIDFAIL",BUY_BIDFAIL);
		mv.addObject("BUY_DELIVERY",BUY_DELIVERY);
		mv.addObject("SELL_BIDDING",SELL_BIDDING);
		mv.addObject("SELL_BIDCOM",SELL_BIDCOM);
		mv.addObject("SELL_DELIVERY",SELL_DELIVERY);
		mv.addObject("BUY_QUESTION",BUY_QUESTION);
		mv.addObject("SELL_QUESTION",SELL_QUESTION);
		mv.addObject("BUY_QUESTION2",BUY_QUESTION2);
		mv.addObject("SELL_QUESTION2",SELL_QUESTION2);
		mv.addObject("Direct" , Direct);
		
		mv.setViewName("sports_mypage/mypage_mydeal_main2");
		
		return mv;
		
	}
	//구매현황 페이지 리스트
	@RequestMapping(value="/buy" ,method=RequestMethod.GET)
	public ModelAndView buylist(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			@RequestParam(value = "view2",
			defaultValue = "1", required = false) int view,
			 ModelAndView mv ,HttpSession session
			 ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		int limit = 5; // 한 화면에 출력할 레코드 갯수
		
		int listcount = MyDealService.getListCount(view,sessionid); // 총 리스트 수를 받아옴
		logger.info("리스트카운트" + listcount);
		
		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에 보여줄 마지막 페이지 수 (10, 20 ,30 등...)
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage)
			endpage = maxpage;
		
		List<DealAuction> Auction = new ArrayList<DealAuction>();
		
		Auction = MyDealService.MybuyList(view,page,limit,sessionid);

		mv.addObject("view2",view);
		mv.addObject("Auction",Auction);
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("limit",limit);
		mv.setViewName("sports_mypage/mypage_mydeal_buy");
			
		return mv;
			
	}
	//판매현황 페이지 리스트
	@RequestMapping(value="/sell" ,method=RequestMethod.GET)
	public ModelAndView selllist(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			@RequestParam(value = "view2",
			defaultValue = "1", required = false) int view,
			 ModelAndView mv ,HttpSession session
			 ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		int limit = 5; // 한 화면에 출력할 레코드 갯수
		
		int listcount = MyDealService.getListCount2(view,sessionid); // 총 리스트 수를 받아옴
		logger.info("리스트카운트" + listcount);
		
		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에 보여줄 마지막 페이지 수 (10, 20 ,30 등...)
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage)
			endpage = maxpage;
		
		List<DealAuction> Auction = new ArrayList<DealAuction>();
		
		Auction = MyDealService.MysellList(view,page,limit,sessionid);

		
		mv.addObject("view2",view);
		mv.addObject("Auction",Auction);
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("limit",limit);
		mv.setViewName("sports_mypage/mypage_mydeal_sell");
			
		return mv;
			
	}
	
	@GetMapping("/delete")
	public String MyDealdelete(int num ,
			HttpSession session)
				throws Exception{
	
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//비밀번호가 일치하는 경우 삭제 처리 합니다. 
		int result = MyDealService.Cart_Delete(num , sessionid);
		


		return "redirect:main";
	}
	
	@GetMapping("/delete2")
	public String MyDealdelete2(int num ,
			HttpSession session)
				throws Exception{
	
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//비밀번호가 일치하는 경우 삭제 처리 합니다. 
		int result = MyDealService.Cart_Delete2(num , sessionid);
		


		return "redirect:main2";
	}
	
	@GetMapping("/postinput")
	public String postinput(int num ,
			@RequestParam(value="sel",defaultValue="우체국",required=false)String sel,
			@RequestParam(value = "post1",
			defaultValue = "", required = false) String post1)
				throws Exception{
	
		
		
		//글정보에 택배사 송장번호 update
		MyDealService.postinput1(num , sel , post1);
		
		//구매자 배송중으로 변경
		MyDealService.postinput2(num);
		
		//판매자 배송중으로 변경
		MyDealService.postinput3(num);


		return "redirect:main";
	}
	
	@GetMapping("/receipt")
	public String postinput(int num )
				throws Exception{
	
		
		
		//글삭제
		MyDealService.receipt1(num);
		
		//내거래내역 위글과 관련된 로우 삭제
		MyDealService.receipt2(num);



		return "redirect:main";
	}
	//경매거래 문의리스트
	@GetMapping("/question")
	public ModelAndView question( ModelAndView mv ,HttpSession session ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//경매 내가 한 문의
		List<DealQuestion> AbuyQuestion = new ArrayList<DealQuestion>();
		AbuyQuestion = MyDealService.DealbuyQuestion(sessionid);
		
		//경매 나에게 온 문의
		List<DealQuestion> AsellQuestion = new ArrayList<DealQuestion>();
		AsellQuestion = MyDealService.DealsellQuestion(sessionid);
		
		mv.addObject("AbuyQuestion",AbuyQuestion);
		mv.addObject("AsellQuestion",AsellQuestion);
		
			
		mv.setViewName("sports_mypage/mypage_mydeal_question");
		return mv;
	}
	//경매거래 답변달기
	@GetMapping("/answer")
	public String answerinput(int num, String tex)
				throws Exception{	
		//답변 달아주기
		MyDealService.Aanwser(num , tex);

		return "redirect:main";
	}
	
	//경매거래 문의글 삭제
	@GetMapping("/questiondel")
	public String Aquestiondel(int num)
				throws Exception{

		//질문글 삭제
		MyDealService.Aquestiondel(num);
	
		return "redirect:main";
	}
	
	//직거래 문의 리스트
	@GetMapping("/question2")
	public ModelAndView question2( ModelAndView mv ,HttpSession session ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//직거래 내가 한 문의
		List<DealQuestion> DbuyQuestion = new ArrayList<DealQuestion>();
		DbuyQuestion = MyDealService.DealbuyQuestion2(sessionid);
		
		//직거래 나에게 온 문의
		List<DealQuestion> DsellQuestion = new ArrayList<DealQuestion>();
		DsellQuestion = MyDealService.DealsellQuestion2(sessionid);
		
		mv.addObject("DbuyQuestion",DbuyQuestion);
		mv.addObject("DsellQuestion",DsellQuestion);
		
			
		mv.setViewName("sports_mypage/mypage_mydeal_question2");
		return mv;
	}
	
	//직거래 답변달기
	@GetMapping("/answer2")
	public String answer2input(int num, String tex)
				throws Exception{	
		//답변 달아주기
		MyDealService.Danwser(num , tex);

		return "redirect:main";
	}

	//직거래 문의글 삭제
	@GetMapping("/questiondel2")
	public String Dquestiondel(int num)
				throws Exception{

		//질문글 삭제
		MyDealService.Dquestiondel(num);
	
		return "redirect:main";
	}
	
	@GetMapping("/pointview")
	public ModelAndView pointview( ModelAndView mv , HttpSession session )
			throws Exception{
		
		
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//현재 포인트 조회
		int nowpoint = MyDealService.nowpoint(sessionid);
		
		mv.addObject("sessionid",sessionid);
		mv.addObject("nowpoint",nowpoint);
		mv.setViewName("sports_mypage/mypage_mydeal_point");
		return mv;
	}	
	
	@GetMapping("/pointrequest")
	public String pointinput( ModelAndView mv , HttpSession session , String name , int point)
			throws Exception{
		
		
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//포인트 관리자에게 요청
		int pointre = MyDealService.pointrequest(sessionid , name , point);
		
		
	
		
		return "redirect:pointview";
	}
	
	@GetMapping("/pointadmin")
	public ModelAndView pointadmin( ModelAndView mv , HttpSession session )
			throws Exception{
		
		
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		List<DealPoint> dealpoint = new ArrayList<DealPoint>();
		
		//요청 리스트 조회
		dealpoint = MyDealService.pointreqlist();
		
		
		mv.addObject("sessionid",sessionid);
		mv.addObject("dealpoint",dealpoint);
	
		mv.setViewName("sports_mypage/mypage_mydeal_pointadmin");
		return mv;
	}
	
	@GetMapping("/pointsuc")
	public String pointsuc( ModelAndView mv , HttpSession session , String id , int point)
			throws Exception{
		
		//회원에게 포인트 입금
		MyDealService.pointsuc( id , point);
		
		
	
		
		return "redirect:pointadmin";
	}
	
	
	
	
}
