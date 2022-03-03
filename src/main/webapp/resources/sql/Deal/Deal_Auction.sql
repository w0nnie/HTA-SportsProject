create table Deal_Auction (
	AUC_NUMBER		 NUMBER primary key , 		--글번호 
	AUC_SUBJECT 	 VARCHAR2(200) , 				--글제목
	AUC_CONTENT 	 VARCHAR2(4000), 			--글내용
	USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade , 		--아이디
	AUC_DATE 		 VARCHAR2(50), 						--경매기간/		
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
	SAVE_AUC_FILE4		 VARCHAR2(100) );			-- 저장용사진4
	
	
select * from Deal_Auction;
select auc_nowdate from deal_auction;
select * from board;
select * from member_info;
drop table deal_auction;

delete from DEAL_AUCTION;

/*추가된 부분 9- 27 */
create sequence Auc_seq; 
drop sequence auc_seq;
/*----------*/

/*추가된 부분 9-30 조회수컬럼*/
	ALTER TABLE DEAL_AUCTION ADD AUC_READCOUNT number  DEFAULT 0; 
/*-----------*/

	ALTER TABLE DEAL_AUCTION DROP COLUMN AUC_READCOUNT;
	
	select * from deal_auction;

/*추가된 부분10-03 시작금액 컬럼*/
	ALTER TABLE DEAL_AUCTION ADD AUC_SPRICE number ; 
/*--------------------------*/
	
/*추가된 부분 10-03 입찰횟수 기본값 변경 */
	ALTER TABLE DEAL_AUCTION DROP COLUMN AUC_COUNT;
	ALTER TABLE DEAL_AUCTION ADD AUC_COUNT number  DEFAULT 0; 
/*----------------------------*/
	
/*-추가된 부분 10-07 올린날짜 컬럼 추가 */
	ALTER TABLE DEAL_AUCTION ADD AUC_NOWDATE date DEFAULT sysdate;

/*-----------------------------*/
	
/* 10-12일 변경 컬럼속성	변경  */
ALTER TABLE DEAL_AUCTION MODIFY AUC_DELIVERYNUM VARCHAR2(50);
/*-------------*/

/* 10-13일 AUC_DATE 속성 VARCHAR2로 변경
 */
 
/* 10-15일 AUC_SUBJECT 크기 변경 */
 ALTER TABLE DEAL_AUCTION MODIFY AUC_SUBJECT VARCHAR2(200);
