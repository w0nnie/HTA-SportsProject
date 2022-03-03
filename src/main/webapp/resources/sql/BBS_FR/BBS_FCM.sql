drop table BBS_FCM cascade constraints;

create table BBS_FCM(
FCM_NO			 NUMBER primary key,
USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID),
FCM_CONTENT		 VARCHAR2(200),
FCM_REF_DATE		 DATE,
FR_NO			 NUMBER references BBS_FR(FR_NO) on delete cascade
);

create sequence FCM_SEQ;

drop sequnce FCM_SEQ;

alter table BBS_FCM
add (FCM_RE_LEV number(1) check(FCM_RE_LEV in (0,1,2)),
	FCM_RE_SEQ number, --�����̸� 0
	FCM_RE_REF number); --������ �ڽ� �۹�ȣ, ����̸� ���� �۹�ȣ

insert into BBS_FCM
		values(FCM_SEQ.nextval, 'admin01', '����Դϴ�1.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user01', '����Դϴ�2.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user02', '����Դϴ�3.', sysdate, 1);
		
SELECT * FROM BBS_FCM;
delete BBS_FCM where FCM_NO = 21;