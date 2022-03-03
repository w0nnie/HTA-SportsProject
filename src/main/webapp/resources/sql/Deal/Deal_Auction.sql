create table Deal_Auction (
	AUC_NUMBER		 NUMBER primary key , 		--�۹�ȣ 
	AUC_SUBJECT 	 VARCHAR2(200) , 				--������
	AUC_CONTENT 	 VARCHAR2(4000), 			--�۳���
	USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID)
					on delete cascade , 		--���̵�
	AUC_DATE 		 VARCHAR2(50), 						--��űⰣ/		
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
	SAVE_AUC_FILE4		 VARCHAR2(100) );			-- ��������4
	
	
select * from Deal_Auction;
select auc_nowdate from deal_auction;
select * from board;
select * from member_info;
drop table deal_auction;

delete from DEAL_AUCTION;

/*�߰��� �κ� 9- 27 */
create sequence Auc_seq; 
drop sequence auc_seq;
/*----------*/

/*�߰��� �κ� 9-30 ��ȸ���÷�*/
	ALTER TABLE DEAL_AUCTION ADD AUC_READCOUNT number  DEFAULT 0; 
/*-----------*/

	ALTER TABLE DEAL_AUCTION DROP COLUMN AUC_READCOUNT;
	
	select * from deal_auction;

/*�߰��� �κ�10-03 ���۱ݾ� �÷�*/
	ALTER TABLE DEAL_AUCTION ADD AUC_SPRICE number ; 
/*--------------------------*/
	
/*�߰��� �κ� 10-03 ����Ƚ�� �⺻�� ���� */
	ALTER TABLE DEAL_AUCTION DROP COLUMN AUC_COUNT;
	ALTER TABLE DEAL_AUCTION ADD AUC_COUNT number  DEFAULT 0; 
/*----------------------------*/
	
/*-�߰��� �κ� 10-07 �ø���¥ �÷� �߰� */
	ALTER TABLE DEAL_AUCTION ADD AUC_NOWDATE date DEFAULT sysdate;

/*-----------------------------*/
	
/* 10-12�� ���� �÷��Ӽ�	����  */
ALTER TABLE DEAL_AUCTION MODIFY AUC_DELIVERYNUM VARCHAR2(50);
/*-------------*/

/* 10-13�� AUC_DATE �Ӽ� VARCHAR2�� ����
 */
 
/* 10-15�� AUC_SUBJECT ũ�� ���� */
 ALTER TABLE DEAL_AUCTION MODIFY AUC_SUBJECT VARCHAR2(200);
