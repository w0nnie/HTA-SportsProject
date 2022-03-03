create table Deal_Point (
	
	USER_ID 	  		  VARCHAR2(20)  PRIMARY KEY,		--아이디	
	SEND_NAME	  		 VARCHAR2(20),				--입금자 성명
	REAL_POINT			 NUMBER default 0,			-- 현재 포인트
	REQUEST_POINT		 NUMBER default 0,			--요청 포인트
	POINT_PROCESS		 NUMBER	default 0			--포인트 처리상황 [0:대기(완료) , 1:요청]

	);				
	
	drop table deal_point;
	delete from deal_point;
	
	insert into deal_point
	(USER_ID)
	VALUES( 'admin01')
	
	insert into deal_point
	(USER_ID)
	VALUES( 'admin02')
	
	insert into deal_point
	(USER_ID)
	VALUES( 'user01')
	
	insert into deal_point
	(USER_ID)
	VALUES( 'user02')
	
	insert into deal_point
	(USER_ID)
	VALUES( 'user03')
