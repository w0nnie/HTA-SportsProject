<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>자유 게시판 글쓰기</title>
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
	<script src="../resources/js/BBS_FR/writeform.js" charset="utf-8"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bbs_fr/Write.css">
	
	<!-- <style>
	 h1{font-size:1.5rem; text-align:center;color:#0d4182}
	 .container{width:60%}
	 label{font-weight:bold}
	 #upfile{display:none}
	 img{width:20px}
	</style> -->
</head>
 <body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">
	
	<main> <!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="single-slider slider-height2 d-flex align-items-center"
			data-background="${pageContext.request.contextPath}/resources/image/bbs_fr/soccer.jpg">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2>자유게시판 글쓰기</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<!-- slider Area End--> <!-- Latest Products Start -->

<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
				</div>
				<form action ="add" method = "post" enctype="multipart/form-data">
					<div class="row">
					  <div class="col-md-4 form-group">	
	 	 				<select name="FR_CSFC" id="FR_CSFC"  style="radius:25%;
	 	 				 width:150px; height:30px;">
	 	 				   <option value="">Category</option>
                   		   <option value="1">운동기록</option>
                   	  	   <option value="2">운동팁</option>
                      	   <option value="3">수다</option>
                      	   <option value="4">운동파트너</option>
    	 				</select>
    	 			  </div>
    	 			</div>
    	 			<div class="row">
						<div class="col-md-4 form-group">
							<label for="USER_ID">글쓴이</label> 
							<input type="text" id="USER_ID" value="admin01" readOnly
									class="form-control" style="width: 680px"
									placeholder="제목을 입력하세요" name="USER_ID"> 
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 form-group">
	 						<label for="FR_PASS">비밀번호</label>
	 						<input name="FR_PASS" id="FR_PASS" type="password" maxlength="30"
	 								class="form-control" style="width: 680px"
	 								placeholder="비밀번호를 입력하세요">
	 					</div>
					</div>
					<div class="row">
						<div class="col-md-4 form-group">
							<label for="FR_SUBJECT">제목</label> 
							<input type="text" id="FR_SUBJECT"
									class="form-control" style="width: 680px"
									placeholder="제목을 입력하세요" name="FR_SUBJECT"> 
						</div>
					</div>
					<div class="row">
						<div class="col-md-11 form-group">
							<label for="message">내용</label>
							<textarea name="FR_CONTENT" id="FR_CONTENT" cols="40" rows="10"
									class="form-control"></textarea>
						</div>
					</div>
					<hr>
					<div class="col-md-6 form-group">
									<label for="message">사진 첨부</label><br>
									<label class="file" title="">
									<input type="file"
										onchange="this.parentNode.setAttribute('title', this.value.replace(/^.*[\\/]/, ''))"
										id="upfile" name="uploadfile" /></label>
								</div>
			<hr>
			<br> <br> <br>
			<div class="container">
				<div class="row" style="text-align: center">
					<div class="col-11">
						<input type="submit" value="Submit"
								class="btn btn-primary py-3 px-5"
								style="background-color: black; height: 50px"> &emsp;
						<input type="reset" value="Cancel"
								class="btn btn-primary py-3 px-5"
								style="background-color: gray; height: 50px"
								onclick="window.history.back()">
					</div>
				   <br> <br> <br> <br> <br> <br> <br>
				</div>
			</div>
		</form>
	  </div>
    </div>
  </div>
</div>

 <!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
</body>
</html>