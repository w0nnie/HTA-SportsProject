<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/fontawesome-all.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Dealstyle.css">
</head>
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<style>
#aa {
	float: left;
	color: black;
	font-weight: bold;
	font-size: 25px
}

#aa.hover {
	color: white;
}

#sele {
	float: right;
}

#delimg {
	color: red
}
#paging {
	color: black;
}

.pagination {
	text-align:center
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
#th2{
	background-color:#2c3e50;
	color:white
}

</style>
<body>


	<!-- Preloader Start-->

	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp" />

	<!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="single-slider slider-height2 d-flex align-items-center"
			data-background="${pageContext.request.contextPath}/resources/img/dealimg.png">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2  style = "font-family :'나눔고딕'">내 거래 내역</h2>
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
				<jsp:include page="/WEB-INF/views/sport_comm/asideLeft.jsp" />
			</div>
			<div class="col-lg-1"></div>
			<div class="col-lg-6">
				<form action="list">
				<h2 style = "font-family :'나눔고딕'"><b>포인트 충전</b></h2>
					<div class="header-bottom ">
						<ul
							class="header-right f-right d-none d-lg-block d-flex justify-content-between">
							<li class="d-none d-xl-block" id="sd-none">
							
							
								<div style="width: 70%" class="form-box f-right"></div></li>
						</ul>
					</div>

				</form>
				<!-- end section -->
				
				<table class="table">
					<thead>
						
						
						<tr>
							<th id= "th2"><div>아이디</div></th>
							<th id= "th2"><div>현재 포인트</div></th>
							<th id= "th2"><div>입금자 성명</div></th>
							<th id= "th2"><div>요청 포인트</div></th>
							<th id= "th2"><div>요청 확인</div></th>
							
						</tr>
						
						
					</thead>
					<tbody>
				
						
						<form name="forma" id="forma" action="pointrequest">
						<tr>
						
							<td>${sessionid}</td>
							<td> <fmt:formatNumber value="${nowpoint}" pattern="#,###"/>원</td>
							<td><input type="text" id="name" name="name" required></td>
							<td><input type="text" id="point" name="point" required></td>
							<td><button  type= "submit" class="btn btn-success" id="receipt"
											style="background-color: green;"
											>포인트 요청</button></td>
						
						</tr>
						</form>
						
						
					
					
					
					
					</tbody>
				</table>
				<div class="pagination">
					<b>요청 후 신한 11120202020-2123 (장성진) 으로 입금해주세요 </b>
				</div>
			</div>
		</div>

	</section>
	<script>
	$(function(){
		$('#receipt').click(function(){
			alert("충전 요청 되었습니다.\n 입금 확인시 충전완료 됩니다.")
		})
	})
	</script>

	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp" />

</body>
</html>