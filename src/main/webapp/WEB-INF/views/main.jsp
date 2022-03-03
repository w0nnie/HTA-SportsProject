<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta charset="UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Total Sports Contents</title>
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
                    <img src="${pageContext.request.contextPath}/resources/image/logo/sports_logo.png" alt="">
                </div>
            </div>
        </div>
    </div>

	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
	
    <main>

        <!-- slider Area Start -->
        <div class="slider-area">
            <!-- Mobile Menu -->
            <div class="slider-active">
                <div class="single-slider slider-height" data-background="${pageContext.request.contextPath}/resources/image/mainSlide/main_slide01.jpg">
                    <div class="container">
                        <div style="height:800px" class="row d-flex align-items-center justify-content-between">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 d-none d-md-block">
                            	<div class="hero__caption">
                                    <span data-animation="fadeInRight" data-delay=".4s">now open!!</span>
                                    <h1 data-animation="fadeInRight" data-delay=".6s">Total Sport<br>Contents</h1>
                                    <p data-animation="fadeInRight" data-delay=".8s">다양한 스포츠 컨텐츠를 제공합니다.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="single-slider slider-height" data-background="${pageContext.request.contextPath}/resources/image/mainSlide/main_slide02.jpg">
                    <div class="container">
                        <div style="height:800px" class="row d-flex align-items-center justify-content-between">
                             <div class="col-xl-5 col-lg-5 col-md-5 col-sm-5 d-none d-md-block">
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-8">
                                <div class="hero__caption">
                                    <span data-animation="fadeInRight" data-delay=".4s">Sports Match</span>
                                    <h1 data-animation="fadeInRight" data-delay=".6s">운동 매칭<br>서비스 제공</h1>
                                    <p data-animation="fadeInRight" data-delay=".8s">다양한 종목/자유로운 매칭</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="single-slider slider-height" data-background="${pageContext.request.contextPath}/resources/image/mainSlide/main_slide03.jpg">
                    <div class="container">
                        <div style="height:800px" class="row d-flex align-items-center justify-content-between">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 d-none d-md-block">
                            	<div class="hero__caption">
                                    <span data-animation="fadeInRight" data-delay=".4s">Sports Mentor/Mentee</span>
                                    <h1 data-animation="fadeInRight" data-delay=".6s">멘토/멘티 <br>서비스 제공</h1>
                                    <p data-animation="fadeInRight" data-delay=".8s">사용자 중심 멘티/멘토 요청과 수락 </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="single-slider slider-height" data-background="${pageContext.request.contextPath}/resources/image/mainSlide/main_slide04.jpg">
                    <div class="container">
                        <div style="height:800px" class="row d-flex align-items-center justify-content-between">
                             <div class="col-xl-5 col-lg-5 col-md-5 col-sm-5 d-none d-md-block">
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-8">
                                <div class="hero__caption">
                                    <span data-animation="fadeInRight" data-delay=".4s">Sports Goods Trading</span>
                                    <h1 data-animation="fadeInRight" data-delay=".6s">운동 물품<br>거래 서비스</h1>
                                    <p data-animation="fadeInRight" data-delay=".8s">중고거래과 경매거래 제공</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="single-slider slider-height" data-background="${pageContext.request.contextPath}/resources/image/mainSlide/main_slide05.jpg">
                    <div class="container">
                        <div style="height:800px" class="row d-flex align-items-center justify-content-between">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 d-none d-md-block">
                            	<div class="hero__caption">
                                    <span data-animation="fadeInRight" data-delay=".4s">Sports BBS</span>
                                    <h1 data-animation="fadeInRight" data-delay=".6s">자유게시판<br>서비스 제공</h1>
                                    <p data-animation="fadeInRight" data-delay=".8s">다양한 카테고리의 의견 공유 </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- slider Area End-->
        
        <!-- 날씨/미세먼지 Area Start-->
        <section class="category-area section-padding30">
            <div class="container-fluid">
                <!-- Section Tittle -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center mb-85">
                            <h2>날씨 / 미세먼지</h2>
                        </div>
                    </div>
                </div>
                 <!-- Section weather/dust start -->
                <div class="row">
                	<!-- Section weather ui start -->
                    <div class="col-xl-6 col-lg-6" style="text-align:center">
						<div class="container w-container" style="margin-right: 30px">
						  <div class="weather-side">
						    <div class="weather-gradient"></div>
						    <div class="date-container">
						      <h1 style='color:white; font-family: "Poppins", sans-serif;' class="date-dayname">월요일</h1>
						      <br>
						      <span class="date-day">2021년 9월 27일</span>
						      <i class="fas fa-map-marker-alt"></i>
						      <span class="location">날씨검색완료</span>
						    </div>
						    <div id="now-weather" class="weather-container">
						      <img style="width:90px; height:90px;" src="${pageContext.request.contextPath}/resources/image/weather/sun.png" alt="">
						      <!-- <i class="weather-icon" data-feather="sun"></i> -->
						      <h1 style='color:white; font-family: "Poppins", sans-serif;' class="weather-temp">18°C</h1>
						      <h3 class="weather-desc">맑음</h3>
						    </div>
						  </div>
						  <div class="info-side">
						    <div class="today-info-container">
						      <div id="now-detail" class="today-info">
						        <div class="precipitation"> <span class="title">강수확률</span><span class="value">0 %</span>
						          <div class="clear"></div>
						        </div>
						        <div class="humidity"> <span class="title">습도</span><span class="value">34 %</span>
						          <div class="clear"></div>
						        </div>
						        <div class="wind"> <span class="title">풍속</span><span class="value">0 km/h</span>
						          <div class="clear"></div>
						        </div>
						      </div>
						    </div>
						    <div class="week-container">
						      <ul id="hour_weather" class="week-list">
						        <li class="active">
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/weather/cloud.png" alt=""> 
						        	</span>
						        	<%-- style='background-image: url("${pageContext.request.contextPath}/resources/image/weather/sun.png")' --%>
						        	<%-- <img style="width:45px; height:45px;" src="${pageContext.request.contextPath}/resources/image/weather/sun.png" alt=""> 
						        	 --%><!-- <i class="day-icon" data-feather="sun"></i> -->
						        	<span class="day-name">화</span>
						        	<span class="day-temp">29°C</span>
						        </li>
						        <li>
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/weather/rain.png" alt=""> 
						        	</span>
						        	<span class="day-name">수</span>
						        	<span class="day-temp">21°C</span>
						        </li>
						        <li>
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/weather/snow.png" alt=""> 
						        	</span>
						        	<span class="day-name">목</span>
						        	<span class="day-temp">08°C</span>
						        </li>
						        <li>
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/weather/thunder.png" alt=""> 
						        	</span>
						        	<span class="day-name">금</span>
						        	<span class="day-temp">19°C</span>
						        </li>
						        <div class="clear"></div>
						      </ul>
						    </div>
						    <div class="location-container">
						      <button class="location-button"> 
						      <i class="fas fa-map-marker-alt"></i>
						      <span>기상 정보 새로고침</span></button>
						    </div>
						  </div>
						</div>
                    </div>
                    <!-- Section weather ui end -->
                    
                	<!-- Section dust ui start -->
                 <div class="col-xl-6 col-lg-6" style="text-align:center">
						<div class="container w-container" style="margin-left: 30px">
						  <div class="weather-side">
						    <div class="weather-gradient"></div>
						    <div class="date-container">
						      <h1 style='color:white; font-family: "Poppins", sans-serif;' class="date-dayname">월요일</h1>
						      <br>
						      <span class="date-day">2021년 9월 27일</span>
						      <i class="fas fa-map-marker-alt"></i>
						      <span class="location">대기검색완료</span>
						    </div>
						    <div id="now-air-condition" class="weather-container">
						      <img style="width:90px; height:90px;" src="${pageContext.request.contextPath}/resources/image/dust/good.png" alt="">
						      <!-- <i class="weather-icon" data-feather="sun"></i> -->
						      <h1 style='color:white; font-family: "Poppins", sans-serif;' class="weather-temp">좋음</h1>
						      <h3 class="weather-desc">최고입니다.</h3>
						    </div>
						  </div>
						  <div class="info-side">
						    <div class="today-info-container">
						      <div id="now-air" class="today-info">
						        <div class="precipitation"> <span class="title">미세먼지</span><span class="value">0uM</span>
						          <div class="clear"></div>
						        </div>
						        <div class="humidity"> <span class="title">초미세먼지</span><span class="value">34uM</span>
						          <div class="clear"></div>
						        </div>
						        <div class="wind"> <span class="title">오존</span><span class="value">0 mm</span>
						          <div class="clear"></div>
						        </div>
						      </div>
						    </div>
						    <div class="week-container">
						      <ul id="hour_air-condition" class="week-list">
						        <li class="active">
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/dust/good.png" alt=""> 
						        	</span>
						        	<%-- style='background-image: url("${pageContext.request.contextPath}/resources/image/weather/sun.png")' --%>
						        	<%-- <img style="width:45px; height:45px;" src="${pageContext.request.contextPath}/resources/image/weather/sun.png" alt=""> 
						        	 --%><!-- <i class="day-icon" data-feather="sun"></i> -->
						        	<span class="day-name">오늘</span>
						        	<span class="day-temp">29㎛</span>
						        </li>
						        <li>
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/dust/worst.png" alt=""> 
						        	</span>
						        	<span class="day-name">아침</span>
						        	<span class="day-temp">21㎛</span>
						        </li>
						        <li>
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/dust/normal.png" alt=""> 
						        	</span>
						        	<span class="day-name">점심</span>
						        	<span class="day-temp">08㎛</span>
						        </li>
						        <li>
						        	<span class="day-icon">
						        		<img style="width:30px; height:30px;" src="${pageContext.request.contextPath}/resources/image/dust/bad.png" alt=""> 
						        	</span>
						        	<span class="day-name">저녁</span>
						        	<span class="day-temp">19㎛</span>
						        </li>
						        <div class="clear"></div>
						      </ul>
						    </div>
						    <div class="location-container">
						      <button class="location-button"> 
						      <i class="fas fa-map-marker-alt"></i>
						      <span>기상 정보 새로고침</span></button>
						    </div>
						  </div>
						</div>
                    </div>
                    <!-- Section dust ui end -->
                </div>
                <!-- Section weather/dust end -->
            </div>
        </section>
        <!-- 날씨/미세먼지 Area End-->

        <!-- 추천 운동 Area Start-->
        <section class="category-area">
            <div class="container-fluid">
                <!-- Section Tittle -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center mb-85">
                            <h2>오늘의 추천 운동</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="recomm_img col-xl-4 col-lg-6">
                    	<h2 style="text-align: center;">복싱</h2>
                        <div class="single-category mb-30">
                            <div class="category-img text-center">
                                <img class="rounded-circle" style="width: 430px; height:430px" src="${pageContext.request.contextPath}/resources/image/recomm_sports/boxing.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="recomm_img col-xl-4 col-lg-6">
                    	<h2 style="text-align: center;">사이클</h2>
                        <div class="single-category mb-30">
                            <div class="category-img text-center">
                                <img class="rounded-circle" style="width: 430px; height:430px"  src="${pageContext.request.contextPath}/resources/image/recomm_sports/cycle.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="recomm_img col-xl-4 col-lg-6">
                   		<h2 style="text-align: center;">요가</h2>
                        <div class="single-category mb-30">
                            <div class="category-img text-center">
                                <img class="rounded-circle" style="width: 430px; height:430px"  src="${pageContext.request.contextPath}/resources/image/recomm_sports/yoga.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- 추천 운동 Area End-->
        
        <!-- Shop Method Start-->
        <div class="shop-method-area section-padding30">
            <div class="container">
                <div class="row d-flex justify-content-between">
                    <div class="col-xl-3 col-lg-3 col-md-6">
                        <div class="single-method mb-40">
                            <i class="ti-package"></i>
                            <h6>다양한 운동 컨텐츠</h6>
                            <p>운동을 위한 각종 매칭 시스템과 거래 및 게시판 서비스를 제공하여 사용자의 접속률 증가</p>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 col-md-6">
                        <div class="single-method mb-40">
                            <i class="ti-user"></i>
                            <h6>사용자 중심의 UI</h6>
                            <p>심플한 메뉴 구성과 화면 배치를 통해 사용자의 접근성 증가</p>
                        </div>
                    </div> 
                    <div class="col-xl-3 col-lg-3 col-md-6">
                        <div class="single-method mb-40">
                            <i class="ti-reload"></i>
                            <h6>주기적인 모니터링 및 피드백</h6>
                            <p>주기적인 모니터링을 통한 부정적인 게시글/등록글 차단 및 사용자 피드백 제공</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Shop Method End-->
        
        <!-- Latest Offers Start -->
        <div class="latest-wrapper lf-padding">
            <div class="latest-area latest-height d-flex align-items-center" data-background="${pageContext.request.contextPath}/resources/image/letter/latest-offer.png">
                <div class="container">
                    <div class="row d-flex align-items-center">
                        <div class="col-xl-5 col-lg-5 col-md-6 offset-xl-1 offset-lg-1">
                            <div class="latest-caption">
                                <h2>우리의 최신 정보를<br> 수신하기 위해</h2>
                                <p>메일로 구독을 신청하세요!!</p>
                            </div>
                        </div>
                         <div class="col-xl-5 col-lg-5 col-md-6 ">
                            <div class="latest-subscribe">
                                <form action="#">
                                    <input type="email" placeholder="Your email here">
                                    <button>Subscript Now</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Latest Offers End -->
       
    </main>

	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/js/main/main.js"></script>
    </body>
</html>