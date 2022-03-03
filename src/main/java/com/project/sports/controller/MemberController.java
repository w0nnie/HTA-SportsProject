package com.project.sports.controller;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.sports.domain.Member;
import com.project.sports.service.MemberService;
import com.project.sports.service.MyDealService;

/*
@Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만
모든 클래스에 @Component를 할당하면 어떤 클래스가 어떤 역할을 하는지 파악하지
어렵습니다. 스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서
@Component를 상속하여 다음과 같은 3개의 애노테이션을 제공합니다.

1. @Controller - 사용자의 요청을 제어하는 Controller 클래스
2. @Repository - DB연동을 처리하는 DAO 클래스
3. @Service - 비즈니스 로직을 처리하는 Service 클래스
 */
@Controller
@RequestMapping(value="/member")//http://localhost:8088/myhome6/member/로 시작하는 주소 매핑
public class MemberController {
	private static final Logger logger
	= LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberservice;
	
	//장성진추가 (10-15)
	@Autowired
	private MyDealService mydealservice;
	
/*
@CookieValue(value="saveid", required=false) Cookie readCookie
이름이 saveid인 쿠키를 Cookie 타입으로 전달받습니다.
지정한 이름의 쿠키가 존재하지 않을 수도 있기 때문에 required=false로 설정해야 합니다.
즉, id 기억하기를 선택하지 않을 수도 있기 때문에 required=false로 설정해야 합니다.
required=true 상태에서 지정한 이름을 가진 쿠키가 존재하지 않으면 스프링 MVC는 익셉션을 발생시킵니다.
 */
	
//http://localhost:8088/myhome6/login 로그인 폼 이동
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv,
//Model:값을 저장하는것, View:값을 보여주는것
//Model만 사용할 경우 String으로 리턴
//ModelAndView는 addObject로 값을 가져오고 setViewName으로 보여준다.
			@CookieValue(value="saveid", required=false) Cookie readCookie
			) {
		if(readCookie != null) {
			mv.addObject("saveid",readCookie.getValue());
			logger.info("cookie time=" + readCookie.getMaxAge());
		}
		mv.setViewName("sports_member/login");
		return mv;
	}
	
	//회원가입 폼 이동
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
		return "sports_member/join";//WEB-INF/views/sports_member/join.jsp
	}
	
	//회원가입 폼 아이디 검사
	@RequestMapping(value="/idcheck", method=RequestMethod.GET)
	public void idcheck(@RequestParam("id") String id,
			HttpServletResponse response) throws Exception{
		int result = memberservice.isId(id);//idId에서 넘어온 int형
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	//회원가입 유저 정보 저장
	@RequestMapping(value="/joinProcess", method=RequestMethod.POST)
	public String joinProcess(Member m,//Member : command 객체
			RedirectAttributes rattr, Model model,String[] USER_PSPORTS,
			HttpServletRequest request) throws Exception{
			m.setUSER_MOBILE(m.getMOBILE1()+m.getMOBILE2()+m.getMOBILE3());
			m.setUSER_ADDRESS(m.getDONG()+m.getHOME()+m.getHOMEADDRESS());
			m.setUSER_JUMIN(m.getJUMIN()+m.getJUMIN1());
			m.setUSER_EMAIL(m.getUSER_EMAIL()+"@"+m.getUSER_EMAILDOMAIN());
			m.setUSER_BMI(Double.valueOf(m.getUSER_PWEIGHT()/(m.getUSER_HEIGHT()*m.getUSER_HEIGHT())*10000));//BMI계산
		if(m.getJUMIN1().substring(0,1).equals("1")) {
			m.setUSER_RMR(
					66.47+(13.75*m.getUSER_PWEIGHT())
						+(5*m.getUSER_HEIGHT())
						-Double.valueOf((6.75*(121-Integer.parseInt(m.getJUMIN().substring(0,2))+1)))
					);
		}else if(m.getJUMIN1().substring(0,1).equals("3")) {
			m.setUSER_RMR(
					66.47+(13.75*m.getUSER_PWEIGHT())
						+(5*m.getUSER_HEIGHT())
							-Double.valueOf((6.75*(21-Integer.parseInt(m.getJUMIN().substring(0,2))+1)))
					);
		}else if(m.getJUMIN1().substring(0,1).equals("2")) {
			m.setUSER_RMR(
					655.1+(9.56*m.getUSER_PWEIGHT())
						+(1.85*m.getUSER_HEIGHT())
							-Double.valueOf((4.68*(121-Integer.parseInt(m.getJUMIN().substring(0,2))+1)))
					);
		}else if(m.getJUMIN1().substring(0,1).equals("4")) {
			m.setUSER_RMR(
					655.1+(9.56*m.getUSER_PWEIGHT())
						+(1.85*m.getUSER_HEIGHT())
							-Double.valueOf((4.68*(21-Integer.parseInt(m.getJUMIN().substring(0,2))+1)))
					);
		}else {m.setUSER_RMR(1);};
		//(남자:66.47+(13.75*현재몸무게)+(5*키)-(6.75*나이)
		//(여자:655.1+(9.56*현재몸무게)+(1.85*키)-(4.68*나이)
		int result = memberservice.insert(m);
		
		//회원가입시 포인트 db 자동생성 (장성진10-15 추가)
		String user_id = m.getUSER_ID();
		mydealservice.pointdb(user_id);
		
		//삽입이 된 경우
		if(result==1) {
			rattr.addFlashAttribute("result","joinSuccess");
			return "redirect:login";
		}else {
			model.addAttribute("url",request.getRequestURL());
			model.addAttribute("message","회원 가입 실패");
			return "error/error";
		}
	}
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(//갖고오는것
			@RequestParam("USER_ID") String id,
			@RequestParam("USER_PASS") String password,
			@RequestParam(value="remember",defaultValue="",required=false)
			String remember,
			HttpSession session, RedirectAttributes rattr,
			HttpServletResponse response) throws Exception{
		int result = memberservice.isId(id, password);
		logger.info("결과: " + result);
		
		if(result == 1) {
			//로그인 성공
			session.setAttribute("USER_ID", id);
			Cookie savecookie = new Cookie("saveid",id);
			if(!remember.equals("")) {
				savecookie.setMaxAge(60*60);
				logger.info("쿠키저장 : 60*60");
			}else {
				logger.info("쿠키저장 : 0");
				savecookie.setMaxAge(0);
			}
			response.addCookie(savecookie);
			return "redirect:/main/mainPage";//boardController로
		}else {
			rattr.addFlashAttribute("result",result);
			return "redirect:login";
		}
		
	}
	//회원 개인정보
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public ModelAndView member_info(HttpSession session,//파라미터로 넘어온 이름 중 id라는 이름을 갖고 있는 값
			ModelAndView mv, HttpServletRequest request) {//delete?id=
		String id = (String) session.getAttribute("USER_ID");
		if(id==null) {
			mv.setViewName("redirect:login");
		}else {
			Member m = memberservice.member_info(id);
			mv.setViewName("sports_mypage/mypage_home");
			mv.addObject("mypage_info",m);
		}
		return mv;
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String member_delete(String id) {
		memberservice.delete(id);
		return "redirect:login";
	}
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView member_update(HttpSession session,
			ModelAndView mv) {
		String id = (String) session.getAttribute("USER_ID");
		if(id==null) {
			mv.setViewName("redirect:login");
		}else {
			Member m = memberservice.member_info(id);
			mv.setViewName("sports_mypage/mypage_updateForm");
			mv.addObject("mypage_info",m);
		}
		return mv;
	}
	@RequestMapping(value="/updateProcess", method=RequestMethod.POST)
	public String updateProcess(Member m, Model model,
			HttpServletRequest request, RedirectAttributes rattr) {
		m.setUSER_BMI(Double.valueOf(m.getUSER_PWEIGHT()/(m.getUSER_HEIGHT()*m.getUSER_HEIGHT())*10000));//BMI계산
		if(m.getUSER_JUMIN().substring(7,8).equals("1")) {
			m.setUSER_RMR(
					66.47+(13.75*m.getUSER_PWEIGHT())
						+(5*m.getUSER_HEIGHT())
						-Double.valueOf((6.75*(121-Integer.parseInt(m.getUSER_JUMIN().substring(0,2))+1)))
					);
		}else if(m.getUSER_JUMIN().substring(7,8).equals("3")) {
			m.setUSER_RMR(
					66.47+(13.75*m.getUSER_PWEIGHT())
						+(5*m.getUSER_HEIGHT())
							-Double.valueOf((6.75*(21-Integer.parseInt(m.getUSER_JUMIN().substring(0,2))+1)))
					);
		}else if(m.getUSER_JUMIN().substring(7,8).equals("2")) {
			m.setUSER_RMR(
					655.1+(9.56*m.getUSER_PWEIGHT())
						+(1.85*m.getUSER_HEIGHT())
							-Double.valueOf((4.68*(121-Integer.parseInt(m.getUSER_JUMIN().substring(0,2))+1)))
					);
		}else if(m.getUSER_JUMIN().substring(7,8).equals("4")) {
			m.setUSER_RMR(
					655.1+(9.56*m.getUSER_PWEIGHT())
						+(1.85*m.getUSER_HEIGHT())
							-Double.valueOf((4.68*(21-Integer.parseInt(m.getUSER_JUMIN().substring(0,2))+1)))
					);
		}else {m.setUSER_RMR(1);};
		int result = memberservice.update(m);
		if(result==1) {
			rattr.addFlashAttribute("result","updateSuccess");
			return "redirect:info";
		}else {
			model.addAttribute("url",request.getRequestURI());
			model.addAttribute("message","정보 수정 실패");
			return "error/error";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
