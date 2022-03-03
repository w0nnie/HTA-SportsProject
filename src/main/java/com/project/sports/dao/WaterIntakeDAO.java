package com.project.sports.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.WaterIntake;

@Repository
public class WaterIntakeDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	public void Waterinsert(WaterIntake water) {
		sqlSession.insert("Water.insert", water);
	}
	 

	public List<WaterIntake> getList(String yearMonth) {
		return sqlSession.selectList("Water.select", yearMonth);
	}

	public void wateradd(WaterIntake water) {
		sqlSession.insert("Water.add", water);
	}

	public float DoughnutList(String id) {
		return sqlSession.selectOne("Water.doughnutlist", id);
	}

	public int doughnutlistcount(String id) {
		return sqlSession.selectOne("Water.doughnutlistcount",id);
	}

	public void waterUpdate(WaterIntake water) {
		sqlSession.update("Water.update", water);
	}


	public int delWater(Map<String, Object> map) {
		return sqlSession.delete("Water.delWater", map);
	}

}
