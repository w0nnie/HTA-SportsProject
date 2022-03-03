package com.project.sports.domain;

public class DealQuestion {
	private int QUESTION_NUMBER;		//문의번호
	private int WRITE_NUMBER;			//글번호
	private String SUBJECT;				//글제목
	private int DEAL_CSFC;				//글분류 (1:경매,2:직)
	private String QUESTION_CONTENT;	//문의 내용
	private String QUESTION_ANSWER;		//문의 답변
	private String SELL_ID;				//판매자 아이디
	private String QUESTION_ID;			//문의자 아이디
	public int getQUESTION_NUMBER() {
		return QUESTION_NUMBER;
	}
	public void setQUESTION_NUMBER(int qUESTION_NUMBER) {
		QUESTION_NUMBER = qUESTION_NUMBER;
	}
	public int getWRITE_NUMBER() {
		return WRITE_NUMBER;
	}
	public void setWRITE_NUMBER(int wRITE_NUMBER) {
		WRITE_NUMBER = wRITE_NUMBER;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public int getDEAL_CSFC() {
		return DEAL_CSFC;
	}
	public void setDEAL_CSFC(int dEAL_CSFC) {
		DEAL_CSFC = dEAL_CSFC;
	}
	public String getQUESTION_CONTENT() {
		return QUESTION_CONTENT;
	}
	public void setQUESTION_CONTENT(String qUESTION_CONTENT) {
		QUESTION_CONTENT = qUESTION_CONTENT;
	}
	public String getQUESTION_ANSWER() {
		return QUESTION_ANSWER;
	}
	public void setQUESTION_ANSWER(String qUESTION_ANSWER) {
		QUESTION_ANSWER = qUESTION_ANSWER;
	}
	public String getSELL_ID() {
		return SELL_ID;
	}
	public void setSELL_ID(String sELL_ID) {
		SELL_ID = sELL_ID;
	}
	public String getQUESTION_ID() {
		return QUESTION_ID;
	}
	public void setQUESTION_ID(String qUESTION_ID) {
		QUESTION_ID = qUESTION_ID;
	}
	
	
}
