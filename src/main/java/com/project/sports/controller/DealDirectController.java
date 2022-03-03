package com.project.sports.controller;

import java.io.File;
import java.util.ArrayList;
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

import com.project.sports.domain.DealDirect;
import com.project.sports.service.DealService;

@Controller
@RequestMapping(value = "/DealD")
public class DealDirectController {

	private static final Logger logger = LoggerFactory.getLogger(DealAuctionController.class);

	@Autowired
	private DealService DealService;

	private String saveFolder = "C:\\Users\\82109\\git\\Sports\\Sports\\src\\main\\webapp\\resources\\dealupload2\\";

	// 메인 페이지 리스트
	@RequestMapping(value = "/list")
	public ModelAndView AutionList
	(@RequestParam(value = "page",
	defaultValue = "1", required = false) int page, 
			@RequestParam(value = "search",
			defaultValue = "", required = false) String search ,ModelAndView mv,
			@RequestParam(value = "view",
			defaultValue = "1", required = false) String view , 
			@RequestParam(value = "view2",
			defaultValue = "1", required = false) int view2 , HttpSession session  )
			
	{
		
		String sessionid = (String) session.getAttribute("USER_ID");
		int limit = 6; // 한 화면에 출력할 레코드 갯수
		
		logger.info("히드닣딓느히늳ㅎ닣"  + view2);
		
		
		int listcount = DealService.getListCount2(); // 총 리스트 수를 받아옴

		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에 보여줄 마지막 페이지 수 (10, 20 ,30 등...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;
		
		List<DealDirect> Direct = new ArrayList<DealDirect>();
		
		if(search.equals("")) {
			Direct = DealService.getDirectList(page, limit,view2); //리스트를 받아옴
		}else {
			Direct = DealService.getSearchDirecList(page,limit,search,view2);
		}
		
	
		
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("Direct",Direct);
		mv.addObject("limit",limit);
		mv.addObject("view2",view2);
		mv.addObject("sessionid",sessionid);
		mv.setViewName("sport_Deal/DealD_list");
	
		
		
		
		return mv;

	}
	
	@ResponseBody
	@RequestMapping(value="/list_ajax")
		public Map<String , Object> boardListAjax(
		@RequestParam(value="page" , defaultValue="1" , required=false) int page,
		@RequestParam(value = "search",
		defaultValue = "", required = false) String search ,
		@RequestParam(value = "view",
		defaultValue = "1", required = false) String view  
		
				){
		int limit = 6; // 한 화면에 출력할 레코드 갯수
		
		
		
		logger.info("page" + page);
		
		int listcount = DealService.getListCount2();	//총 리스트 수를 받아옴
		
		//총 페이지 수
		int maxpage=(listcount + limit-1) / limit;
		
		//현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page -1 ) / 10) * 10 + 1 ; 
		
		//현재 페이지에 보여줄 마지막 페이지 수 (10, 20 ,30 등...)
		int endpage = startpage +10 -1 ;
		
		if (endpage > maxpage)
			endpage = maxpage;
		
		List<DealDirect> Direct = new ArrayList<DealDirect>();
		
	
		
		//맵으로 합쳐 맵으로 넘겨주기
		HashMap<String , Object>map2 = new HashMap<String,Object>();
		int startrow=(page-1)*limit +1; 
		int endrow = startrow+limit-1;
		


		int view2 = Integer.parseInt(view);
		
		if(view2==1) {
			map2.put("view" , "DIR_NUMBER desc");
		}
		if(view2==2) {
			map2.put("view" , "DIR_NUMBER asc");
		}
		if(view2==3) {
			map2.put("view" , "DIR_READCOUNT desc");
		}
		if(view2==4){
			map2.put("view" , "DIR_PRICE desc");
		}
		
		map2.put("start", startrow);
		map2.put("end",endrow);
		map2.put("search_word", search);
		
		logger.info("view값" + map2.get("view"));	
		logger.info("start값 " + map2.get("start"));
		logger.info("end값 " + map2.get("end"));
		logger.info("search_word값 " + map2.get("search_word"));
		
		

		Direct = DealService.getDirectListsort(map2); //리스트를 받아옴

		
		logger.info("다이렉트사이즈" + Direct.size());
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("page",page);
		map.put("maxpage",maxpage);
		map.put("startpage",startpage);
		map.put("endpage",endpage);
		map.put("listcount",listcount);
		map.put("Direct",Direct);
		map.put("limit",limit);
		
		
		return map;
	}
	


	// 글쓰기
	@GetMapping(value = "/write")
	// @RequestMapping(value="/write", method=requestMethod.GET)
	public String Direct_write() {
		return "sport_Deal/Direct_write";
	}

	// 상세 페이지
	@GetMapping(value = "/detail")
	// @RequestMapping(value="/write", method=requestMethod.GET)
	public ModelAndView Direct_detail(int num, ModelAndView mv,
			HttpServletRequest request,
			HttpSession session) {
		
		DealDirect Direct = DealService.D_getDetail(num);
		
		//찜했던 물품인지 확인
		String sessionid = (String) session.getAttribute("USER_ID");	//현재 로그인 된 아이디
		if(sessionid !=null) {
			//찜한물품인지 확인
			Object pickcheck = DealService.pickcheck2(sessionid, num);
			if(pickcheck == null) {						//찜 했던 물품이 아님 
				mv.addObject("pickcheck", "possible");
			}else {										//찜 했던 물품임
				mv.addObject("pickcheck", "impossible");
			}
		}
		//조회수
		int count = DealService.D_readcount(num);
		
		if(Direct==null) {
			logger.info("상세보기 실패");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURL());
			mv.addObject("message", "상세보기 실패 입니다.");
		}else {
			logger.info("상세보기 성공");
			mv.setViewName("sport_Deal/Direct_detail");
			logger.info("파일" + Direct.getSAVE_DIR_FILE2());
			mv.addObject("b" ,Direct);
		}
		
		return mv;
	}


	@PostMapping("/add")
	// @RequestMapping(value="/add" , method=RequestMethod.POST)
	public String Auction_add(DealDirect Direct, HttpServletRequest request,
			HttpSession session) throws Exception {

		MultipartFile uploadfile1 = Direct.getUploadfile1();
		MultipartFile uploadfile2 = Direct.getUploadfile2();
		MultipartFile uploadfile3 = Direct.getUploadfile3();
		MultipartFile uploadfile4 = Direct.getUploadfile4();

		if (!uploadfile1.isEmpty()) {
			String fileName = uploadfile1.getOriginalFilename();// 원래 파일명
			Direct.setORI_DIR_MAINFILE(fileName);// 원래 파일명 저장
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile1.transferTo(new File(saveFolder + fileDBName));
			

			// 바뀐 파일명으로 저장
			Direct.setSAVE_DIR_MAINFILE(fileDBName);
		}

		if (!uploadfile2.isEmpty()) {
			String fileName = uploadfile2.getOriginalFilename();// 원래 파일명
			Direct.setORI_DIR_FILE2(fileName);// 원래 파일명 저장
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile2.transferTo(new File(saveFolder + fileDBName));

			// 바뀐 파일명으로 저장
			Direct.setSAVE_DIR_FILE2(fileDBName);
		} else {
			Direct.setSAVE_DIR_FILE2("0");
			Direct.setORI_DIR_FILE2("0");
		}

		if (!uploadfile3.isEmpty()) {
			String fileName = uploadfile3.getOriginalFilename();// 원래 파일명
			Direct.setORI_DIR_FILE3(fileName);// 원래 파일명 저장
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile3.transferTo(new File(saveFolder + fileDBName));

			// 바뀐 파일명으로 저장
			Direct.setSAVE_DIR_FILE3(fileDBName);
		} else {
			Direct.setSAVE_DIR_FILE3("0");
			Direct.setORI_DIR_FILE3("0");
		}

		if (!uploadfile4.isEmpty()) {
			String fileName = uploadfile4.getOriginalFilename();// 원래 파일명
			Direct.setORI_DIR_FILE4(fileName);// 원래 파일명 저장
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile4.transferTo(new File(saveFolder + fileDBName));

			// 바뀐 파일명으로 저장
			Direct.setSAVE_DIR_FILE4(fileDBName);
		} else {
			Direct.setSAVE_DIR_FILE4("0");
			Direct.setORI_DIR_FILE4("0");
		}

		logger.info("save폴더" + saveFolder);

		String sessionid = (String) session.getAttribute("USER_ID");
		
		
		Direct.setUSER_ID(sessionid);

		DealService.D_insert(Direct); // 저장메서드 호출
		
		
		return "redirect:list";
	}

	private String fileDBName(String fileName, String saveFolder) {
		// 새로운 폴더 이름 : 오늘 년+월+일
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); // 오늘 년도 구합니다.
		int month = c.get(Calendar.MONTH) + 1; // 오늘 월 구합니다.
		int date = c.get(Calendar.DATE); // 오늘 일 구합니다.

		String homedir = saveFolder;
		logger.info(homedir);
		File path1 = new File(homedir);
		if (!(path1.exists())) {
			path1.mkdir();// 새로운 폴더를 생성
		}

		// 난수를 구합니다.
		Random r = new Random();
		int random = r.nextInt(100000000);

		/***** 확장자 구하기 시작 *****/
		int index = fileName.lastIndexOf(".");
		// 문자열에서 특정 문자열의 위치 값 (index)를 반환합니다.
		// indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
		// lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
		// (파일명에 점에 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.)
		logger.info("index=" + index);

		String fileExtension = fileName.substring(index + 1);
		logger.info("fileExtension = " + fileExtension);
		/**** 확장자 구하기 끝 ***/

		// 새로운 파일명
		String refileName = "dir" + year + month + date + random + "." + fileExtension;
		logger.info("refileName = " + refileName);

		// 오라클 디비에 저장될 파일 명
		String fileDBName =   refileName;
		logger.info("fileDBName = " + fileDBName);
		return fileDBName;
	}
	
	@GetMapping("/delete")
	public String BoardDeleteAction(int num ,
			Model mv, 
			 HttpServletRequest request)
				throws Exception{
	
		
		int result = DealService.D_Delete(num);
		
		//삭제 처리 실패한 경우
		if (result==0) {
				logger.info("게시판 삭제 실패 ");
				mv.addAttribute("url",request.getRequestURL());
				mv.addAttribute("message", "삭제 실패");
				return "error/error";
		}
		
		//삭제 처리 성공한 경우 - 글 목록 보기 요청을 전송하는 부분입니다. 
		logger.info("게시판 삭제 성공");
		return "redirect:list";
	}
	
	//글 수정 뷰
	@GetMapping("/modifyView")
	public ModelAndView BoardModifyView(int num,
				ModelAndView mv,
				HttpServletRequest request) {
		DealDirect Direct = DealService.D_getDetail(num);
		
		//글 내용 불러오기 실패한 경우입니다. 
		if (Direct==null) {
			logger.info("수정보기 실패");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURL());
			mv.addObject("message","수정보기 실패입니다.");
			return mv;
		}
		logger.info("(수정)상세보기 성공");
		//수정 폼 페이지로 이동할 때 원문 글 내용을 보여주기 때문에 boarddata 개게를 
		//ModelAndView 객체에 저장합니다. 
		mv.addObject("d", Direct);
		logger.info("성진" + Direct.getORI_DIR_FILE2());
		//글 수정 폼 페이지로 이도아기위해 경로를 설정합니다.
		mv.setViewName("sport_Deal/DealD_modify");
		
		return mv;
	}
	@PostMapping("/modifyAction")
	public String BoardModifyAction( DealDirect Direct, 
			String check , String check2 , String check3,
			String check4 , Model mv, HttpServletRequest request,
			RedirectAttributes rattr ,int num) throws Exception {
		
		DealDirect Direct2 = DealService.D_getDetail(num);
		Direct.setDIR_NUMBER(num);
		
		MultipartFile uploadfile1 = Direct.getUploadfile1();
		MultipartFile uploadfile2= Direct.getUploadfile2();
		MultipartFile uploadfile3 = Direct.getUploadfile3();
		MultipartFile uploadfile4 = Direct.getUploadfile4();
		//String saveFolder = 
				//request.getSession().getServletContext().getRealPath("resources") + "/upload/";
		
		if(check!=null && !check.equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("기존파일 그대로 사용합니다.");
			Direct.setORI_DIR_MAINFILE(check);
			Direct.setSAVE_DIR_MAINFILE(Direct2.getSAVE_DIR_MAINFILE());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//위 문장 때문에 board.setBAORD_FILE()값은 자동 저장됩니다. 
			
		}else {
			
			if(!uploadfile1.isEmpty()) {
				logger.info("파일 변경되었습니다.");
				
				
				String fileName = uploadfile1.getOriginalFilename(); //원래 파일명
				Direct.setORI_DIR_MAINFILE(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다. 
				uploadfile1.transferTo(new File(saveFolder + fileDBName));
				
				//바뀐 파일며으로 저장 
				Direct.setSAVE_DIR_MAINFILE(fileDBName);
				
			} else { //uploadfile.isEmpty() 인 경우 - 파일 선택하지 않은 경우
				logger.info("선택 파일 없습니다.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//위 태그에 값이 있다면 ""로 값을 변경합니다.
				Direct.setORI_DIR_MAINFILE("0");//""로 초기화 합니다.
				Direct.setSAVE_DIR_MAINFILE("0");//""로 초기화 합니다.
			}//else end
		}// else end 
		
		if(check2!=null && !check2.equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("기존파일 그대로 사용합니다.");
			Direct.setORI_DIR_FILE2(check2);
			Direct.setSAVE_DIR_FILE2(Direct2.getSAVE_DIR_FILE2());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//위 문장 때문에 board.setBAORD_FILE()값은 자동 저장됩니다. 
			
		}else {
			
			if(!uploadfile2.isEmpty()) {
				logger.info("파일 변경되었습니다.");
				
				
				String fileName = uploadfile2.getOriginalFilename(); //원래 파일명
				Direct.setORI_DIR_FILE2(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다. 
				uploadfile2.transferTo(new File(saveFolder + fileDBName));
				
				//바뀐 파일며으로 저장 
				Direct.setSAVE_DIR_FILE2(fileDBName);
				
			} else { //uploadfile.isEmpty() 인 경우 - 파일 선택하지 않은 경우
				logger.info("선택 파일 없습니다.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//위 태그에 값이 있다면 ""로 값을 변경합니다.
				Direct.setSAVE_DIR_FILE2("0");
				Direct.setORI_DIR_FILE2("0");
			}//else end
		}// else end
		
		if(check3!=null && !check3.equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("기존파일 그대로 사용합니다.");
			Direct.setORI_DIR_FILE3(check3);
			Direct.setSAVE_DIR_FILE3(Direct2.getSAVE_DIR_FILE3());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//위 문장 때문에 board.setBAORD_FILE()값은 자동 저장됩니다. 
			
		}else {
			
			if(!uploadfile3.isEmpty()) {
				logger.info("파일 변경되었습니다.");
				
				
				String fileName = uploadfile3.getOriginalFilename(); //원래 파일명
				Direct.setORI_DIR_FILE3(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다. 
				uploadfile3.transferTo(new File(saveFolder + fileDBName));
				
				//바뀐 파일며으로 저장 
				Direct.setSAVE_DIR_FILE3(fileDBName);
				
			} else { //uploadfile.isEmpty() 인 경우 - 파일 선택하지 않은 경우
				logger.info("선택 파일 없습니다.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//위 태그에 값이 있다면 ""로 값을 변경합니다.
				Direct.setSAVE_DIR_FILE3("0");
				Direct.setORI_DIR_FILE3("0");
			}//else end
		}// else end
		
		if(check4!=null && !check4.equals("")) { //기존파일 그대로 사용하는 경우입니다.
			logger.info("기존파일 그대로 사용합니다.");
			Direct.setORI_DIR_FILE4(check4);
			Direct.setSAVE_DIR_FILE4(Direct2.getSAVE_DIR_FILE4());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//위 문장 때문에 board.setBAORD_FILE()값은 자동 저장됩니다. 
			
		}else {
			
			if(!uploadfile4.isEmpty()) {
				logger.info("파일 변경되었습니다.");
				
				
				String fileName = uploadfile4.getOriginalFilename(); //원래 파일명
				Direct.setORI_DIR_FILE4(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다. 
				uploadfile4.transferTo(new File(saveFolder + fileDBName));
				
				//바뀐 파일며으로 저장 
				Direct.setSAVE_DIR_FILE4(fileDBName);
				
			} else { //uploadfile.isEmpty() 인 경우 - 파일 선택하지 않은 경우
				logger.info("선택 파일 없습니다.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//위 태그에 값이 있다면 ""로 값을 변경합니다.
				Direct.setSAVE_DIR_FILE4("0");
				Direct.setORI_DIR_FILE4("0");
			}//else end
		}// else end
		
		logger.info("DIR_SUBJECT" + Direct.getDIR_SUBJECT());
		logger.info("DIR_PHONE" + Direct.getDIR_PHONE());
		logger.info("DIR_ADDRESS" + Direct.getDIR_ADDRESS());
		logger.info("DIR_PRICE" + Direct.getDIR_PRICE());
		logger.info("DIR_CONTENT" + Direct.getDIR_CONTENT());
		logger.info("ORI_DIR_MAINFILE" + Direct.getORI_DIR_MAINFILE());
		logger.info("SAVE_DIR_MAINFILE" + Direct.getSAVE_DIR_MAINFILE());
		logger.info("ORI_DIR_FILE2" + Direct.getORI_DIR_FILE2());
		logger.info("SAVE_DIR_FILE2" + Direct.getSAVE_DIR_FILE2());
		logger.info("ORI_DIR_FILE3" + Direct.getORI_DIR_FILE3());
		logger.info("SAVE_DIR_FILE3" + Direct.getSAVE_DIR_FILE3());
		logger.info("ORI_DIR_FILE4" + Direct.getORI_DIR_FILE4());
		logger.info("SAVE_DIR_FILE4" + Direct.getSAVE_DIR_FILE4());
		String url ="";
		// DAO에서 수정 메서드 호출하여 수정합니다. 
		int result = DealService.D_Modify(Direct);
		//수정에 실패한 경우 
		if (result ==0) {
			logger.info("게시판 수정 실패");
			mv.addAttribute("url",request.getRequestURL());
			mv.addAttribute("message", "게시판 술정 실패");
			url = "error/error";
		}else {//수정 성공의 경우
			logger.info("게시판 수정 완료");
			// 수정한 글 내용을 보여주기 위해글 내용 보기 보기 페이지로 이동하기위해 경로를 설정합니다.
			url = "redirect:detail";
			rattr.addAttribute("num", Direct.getDIR_NUMBER());
			
		
		}
		return url;
	}
	
	//직거래 찜하기
	@RequestMapping(value="/pick")
	public String Auctionpick(RedirectAttributes rattr , 
			HttpServletRequest request , int num,
			HttpSession session) {
				
		String sessionid = (String) session.getAttribute("USER_ID");
		
			
			
		//찜하기 등록
		DealService.Direct_pick(sessionid , num);
			
		return "redirect:list";
	}
	
	@RequestMapping(value="/question2")
	public String question(int num , 
			HttpSession session ,
			String sub , String sellid , String content) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//문의글 등록
		DealService.questioninput2(sessionid , num , sub , sellid, content);
		
		logger.info("sessionid  " + sessionid);
		logger.info("num  " + num);
		logger.info("sub  " + sub);
		logger.info("sellid  " + sellid);
		logger.info("content  " + content);
		
		
		return"redirect:list";
		
		
	}

}
