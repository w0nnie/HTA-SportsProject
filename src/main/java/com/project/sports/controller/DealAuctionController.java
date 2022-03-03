package com.project.sports.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.sports.domain.DealAuction;
import com.project.sports.domain.DealDirect;
import com.project.sports.service.DealService;
import com.project.sports.service.MyDealService;

@Controller
@RequestMapping(value="/DealA")
public class DealAuctionController {
	
	private static final Logger logger
	= LoggerFactory.getLogger(DealAuctionController.class);
	
	@Autowired
	private DealService DealService;
	
	@Autowired
	private MyDealService MyDealService;
	

	private String saveFolder = "C:\\Users\\82109\\git\\Sports\\Sports\\src\\main\\webapp\\resources\\dealupload1\\";
	
	//���� ������ ����Ʈ
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView AuctionList(
			@RequestParam(value="page",defaultValue="1",required=false)int page,
			@RequestParam(value = "search",
			defaultValue = "", required = false) String search ,
			@RequestParam(value = "view2",
			defaultValue = "1", required = false) int view2,
			 ModelAndView mv , HttpSession session
			 ) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		int limit = 6; // �� ȭ�鿡 ����� ���ڵ� ����
		
		
		
		int listcount = DealService.getListCount(); // �� ����Ʈ ���� �޾ƿ�
		
		logger.info("����Ʈ��" + listcount);
		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� �������� ������ ������ ������ �� (10, 20 ,30 ��...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;
		
		List<DealAuction> Auction = new ArrayList<DealAuction>();
		
		if(search == "") {
			Auction = DealService.getAuctionList(page, limit,view2); //����Ʈ�� �޾ƿ�
		}else {
			Auction = DealService.getSearchAuctionList(page,limit,search,view2);
		}
		
		
		int nowpoint=0;
		
		if(sessionid !=null) {
			//���� ����Ʈ ��ȸ
			nowpoint = MyDealService.nowpoint(sessionid);
		}
		
		logger.info("���Ǿ��̵�" + sessionid);
		 
		
		mv.setViewName("sport_Deal/DealA_list");
		mv.addObject("sessionid",sessionid);
		mv.addObject("page",page);
		mv.addObject("maxpage",maxpage);
		mv.addObject("startpage",startpage);
		mv.addObject("endpage",endpage);
		mv.addObject("listcount",listcount);
		mv.addObject("Auction",Auction);
		mv.addObject("limit",limit);
		mv.addObject("view2",view2);
		mv.addObject("nowpoint",nowpoint);
		
		
		
		return mv;
		
		}
	
	// �۾��� 
	@GetMapping(value="/write")
	//@RequestMapping(value="/write", method=requestMethod.GET)
	public String Auction_write() {
		return "sport_Deal/Auction_write";
		
	}
	
	// �� ������
	@GetMapping(value="/detail")
	//@RequestMapping(value="/write", method=requestMethod.GET)
	public ModelAndView Auction_detail(int num, ModelAndView mv,
			HttpServletRequest request,
			HttpSession session
			) {
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//�����ϰ��ִ� ��� ���̵� Ȯ��
		String beforebidid = DealService.beforebidid(num);
		
		//������ ��������
		DealAuction Auction = DealService.A_getDetail(num);
		
		//���������� ��������
		int Dealunit = DealService.Dealunit(num);
		logger.info("����������" + Dealunit);
		
		//���� ����Ʈ ��ȸ
		int nowpoint = MyDealService.nowpoint(sessionid);
		
		int possible ;
		
		//���� ����Ʈ�� �����̰������� �Ǵ�
		if(Dealunit > nowpoint) {
			possible = 0 ;
		}else {
			possible = 1;
		}

		mv.addObject("possible", possible);	 //���� ����Ʈ�� ���� ���ɿ���
		mv.addObject("nowpoint", nowpoint);	 //���� ����Ʈ
		mv.addObject("beforebidid", beforebidid);	//���� ������ ���̵� Ȯ��

		
		if(sessionid !=null) {
			//���ѹ�ǰ���� Ȯ��
			Object pickcheck = DealService.pickcheck(sessionid, num);
			if(pickcheck == null) {
				mv.addObject("pickcheck", "possible");
			}else {
				mv.addObject("pickcheck", "impossible");
			}
			
			//���� �����̵�� �������� ��Ǭ���� Ȯ��
			Object bidcheck = DealService.bidcheck(sessionid , num);
			if(bidcheck == null) {
				mv.addObject("bidcheck" , "possible");
				
			}else {
				mv.addObject("bidcheck" , "impossible");
			}
		}
		
		
		//��ȸ��
		int count = DealService.A_readcount(num);
		
		if(Auction==null) {
			logger.info("�󼼺��� ����");
			mv.setViewName("error/error");
			mv.addObject("url",request.getRequestURL());
			mv.addObject("message", "�󼼺��� ���� �Դϴ�.");
		}else {
			logger.info("�󼼺��� ����");
			mv.setViewName("sport_Deal/Auction_detail");
			logger.info("����" + Auction.getSAVE_AUC_FILE2());
			mv.addObject("b" ,Auction);
			
		}
		
		return mv;
	}
	
	@PostMapping("/add")
	//@RequestMapping(value="/add" , method=RequestMethod.POST)
	public String Auction_add(DealAuction Auction, HttpServletRequest request 
			,HttpSession session,ModelAndView mv)
			throws Exception{
		
		
		
		MultipartFile uploadfile1 = Auction.getUploadfile1();
		MultipartFile uploadfile2 = Auction.getUploadfile2();
		MultipartFile uploadfile3 = Auction.getUploadfile3();
		MultipartFile uploadfile4 = Auction.getUploadfile4();
		
		if(!uploadfile1.isEmpty()) {
			String fileName = uploadfile1.getOriginalFilename();//���� ���ϸ�
			Auction.setORI_AUC_MAINFILE(fileName);//���� ���ϸ� ����
			//String saveFolder = 
					// request.getSession().getServletContext().getRealPath("resources")
					// 	+ "/upload/";
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName= " + fileDBName);
			logger.info("������" + saveFolder + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
			uploadfile1.transferTo(new File(saveFolder + fileDBName));
			
			//�ٲ� ���ϸ����� ���� 
			Auction.setSAVE_AUC_MAINFILE(fileDBName);
		}
		
		if(!uploadfile2.isEmpty()) {
			String fileName = uploadfile2.getOriginalFilename();//���� ���ϸ�
			Auction.setORI_AUC_FILE2(fileName);//���� ���ϸ� ����
			//String saveFolder = 
					// request.getSession().getServletContext().getRealPath("resources")
					// 	+ "/upload/";
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName= " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
			uploadfile2.transferTo(new File(saveFolder + fileDBName));
			
			//�ٲ� ���ϸ����� ���� 
			Auction.setSAVE_AUC_FILE2(fileDBName);
		}else {
			Auction.setSAVE_AUC_FILE2("0");
			Auction.setORI_AUC_FILE2("0");
		}
		
		if(!uploadfile3.isEmpty()) {
			String fileName = uploadfile3.getOriginalFilename();//���� ���ϸ�
			Auction.setORI_AUC_FILE3(fileName);//���� ���ϸ� ����
			//String saveFolder = 
					// request.getSession().getServletContext().getRealPath("resources")
					// 	+ "/upload/";
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName= " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
			uploadfile3.transferTo(new File(saveFolder + fileDBName));
			
			//�ٲ� ���ϸ����� ���� 
			Auction.setSAVE_AUC_FILE3(fileDBName);
		}else {
			Auction.setSAVE_AUC_FILE3("0");
			Auction.setORI_AUC_FILE3("0");
		}
		
		if(!uploadfile4.isEmpty()) {
			String fileName = uploadfile4.getOriginalFilename();//���� ���ϸ�
			Auction.setORI_AUC_FILE4(fileName);//���� ���ϸ� ����
			//String saveFolder = 
					// request.getSession().getServletContext().getRealPath("resources")
					// 	+ "/upload/";
			String fileDBName = fileDBName(fileName,saveFolder);
			logger.info("fileDBName= " + fileDBName);
			
			//transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�. 
			uploadfile4.transferTo(new File(saveFolder + fileDBName));
			
			//�ٲ� ���ϸ����� ���� 
			Auction.setSAVE_AUC_FILE4(fileDBName);
		}else {
			Auction.setSAVE_AUC_FILE4("0");
			Auction.setORI_AUC_FILE4("0");
		}
		
		logger.info("����" + Auction.getAUC_SUBJECT());
		logger.info("���۰�" + Auction.getAUC_PRICE());
		logger.info("���Ѱ�" + Auction.getAUC_LPRICE());
		logger.info("��������" + Auction.getAUC_UNIT());
		logger.info("����" + Auction.getAUC_CONTENT());
		logger.info("����1" + Auction.getORI_AUC_MAINFILE());
		logger.info("����1" + Auction.getSAVE_AUC_MAINFILE());
		logger.info("��¥" + Auction.getAUC_DATE());
		logger.info("���" + Auction.getAUC_DELIVERY());
		logger.info("save����" + saveFolder);
		
		
		String sessionid = (String)session.getAttribute("USER_ID");
		Auction.setUSER_ID(sessionid);
		
		
		
		//�� �߰�
		DealService.insert(Auction);	//����޼��� ȣ��
		
		//�Ǹ��� ���ŷ����� �Ǹ��� �߰�
		DealService.Myinsert(Auction);
		
		
		return "redirect:list";
	}
	
	private String fileDBName(String fileName , String saveFolder) {
		//���ο� ���� �̸� : ���� ��+��+��
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);	//���� �⵵ ���մϴ�. 
		int month = c.get(Calendar.MONTH)+1 ; //���� �� ���մϴ�. 
		int date = c.get(Calendar.DATE);	//���� �� ���մϴ�.
		
		String homedir = saveFolder;
		logger.info(homedir);
		File path1 = new File(homedir);
		if(!(path1.exists())) {
			path1.mkdir();//���ο� ������ ���� 
		}
		
		//������ ���մϴ�. 
		Random r = new Random(); 
		int random = r.nextInt(100000000);
		
		/*****Ȯ���� ���ϱ� ���� *****/
		int index = fileName.lastIndexOf(".");
		//���ڿ����� Ư�� ���ڿ��� ��ġ �� (index)�� ��ȯ�մϴ�.
		//indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�,
		//lastIndexOf�� ���������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�. 
		//(���ϸ� ���� ������ ���� ��� �� �������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
		logger.info("index=" + index);
		
		String fileExtension = fileName.substring(index + 1);
		logger.info("fileExtension = " + fileExtension);
		/**** Ȯ���� ���ϱ� �� ***/
		
		//���ο� ���ϸ� 
		String refileName = "auc" + year + month + date + random + "." + fileExtension ;
		logger.info("refileName = " + refileName);
		
		//����Ŭ ��� ����� ���� �� 
		String fileDBName =  refileName;
		logger.info("fileDBName = " + fileDBName);
		return fileDBName ;
	}
	
	//����
	@RequestMapping(value="/bid")
	public String AuctionBid(RedirectAttributes rattr , 
			HttpServletRequest request , int num,
			HttpSession session) {
		
		//�����ϰ� �ִ� ��� ���̵� Ȯ��
		String beforebidid = DealService.beforebidid(num);
		logger.info("�����Ƥӵ�" + beforebidid);
		
		//�̱ۿ� ��������
		int Dealunit2 = DealService.Dealunit(num);
		
		if(beforebidid != null) {
			//���������� �ٽ� ������ ��ȯ
			MyDealService.moneyreturn(beforebidid , Dealunit2);
		}
		
		//�� �ŷ� ���� �������� ������� �������з� ����
		int change = DealService.Auction_bidchange(num); 
		
		String sessionid = (String) session.getAttribute("USER_ID");
		logger.info("����2��" + sessionid);
		
		// ���ŷ����� ������ �߰� 
		DealService.Auction_biding(sessionid , num);
		
		//������ �� ��ȸ
		DealAuction Auction = DealService.A_getDetail(num);
		
		// ���� ��Ű� ����
		int pricemodify = DealService.Auction_pricemodi(Auction);
		
		
		/*����Ʈ ���� �������� ��ŭ���� */
		//���������� ��������
		int Dealunit = DealService.Dealunit(num);
		
		//���� ����Ʈ ��ȸ
		int nowpoint = MyDealService.nowpoint(sessionid);
		
		//������ �ݾ׸�ŭ ������ ����Ʈ
		int minuspoint = nowpoint - Dealunit;
		
		//������ �ݾ׸�ŭ ����Ʈ ������Ʈ
		MyDealService.minuspoint(minuspoint , sessionid);
		
		/* ****************************/
		
		
		
		return "redirect:list"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//��� ���ϱ�
	@RequestMapping(value="/pick")
	public String Auctionpick(RedirectAttributes rattr , 
			HttpServletRequest request , int num,
			HttpSession session) {
			
		String sessionid = (String) session.getAttribute("USER_ID");
	
		
		
		//���ϱ� ���
		DealService.Auction_pick(sessionid , num);
		
		return "redirect:list";
	}
	
	//��� �Ⱓ ��������
	@RequestMapping(value="/timeout")
	public String Auctiontimout(int num ) {
		
		
		//���� �ǸſϷ�� ����
		DealService.Auction_soldoutimg(num);
		
		//�Ǹ��� ���ŷ����� ( �Ǹ��� -> ����Է� )
		DealService.Auction_timeout(num);
		
		//������ ���ŷ����� ( ������ -> �����Ϸ�)
		DealService.Auction_timeout2(num);
		
		//��,�������� ����� 
		DealService.Auction_timeout3(num);
		
		return"redirect:list";
	}
	
	//��� ����
	@RequestMapping(value="/buynow")
	public String Auctionbuynow(int num , 
			HttpSession session) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		logger.info("��ñ���" + num);
		
		//�����ϰ��ִ� ��� ���̵� Ȯ��
		String beforebidid = DealService.beforebidid(num);
		logger.info("�����Ƥӵ�" + beforebidid);
				
		//�̱ۿ� ��������
		int Dealunit2 = DealService.Dealunit(num);
				
			
		if(beforebidid != null) {
			//���������� �ٽ� ������ ��ȯ
			MyDealService.moneyreturn(beforebidid , Dealunit2);
		}
		
		/*����Ʈ ���� �������� ��ŭ���� */
		//���������� ��������
		int Deallprice = DealService.Deallprice(num);
		
		//���� ����Ʈ ��ȸ
		int nowpoint = MyDealService.nowpoint(sessionid);
		
		
		int minuspoint = nowpoint - Deallprice;
		
		//������ �ݾ׸�ŭ ����Ʈ ������Ʈ
		MyDealService.minuspoint(minuspoint , sessionid);
		
		/* ****************************/
		
		//��ñ��� �Ϸ� �̹���, ���簡 ��ñ��Ű� �� �ٲ��ֱ�
		DealService.Auction_imgchan(num);
		
		//�Ǹ��� ���ŷ����� ( �Ǹ��� -> ����Է� )
		DealService.Auction_timeout(num);
		
		//������ ���ŷ����� ( �����Ϸ�) - insert
		DealService.Auction_buynow1(num, sessionid);
	
		//��,��������,������ ����� 
		DealService.Auction_buynow2(num);
		
		return"redirect:list";
	}

	@RequestMapping(value="/question")
	public String question(int num , 
			HttpSession session ,
			String sub , String sellid , String content) {
		
		String sessionid = (String) session.getAttribute("USER_ID");
		
		//���Ǳ� ���
		DealService.questioninput(sessionid , num , sub , sellid, content);
		
		logger.info("sessionid  " + sessionid);
		logger.info("num  " + num);
		logger.info("sub  " + sub);
		logger.info("sellid  " + sellid);
		logger.info("content  " + content);
		
		
		return"redirect:list";
		
		
	}
	
	
	
}
