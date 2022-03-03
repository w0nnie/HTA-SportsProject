package com.project.sports.domain;

import org.springframework.web.multipart.MultipartFile;

public class Mentor {
	private String mentor_code;
	private String user_id;
	private String mentor_title;
	private String sports_name;
	private String city;
	private String sigungu;
	private String mentor_loc_detail;
	private String mentor_date;
	private int mentor_amount;
	private int mentor_number;
	private String mentor_caution;
	private String mentor_gender;
	private String mentor_name;
	private String mentor_career;
	private String mentor_pic1;
	private String mentor_origin_pic1;	
	private String mentor_pic2;
	private String mentor_origin_pic2;	
	private String mentor_pic3;
	private String mentor_origin_pic3;
    private MultipartFile uploadfile1;
    private MultipartFile uploadfile2;
    private MultipartFile uploadfile3;

	public MultipartFile getUploadfile1() {
		return uploadfile1;
	}
	public void setUploadfile1(MultipartFile uploadfile1) {
		this.uploadfile1 = uploadfile1;
	}
	public MultipartFile getUploadfile2() {
		return uploadfile2;
	}
	public void setUploadfile2(MultipartFile uploadfile2) {
		this.uploadfile2 = uploadfile2;
	}
	public MultipartFile getUploadfile3() {
		return uploadfile3;
	}
	public void setUploadfile3(MultipartFile uploadfile3) {
		this.uploadfile3 = uploadfile3;
	}
	public String getMentor_code() {
		return mentor_code;
	}
	public void setMentor_code(String mentor_code) {
		this.mentor_code = mentor_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMentor_title() {
		return mentor_title;
	}
	public void setMentor_title(String mentor_title) {
		this.mentor_title = mentor_title;
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
	public String getMentor_loc_detail() {
		return mentor_loc_detail;
	}
	public void setMentor_loc_detail(String mentor_loc_detail) {
		this.mentor_loc_detail = mentor_loc_detail;
	}
	public String getMentor_date() {
		return mentor_date;
	}
	public void setMentor_date(String mentor_date) {
		this.mentor_date = mentor_date;
	}
	public int getMentor_amount() {
		return mentor_amount;
	}
	public void setMentor_amount(int mentor_amount) {
		this.mentor_amount = mentor_amount;
	}
	public int getMentor_number() {
		return mentor_number;
	}
	public void setMentor_number(int mentor_number) {
		this.mentor_number = mentor_number;
	}
	public String getMentor_caution() {
		return mentor_caution;
	}
	public void setMentor_caution(String mentor_caution) {
		this.mentor_caution = mentor_caution;
	}
	public String getMentor_gender() {
		return mentor_gender;
	}
	public void setMentor_gender(String mentor_gender) {
		this.mentor_gender = mentor_gender;
	}
	public String getMentor_name() {
		return mentor_name;
	}
	public void setMentor_name(String mentor_name) {
		this.mentor_name = mentor_name;
	}
	public String getMentor_career() {
		return mentor_career;
	}
	public void setMentor_career(String mentor_career) {
		this.mentor_career = mentor_career;
	}
	public String getMentor_pic1() {
		return mentor_pic1;
	}
	public void setMentor_pic1(String mentor_pic1) {
		this.mentor_pic1 = mentor_pic1;
	}
	public String getMentor_origin_pic1() {
		return mentor_origin_pic1;
	}
	public void setMentor_origin_pic1(String mentor_origin_pic1) {
		this.mentor_origin_pic1 = mentor_origin_pic1;
	}
	public String getMentor_pic2() {
		return mentor_pic2;
	}
	public void setMentor_pic2(String mentor_pic2) {
		this.mentor_pic2 = mentor_pic2;
	}
	public String getMentor_origin_pic2() {
		return mentor_origin_pic2;
	}
	public void setMentor_origin_pic2(String mentor_origin_pic2) {
		this.mentor_origin_pic2 = mentor_origin_pic2;
	}
	public String getMentor_pic3() {
		return mentor_pic3;
	}
	public void setMentor_pic3(String mentor_pic3) {
		this.mentor_pic3 = mentor_pic3;
	}
	public String getMentor_origin_pic3() {
		return mentor_origin_pic3;
	}
	public void setMentor_origin_pic3(String mentor_origin_pic3) {
		this.mentor_origin_pic3 = mentor_origin_pic3;
	}
}
