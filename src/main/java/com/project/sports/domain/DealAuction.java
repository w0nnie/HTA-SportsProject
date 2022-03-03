package com.project.sports.domain;

import org.springframework.web.multipart.MultipartFile;

public class DealAuction {
	private int		AUC_NUMBER;			//글번호
	private String	AUC_SUBJECT; 		//글제목
	private String	AUC_CONTENT;		//글내용
	private String	USER_ID;			//아이디
	private String	AUC_DATE; 			//경매기간
	private String	AUC_PRICE; 			//경매가
	private String	AUC_UNIT;			//입찰단위
	private String	AUC_LPRICE;			//즉시구매가
	private int		AUC_COUNT;			//입찰수
	private String	AUC_DELIVERY;		//배송방법
	private String	AUC_DELIVERYCOM;	//택배사
	private String	AUC_DELIVERYNUM;	//송장번호
	private String	ORI_AUC_MAINFILE;	//메인사진
	private String	SAVE_AUC_MAINFILE;	//저장용 메인사진
	private String	ORI_AUC_FILE2;		//사진2
	private String	SAVE_AUC_FILE2;
	private String	ORI_AUC_FILE3;		//사진3
	private String	SAVE_AUC_FILE3;
	private String	ORI_AUC_FILE4;		//사진4
	private String	SAVE_AUC_FILE4;
	private int AUC_READCOUNT;			//글 조회수 (9-30 추가)
	private int AUC_SPRICE;				//경매 시작값 (10-03 추가)
	private String AUC_NOWDATE;			//올린시간 (10-07추가)
	
	private MultipartFile uploadfile1;
	private MultipartFile uploadfile2;
	private MultipartFile uploadfile3;
	private MultipartFile uploadfile4;
	
	
	public int getAUC_NUMBER() {
		return AUC_NUMBER;
	}
	public void setAUC_NUMBER(int aUC_NUMBER) {
		AUC_NUMBER = aUC_NUMBER;
	}
	public String getAUC_SUBJECT() {
		return AUC_SUBJECT;
	}
	public void setAUC_SUBJECT(String aUC_SUBJECT) {
		AUC_SUBJECT = aUC_SUBJECT;
	}
	public String getAUC_CONTENT() {
		return AUC_CONTENT;
	}
	public void setAUC_CONTENT(String aUC_CONTENT) {
		AUC_CONTENT = aUC_CONTENT;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getAUC_DATE() {
		return AUC_DATE;
	}
	public void setAUC_DATE(String aUC_DATE) {
		AUC_DATE = aUC_DATE;
		
	}
	public String getAUC_PRICE() {
		return AUC_PRICE;
	}
	public void setAUC_PRICE(String aUC_PRICE) {
		AUC_PRICE = aUC_PRICE;
	}
	public String getAUC_UNIT() {
		return AUC_UNIT;
	}
	public void setAUC_UNIT(String aUC_UNIT) {
		AUC_UNIT = aUC_UNIT;
	}
	public String getAUC_LPRICE() {
		return AUC_LPRICE;
	}
	public void setAUC_LPRICE(String aUC_LPRICE) {
		AUC_LPRICE = aUC_LPRICE;
	}
	public int getAUC_COUNT() {
		return AUC_COUNT;
	}
	public void setAUC_COUNT(int aUC_COUNT) {
		AUC_COUNT = aUC_COUNT;
	}
	public String getAUC_DELIVERY() {
		return AUC_DELIVERY;
	}
	public void setAUC_DELIVERY(String aUC_DELIVERY) {
		AUC_DELIVERY = aUC_DELIVERY;
	}
	public String getAUC_DELIVERYCOM() {
		return AUC_DELIVERYCOM;
	}
	public void setAUC_DELIVERYCOM(String aUC_DELIVERYCOM) {
		AUC_DELIVERYCOM = aUC_DELIVERYCOM;
	}
	public String getAUC_DELIVERYNUM() {
		return AUC_DELIVERYNUM;
	}
	public void setAUC_DELIVERYNUM(String aUC_DELIVERYNUM) {
		AUC_DELIVERYNUM = aUC_DELIVERYNUM;
	}
	public String getORI_AUC_MAINFILE() {
		return ORI_AUC_MAINFILE;
	}
	public void setORI_AUC_MAINFILE(String oRI_AUC_MAINFILE) {
		ORI_AUC_MAINFILE = oRI_AUC_MAINFILE;
	}
	public String getSAVE_AUC_MAINFILE() {
		return SAVE_AUC_MAINFILE;
	}
	public void setSAVE_AUC_MAINFILE(String sAVE_AUC_MAINFILE) {
		SAVE_AUC_MAINFILE = sAVE_AUC_MAINFILE;
	}
	public String getORI_AUC_FILE2() {
		return ORI_AUC_FILE2;
	}
	public void setORI_AUC_FILE2(String oRI_AUC_FILE2) {
		ORI_AUC_FILE2 = oRI_AUC_FILE2;
	}
	public String getSAVE_AUC_FILE2() {
		return SAVE_AUC_FILE2;
	}
	public void setSAVE_AUC_FILE2(String sAVE_AUC_FILE2) {
		SAVE_AUC_FILE2 = sAVE_AUC_FILE2;
	}
	public String getORI_AUC_FILE3() {
		return ORI_AUC_FILE3;
	}
	public void setORI_AUC_FILE3(String oRI_AUC_FILE3) {
		ORI_AUC_FILE3 = oRI_AUC_FILE3;
	}
	public String getSAVE_AUC_FILE3() {
		return SAVE_AUC_FILE3;
	}
	public void setSAVE_AUC_FILE3(String sAVE_AUC_FILE3) {
		SAVE_AUC_FILE3 = sAVE_AUC_FILE3;
	}
	public String getORI_AUC_FILE4() {
		return ORI_AUC_FILE4;
	}
	public void setORI_AUC_FILE4(String oRI_AUC_FILE4) {
		ORI_AUC_FILE4 = oRI_AUC_FILE4;
	}
	public String getSAVE_AUC_FILE4() {
		return SAVE_AUC_FILE4;
	}
	public void setSAVE_AUC_FILE4(String sAVE_AUC_FILE4) {
		SAVE_AUC_FILE4 = sAVE_AUC_FILE4;
	}
	public MultipartFile getUploadfile1() {
		return uploadfile1;
	}
	public void setUploadfile1(MultipartFile uploadfile1) {
		this.uploadfile1 = uploadfile1;
	}
	public MultipartFile getUploadfile2() {
		return uploadfile2;
	}
	public void setUploadfile2(MultipartFile uploadfile2) {
		this.uploadfile2 = uploadfile2;
	}
	public MultipartFile getUploadfile3() {
		return uploadfile3;
	}
	public void setUploadfile3(MultipartFile uploadfile3) {
		this.uploadfile3 = uploadfile3;
	}
	public MultipartFile getUploadfile4() {
		return uploadfile4;
	}
	public void setUploadfile4(MultipartFile uploadfile4) {
		this.uploadfile4 = uploadfile4;
	}
	public int getAUC_READCOUNT() {
		return AUC_READCOUNT;
	}
	public void setAUC_READCOUNT(int aUC_READCOUNT) {
		AUC_READCOUNT = aUC_READCOUNT;
	}
	public int getAUC_SPRICE() {
		return AUC_SPRICE;
	}
	public void setAUC_SPRICE(int aUC_SPRICE) {
		AUC_SPRICE = aUC_SPRICE;
	}
	public String getAUC_NOWDATE() {
		return AUC_NOWDATE;
	}
	public void setAUC_NOWDATE(String aUC_NOWDATE) {
		AUC_NOWDATE = aUC_NOWDATE.substring(0,10).replace("-", " ");
	}
   
	
	
	
}
