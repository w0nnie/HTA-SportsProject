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
	SAVE_DIR_FILE4		 VARCHAR2(100) );			-- 저장용사진4
	
	DROP TABLE DEAL_DIRECT;
	
	/*추가된 부분 9-27*/
	create sequence Dir_seq; 
	drop sequence dir_seq;
	/*-----------*/
	
	/*추가된 부분 9-30*/
	ALTER TABLE Deal_Direct ADD DIR_READCOUNT number  DEFAULT 0; 
	/*-----------*/
	
	ALTER TABLE Deal_Direct DROP COLUMN DIR_READCOUNT;
	
	delete from Deal_Direct;
	
	delete from deal_direct where dir_number = 3
	
	select* from Deal_direct;
	
	/* 10-02일 변경 */
	ALTER TABLE Deal_direct MODIFY DIR_PRICE NUMBER;
	/*-------------*/
	W
	
update deal_direct set DIR_READCOUNT = DIR_READCOUNT +1 
where dir_number = 35;





select * from
	(select rownum rnum , 	DIR_NUMBER , DIR_SUBJECT , 
	DIR_PRICE ,DIR_ADDRESS ,DIR_DATE ,SAVE_DIR_MAINFILE ,DIR_READCOUNT
		from(
		select * from deal_direct
		order by DIR_PRICE desc ))
	 where rnum >= 1 and rnum  <=  10


	