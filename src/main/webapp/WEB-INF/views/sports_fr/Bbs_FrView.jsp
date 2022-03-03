<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>자유게시판 상세보기</title>
<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bbs_fr/view.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
 <script src="${pageContext.request.contextPath}/resources/js/BBS_FR/view.js"></script>
<script>
	
	var result = "${result}";
	if(result == 'passFail'){
		alert("비밀번호가 일치하지 않습니다.")
	}
	$(function(){
		$("form[action=delete]").submit(function(){
			if($("#FR_PASS").val() == ''){
				alert("비밀번호를 입력하세요");
				$("#FR_PASS").focus();
				return false;
			}
	
		})
	})
</script>

<style>
#comment > table > tbody > tr > td:nth-child(2){
width:60%
}

/* #count{
	position: relative;
	top: -10px;
	left: -10px;
	background: orange;
	color:white;
	border-radius: 30%
} */

textarea{resixe:none}

form[action=down] > input[type=submit]{
	position: relative;
	top: -25px;
	left:10px;
	border: none;
	cursor : pointer;
	background-color : white;
}

</style>
</head>
<body>
	<%-- <input type="hidden" value="${id}" id="loginid" name="loginid"> --%>
	
<%-- 	<input type="hidden" value='admin01' id="loginid" name="loginid">
	<div class="container">
		<table class="table table=striped">
			<tr><th colspan="2">자유게시판</th></tr>
			<tr>
				<td><div>분류</div></td>
				<td><div id="FR_CSFC">
				<c:if test="${boarddata.FR_CSFC =='1'}">
				운동기록
				</c:if>
				<c:if test="${boarddata.FR_CSFC == '2'}">
				운동팁
				</c:if>
				<c:if test="${boarddata.FR_CSFC == '3'}">
				수다
				</c:if>
				<c:if test="${boarddata.FR_CSFC == '4'}">
				운동파트너
				</c:if>
				</div></td>
			</tr>
			<tr>
				<td><div>글쓴이</div></td>
				<td><div id="BOARD_NAME">${boarddata.USER_ID}</div></td>
			</tr>
			<tr>
				<td><div>제목</div></td>
				<td><c:out value="${boarddata.FR_SUBJECT}"	/></td>
			</tr>
			<tr>
				<td><div>내용</div></td>
				<td style="padding-right:0px"><textarea class="form-control" rows="5"
					readOnly>${boarddata.FR_CONTENT}</textarea></td>
			</tr>
			
				<tr>
					<td><div>첨부파일</div></td>
					<c:if test="${!empty boarddata.FR_FILE}">
						파일첨부한 경우
						<td><img src="../resources/image/bbs_fr/down.png" width="10px"> 
						<form method="post" action="down">
							<input type="hidden" value="${boarddata.FR_FILE}" name="filename">
							<input type="hidden" value="${boarddata.FR_ORIGINAL}" name="original">
							<input type="submit" value="${boarddata.FR_ORIGINAL}" >
						</form>
						</td>
					</c:if>
					<c:if test="${empty boarddata.FR_FILE}">
						파일첨부하지 않은 경우
						<td></td>
					</c:if>
				</tr>
			<tr>
				<td colspan="2" class="center">
				  	<button class="btn btn-primary start">댓글</button>
				  		<span id="count">${count}</span>
				  <c:if test="${board.USER_ID == id || id =='admin' }">
				   <a href="modifyView?num=${boarddata.FR_NO}">
				   	<button class="btn btn-warning">수정</button>
				  </a>
				  <a href="#">
				   	<button class="btn btn-danger" data-toggle="modal"
				   			data-target="#myModal">삭제</button>
				   </a>
				  </c:if>
			
				  <a href="replyView?num=${boarddata.FR_NO}">
				   	 <button class="btn btn-info">답변</button>
				   </a>
				   
				   <a href="list">
				   	 <button class="btn btn-success">목록</button>
				   </a>
				</td>
			</tr>
		</table>
		</div> --%>
<%-- 게시판view end --%>
		
		<!-- 게시판 상세보기 시작 -->
		<!-- <input type="hidden" value='admin01' id="loginid" name="loginid"> -->
		<input type="hidden" value="${USER_ID}" id="loginid" name="loginid">
		<div class="blog-single gray-bg">
        <div class="container">
            <div class="row align-items-start">
                <div class="col-lg-12 m-15px-tb">
                    <article class="article">
                     <div class="article-title">
                        <h6><a href="#">자유게시판 >
						 <c:if test="${boarddata.FR_CSFC =='1'}">
						   운동기록
						 </c:if>
						 <c:if test="${boarddata.FR_CSFC == '2'}">
						   운동팁
						 </c:if>
						 <c:if test="${boarddata.FR_CSFC == '3'}">
						   수다
						 </c:if>
						 <c:if test="${boarddata.FR_CSFC == '4'}">
						   운동파트너
						 </c:if>
						 </a></h6>
                      <h2> ${boarddata.FR_SUBJECT}</h2>
                       <div class="media">
                         <div class="avatar">
                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" title="" alt="">
                              </div>
                                <div class="media-body">
                                   <label>${boarddata.USER_ID}</label>
                                   <span>${boarddata.FR_DATE}</span>
                                </div>
                        </div>
                     </div>
                     <div class="article-content">
                        <%-- <textarea class="form-control" rows="5" id="text"
						readonly style="background-color:white">${boarddata.FR_CONTENT}
						</textarea> --%>
						<span>${boarddata.FR_CONTENT}</span>
                     </div>
                        <div class="article-img">
                            <img src="${pageContext.request.contextPath}/resources/BBS_FRupload/${boarddata.FR_FILE}"
                             title="" alt="">
                     	<c:if test="${!empty boarddata.FR_FILE}">
						<%-- 파일첨부한 경우 --%>
						<div>
						<img src="../resources/image/bbs_fr/down.png" width="10px"> 
						<form method="post" action="down">
							<input type="hidden" value="${boarddata.FR_FILE}" name="filename">
							<input type="hidden" value="${boarddata.FR_ORIGINAL}" name="original">
							<input type="submit" value="${boarddata.FR_ORIGINAL}" >
						</form>
						</div>
						</c:if>
						<c:if test="${empty boarddata.FR_FILE}">
						<%-- 파일첨부하지 않은 경우 --%>
						</c:if>
						</div>                     	
                     	
                        <div class="nav tag-cloud">
                          <c:if test="${board.USER_ID == id || id =='admin' }">
				   		  <a href="modifyView?num=${boarddata.FR_NO}">수정
		                  </a>
				  		  <a href="#"  data-toggle="modal"
				   			 data-target="#myModal">삭제
				 		  </a>
				  		  </c:if>
				   		  <a href="list">목록
				  		  </a>
                        </div>
                     </article>
                    
                    <!-- 댓글 area -->
<div class="container">
	<div id="comment">
		<button id="wc" class="btn-dark float-left">총 50자까지 가능합니다.</button>
			<span>댓글</span>
			<span id="count">${count}</span>
		<div>
		<textarea rows=3 class="form-control"
				  id="content" maxLength="50"></textarea>
		<button id="write" style=" border-radius: 25px;" class="btn-dark float-right">등록</button>
			<table class="table table_striped">
				<thead>
				  <tr><td>아이디</td><td>내용</td><td>날짜</td></tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
			<div id="message"></div>
		</div>
	</div>
</div>
            <!-- 댓글 끝 -->       
                </div>
                <div class="col-lg-4 m-15px-tb blog-aside">
              </div>
            </div>
        </div>
    </div>
<!-- 게시판 상세보기 끝 -->
		
		<%--modal 시작--%>
		<div class="modal" id="myModal">
		  <div class="modal-dialog">
			<div class="modal-content">
				<%--Modal body --%>
				<div class="modal-body">
				 <form name="deleteForm" action="delete" method="post">
				 	<%--http://localhost:8088/Board/BoardDetailAction.bo?num=22 
				 		주소를 보면 num을 파라미터로 넘기고 있습니다.
				 		이 값을 가져와서 ${param.num}를 사용
				 		또는 ${boarddata.BOARD_NUM}
				 	--%>
				 	<input type="hidden" name="FR_NO" value="${param.num}" id="FR_NO">
				 	<div class="form-group">
				 		<label for ="pwd">비밀번호</label>
				 		<input type="password"
				 				class="form-control" placeholder="Enter password"
				 				name="FR_PASS" id="FR_PASS">
				 	</div>
				 	<button type="submit" class="btn btn-primary">전송</button>
				 	<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
				 </form>
				</div><!-- class="modal-body" -->
			</div><!-- class="modal-content -->
		</div><!-- class="modal-dialog" -->
		</div><!-- class="modal" end -->
		
	

	<%-- <div class="CommentBox">
			<div class="comment_option">
				<h3 class="comment_title">
					댓글<sup id="count"></sup>
				</h3>
				<div class="comment_tab">
					<ul class="comment_tab_list">
					</ul>
				</div>
			</div><!-- comment option end -->
			<ul class="comment_list">
			</ul>
			<div class="CommentWriter">
				<div class="comment_inbox">
					<b class="comment_inbox_name">${id}</b> <span
						class="comment_inbox_count">0/200</span>
					<textarea placeholder="댓글을 남겨보세요" rows="1"
						class="comment_inbox_text" maxLength="200"></textarea>
				</div>
				<div class="register_box">
					<div class="button btn_cancel">취소</div>
					<div class="button btn_register">등록</div>
				</div>
			</div><!-- CommentWriter end -->
		</div><!-- CommentBox end -->
	</div><!-- class="container" --> --%>


<!-- footer 영역  -->
<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>

</body>
</html>