--ȸ������
CREATE TABLE MEMBER_INFO(
USER_ID			 VARCHAR2(60) PRIMARY KEY,	--ȸ��ID
USER_PASS		 VARCHAR2(60) NOT NULL,		--ȸ����й�ȣ
USER_NAME		 VARCHAR2(15) NOT NULL,		--ȸ���̸�
USER_JUMIN		 VARCHAR2(13) NOT NULL,		--ȸ���ֹι�ȣ
USER_MOBILE		 VARCHAR2(11) NOT NULL,		--ȸ����ȭ��ȣ
USER_ADDRESS	 VARCHAR2(300) NOT NULL,	--ȸ���ּ�
USER_EMAIL		 VARCHAR2(100) NOT NULL,	--ȸ���̸���
USER_HEIGHT		 NUMBER NOT NULL,			--ȸ������(Ű)
USER_PWEIGHT	 NUMBER NOT NULL,			--ȸ�����������
USER_WWEIGHT	 NUMBER NOT NULL,			--ȸ����ǥ������
USER_BMI		 NUMBER,					--ȸ��BMI(���������/(Ű*Ű)*10000)
USER_RMR		 NUMBER,					--ȸ�����ʴ�緮
											--(����:66.47+(13.75*���������)+(5*Ű)-(6.75*����)
											--(����:655.1+(9.56*���������)+(1.85*Ű)-(4.68*����)
USER_WATER		 VARCHAR2(10),				--ȸ�������뷮
USER_IMAGE		 VARCHAR2(150),				--ȸ�� ������
USER_PSPORTS	 VARCHAR2(50)				--��ȣ�
);

SELECT * FROM MEMBER_INFO;--MEMBER_INFO ��ȸ
delete from MEMBER_INFO where USER_ID='admin';

DROP TABLE MEMBER_INFO CASCADE CONSTRAINTS;--MEMBER_INFO ����

INSERT INTO MEMBER_INFO(
USER_ID,USER_PASS,USER_NAME,
USER_JUMIN,USER_MOBILE,USER_ADDRESS,
USER_EMAIL,USER_HEIGHT,USER_PWEIGHT,USER_WWEIGHT,
USER_BMI,USER_RMR,USER_WATER
) VALUES(
'admin',1234,'2��',								--ID, ��й�ȣ, �̸�
9009091234567,01032905515,'����� ��鱸 �ູ��',	--�ֹι�ȣ, ��ȭ��ȣ, �ּ�
'niggo0803@gmail.com',200,100,90,				--�̸���, Ű, ���������, ��ǥ������
25,1831.3,1										--BMI, ���ʴ�緮, �����뷮				
)