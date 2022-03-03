<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>경매거래 메인</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico">

<!-- CSS here -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/flaticon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/slicknav.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/animate.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/fontawesome-all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/slick.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/nice-select.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<script src = "http://code.jquery.com/jquery-latest.js"></script>

</head>
<style>
#paging {
	color: black;
}

.pagination {
	position: absolute;
	left: 44%;
}

.pagination a {
	color: black;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination

 

a


:hover


:not

 

(
.active

 

)
{
background-color


:

 

#ddd


;
}
#paging {
	text-align: center;
	margin-top: 0
}

.timeback {
	width: 100%;
	height: 30px;
	background-color: #556069;
	color: white;
	border: 1px solid white;
}



.discount2 {
	color: red;
}
/** Custom Select **/
.custom-select-wrapper {
  position: relative;
  display: inline-block;
  user-select: none;
}
  .custom-select-wrapper select {
    display: none;
  }
  .custom-select {
    position: relative;
    display: inline-block;
  }
    .custom-select-trigger {
      position: relative;
      display: block;
      width: 130px;
      padding: 0 84px 0 22px;
      font-size: 22px;
      font-weight: 300;
      color: #fff;
      line-height: 60px;
      background: #5c9cd8;
      border-radius: 4px;
      cursor: pointer;
    }
      .custom-select-trigger:after {
        position: absolute;
        display: block;
        content: '';
        width: 10px; height: 10px;
        top: 50%; right: 25px;
        margin-top: -3px;
        border-bottom: 1px solid #fff;
        border-right: 1px solid #fff;
        transform: rotate(45deg) translateY(-50%);
        transition: all .4s ease-in-out;
        transform-origin: 50% 0;
      }
      .custom-select.opened .custom-select-trigger:after {
        margin-top: 3px;
        transform: rotate(-135deg) translateY(-50%);
      }
  .custom-options {
    position: absolute;
    display: block;
    top: 100%; left: 0; right: 0;
    min-width: 100%;
    margin: 15px 0;
    border: 1px solid #b5b5b5;
    border-radius: 4px;
    box-sizing: border-box;
    box-shadow: 0 2px 1px rgba(0,0,0,.07);
    background: #fff;
    transition: all .4s ease-in-out;
    
    opacity: 0;
    visibility: hidden;
    pointer-events: none;
    transform: translateY(-15px);
  }
  .custom-select.opened .custom-options {
    opacity: 1;
    visibility: visible;
    pointer-events: all;
    transform: translateY(0);
  }
    .custom-options:before {
      position: absolute;
      display: block;
      content: '';
      bottom: 100%; right: 25px;
      width: 7px; height: 7px;
      margin-bottom: -4px;
      border-top: 1px solid #b5b5b5;
      border-left: 1px solid #b5b5b5;
      background: #fff;
      transform: rotate(45deg);
      transition: all .4s ease-in-out;
    }
    .option-hover:before {
      background: #f9f9f9;
    }
    .custom-option {
      position: relative;
      display: block;
      padding: 0 22px;
      border-bottom: 1px solid #b5b5b5;
      font-size: 18px;
      font-weight: 600;
      color: #b5b5b5;
      line-height: 47px;
      cursor: pointer;
      transition: all .4s ease-in-out;
    }
    .custom-option:first-of-type {
      border-radius: 4px 4px 0 0;
    }
    .custom-option:last-of-type {
      border-bottom: 0;
      border-radius: 0 0 4px 4px;
    }
    .custom-option:hover,
    .custom-option.selection {
      background: #f9f9f9;
    }
</style>
<body>

	<!-- Preloader Start -->
	<div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img
						src="${pageContext.request.contextPath}/resources/image/logo/sports_logo.png"
						alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Preloader Start -->

	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp" />

	<!-- Preloader Start -->
	<main> <!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="single-slider slider-height2 d-flex align-items-center"
			data-background="${pageContext.request.contextPath}/resources/img/dealimg.png">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2  style = "font-family :'나눔고딕'">운동물품 거래</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider Area End--> <!-- Latest Products Start -->
	<section class="latest-product-area latest-padding">
		<div class="container">
			<div class="row product-btn d-flex justify-content-between">
				<div class="properties__button">
					<!--Nav Button  -->
					<nav>
						<div class="nav nav-tabs" id="nav-tab" role="tablist">
							<a class="nav-item nav-link active" id="nav-home-tab"
								href="${pageContext.request.contextPath}/DealA/list">경매 거래</a> <a
								class="nav-item nav-link" id="nav-profile-tab"
								href="${pageContext.request.contextPath}/DealD/list">직거래</a>

						</div>
					</nav>
					<!--End Nav Button  -->
				</div>
				<div class="select-this d-flex">
					
					<form action="#">
					<b>나의 경매포인트 : <fmt:formatNumber value="${nowpoint}" pattern="#,###"/>원 </b>
						<div class="select-itms">
							<div class="center">
							
							<select name="sources" id="view" 
							class="custom-select sources"
								placeholder="Source Type" name="view">
								<c:if test="${view2 == 1 }">
								<option value="1">최신순</option>
								<option value="2">정확순</option>
								<option value="3">입찰순</option>
								<option value="4">시작가순</option>
								<option value="5">현재가순</option>
								</c:if>
								<c:if test="${view2 == 2 }">
								<option value="1">최신순</option>
								<option value="2" selected>정확순</option>
								<option value="3">입찰순</option>
								<option value="4">시작가순</option>
								<option value="5">현재가순</option>
								</c:if>
								<c:if test="${view2 == 3 }">
								<option value="1">최신순</option>
								<option value="2">정확순</option>
								<option value="3" selected>입찰순</option>
								<option value="4">시작가순</option>
								<option value="5">현재가순</option>
								</c:if>
								<c:if test="${view2 == 4 }">
								<option value="1">최신순</option>
								<option value="2">정확순</option>
								<option value="3">입찰순</option>
								<option value="4" selected>시작가순</option>
								<option value="5">현재가순</option>
								</c:if>
								<c:if test="${view2 == 5 }">
								<option value="1">최신순</option>
								<option value="2">정확순</option>
								<option value="3">입찰순</option>
								<option value="4">시작가순</option>
								<option value="5" selected>현재가순</option>
								</c:if>
								
							</select>
						</div>
						</div>
					</form>
				</div>
			</div>
			<!-- Nav Card -->

			<div class="tab-content" id="nav-tabContent">
				<!-- card one -->
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<div class="row">
					<c:forEach var="b" items="${Auction}">
						<div class="col-xl-4 col-lg-4 col-md-6">
							<div class="single-product mb-60">
								
								
								<div id="timeback" class="timeback">
									 
								</div>
						
								<div class="product-img">
									<img
										id="imgimg"
										src="${pageContext.request.contextPath}/resources/dealupload1/${b.SAVE_AUC_MAINFILE}"
										alt=""
										style="width: 355px; height: 300px;">

								</div>
								<div class="product-caption">

									<h4>
										<span style="float:left">No.${b.AUC_NUMBER}</span>
										
										<c:choose>
											<c:when test="${b.SAVE_AUC_MAINFILE eq 'buynow.jpg'}">
												<b style="font-size:15px">	${b.AUC_SUBJECT}</b><b style="color:red;font-size:15px">(판매완료)</b>
											</c:when>
											<c:when test="${b.SAVE_AUC_MAINFILE eq 'soldout.jpg'}">
												<b style="font-size:15px">	${b.AUC_SUBJECT}</b><b style="color:red;font-size:15px">(판매완료)</b>
											</c:when>
											<c:otherwise>
											<a href="${pageContext.request.contextPath}
										/DealA/detail?num=${b.AUC_NUMBER}"><b>${b.AUC_SUBJECT}</b></a>
											</c:otherwise>
										</c:choose>
										
										
										
									
										
									</h4>
									<div class="price">
										<table class="table">
											<tr>
												<th>올린사람</th>
												<td>${b.USER_ID}</td>
												
											</tr>
											<tr>
												<th>시작가</th>
												<td>
												<fmt:formatNumber value="${b.AUC_SPRICE}" pattern="#,###"/>원

												</td>
												
											</tr>
											<tr>
												<th class="discount2">현재가</th>
												<td class="discount2">
												<fmt:formatNumber value="${b.AUC_PRICE}" pattern="#,###"/>원
												</td>
											</tr>
											<tr>
												<th>입찰횟수</th>
												<td>${b.AUC_COUNT}회</td>
											</tr>
											<tr>
												<th>올린시간</th>
												<td>${b.AUC_NOWDATE}</td>
											</tr>

										</table>

									</div>
								</div>
							</div>
						</div>
						<!-- 남은 시간 구하는 스크립트문 -->
						<script>
						 $(function() {
																
							//경매기간 
						 	var aucdate = '${b.AUC_DATE}';			
						 	/*경매기간 년도,월,일,시간,초 로 나눔 */
						 	var dateyear = aucdate.substring(0,4)	
						 	var datemonth = aucdate.substring(5,7)
						 	var dateday = aucdate.substring(8,10)
						 	var datehour = aucdate.substring(11,13)
						 	var datemin = aucdate.substring(14,16)
						 	/*****************************/

						 	//글번호
						 	var number = ${b.AUC_NUMBER}
						 	//글 이미지 파일 저장용 이름
						 	var img = "${b.SAVE_AUC_MAINFILE}"
						 	
						 	
						 	/* 남은시간 부분 과 이미지 부분 태그 id를 동적으로 주기위해 
						 		해당 글의 정보를 변수로 선언하여 그 변수를 아이디로 바꿔줌
						 	*/
						 	var timeid = "timeback" + number;
						 	var imgid = "imgimg" + number;	 	
						 	$("#timeback").attr("id",timeid)
						 	$("#imgimg").attr("id" , imgid)
						 	
							//남은 시간 들어갈태그 동적변수로 id 기입
						 	var watch = '<span class="fas fa-clock" /> <span id="' + number + '"></span>'
						 	document.getElementById(timeid).innerHTML = watch;
						 	
						 	//남은시간 구하기 (현재시간 - 경매기간)
							var endTime = new Date(dateyear,datemonth-1, dateday, datehour, datemin, 0) / 1000;       					           
						 	
						 	//남은 시간 1초마다 갱신
							function setClock() {
								var elapsed = new Date() / 1000;
								var totalTime = endTime - elapsed;
								var hr = parseInt(totalTime / 3600)
								var min = parseInt(totalTime / 60) % 60;
								var sec = parseInt(totalTime % 60, 10);
								
								//남은시간 변수로 선언 후 innerHTML로 삽입
								var result = "남은시간 " +  hr + "시 " + min + "분 " + sec
										+ "초";
								eval("var count"+number+"=" + "'" + result + "'");
	
								document.getElementById(number).innerHTML = result;
								//1초마다 setClock 함수 실행 
								setTimeout(setClock, 1000);
								
								//남은 시간이 0시0분0초 보다 감소하면 위 함수 종료 후 시간 기입되는 태그 삭제
								//함수 종료
								if(hr <=0 && min <=0 && sec <=0 ){
									
									clearTimeout(setClock);
									$("#timeid").remove();
									$(eval("'#timeback" +number + "'")).remove();
					
								}
								//남은 시간이 0시0분0초가 되면 
								//글번호 값을 갖고 timeout 으로 이동 
								if(hr == 0 && min ==0 && sec ==0){
									location.href="timeout?num=" + number
									
								}
								//남은 시간이 0시0분0초가 되면 
								//이미지 판매완료 이미지로 바뀜 
								var imgfile = "${b.SAVE_AUC_MAINFILE}"
								if(imgfile == 'buynow.jpg'){
									$(eval("'#timeback" +number + "'")).remove();
								}
								
							}
						 	//함수 실행
							setClock();
							
						 })
							
						</script>
					</c:forEach>



					</div>
					<hr>
					<div class="sungjinS">
						<div class="header-bottom ">
							<ul
								class="header-right f-right d-none d-lg-block d-flex justify-content-between">
								<li class="d-none d-xl-block" id="sd-none">
									<div class="form-box f-right ">
										<form method="get" action="list" name="form1" id="form1">
											<input type="text" name="search" id="search"
												placeholder="Search products">

											<div class="search-icon">
												<i onclick="SubmitForm()" class="fas fa-search special-tag"
													id="searchB"></i>
											</div>
										</form>
									</div>
								</li>

							</ul>

						</div>
					</div>
					
					<c:if test="${sessionid ==null}">
					<div id="write-b">
						<a href="${pageContext.request.contextPath}/member/login"
							class="btn header-btn">글쓰기</a>

					</div>
					</c:if>
					<c:if test="${sessionid !=null}">
					<div id="write-b">
						<a href="${pageContext.request.contextPath}/DealA/write"
							class="btn header-btn">글쓰기</a>

					</div>
					</c:if>
					<div class="pagination">
						<c:if test="${page <= 1 }">
					<a id="paging">&laquo;</a>

				</c:if>
				<c:if test="${page > 1 }">
					<a href="list?page=${page-1}&view2=${view2}" id="paging">&laquo;</a>
				</c:if>

				<c:forEach var="a" begin="${startpage}" end="${endpage}">

					<c:if test="${a == page }">
						<a href="#" id="paging1">${a}</a>
					</c:if>
					<c:if test="${a != page }">
						<a href="list?page=${a}&view2=${view2}" id="paging2">${a}</a>
					</c:if>
				</c:forEach>
				<c:if test="${page >= maxpage }">
					<a id="paging">&raquo;</a>
				</c:if>
				<c:if test="${page < maxpage }">
					<a href="list?page=${page+1}&view2=${view2}" id="paging3">&raquo;</a>
				</c:if>
					</div>

				</div>


			</div>
			<!-- End Nav Card -->
		</div>
	</section>


	
	
		
		<script>
		function getParameterByName(name) {
			name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
			var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
					.exec(location.search);
			return results == null ? "" : decodeURIComponent(results[1]
					.replace(/\+/g, " "));
		}

		function SubmitForm()
        {

            form1.submit();
           
        }
		
		$(function() {
			var page = getParameterByName("page");
			$("#view").change(function() { //최신순, 등록순, 조회순 변경 시
				var view = $("#view").val();
				location.href="list?page="+page +"&view2=" + view;
				
			})
			
		})
		</script>
	
	
	<!-- Gallery End--> </main>
	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer2.jsp" />



</body>
</html>