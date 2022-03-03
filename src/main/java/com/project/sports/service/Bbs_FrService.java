package com.project.sports.service;

import java.util.List;

import com.project.sports.domain.BBS_FR;


public interface Bbs_FrService {
	//글의 개수 구하기
	public int getSearchListCount(int index, String search_word);
		
	//글의 목록 보기
	public List<BBS_FR> getSearchList(int index, String search_word, int page, int limit);
	
	//글 작성
	public void insertBoard(BBS_FR board);

	//상세보기	
	public BBS_FR getDetail(int num);

	//조회수 업데이트
	public int setReadCountUpdate(int num);
	
	//비밀번호 확인(삭제)
	public boolean isFrWriter(int num, String pass);
	
	//게시글 삭제
	public int FrDelete(int num);
	
	//게시글 수정
	public int FrModify(BBS_FR boarddata);


}
