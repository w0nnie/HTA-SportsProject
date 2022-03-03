package com.project.sports.domain;

public class Sports {
	private int SPORTS_NUM;			//스포츠 고유번호
	private int SPORTS_CATEGORY;	//스포츠항목(1:구기,2:기구,3:맨몸)
	private String SPORTS_NAME;		//스포츠명
/* 1. 구기운동 : 풋살,축구,야구,농구,배드민턴,테니스,탁구,골프,
 * 2. 기구운동 : 헬스,크로스핏,스피닝,사이클,서핑,
 * 3. 맨몸운동 : 요가,필라테스,등산,런닝,주짓수,복싱,태권
 */
	private String CAL;				//운동당 소모칼로리
	private String SPORTS_IMG;		//스포츠이미지
	
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
