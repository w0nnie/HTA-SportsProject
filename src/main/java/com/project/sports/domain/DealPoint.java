package com.project.sports.domain;

public class DealPoint {
	private String USER_ID;		//���̵�
	private String SEND_NAME;	//�Ա��� ����
	private int REAL_POINT;		//���� ����Ʈ
	private int REQUEST_POINT;	//��û ����Ʈ
	private int POINT_PROCESS;	//����Ʈ ó����Ȳ [0:���(�Ϸ�) , 1:��û]
	
	
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getSEND_NAME() {
		return SEND_NAME;
	}
	public void setSEND_NAME(String sEND_NAME) {
		SEND_NAME = sEND_NAME;
	}
	public int getREAL_POINT() {
		return REAL_POINT;
	}
	public void setREAL_POINT(int rEAL_POINT) {
		REAL_POINT = rEAL_POINT;
	}
	public int getREQUEST_POINT() {
		return REQUEST_POINT;
	}
	public void setREQUEST_POINT(int rEQUEST_POINT) {
		REQUEST_POINT = rEQUEST_POINT;
	}
	public int getPOINT_PROCESS() {
		return POINT_PROCESS;
	}
	public void setPOINT_PROCESS(int pOINT_PROCESS) {
		POINT_PROCESS = pOINT_PROCESS;
	}
	
	
}
