--1.user ���� �Է�
INSERT INTO MEMBER_INFO VALUES('admin01','1234','1��','9009091234567','01032905515','����� ��鱸 �ູ��','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('admin02','1234','2��','9009091234567','01032905515','����� ��鱸 �ູ��','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('admin03','1234','3��','9009091234567','01032905515','����� ��鱸 �ູ��','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user01','1234','4��','9009091234567','01032905515','����� ��鱸 �ູ��','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user02','1234','5��','9009091234567','01032905515','����� ��鱸 �ູ��','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user03','1234','6��','9009091234567','01032905515','����� ��鱸 �ູ��','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user04','1234','7��','9009091234567','01032905515','����� ��鱸 �ູ��','niggo0803@gmail.com',200,100,90,25,1831.3,1);





--2.SPORTS ���� �Է�
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






--3.SPORTS ��Ī ��� �Է�
insert into SPORT_REGISTER(REGISTER_ID,REGISTER_NUM,SPORT_NUM,MATCH_PRS,MATCH_ADR,MATCH_DTL_ADR,MATCH_TIME,MATCH_SKL)
values('admin01',reg_seq.nextval,1,9,'��õ','������','09:00','��');

insert into SPORT_REGISTER(REGISTER_ID, REGISTER_NUM, SPORT_NUM,MATCH_PRS, MATCH_ADR, MATCH_DTL_ADR, MATCH_TIME, MATCH_SKL)
values('admin02', reg_seq.nextval, 2, 9, '����', '���α�', '13:00', '��');

insert into SPORT_REGISTER(REGISTER_ID, REGISTER_NUM, SPORT_NUM,MATCH_PRS, MATCH_ADR, MATCH_DTL_ADR, MATCH_TIME, MATCH_SKL)
values('admin03', reg_seq.nextval, 3, 11, '��õ', '������', '11:00', '��');





--4.SPORTS ��û 
insert into SPORT_APPLY(APPLY_ID, APPLY_NUM , REGISTER_NUM) values('admin01', aply_seq.nextval, 1);
insert into SPORT_APPLY(APPLY_ID, APPLY_NUM , REGISTER_NUM) values('admin02', aply_seq.nextval, 2);
insert into SPORT_APPLY(APPLY_ID, APPLY_NUM , REGISTER_NUM) values('admin03', aply_seq.nextval, 3);






--5.SPORTS �������
insert into SPORT_DEADLINE(REGISTER_ID, APPLY_ID, DEADLINE_NUM, SPORT_NUM)
values('admin01', 'admin03', dead_seq.nextval, 1);

insert into SPORT_DEADLINE(REGISTER_ID, APPLY_ID, DEADLINE_NUM, SPORT_NUM)
values('admin02', 'admin01', dead_seq.nextval, 2);

insert into SPORT_DEADLINE(REGISTER_ID, APPLY_ID, DEADLINE_NUM, SPORT_NUM)
values('admin03', 'admin02', dead_seq.nextval, 3);




--6.���� ��Ī ���
insert into MENTOR_MATCH values('mr1','user01','�౸ ����Ĩ�ϴ�1.','�౸','��Ͽ����Ű����1','������  ���� 6��',30000,10,'�౸ȭ�� ������ �غ��ؿ�����1','û��FC�⿬','/2021-9-17/bbs202191700000001.png','class1.png','/2021-9-17/bbs202191700000002.png','class2.png','/2021-9-17/bbs202191700000003.png','class3.png');

insert into MENTOR_MATCH values('mr2','user02','�౸ ����Ĩ�ϴ�2.','�౸','��Ͽ����Ű����2','ȭ����  ���� 6��',40000,11,'�౸ȭ�� ������ �غ��ؿ�����2','����FC�⿬','/2021-9-17/bbs202191700000004.png','class4.png','/2021-9-17/bbs202191700000005.png','class5.png','/2021-9-17/bbs202191700000006.png','class6.png');

insert into MENTOR_MATCH values('mr3','user03','�౸ ����Ĩ�ϴ�3.','�౸','��Ͽ����Ű����3','������  ���� 6��',50000,12,'�౸ȭ�� ������ �غ��ؿ�����3','����FC�⿬','/2021-9-17/bbs202191700000007.png','class7.png','/2021-9-17/bbs202191700000008.png','class8.png','/2021-9-17/bbs202191700000009.png','class9.png');

insert into MENTOR_MATCH values('mr4','user04','�౸ ����Ĩ�ϴ�4.','�౸','��Ͽ����Ű����4','�����  ���� 6��',60000,13,'�౸ȭ�� ������ �غ��ؿ�����4','�뱸FC�⿬','/2021-9-17/bbs202191700000010.png','class10.png','/2021-9-17/bbs202191700000011.png','class11.png','/2021-9-17/bbs202191700000012.png','class12.png');




--7.��Ƽ ��Ī ��� 
insert into MENTEE_MATCH values('me1','user01','�䰡 ���ϴ�.1','�߱�','gym01','������  ���� 1��',20000,'�ʺ��Դϴ�1.','/2021-9-17/bbs202191700000025.png','class25.png');
insert into MENTEE_MATCH values('me2','user02','�䰡 ���ϴ�.2','�߱�','gym02','������  ���� 2��',21000,'�ʺ��Դϴ�2.','/2021-9-17/bbs202191700000026.png','class26.png');
insert into MENTEE_MATCH values('me3','user03','�䰡 ���ϴ�.3','�߱�','gym03','������  ���� 3��',22000,'�ʺ��Դϴ�3.','/2021-9-17/bbs202191700000027.png','class27.png');
insert into MENTEE_MATCH values('me4','user04','�䰡 ���ϴ�.4','�߱�','gym04','������  ���� 4��',23000,'�ʺ��Դϴ�4.','/2021-9-17/bbs202191700000028.png','class28.png');






--8.�����Ƽ ��� ��Ȳ
insert into MATCH_INFO values(1,'user01' ,'me2',1);
insert into MATCH_INFO values(2,'user02' ,'me3',2);
insert into MATCH_INFO values(3,'user03' ,'mr4',3);
insert into MATCH_INFO values(4,'user04' ,'mr1',1);





--9.��Űŷ� Deal_Auction 
	insert into Deal_Auction values
	(1, '�������1', '��ų���1', 'admin01','2021-09-20',5000,1000,15000,0 ,'����',
	'cj',123214114 , '1main.png' , '2021-09-0712123' , '1two.png', '2021-09071515' , '1three.png' , '2021-090715156',
	'1.four.png','2021-84811');	
	insert into Deal_Auction values
	(2, '�������2', '��ų���2', 'admin01','2021-09-20',6000,2000,20000,0 ,'����',
	'��ü��',1234114 , '2main.png' , '2021-09-1231242123' , '2two.png', '2021-44071515' , '2three.png' , '2021-09715156',
	'2.four.png','2021-844211');
	insert into Deal_Auction values
	(3, '�������3', '��ų���3', 'admin02','2021-09-20',400,2000,18000,0 ,'����',
	'������',12323114 , '3main.png' , '2021-09-077723' , '3two.png', '2021-090715' , '3three.png' , '2021-090756',
	'3.four.png','2021-8471');
	insert into Deal_Auction values
	(4, '�������4', '��ų���4', 'admin02','2021-09-20',5000,1000,15000,0 ,'����',
	'cj',1232114 , '4main.png' , '2021-09-07772123' , '4two.png', '2021-1071515' , '4three.png' , '2021-095515156',
	'4.four.png','2021-8486611');





	
--10.���ŷ� Deal_Direcit

	insert into Deal_Direct values
	(1 , '���ŷ�����1' , '���ŷ�����1' , 'admin01' , '10000' , '010-9079-1111' , '����3���� 1���ⱸ' , sysdate ,
	'1main.png' , '2021-09-0712123' , '1two.png', '2021-09071515' , '1three.png' , '2021-090715156',
	'1.four.png','2021-84811');
	insert into Deal_Direct values
	(2 , '���ŷ�����2' , '���ŷ�����2' , 'admin01' , '15000' , '010-7779-1811' , '���࿪ 1���ⱸ' , sysdate ,
	'2main.png' , '2021-09-0412123' , '2two.png', '2021-04471515' , '2three.png' , '2021-050715156',
	'2.four.png','2021-84661');
	insert into Deal_Direct values
	(3 , '���ŷ�����3' , '���ŷ�����3' , 'admin02' , '8000' , '010-9559-1111' , '������' , sysdate ,
	'3main.png' , '2021-79-0712123' , '3two.png', '2021-809071515' , '3three.png' , '2021-09785156',
	'3.four.png','2021-84844411');
	insert into Deal_Direct values
	(4 , '���ŷ�����4' , '���ŷ�����4' , 'admin02' , '14500' , '010-9079-1181' , '����3���� 2���ⱸ' , sysdate ,
	'4main.png' , '2021-09-8712123' , '4two.png', '2021-071515' , '4three.png' , '2021-090156',
	'4.four.png','2021-81166');
	







--11.�� �ŷ� ���� MY_DEAL

	insert into MY_DEAL values
	('admin01' , 1 , 0 , 0 ,1 , 2, 0 , 0 ,0 ,0);









--12.� �Խ��� ��
insert into BBS_FR(FR_NO, USER_ID, FR_PASS, FR_CSFC, 
		   FR_SUBJECT, FR_CONTENT, FR_DATE, FR_READCOUNT,
		   FR_FILE, FR_ORIGINAL)
values(1, 'admin01', '1234', '����', '����', '����', SYSDATE, 0,
      '/2021_9_17/bbs202191712345678.png', 'tear3.png');
insert into BBS_FR values(2, 'user01', '1234', '����', '����', '�����Դϴ�.', sysdate, 0,'/2021_9_17/bbs202191787654321.png', 'strawberry.png');
insert into BBS_FR values(3, 'user02', '1234', '����', '����', '����', sysdate, 0, '/2021_9_17/bbs202191777654321.png', 'strawberry.png');
insert into BBS_FR values(4, 'user03', '1234', '����', '����', '����', sysdate, 0, '/2021_9_17/bbs202191786595583.png', 'icecream.png');








--13.� �Խ��� ���
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'admin01', '����Դϴ�1.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user01', '����Դϴ�2.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user02', '����Դϴ�3.', sysdate, 1);







--14.���� ���� ����(�����)

insert into PERSONAL_MANAGEMENT values(
					1,'user01', '63', SYSDATE, '�߱�'); 
insert into PERSONAL_MANAGEMENT values(
					2, 'user01', '810', SYSDATE, '�ｺ'); 
insert into PERSONAL_MANAGEMENT values(
					3, 'user01', '63', SYSDATE, '�౸');  



--15.�� ���뷮
insert into WATER_INTAKE values(
				1, 'user01', '2', sysdate);
