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
	SAVE_DIR_FILE4		 VARCHAR2(100) );			-- ��������4
	
	DROP TABLE DEAL_DIRECT;
	
	/*�߰��� �κ� 9-27*/
	create sequence Dir_seq; 
	drop sequence dir_seq;
	/*-----------*/
	
	/*�߰��� �κ� 9-30*/
	ALTER TABLE Deal_Direct ADD DIR_READCOUNT number  DEFAULT 0; 
	/*-----------*/
	
	ALTER TABLE Deal_Direct DROP COLUMN DIR_READCOUNT;
	
	delete from Deal_Direct;
	
	delete from deal_direct where dir_number = 3
	
	select* from Deal_direct;
	
	/* 10-02�� ���� */
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


	