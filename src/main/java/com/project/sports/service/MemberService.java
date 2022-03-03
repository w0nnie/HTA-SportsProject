package com.project.sports.service;
import java.util.List;

import com.project.sports.domain.Member;

public interface MemberService {
	public int isId(String id, String password);
	public int isId(String id);
	public int insert(Member m);
	public Member member_info(String id);
	public void delete(String id);
	public int update(Member m);
	public List<Member> getSearchList(int index, String search_word,
			int page, int limit);
	public int getSearchListCount(int index, String search_word);
}
