package com.project.sports.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.Sports;

@Repository
public class mainDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Sports> getRecommSportlList(int state){
		return sqlSession.selectList("Mains.sportRecommList",state);
	}

}
