package com.project.sports.service;

import java.util.HashMap; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.MatchDAO;
import com.project.sports.domain.Match;
import com.project.sports.domain.Match_Apply;
import com.project.sports.domain.Match_Deadline;
import com.project.sports.domain.Sports;

@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	private MatchDAO dao;
	
	@Override
	public int getListCount(int num) {
		return dao.getListCount(num);
	}

	@Override
	public List<Match> getMatchList(int page, int limit, int num) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int startrow = (page-1)*limit +1;
		int endrow = startrow + limit -1;
		map.put("start", startrow);
		map.put("end", endrow);
		map.put("num", num);
		return dao.getMatchList(map);
	}

	@Override
	public String selSportName(Sports param){
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int sports_num = param.getSports_num();
		map.put("sports_num", sports_num);
		return dao.selSportName(map);
	}

	@Override
	public void insertMatch(Match match) {
		dao.insertMatch(match);
	}

	@Override
	public List<Match> getSearchList(int num, String MATCH_ADR, String MATCH_DTL_ADR, String MATCH_TIME,
			int MATCH_PRS, String MATCH_SKL) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("MATCH_ADR", MATCH_ADR);
		map.put("MATCH_DTL_ADR", MATCH_DTL_ADR);
		map.put("MATCH_TIME", MATCH_TIME);
		map.put("MATCH_PRS", MATCH_PRS);
		map.put("MATCH_SKL", MATCH_SKL);
		return dao.getSearchList(map);
	}

	@Override
	public List<Match> selRegi(int REGISTER_NUM) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("REGISTER_NUM", REGISTER_NUM);
		return dao.selRegi(map);
	}

	@Override
	public int RegiupdateMatch(int REGISTER_NUM) {
		return dao.RegiupdateMatch(REGISTER_NUM);
	}

	@Override
	public String getemail(String REGISTER_ID) {
		return dao.getemail(REGISTER_ID);
	}

	@Override
	public void ApplyMatch(Match_Apply match_apply) {
		dao.ApplyMatch(match_apply);
	}

	@Override
	public List<Match> getRegiList(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.myRegi(map);
	}

	@Override
	public List<Match> getApplyList(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.myApply(map);
	}
	
	@Override
	public List<Match> getDeadList(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return dao.myDead(map);
	}

	@Override
	public int MactingUpdate(Match match) {
		return dao.MactingUpdate(match);
	}

	@Override
	public int Regidelete(int REGISTER_NUM) {
		return dao.Regidelete(REGISTER_NUM);
	}

	@Override
	public String getApplyID(int REGISTER_NUM) {
		return dao.getApplyID(REGISTER_NUM);
	}
	

	@Override
	public String getRegiID(int REGISTER_NUM) {
		return dao.getRegiID(REGISTER_NUM);
	}

	@Override
	public int ApplyupdateMatch(int REGISTER_NUM) {
		return dao.ApplyupdateMatch(REGISTER_NUM);
	}

	@Override
	public int Regifinalupdate(int REGISTER_NUM) {
		return dao.Regifinalupdate(REGISTER_NUM);
	}

	@Override
	public void DeadMatch(int SPORT_NUM, String APPLY_ID, String REGISTER_ID, int REGISTER_NUM) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("SPORT_NUM", SPORT_NUM);
		map.put("APPLY_ID", APPLY_ID);
		map.put("REGISTER_ID", REGISTER_ID);
		map.put("REGISTER_NUM", REGISTER_NUM);
		dao.DeadMatch(map);
		
	}

	@Override
	public String getMobile(String Register_ID) {
		return dao.getMobile(Register_ID);
	}
	
}
