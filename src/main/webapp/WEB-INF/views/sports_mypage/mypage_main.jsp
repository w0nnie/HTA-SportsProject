<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>MyPage</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<script src="https://unpkg.com/feather-icons"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/weather.css">
<script src="${pageContext.request.contextPath}/resources/js/weather.js"></script>
<script src = "http://code.jquery.com/jquery-latest.js"></script>
</head>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:400,100,900);

html,
body {
  -moz-box-sizing: border-box;
       box-sizing: border-box;
  height: 100%;
  width: 100%; 
  background: #FFF;
  font-family: 'Roboto', sans-serif;
  font-weight: 400;
}
 
.wrapper {
  display: table;
  height: 100%;
  width: 100%;
}

.container-fostrap {
  display: table-cell;
  padding: 1em;
  text-align: center;
  vertical-align: middle;
}
.fostrap-logo {
  width: 100px;
  margin-bottom:15px
}
h1.heading {
  color: #fff;
  font-size: 1.15em;
  font-weight: 900;
  margin: 0 0 0.5em;
  color: #505050;
}
@media (min-width: 450px) {
  h1.heading {
    font-size: 3.55em;
  }
}
@media (min-width: 760px) {
  h1.heading {
    font-size: 3.05em;
  }
}
@media (min-width: 900px) {
  h1.heading {
    font-size: 3.25em;
    margin: 0 0 0.3em;
  }
} 
.card {
  display: block; 
    margin-bottom: 20px;
    line-height: 1.42857143;
    background-color: #fff;
    border-radius: 2px;
    box-shadow: 0 2px 5px 0 rgba(0,0,0,0.16),0 2px 10px 0 rgba(0,0,0,0.12); 
    transition: box-shadow .25s; 
}
.card:hover {
  box-shadow: 0 8px 17px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
}
.img-card {
  width: 100%;
  height:200px;
  border-top-left-radius:2px;
  border-top-right-radius:2px;
  display:block;
    overflow: hidden;
}
.img-card img{
  width: 100%;
  height: 200px;
  object-fit:cover; 
  transition: all .25s ease;
} 
.card-content {
  padding:15px;
  text-align:left;
}
.card-title {
  margin-top:0px;
  font-weight: 700;
  font-size: 1.65em;
}
.card-title a {
  color: #000;
  text-decoration: none !important;
}
.card-read-more {
  border-top: 1px solid #D4D4D4;
}
.card-read-more a {
  text-decoration: none !important;
  padding:10px;
  font-weight:600;
  text-transform: uppercase
}
/* #cardpadd{
	padding-top:150px
} */
</style>
<body>

	<!-- Preloader Start -->
	<div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="assets/img/logo/logo.png" alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Preloader Start-->

	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp" />

	<!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="single-slider slider-height2 d-flex align-items-center"
			data-background="${pageContext.request.contextPath}/resources/img/my_main_backimg.png">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2>Mypage</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider Area End-->
	<script>
	$(function(){
		var id = ${sessionid}
		console.log(id)
	})
	
	</script>

	<section class="blog_area section-padding">
	<h1 style="text-align:center">${sessionid}님 안녕 하세요</h1>
	<hr>
		<div class="row">
		
			<div class="col-lg-2">
				<!-- 마이 페이지 좌측 asideLeft 메뉴들 -->
				<jsp:include page="/WEB-INF/views/sport_comm/asideLeft.jsp" />
			</div>
			<div class="col-lg-9">
				<div class="row">
					<div class="col-lg-4" id="cardpadd">
						<div class="card">
							<a class="img-card"
								href="${pageContext.request.contextPath}/member/update">
								<img
								src="${pageContext.request.contextPath}/resources/img/my_infomodi.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										 href="${pageContext.request.contextPath}/member/update">
										개인 정보 수정</a>
								</h4>
								<p class="">개인 정보 수정을할 수 있는 메뉴 입니다.</p>
							</div>
							
						</div>
					</div>
					<div class="col-lg-4" id="cardpadd">
						<div class="card">
							<a class="img-card"
								 href="${pageContext.request.contextPath}/pm/doughnut" >
								<img
								src="${pageContext.request.contextPath}/resources/img/my_water.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										 href="${pageContext.request.contextPath}/pm/doughnut">
										당일 운동량 / 물 섭취량 </a>
								</h4>
								<p class="">당일 총 운동량과 총 물 섭취량을 기록하세요! </p>
							</div>
						</div>
					</div>
					<div class="col-lg-4" id="cardpadd">
						<div class="card">
							<a class="img-card"
								 href="${pageContext.request.contextPath}/water/calendar" >
								<img
								src="${pageContext.request.contextPath}/resources/img/my_calendar.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										href="${pageContext.request.contextPath}/water/calendar">
										캘린더 </a>
								</h4>
								<p class="">기록된 운동량과 물 섭취량을 달력으로 확인하세요</p>
							</div>
							
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="card">
							<a class="img-card"
								href="${pageContext.request.contextPath}/member/info" >
								<img
								src="${pageContext.request.contextPath}/resources/img/my_myinfo.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										href="${pageContext.request.contextPath}/member/info">
										내 정보  </a>
								</h4>
								<p class="">내 정보를 확인하고 싶을때 오세요</p>
							</div>
							
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<a class="img-card"
								href="${pageContext.request.contextPath}/Mydeal/main">
								<img
								src="${pageContext.request.contextPath}/resources/img/my_mydeal2.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										href="${pageContext.request.contextPath}/Mydeal/main">
										내 거래 내역 </a>
								</h4>
								<p class="">나의 운동 거래 관련 내용은 이쪽에서 확인 해주세요</p>
							</div>
							
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<a class="img-card"
								href="${pageContext.request.contextPath}/mypage/mymatching">
								<img
								src="${pageContext.request.contextPath}/resources/img/my_mymatching.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										href="${pageContext.request.contextPath}/mypage/mymatching">
										내 매칭 정보 </a>
								</h4>
								<p class="">매칭에 대한 나의 이력을 확인할 수 있습니다.</p>
							</div>
							
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="card">
							<a class="img-card"
								 href="${pageContext.request.contextPath}/mypage/mmwriteList">
								<img
								src="${pageContext.request.contextPath}/resources/img/my_mymontor.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										href="${pageContext.request.contextPath}/mypage/mmwriteList">
										내 작성 멘토멘티 </a>
								</h4>
								<p class="">내가 작성한 멘토/멘티 작성 목록을 확인할 수 있습니다.</p>
							</div>
							
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<a class="img-card"
								href="${pageContext.request.contextPath}/mypage/mmApplyList">
								<img
								src="${pageContext.request.contextPath}/resources/img/my_mentorapply.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										href="${pageContext.request.contextPath}/mypage/mmApplyList">
										멘티/멘토 신청 현황 </a>
								</h4>
								<p class="">멘티/멘토 신청 현황을 확인 할 수 있습니다.</p>
							</div>
							
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<a class="img-card"
								 href="${pageContext.request.contextPath}/mypage/mmReqList">
								<img
								src="${pageContext.request.contextPath}/resources/img/my_mentorrequest.png" />
							</a>
							<div class="card-content">
								<h4 class="card-title">
									<a
										 href="${pageContext.request.contextPath}/mypage/mmReqList">
										멘티/멘토 요청 현황  </a>
								</h4>
								<p class="">멘티/멘토 요청 현황을 확인할 수 있습니다.</p>
							</div>
							
						</div>
					</div>
				</div>				
			</div>
		</div>

	</section>

	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp" />

</body>
</html>