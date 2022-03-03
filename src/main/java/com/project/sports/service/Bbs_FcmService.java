package com.project.sports.service;

import java.util.List;

import com.project.sports.domain.BBS_FCM;

public interface Bbs_FcmService {

	int getListCount(int FR_NO);

	List<BBS_FCM> getFcmList(int FR_NO, int page);

	int FcmInsert(BBS_FCM fcm);

	int FcmDelete(int num);

	int FcmUpdate(BBS_FCM fcm);

}
