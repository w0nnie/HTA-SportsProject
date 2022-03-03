create table Deal_Question (
	
	QUESTION_NUMBER  NUMBER PRIMARY KEY,		--문의 번호
	WRITE_NUMBER	 NUMBER,					--글번호 
	SUBJECT			 VARCHAR2(200),				--글제목
	DEAL_CSFC		 NUMBER,					--글분류 (1:경매 ,2:직)
	QUESTION_CONTENT	 VARCHAR2(4000),		--문의 내용
	QUESTION_ANSWER		 VARCHAR2(4000),		--문의 답변
	SELL_ID			 VARCHAR2(50),				--판매자 아이디
	QUESTION_ID		 VARCHAR2(50));				--문의자 아이디

	ALTER TABLE Deal_Question MODIFY SUBJECT VARCHAR2(200);
	
drop table Deal_Question
 /*문의번호 부여 시퀀스 */ 
 create sequence qs_seq ; 
 
 select * from deal_question
 
 delete  from deal_question