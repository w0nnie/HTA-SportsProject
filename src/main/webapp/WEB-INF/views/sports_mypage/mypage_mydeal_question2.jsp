<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	background-color: #9dc15b;
	color: white
}

/* 아코디언*/
@charset "UTF-8";

body {
	color: #2c3e50;
	background: #ecf0f1;
	padding: 0 1em 1em;
}

h1 {
	margin: 0;
	line-height: 2;
	text-align: center;
}

h2 {
	margin: 0 0 0.5em;
	font-weight: normal;
}

input {
	position: absolute;
	opacity: 0;
	z-index: -1;
}

.row {
	display: flex;
}

.row .col {
	flex: 1;
}

.row .col:last-child {
	margin-left: 1em;
}

/* Accordion styles */
.tabs {
	border-radius: 8px;
	overflow: hidden;
	box-shadow: 0 4px 4px -2px rgba(0, 0, 0, 0.5);
}

.tab {
	width: 100%;
	color: white;
	overflow: hidden;
}

.tab-label {
	display: flex;
	justify-content: space-between;
	padding: 1em;
	background: #2c3e50;
	font-weight: bold;
	cursor: pointer;
	/* Icon */
}

.tab-label:hover {
	background: #1a252f;
}

.tab-label::after {
	content: "❯";
	width: 1em;
	height: 1em;
	text-align: center;
	transition: all 0.35s;
}

.tab-content {
	max-height: 0;
	padding: 0 1em;
	color: #2c3e50;
	background: white;
	transition: all 0.35s;
}

.tab-close {
	display: flex;
	justify-content: flex-end;
	padding: 1em;
	font-size: 0.75em;
	background: #2c3e50;
	cursor: pointer;
}

.tab-close:hover {
	background: #1a252f;
}

input:checked+.tab-label {
	background: #1a252f;
}

input:checked+.tab-label::after {
	transform: rotate(90deg);
}

input:checked ~ .tab-content {
	max-height: 100vh;
	padding: 1em;
}
/*****/
#view{
position: absolute;
	left: 90%;
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
							<h2 style="font-family: '나눔고딕'">내 거래 내역</h2>
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
						<b>나의 문의내역</b>
					</h2>
					<div class="header-bottom ">
						
							
							<select
								style="position: relative;" id="view" name="search_field">
									
										<option value="1">경매거래</option>
										<option value="2" selected>직거래</option>
									
									
							</select>
							<script>
							$(function(){
								$("#view").change(function() { //최신순, 등록순, 조회순 변경 시
									var view = $("#view").val();
									
									if(view=="1"){
										location.href="question";
									}else{
										location.href="question2"
									}
									
									
								})
							})
							</script>	
						
					</div>

				</form>
				<!-- end section -->

				<div class="row">
					<div class="col">
						<h3 style="font-family: '나눔고딕'">
							내가 한 문의
						</h3>
						<div class="tabs">
						<c:forEach var="b" items="${DbuyQuestion}">
							<div class="tab">
								<input type="checkbox" id="chck1"> 
								<label id="la1"
									class="tab-label" for="chck1">No.${b.WRITE_NUMBER }&nbsp;${b.SUBJECT }
									
									<c:if test="${b.QUESTION_ANSWER==null}">
									<span style="float:right; color:#0a8ff9">(답변대기)</span>
									</c:if>
									<c:if test="${b.QUESTION_ANSWER!=null}">
									<span style="float:right; color:#f11c1c">(답변완료)</span>
									</c:if>
									</label>
								<div class="tab-content"><b>내질문</b>
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								<a href="questiondel2?num=${b.QUESTION_NUMBER}"><i class="far fa-trash-alt"></i></a>
								<hr>${b.QUESTION_CONTENT}<hr>
								<b>답글</b><hr>
								<c:if test="${b.QUESTION_ANSWER==null}">
								답변이 아직안왔습니다.
								</c:if>
								<c:if test="${b.QUESTION_ANSWER!=null}">
								${b.QUESTION_ANSWER}
								</c:if>
								</div>
							</div>
							<script>
							//input label id값이랑 for 값 동적 부여 
							$(function(){
								var number = ${b.QUESTION_NUMBER}
								var inputid = "chck1" + number ; 
								var labelid = "lab" + number;
								
								
								
								$("#chck1").attr("id",inputid);
								$("#la1").attr("id", labelid);
								$(eval('"#' + labelid + '"')).attr("for",inputid)
								//eval($('"#' + labelid + '"').attr("for",inputid));
								
								
							})
							</script>
						</c:forEach>
							
						</div>
					</div>
					
				</div>
				<br>
				<br>
				<br>
				<hr>
				<div class="row">
					<div class="col">
						<h3 style="font-family: '나눔고딕'">
							나에게 온 문의
						</h3>
						
						<div class="tabs">
							<c:forEach var="b" items="${DsellQuestion}">
							<div class="tab">
								<input type="checkbox" id="chcks"> 
								<label id="las"
									class="tab-label" for="chcks">No.${b.WRITE_NUMBER }&nbsp;${b.SUBJECT }
									
									<c:if test="${b.QUESTION_ANSWER==null}">
									<span style="float:right; color:#0a8ff9">(답변대기)</span>
									</c:if>
									<c:if test="${b.QUESTION_ANSWER!=null}">
									<span style="float:right; color:#f11c1c">(답변완료)</span>
									</c:if></label>
								<div class="tab-content"><b>나에게 온질문</b> 
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;
								아이디: ${b.QUESTION_ID }<hr>${b.QUESTION_CONTENT}<hr>
								<b>답글</b><hr>
								<c:if test="${b.QUESTION_ANSWER==null}">
								<form name="forma" id="forma" action="answer2">
								<div><textarea  
								id = "tex" name="tex"
								style="width:1000px; height:100px"></textarea></div>
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								<button onclick="SubmitForm()" 
								class="btn btn-success" id="buttonid"
								name="buttonid"
											>답글등록</button>
								<input type="hidden" id="num" name="num" value="${b.QUESTION_NUMBER}">
								</form>
								</c:if>
								<c:if test="${b.QUESTION_ANSWER!=null}">
								${b.QUESTION_ANSWER}
								</c:if>
								</div>
							</div>
							<script>
							$(function(){
								var number = ${b.QUESTION_NUMBER}
								var textid = "text" + number; 
								var buttonid = "buttonid" +number;
								var formname = "forma" + number;
								
								$("#tex").attr("id",textid);
								$("buttonid").attr("id",buttonid);
								
								$("#forma").attr("name", formname);
								$("#forma").attr("id", formname);
								
								function SubmitForm()
								   {

									eval('form' + number).submit();
    
									}
								
							})
							</script>
							<script>
							//input label id값이랑 for 값 동적 부여 
							$(function(){
								var number = ${b.QUESTION_NUMBER}
								var inputid = "chcks" + number ; 
								var labelid = "las" + number;
								
								
								
								$("#chcks").attr("id",inputid);
								$("#las").attr("id", labelid);
								$(eval('"#' + labelid + '"')).attr("for",inputid)
								//eval($('"#' + labelid + '"').attr("for",inputid));
								
								
							})
							</script>
						</c:forEach>
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