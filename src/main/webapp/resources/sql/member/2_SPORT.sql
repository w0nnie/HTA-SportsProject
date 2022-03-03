--�������׸�,Į�θ�,�̹���
CREATE TABLE SPORTS(
SPORTS_NUM		 NUMBER PRIMARY KEY,						--������������ȣ
SPORTS_CATEGORY	 NUMBER NOT NULL,						--�������׸�(1:����, 2:�ⱸ, 3:�Ǹ�)
SPORTS_NAME		 VARCHAR2(100)  UNIQUE NOT NULL,					--��������
--1. ���� : ǲ��,�౸,�߱�,��,������,�״Ͻ�,Ź��,����,
--2. �ⱸ� : �ｺ,ũ�ν���,���Ǵ�,����Ŭ,����,
--3. �Ǹ�� : �䰡,�ʶ��׽�,���,����,������,����,�±�
CAL				 VARCHAR2(10) NOT NULL,					--��� �Ҹ�Į�θ�
SPORTS_IMG		 VARCHAR2(50) NOT NULL					--�������̹���
);

SELECT * FROM SPORTS;--SPORTS ��ȸ
DROP TABLE SPORTS CASCADE CONSTRAINTS;--SPORTS ����

INSERT INTO SPORTS(SPORTS_NUM, SPORTS_CATEGORY,
SPORTS_NAME, CAL, SPORTS_IMG) VALUES(
1,					--SPORTS���̺� ������ȣ
1,					--�������׸�
'�౸',				--��� �Ҹ�Į�θ�(1�д�)
9,					--��������
'soccer.png'		--�������̹���
);

INSERT INTO SPORTS VALUES(2,1,'�߱�',6,'baseball.png');
INSERT INTO SPORTS VALUES(3,2,'�ｺ',6,'fitness.png');
INSERT INTO SPORTS VALUES(4,2,'ũ�ν���',8,'crossfit.png');
INSERT INTO SPORTS VALUES(5,3,'�ʶ��׽�',5,'pilates.png');
