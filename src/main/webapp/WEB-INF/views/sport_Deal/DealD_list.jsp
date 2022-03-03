<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>직거래 메인</title>
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
<script src="http://code.jquery.com/jquery-latest.js"></script>
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

#timeback {
	width: 100%;
	height: 30px;
	background-color: #556069;
	color: white;
	border: 1px solid white;
}

/* 정렬 */

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
	width: 10px;
	height: 10px;
	top: 50%;
	right: 25px;
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
	top: 100%;
	left: 0;
	right: 0;
	min-width: 100%;
	margin: 15px 0;
	border: 1px solid #b5b5b5;
	border-radius: 4px;
	box-sizing: border-box;
	box-shadow: 0 2px 1px rgba(0, 0, 0, .07);
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
	bottom: 100%;
	right: 25px;
	width: 7px;
	height: 7px;
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

.custom-option:hover, .custom-option.selection {
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
							<a class="nav-item nav-link " id="nav-home-tab"
								href="${pageContext.request.contextPath}/DealA/list">경매 거래</a> <a
								class="nav-item nav-link active" id="nav-profile-tab"
								href="${pageContext.request.contextPath}/DealD/list">직거래</a>

						</div>
					</nav>
					<!--End Nav Button  -->
				</div>
				<div class="select-this d-flex">

					<form action="#">
						<div class="center">
							<c:if test="${view2 == 1 }">
								<select name="sources" id="view" class="custom-select sources"
									placeholder="Source Type" name="view">
									<option value="1">최신순</option>
									<option value="2">정확순</option>
									<option value="3">조회순</option>
									<option value="4">금액순</option>
								</select>
							</c:if>
							<c:if test="${view2 == 2 }">
								<select name="sources" id="view" class="custom-select sources"
									placeholder="Source Type" name="view">
									<option value="1">최신순</option>
									<option value="2" selected>정확순</option>
									<option value="3">조회순</option>
									<option value="4">금액순</option>
								</select>
							</c:if>
							<c:if test="${view2 == 3 }">
								<select name="sources" id="view" class="custom-select sources"
									placeholder="Source Type" name="view">
									<option value="1">최신순</option>
									<option value="2">정확순</option>
									<option value="3" selected>조회순</option>
									<option value="4">금액순</option>
								</select>
							</c:if>
							<c:if test="${view2 == 4 }">
								<select name="sources" id="view" class="custom-select sources"
									placeholder="Source Type" name="view">
									<option value="1">최신순</option>
									<option value="2">정확순</option>
									<option value="3">조회순</option>
									<option value="4" selected>금액순</option>
								</select>
							</c:if>
						</div>
					</form>
				</div>
			</div>
			<!-- Nav Card -->

			<div class="tab-content" id="nav-tabContent">
				<!-- card one -->
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<div id="ajax">
						<div class="row" id="aa">

							<c:forEach var="b" items="${Direct}">
								<div class="col-xl-4 col-lg-4 col-md-6">
									<div class="single-product mb-60">
										<div class="product-img">
											<img
												src="${pageContext.request.contextPath}/resources/dealupload2/${b.SAVE_DIR_MAINFILE}"
												alt="" style="width: 300px; height: 250px;">

										</div>
										<div class="product-caption">

											<h4>
											<span style="float:left">No.${b.DIR_NUMBER}</span>
												<a
													href="${pageContext.request.contextPath}/DealD/detail?num=${b.DIR_NUMBER}">
													<b>${b.DIR_SUBJECT}</b>
												</a>
											</h4>
											<div class="price">
												<table class="table">
													<tr>
														<th>올린사람</th>
														<td>${b.USER_ID}</td>
												
													</tr>
													<tr>
														<th>금액</th>
														<td>
														<fmt:formatNumber value="${b.DIR_PRICE}" pattern="#,###"/>원
														</td>

													</tr>
													<tr>
														<th>거래지역</th>
														<td>${b.DIR_ADDRESS}</td>
													</tr>
													<tr>
														<th>올리시간</th>
														<td>${b.DIR_DATE}</td>
													</tr>
													<tr>
														<th>조회수</th>
														<td>${b.DIR_READCOUNT}</td>
													</tr>

												</table>

											</div>
										</div>
									</div>
								</div>
							</c:forEach>




						</div>
					</div>


				</div>

			</div>
			<hr>
			<div class="ajax3">
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
										<input type="hidden" name="view2" value="${view2}">
									</form>
								</div>
							</li>

						</ul>

					</div>
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
						<a href="${pageContext.request.contextPath}/DealD/write"
							class="btn header-btn">글쓰기</a>

					</div>
					</c:if>

			<div id="ajaxpage">
				<div class="pagination">
					<c:if test="${page <= 1 }">
						<a id="paging">&laquo;</a>

					</c:if>
					<c:if test="${page > 1 }">
						<a href="list?page=${page-1}&view2=${view2}" id="paging">&laquo;</a>
					</c:if>

					<c:forEach var="a" begin="${startpage}" end="${endpage}">

						<c:if test="${a == page }">
							<a href="#" id="paging">${a}</a>
						</c:if>
						<c:if test="${a != page }">
							<a href="list?page=${a}&view2=${view2}" id="paging">${a}</a>
						</c:if>
					</c:forEach>
					<c:if test="${page >= maxpage }">
						<a id="paging">&raquo;</a>
					</c:if>
					<c:if test="${page < maxpage }">
						<a href="list?page=${page+1}&view2=${view2}" id="paging">&raquo;</a>
					</c:if>
				</div>
			</div>




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

		
		function SubmitForm() {

			form1.submit();
		}
		function go(page) {
			var view = $("#view").val(); //최신순부터 값은 1~3
			
			if(page==null){
				var data = "view=" + view + "&state=ajax";
			}else{
				var data = "view=" + view + "&state=ajax" + "&page=" + page;
			}
			
			var data2 = "&view2=" + view;
			var data3 = view;
			console.log("뷰" + view)

			console.log(page + "페잊")
			console.log(data)

			ajax(data, data2, data3);
		}
		$(function() {
			var page = getParameterByName("page");
			$("#view").change(function() { //최신순, 등록순, 조회순 변경 시
				go(page);

			})
		})
		
		function AddComma(num)
		{
			var regexp = /\B(?=(\d{3})+(?!\d))/g;
			return num.toString().replace(regexp, ',');
		}




		function ajax(sdata, sdata2, sdata3) {
			output = "";
			$.ajax({
						type : "post",
						data : sdata,
						url : "list_ajax",
						dataType : "json",
						success : function(rdata) {
							console.log("aa")
							$("#aa").remove();
							$(".pagination").remove();
							$(".sungjinS").remove();
							var output = '<div class="row" id="aa">';
							var outputP = '<div class="pagination">'
							outputP += '<c:if test="${page <= 1 }"><a id="paging">&laquo;</a>'
							outputP += '</c:if><c:if test="${page > 1 }">'
							outputP += '<a href="list?page=${page-1}' + sdata2
									+ '"id="paging">&laquo;</a>'
							outputP += '</c:if><c:forEach var="a" begin="${startpage}" end="${endpage}">'
							outputP += '<c:if test="${a == page }"><a href="#" id="paging">${a}</a>'
							outputP += '</c:if><c:if test="${a != page }"><a href="list?page=${a}'
									+ sdata2 + '"id="paging">${a}</a>'
							outputP += '</c:if></c:forEach><c:if test="${page >= maxpage }">'
							outputP += '<a id="paging">&raquo;</a></c:if>'
							outputP += '<c:if test="${page < maxpage }">'
							outputP += '<a href="list?page=${page+1}' + sdata2
									+ '"id="paging">&raquo;</a>'
							outputP += '</c:if></div>'

							var outputS = '<div class="sungjinS">'
							outputS += '<div class="header-bottom "> <ul '
				outputS +='class="header-right f-right d-none d-lg-block d-flex justify-content-between">'
							outputS += '<li class="d-none d-xl-block" id="sd-none">'
							outputS += '<div class="form-box f-right ">'
							outputS += '<form method="get" action="list" name="form1" id="form1">'
							outputS += '<input type="text" name="search" id="search"'
				outputS +='placeholder="Search products">'
							outputS += '<div class="search-icon">'
							outputS += '<i onclick="SubmitForm()" class="fas fa-search special-tag"id="searchB"></i>'
							outputS += '</div><input type="hidden" name = "view2" value="'+ sdata3  + '">'
							outputS += '</form></div></li></ul></div></div>'
							outputS += "<script>"
							outputS += '<link rel="stylesheet"'
				outputS +=	'href="${pageContext.request.contextPath}/resources/css/style.css">"'

							console.log(rdata)
							$(rdata.Direct)
									.each(
											function(index, item) {				
												 var price = AddComma(item.dir_PRICE);
												
												console.log(item.dir_PRICE
														+ "가격")
												output += '<div class="col-xl-4 col-lg-4 col-md-6" >'
												output += '<div class="single-product mb-60">'
												output += '<div class="product-img">'
												output += '<img src="${pageContext.request.contextPath}/resources/dealupload2/'
							output+= item.save_DIR_MAINFILE + '"'
							output+='alt="" style="width: 300px; height: 250px;">'
												output += '</div>'
												output += '<div class="product-caption">'
												output += '<h4> <a href="${pageContext.request.contextPath}/DealD/detail?num='
												output += item.dir_NUMBER
														+ '"> '
												output += '<b>'
														+ item.dir_SUBJECT
														+ '</b></a></h4>'
												output += '<div class="price"><table class="table">'
												output += '<tr><th>금액</th><td>'
														+ price
														+ '원</td>'
												output += '<tr><th>거래지역</th><td>'
														+ item.dir_ADDRESS
														+ '</td>'
												output += '</tr><tr><th>올린시간</th><td>'
														+ item.dir_DATE
														+ '</td>'
												output += '</tr><tr><th>조회수</th><td>'
														+ item.dir_READCOUNT
														+ '</td></tr></table>'
												output += '</div></div></div></div>'

											})
							output += "</div>"

							$('#ajax').append(output).trigger("create") //table 완성
							$('#ajaxpage').append(outputP).trigger("create") //페이징
							$('.ajax3').append(outputS).trigger("create")

						},
						error : function(request, status, error) {
							console.log(request.status + +"받은 데이터 :"
									+ request.responseText + +"error status : "
									+ status + +"error 메시지 : " + error)

						}//error end

					})
		}
	</script> <!-- Gallery End--> </main>
	<!-- Footer 영역  -->

	<jsp:include page="/WEB-INF/views/sport_comm/footer2.jsp" />

	<!-- JS here -->


</body>
</html>