<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="m" value="${mypage_info}"/>
<!DOCTYPE html>
<html>
<head>
<title>회원수정 페이지</title>
<style>
h3{text-align:center;}

input{border-radius:3px;border:1px solid lightgray}
input[type=file]{display:none;}
input[type=text], input[type=password] {
    width: 100%;
    padding: 10px;
    margin: 5px 0 10px 0;
    display: inline-block;
}


button {cursor: pointer;}

button:hover {opacity:1;
}
button:focus{outline:none;}

/* 취소 버튼*/
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

button{
  float: right;
}

form {
    margin: 5% auto 5% auto;
    width: 600px;
    height:1000px;
    padding: 6px;
}

h1{text-align:center}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
<!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div style="background-image: url('/sports/resources/image/privacy.jpg')"    
             class="single-slider slider-height2 d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>개인정보수정</h2>
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
					<jsp:include page="/WEB-INF/views/sport_comm/asideLeft.jsp"/>
                </div>
                <div class="col-lg-10 mb-5 mb-lg-0">
					<form name="joinform" action="updateProcess" method="post" enctype="multipart/form-data">
						<h3>회원 정보 수정</h3>
						<hr>
						<b>아이디</b>
						<input class="single-input" type="text" name="USER_ID" value="${m.USER_ID}" readOnly>
  
						<b>비밀번호</b>
						<input class="single-input" type="password" name="USER_PASS" value="${m.USER_PASS}" required>
  
						<b>이름</b>
						<input class="single-input" type="text" name="USER_NAME" value="${m.USER_NAME}" placeholder="Enter name" readOnly>
  
						<b>주민번호</b>
						<input class="single-input" type="text" name="USER_JUMIN" value="${m.USER_JUMIN}" placeholder="Enter JUMIN" required>
  
						<b>연락처</b>
						<input class="single-input" type="text" name="USER_MOBILE" value="${m.USER_MOBILE}" size="10" maxLength="11" pattern="[0-9]+" required>
  
						<b>이메일 주소</b>
						<input class="single-input" type="text" name="USER_EMAIL" value="${m.USER_EMAIL}" placeholder="Enter email" required>
  
						<b>주소</b>
						<input class="single-input" type="text" name="USER_ADDRESS" value="${m.USER_ADDRESS}" required>
  
						<b>키(cm)</b>
						<input class="single-input" type="text" name="USER_HEIGHT" value="${m.USER_HEIGHT}" maxLength="5" pattern="[0-9.]+" required>
  
						<b>현재 몸무게(kg)</b>
						<input class="single-input" type="text" name="USER_PWEIGHT" value="${m.USER_PWEIGHT}" maxLength="5" pattern="[0-9.]+" required>
  
						<b>목표 몸무게(kg)</b>
						<input class="single-input" type="text" name="USER_WWEIGHT" value="${m.USER_WWEIGHT}" maxLength="5" pattern="[0-9.]+" required>
  
						<div class="clearfix">
						<button type="button" class="genric-btn danger radius">취소</button>
						<button type="submit" class="genric-btn success radius">수정</button>
						</div>
					</form>
                </div> 
        </div>
    </section>
</body>
</html>