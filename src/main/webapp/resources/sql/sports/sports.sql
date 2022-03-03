CREATE TABLE SPORTS(
SPORTS_NUM		 NUMBER PRIMARY KEY,						--스포츠고유번호
SPORTS_CATEGORY	 NUMBER NOT NULL,						--스포츠항목(1:구기, 2:기구, 3:맨몸)
SPORTS_NAME		 VARCHAR2(100)  UNIQUE NOT NULL,					--스포츠명
--1. 구기운동 : 풋살,축구,야구,농구,배드민턴,테니스,탁구,골프,
--2. 기구운동 : 헬스,크로스핏,스피닝,사이클,서핑,
--3. 맨몸운동 : 요가,필라테스,등산,런닝,주짓수,복싱,태권
CAL				 VARCHAR2(10) NOT NULL,					--운동당 소모칼로리
SPORTS_IMG		 VARCHAR2(50) NOT NULL					--스포츠이미지
);

select * from sports;