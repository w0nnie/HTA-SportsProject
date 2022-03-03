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
@Component�� �̿��ؼ� ������ �����̳ʰ� �ش� Ŭ���� ��ü�� �����ϵ��� ������ �� ������
��� Ŭ������ @Component�� �Ҵ��ϸ� � Ŭ������ � ������ �ϴ��� �ľ�����
��ƽ��ϴ�. ������ �����ӿ�ũ������ �̷� Ŭ�������� �з��ϱ� ���ؼ�
@Component�� ����Ͽ� ������ ���� 3���� �ֳ����̼��� �����մϴ�.

1. @Controller - ������� ��û�� �����ϴ� Controller Ŭ����
2. @Repository - DB������ ó���ϴ� DAO Ŭ����
3. @Service - ����Ͻ� ������ ó���ϴ� Service Ŭ����
 */
@Controller
@RequestMapping(value="/member")//http://localhost:8088/myhome6/member/�� �����ϴ� �ּ� ����
public class MemberController {
	private static final Logger logger
	= LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberservice;
	
	//�强���߰� (10-15)
	@Autowired
	private MyDealService mydealservice;
	
/*
@CookieValue(value="saveid", required=false) Cookie readCookie
�̸��� saveid�� ��Ű�� Cookie Ÿ������ ���޹޽��ϴ�.
������ �̸��� ��Ű�� �������� ���� ���� �ֱ� ������ required=false�� �����ؾ� �մϴ�.
��, id ����ϱ⸦ �������� ���� ���� �ֱ� ������ required=false�� �����ؾ� �մϴ�.
required=true ���¿��� ������ �̸��� ���� ��Ű�� �������� ������ ������ MVC�� �ͼ����� �߻���ŵ�ϴ�.
 */
	
//http://localhost:8088/myhome6/login �α��� �� �̵�
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv,
//Model:���� �����ϴ°�, View:���� �����ִ°�
//Model�� ����� ��� String���� ����
//ModelAndView�� addObject�� ���� �������� setViewName���� �����ش�.
			@CookieValue(value="saveid", required=false) Cookie readCookie
			) {
		if(readCookie != null) {
			mv.addObject("saveid",readCookie.getValue());
			logger.info("cookie time=" + readCookie.getMaxAge());
		}
		mv.setViewName("sports_member/login");
		return mv;
	}
	
	//ȸ������ �� �̵�
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
		return "sports_member/join";//WEB-INF/views/sports_member/join.jsp
	}
	
	//ȸ������ �� ���̵� �˻�
	@RequestMapping(value="/idcheck", method=RequestMethod.GET)
	public void idcheck(@RequestParam("id") String id,
			HttpServletResponse response) throws Exception{
		int result = memberservice.isId(id);//idId���� �Ѿ�� int��
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	//ȸ������ ���� ���� ����
	@RequestMapping(value="/joinProcess", method=RequestMethod.POST)
	public String joinProcess(Member m,//Member : command ��ü
			RedirectAttributes rattr, Model model,String[] USER_PSPORTS,
			HttpServletRequest request) throws Exception{
			m.setUSER_MOBILE(m.getMOBILE1()+m.getMOBILE2()+m.getMOBILE3());
			m.setUSER_ADDRESS(m.getDONG()+m.getHOME()+m.getHOMEADDRESS());
			m.setUSER_JUMIN(m.getJUMIN()+m.getJUMIN1());
			m.setUSER_EMAIL(m.getUSER_EMAIL()+"@"+m.getUSER_EMAILDOMAIN());
			m.setUSER_BMI(Double.valueOf(m.getUSER_PWEIGHT()/(m.getUSER_HEIGHT()*m.getUSER_HEIGHT())*10000));//BMI���
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
		//(����:66.47+(13.75*���������)+(5*Ű)-(6.75*����)
		//(����:655.1+(9.56*���������)+(1.85*Ű)-(4.68*����)
		int result = memberservice.insert(m);
		
		//ȸ�����Խ� ����Ʈ db �ڵ����� (�强��10-15 �߰�)
		String user_id = m.getUSER_ID();
		mydealservice.pointdb(user_id);
		
		//������ �� ���
		if(result==1) {
			rattr.addFlashAttribute("result","joinSuccess");
			return "redirect:login";
		}else {
			model.addAttribute("url",request.getRequestURL());
			model.addAttribute("message","ȸ�� ���� ����");
			return "error/error";
		}
	}
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(//������°�
			@RequestParam("USER_ID") String id,
			@RequestParam("USER_PASS") String password,
			@RequestParam(value="remember",defaultValue="",required=false)
			String remember,
			HttpSession session, RedirectAttributes rattr,
			HttpServletResponse response) throws Exception{
		int result = memberservice.isId(id, password);
		logger.info("���: " + result);
		
		if(result == 1) {
			//�α��� ����
			session.setAttribute("USER_ID", id);
			Cookie savecookie = new Cookie("saveid",id);
			if(!remember.equals("")) {
				savecookie.setMaxAge(60*60);
				logger.info("��Ű���� : 60*60");
			}else {
				logger.info("��Ű���� : 0");
				savecookie.setMaxAge(0);
			}
			response.addCookie(savecookie);
			return "redirect:/main/mainPage";//boardController��
		}else {
			rattr.addFlashAttribute("result",result);
			return "redirect:login";
		}
		
	}
	//ȸ�� ��������
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public ModelAndView member_info(HttpSession session,//�Ķ���ͷ� �Ѿ�� �̸� �� id��� �̸��� ���� �ִ� ��
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
		m.setUSER_BMI(Double.valueOf(m.getUSER_PWEIGHT()/(m.getUSER_HEIGHT()*m.getUSER_HEIGHT())*10000));//BMI���
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
			model.addAttribute("message","���� ���� ����");
			return "error/error";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
