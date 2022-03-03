--스포츠항목,칼로리,이미지
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

SELECT * FROM SPORTS;--SPORTS 조회
DROP TABLE SPORTS CASCADE CONSTRAINTS;--SPORTS 삭제

INSERT INTO SPORTS(SPORTS_NUM, SPORTS_CATEGORY,
SPORTS_NAME, CAL, SPORTS_IMG) VALUES(
1,					--SPORTS테이블 고유번호
1,					--스포츠항목
'축구',				--운동당 소모칼로리(1분당)
9,					--스포츠명
'soccer.png'		--스포츠이미지
);

INSERT INTO SPORTS VALUES(2,1,'야구',6,'baseball.png');
INSERT INTO SPORTS VALUES(3,2,'헬스',6,'fitness.png');
INSERT INTO SPORTS VALUES(4,2,'크로스핏',8,'crossfit.png');
INSERT INTO SPORTS VALUES(5,3,'필라테스',5,'pilates.png');
