package com.project.sports.domain;

public class DealQuestion {
	private int QUESTION_NUMBER;		//���ǹ�ȣ
	private int WRITE_NUMBER;			//�۹�ȣ
	private String SUBJECT;				//������
	private int DEAL_CSFC;				//�ۺз� (1:���,2:��)
	private String QUESTION_CONTENT;	//���� ����
	private String QUESTION_ANSWER;		//���� �亯
	private String SELL_ID;				//�Ǹ��� ���̵�
	private String QUESTION_ID;			//������ ���̵�
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
