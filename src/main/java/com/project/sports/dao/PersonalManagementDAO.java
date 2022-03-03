package com.project.sports.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.PersonalManagement;
import com.project.sports.domain.Sports;

@Repository
public class PersonalManagementDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void insertPM(PersonalManagement pm) {
		sqlSession.insert("Pm.insert", pm);
	}

	public List<Sports> getSelect(String select) {
		return sqlSession.selectList("Pm.select", select);
	}

	public int delete(int num) {
		return sqlSession.delete("Pm.delete", num);
	}

	public List<PersonalManagement> getList(HashMap<String, Object> map) {
		return sqlSession.selectList("Pm.selectkcal", map);	
	}

	public int getListCount(String id) {
		return sqlSession.selectOne("Pm.selectcount",id);
		
	}

	public List<Map<String, Object>> getCalendar(Map<String, Object> map) {
		return sqlSession.selectList("Pm.getCalendar", map);
	}

}
