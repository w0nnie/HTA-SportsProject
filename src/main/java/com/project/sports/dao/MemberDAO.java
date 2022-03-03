package com.project.sports.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member isId(String id) {
		return sqlSession.selectOne("Members.idcheck",id);//xml mapper이름
	}
	public int insert(Member m) {
		return sqlSession.insert("Members.insert",m);
	}
	public int getSearchListCount(Map<String, String> map) {
		return sqlSession.selectOne("Members.searchCount",map);//primary key 가져올때는 selectOne
	}
	public List<Member> getSearchList(Map<String, Object> map) {
		return sqlSession.selectList("Members.searchList",map);
	}
	public Member member_info(String id) {
		return sqlSession.selectOne("Members.idcheck",id);
	}
	public void delete(String id) {
		sqlSession.delete("Members.delete",id);
	}
	public int update(Member m) {
		return sqlSession.update("Members.update",m);
	}
	
}
