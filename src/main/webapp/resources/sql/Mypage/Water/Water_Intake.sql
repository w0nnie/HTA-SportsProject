
create table WATER_INTAKE(
wi_no			 NUMBER primary key,
user_id			 VARCHAR2(60) references MEMBER_INFO(USER_ID),
title		 	 VARCHAR2(10),
time_start		 varchar2(10),
time_end	     varchar2(10)
);

insert into WATER_INTAKE values(
				1, 'user01', '2', sysdate);
				
select * from WATER_INTAKE;
--³âµµ / ´Þ



