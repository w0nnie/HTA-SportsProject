package com.project.sports.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.BBS_FCM;

@Repository
public class Bbs_FcmDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getListCount(int FR_NO) {
		return sqlSession.selectOne("BBS_FCM.count",FR_NO);
	}

	public List<BBS_FCM> getFcmList(Map<String, Integer> map) {
		return sqlSession.selectList("BBS_FCM.getList",map);
	}

	public int FcmInsert(BBS_FCM fcm) {
		return sqlSession.insert("BBS_FCM.insert", fcm);
	}

	public int FcmDelete(int num) {
		return sqlSession.delete("BBS_FCM.delete", num);
	}

	public int commentUpdate(BBS_FCM fcm) {
		return sqlSession.update("BBS_FCM.update", fcm);
	}
	
}
