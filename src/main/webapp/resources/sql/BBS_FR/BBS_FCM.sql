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
	FCM_RE_SEQ number, --원문이면 0
	FCM_RE_REF number); --원문은 자신 글번호, 답글이면 원문 글번호

insert into BBS_FCM
		values(FCM_SEQ.nextval, 'admin01', '댓글입니다1.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user01', '댓글입니다2.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user02', '댓글입니다3.', sysdate, 1);
		
SELECT * FROM BBS_FCM;
delete BBS_FCM where FCM_NO = 21;