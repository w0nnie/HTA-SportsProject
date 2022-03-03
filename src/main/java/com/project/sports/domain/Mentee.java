package com.project.sports.domain;

import org.springframework.web.multipart.MultipartFile;

public class Mentee {
	private String mentee_code;
	private String user_id;
	private String mentee_title;
	private String sports_name;
	private String city;
	private String sigungu;
	private String mentee_loc_detail;
	private String mentee_date;
	private int mentee_amount;
	private String mentee_gender;
	private String mentee_req;
	private String mentee_pic1;
	private String mentee_origin_pic1;	
    private MultipartFile uploadfile1;
	public String getMentee_code() {
		return mentee_code;
	}
	public void setMentee_code(String mentee_code) {
		this.mentee_code = mentee_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getMentee_loc_detail() {
		return mentee_loc_detail;
	}
	public void setMentee_loc_detail(String mentee_loc_detail) {
		this.mentee_loc_detail = mentee_loc_detail;
	}
	public String getMentee_date() {
		return mentee_date;
	}
	public void setMentee_date(String mentee_date) {
		this.mentee_date = mentee_date;
	}
	public int getMentee_amount() {
		return mentee_amount;
	}
	public void setMentee_amount(int mentee_amount) {
		this.mentee_amount = mentee_amount;
	}
	public String getMentee_gender() {
		return mentee_gender;
	}
	public void setMentee_gender(String mentee_gender) {
		this.mentee_gender = mentee_gender;
	}
	public String getMentee_req() {
		return mentee_req;
	}
	public void setMentee_req(String mentee_req) {
		this.mentee_req = mentee_req;
	}
	public String getMentee_pic1() {
		return mentee_pic1;
	}
	public void setMentee_pic1(String mentee_pic1) {
		this.mentee_pic1 = mentee_pic1;
	}
	public String getMentee_origin_pic1() {
		return mentee_origin_pic1;
	}
	public void setMentee_origin_pic1(String mentee_origin_pic1) {
		this.mentee_origin_pic1 = mentee_origin_pic1;
	}
	public MultipartFile getUploadfile1() {
		return uploadfile1;
	}
	public void setUploadfile1(MultipartFile uploadfile1) {
		this.uploadfile1 = uploadfile1;
	}

}
