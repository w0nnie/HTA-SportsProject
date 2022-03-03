DROP TABLE WATER_INTAKE cascade constraints purge;
DROP TABLE PERSONAL_MANAGEMENT cascade constraints purge;
DROP TABLE BBS_FCM cascade constraints purge;
DROP TABLE BBS_FR cascade constraints purge;
DROP TABLE Deal_Direct cascade constraints purge;
DROP TABLE MY_DEAL cascade constraints purge;
DROP TABLE Deal_Auction cascade constraints purge;
DROP TABLE MATCH_INFO cascade constraints purge;
DROP TABLE MENTEE_MATCH cascade constraints purge;
DROP TABLE MENTOR_MATCH cascade constraints purge;
DROP TABLE SPORT_DEADLINE cascade constraints purge;
DROP TABLE SPORT_APPLY cascade constraints purge;
DROP TABLE SPORT_REGISTER cascade constraints purge;
DROP TABLE SPORTS CASCADE CONSTRAINTS purge;
DROP TABLE MEMBER_INFO CASCADE CONSTRAINTS purge;

drop sequence reg_seq;
drop sequence aply_seq; 
drop sequence dead_seq;
drop sequence FCM_SEQ;

create sequence reg_seq;
create sequence aply_seq; 
create sequence dead_seq;
create sequence FCM_SEQ;



delete from WATER_INTAKE;
delete from PERSONAL_MANAGEMENT;
delete from BBS_FCM;
delete from BBS_FR;
delete from Deal_Direct;
delete from MY_DEAL;
delete from Deal_Auction;
delete from MATCH_INFO;
delete from MENTEE_MATCH;
delete from MENTOR_MATCH;
delete from SPORT_DEADLINE;
delete from SPORT_APPLY;
delete from SPORT_REGISTER;
delete from SPORTS;
delete from MEMBER_INFO;
