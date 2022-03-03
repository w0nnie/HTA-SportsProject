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

	// ���� ������ ����Ʈ
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
		int limit = 6; // �� ȭ�鿡 ����� ���ڵ� ����
		
		logger.info("���刢�������w����"  + view2);
		
		
		int listcount = DealService.getListCount2(); // �� ����Ʈ ���� �޾ƿ�

		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� �������� ������ ������ ������ �� (10, 20 ,30 ��...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;
		
		List<DealDirect> Direct = new ArrayList<DealDirect>();
		
		if(search.equals("")) {
			Direct = DealService.getDirectList(page, limit,view2); //����Ʈ�� �޾ƿ�
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
		int limit = 6; // �� ȭ�鿡 ����� ���ڵ� ����
		
		
		
		logger.info("page" + page);
		
		int listcount = DealService.getListCount2();	//�� ����Ʈ ���� �޾ƿ�
		
		//�� ������ ��
		int maxpage=(listcount + limit-1) / limit;
		
		//���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page -1 ) / 10) * 10 + 1 ; 
		
		//���� �������� ������ ������ ������ �� (10, 20 ,30 ��...)
		int endpage = startpage +10 -1 ;
		
		if (endpage > maxpage)
			endpage = maxpage;
		
		List<DealDirect> Direct = new ArrayList<DealDirect>();
		
	
		
		//������ ���� ������ �Ѱ��ֱ�
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
		
		logger.info("view��" + map2.get("view"));	
		logger.info("start�� " + map2.get("start"));
		logger.info("end�� " + map2.get("end"));
		logger.info("search_word�� " + map2.get("search_word"));
		
		

		Direct = DealService.getDirectListsort(map2); //����Ʈ�� �޾ƿ�

		
		logger.info("���̷�Ʈ������" + Direct.size());
		
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
	


	// �۾���
	@GetMapping(value = "/write")
	// @RequestMapping(value="/write", method=requestMethod.GET)
	public String Direct_write() {
		return "sport_Deal/Direct_write";
	}

	// �� ������
	@GetMapping(value = "/detail")
	// @RequestMapping(value="/write", method=requestMethod.GET)
	public ModelAndView Direct_detail(int num, ModelAndView mv,
			HttpServletRequest request,
			HttpSession session) {
		
		DealDirect Direct = DealService.D_getDetail(num);
		
		//���ߴ� ��ǰ���� Ȯ��
		String sessionid = (String) session.getAttribute("USER_ID");	//���� �α��� �� ���̵�
		if(sessionid !=null) {
			//���ѹ�ǰ���� Ȯ��
			Object pickcheck = DealService.pickcheck2(sessionid, num);
			if(pickcheck == null) {						//�� �ߴ� ��ǰ�� �ƴ� 
				mv.addObject("pickcheck", "possible");
			}else {										//�� �ߴ� ��ǰ��
				mv.addObject("pickcheck", "impossible");
			}
		}
		//��ȸ��
		int count = DealService.D_readcount(num);
		
		if(Direct==null) {
			logger.info("�󼼺��� ����");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURL());
			mv.addObject("message", "�󼼺��� ���� �Դϴ�.");
		}else {
			logger.info("�󼼺��� ����");
			mv.setViewName("sport_Deal/Direct_detail");
			logger.info("����" + Direct.getSAVE_DIR_FILE2());
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
			String fileName = uploadfile1.getOriginalFilename();// ���� ���ϸ�
			Direct.setORI_DIR_MAINFILE(fileName);// ���� ���ϸ� ����
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile1.transferTo(new File(saveFolder + fileDBName));
			

			// �ٲ� ���ϸ����� ����
			Direct.setSAVE_DIR_MAINFILE(fileDBName);
		}

		if (!uploadfile2.isEmpty()) {
			String fileName = uploadfile2.getOriginalFilename();// ���� ���ϸ�
			Direct.setORI_DIR_FILE2(fileName);// ���� ���ϸ� ����
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile2.transferTo(new File(saveFolder + fileDBName));

			// �ٲ� ���ϸ����� ����
			Direct.setSAVE_DIR_FILE2(fileDBName);
		} else {
			Direct.setSAVE_DIR_FILE2("0");
			Direct.setORI_DIR_FILE2("0");
		}

		if (!uploadfile3.isEmpty()) {
			String fileName = uploadfile3.getOriginalFilename();// ���� ���ϸ�
			Direct.setORI_DIR_FILE3(fileName);// ���� ���ϸ� ����
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile3.transferTo(new File(saveFolder + fileDBName));

			// �ٲ� ���ϸ����� ����
			Direct.setSAVE_DIR_FILE3(fileDBName);
		} else {
			Direct.setSAVE_DIR_FILE3("0");
			Direct.setORI_DIR_FILE3("0");
		}

		if (!uploadfile4.isEmpty()) {
			String fileName = uploadfile4.getOriginalFilename();// ���� ���ϸ�
			Direct.setORI_DIR_FILE4(fileName);// ���� ���ϸ� ����
			// String saveFolder =
			// request.getSession().getServletContext().getRealPath("resources")
			// + "/upload/";
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);

			// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile4.transferTo(new File(saveFolder + fileDBName));

			// �ٲ� ���ϸ����� ����
			Direct.setSAVE_DIR_FILE4(fileDBName);
		} else {
			Direct.setSAVE_DIR_FILE4("0");
			Direct.setORI_DIR_FILE4("0");
		}

		logger.info("save����" + saveFolder);

		String sessionid = (String) session.getAttribute("USER_ID");
		
		
		Direct.setUSER_ID(sessionid);

		DealService.D_insert(Direct); // ����޼��� ȣ��
		
		
		return "redirect:list";
	}

	private String fileDBName(String fileName, String saveFolder) {
		// ���ο� ���� �̸� : ���� ��+��+��
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); // ���� �⵵ ���մϴ�.
		int month = c.get(Calendar.MONTH) + 1; // ���� �� ���մϴ�.
		int date = c.get(Calendar.DATE); // ���� �� ���մϴ�.

		String homedir = saveFolder;
		logger.info(homedir);
		File path1 = new File(homedir);
		if (!(path1.exists())) {
			path1.mkdir();// ���ο� ������ ����
		}

		// ������ ���մϴ�.
		Random r = new Random();
		int random = r.nextInt(100000000);

		/***** Ȯ���� ���ϱ� ���� *****/
		int index = fileName.lastIndexOf(".");
		// ���ڿ����� Ư�� ���ڿ��� ��ġ �� (index)�� ��ȯ�մϴ�.
		// indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�,
		// lastIndexOf�� ���������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�.
		// (���ϸ� ���� ������ ���� ��� �� �������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
		logger.info("index=" + index);

		String fileExtension = fileName.substring(index + 1);
		logger.info("fileExtension = " + fileExtension);
		/**** Ȯ���� ���ϱ� �� ***/

		// ���ο� ���ϸ�
		String refileName = "dir" + year + month + date + random + "." + fileExtension;
		logger.info("refileName = " + refileName);

		// ����Ŭ ��� ����� ���� ��
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
		
		//���� ó�� ������ ���
		if (result==0) {
				logger.info("�Խ��� ���� ���� ");
				mv.addAttribute("url",request.getRequestURL());
				mv.addAttribute("message", "���� ����");
				return "error/error";
		}
		
		//���� ó�� ������ ��� - �� ��� ���� ��û�� �����ϴ� �κ��Դϴ�. 
		logger.info("�Խ��� ���� ����");
		return "redirect:list";
	}
	
	//�� ���� ��
	@GetMapping("/modifyView")
	public ModelAndView BoardModifyView(int num,
				ModelAndView mv,
				HttpServletRequest request) {
		DealDirect Direct = DealService.D_getDetail(num);
		
		//�� ���� �ҷ����� ������ ����Դϴ�. 
		if (Direct==null) {
			logger.info("�������� ����");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURL());
			mv.addObject("message","�������� �����Դϴ�.");
			return mv;
		}
		logger.info("(����)�󼼺��� ����");
		//���� �� �������� �̵��� �� ���� �� ������ �����ֱ� ������ boarddata ���Ը� 
		//ModelAndView ��ü�� �����մϴ�. 
		mv.addObject("d", Direct);
		logger.info("����" + Direct.getORI_DIR_FILE2());
		//�� ���� �� �������� �̵��Ʊ����� ��θ� �����մϴ�.
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
		
		if(check!=null && !check.equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("�������� �״�� ����մϴ�.");
			Direct.setORI_DIR_MAINFILE(check);
			Direct.setSAVE_DIR_MAINFILE(Direct2.getSAVE_DIR_MAINFILE());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//�� ���� ������ board.setBAORD_FILE()���� �ڵ� ����˴ϴ�. 
			
		}else {
			
			if(!uploadfile1.isEmpty()) {
				logger.info("���� ����Ǿ����ϴ�.");
				
				
				String fileName = uploadfile1.getOriginalFilename(); //���� ���ϸ�
				Direct.setORI_DIR_MAINFILE(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
				uploadfile1.transferTo(new File(saveFolder + fileDBName));
				
				//�ٲ� ���ϸ����� ���� 
				Direct.setSAVE_DIR_MAINFILE(fileDBName);
				
			} else { //uploadfile.isEmpty() �� ��� - ���� �������� ���� ���
				logger.info("���� ���� �����ϴ�.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//�� �±׿� ���� �ִٸ� ""�� ���� �����մϴ�.
				Direct.setORI_DIR_MAINFILE("0");//""�� �ʱ�ȭ �մϴ�.
				Direct.setSAVE_DIR_MAINFILE("0");//""�� �ʱ�ȭ �մϴ�.
			}//else end
		}// else end 
		
		if(check2!=null && !check2.equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("�������� �״�� ����մϴ�.");
			Direct.setORI_DIR_FILE2(check2);
			Direct.setSAVE_DIR_FILE2(Direct2.getSAVE_DIR_FILE2());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//�� ���� ������ board.setBAORD_FILE()���� �ڵ� ����˴ϴ�. 
			
		}else {
			
			if(!uploadfile2.isEmpty()) {
				logger.info("���� ����Ǿ����ϴ�.");
				
				
				String fileName = uploadfile2.getOriginalFilename(); //���� ���ϸ�
				Direct.setORI_DIR_FILE2(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
				uploadfile2.transferTo(new File(saveFolder + fileDBName));
				
				//�ٲ� ���ϸ����� ���� 
				Direct.setSAVE_DIR_FILE2(fileDBName);
				
			} else { //uploadfile.isEmpty() �� ��� - ���� �������� ���� ���
				logger.info("���� ���� �����ϴ�.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//�� �±׿� ���� �ִٸ� ""�� ���� �����մϴ�.
				Direct.setSAVE_DIR_FILE2("0");
				Direct.setORI_DIR_FILE2("0");
			}//else end
		}// else end
		
		if(check3!=null && !check3.equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("�������� �״�� ����մϴ�.");
			Direct.setORI_DIR_FILE3(check3);
			Direct.setSAVE_DIR_FILE3(Direct2.getSAVE_DIR_FILE3());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//�� ���� ������ board.setBAORD_FILE()���� �ڵ� ����˴ϴ�. 
			
		}else {
			
			if(!uploadfile3.isEmpty()) {
				logger.info("���� ����Ǿ����ϴ�.");
				
				
				String fileName = uploadfile3.getOriginalFilename(); //���� ���ϸ�
				Direct.setORI_DIR_FILE3(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
				uploadfile3.transferTo(new File(saveFolder + fileDBName));
				
				//�ٲ� ���ϸ����� ���� 
				Direct.setSAVE_DIR_FILE3(fileDBName);
				
			} else { //uploadfile.isEmpty() �� ��� - ���� �������� ���� ���
				logger.info("���� ���� �����ϴ�.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//�� �±׿� ���� �ִٸ� ""�� ���� �����մϴ�.
				Direct.setSAVE_DIR_FILE3("0");
				Direct.setORI_DIR_FILE3("0");
			}//else end
		}// else end
		
		if(check4!=null && !check4.equals("")) { //�������� �״�� ����ϴ� ����Դϴ�.
			logger.info("�������� �״�� ����մϴ�.");
			Direct.setORI_DIR_FILE4(check4);
			Direct.setSAVE_DIR_FILE4(Direct2.getSAVE_DIR_FILE4());
			//<input type="hidden" name = "BOARD_FILE" value="${baorddata.BAORD_FILE}">
			//�� ���� ������ board.setBAORD_FILE()���� �ڵ� ����˴ϴ�. 
			
		}else {
			
			if(!uploadfile4.isEmpty()) {
				logger.info("���� ����Ǿ����ϴ�.");
				
				
				String fileName = uploadfile4.getOriginalFilename(); //���� ���ϸ�
				Direct.setORI_DIR_FILE4(fileName);
				
				String fileDBName = fileDBName(fileName, saveFolder);
				
				//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
				uploadfile4.transferTo(new File(saveFolder + fileDBName));
				
				//�ٲ� ���ϸ����� ���� 
				Direct.setSAVE_DIR_FILE4(fileDBName);
				
			} else { //uploadfile.isEmpty() �� ��� - ���� �������� ���� ���
				logger.info("���� ���� �����ϴ�.");
				//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
				//�� �±׿� ���� �ִٸ� ""�� ���� �����մϴ�.
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
		// DAO���� ���� �޼��� ȣ���Ͽ� �����մϴ�. 
		int result = DealService.D_Modify(Direct);
		//������ ������ ��� 
		if (result ==0) {
			logger.info("�Խ��� ���� ����");
			mv.addAttribute("url",request.getRequestURL());
			mv.addAttribute("message", "�Խ��� ���� ����");
			url = "error/error";
		}else {//���� ������ ���
			logger.info("�Խ��� ���� �Ϸ�");
			// ������ �� ������ �����ֱ� ���ر� ���� ���� ���� �������� �̵��ϱ����� ��θ� �����մϴ�.
			url = "redirect:detail";
			rattr.addAttribute("num", Direct.getDIR_NUMBER());
			
		
		}
		return url;
	}
	
	//���ŷ� ���ϱ�
	@RequestMapping(value="/pick")
	public String Auctionpick(RedirectAttributes rattr , 
			HttpServletRequest request , int num,
			HttpSession session) {
				
		String sessionid = (String) session.getAttribute("USER_ID");
		
			
			
		//���ϱ� ���
		DealService.Direct_pick(sessionid , num);
			
		return "redirect:list";
	}
	
	@RequestMapping(value="/question2")
	public String question(int num , 
			HttpSession session ,
			String sub , String sellid , String content) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//���Ǳ� ���
		DealService.questioninput2(sessionid , num , sub , sellid, content);
		
		logger.info("sessionid  " + sessionid);
		logger.info("num  " + num);
		logger.info("sub  " + sub);
		logger.info("sellid  " + sellid);
		logger.info("content  " + content);
		
		
		return"redirect:list";
		
		
	}

}
