package com.project.sports.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.WaterIntakeDAO;
import com.project.sports.domain.WaterIntake;

@Service
public class WaterIntakeServiceImpl implements WaterIntakeService{

	@Autowired
	WaterIntakeDAO dao;

	
	@Override
	public void Waterinsert(WaterIntake water) {
		dao.Waterinsert(water);
	}
	 

	@Override
	public List<WaterIntake> getList(String yearMonth) {
		return dao.getList(yearMonth);
	}

	@Override
	public void wateradd(WaterIntake water) {
		dao.wateradd(water);
	}

	@Override
	public float DoughnutList(String id) {
		return dao.DoughnutList(id);
	}

	@Override
	public int doughnutlistcount(String id) {
		return dao.doughnutlistcount(id);
	}

	@Override
	public void waterUpdate(WaterIntake water) {
		dao.waterUpdate(water);
	}

	@Override
	public int delWater(Map<String, Object> map) {
		return dao.delWater(map);
	}

}
	
	
