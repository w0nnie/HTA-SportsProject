--ȸ������
CREATE TABLE MEMBER_INFO(
USER_ID			 VARCHAR2(60) PRIMARY KEY,	--ȸ��ID
USER_PASS		 VARCHAR2(60) NOT NULL,		--ȸ����й�ȣ
USER_NAME		 VARCHAR2(15) NOT NULL,		--ȸ���̸�
USER_JUMIN		 VARCHAR2(13) NOT NULL,		--ȸ���ֹι�ȣ
USER_MOBILE		 VARCHAR2(11) NOT NULL,		--ȸ����ȭ��ȣ
USER_ADDRESS	 VARCHAR2(300) NOT NULL,		--ȸ���ּ�
USER_EMAIL		 VARCHAR2(100) NOT NULL,		--ȸ���̸���
USER_HEIGHT		 NUMBER NOT NULL,			--ȸ������(Ű)
USER_PWEIGHT	 NUMBER NOT NULL,			--ȸ�����������
USER_WWEIGHT	 NUMBER NOT NULL,			--ȸ����ǥ������
USER_BMI		 NUMBER,						--ȸ��BMI(���������/(Ű*Ű)*10000)
USER_RMR		 NUMBER,						--ȸ�����ʴ�緮
											--(����:66.47+(13.75*���������)+(5*Ű)-(6.75*����)
											--(����:655.1+(9.56*���������)+(1.85*Ű)-(4.68*����)
USER_WATER		 VARCHAR2(10),						--ȸ�������뷮
USER_IMAGE		 VARCHAR2(100),				--ȸ�� ������
USER_PSPORTS1	 VARCHAR2(10),				--��ȣ�1
USER_PSPORTS2	 VARCHAR2(10),				--��ȣ�2
USER_PSPORTS3	 VARCHAR2(10)				--��ȣ�3
);






CREATE TABLE SPORTS(
SPORTS_NUM		 NUMBER PRIMARY KEY,						--������������ȣ
SPORTS_CATEGORY	 NUMBER NOT NULL,						--�������׸�(1:����, 2:�ⱸ, 3:�Ǹ�)
SPORTS_NAME		 VARCHAR2(100)  UNIQUE NOT NULL,					--��������
--1. ���� : ǲ��,�౸,�߱�,��,������,�״Ͻ�,Ź��,����,
--2. �ⱸ� : �ｺ,ũ�ν���,���Ǵ�,����Ŭ,����,
--3. �Ǹ�� : �䰡,�ʶ��׽�,���,����,������,����,�±�
CAL				 VARCHAR2(10) NOT NULL,					--��� �Ҹ�Į�θ�
SPORTS_IMG		 VARCHAR2(50) NOT NULL					--�������̹���
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
	--������ 0, ����� 1, ����2 (�Խñۿ� ���� ��������) --
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
	AUC_NUMBER		 NUMBER primary key , 		--�۹�ȣ 
	AUC_SUBJECT 	 VARCHAR2(50) , 				--������
	AUC_CONTENT 	 VARCHAR2(4000), 			--�۳���
	USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade , 		--���̵�
	AUC_DATE 		 DATE, 						--��űⰣ/		
	AUC_PRICE 		 NUMBER, 					--��Ű�
	AUC_UNIT		 NUMBER, 					--��������
	AUC_LPRICE		 NUMBER, 					--��ñ��Ű�
	AUC_COUNT		 NUMBER, 					--������
	AUC_DELIVERY	 VARCHAR2(20), 				--��۹��
	AUC_DELIVERYCOM	 VARCHAR2(30), 				--�ù��
	AUC_DELIVERYNUM  NUMBER, 					--�����ȣ
	ORI_AUC_MAINFILE	  VARCHAR2(100),			--��¥ ���λ���
	SAVE_AUC_MAINFILE	 VARCHAR2(100),			--����� ���λ���
	ORI_AUC_FILE2		 VARCHAR2(100), 			--��¥ ����2
	SAVE_AUC_FILE2		 VARCHAR2(100), 			--����� ����2
	ORI_AUC_FILE3		 VARCHAR2(100), 			--��¥ ����3
	SAVE_AUC_FILE3		 VARCHAR2(100), 			--����� ����3
	ORI_AUC_FILE4		 VARCHAR2(100), 			-- ��¥����4
	SAVE_AUC_FILE4		 VARCHAR2(100) );	




create table MY_DEAL(
	USER_ID VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade,	--�ƾƵ�
	AUC_NUMBER NUMBER references DEAL_AUCTION(AUC_NUMBER)
					on delete cascade,	--�۹�ȣ
	BUY_BIDDING	 NUMBER,					--������(����)
	BUY_BIDCOM         NUMBER,					--�����Ϸ�(����)
	BUY_BIDFAIL	 NUMBER,					--��������(����)
	BUY_DELIVERY	 NUMBER,				--�����(����)
	SELL_BIDDING	 NUMBER,				--������(�Ǹ�)
	SELL_BIDCOM		 NUMBER,				--�����Ϸ�(�Ǹ�)
	SELL_DELIVERY	 NUMBER,				--����Է�(�Ǹ�)
	PICK			 NUMBER);




create table Deal_Direct (
	DIR_NUMBER 	 NUMBER       primary key,	--�۹�ȣ 
	DIR_SUBJECT 	 VARCHAR2(50),				--������ 
	DIR_CONTENT 	 VARCHAR2(4000),				--�۳���
	USER_ID		 VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade , 		--���̵�
	DIR_PRICE		 VARCHAR2(20),				--�ݾ�
	DIR_PHONE		 VARCHAR2(30),				--��ȭ��ȣ
	DIR_ADDRESS		 VARCHAR2(70),				--�ŷ�����
	DIR_DATE		 DATE default sysdate,		--�ð�
	ORI_DIR_MAINFILE	 VARCHAR2(100),			--��¥ ���λ���
	SAVE_DIR_MAINFILE	 VARCHAR2(100),			--����� ���λ���
	ORI_DIR_FILE2		 VARCHAR2(100), 			--��¥ ����2
	SAVE_DIR_FILE2		 VARCHAR2(100), 			--����� ����2
	ORI_DIR_FILE3		 VARCHAR2(100), 			--��¥ ����3
	SAVE_DIR_FILE3		 VARCHAR2(100), 			--����� ����3
	ORI_DIR_FILE4		 VARCHAR2(100), 			-- ��¥����4
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