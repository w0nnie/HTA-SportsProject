create table PERSONAL_MANAGEMENT(
PM_NO			 NUMBER primary key,
USER_ID			 VARCHAR2(60) references MEMBER_INFO(USER_ID),
PM_KCAL			 VARCHAR2(20),
PM_DATE			 DATE,
SPORTS_NAME		 VARCHAR2(100) NOT NULL references SPORTS(SPORTS_NAME),
SPORTS_IMG		 VARCHAR2(50) NOT NULL references SPORTS(SPORTS_IMG)
);

insert into PERSONAL_MANAGEMENT values(
					1,'user01', '63', SYSDATE, '야구'); 
insert into PERSONAL_MANAGEMENT values(
					2, 'user01', '810', SYSDATE, '헬스'); 
insert into PERSONAL_MANAGEMENT values(
					3, 'user01', '63', SYSDATE, '축구');  
					
select * from personal_management;

select pm_date from PERSONAL_MANAGEMENT
where to_char(pm_date, 'YYYYMMDD') = to_char(sysdate, 'YYYYMMDD');

