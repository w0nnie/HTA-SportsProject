package com.project.sports.domain;

public class DealPoint {
	private String USER_ID;		//아이디
	private String SEND_NAME;	//입금자 성명
	private int REAL_POINT;		//현재 포인트
	private int REQUEST_POINT;	//요청 포인트
	private int POINT_PROCESS;	//포인트 처리상황 [0:대기(완료) , 1:요청]
	
	
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
