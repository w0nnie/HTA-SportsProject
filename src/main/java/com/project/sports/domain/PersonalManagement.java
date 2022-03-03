package com.project.sports.domain;

public class PersonalManagement {

	private int 	PM_NO;
	private String 	USER_ID;
	private int 	PM_KCAL;
	private String	PM_DATE;
	private String  SPORTS_NAME;
	private String  SPORTS_IMG;
	
	public String getSPORTS_IMG() {
		return SPORTS_IMG;
	}
	public void setSPORTS_IMG(String sPORTS_IMG) {
		SPORTS_IMG = sPORTS_IMG;
	}
	public int getPM_NO() {
		return PM_NO;
	}
	public void setPM_NO(int pM_NO) {
		PM_NO = pM_NO;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getPM_KCAL() {
		return PM_KCAL;
	}
	public void setPM_KCAL(int pM_KCAL) {
		PM_KCAL = pM_KCAL;
	}
	public String getPM_DATE() {
		return PM_DATE;
	}
	public void setPM_DATE(String pM_DATE) {
		PM_DATE = pM_DATE;
	}
	public String getSPORTS_NAME() {
		return SPORTS_NAME;
	}
	public void setSPORTS_NAME(String sPORTS_NAME) {
		SPORTS_NAME = sPORTS_NAME;
	}
	
}
