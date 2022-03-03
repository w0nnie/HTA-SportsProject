package com.project.sports.service;

import java.util.List;

import com.project.sports.domain.Sports;

public interface MainService {
	public List<Sports> getRecommSportlList(int state);
}
