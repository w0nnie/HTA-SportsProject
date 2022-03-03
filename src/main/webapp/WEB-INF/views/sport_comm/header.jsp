<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- CSS here -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flaticon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/slicknav.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontawesome-all.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/themify-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/slick.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- Preloader Start -->
<header>
    <!-- Header Start -->
   <div class="header-area">
        <div class="main-header ">
        <div class="py-1 bg-primary">
		  	<div class="container">
		  		<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
		   		<div class="col-lg-12 d-block">
		    		<div class="row d-flex">
		    			<div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
						    <span class="text"> 070-8240-3211 </span>
					    </div>
					    <div>
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
						    <span class="text">edu@jhta.co.kr</span>
					    </div>
					    <div class="col-md-5 pr-4 topper align-items-center text-lg-right">
						    <span class="text">Sports &amp; Healthy</span>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
		</div>   
           <div class="header-bottom  header-sticky">
                <div class="container-fluid">
                    <div class="row align-items-center">
                        <!-- Logo -->
                        <div class="col-xl-1 col-lg-1 col-md-1 col-sm-3">
                            <div class="logo">
                              <a href="${pageContext.request.contextPath}/main/mainPage"><img style="width:200px; height:85px;" src="${pageContext.request.contextPath}/resources/image/logo/sports_logo.png" alt=""></a>
                            </div>
                        </div>
                        <div class="col-xl-7 col-lg-8 col-md-7 col-sm-5">
                            <!-- Main-menu -->
                            <div class="main-menu f-right d-none d-lg-block">
                                <nav>                                                
                                    <ul id="navigation">       
                                        <li><a href="${pageContext.request.contextPath}/main/mainPage">홈화면</a></li>
                                        <li><a href="${pageContext.request.contextPath}/match/mainPage">운동 파트너 매칭</a></li>
                                        <li><a href="#">운동 멘토/멘티 매칭</a>
                                            <ul class="submenu">
                                                 <li><a href="${pageContext.request.contextPath}/mmatch/mentorPage"> 멘토 매칭</a></li>
                                                 <li><a href="${pageContext.request.contextPath}/mmatch/menteePage"> 멘티 매칭</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="${pageContext.request.contextPath}/DealA/list">운동 거래</a></li>
                                        <li><a href="${pageContext.request.contextPath}/BBS_FR/list">운동 자유 게시판</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div> 
                        <div class="col-xl-4 col-lg-3 col-md-3 col-sm-3 fix-card">
                            <ul class="header-right f-right d-none d-lg-block d-flex justify-content-between">
                                <li>
                                <c:if test="${!empty USER_ID}">
                                    <div>
                                       <i class="fas fa-user" style="font-size: 13px; margin-top:17px; margin-right:5px">&nbsp;${USER_ID}&nbsp;님&nbsp; 환영합니다.</i>
                                    </div>
                                </c:if>
                                </li>
                                <c:if test="${empty USER_ID}">
						              <li class="d-none d-lg-block"> <a href="${pageContext.request.contextPath}/member/login" class="btn header-btn">로그인</a></li>
                                      <li class="d-none d-lg-block"> <a href="${pageContext.request.contextPath}/member/join" class="btn header-btn">회원가입</a></li>
						        </c:if>
						        <c:if test="${!empty USER_ID}">
						        	  <li class="d-none d-lg-block"> <a href="${pageContext.request.contextPath}/mypage/main" class="btn header-btn">마이페이지</a></li>
						              <li class="d-none d-lg-block"> <a href="${pageContext.request.contextPath}/member/logout" class="btn header-btn">로그아웃</a></li>
						        </c:if>
                            </ul>
                        </div>
                        <!-- Mobile Menu -->
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
           </div>
        </div>
   </div>
    <!-- Header End -->
</header>