<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible">
    <title>Login </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/favicon.ico">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
<script>

var result='${result}';
if(result=='joinSuccess'){
	alert("회원가입을 축하합니다.");
}else if(result=='0'){
	alert("비밀번호가 일치가지 않습니다.")
}else if(result=='-1'){
	alert("아이디가 존재하지 않습니다.")
}
 $(function(){
	 $(".join").click(function(){
		 location.href="${pageContext.request.contextPath}/sports_member/join";
	 });
	})
</script>
</head>

<body>
    
    <!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
    

    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="${pageContext.request.contextPath}/resources/image/bbs_fr/meditate.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>Login</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider Area End-->

    <!--================login_part Area =================-->
    <section class="login_part section_padding ">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 col-md-6">
                    <div class="login_part_text text-center">
                        <div class="login_part_text_iner">
                            <h2>처음이신가요?</h2>
                            <p>같이 운동할 파트너와 멘토/멘티를 찾으신다면</p>
                            <a href="${pageContext.request.contextPath}/member/join" class="btn_3">새 계정 만들기</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="login_part_form">
                        <div class="login_part_form_iner">
                            <h3>환영합니다 !<br>
								로그인 정보를 입력하세요</h3>
                            <form class="row contact_form" 
                            action="${pageContext.request.contextPath}/member/loginProcess" method="post">
                                <div class="col-md-12 form-group p_star">
                                    <input type="text" class="form-control" id="USER_ID" name="USER_ID" required
									<c:if test="${!empty saveid}">
									value="${saveid}
									</c:if>
                                        placeholder="ID">
                                </div>
                                <div class="col-md-12 form-group p_star">
                                    <input type="password" class="form-control" id="USER_PASS" name="USER_PASS"
									<c:if test="${!empty saveid}">
									value="${saveid}
									</c:if>
                                        placeholder="Password">
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="creat_account d-flex align-items-center">
                                        <input type="checkbox" id="f-option" name="remember"
                                        <c:if test="${!empty saveid}">
										checked
										</c:if>>
                                        <label for="f-option">Remember me</label>
                                    </div>
                                    <button type="submit" value="submit" class="btn_3">
                                        log in
                                    </button>
                                    <a class="lost_pass" href="#">비밀번호를 잊으셨나요?</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================login_part end =================-->
	
	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
   
	<!-- JS here -->
</body>
    
</html>