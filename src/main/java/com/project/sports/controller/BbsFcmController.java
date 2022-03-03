package com.project.sports.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.sports.domain.BBS_FCM;
import com.project.sports.service.Bbs_FcmService;

@Controller
@RequestMapping(value="/BBS_FCM")
public class BbsFcmController {
	private static final Logger Logger
	= LoggerFactory.getLogger(BbsFcmController.class);

	@Autowired
	private Bbs_FcmService FcmService;
	
	@ResponseBody
	@PostMapping(value = "/list")
	public Map<String,Object> CommentList(int FR_NO, int page){
		List<BBS_FCM> list = FcmService.getFcmList(FR_NO, page);
		int listcount = FcmService.getListCount(FR_NO);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("listcount", listcount);
		Logger.info("listcount=" + listcount);
		for(BBS_FCM fcm : list) {
			Logger.info("1" + fcm.getUSER_ID());
			Logger.info("2" + fcm.getFCM_CONTENT());
			Logger.info("3" + fcm.getFCM_REF_DATE());
		}
		return map;
	}
	
	@GetMapping(value = "/add")
	public void CommentAdd(BBS_FCM fcm, HttpServletResponse response)
			throws Exception{
		int ok = FcmService.FcmInsert(fcm);
		Logger.info("ok=" + ok);
		response.getWriter().print(ok);
	}
	
	@PostMapping(value= "/delete")
	public void CommentDelete(int num, HttpServletResponse response)throws Exception{
								//int num => Integer.parseInt(request.getParameter("num"))
			int result = FcmService.FcmDelete(num);
			Logger.info("num =" + num);
			response.getWriter().print(result);
	}
	
	@GetMapping(value="/update")
	public void CommentUpdate(BBS_FCM fcm, HttpServletResponse response) throws Exception{
			int ok = FcmService.FcmUpdate(fcm);
			Logger.info("fcm=" + fcm);
			response.getWriter().print(ok);
	}
	
}


