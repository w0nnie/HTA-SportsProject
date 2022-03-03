create table MY_DEAL(
	USER_ID VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade,			--아아디
	AUC_NUMBER NUMBER ,						--글번호
	BUY_BIDDING	 NUMBER default 0,					--입찰중(구매)
	BUY_BIDCOM         NUMBER default 0,					--입찰완료(구매)
	BUY_BIDFAIL	 NUMBER default 0,					--입찰실패(구매)
	BUY_DELIVERY	 NUMBER default 0,				--배송중(구매)
	SELL_BIDDING	 NUMBER default 0,				--입찰중(판매)
	SELL_BIDCOM		 NUMBER default 0,				--배송중(판매)
	SELL_DELIVERY	 NUMBER default 0,				--배송입력(판매)
	PICK			 NUMBER default 0);	--장바구니
	
	drop table my_deal;
	delete from my_deal;
	
	select * from my_deal;
	
	/*10-09 추가 거래분류 속성추가*/
	ALTER TABLE MY_DEAL ADD DEAL_CSFC number  DEFAULT 0;
	/*************************/
	
/* 발표세팅 삭제*/ 
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

