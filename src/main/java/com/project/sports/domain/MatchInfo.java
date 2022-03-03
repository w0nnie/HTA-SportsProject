package com.project.sports.domain;

public class MatchInfo {
	private int match_no;
	private String user_id;
	private String match_code;
	private int match_state;
	public int getMatch_no() {
		return match_no;
	}
	public void setMatch_no(int match_no) {
		this.match_no = match_no;
	}
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
	public int getMatch_state() {
		return match_state;
	}
	public void setMatch_state(int match_state) {
		this.match_state = match_state;
	}
}
