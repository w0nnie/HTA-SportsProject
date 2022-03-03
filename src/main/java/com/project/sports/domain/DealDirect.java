package com.project.sports.domain;

import org.springframework.web.multipart.MultipartFile;

public class DealDirect {
	private int 	DIR_NUMBER;			//글번호
	private String  DIR_SUBJECT;		//글제목
	private String  DIR_CONTENT; 		//글내용
	private String  USER_ID		;		//아이디
	private String  DIR_PRICE;			//금액
	private String  DIR_PHONE;			//핸드폰 번호
	private String  DIR_ADDRESS;		//거래장소
	private String  DIR_DATE;			//날짜 
	private String  ORI_DIR_MAINFILE; 	//진짜 메인사진
	private String  SAVE_DIR_MAINFILE;	//저장용 메인사진
	private String  ORI_DIR_FILE2;		//사진2
	private String  SAVE_DIR_FILE2;
	private String  ORI_DIR_FILE3;		//사진3
	private String  SAVE_DIR_FILE3;
	private String  ORI_DIR_FILE4;		//사진4 
	private String  SAVE_DIR_FILE4;
	
	private MultipartFile uploadfile1;
	private MultipartFile uploadfile2;
	private MultipartFile uploadfile3;
	private MultipartFile uploadfile4;
	
	private int DIR_READCOUNT;			//글 조회수(9-30 추가)
	
	
	
	public int getDIR_NUMBER() {
		return DIR_NUMBER;
	}
	public void setDIR_NUMBER(int dIR_NUMBER) {
		DIR_NUMBER = dIR_NUMBER;
	}
	public String getDIR_SUBJECT() {
		return DIR_SUBJECT;
	}
	public void setDIR_SUBJECT(String dIR_SUBJECT) {
		DIR_SUBJECT = dIR_SUBJECT;
	}
	public String getDIR_CONTENT() {
		return DIR_CONTENT;
	}
	public void setDIR_CONTENT(String dIR_CONTENT) {
		DIR_CONTENT = dIR_CONTENT;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getDIR_PRICE() {
		return DIR_PRICE;
	}
	public void setDIR_PRICE(String dIR_PRICE) {
		DIR_PRICE = dIR_PRICE;
	}
	public String getDIR_PHONE() {
		return DIR_PHONE;
	}
	public void setDIR_PHONE(String dIR_PHONE) {
		DIR_PHONE = dIR_PHONE;
	}
	public String getDIR_ADDRESS() {
		return DIR_ADDRESS;
	}
	public void setDIR_ADDRESS(String dIR_ADDRESS) {
		DIR_ADDRESS = dIR_ADDRESS;
	}
	public String getDIR_DATE() {
		return DIR_DATE;
	}
	public void setDIR_DATE(String dIR_DATE) {
		DIR_DATE = dIR_DATE;
	}
	public String getORI_DIR_MAINFILE() {
		return ORI_DIR_MAINFILE;
	}
	public void setORI_DIR_MAINFILE(String oRI_DIR_MAINFILE) {
		ORI_DIR_MAINFILE = oRI_DIR_MAINFILE;
	}
	public String getSAVE_DIR_MAINFILE() {
		return SAVE_DIR_MAINFILE;
	}
	public void setSAVE_DIR_MAINFILE(String sAVE_DIR_MAINFILE) {
		SAVE_DIR_MAINFILE = sAVE_DIR_MAINFILE;
	}
	public String getORI_DIR_FILE2() {
		return ORI_DIR_FILE2;
	}
	public void setORI_DIR_FILE2(String oRI_DIR_FILE2) {
		ORI_DIR_FILE2 = oRI_DIR_FILE2;
	}
	public String getSAVE_DIR_FILE2() {
		return SAVE_DIR_FILE2;
	}
	public void setSAVE_DIR_FILE2(String sAVE_DIR_FILE2) {
		SAVE_DIR_FILE2 = sAVE_DIR_FILE2;
	}
	public String getORI_DIR_FILE3() {
		return ORI_DIR_FILE3;
	}
	public void setORI_DIR_FILE3(String oRI_DIR_FILE3) {
		ORI_DIR_FILE3 = oRI_DIR_FILE3;
	}
	public String getSAVE_DIR_FILE3() {
		return SAVE_DIR_FILE3;
	}
	public void setSAVE_DIR_FILE3(String sAVE_DIR_FILE3) {
		SAVE_DIR_FILE3 = sAVE_DIR_FILE3;
	}
	public String getORI_DIR_FILE4() {
		return ORI_DIR_FILE4;
	}
	public void setORI_DIR_FILE4(String oRI_DIR_FILE4) {
		ORI_DIR_FILE4 = oRI_DIR_FILE4;
	}
	public String getSAVE_DIR_FILE4() {
		return SAVE_DIR_FILE4;
	}
	public void setSAVE_DIR_FILE4(String sAVE_DIR_FILE4) {
		SAVE_DIR_FILE4 = sAVE_DIR_FILE4;
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
	public int getDIR_READCOUNT() {
		return DIR_READCOUNT;
	}
	public void setDIR_READCOUNT(int dIR_READCOUNT) {
		DIR_READCOUNT = dIR_READCOUNT;
	}
	
	
	
	
}
