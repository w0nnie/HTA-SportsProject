--회원정보
CREATE TABLE MEMBER_INFO(
USER_ID			 VARCHAR2(60) PRIMARY KEY,	--회원ID
USER_PASS		 VARCHAR2(60) NOT NULL,		--회원비밀번호
USER_NAME		 VARCHAR2(15) NOT NULL,		--회원이름
USER_JUMIN		 VARCHAR2(13) NOT NULL,		--회원주민번호
USER_MOBILE		 VARCHAR2(11) NOT NULL,		--회원전화번호
USER_ADDRESS	 VARCHAR2(300) NOT NULL,		--회원주소
USER_EMAIL		 VARCHAR2(100) NOT NULL,		--회원이메일
USER_HEIGHT		 NUMBER NOT NULL,			--회원신장(키)
USER_PWEIGHT	 NUMBER NOT NULL,			--회원현재몸무게
USER_WWEIGHT	 NUMBER NOT NULL,			--회원목표몸무게
USER_BMI		 NUMBER,						--회원BMI(현재몸무게/(키*키)*10000)
USER_RMR		 NUMBER,						--회원기초대사량
											--(남자:66.47+(13.75*현재몸무게)+(5*키)-(6.75*나이)
											--(여자:655.1+(9.56*현재몸무게)+(1.85*키)-(4.68*나이)
USER_WATER		 VARCHAR2(10),						--회원물섭취량
USER_IMAGE		 VARCHAR2(100),				--회원 프로필
USER_PSPORTS1	 VARCHAR2(10),				--선호운동1
USER_PSPORTS2	 VARCHAR2(10),				--선호운동2
USER_PSPORTS3	 VARCHAR2(10)				--선호운동3
);






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





create table SPORT_REGISTER(
	REGISTER_ID VARCHAR2(60) references MEMBER_INFO(USER_ID) on delete cascade UNIQUE,
	REGISTER_NUM NUMBER(20) primary key,  --reg_seq--
	SPORT_NUM references SPORTS(SPORTS_NUM), 
	MATCH_PRS NUMBER(20),
	MATCH_ADR VARCHAR2(100),
	MATCH_DTL_ADR VARCHAR2(100),
	MATCH_TIME VARCHAR2(100),
	MATCH_SKL VARCHAR2(100),
	REGISTER_STUS NUMBER(20) default 0
	--constraint REGISTER_STUS_CK check (REGISTER_STUS in ('0','1','2'))--
	--모집중 0, 대기중 1, 마감2 (게시글에 대한 상태정보) --
);





create table SPORT_APPLY(
	APPLY_ID VARCHAR2(60) references MEMBER_INFO(USER_ID) on delete cascade UNIQUE,
	APPLY_NUM  NUMBER(20) primary key, --seq
	REGISTER_NUM references SPORT_REGISTER(REGISTER_NUM)
);




create table SPORT_DEADLINE(
	REGISTER_ID references SPORT_REGISTER(REGISTER_ID) on delete cascade,
	APPLY_ID references SPORT_APPLY(APPLY_ID) on delete cascade,
	DEADLINE_NUM NUMBER primary key,
	SPORT_NUM references SPORTS(SPORTS_NUM)
);




CREATE TABLE MENTOR_MATCH(
  MENTOR_CODE          VARCHAR2(4)     NOT NULL,
  USER_ID                   VARCHAR2(60)     NOT NULL,
  MENTOR_TITLE          VARCHAR2(200)      NOT NULL,
  SPORTS_NAME            VARCHAR2(100)     NOT NULL,
  MENTOR_LOCATION    VARCHAR2(100)     NOT NULL,
  MENTOR_DATE          VARCHAR2(300)     NOT NULL,
  MENTOR_AMOUNT      NUMBER(7)       NOT NULL,
  MENTOR_NUBER         NUMBER(2)       NOT NULL,
  MENTOR_CAUTION      VARCHAR2(200),
  MENTOR_CAREER        VARCHAR2(200),    
  MENTOR_PIC1            VARCHAR2(100),
  MENTOR_ORIGIN_PIC1  VARCHAR2(20),
  MENTOR_PIC2            VARCHAR2(100),
  MENTOR_ORIGIN_PIC2  VARCHAR2(20),
  MENTOR_PIC3            VARCHAR2(100),
  MENTOR_ORIGIN_PIC3  VARCHAR2(20),
  FOREIGN KEY(USER_ID)  REFERENCES MEMBER_INFO(USER_ID) on delete cascade,
  FOREIGN KEY(SPORTS_NAME)  REFERENCES SPORTS(SPORTS_NAME) on delete cascade,
  PRIMARY KEY(MENTOR_CODE)
);




CREATE TABLE MENTEE_MATCH (
  MENTEE_CODE           VARCHAR2(4)        NOT NULL,
  USER_ID                   VARCHAR2(60)       NOT NULL,
  MENTEE_TITLE           VARCHAR2(200)      NOT NULL,
  SPORTS_NAME            VARCHAR2(100)     NOT NULL,
  MENTEE_LOCATION    VARCHAR2(100)     NOT NULL,
  MENTEE_DATE           VARCHAR2(300)     NOT NULL,
  MENTEE_AMOUNT      NUMBER(7)          NOT NULL,
  MENTEE_REQ             VARCHAR2(200),
  MENTEE_PIC1             VARCHAR2(100),
  MENTEE_ORIGIN_PIC1   VARCHAR2(20),
  FOREIGN KEY(USER_ID)  REFERENCES MEMBER_INFO(USER_ID) on delete cascade,
  FOREIGN KEY(SPORTS_NAME)  REFERENCES SPORTS(SPORTS_NAME) on delete cascade,
  PRIMARY KEY(MENTEE_CODE)
);



CREATE TABLE MATCH_INFO (
  MATCH_NO               NUMBER(3)          NOT NULL,
  USER_ID                    VARCHAR2(60)     NOT NULL,
  MATCH_CODE             VARCHAR2(4)      NOT NULL,
  MATCH_STATE            NUMBER(1)         NOT NULL,
  FOREIGN KEY(USER_ID)  REFERENCES MEMBER_INFO(USER_ID) on delete cascade,
  PRIMARY KEY(MATCH_NO)
);



create table Deal_Auction (
	AUC_NUMBER		 NUMBER primary key , 		--글번호 
	AUC_SUBJECT 	 VARCHAR2(50) , 				--글제목
	AUC_CONTENT 	 VARCHAR2(4000), 			--글내용
	USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade , 		--아이디
	AUC_DATE 		 DATE, 						--경매기간/		
	AUC_PRICE 		 NUMBER, 					--경매가
	AUC_UNIT		 NUMBER, 					--입찰단위
	AUC_LPRICE		 NUMBER, 					--즉시구매가
	AUC_COUNT		 NUMBER, 					--입찰수
	AUC_DELIVERY	 VARCHAR2(20), 				--배송방법
	AUC_DELIVERYCOM	 VARCHAR2(30), 				--택배사
	AUC_DELIVERYNUM  NUMBER, 					--송장번호
	ORI_AUC_MAINFILE	  VARCHAR2(100),			--진짜 메인사진
	SAVE_AUC_MAINFILE	 VARCHAR2(100),			--저장용 메인사진
	ORI_AUC_FILE2		 VARCHAR2(100), 			--진짜 사진2
	SAVE_AUC_FILE2		 VARCHAR2(100), 			--저장용 사진2
	ORI_AUC_FILE3		 VARCHAR2(100), 			--진짜 사진3
	SAVE_AUC_FILE3		 VARCHAR2(100), 			--저장용 사진3
	ORI_AUC_FILE4		 VARCHAR2(100), 			-- 진짜사진4
	SAVE_AUC_FILE4		 VARCHAR2(100) );	




create table MY_DEAL(
	USER_ID VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade,	--아아디
	AUC_NUMBER NUMBER references DEAL_AUCTION(AUC_NUMBER)
					on delete cascade,	--글번호
	BUY_BIDDING	 NUMBER,					--입찰중(구매)
	BUY_BIDCOM         NUMBER,					--입찰완료(구매)
	BUY_BIDFAIL	 NUMBER,					--입찰실패(구매)
	BUY_DELIVERY	 NUMBER,				--배송중(구매)
	SELL_BIDDING	 NUMBER,				--입찰중(판매)
	SELL_BIDCOM		 NUMBER,				--입찰완료(판매)
	SELL_DELIVERY	 NUMBER,				--배송입력(판매)
	PICK			 NUMBER);




create table Deal_Direct (
	DIR_NUMBER 	 NUMBER       primary key,	--글번호 
	DIR_SUBJECT 	 VARCHAR2(50),				--글제목 
	DIR_CONTENT 	 VARCHAR2(4000),				--글내용
	USER_ID		 VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade , 		--아이디
	DIR_PRICE		 VARCHAR2(20),				--금액
	DIR_PHONE		 VARCHAR2(30),				--전화번호
	DIR_ADDRESS		 VARCHAR2(70),				--거래지역
	DIR_DATE		 DATE default sysdate,		--시간
	ORI_DIR_MAINFILE	 VARCHAR2(100),			--진짜 메인사진
	SAVE_DIR_MAINFILE	 VARCHAR2(100),			--저장용 메인사진
	ORI_DIR_FILE2		 VARCHAR2(100), 			--진짜 사진2
	SAVE_DIR_FILE2		 VARCHAR2(100), 			--저장용 사진2
	ORI_DIR_FILE3		 VARCHAR2(100), 			--진짜 사진3
	SAVE_DIR_FILE3		 VARCHAR2(100), 			--저장용 사진3
	ORI_DIR_FILE4		 VARCHAR2(100), 			-- 진짜사진4
	SAVE_DIR_FILE4		 VARCHAR2(100) );	




create table BBS_FR(
FR_NO		 NUMBER,
USER_ID		 VARCHAR2(60),
FR_PASS  	 VARCHAR2(20),
FR_CSFC		 VARCHAR2(14),
FR_SUBJECT	 VARCHAR2(300),
FR_CONTENT	 VARCHAR2(4000),
FR_DATE		 DATE,
FR_READCOUNT	 NUMBER  NOT NULL,
FR_FILE		 VARCHAR2(50),
FR_ORIGINAL	 VARCHAR2(50),
primary key(FR_NO),
foreign key(USER_ID) references MEMBER_INFO(USER_ID)
);


create table BBS_FCM(
FCM_NO			 NUMBER primary key,
USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID),
FCM_CONTENT		 VARCHAR2(200),
FCM_REF_DATE		 DATE,
FR_NO			 NUMBER references BBS_FR(FR_NO) on delete cascade
);


create table PERSONAL_MANAGEMENT(
PM_NO			 NUMBER primary key,
USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID),
PM_KCAL			 VARCHAR2(20),
PM_DATE			 DATE,
SPORTS_NAME		 VARCHAR2(100) NOT NULL references SPORTS(SPORTS_NAME)
);




create table WATER_INTAKE(
WI_NO			 NUMBER primary key,
USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID),
WI_INTAKE		 VARCHAR(10),
WI_DATE			 DATE
);