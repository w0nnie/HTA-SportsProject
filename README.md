HTA-SportsProject


# 프로젝트 소개

- 코로나 장기화로 인한 운동 부족이 비만을 야기하기 때문에 비만 방지 운동에 초점을 맞춰 운동 매칭, 운동 거래, 운동 멘토/멘티, 운동 자유게시판, 운동 개인 기록등의 다양한 니즈를 충족 할수 있는 종합 운동 사이트를 구현하였습니다.

[권진원(파이널프로젝트).pdf](https://github.com/w0nnie/HTA-SportsProject/files/9117698/default.pdf)

## 개요

- 명칭 : SportsProject
- 개발 인원 : 5명
- 개발 기간 : 2021.09.03 ~ 2021. 10.20
- 담당 기능 : 운동 파트너 매칭, 마이페이지(내 파트너 매칭내역)
- 개발 언어 : java, jsp, javaScript, jQuery, jstl, Ajax, myBatis, spring
- 개발 환경 : sts3
- 데이터베이스 : oracle
- 형상관리 툴 : git
- 간단 소개 : 건강을 위한 운동 종합 커뮤니티 사이트


# 화면 설계

## 메인 화면

![메인화면](https://user-images.githubusercontent.com/87374274/179146922-e0cc183e-ef08-43e8-b9f3-f2313b58432e.PNG)

1. 배너 클릭시 해당 스포츠 별로 게시판 조회 
2. 매칭조회, 매칭등록 조회
3. 세션ID와 등록 ID 비교
4. 지역/세부지역/날짜/인원/실력 별로 검색이 가능 다중 select문을 이용해 구현


## 조회내역 모달

![조회내역클릭시모달](https://user-images.githubusercontent.com/87374274/179147001-ec58b866-8226-4aa7-a88b-36dfad0fd4a4.PNG)

1. 조회 내역 정보를 담은 모달


## 내 매칭내역

![내매칭내역](https://user-images.githubusercontent.com/87374274/179147149-217c7ed2-07d7-4e4d-86ec-6a726eba00a7.PNG)

1. 내가 등록한 매칭 현재 상태
2. 내가 신청한 매칭의 현재 상태
3. 매칭이 성사되어 마감된 매칭의 상태
4. 내가 등록한 매칭의 삭제 (단, 신청이 들어온경우 삭제 불가능)


## 메일 기능

![매일](https://user-images.githubusercontent.com/87374274/179147402-4d5c4aa6-dcd0-4704-b5a4-bc28443818ee.PNG)

1. smtp를 이용해 등록자, 신청자의 정보를 조회해 전화번호 제공


## 사이트 기능구조도

![사이트기능구조도](https://user-images.githubusercontent.com/87374274/179147620-9a70b0ba-27f0-4caf-99a1-d246ca6a61fd.PNG)


## 테이블 정의서

![테이블정의서](https://user-images.githubusercontent.com/87374274/179147574-a1f78f07-c971-4dc4-b045-649ded87c663.PNG)


## 클레스 다이어그램

![클래스다이어그램](https://user-images.githubusercontent.com/87374274/179147512-ff3984e5-5b46-42fa-9d76-aa91e3c158f8.PNG)
