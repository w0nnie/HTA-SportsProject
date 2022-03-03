package com.project.sports.service;

import java.util.List;

import com.project.sports.domain.BBS_FR;


public interface Bbs_FrService {
	//���� ���� ���ϱ�
	public int getSearchListCount(int index, String search_word);
		
	//���� ��� ����
	public List<BBS_FR> getSearchList(int index, String search_word, int page, int limit);
	
	//�� �ۼ�
	public void insertBoard(BBS_FR board);

	//�󼼺���	
	public BBS_FR getDetail(int num);

	//��ȸ�� ������Ʈ
	public int setReadCountUpdate(int num);
	
	//��й�ȣ Ȯ��(����)
	public boolean isFrWriter(int num, String pass);
	
	//�Խñ� ����
	public int FrDelete(int num);
	
	//�Խñ� ����
	public int FrModify(BBS_FR boarddata);


}
