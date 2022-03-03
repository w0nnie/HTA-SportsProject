<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>수정 게시판</title>
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bbs_fr/modify.css">
	<script src="../resources/js/BBS_FR/modifyform.js"></script>
	<script>
	if('${result}'=='passFail'){
		alert("비밀번호가 다릅니다.")
	}
	</script>
	<!-- <style>
	 h1{font-size:1.5rem; text-align:center;color:#1a92b9}
	 .container{width:60%}
	 #upfile{display:none}
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
							<h2>자유게시판 수정</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<!-- slider Area End--> 
	
	<!-- Latest Products Start -->
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
				</div>
				<form action="modifyAction" method="post" enctype="multipart/form-data"
	 			name="modifyform">
				<input type="hidden" name="FR_NO" 	value="${boarddata.FR_NO}">
	 			<input type="hidden" name="FR_FILE" 	value="${boarddata.FR_FILE}">
	 			<input type="hidden" name="before_file" value="${boarddata.FR_FILE}">
    	 			<div class="row">
						<div class="col-md-4 form-group">
							<label for="USER_ID">글쓴이</label> 
							<input type="text" id="USER_ID" value="${boarddata.USER_ID}" readOnly
									class="form-control" style="width: 680px"
									placeholder="제목을 입력하세요" name="USER_ID"> 
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 form-group">
							<label for="FR_SUBJECT">제목</label> 
							<input name="FR_SUBJECT" id="FR_SUBJECT" maxlength="100"
	 				 				class="form-control "style="width: 680px" value="${boarddata.FR_SUBJECT}">
	 				 		
						</div>
					</div>
					<div class="row">
						<div class="col-md-11 form-group">
							<label for="message">내용</label>
							<textarea name="FR_CONTENT" id="FR_CONTENT" cols="40" rows="10"
									class="form-control">${boarddata.FR_CONTENT}</textarea>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="message">사진 첨부</label><br> <label class="file"
									title="">
							<c:choose>
							<c:when test="${boarddata.FR_ORIGINAL!=null}">	
							<span id="filevalue">${boarddata.FR_ORIGINAL}</span>
							</c:when>
							<c:when test="${boarddata.FR_ORIGINAL==null}">
							<span id="filevalue">No file chosen</span>
							</c:when>
							</c:choose>
							
							<input type="file"
									onchange="this.parentNode.setAttribute('title', this.value.replace(/^.*[\\/]/, ''))"
									id="upfile" name="uploadfile" />
							</label>
							<img src="../resources/image/bbs_fr/close.png" alt="파일삭제" width="10px" class="remove">
							
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-md-4 form-group">
	 						<label for="FR_PASS">비밀번호</label>
	 						<input name="FR_PASS" id="FR_PASS" type="password" maxlength="30"
	 								class="form-control" style="width: 680px"
	 								placeholder="비밀번호를 입력하세요">
	 					</div>
					</div>
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
<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
</body>
</html>