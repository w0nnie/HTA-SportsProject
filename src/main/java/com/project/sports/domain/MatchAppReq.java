package com.project.sports.domain;


public class MatchAppReq {
	private String mentor_title;
	private String mentee_title;
	private String sports_name;
	private int match_state;
	private String match_code;
	private String user_name;
	private String user_id;
	private String user_mobile;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMatch_code() {
		return match_code;
	}
	public void setMatch_code(String match_code) {
		this.match_code = match_code;
	}
	public String getMentor_title() {
		return mentor_title;
	}
	public void setMentor_title(String mentor_title) {
		this.mentor_title = mentor_title;
	}
	public String getMentee_title() {
		return mentee_title;
	}
	public void setMentee_title(String mentee_title) {
		this.mentee_title = mentee_title;
	}
	public String getSports_name() {
		return sports_name;
	}
	public void setSports_name(String sports_name) {
		this.sports_name = sports_name;
	}
	public int getMatch_state() {
		return match_state;
	}
	public void setMatch_state(int match_state) {
		this.match_state = match_state;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	
}
