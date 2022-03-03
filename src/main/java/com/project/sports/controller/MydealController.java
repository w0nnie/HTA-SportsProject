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

	//���� ������ ����Ʈ
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public ModelAndView mypage1(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			 ModelAndView mv ,
			 HttpSession session) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		// �� �ŷ����� �з��� ����
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
		
		//��Űŷ� ��ٱ���
		List<DealAuction> Auction = new ArrayList<DealAuction>();
		Auction = MyDealService.AuctionCartList(sessionid);
		
		//���� ����Ʈ ��ȸ
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
	//��ٱ��� ���ŷ� ���ý� ����������
	@RequestMapping(value="/main2",method=RequestMethod.GET)
	public ModelAndView mypage2(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			 ModelAndView mv ,
			 HttpSession session) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		// �� �ŷ����� �з��� ����
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
		
		//���ŷ� ��ٱ���
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
	//������Ȳ ������ ����Ʈ
	@RequestMapping(value="/buy" ,method=RequestMethod.GET)
	public ModelAndView buylist(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			@RequestParam(value = "view2",
			defaultValue = "1", required = false) int view,
			 ModelAndView mv ,HttpSession session
			 ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		int limit = 5; // �� ȭ�鿡 ����� ���ڵ� ����
		
		int listcount = MyDealService.getListCount(view,sessionid); // �� ����Ʈ ���� �޾ƿ�
		logger.info("����Ʈī��Ʈ" + listcount);
		
		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� �������� ������ ������ ������ �� (10, 20 ,30 ��...)
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
	//�Ǹ���Ȳ ������ ����Ʈ
	@RequestMapping(value="/sell" ,method=RequestMethod.GET)
	public ModelAndView selllist(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			@RequestParam(value = "view2",
			defaultValue = "1", required = false) int view,
			 ModelAndView mv ,HttpSession session
			 ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		int limit = 5; // �� ȭ�鿡 ����� ���ڵ� ����
		
		int listcount = MyDealService.getListCount2(view,sessionid); // �� ����Ʈ ���� �޾ƿ�
		logger.info("����Ʈī��Ʈ" + listcount);
		
		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� �������� ������ ������ ������ �� (10, 20 ,30 ��...)
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
		
		//��й�ȣ�� ��ġ�ϴ� ��� ���� ó�� �մϴ�. 
		int result = MyDealService.Cart_Delete(num , sessionid);
		


		return "redirect:main";
	}
	
	@GetMapping("/delete2")
	public String MyDealdelete2(int num ,
			HttpSession session)
				throws Exception{
	
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//��й�ȣ�� ��ġ�ϴ� ��� ���� ó�� �մϴ�. 
		int result = MyDealService.Cart_Delete2(num , sessionid);
		


		return "redirect:main2";
	}
	
	@GetMapping("/postinput")
	public String postinput(int num ,
			@RequestParam(value="sel",defaultValue="��ü��",required=false)String sel,
			@RequestParam(value = "post1",
			defaultValue = "", required = false) String post1)
				throws Exception{
	
		
		
		//�������� �ù�� �����ȣ update
		MyDealService.postinput1(num , sel , post1);
		
		//������ ��������� ����
		MyDealService.postinput2(num);
		
		//�Ǹ��� ��������� ����
		MyDealService.postinput3(num);


		return "redirect:main";
	}
	
	@GetMapping("/receipt")
	public String postinput(int num )
				throws Exception{
	
		
		
		//�ۻ���
		MyDealService.receipt1(num);
		
		//���ŷ����� ���۰� ���õ� �ο� ����
		MyDealService.receipt2(num);



		return "redirect:main";
	}
	//��Űŷ� ���Ǹ���Ʈ
	@GetMapping("/question")
	public ModelAndView question( ModelAndView mv ,HttpSession session ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//��� ���� �� ����
		List<DealQuestion> AbuyQuestion = new ArrayList<DealQuestion>();
		AbuyQuestion = MyDealService.DealbuyQuestion(sessionid);
		
		//��� ������ �� ����
		List<DealQuestion> AsellQuestion = new ArrayList<DealQuestion>();
		AsellQuestion = MyDealService.DealsellQuestion(sessionid);
		
		mv.addObject("AbuyQuestion",AbuyQuestion);
		mv.addObject("AsellQuestion",AsellQuestion);
		
			
		mv.setViewName("sports_mypage/mypage_mydeal_question");
		return mv;
	}
	//��Űŷ� �亯�ޱ�
	@GetMapping("/answer")
	public String answerinput(int num, String tex)
				throws Exception{	
		//�亯 �޾��ֱ�
		MyDealService.Aanwser(num , tex);

		return "redirect:main";
	}
	
	//��Űŷ� ���Ǳ� ����
	@GetMapping("/questiondel")
	public String Aquestiondel(int num)
				throws Exception{

		//������ ����
		MyDealService.Aquestiondel(num);
	
		return "redirect:main";
	}
	
	//���ŷ� ���� ����Ʈ
	@GetMapping("/question2")
	public ModelAndView question2( ModelAndView mv ,HttpSession session ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//���ŷ� ���� �� ����
		List<DealQuestion> DbuyQuestion = new ArrayList<DealQuestion>();
		DbuyQuestion = MyDealService.DealbuyQuestion2(sessionid);
		
		//���ŷ� ������ �� ����
		List<DealQuestion> DsellQuestion = new ArrayList<DealQuestion>();
		DsellQuestion = MyDealService.DealsellQuestion2(sessionid);
		
		mv.addObject("DbuyQuestion",DbuyQuestion);
		mv.addObject("DsellQuestion",DsellQuestion);
		
			
		mv.setViewName("sports_mypage/mypage_mydeal_question2");
		return mv;
	}
	
	//���ŷ� �亯�ޱ�
	@GetMapping("/answer2")
	public String answer2input(int num, String tex)
				throws Exception{	
		//�亯 �޾��ֱ�
		MyDealService.Danwser(num , tex);

		return "redirect:main";
	}

	//���ŷ� ���Ǳ� ����
	@GetMapping("/questiondel2")
	public String Dquestiondel(int num)
				throws Exception{

		//������ ����
		MyDealService.Dquestiondel(num);
	
		return "redirect:main";
	}
	
	@GetMapping("/pointview")
	public ModelAndView pointview( ModelAndView mv , HttpSession session )
			throws Exception{
		
		
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//���� ����Ʈ ��ȸ
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
		
		//����Ʈ �����ڿ��� ��û
		int pointre = MyDealService.pointrequest(sessionid , name , point);
		
		
	
		
		return "redirect:pointview";
	}
	
	@GetMapping("/pointadmin")
	public ModelAndView pointadmin( ModelAndView mv , HttpSession session )
			throws Exception{
		
		
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		List<DealPoint> dealpoint = new ArrayList<DealPoint>();
		
		//��û ����Ʈ ��ȸ
		dealpoint = MyDealService.pointreqlist();
		
		
		mv.addObject("sessionid",sessionid);
		mv.addObject("dealpoint",dealpoint);
	
		mv.setViewName("sports_mypage/mypage_mydeal_pointadmin");
		return mv;
	}
	
	@GetMapping("/pointsuc")
	public String pointsuc( ModelAndView mv , HttpSession session , String id , int point)
			throws Exception{
		
		//ȸ������ ����Ʈ �Ա�
		MyDealService.pointsuc( id , point);
		
		
	
		
		return "redirect:pointadmin";
	}
	
	
	
	
}
