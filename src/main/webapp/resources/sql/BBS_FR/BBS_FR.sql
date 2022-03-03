create table BBS_FR(
FR_NO		 NUMBER,
USER_ID		 VARCHAR2(60),
FR_PASS  	 VARCHAR2(20),
FR_CSFC		 VARCHAR2(14),
FR_SUBJECT	 VARCHAR2(300),
FR_CONTENT	 VARCHAR2(4000),
FR_DATE		 DATE,
FR_READCOUNT	 NUMBER  NOT NULL,
FR_FILE		 VARCHAR2(50),
FR_ORIGINAL	 VARCHAR2(50),
primary key(FR_NO),
foreign key(USER_ID) references MEMBER_INFO(USER_ID)
);

select * from BBS_FR;

insert into BBS_FR(FR_NO, USER_ID, FR_PASS, FR_CSFC, 
		   FR_SUBJECT, FR_CONTENT, FR_DATE, FR_READCOUNT,
		   FR_FILE, FR_ORIGINAL)
values(1, 'admin01', '1234', '운동방법', '제목', '내용', SYSDATE, 0,
      '/2021_9_17/bbs202191712345678.png', 'tear3.png');
insert into BBS_FR values(2, 'user01', '1234', '운동기록', '제목', '내용입니다.', sysdate, 0,'/2021_9_17/bbs202191787654321.png', 'strawberry.png');
insert into BBS_FR values(3, 'user02', '1234', '운동기록', '제목', '내용', sysdate, 0, '/2021_9_17/bbs202191777654321.png', 'strawberry.png');
insert into BBS_FR values(4, 'user03', '1234', '운동방법', '제목', '내용', sysdate, 0, '/2021_9_17/bbs202191786595583.png', 'icecream.png');
