create table MY_DEAL(
	USER_ID VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade,			--�ƾƵ�
	AUC_NUMBER NUMBER ,						--�۹�ȣ
	BUY_BIDDING	 NUMBER default 0,					--������(����)
	BUY_BIDCOM         NUMBER default 0,					--�����Ϸ�(����)
	BUY_BIDFAIL	 NUMBER default 0,					--��������(����)
	BUY_DELIVERY	 NUMBER default 0,				--�����(����)
	SELL_BIDDING	 NUMBER default 0,				--������(�Ǹ�)
	SELL_BIDCOM		 NUMBER default 0,				--�����(�Ǹ�)
	SELL_DELIVERY	 NUMBER default 0,				--����Է�(�Ǹ�)
	PICK			 NUMBER default 0);	--��ٱ���
	
	drop table my_deal;
	delete from my_deal;
	
	select * from my_deal;
	
	/*10-09 �߰� �ŷ��з� �Ӽ��߰�*/
	ALTER TABLE MY_DEAL ADD DEAL_CSFC number  DEFAULT 0;
	/*************************/
	
/* ��ǥ���� ����*/ 
delete from deal_auction;
delete from deal_direct;
delete from deal_question;
delete from my_deal;
delete from deal_point;
drop sequence auc_seq;
drop sequence dir_seq;
drop sequence qs_seq ; 



create sequence auc_seq;
create sequence dir_seq;
create sequence qs_seq ; 

insert into deal_point
	(USER_ID)
	VALUES( 'admin');

insert into deal_point
	(USER_ID)
	VALUES( 'admin01');
	
	insert into deal_point
	(USER_ID)
	VALUES( 'admin02');
	
	insert into deal_point
	(USER_ID)
	VALUES( 'user01');
	
	insert into deal_point
	(USER_ID)
	VALUES( 'user02');
	
	insert into deal_point
	(USER_ID)
	VALUES( 'user03');

