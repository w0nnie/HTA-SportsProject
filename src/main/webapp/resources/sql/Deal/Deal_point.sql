create table Deal_Point (
	
	USER_ID 	  		  VARCHAR2(20)  PRIMARY KEY,		--���̵�	
	SEND_NAME	  		 VARCHAR2(20),				--�Ա��� ����
	REAL_POINT			 NUMBER default 0,			-- ���� ����Ʈ
	REQUEST_POINT		 NUMBER default 0,			--��û ����Ʈ
	POINT_PROCESS		 NUMBER	default 0			--����Ʈ ó����Ȳ [0:���(�Ϸ�) , 1:��û]

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
