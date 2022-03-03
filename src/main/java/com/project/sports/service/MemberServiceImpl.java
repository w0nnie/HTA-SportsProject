package com.project.sports.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.MemberDAO;
import com.project.sports.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;

	@Override
	public int isId(String id, String password) {
		Member rmember = dao.isId(id);
		int result = -1;	//ID�� �������� �ʴ� ��� - rmember=null�� ���
		if(rmember!=null) {	//ID�� �����ϴ� ���
			if(rmember.getUSER_PASS().equals(password)) {
				result=1;	//ID,Password ��ġ
			}else {
				result=0;	//ID��ġ, Password ����ġ
			}
		}
		return result;
	}

	@Override
	public int isId(String id) {
		Member rmember = dao.isId(id);
		return (rmember==null)? -1 : 1 ;
		//1 : ID�����ϴ� ���, -1 : ID �������� �ʴ� ���
	}

	@Override
	public int insert(Member m) {
		return dao.insert(m);
	}

	public Member member_info(String id) {
		return dao.member_info(id);
	}

	public void delete(String id) {
		dao.delete(id);
	}

	public int update(Member m) {
		return dao.update(m);
	}
	@Override
	public List<Member> getSearchList(int index, String search_word, int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(index != -1) {
			String[] search_field = new String[] {"USER_ID","USER_PASS","USER_NAME","USER_JUMIN"};
			map.put("search_field", search_field[index]);
			map.put("search_word","%"+search_word+"%");
		}
		int startrow = (page-1)*limit+1;
		int endrow = startrow + limit - 1;
		map.put("start",startrow);
		map.put("end",endrow);
		return dao.getSearchList(map);
	}

	@Override
	public int getSearchListCount(int index, String search_word) {
		Map<String, String> map = new HashMap<String, String>();
		if(index!=-1) {//��Ʈ�ѷ� /list���� search_field�� �ƴ� ���
			String[] search_field = new String[] {"USER_ID","USER_PASS","USER_NAME","USER_JUMIN"};
			map.put("search_field", search_field[index]);
			map.put("search_word","%"+search_word+"%");
		}
		return dao.getSearchListCount(map);
	}
}
