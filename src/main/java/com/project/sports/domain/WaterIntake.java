package com.project.sports.domain;

import java.sql.Date;

public class WaterIntake {
	private int wi_no;//시퀀스
	private String user_id;//로그인한 아이디
	private String time_start;
	private String time_end;
	private String title;//당일 섭취량
	private String goaldata;
	
	public String getGoaldata() {
		return goaldata;
	}
	public void setGoaldata(String goaldata) {
		this.goaldata = goaldata;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public int getWi_no() {
		return wi_no;
	}
	public void setWi_no(int wi_no) {
		this.wi_no = wi_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
