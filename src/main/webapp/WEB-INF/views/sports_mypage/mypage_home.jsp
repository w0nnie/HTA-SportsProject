<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="m" value="${mypage_info}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  		<meta charset="UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>MyPage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- <link rel="manifest" href="site.webmanifest"> -->
		<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
		<script src="https://unpkg.com/feather-icons"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/weather.css">
		<script src="${pageContext.request.contextPath}/resources/js/weather.js"></script>
</head>

<body>
    
    <!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
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
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
	
    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="${pageContext.request.contextPath}/resources/img/hero/category.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>Infomation</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider Area End-->

    <section class="blog_area section-padding">
            <div class="row">
            	<div class="col-lg-2">
            		<!-- 마이 페이지 좌측 asideLeft 메뉴들 -->
					<jsp:include page="/WEB-INF/views/sport_comm/asideLeft.jsp"/>
                </div>
                <div class="col-lg-10 mb-5 mb-lg-0">
                    <form method="get" name="myinfo">
						<div class="container">
							<p>member Infomation</p>
							<table class="table table-bordered">
							<tr>
							<td>아이디</td><td>${m.USER_ID}</td>
							</tr>
							<tr>
							<td>비밀번호</td><td>${m.USER_PASS}</td>
							</tr>
							<tr>
							<td>이름</td><td>${m.USER_NAME}</td>
							</tr>
							<tr>
							<td>주민번호</td><td>${m.USER_JUMIN}</td>
							</tr>
							<tr>
							<td>휴대폰번호</td><td>${m.USER_MOBILE}</td>
							</tr>
							<tr>
							<td>주소</td><td>${m.USER_ADDRESS}</td>
							</tr>
							<tr>
							<td>이메일</td><td>${m.USER_EMAIL}</td>
							</tr>
							<tr>
							<td>키</td><td>${m.USER_HEIGHT}</td>
							</tr>
							<tr>
							<td>현재 몸무게</td><td>${m.USER_PWEIGHT}</td>
							</tr>
							<tr>
							<td>목표 몸무게</td><td>${m.USER_WWEIGHT}</td>
							</tr>
							<tr>
							<td>BMI</td><td>${m.USER_BMI}</td>
							</tr>
							<tr>
							<td>기초대사량</td><td>${m.USER_RMR}</td>
							</tr>
							<tr>
							<td>선호운동</td><td>${m.USER_PSPORTS}</td>
							</tr>
							</table>
						</div>
					</form>
               </div> 
        </div>
    </section>

	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
  
</body>
</html>