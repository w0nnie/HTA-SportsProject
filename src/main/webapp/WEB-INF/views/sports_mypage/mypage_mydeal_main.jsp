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
   href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Dealstyle.css">
</head>
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<style>
#sell, #buy ,#cart {
	float: left;
	color: black;
	font-weight: bold;
	font-size: 25px
}



#view{
	float:right;
}
#delimg{
	color:red
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
			
			<div class="col-lg-8">
				<div class="section lb">
				
					<div class="container">
						<div class="section-title text-center">

							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									 <a id="buy" href="${pageContext.request.contextPath}/Mydeal/buy">
									 <i class="fas fa-coins" 
									
									></i>&nbsp;&nbsp;구매현황<b style="color:red;font-size:15px">(클릭시 상세페이지)</b></a> 
									
									<c:if test="${sessionid eq 'admin'}">
									<a 
									href = "pointadmin" style="float:right" id="pointadmin">포인트 요청 내역</a> 
									</c:if>
									<c:if test="${sessionid ne 'admin'}">
									<a 
									href = "pointview" style="float:right" id="pointview">경매 포인트 충전 (현재 포인트<fmt:formatNumber value="${nowpoint}" pattern="#,###"/>원)</a> 
									</c:if>
									<br>
									<br>
									
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">입찰중</th>
												<th scope="col">입찰완료</th>
												<th scope="col">입찰실패</th>
												<th scope="col">배송중</th>
												
											</tr>
										</thead>
										<tbody>
											<tr>
												<td data-label="DOMAIN NAME">${BUY_BIDDING}</td>
												<td data-label="registration pricing">${BUY_BIDCOM}</td>
												<td data-label="renewal pricing">${BUY_BIDFAIL}</td>
												<td data-label="transfer-price">${BUY_DELIVERY}</td>
											
											</tr>

										</tbody>
									</table>

								</div>
							</div>
							<hr>
							<br>
							<br>

							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									<a id="sell" 
									href="${pageContext.request.contextPath}/Mydeal/sell"
									><i class="fas fa-coins"></i>&nbsp;&nbsp;판매현황<b style="color:red;font-size:15px">(클릭시 상세페이지)</b></a> <br>
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">입찰중</th>
												<th scope="col">배송입력</th>
												<th scope="col">배송중</th>
												
											
											</tr>
										</thead>
										<tbody>
											<tr>
												<td data-label="DOMAIN NAME">${SELL_BIDDING}</td>
												<td data-label="renewal pricing">${SELL_DELIVERY}</td>
												<td data-label="registration pricing">${SELL_BIDCOM}</td>
												
												
											</tr>

										</tbody>
									</table>

								</div>
							</div><hr>
							<br>
							<br>
							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									<a id="sell" 
									href="${pageContext.request.contextPath}/Mydeal/question"
									><i class="fas fa-envelope-square"></i>&nbsp;&nbsp;문의내역<b style="color:red;font-size:15px">(클릭시 상세페이지)</b></a> <br>
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col" colspan="2">경매거래</th>
												<th scope="col" colspan="2">직거래 </th>

											</tr>
											<tr class="domain-head">
												<th scope="col">내가 한 문의</th>
												<th scope="col">나에게 온 문의 </th>
												<th scope="col">내가 한 문의</th>
												<th scope="col">나에게 온 문의 </th>

											</tr>
										</thead>
										<tbody>
											<tr>
												<td data-label="transfer-price">${BUY_QUESTION}</td>
												<td data-label="transfer-price">${SELL_QUESTION}</td>
												<td data-label="transfer-price">${BUY_QUESTION2}</td>
												<td data-label="transfer-price">${SELL_QUESTION2}</td>
												
											</tr>

										</tbody>
									</table>

								</div>
							</div>
							<hr><br><br><br>
							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									<a id="cart"><i class="fas fa-shopping-cart"></i>
									&nbsp;장바구니</a> 
									<select id="view">
									<option value="1" selected>경매거래</option>
									<option value="2">직거래</option>
									</select><br>
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">글번호</th>
												<th scope="col">글제목</th>
												<th scope="col">경매기간</th>
												<th scope="col">입찰수</th>
												<th scope="col">시작가</th>
												<th scope="col">현재가</th>
												<th scope="col">즉시구매가</th>
												<th scope="col">아이디</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="b" items="${Auction}">
											<tr>
												<td data-label="DOMAIN NAME">${b.AUC_NUMBER }</td>
												<td data-label="DOMAIN NAME">
												<a href="${pageContext.request.contextPath}
										/DealA/detail?num=${b.AUC_NUMBER}">${b.AUC_SUBJECT }</a></td>
												<td data-label="registration pricing">${b.AUC_DATE }</td>
												<td data-label="renewal pricing">${b.AUC_COUNT }</td>
												<td data-label="transfer-price">${b.AUC_SPRICE }</td>
												<td data-label="renewal pricing">${b.AUC_PRICE }</td>
												<td data-label="renewal pricing">${b.AUC_LPRICE }</td>
												<td data-label="transfer-price">${b.USER_ID }&nbsp;
												<span id ="delimg"><a href =
												"${pageContext.request.contextPath}
										/Mydeal/delete?num=${b.AUC_NUMBER}"><i class="far fa-trash-alt"></i></a></span></td>
											</tr>
										</c:forEach>

										</tbody>
									</table>

								</div>
							</div>
						</div>
						<!-- end title -->
					</div>
					<!-- end container -->
				</div>
				<!-- end section -->
			</div>
		</div>

	</section>
	<script>
	$(function() {
		
		$("#view").change(function() { //최신순, 등록순, 조회순 변경 시
			var view = $("#view").val();
			
			if(view=="1"){
				location.href="main";
			}else{
				location.href="main2"
			}
			
			
		})
		
		$("#pointview").click(function(){
			location.href="pointview"
		})
		
		
	})
	</script>

	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp" />

</body>
</html>