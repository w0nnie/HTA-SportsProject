package com.project.sports.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.mainDAO; 
import com.project.sports.domain.Sports;


@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private mainDAO dao;
	
	@Override
	public List<Sports> getRecommSportlList(int state){
		return dao.getRecommSportlList(state);
	}
}
