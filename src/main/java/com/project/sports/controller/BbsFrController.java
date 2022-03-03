package com.project.sports.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.sports.domain.BBS_FR;
import com.project.sports.service.Bbs_FcmService;
import com.project.sports.service.Bbs_FrService;

@Controller
@RequestMapping(value="/BBS_FR")
	public class BbsFrController {

	private static final Logger logger
	= LoggerFactory.getLogger(BbsFrController.class);

	@Autowired
	private Bbs_FrService FrService;
	
	@Autowired
	private Bbs_FcmService FcmService;
	
	private String saveFolder = "C:\\Users\\���ֿ�\\git\\Sports\\Sports\\src\\main\\webapp\\resources\\BBS_FRupload\\";
	
	private String fileDBName(String fileName, String saveFolder) {
		//���ο� ���� �̸� : ���� �� + �� + ��
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); //���� ���� ���մϴ�.
		int month = c.get(Calendar.MONTH) + 1; //���� �� ���մϴ�.
		int date = c.get(Calendar.DATE); //���� �� ���մϴ�.
		
		String homedir = saveFolder + year + "_" + month + "_" + date;
		logger.info(homedir);
		File path1 = new File(homedir);
		if(!(path1.exists())) {
			path1.mkdir();//���ο� ������ ����
		}
		
		//������ ���մϴ�.
		Random r = new Random();
		int random = r.nextInt(100000000);
		
		/**** Ȯ���� ���ϱ� ���� *****/
		int index = fileName.lastIndexOf(".");
		//���ڿ����� Ư�� ���ڿ��� ��ġ ��(index)�� ��ȯ�մϴ�.
		//indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�
		// lastIndexOf�� ���������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�.
		// (���ϸ� ���� ���� �� ���� ��� �� �������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
		logger.info("index = " + index);
		
		String fileExtension = fileName.substring(index + 1);
		logger.info("fileExtension = " + fileExtension);
		/**** Ȯ���� ���ϱ� �� ****/
		
		//���ο� ���ϸ�
		String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		logger.info("refileName = " + refileName);
		
		//����Ŭ ��� ����� ���� ��
		String fileDBName = "/" + year + "_" + month + "_" +date + "/" + refileName;
		logger.info("fileDBName = " + fileDBName);
		return fileDBName;
	} 
	//����Ʈ
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView List(
			@RequestParam(value="page",defaultValue="1",required=false) int page,
			@RequestParam(value="search_field", defaultValue="-1", required = false)
			int index,
			@RequestParam(value="search_word", defaultValue="", required = false)
			String search_word,
			ModelAndView mv) {
		int limit = 10;	// �� ȭ�鿡 ����� ���ڵ� ����
		
		
		if(index == 0) {// ī�װ� ������ ���
			switch(search_word) {
			case "����":
				search_word = "1";
				break;
			case "���":
				search_word = "2";
				break;
			case "����":
				search_word = "3";
				break;	
			case "���Ʈ��":
				search_word = "4";
				break;
			}
			
		}
		int listcount =FrService.getSearchListCount(index, search_word); //�� ����Ʈ ���� �޾ƿ�
		
		//�� ������ ��
		int maxpage = (listcount + limit -1) / limit;
		
		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//���� �������� ������ ������ ������ �� (10, 20, 30 ��...)
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage)
			endpage = maxpage;
		
		List<BBS_FR> boardlist = FrService.getSearchList(index, search_word, page, limit);
		logger.info("boardlist =" + boardlist);

		mv.setViewName("sports_fr/Bbs_FrList");
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("boardlist",boardlist);
		mv.addObject("limit",limit);
		mv.addObject("search_field",index);
		mv.addObject("search_word",search_word);
		return mv;
	}
	
	
	//�۾��� 
	@RequestMapping(value="/write", method=RequestMethod.GET)
		public String board_write() {
			return "sports_fr/Bbs_FrWrite";
		}

	
	@PostMapping("/add")
	//@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(BBS_FR board, HttpServletRequest request)
			throws Exception {
		
		MultipartFile uploadfile = board.getUploadfile();
		
		if(!uploadfile.isEmpty()) {
			String fileName = uploadfile.getOriginalFilename();//���� ���ϸ�
			board.setFR_ORIGINAL(fileName);	//���� ���ϸ� ����
			
			/*
			 * String saveFolder =
			 * request.getSession().getServletContext().getRealPath("resources") +
			 * "/BBS_FRupload/";
			 */
			 
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName= " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
			uploadfile.transferTo(new File(saveFolder + fileDBName));
			
			
			//�ٲ� ���ϸ����� ����
			board.setFR_FILE(fileDBName);
			
		}
		logger.info("save����" + saveFolder);
		//�з�
		logger.info("�з� �� : " + board.getFR_CSFC());
		
		//board.setUSER_ID("admin01"); //����
		
		FrService.insertBoard(board); //����޼��� ȣ��
		
		return "redirect:list";
	 
}
	@GetMapping(value="/detail")
	public ModelAndView Detail (int num, ModelAndView mv,
			HttpServletRequest request) {

		BBS_FR board = FrService.getDetail(num);
		logger.info("num:" + num);
		//board=null;//error ������ �̵� Ȯ���ϰ��� ���Ƿ� �����մϴ�.
		if(board==null) {
			logger.info("�󼼺��� ����");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURL());
			mv.addObject("message", "�󼼺��� �����Դϴ�.");
		}else {
			logger.info("�󼼺��� ����");
			int count = FcmService.getListCount(num);
			mv.setViewName("sports_fr/Bbs_FrView");
			mv.addObject("count", count);
			mv.addObject("boarddata", board);
		}
		logger.info("�з� �� : " + board.getFR_CSFC());
		return mv;
	}
	
	 @PostMapping("/delete")
	 public String BoardDeleteAction(
			@RequestParam(value="FR_NO",defaultValue="0",required=false) int num,
			 String FR_PASS, Model mv,
			 RedirectAttributes rattr,
			 HttpServletRequest request
			 ) throws Exception {
		// �� ���� ����� ��û�� ����ڰ� ���� �ۼ��� ��������� �Ǵ��ϱ� ����
		// �Է��� ��й�ȣ�� ����� ��й�ȣ�� ���Ͽ� ��ġ�ϸ� �����մϴ�.
		 boolean usercheck = FrService.isFrWriter(num, FR_PASS);
		 	logger.info("num" + num);
		// ��й�ȣ ��ġ���� �ʴ� ���
		if (usercheck == false) {
			rattr.addFlashAttribute("result","passFail");
			rattr.addAttribute("num",num);
			return "redirect:detail";
		}
		
		// ��й�ȣ ��ġ�ϴ� ��� ���� ó�� �մϴ�.
		int result = FrService.FrDelete(num);
			logger.info("result:" + result);
		//���� ó�� ������ ���
		if(result == 0) {
			logger.info("�Խ��� ���� ����");
			mv.addAttribute("url", request.getRequestURL());
			mv.addAttribute("message", "��������");
			return "error/error";
							
		}
		//���� ó�� ������ ��� - �� ��� ���� ��û�� �����ϴ� �κ��Դϴ�.
			logger.info("�Խ��� ���� ����");
			rattr.addFlashAttribute("result","deleteSuccess");
			return "redirect:list";
		  }
	 
	  @GetMapping("/modifyView")
	  public ModelAndView BoardModifyView(int num,
			  	ModelAndView mv,
			  	HttpServletRequest request
			  	) {
		  BBS_FR boarddata = FrService.getDetail(num);
		  
		  //�� ���� �ҷ����� ������ ���
		  if (boarddata == null) {
			  logger.info("�������� ����");
			  mv.setViewName("error/error");
			  mv.addObject("url", request.getRequestURL());
			  mv.addObject("message","�������� �����Դϴ�.");
			  return mv;
		  }
		  logger.info("(����)�󼼺��� ����");
		  //���� �� �������� �̵��� �� ���� �� ������ �����ֱ� ������ boarddata ��ü��
		  //ModelAndView��ü�� �����մϴ�.
		  mv.addObject("boarddata", boarddata);
		  logger.info("���� �̸�" + boarddata.getFR_ORIGINAL());
		  //�� ���� �� �������� �̵��ϱ� ���� ��θ� �����մϴ�.
		  mv.setViewName("sports_fr/Bbs_FrModify");
		  return mv;
	  }
	  
	 @PostMapping("/modifyAction")
	  public String BoardModifyAction(BBS_FR boarddata,
			  String check, Model mv, HttpServletRequest request,
			  RedirectAttributes rattr
			  ) throws Exception{
		  boolean usercheck = 
				  FrService.isFrWriter(boarddata.getFR_NO(), boarddata.getFR_PASS());
		  		String url="";
		  		//��й�ȣ�� �ٸ� ���
		  		if(usercheck == false) {
		  			rattr.addFlashAttribute("result", "passFail");
		  			rattr.addAttribute("num",boarddata.getFR_NO());
		  			return "redirect:modifyView";
		  		}
		  	MultipartFile uploadfile = boarddata.getUploadfile();
		/*
		 * String saveFolder=
		 * request.getSession().getServletContext().getRealPath("resources") +
		 * "/BBS_FRupload/";
		 */
		  	
		  	if(check != null && !check.equals("")) {	//���� ���� �״�� ����ϴ� ����Դϴ�.
		  		logger.info("���� ���� �״�� ����մϴ�.");
		  		boarddata.setFR_ORIGINAL(check);
		  		//<input type="hidden" name=BOARD_FILE" value="${boarddata.BOARD_FILE}">
		  		//�� ���� ������ board.setBOARD_FILE()���� �ڵ� ����˴ϴ�.
		  	}else {
		  		if(uploadfile!=null && !uploadfile.isEmpty()) {
		  			logger.info("���� ����Ǿ����ϴ�.");
		  			//�亯 ���� ������ ��� <input type="file" id="upfile" name="uploadfile">������Ʈ
		  			//private MultipartFile uploadfile;���� uploadfile�� null�Դϴ�.
		  			
		  			String fileName= uploadfile.getOriginalFilename();//���� ���ϸ�
		  			boarddata.setFR_ORIGINAL(fileName);
		  			
		  			String fileDBName = fileDBName(fileName, saveFolder);
		  			
		  			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
		  			uploadfile.transferTo(new File(saveFolder + fileDBName));
		  			
		  			//�ٲ� ���ϸ����� ����
		  			boarddata.setFR_FILE(fileDBName);
		  		}else {	//uploadfile.isEmpty()�� ��� - ���� �������� ���� ���
		  			logger.info("���� ������ �����ϴ�.");
		  			//<input type="hidden" name="BOARD_FILE" value="${boarddata.BOARD_FILE}">
		  			//�� �±׿� ���� �ִٸ� ""�� ���� �����մϴ�.
		  			boarddata.setFR_FILE("");//""�� �ʱ�ȭ�մϴ�.
		  			boarddata.setFR_ORIGINAL("");//""�� �ʱ�ȭ�մϴ�.
		  		}//else end
		  }//else end
		  
		  logger.info("FR_SUBJECT" + boarddata.getFR_SUBJECT());
		  logger.info("FR_CONTENT" + boarddata.getFR_CONTENT());
		  logger.info("FR_FILE"+ boarddata.getFR_FILE());
		  logger.info("FR_ORIGINAL"+boarddata.getFR_ORIGINAL());
		  //DAO���� ���� �޼��� ȣ���Ͽ� �����մϴ�.
		  int result = FrService.FrModify(boarddata);
		  //������ ������ ���
		  if(result == 0) {
			  logger.info("�Խ��� ���� ����");
			  mv.addAttribute("url",request.getRequestURL());
			  mv.addAttribute("message","�Խ��� ���� ����");
			  url="error/error";
			  
		  }else {// ���������� ���
			  logger.info("�Խ��� ���� �Ϸ�");
			  //������ �� ������ �����ֱ� ���� �� ���� ���� �������� �̵��ϱ� ���� ��θ� �����մϴ�.
			  url = "redirect:list";
			  rattr.addAttribute("num",boarddata.getFR_NO());
		  }
		  return url;
	  }
	 @PostMapping("/down")
	 public void BoardFileDown(String filename,
			 HttpServletRequest request, String original,
			 HttpServletResponse response) throws Exception {
		 
		 //String savePath = "resources/BBS_FRupload";
		 //������ ���� ȯ�� ������ ��� �ִ� ��ü�� �����մϴ�.
		 ServletContext context = request.getSession().getServletContext();
		 //String sDownloadPath = context.getRealPath(savePath);
		 
		 //String sFilePath = sDownloadPath + "\\" + fileName;
		 // "\" �߰��ϱ� ���� "\\" ����մϴ�.
		 //String sFilePath = sDownloadPath + "/" + filename;
		 String sFilePath = saveFolder + "/" + filename;
		 logger.info(sFilePath);
		 
		 byte b[] = new byte[4096];
		 
		 //sFilePath�� �ִ� ������ MimeType�� ���ؿɴϴ�.
		 String sMimeType = context.getMimeType(sFilePath);
		 logger.info("sMimeType>>>" + sMimeType);
		 
		 if(sMimeType == null)
			 sMimeType = "application/octet-stream";
		 
		 response.setContentType(sMimeType);
		 
		 // - �� �κ��� �ѱ� ���ϸ��� ������ ���� �������ݴϴ�.
		 String sEncoding = new String(original.getBytes("utf-8"), "ISO-8859-1");
		 //Logger.info(sEncoding);
		 
		/*
		 * Content -Disposition: attachment: �������� �ش� Content�� ó������ �ʰ�, �ٿ�ε��ϰ� �˴ϴ�.
		 */
		 response.setHeader("Content-Disposition", "attachment; filename= "
				 + sEncoding);
		 //Package Explorer - ������Ʈ ��Ŭ�� - Properties - Project facets���� �ڹ� ���� 1.8�� ����
		 try (
				 //�� ���������� ��� ��Ʈ�� �����մϴ�.
				 BufferedOutputStream out2 = 
				 		new BufferedOutputStream(response.getOutputStream());
				 //sFilePath�� ������ ���Ͽ� ���� �Է� ��Ʈ���� �����մϴ�.
				 BufferedInputStream in = 
						 new BufferedInputStream(new FileInputStream(sFilePath));)
		 {
			 int numRead;
			 //read(b,0,b.length) : ����Ʈ �迭 b�� 0������ b.length
			 //ũ�⸸ŭ �о�ɴϴ�.
	         while ((numRead = in.read(b,0,b.length))!= -1) { //���� �����Ͱ� �����ϴ� ���
	             //����Ʈ �迭 b�� 0�� ���� numReadũ�� ��ŭ �������� ��� 
	             out2.write(b,0,numRead);
	          }
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
			
	 }
} 
