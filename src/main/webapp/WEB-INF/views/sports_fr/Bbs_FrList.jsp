<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>자유 게시판</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bbs_fr/list.css">
	
	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
	<script src="../resources/js/BBS_FR/list.js" charset="utf-8"></script>
</head>

<body>
    <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="${pageContext.request.contextPath}/resources/image/bbs_fr/jogging.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>자유게시판</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider Area End-->

    <!--================BBS_FRList Area =================-->
    
 <section class="blog_area section-padding">
 <div class="container">
 <form action="list">
 <div class="JooSearch">
	<div class="header-bottom ">
	  <ul class="header-right f-right d-none d-lg-block d-flex justify-content-between">
		<li class="d-none d-xl-block" id="sd-none">
			<select  style="position:relative;" id="viewcount" name="search_field">
 		 		<option value="0" selected>카테고리</option>
 		 		<option value="1">아이디</option>
 		  		<option value="2">제목</option>
 		 		<option value="3">내용</option>
 			</select>
			<div style="width:70%" class="form-box f-right">
	 		 <input name="search_word" type="text" class="form-control"
 			   placeholder="검색어를 입력하세요" value="${search_word}" id="sinput">
			<div class="search-icon">
				<i id="sub" class="fas fa-search special-tag"></i>
			</div>
			</div>
		</li>
	   </ul>
	</div>
 </div>
</form>
<%-- 게시글이 있는 경우--%> 
<input type="hidden" id="USER_ID" name="USER_ID" value="${USER_ID}">
<c:if test="${listcount > 0 }">
  <table class="table">
   <thead>
	<tr>
	   <th colspan="6">
			<font size=3>글 개수 : ${listcount}</font>
	   </th>
	</tr>
	<tr>
		<th><div>번호</div></th>
		<th><div>분류</div></th>
		<th><div>제목</div></th>
		<th><div>작성자</div></th>
		<th><div>날짜</div></th>
		<th><div>조회수</div></th>
	</tr>	
   </thead>
   <tbody>
	<c:set var="num" value="${listcount-(page-1)*limit}"/>	
	<c:forEach var="b" items="${boardlist}">	
	<tr>
	  <td><%--번호 --%>
		<c:out value="${num}"/><%-- num 출력 --%>		
		<c:set var="num" value="${num-1}"/>	<%-- num=num-1; 의미--%>	
	  </td>
	  <td><div>
          	    <c:if test="${b.FR_CSFC == '1' }">
	                        운동기록
		        </c:if>
	            <c:if test="${b.FR_CSFC == '2' }">
	                        운동팁
		        </c:if>
	            <c:if test="${b.FR_CSFC == '3' }">
	                        수다
		        </c:if>		
	            <c:if test="${b.FR_CSFC == '4' }">
	                        운동파트너
		        </c:if>
         </div></td>
	  <td ><%--제목 --%>
	     <div>		
			<a href="detail?num=${b.FR_NO}">
				 <c:out value="${b.FR_SUBJECT}" />  
				<%-- ${b.board_subject} --%>
				<%-- escapeXml="true" : HTML 태그를 화면에 그대로 보여줍니다. --%>	
			</a>
			<span class="cnt">[<c:out value="${b.CNT}"/>]</span>
		  </div>
		</td>
		<td><div>${b.USER_ID}</div></td>
		<td><div>${b.FR_DATE}</div></td>	
		<td><div>${b.FR_READCOUNT}</div></td>
	   </tr>
	  </c:forEach>
	 </tbody>	
	</table>
		
<div>
 	  <ul class="pagination justify-content-center">
 	  	<c:if test="${page <= 1 }">
				<a href="#" id="paging">&laquo;</a>
 	  	</c:if>
 	  	<c:if test="${page > 1 }">
			 <a href="list?page=${page-1}&search_field=${search_field}&search_word=${search_word}"
	  			id="paging">&laquo;</a>	
		</c:if>
		
		<c:forEach var="a" begin="${startpage}" end="${endpage}">
			<c:if test ="${a == page }">
						 <a href="#" id="paging">${a}</a>	
			</c:if>
		<c:if test="${a != page }">
			 <a href="list?page=${a}&search_field=${search_field}&search_word=${search_word}"
				id="paging">${a}</a>	
		</c:if>
		</c:forEach>
		
		<c:if test="${page >= maxpage}">
			<a href="#" id="paging">&raquo;</a>
		</c:if>
		<c:if test="${page < maxpage }">
			<a href="list?page=${page+1}&search_field=${search_field}&search_word=${search_word}"
			   id="paging">&raquo;</a>
		</c:if>
 	  </ul>
 </div>
     </c:if><%-- <c:if test="${listcount > 0 }"> end --%>
     <%-- 게시글이 없는 경우--%>
     <div class="container">
	<c:if test="${listcount == 0 }">
		<font size=5>등록된 글이 없습니다.</font>
	</c:if>
	</div>
	<button style=" height: 50px;" id="write" type="button" class="btn btn-primary py-3 px-5 float-left">글 쓰 기</button>
  </div>
  </section>
    <!--================BBS_FRList Area End=================-->

   <!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
   
</body>
</html>