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

select * from sports;