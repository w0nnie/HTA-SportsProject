<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="http://code.jquery.com/jquery-latest.js"></script>
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

#th2 {
	background-color: #2c3e50;
	color: white
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
					<h2 style="font-family: '나눔고딕'">
						<b>판매현황</b>
					</h2>
					<div class="header-bottom ">
						<ul
							class="header-right f-right d-none d-lg-block d-flex justify-content-between">
							<li class="d-none d-xl-block" id="sd-none"><select
								style="position: relative;" id="view" name="search_field">
									<c:if test="${view2 == '1' }">
										<option value="1" selected>입찰중</option>
										<option value="2">배송입력</option>
										<option value="3">배송중</option>

									</c:if>
									<c:if test="${view2 == '2'}">
										<option value="1">입찰중</option>
										<option value="2" selected>배송입력</option>
										<option value="3">배송중</option>

									</c:if>
									<c:if test="${view2 == '3'}">
										<option value="1">입찰중</option>
										<option value="2">배송입력</option>
										<option value="3" selected>배송중</option>

									</c:if>


							</select>
								<div style="width: 70%" class="form-box f-right"></div></li>
						</ul>
					</div>

				</form>
				<!-- end section -->

				<table class="table">
					<thead>
						<tr>
							<th colspan="6"><font size=3>글 개수 : ${listcount}</font></th>
						</tr>
						<c:if test="${view2 == '3' }">
							<tr>
								<th id="th2"><div>글번호</div></th>
								<th id="th2"><div>제목</div></th>
								<th id="th2"><div>최종금액</div></th>
								<th id="th2"><div>택배사</div></th>
								<th id="th2"><div>송장번호</div></th>
								<th id="th2"><div></div></th>

							</tr>
						</c:if>
						<c:if test="${view2 == '2' }">
							<tr>
								<th id="th2"><div>글번호</div></th>
								<th id="th2"><div>제목</div></th>
								<th id="th2"><div>최종금액</div></th>
								<th id="th2"><div>택배사</div></th>
								<th id="th2"><div>송장번호</div></th>
								<th id="th2"><div>송장등록</div></th>

							</tr>
						</c:if>
						<c:if test="${view2 == '1' }">
							<tr>
								<th id="th2"><div>글번호</div></th>
								<th id="th2"><div>제목</div></th>
								<th id="th2"><div>시작금액</div></th>
								<th id="th2"><div>현재금액</div></th>
								<th id="th2"><div>즉시구매가</div></th>
								<th id="th2"><div>입찰횟수</div></th>
								<th id="th2"><div>경매기간</div></th>
							</tr>
						</c:if>
					</thead>
					<tbody>
						<c:forEach var="b" items="${Auction}">
							<c:if test="${view2 == '2' }">

								<tr>
								<form name="forma" id="forma" action="postinput">
									<td>${b.AUC_NUMBER}</td>
									<input type="hidden" id="num" name="num" value="${b.AUC_NUMBER}">

									<td><div>${b.AUC_SUBJECT}</div></td>

									<td><div><fmt:formatNumber value="${b.AUC_PRICE}" pattern="#,###"/>원</div></td>

									<td><div>
											<select id="sel" name="sel">
												<option value="우체국">우체국</option>
												<option value="cj">cj</option>
												<option value="로젠">로젠</option>
												<option value="한진">한진</option>
												<option value="현대">현대</option>
												<option value="UPS">UPS</option>
												<option value="DHL">DHL</option>
												<option value="KGB">KGB</option>
												<option value="경동">경동</option>
												<option value="KG로지스">KG로지스</option>
												<option value="대신">대신</option>
												<option value="합동">합동</option>
												<option value="천일">천일</option>
												<option value="씨브이에스넷">씨브이에스넷</option>
												<option value="편의점">편의점</option>

											</select>
										</div></td>
									<td><div>
											<input id="post1" name="post1" type="text"
												placeholder="송장번호를 입력해주세요..." required>
										</div></td>
									<td><button onclick="SubmitForm()" class="btn btn-success" id="buttonid"
											style="background-color: green;">송장등록</button></td>
									</form>
								</tr>

							</c:if>
							<c:if test="${view2 == '1' }">
								<tr>
									<td>${b.AUC_NUMBER}</td>
									<td><div><a href="${pageContext.request.contextPath}
										/DealA/detail?num=${b.AUC_NUMBER}">${b.AUC_SUBJECT}</a></div></td>
									<td>

										<div><fmt:formatNumber value="${b.AUC_SPRICE}" pattern="#,###"/>원</div>
									</td>
									<td><div><fmt:formatNumber value="${b.AUC_PRICE}" pattern="#,###"/>원</div></td>
									<td><div><fmt:formatNumber value="${b.AUC_LPRICE}" pattern="#,###"/>원</div></td>
									<td><div>${b.AUC_COUNT}</div></td>
									<td><div>${b.AUC_DATE}</div></td>
								</tr>
							</c:if>
							<c:if test="${view2 == '3' }">
								<tr>
									<td>${b.AUC_NUMBER}</td>
									<td><div>${b.AUC_SUBJECT}</div></td>
								
									<td><div>${b.AUC_PRICE}원<fmt:formatNumber value="${b.AUC_PRICE}" pattern="#,###"/>원</div></td>
									
									<td><div>${b.AUC_DELIVERYCOM}</div></td>
									<td><div>${b.AUC_DELIVERYNUM}</div></td>
									<td><div style="color:red">수령확인시 글이자동 삭제</div></td>
								</tr>
							</c:if>
							<!-- 셀렉 인풋값 아이디 버튼 id값 다 따로부여 -->
							<script>
								$(function() {
									var number = ${b.AUC_NUMBER}
									var selid = "sel" + number;
									var postid = "post1" + number;
									var buttonid = "buttonid" + number;
									var formname = "forma" + number;
	
									

									$("#sel").attr("id", selid);
									$("#post1").attr("id", postid);
									
									$("#buttonid").attr("id", buttonid);
									$("#forma").attr("name", formname);
									$("#forma").attr("id", formname);
									
									var sel = getParameterByName(selid);
									var post1 = getParameterByName(postid);
									
								

									function SubmitForm()
     								   {

										eval('form' + number).submit();
           
       									}

								})

								function getParameterByName(name) {
									name = name.replace(/[\[]/, "\\[").replace(
											/[\]]/, "\\]");
									var regex = new RegExp("[\\?&]" + name
											+ "=([^&#]*)"), results = regex
											.exec(location.search);
									return results == null ? ""
											: decodeURIComponent(results[1]
													.replace(/\+/g, " "));
								}
								
							</script>
						</c:forEach>


					</tbody>
				</table>
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

	</section>
	<script>
		$(function() {
			$("#view").change(function() { //최신순, 등록순, 조회순 변경 시
				var view = $("#view").val();
				location.href = "sell?view2=" + view;

			})

		})
	</script>

	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp" />

</body>
</html>