<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>멘티 공고 글쓰기</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mmatch/mentor_write.css">
</head>
<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp" />

	<main> <!-- slider Area Start-->
		<div class="slider-area ">
			<!-- Mobile Menu -->
			<div class="single-slider slider-height2 d-flex align-items-center"
				data-background="${pageContext.request.contextPath}/resources/image/mainSlide/main_slide03.jpg">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="hero-cap text-center">
								<h2>멘티 공고 글쓰기</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- slider Area End--> <!-- Latest Products Start -->
	
		<div class="site-section bg-light" style="padding-top: 50px;padding-bottom: 50px">
			<div class="container" style="padding: 30px;border: 2px solid;">
				<div class="row">
					<div class="col-lg-12">
						<form action="addWMentee" method="post" enctype="multipart/form-data">
							<!-- 작성자 (hidden) -->
							<input id="user_id" name="user_id" value="${USER_ID}" type="hidden" >
							<!-- 수업 타이틀  -->
							<div class="row">
								<div class="col-md-4 form-group">
									<label for="mentee_title"><h4>수업 제목</h4></label>
									<input style="width: 1013px" type="text" id="mentee_title" name="mentee_title" 
										class="form-control form-control-lg" placeholder="제목을 입력하세요">
								</div>
							</div>
							<br>
			
							<!-- 수업 종목  -->
							<div class="row">
								<div class="col form-group">
									<h4>요청 종목</h4>
									항목&nbsp;
									<select name='sports_category' id="mentee_sports_category1">
										<option selected>-- 선택 --</option>
									</select>
									&nbsp;&nbsp;&nbsp;&nbsp;카테고리
									<select name='sports_name' id="mentee_sports_category2">
										<option selected>-- 선택 --</option>
									</select>
								</div>
							</div>
							<br>
						
							<!-- 수업 시간  -->
							<div class="row" id="time_row">
								<div class="col form-group">
									<h4 class="element_inline">요청 시간</h4>
									<div class="element_inline" id="addTime">
										<img style="margin-bottom: 8px" src="${pageContext.request.contextPath}/resources/image/mmatch/plus_icon.png" alt="">
									</div>
									<div id="mentee_time_list">
										<div>
											요일&nbsp;
											<select name='mentee_yoil'>
												<option selected>-- 선택 --</option>
											</select>
											&nbsp;&nbsp;&nbsp;
											시작시간 &nbsp;<input name="mentee_startTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>
											&nbsp;&nbsp;&nbsp;
											종료시간 &nbsp;<input name="mentee_endTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>
											<div class="element_inline" id="deleteTime">
												<img src="${pageContext.request.contextPath}/resources/image/mmatch/minus_icon.png" alt="">							
											</div>
										</div>
	    							</div>
								</div>
							</div>
							<br>
	
	
							<!-- 수업 장소  -->
							<div class="row">
								<div class="col form-group">
									<h4>요청 장소</h4>
									장소&nbsp;
									<select name='city' id="mentee_loc_category1" >
										<option selected>-- 선택 --</option>
									</select>
									&nbsp;
									<select name='sigungu' id="mentee_loc_category2">
										<option selected>-- 선택 --</option>
									</select>
									&nbsp;
									<input type="text" id="mentee_loc_detail" name="mentee_loc_detail"
											style="width: 647px"
											placeholder="&nbsp;상세 주소 입력하세요">
								</div>
							</div>
							<br>
				 			
							<!-- 요청 가격 /요청 성별 -->
							<div class="row">
								<div class="col form-group">
									<h4>요청 가격/요청 성별</h4>
									가격&nbsp;
									<input type="text" id="mentee_price" name="mentee_amount"
											style="width: 140px;text-align:right;"
											>원
									&nbsp;&nbsp;&nbsp;&nbsp;성별&nbsp;
									<select name='mentee_gender' id="mentee_gender">
										<option selected>-- 선택 --</option>
										<option value="남">남자</option>
										<option value="여">여자</option>
									</select>
								</div>
							</div>
							<br>
						
							<!-- 수업 주의사항 -->
							<div class="row">
								<div class="col form-group">
									<h4>기타 요구사항</h4>
									<input style="width:1013px;" type="text" id="mentee_req" name="mentee_req">
								</div>
							</div>
							<br>
							
							<hr>
	
							<!--첨부 사진 -->
							<div class="row">
								<div class="col-md-6 form-group">
									<h4>첨부 사진</h4><br>
									첨부파일
									<div style="color:red"class="element_inline">(해당 파일은 공고화면에 표시됩니다.)</div>
									<div class="custom-file mb-3"  style="width:1013px;" >
	      								<input type="file" class="custom-file-input" id="customFile1" name="uploadfile1">
	      								<label class="custom-file-label" for="customFile1">Choose file</label>
	      							</div>
								</div>
							</div>
							<hr>
							<br>
							<div class="row" style="text-align: center">
								<div class="col-12">
									<input type="submit" value="Submit"
										class="btn btn-primary py-3 px-5"
										style="background-color: black; height: 50px"> &emsp;
									<input type="button" value="Cancel"
										class="btn btn-primary py-3 px-5"
										style="background-color: gray; height: 50px">
								</div>
								<br><br>
							</div>
						</form>
					</div>
	
				</div>
			</div>
		</div>
	</main>
	<!-- Gallery End--> 
	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp" />
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/mmatch/mentee_write.js"></script>
</body>
</html>