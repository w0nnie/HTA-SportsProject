<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/fontawesome-all.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/match/mymatching.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/match/style2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mmatch/mmwriteList.css">
</head>
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/mmatch/mentorwritelist.js"></script>
<style>
#Register, #Apply ,#Deadline {
	float: left;
	color: black;
	font-weight: bold;
	font-size: 20px
}
#view{
	float:right;
}
#delimg{
	color:red
}
.section-title{
	margin-bottom:0px;
}
</style>
<body>
	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp" />

	<!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="single-slider slider-height2 d-flex align-items-center"
			data-background="${pageContext.request.contextPath}/resources/image/mmatch/mypage_mmreq.jpg">
			<div id="user_id" style="display:none;">${USER_ID}</div>
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2 style = "font-family :'나눔고딕'"><b>내 멘토/멘티 신청 현황</b></h2>
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
			<div class="col-lg-8">
				<div class="section lb">
					<div class="container">
						<div class="section-title text-center">

							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									 <i id="Apply" class="fas fa-running">&nbsp;&nbsp;요청(멘토 글) 리스트 
									  <span style="display:inline-block;" id="writingcount1">${listcount1}</span>
									 </i><br>
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">종목</th>
												<th colspan="3" scope="col">수업제목</th>
												<th colspan="3" scope="col">신청자정보</th>
												<th scope="col">요청수락</th>
												<th scope="col">요청거절</th>
											</tr>
										</thead>
										<tbody id="mentorbody">
										<c:if test="${listcount1 > 0 }">
										<c:forEach var="mentor" items="${mentorReqlylist}">
											<tr>
												<td><div class="classalign">${mentor.sports_name}</div></td>	
												<td colspan="3" ><div class="classalign">${mentor.mentor_title}</div></td>
												<td colspan="3" ><div class="classalign">${mentor.user_name}/${mentor.user_mobile}
												</div></td>
												<c:choose>
													 <c:when test="${mentor.match_state == 1}">
														<td><div onclick="javascript:mentorRespRequest(2,'${mentor.user_id}','${mentor.match_code}','${mentor.user_mobile}');" class="submit4">요청수락</div></td>
														<td><div onclick="javascript:mentorRespRequest(3,'${mentor.user_id}','${mentor.match_code}','${mentor.user_mobile}');" class="submit4">요청거절</div></td>
													 </c:when>
													 <c:when test="${mentor.match_state == 2}">
														<td><div class="submit6">수락완료</div></td>
														<td></td>
													 </c:when>
													 <c:when test="${mentor.match_state == 3}">
														<td></td>
														<td><div class="submit6">거절완료</div></td>
													 </c:when>
												</c:choose>
											</tr>
										</c:forEach>
										</c:if>
										<c:if test="${listcount1 == 0 }">
											<tr>
												<td colspan="5" style="text-align: left !important;"><font style="padding-left:10px;" size=5>등록된 글이 없습니다.</font></td>
											<tr>
										</c:if>
										</tbody>
									</table>
								</div>
							</div>
							<br>
							<c:if test="${listcount1 > 0 }">
								<div id="mentorPagination" class="pagination justify-content-center">
									<c:if test="${page <= 1 }">
										<a class="gray"  id="paging">&laquo;</a> 
									</c:if>
									<c:if test="${page > 1 }">	
										<a href="javascript:goMentor(${page -1});" id="paging">&laquo;</a> 		
									</c:if>
									<c:forEach var="a" begin="${startpage1}" end="${endpage1}">
										<c:if test="${a == page }">
											<a class="active" id="paging">${a}</a>	
										</c:if>
										<c:if test="${a != page }">
											<a href="javascript:goMentor(${a});" id="paging">${a}</a>
										</c:if>
									</c:forEach>
									<c:if test="${page >= maxpage1 }">
										<a class="gray" id="paging">&raquo;</a>
									</c:if>
									<c:if test="${page < maxpage1 }">
										<a href="javascript:goMentor(${page+1});" id="paging">&raquo;</a>
									</c:if>					
								</div>
							</c:if>	
							<hr>
							<br>
							<br>
							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									<i id="Register" class="fas fa-running">&nbsp;&nbsp;요청(멘티 글) 리스트 
										<span style="display:inline-block;" id="writingcount2">${listcount2}</span>
									</i><br>
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">종목</th>
												<th colspan="3" scope="col">수업제목</th>
												<th colspan="3" scope="col">신청자정보</th>
												<th scope="col">요청수락</th>
												<th scope="col">요청거절</th>
											</tr>
										</thead>
										<tbody id="menteebody">
										<c:if test="${listcount2 > 0 }">
										<c:forEach var="mentee" items="${menteeReqlylist}">
											<tr>
												<td><div class="classalign">${mentee.sports_name}</div></td>	
												<td colspan="3" ><div class="classalign">${mentee.mentee_title}</div></td>
												<td colspan="3" ><div class="classalign">${mentee.user_name}/${mentee.user_mobile}
												</div></td>
												<c:choose>
													 <c:when test="${mentee.match_state == 1}">
														<td><div onclick="javascript:menteeRespRequest(2,'${mentee.user_id}','${mentee.match_code}','${mentee.user_mobile}');" class="submit4">요청수락</div></td>
														<td><div onclick="javascript:menteeRespRequest(3,'${mentee.user_id}','${mentee.match_code}','${mentee.user_mobile}');" class="submit4">요청거절</div></td>
													 </c:when>
													 <c:when test="${mentee.match_state == 2}">
														<td><div class="submit6">수락완료</div></td>
														<td></td>
													 </c:when>
													 <c:when test="${mentee.match_state == 3}">
														<td></td>
														<td><div class="submit6">거절완료</div></td>
													 </c:when>
												</c:choose>
											</tr>
										</c:forEach>
										</c:if>
										<c:if test="${listcount2 == 0 }">
											<tr>
												<td colspan="5" style="text-align: left !important;"><font style="padding-left:10px;" size=5>등록된 글이 없습니다.</font></td>
											<tr>
										</c:if>
										</tbody>
									</table>
								</div>
							</div>
							<br>
							<c:if test="${listcount2 > 0 }">
								<div id="menteePagination" class="pagination justify-content-center">
									<c:if test="${page <= 1 }">
										<a class="gray"  id="paging">&laquo;</a> 
									</c:if>
									<c:if test="${page > 1 }">	
										<a href="javascript:goMentee(${page -1}); "id="paging">&laquo;</a> 		
									</c:if>
									<c:forEach var="a" begin="${startpage2}" end="${endpage2}">
										<c:if test="${a == page }">
											<a class="active" id="paging">${a}</a>	
										</c:if>
										<c:if test="${a != page }">
											<a href="javascript:goMentee(${a});" id="paging">${a}</a>
										</c:if>
									</c:forEach>
									<c:if test="${page >= maxpage2 }">
										<a class="gray" id="paging">&raquo;</a>
									</c:if>
									<c:if test="${page < maxpage2 }">
										<a href="javascript:goMentee(${page+1});" id="paging">&raquo;</a>
									</c:if>					
								</div>
							</c:if>	
						</div>
						<!-- end title -->
					</div>
					<!-- end container -->
				</div>
				<!-- end section -->
			</div>
		</div>
	</section>
	
  <!-- 멘토 상세보기 modal -->
   <div class="modal" id="detailMentorModal">
		<div class="modal-dialog" style="max-width: 800px;">
			<div class="modal-content">
				<div class="container" style="padding:0px">
					<div id="demo" class="carousel slide" data-ride="carousel">
					
					  <!-- Indicators -->
					  <ul class="carousel-indicators">
					    <li data-target="#demo" data-slide-to="0" class="active"></li>
					    <li data-target="#demo" data-slide-to="1"></li>
					    <li data-target="#demo" data-slide-to="2"></li>
					  </ul>
					  
					  <!-- The slideshow -->
					  <div id="slidePic1" class="carousel-inner">
						<div class="carousel-item active">
						  <img src="${pageContext.request.contextPath}/resources/image/mmatch/test1.jpg" alt="Los Angeles" width="800px" height="350px">
						</div>
						<div class="carousel-item">
						  <img src="${pageContext.request.contextPath}/resources/image/mmatch/test2.jpg" alt="Chicago" width="800px" height="350px">
						</div>
						<div class="carousel-item">
						  <img src="${pageContext.request.contextPath}/resources/image/mmatch/test3.jpg" alt="New York" width="800px" height="350px">
						</div>
					  </div>
					  
					  <!-- Left and right controls -->
					  <a class="carousel-control-prev" href="#demo" data-slide="prev">
					    <span class="carousel-control-prev-icon"></span>
					  </a>
					  <a class="carousel-control-next" href="#demo" data-slide="next">
					    <span class="carousel-control-next-icon"></span>
					  </a>
					</div>				
				
					<br><h2 id="detail_title1" class="mb-30">러닝 가르칩니다.</h2>
					<div style="text-align:left">
					   <div id="mentorAccordion">
						    <div class="card" style="border-bottom:none;">
							      <div class="card-header" style="background-color:white;border-bottom:none;">
							      	  <div>
											<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/detail_class.png" alt="">
											<h4 class="mb-30 element_inline">수업소개</h4>
											<a class="card-link element_inline" data-toggle="collapse" href="#mentorCollapseOne">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="mentorCollapseOne" class="collapse" data-parent="#mentorAccordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li>수업 과목 : <div id="detail_subject1" class="element_inline">러닝</div></li>
								      		<li>수업 시간 :
								      			<div id="detail_time1">
									      		    <div> - 월요일 10:30 ~ 12:30</div>
									      			<div> - 월요일 10:30 ~ 12:30</div>
									      			<div> - 화요일 08:30 ~ 10:30</div>
									      			<div> - 수요일 10:30 ~ 12:30</div>
									      			<div> - 목요일 08:30 ~ 10:30</div>
									      			<div> - 금요일 10:30 ~ 12:30</div>
								      			</div>
								      		</li>
								      		<li>수업 장소 : <div id="detail_loc1" class="element_inline">올림픽 공원</div></li>
								      		<li>수업 가격 : <div id="detila_amount1" class="element_inline">10</div>원</li>
								      	</ul>
								      </div>
							      </div>
						    </div>
						    <div class="card" style="border-bottom:none;">
							      <div class="card-header" style="background-color:white;border-bottom:none;">
							      	  <div>
											<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/detail_person.png" alt="">
											<h4 class="mb-30 element_inline">멘토소개</h4>
											<a class="card-link element_inline" data-toggle="collapse" href="#mentorCollapseTwo">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="mentorCollapseTwo" class="collapse" data-parent="#mentorAccordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li>멘토 이름 : <div id="deatil_name1" class="element_inline">홍길동</div></li>
								      		<li>멘토 경력 :
								      			<div id="detail_career1">
								      				테스트1234
								      			</div>
								      		</li>
								      	</ul>
								      </div>
							      </div>
						    </div>
						    <div class="card">
							      <div class="card-header" style="background-color:white;border-bottom:none;">
							      	  <div>
											<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/detail_caution.png" alt="">
											<h4 class="mb-30 element_inline">주의사항</h4>
											<a class="card-link element_inline" data-toggle="collapse" href="#mentorCollapseThree">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="mentorCollapseThree" class="collapse" data-parent="#mentorAccordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li id="detail_caution1">저희 수업은 고강도 체력 훈련자를 위한 수업이므로 기초 체력이 안되신 힘들 수 있으니 신청에 주의하세요</li>
								      	</ul>
								      </div>
							      </div>
						    </div>
					   </div>
				    </div>
					<br> 
				</div>
			</div>
		</div>
	</div> 

  <!-- 멘티 상세보기 modal -->
   <div class="modal" id="detailMenteeModal">
		<div class="modal-dialog" style="max-width: 800px;">
			<div class="modal-content">
				<div class="container" style="padding:0px">
					<div id="demo" class="carousel slide" data-ride="carousel">
					
					  <!-- The slideshow -->
					  <div id="slidePic2" class="carousel-inner">
						<div class="carousel-item active">
						  <img src="${pageContext.request.contextPath}/resources/image/mmatch/test1.jpg" alt="Los Angeles" width="800px" height="350px">
						</div>
						<div class="carousel-item">
						  <img src="${pageContext.request.contextPath}/resources/image/mmatch/test2.jpg" alt="Chicago" width="800px" height="350px">
						</div>
						<div class="carousel-item">
						  <img src="${pageContext.request.contextPath}/resources/image/mmatch/test3.jpg" alt="New York" width="800px" height="350px">
						</div>
					  </div>
					  
					</div>				
				
					<br><h2 id="detail_title2" class="mb-30">러닝 배웁니다.</h2>
					<div style="text-align:left">
					   <div id="accordion">
						    <div class="card" style="border-bottom:none;">
							      <div class="card-header" style="background-color:white;border-bottom:none;">
							      	  <div>
											<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/detail_class.png" alt="">
											<h4 class="mb-30 element_inline">요청 수업조건</h4>
											<a class="card-link element_inline" data-toggle="collapse" href="#collapseOne">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="collapseOne" class="collapse" data-parent="#accordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li>요청 과목 : <div id="detail_subject2" class="element_inline">러닝</div></li>
								      		<li>요청 시간 :
								      			<div id="detail_time2">
									      		    <div> - 월요일 10:30 ~ 12:30</div>
									      			<div> - 월요일 10:30 ~ 12:30</div>
									      			<div> - 화요일 08:30 ~ 10:30</div>
									      			<div> - 수요일 10:30 ~ 12:30</div>
									      			<div> - 목요일 08:30 ~ 10:30</div>
									      			<div> - 금요일 10:30 ~ 12:30</div>
								      			</div>
								      		</li>
								      		<li>요청 장소 : <div id="detail_loc2" class="element_inline">올림픽 공원</div></li>
								      		<li>요청 가격 : <div id="detila_amount2" class="element_inline">10</div>원</li>
								      		<li>요청 성별 : <div id="detila_gender2" class="element_inline">남</div></li>
								      	</ul>
								      </div>
							      </div>
						    </div>
						    <div class="card">
							      <div class="card-header" style="background-color:white;border-bottom:none;">
							      	  <div>
											<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/detail_caution.png" alt="">
											<h4 class="mb-30 element_inline">기타 요구사항</h4>
											<a class="card-link element_inline" data-toggle="collapse" href="#collapseThree">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="collapseThree" class="collapse" data-parent="#accordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li id="detail_req">부분 조건만 맞아도 가능합니다. 많이 신청 주세요~</li>
								      	</ul>
								      </div>
							      </div>
						    </div>
					   </div>
				    </div>
					<br> 
				</div>
			</div>
		</div>
	</div> 


	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp" />
	<script src="${pageContext.request.contextPath}/resources/js/mmatch/mymmReqlist.js"></script>
	<script>
	
	//멘토 상세정보 보기
    function mentorDetail(code){
    	console.log("code : "+ code);
    	$.ajax({
    		url : "sportDetail",
    		type : "get", 
    		data : {"code":code},
    		dataType : "json",
    		cache : false,
    		success : function(data){
    			var output='';
    			console.log("멘토 상세 성공");
    			
    			$('#detail_title1').text(data.mentor_title);  //수업 타이틀 
    			$('#detail_subject1').text(data.sports_name); //수업 종목 
    			$('#detail_loc1').text(data.city+" "+data.sigungu+" "+data.mentor_loc_detail); //수업 장소
    			$('#detila_amount1').text(data.mentor_amount); //수업 금액
    			$('#deatil_name1').text(data.mentor_name);	  //멘토 이름
    			$('#detail_caution1').text(data.mentor_caution); //수업 주의사항
    			
    			//수업 시간 
    			var times=data.mentor_date.split(",");
    			$('#detail_time1').empty();
    			for(var i=0;i<times.length;i++){
    				var detailTimes=times[i].split("/");
        			output+="<div> - "+detailTimes[0]+"&nbsp;"+detailTimes[1]+"~"+detailTimes[2]+"</div>"
    			}
    			$('#detail_time1').append(output);
    			
    			
    			//업로드 사진 슬라이드 출력
    			output='';
    			$('#slidePic1').empty();
    			if(data.mentor_pic1 == null){
    				output+='<div class="carousel-item active">';
    				output+='<img src="/sports/resources/image/mmatch/default.jpg" alt="no img" width="800px" height="350px">';
    				output+='</div>';
    			}else{
    				var spingurl = "<spring:url value='/matchupload"+data.mentor_pic1+"'/>"; 	
    				output+='<div class="carousel-item active">';
    				output+='<img src="';
    				output+=spingurl;
    				output+='" alt="no img" width="800px" height="350px"/>';
    				output+='</div>';
    			}
    			
    			if(data.mentor_pic2 == null){
    				output+='<div class="carousel-item">';
    				output+='<img src="/sports/resources/image/mmatch/default.jpg" alt="no img" width="800px" height="350px">';
    				output+='</div>';
    			}else{
    				var spingurl = "<spring:url value='/matchupload"+data.mentor_pic2+"'/>"; 	
    				output+='<div class="carousel-item">';
    				output+='<img src="';
    				output+=spingurl;
    				output+='" alt="no img" width="800px" height="350px"/>';
    				output+='</div>';
    			}
    			
    			if(data.mentor_pic3 == null){
    				output+='<div class="carousel-item">';
    				output+='<img src="/sports/resources/image/mmatch/default.jpg" alt="no img" width="800px" height="350px">';
    				output+='</div>';
    			}else{
    				var spingurl = "<spring:url value='/matchupload"+data.mentor_pic3+"'/>"; 	
    				output+='<div class="carousel-item">';
    				output+='<img src="';
    				output+=spingurl;
    				output+='" alt="no img" width="800px" height="350px"/>';
    				output+='</div>';
    			}
    			$('#slidePic1').append(output);  
    			
    			
    			//멘토 경력 (append 대신 text 사용(context에 태그시 이슈)
    			output="<div></div>";
    			$('#detail_career1').empty();
    			var content = data.mentor_career.split(/\n|\r/);
    			for(var i=0; i<content.length; i++){
    				$('#detail_career1').append(output);
    				$("#detail_career1>div").eq(i).text(content[i]);
    				console.log(content[i]);
    			} 
    			
    			$("#detailMentorModal").modal();
    		},
    		error : function(){
    			console.log('에러');
    		}
    	});
    }
	//멘티 상세정보 보기
	function menteeDetail(code){
		console.log("code : "+ code);
		$.ajax({
			url : "menteeDetail",
			type : "get", 
			data : {"code":code},
			dataType : "json",
			cache : false,
			success : function(data){
				var output='';
				console.log("멘티 상세 성공");
				
				$('#detail_title2').text(data.mentee_title);  //수업 타이틀 
				$('#detail_subject2').text(data.sports_name); //요청 종목 
				$('#detail_loc2').text(data.city+" "+data.sigungu+" "+data.mentee_loc_detail); //요청 장소
				$('#detila_amount2').text(data.mentee_amount); //요청 금액
				$('#detail_req2').text(data.mentee_req); 	//요청 요구사항
				$('#detila_gender2').text(data.mentee_gender); //요청 성별
				
				
				//요청 수업 시간 
				var times=data.mentee_date.split(",");
				$('#detail_time2').empty();
				for(var i=0;i<times.length;i++){
					var detailTimes=times[i].split("/");
	    			output+="<div> - "+detailTimes[0]+"&nbsp;"+detailTimes[1]+"~"+detailTimes[2]+"</div>"
				}
				$('#detail_time2').append(output);
				
				
				//업로드 사진 슬라이드 출력
				output='';
				$('#slidePic2').empty();
				if(data.mentee_pic1 == null){
					output+='<div class="carousel-item active">';
					output+='<img src="/sports/resources/image/mmatch/default.jpg" alt="no img" width="800px" height="350px">';
					output+='</div>';
				}else{
					var spingurl = "<spring:url value='/matchupload"+data.mentee_pic1+"'/>"; 	
					output+='<div class="carousel-item active">';
					output+='<img src="';
					output+=spingurl;
					output+='" alt="no img" width="800px" height="350px"/>';
					output+='</div>';
				}
				$('#slidePic2').append(output);  

				$("#detailMenteeModal").modal();
			},
			error : function(){
				console.log('에러');
			}
		});
	}
	</script>
</body>
</html>