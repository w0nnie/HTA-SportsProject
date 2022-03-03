package com.project.sports.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.Bbs_FcmDAO;
import com.project.sports.domain.BBS_FCM;

@Service
public class Bbs_FcmServiceImpl implements Bbs_FcmService{

	@Autowired
	Bbs_FcmDAO dao;

	@Override
	public int getListCount(int FR_NO) {
		return dao.getListCount(FR_NO);
	}

	@Override
	public List<BBS_FCM> getFcmList(int FR_NO, int page) {
		int startrow =1;
		int endrow = page*3;
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("FR_NO", FR_NO);
		map.put("start", startrow);
		map.put("end", endrow);
		return dao.getFcmList(map);
	}

	@Override
	public int FcmInsert(BBS_FCM fcm) {
		return dao.FcmInsert(fcm);

	}

	@Override
	public int FcmDelete(int num) {
		return dao.FcmDelete(num);
	}

	@Override
	public int FcmUpdate(BBS_FCM fcm) {
		return dao.commentUpdate(fcm);
	}
}
