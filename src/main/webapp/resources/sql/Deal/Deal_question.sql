create table Deal_Question (
	
	QUESTION_NUMBER  NUMBER PRIMARY KEY,		--���� ��ȣ
	WRITE_NUMBER	 NUMBER,					--�۹�ȣ 
	SUBJECT			 VARCHAR2(200),				--������
	DEAL_CSFC		 NUMBER,					--�ۺз� (1:��� ,2:��)
	QUESTION_CONTENT	 VARCHAR2(4000),		--���� ����
	QUESTION_ANSWER		 VARCHAR2(4000),		--���� �亯
	SELL_ID			 VARCHAR2(50),				--�Ǹ��� ���̵�
	QUESTION_ID		 VARCHAR2(50));				--������ ���̵�

	ALTER TABLE Deal_Question MODIFY SUBJECT VARCHAR2(200);
	
drop table Deal_Question
 /*���ǹ�ȣ �ο� ������ */ 
 create sequence qs_seq ; 
 
 select * from deal_question
 
 delete  from deal_question