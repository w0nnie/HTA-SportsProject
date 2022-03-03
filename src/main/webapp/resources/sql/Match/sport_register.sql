DROP TABLE SPORT_REGISTER cascade constraints purge;

create table SPORT_REGISTER(
	REGISTER_ID VARCHAR2(60) references MEMBER_INFO(USER_ID),
	REGISTER_NUM NUMBER(20) primary key,  --reg_seq--
	SPORT_NUM references SPORTS(SPORTS_NUM), 
	MATCH_PRS NUMBER(20),
	MATCH_ADR VARCHAR2(100),
	MATCH_DTL_ADR VARCHAR2(100),
	MATCH_TIME VARCHAR2(100),
	MATCH_SKL VARCHAR2(100),
	REGISTER_STUS NUMBER(20) default 0
	--constraint REGISTER_STUS_CK check (REGISTER_STUS in ('0','1','2'))--
	--������ 0, ����� 1, ����2 (�Խñۿ� ���� ��������) --
);

delete SPORT_REGISTER where REGISTER_NUM =25;

select * from SPORT_REGISTER where REGISTER_STUS = 2;

update Sport_register
		set REGISTER_STUS = 2
		where REGISTER_NUM = 4

update Sport_register
		set REGISTER_STUS =1
		where REGISTER_NUM = 20;

select * from SPORT_REGISTER;
drop sequence reg_seq;
drop sequence aply_seq; 
drop sequence dead_seq;
create sequence reg_seq;


select * from SPORT_REGISTER where REGISTER_NUM=3;
 
insert into SPORT_REGISTER(REGISTER_ID,REGISTER_NUM,SPORT_NUM,MATCH_PRS,MATCH_ADR,MATCH_DTL_ADR,MATCH_TIME,MATCH_SKL)
values('admin01',reg_seq.nextval,1,9,'��õ������','������','2021-10-31','��');

insert into SPORT_REGISTER
(REGISTER_ID,REGISTER_NUM,SPORT_NUM,MATCH_PRS,MATCH_ADR,MATCH_DTL_ADR,MATCH_TIME,MATCH_SKL)
values('admin02', reg_seq.nextval, 2, 9, '����Ư����', '���α�', '2021-10-31', '��');

insert into SPORT_REGISTER
(REGISTER_ID, REGISTER_NUM, SPORT_NUM,MATCH_PRS, MATCH_ADR, MATCH_DTL_ADR, MATCH_TIME, MATCH_SKL)
values('admin03', reg_seq.nextval, 3, 11, '�λ걤����', '�ؿ�뱸', '2021-10-31', '��');

insert into SPORT_REGISTER(REGISTER_ID,REGISTER_NUM,SPORT_NUM,MATCH_PRS,MATCH_ADR,MATCH_DTL_ADR,MATCH_TIME,MATCH_SKL)
values('admin',reg_seq.nextval,1,9,'��õ������','����Ȧ��','2021-11-31','��');
