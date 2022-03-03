package com.project.sports.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.PersonalManagementDAO;
import com.project.sports.domain.PersonalManagement;
import com.project.sports.domain.Sports;

@Service
public class PersonalManagementServiceImpl implements PersonalManagementService{

	@Autowired
	PersonalManagementDAO dao;

	@Override
	public void insertPM(PersonalManagement pm) {
		dao.insertPM(pm);
	}

	@Override
	public List<Sports> getSelect(String select) {
		return dao.getSelect(select);
	}

	@Override
	public List<PersonalManagement> getList(String id,int page, int limit) {
		HashMap<String,Object>map = new HashMap<String, Object>();
		int startrow=(page-1) * limit + 1;
		int endrow = startrow + limit -1;
		map.put("start", startrow);
		map.put("end", endrow);
		map.put("id", id);
		return dao.getList(map);
	}
	
	@Override
	public int getListCount(String id) {
		return dao.getListCount(id);
	}

	@Override
	public int delete(int num) {
		return dao.delete(num);
	}

	@Override
	public List<Map<String, Object>> getCalendar(Map<String,Object> map) {
		return dao.getCalendar(map);
	}

}
