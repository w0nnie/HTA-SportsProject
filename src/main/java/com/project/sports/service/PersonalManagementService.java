package com.project.sports.service;

import java.util.List;
import java.util.Map;

import com.project.sports.domain.PersonalManagement;
import com.project.sports.domain.Sports;

public interface PersonalManagementService {
	
	//셀렉바에 데이터 불러오기
	List<Sports> getSelect(String select);
	//데이터 삽입
	void insertPM(PersonalManagement pm);
	//당일 운동량 존재하는지 개수 확인(데이터개수)
	int getListCount(String id);
	//삭제
	int delete(int num);
	//칼로리, 운동종목, 사진 등 데이터(당일운동량페이지)
	List<PersonalManagement> getList(String id,int page, int limit);
	//캘린더에 나올 총 칼로리+총물섭취량 데이터(캘린더 페이지)
	List<Map<String,Object>> getCalendar(Map<String, Object> map);
	//캘린더에 나올 총칼로리(물섭취량이 없을 경우)
	
	
}
