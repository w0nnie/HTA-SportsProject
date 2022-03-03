package com.project.sports.dao;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.sports.domain.Match;
import com.project.sports.domain.Match_Apply;
import com.project.sports.domain.Match_Deadline;
import com.project.sports.domain.Sports;

@Repository
public class MatchDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int getListCount(int num) {
		return sqlSession.selectOne("Match.count", num);
	}
	
	public List<Match> getMatchList(HashMap<String, Integer> map) {
		return sqlSession.selectList("Match.list",map);
	}
	
	public String selSportName(HashMap<String, Integer> param) {
		return sqlSession.selectOne("Match.selSportName", param);
	}

	public void insertMatch(Match match) {
		sqlSession.insert("Match.insert",match);
	}

	public List<Match> getSearchList(HashMap<String, Object> map) {
		return sqlSession.selectList("Match.searchlist",map);
	}

	public List<Match> selRegi(HashMap<String, Object> map) {
		return sqlSession.selectList("Match.selRegi",map);
	}

	public int RegiupdateMatch(int REGISTER_NUM) {
		return sqlSession.update("Match.Regiupdate",REGISTER_NUM);	
	}

	public String getemail(String REGISTER_ID) {
		return sqlSession.selectOne("Match.getemail",REGISTER_ID);
	}

	public void ApplyMatch(Match_Apply match_apply) {
		sqlSession.insert("Match.ApplyMatch",match_apply);
	}

	public List<Match> myRegi(HashMap<String, Object> map) {
		return sqlSession.selectList("Match.myRegi",map);
	}

	public List<Match> myApply(HashMap<String, Object> map) {
		return sqlSession.selectList("Match.myApply",map);
	}
	
	public List<Match> myDead(HashMap<String, Object> map) {
		return sqlSession.selectList("Match.myDead",map);
	}

	public int MactingUpdate(Match match) {
		return sqlSession.update("Match.MactingUpdate",match);
	}

	public int Regidelete(int REGISTER_NUM) {
		return sqlSession.delete("Match.delete",REGISTER_NUM);
	}

	public String getApplyID(int REGISTER_NUM) {
		return sqlSession.selectOne("Match.getApplyID",REGISTER_NUM);
	}
	
	public String getRegiID(int REGISTER_NUM) {
		return sqlSession.selectOne("Match.getRegiID",REGISTER_NUM);
	}

	public int ApplyupdateMatch(int REGISTER_NUM) {
		return sqlSession.update("Match.ApplyupdateMatch",REGISTER_NUM);
	}

	public int Regifinalupdate(int REGISTER_NUM) {
		return sqlSession.update("Match.Regifinalupdate", REGISTER_NUM);
	}

	public void DeadMatch(HashMap<String, Object> map) {
		sqlSession.insert("Match.DeadMatch",map);
	}

	public String getMobile(String register_ID) {
		return sqlSession.selectOne("Match.getMobile",register_ID);
	}
}
