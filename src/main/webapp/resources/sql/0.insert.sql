--1.user 정보 입력
INSERT INTO MEMBER_INFO VALUES('admin01','1234','1조','9009091234567','01032905515','사랑시 고백구 행복동','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('admin02','1234','2조','9009091234567','01032905515','사랑시 고백구 행복동','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('admin03','1234','3조','9009091234567','01032905515','사랑시 고백구 행복동','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user01','1234','4조','9009091234567','01032905515','사랑시 고백구 행복동','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user02','1234','5조','9009091234567','01032905515','사랑시 고백구 행복동','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user03','1234','6조','9009091234567','01032905515','사랑시 고백구 행복동','niggo0803@gmail.com',200,100,90,25,1831.3,1);
INSERT INTO MEMBER_INFO VALUES('user04','1234','7조','9009091234567','01032905515','사랑시 고백구 행복동','niggo0803@gmail.com',200,100,90,25,1831.3,1);





--2.SPORTS 정보 입력
INSERT INTO SPORTS(SPORTS_NUM, SPORTS_CATEGORY,
SPORTS_NAME, CAL, SPORTS_IMG) VALUES(
1,					--SPORTS테이블 고유번호
1,					--스포츠항목
'축구',				--운동당 소모칼로리(1분당)
9,					--스포츠명
'soccer.png'		--스포츠이미지
);

INSERT INTO SPORTS VALUES(2,1,'야구',6,'baseball.png');
INSERT INTO SPORTS VALUES(3,2,'헬스',6,'fitness.png');
INSERT INTO SPORTS VALUES(4,2,'크로스핏',8,'crossfit.png');
INSERT INTO SPORTS VALUES(5,3,'필라테스',5,'pilates.png');






--3.SPORTS 매칭 등록 입력
insert into SPORT_REGISTER(REGISTER_ID,REGISTER_NUM,SPORT_NUM,MATCH_PRS,MATCH_ADR,MATCH_DTL_ADR,MATCH_TIME,MATCH_SKL)
values('admin01',reg_seq.nextval,1,9,'인천','연수구','09:00','상');

insert into SPORT_REGISTER(REGISTER_ID, REGISTER_NUM, SPORT_NUM,MATCH_PRS, MATCH_ADR, MATCH_DTL_ADR, MATCH_TIME, MATCH_SKL)
values('admin02', reg_seq.nextval, 2, 9, '서울', '종로구', '13:00', '중');

insert into SPORT_REGISTER(REGISTER_ID, REGISTER_NUM, SPORT_NUM,MATCH_PRS, MATCH_ADR, MATCH_DTL_ADR, MATCH_TIME, MATCH_SKL)
values('admin03', reg_seq.nextval, 3, 11, '인천', '연수구', '11:00', '상');





--4.SPORTS 신청 
insert into SPORT_APPLY(APPLY_ID, APPLY_NUM , REGISTER_NUM) values('admin01', aply_seq.nextval, 1);
insert into SPORT_APPLY(APPLY_ID, APPLY_NUM , REGISTER_NUM) values('admin02', aply_seq.nextval, 2);
insert into SPORT_APPLY(APPLY_ID, APPLY_NUM , REGISTER_NUM) values('admin03', aply_seq.nextval, 3);






--5.SPORTS 데드라인
insert into SPORT_DEADLINE(REGISTER_ID, APPLY_ID, DEADLINE_NUM, SPORT_NUM)
values('admin01', 'admin03', dead_seq.nextval, 1);

insert into SPORT_DEADLINE(REGISTER_ID, APPLY_ID, DEADLINE_NUM, SPORT_NUM)
values('admin02', 'admin01', dead_seq.nextval, 2);

insert into SPORT_DEADLINE(REGISTER_ID, APPLY_ID, DEADLINE_NUM, SPORT_NUM)
values('admin03', 'admin02', dead_seq.nextval, 3);




--6.멘토 매칭 등록
insert into MENTOR_MATCH values('mr1','user01','축구 가르칩니다1.','축구','상암월드컵경기장1','월요일  오후 6시',30000,10,'축구화는 개인이 준비해오세요1','청춘FC출연','/2021-9-17/bbs202191700000001.png','class1.png','/2021-9-17/bbs202191700000002.png','class2.png','/2021-9-17/bbs202191700000003.png','class3.png');

insert into MENTOR_MATCH values('mr2','user02','축구 가르칩니다2.','축구','상암월드컵경기장2','화요일  오후 6시',40000,11,'축구화는 개인이 준비해오세요2','강원FC출연','/2021-9-17/bbs202191700000004.png','class4.png','/2021-9-17/bbs202191700000005.png','class5.png','/2021-9-17/bbs202191700000006.png','class6.png');

insert into MENTOR_MATCH values('mr3','user03','축구 가르칩니다3.','축구','상암월드컵경기장3','수요일  오후 6시',50000,12,'축구화는 개인이 준비해오세요3','수원FC출연','/2021-9-17/bbs202191700000007.png','class7.png','/2021-9-17/bbs202191700000008.png','class8.png','/2021-9-17/bbs202191700000009.png','class9.png');

insert into MENTOR_MATCH values('mr4','user04','축구 가르칩니다4.','축구','상암월드컵경기장4','목요일  오후 6시',60000,13,'축구화는 개인이 준비해오세요4','대구FC출연','/2021-9-17/bbs202191700000010.png','class10.png','/2021-9-17/bbs202191700000011.png','class11.png','/2021-9-17/bbs202191700000012.png','class12.png');




--7.멘티 매칭 등록 
insert into MENTEE_MATCH values('me1','user01','요가 배웁니다.1','야구','gym01','월요일  오후 1시',20000,'초보입니다1.','/2021-9-17/bbs202191700000025.png','class25.png');
insert into MENTEE_MATCH values('me2','user02','요가 배웁니다.2','야구','gym02','월요일  오후 2시',21000,'초보입니다2.','/2021-9-17/bbs202191700000026.png','class26.png');
insert into MENTEE_MATCH values('me3','user03','요가 배웁니다.3','야구','gym03','월요일  오후 3시',22000,'초보입니다3.','/2021-9-17/bbs202191700000027.png','class27.png');
insert into MENTEE_MATCH values('me4','user04','요가 배웁니다.4','야구','gym04','월요일  오후 4시',23000,'초보입니다4.','/2021-9-17/bbs202191700000028.png','class28.png');






--8.멘토멘티 등록 현황
insert into MATCH_INFO values(1,'user01' ,'me2',1);
insert into MATCH_INFO values(2,'user02' ,'me3',2);
insert into MATCH_INFO values(3,'user03' ,'mr4',3);
insert into MATCH_INFO values(4,'user04' ,'mr1',1);





--9.경매거래 Deal_Auction 
	insert into Deal_Auction values
	(1, '경매제목1', '경매내용1', 'admin01','2021-09-20',5000,1000,15000,0 ,'착불',
	'cj',123214114 , '1main.png' , '2021-09-0712123' , '1two.png', '2021-09071515' , '1three.png' , '2021-090715156',
	'1.four.png','2021-84811');	
	insert into Deal_Auction values
	(2, '경매제목2', '경매내용2', 'admin01','2021-09-20',6000,2000,20000,0 ,'선불',
	'우체국',1234114 , '2main.png' , '2021-09-1231242123' , '2two.png', '2021-44071515' , '2three.png' , '2021-09715156',
	'2.four.png','2021-844211');
	insert into Deal_Auction values
	(3, '경매제목3', '경매내용3', 'admin02','2021-09-20',400,2000,18000,0 ,'착불',
	'편의점',12323114 , '3main.png' , '2021-09-077723' , '3two.png', '2021-090715' , '3three.png' , '2021-090756',
	'3.four.png','2021-8471');
	insert into Deal_Auction values
	(4, '경매제목4', '경매내용4', 'admin02','2021-09-20',5000,1000,15000,0 ,'착불',
	'cj',1232114 , '4main.png' , '2021-09-07772123' , '4two.png', '2021-1071515' , '4three.png' , '2021-095515156',
	'4.four.png','2021-8486611');





	
--10.직거래 Deal_Direcit

	insert into Deal_Direct values
	(1 , '직거래제목1' , '직거래내용1' , 'admin01' , '10000' , '010-9079-1111' , '종로3가역 1번출구' , sysdate ,
	'1main.png' , '2021-09-0712123' , '1two.png', '2021-09071515' , '1three.png' , '2021-090715156',
	'1.four.png','2021-84811');
	insert into Deal_Direct values
	(2 , '직거래제목2' , '직거래내용2' , 'admin01' , '15000' , '010-7779-1811' , '지행역 1번출구' , sysdate ,
	'2main.png' , '2021-09-0412123' , '2two.png', '2021-04471515' , '2three.png' , '2021-050715156',
	'2.four.png','2021-84661');
	insert into Deal_Direct values
	(3 , '직거래제목3' , '직거래내용3' , 'admin02' , '8000' , '010-9559-1111' , '낙원상가' , sysdate ,
	'3main.png' , '2021-79-0712123' , '3two.png', '2021-809071515' , '3three.png' , '2021-09785156',
	'3.four.png','2021-84844411');
	insert into Deal_Direct values
	(4 , '직거래제목4' , '직거래내용4' , 'admin02' , '14500' , '010-9079-1181' , '종로3가역 2번출구' , sysdate ,
	'4main.png' , '2021-09-8712123' , '4two.png', '2021-071515' , '4three.png' , '2021-090156',
	'4.four.png','2021-81166');
	







--11.내 거래 내역 MY_DEAL

	insert into MY_DEAL values
	('admin01' , 1 , 0 , 0 ,1 , 2, 0 , 0 ,0 ,0);









--12.운동 게시판 글
insert into BBS_FR(FR_NO, USER_ID, FR_PASS, FR_CSFC, 
		   FR_SUBJECT, FR_CONTENT, FR_DATE, FR_READCOUNT,
		   FR_FILE, FR_ORIGINAL)
values(1, 'admin01', '1234', '운동방법', '제목', '내용', SYSDATE, 0,
      '/2021_9_17/bbs202191712345678.png', 'tear3.png');
insert into BBS_FR values(2, 'user01', '1234', '운동기록', '제목', '내용입니다.', sysdate, 0,'/2021_9_17/bbs202191787654321.png', 'strawberry.png');
insert into BBS_FR values(3, 'user02', '1234', '운동기록', '제목', '내용', sysdate, 0, '/2021_9_17/bbs202191777654321.png', 'strawberry.png');
insert into BBS_FR values(4, 'user03', '1234', '운동방법', '제목', '내용', sysdate, 0, '/2021_9_17/bbs202191786595583.png', 'icecream.png');








--13.운동 게시판 댓글
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'admin01', '댓글입니다1.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user01', '댓글입니다2.', sysdate, 1);
insert into BBS_FCM
		values(FCM_SEQ.nextval, 'user02', '댓글입니다3.', sysdate, 1);







--14.개인 관리 정보(운동관련)

insert into PERSONAL_MANAGEMENT values(
					1,'user01', '63', SYSDATE, '야구'); 
insert into PERSONAL_MANAGEMENT values(
					2, 'user01', '810', SYSDATE, '헬스'); 
insert into PERSONAL_MANAGEMENT values(
					3, 'user01', '63', SYSDATE, '축구');  



--15.물 섭취량
insert into WATER_INTAKE values(
				1, 'user01', '2', sysdate);
