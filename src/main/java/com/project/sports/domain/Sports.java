package com.project.sports.domain;

public class Sports {
	private int SPORTS_NUM;			//������ ������ȣ
	private int SPORTS_CATEGORY;	//�������׸�(1:����,2:�ⱸ,3:�Ǹ�)
	private String SPORTS_NAME;		//��������
/* 1. ���� : ǲ��,�౸,�߱�,��,������,�״Ͻ�,Ź��,����,
 * 2. �ⱸ� : �ｺ,ũ�ν���,���Ǵ�,����Ŭ,����,
 * 3. �Ǹ�� : �䰡,�ʶ��׽�,���,����,������,����,�±�
 */
	private String CAL;				//��� �Ҹ�Į�θ�
	private String SPORTS_IMG;		//�������̹���
	
	private int sports_num;	
	
	public int getSPORTS_NUM() {
		return SPORTS_NUM;
	}
	public void setSPORTS_NUM(int sPORTS_NUM) {
		SPORTS_NUM = sPORTS_NUM;
	}
	public int getSPORTS_CATEGORY() {
		return SPORTS_CATEGORY;
	}
	public void setSPORTS_CATEGORY(int sPORTS_CATEGORY) {
		SPORTS_CATEGORY = sPORTS_CATEGORY;
	}
	public String getSPORTS_NAME() {
		return SPORTS_NAME;
	}
	public void setSPORTS_NAME(String sPORTS_NAME) {
		SPORTS_NAME = sPORTS_NAME;
	}
	public String getCAL() {
		return CAL;
	}
	public void setCAL(String cAL) {
		CAL = cAL;
	}
	public String getSPORTS_IMG() {
		return SPORTS_IMG;
	}
	public void setSPORTS_IMG(String sPORTS_IMG) {
		SPORTS_IMG = sPORTS_IMG;
	}
	public int getSports_num() {
		return sports_num;
	}
	public void setSports_num(int sports_num) {
		this.sports_num = sports_num;
	}
}
