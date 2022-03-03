package com.project.sports.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.MmatchDAO;
import com.project.sports.domain.MatchAppReq;
import com.project.sports.domain.MatchInfo;
import com.project.sports.domain.Mentee;
import com.project.sports.domain.Mentor;
import com.project.sports.domain.Sports;
import com.sun.media.jfxmedia.logging.Logger;


@Service
public class MmatchServiceImpl implements MmatchService {
	@Autowired
	private MmatchDAO dao;

	@Override
	public List<String> getSportlist(int selType) {
		return dao.getSportlist(selType);
	}

	@Override
	public List<String> getSilist() {
		return dao.getSilist();
	}

	@Override
	public List<String> getDonglist(String selType) {
		return dao.getDonglist(selType);
	}

	@Override
	public int insertMentorWriting(Mentor mentor) {
		return dao.insertMentorWriting(mentor);
	}

	@Override
	public List<Sports> getSportDeatilList(int selType) {
		return dao.getSportDeatilList(selType);
	}
	
	@Override
	public int getMentorListCount() {
		return dao.getMentorListCount();
	}

	@Override
	public List<Mentor> getMentorList(int page, int limit) {
		HashMap <String,Integer> map = new HashMap <String,Integer>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		return dao.getMentorList(map);
	}

	@Override
	public int getSearchMentorListCount(String search_field, String search_word) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(!search_field.equals("")) {
			//검색 영역이 있다면 map에 put
			map.put("search_field",search_field);
			
			//검색 영역에 따라 map에 put을하는 조건이 틀림
			switch(search_field) {
				case "지역" : 
					String[] loc =search_word.split(",");
					map.put("search_word",loc[0]);
					map.put("search_addword",loc[1]);
					break;
				case "수업료": 
					String money =search_word.substring(0,2)+"0000";
					map.put("search_word",money);
					break;
				case "과목" : 
				case "성별" : 
					map.put("search_word",search_word);
					break;
			}
			
		}
		return dao.getSearchMentorListCount(map);
	}

	@Override
	public List<Mentor> getSearchMentorList(int page, int limit, String search_field, String search_word) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(!search_field.equals("")) {
			//검색 영역이 있다면 map에 put
			map.put("search_field",search_field);
			
			//검색 영역에 따라 map에 put을하는 조건이 틀림
			switch(search_field) {
				case "지역" : 
					String[] loc =search_word.split(",");
					map.put("search_word",loc[0]);
					map.put("search_addword",loc[1]);
					break;
				case "수업료": 
					String money =search_word.substring(0,2)+"0000";
					map.put("search_word",money);
					break;
				case "과목" : 
				case "성별" : 
					map.put("search_word",search_word);
					break;
			}
			
		}
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		return dao.getSearchMentorList(map);
	}

	@Override
	public Mentor getMentorDetail(String code) {
		return dao.getMentorDetail(code);
	}

	@Override
	public int ApplyMentor(String id,String code) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("code",code);
		return dao.ApplyWMentor(map);
	}

	@Override
	public int checkApply(String id, String code) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("code",code);
		return dao.checkApply(map);
	}

	@Override
	public int deleteMentor(String code) {
		return dao.deleteWMentor(code);
	}

	@Override
	public int getSport(String subject) {
		return dao.getSport(subject);
	}

	@Override
	public int modifyMentorWriting(Mentor mentor) {
		return dao.modifyMentorWriting(mentor);
	}

	@Override
	public int changeApplyState(MatchInfo matchinfo) {
		return dao.changeApplyState(matchinfo);
	}
	
	@Override
	public int insertMenteeWriting(Mentee mentee) {
		return dao.insertMenteeWriting(mentee);
	}


	
	@Override
	public int getMenteeListCount() {
		return dao.getMenteeListCount();
	}

	@Override
	public List<Mentee> getMenteeList(int page, int limit) {
		HashMap <String,Integer> map = new HashMap <String,Integer>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		return dao.getMenteeList(map);
	}

	@Override
	public int getSearchMenteeListCount(String search_field, String search_word) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(!search_field.equals("")) {
			//검색 영역이 있다면 map에 put
			map.put("search_field",search_field);
			
			//검색 영역에 따라 map에 put을하는 조건이 틀림
			switch(search_field) {
				case "지역" : 
					String[] loc =search_word.split(",");
					map.put("search_word",loc[0]);
					map.put("search_addword",loc[1]);
					break;
				case "수업료": 
					String money =search_word.substring(0,2)+"0000";
					map.put("search_word",money);
					break;
				case "과목" : 
				case "성별" : 
					map.put("search_word",search_word);
					break;
			}
			
		}
		return dao.getSearchMenteeListCount(map);
	}

	@Override
	public List<Mentee> getSearchMenteeList(int page, int limit, String search_field, String search_word) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(!search_field.equals("")) {
			//검색 영역이 있다면 map에 put
			map.put("search_field",search_field);
			
			//검색 영역에 따라 map에 put을하는 조건이 틀림
			switch(search_field) {
				case "지역" : 
					String[] loc =search_word.split(",");
					map.put("search_word",loc[0]);
					map.put("search_addword",loc[1]);
					break;
				case "수업료": 
					String money =search_word.substring(0,2)+"0000";
					map.put("search_word",money);
					break;
				case "과목" : 
				case "성별" : 
					map.put("search_word",search_word);
					break;
			}
			
		}
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		return dao.getSearchMenteeList(map);
	}

	@Override
	public Mentee getMenteeDetail(String code) {
		return dao.getMenteeDetail(code);
	}

	@Override
	public int ApplyMentee(String id,String code) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("code",code);
		return dao.ApplyWMentee(map);
	}

	@Override
	public int deleteMentee(String code) {
		return dao.deleteWMentee(code);
	}

	@Override
	public int modifyMenteeWriting(Mentee mentee) {
		return dao.modifyMenteeWriting(mentee);
	}

	
	@Override
	public int getMyMentorListCount(String id) {
		return dao.getMyMentorListCount(id);
	}
	
	@Override
	public int getMyMenteeListCount(String id) {
		return dao.getMyMenteeListCount(id);
	}
	
	@Override
	public List<Mentor> getMyMentorList(int page, int limit,String id) {
		HashMap <String,Object> map = new HashMap <String,Object>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		map.put("id",id);
		return dao.getMyMentorList(map);
	}
	@Override
	public List<Mentee> getMyMenteeList(int page, int limit,String id) {
		HashMap <String,Object> map = new HashMap <String,Object>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		map.put("id",id);
		return dao.getMyMenteeList(map);
	}

	@Override
	public int getMyMentorAppListCount(String id) {
		// TODO Auto-generated method stub
		return dao.getMyMentorAppListCount(id);
	}

	@Override
	public int getMyMenteeAppListCount(String id) {
		// TODO Auto-generated method stub
		return dao.getMyMenteeAppListCount(id);
	}
	
	@Override
	public List<MatchAppReq> getMyMentorAppList(int page, int limit, String id) {
		HashMap <String,Object> map = new HashMap <String,Object>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		map.put("id",id);
		return dao.getMyMentorAppList(map);
	}

	@Override
	public List<MatchAppReq> getMyMenteeAppList(int page, int limit, String id) {
		HashMap <String,Object> map = new HashMap <String,Object>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		map.put("id",id);
		return dao.getMyMenteeAppList(map);
	}

	@Override
	public int cancelApply(String code,String id) {
		HashMap <String,Object> map = new HashMap <String,Object>();
		map.put("code",code);
		map.put("id",id);
		return dao.cancelApply(map);
	}
	
	@Override
	public int getMyMentorReqListCount(String id) {
		// TODO Auto-generated method stub
		return dao.getMyMentorReqListCount(id);
	}

	@Override
	public int getMyMenteeReqListCount(String id) {
		// TODO Auto-generated method stub
		return dao.getMyMenteeReqListCount(id);
	}
	
	@Override
	public List<MatchAppReq> getMyMentorReqList(int page, int limit, String id) {
		HashMap <String,Object> map = new HashMap <String,Object>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		map.put("id",id);
		return dao.getMyMentorReqList(map);
	}

	@Override
	public List<MatchAppReq> getMyMenteeReqList(int page, int limit, String id) {
		HashMap <String,Object> map = new HashMap <String,Object>();
		int startrow =(page-1)*limit +1;
		int endrow=startrow+limit-1;
		map.put("start",startrow);
		map.put("end",endrow);
		map.put("id",id);
		return dao.getMyMenteeReqList(map);
	}
}
