package com.project.sports.domain;

import org.springframework.web.multipart.MultipartFile;

public class BBS_FR {
	private	int FR_NO			;
	private String USER_ID		;
	private String FR_PASS		;
	private String FR_CSFC;
	private String FR_SUBJECT	;
	private String FR_CONTENT	;
	private String FR_DATE	;
	private int FR_READCOUNT	;
	private String FR_FILE		;
	private String FR_ORIGINAL;
	private int CNT;
	
	public int getCNT() {
		return CNT;
	}

	public void setCNT(int cNT) {
		CNT = cNT;
	}

	//board_write.jsp에서 name속성 확인하세요.
	//<input type="file" id="upfile" name="uploadfile">확인
	private MultipartFile uploadfile;

	public int getFR_NO() {
		return FR_NO;
	}

	public void setFR_NO(int fR_NO) {
		FR_NO = fR_NO;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getFR_PASS() {
		return FR_PASS;
	}

	public void setFR_PASS(String fR_PASS) {
		FR_PASS = fR_PASS;
	}

	public String getFR_CSFC() {
		return FR_CSFC;
	}

	public void setFR_CSFC(String fR_CSFC) {
		FR_CSFC = fR_CSFC;
	}

	public String getFR_SUBJECT() {
		return FR_SUBJECT;
	}

	public void setFR_SUBJECT(String fR_SUBJECT) {
		FR_SUBJECT = fR_SUBJECT;
	}

	public String getFR_CONTENT() {
		return FR_CONTENT;
	}

	public void setFR_CONTENT(String fR_CONTENT) {
		FR_CONTENT = fR_CONTENT;
	}


	public String getFR_DATE() {
		return FR_DATE;
	}

	public void setFR_DATE(String fR_DATE) {
		FR_DATE = fR_DATE;
	}

	public int getFR_READCOUNT() {
		return FR_READCOUNT;
	}

	public void setFR_READCOUNT(int fR_READCOUNT) {
		FR_READCOUNT = fR_READCOUNT;
	}

	public String getFR_FILE() {
		return FR_FILE;
	}

	public void setFR_FILE(String fR_FILE) {
		FR_FILE = fR_FILE;
	}

	public String getFR_ORIGINAL() {
		return FR_ORIGINAL;
	}

	public void setFR_ORIGINAL(String fR_ORIGINAL) {
		FR_ORIGINAL = fR_ORIGINAL;
	}

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
}
