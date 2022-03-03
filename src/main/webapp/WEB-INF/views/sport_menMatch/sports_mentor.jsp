<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<title>운동 멘티/멘토 매칭</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Inter:400,500,600,700&amp;display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mmatch/mentor_main.css">
</head>
<body>

	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>

	<main> <!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="single-slider slider-height2 d-flex align-items-center"
			data-background="${pageContext.request.contextPath}/resources/image/mainSlide/main_slide03.jpg">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2>운동 멘토 매칭</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider Area End--> 
	
	<!-- 검색 모달 open 영역 -->
	<section id="search_section" style="padding-top: 70px; ">	
		<div class="container">
			<div style="display:inline !important">
				<h1 id="writingcount" style="display:inline !important">${listcount}</h1>명의 멘토가 검색되었습니다.
				( 키워드 : 
				<c:if test="${!empty search_field}">
					<div id="searchkeyword" style="color:red; display:inline !important">${search_field}-${search_word}</div>
				</c:if>
				<c:if test="${empty search_field}">
					<div id="searchkeyword" style="color:red; display:inline !important">전체 검색</div>
				</c:if>
				)
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col">
				  <input type="radio" id="location_sel" name="select" value="1" data-toggle="modal" data-target="#addressModal">
				  <label for="location_sel">
				    <h2>수업지역</h2>
				    <img class="icon-xxxl" src="${pageContext.request.contextPath}/resources/image/mmatch/ic_search_filter_location.png">
				  </label>
				</div>
				<div class="col">
				  <input type="radio" id="subject_sel" name="select" value="2" data-toggle="modal" data-target="#subjectModal">
				  <label for="subject_sel">
				    <h2>전체과목</h2>
				    <img class="icon-xxxl" src="${pageContext.request.contextPath}/resources/image/mmatch/ic_search_filter_class.png">
				 </label>
				</div>
				<div class="col">
				  <input type="radio" id="money_sel" name="select" value="3" data-toggle="modal" data-target="#paymentModal">
				  <label for="money_sel">
				    <h2>전체수업료</h2>
				    <img class="icon-xxxl" src="${pageContext.request.contextPath}/resources/image/mmatch/ic_search_filter_payment.png">
				 </label>
				</div>
				<div class="col">
				  <input type="radio" id="gender_sel" name="select" value="4" data-toggle="modal" data-target="#genderModal">
				  <label for="gender_sel">
				    <h2>전체성별</h2>
				    <img class="icon-xxxl" src="${pageContext.request.contextPath}/resources/image/mmatch/ic_search_filter_sex.png">
				 </label>
				</div>
			</div>
		</div>
	</section>
	
	
	<!-- 주소 필터 modal -->
 	<div class="modal" id="addressModal">
		<div class="modal-dialog">
			<div class="modal-content scroll type2">
				<div class="container">
					<br><h4 class=mb-30>수업지역</h4><hr>
					<div class="row product-btn d-flex justify-content-between">
                        <div class="properties_button">
                            <!--Nav Button  -->
                            <nav>                                                                                                
                                <div class="nav" id="nav-tab-si" role="tablist">
                                </div>
                            </nav>
                            <!--End Nav Button  -->
                        </div>
                	</div>
                	<br>
					<div class="grid">
				    </div>
				    <hr>
				    <input type="hidden" value="location_sel">
				    <div class="mt-40">
						<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal" onclick="javascript:search();">검색하기</button>
						<button style="width:48%" type="button" class="genric-btn danger  circle" data-dismiss="modal" onclick="javascript:searchCancel();">취소하기</button>
					</div>
					
					<br>
				</div>
			</div>
		</div>
	</div> 
	
	<!-- 과목 필터 modal -->
  	<div class="modal" id="subjectModal">
		<div class="modal-dialog">
			<div class="modal-content scroll type2">
				<div class="container">
					<br><h4 class=mb-30>과목</h4><hr>
					<div class="row product-btn d-flex justify-content-between">
                        <div class="properties_button">
                            <nav>                                                                                                
                                <div class="nav" id="nav-tab-lgsubject" role="tablist">
                                </div>
                            </nav>
                        </div>
                	</div>
                	<br>
					<div class="grid">
				    </div>
				    <hr>
				    <input type="hidden" value="subject_sel">
				    <div class="mt-40">
						<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal" onclick="javascript:search();">검색하기</button>
						<button style="width:48%" type="button" class="genric-btn danger  circle" data-dismiss="modal" onclick="javascript:searchCancel();">취소하기</button>
					</div>
					
					<br>
				</div>
			</div>
		</div>
	</div>  

	<!-- 수업료 필터 modal -->
	<div class="modal" id="paymentModal">
		<div class="modal-dialog">
			<div class="modal-content scroll type2">
				<div class="container">
					<br><h4 class=mb-30>수업료</h4><hr>
					<div class="grid">
				    	<label class="card">
							<input class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/money_10.png" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">10만이하</h2>
					            </header>
				        	</div>
				    	</label>
						<label class="card">
							<input class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/money_20.png" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">20만이하</h2>
					            </header>
				        	</div>
				    	</label>
				    	<label class="card">
							<input class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/money_30.png" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">30만이하</h2>
					            </header>
				        	</div>
				    	</label>
				    	<label class="card">
							<input class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/money_40.png" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">40만이하</h2>
					            </header>
				        	</div>
				    	</label>
						<label class="card">
							<input class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/money_50.png" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">50만이하</h2>
					            </header>
				        	</div>
				    	</label>
				    	<label class="card">
							<input class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/money_60.png" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">60만이하</h2>
					            </header>
				        	</div>
				    	</label>
				    	<label class="card">
							<input class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/money_70.png" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">70만이하</h2>
					            </header>
				        	</div>
				    	</label>
				    </div>

				    <hr>  
				    <input type="hidden" value="money_sel">  
				    <div class="mt-40">
						<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal" onclick="javascript:search();">검색하기</button>
						<button style="width:48%" type="button" class="genric-btn danger  circle" data-dismiss="modal" onclick="javascript:searchCancel();">취소하기</button>
					</div>
					<br>
				</div>
			</div>
		</div>
	</div> 
	
	<!-- 성별 필터 modal -->
	<div class="modal" id="genderModal">
		<div class="modal-dialog">
			<div class="modal-content scroll type2">
				<div class="container">
					<br><h4 class=mb-30>성별</h4><hr>
					<div class="grid">
				    	<label class="card">
							<input value="남" class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/gender_male.jpg" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">남성</h2>
					            </header>
				        	</div>
				    	</label>
				    	<label class="card">
							<input value="여" class="card__input" type="checkbox"/>
				        	<div class="card__body">
				            	<div class="card__body-cover">
					            	<img class="card__body-cover-image" src="${pageContext.request.contextPath}/resources/image/mmatch/gender_female.jpg" />
					            	<span class="card__body-cover-checkbox"> 
					            		<svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">
					                		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>
					                    </svg>
					                 </span>
				                </div>
					            <header class="card__body-header">
					                <h2 class="card__body-header-title">여자</h2>
					            </header>
				        	</div>
				    	</label>
				    </div>
				    <hr>
				    <input type="hidden" value="gender_sel">  
				    <div class="mt-40">
						<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal" onclick="javascript:search();">검색하기</button>
						<button style="width:48%" type="button" class="genric-btn danger circle" data-dismiss="modal" onclick="javascript:searchCancel();">취소하기</button>
					</div>
					<br>
				</div>
			</div>
		</div>
	</div> 
	
	
	<!-- mentor 공고글 리스트 -->
	<section class="latest-product-area latest-padding" style="padding-top: 70px;">
		<div class="container">
			<hr><br><br><br>
			<div class="tab-content" id="nav-tabContent">
				<!-- card one -->
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<div class="row">
						<c:if test="${listcount > 0 }">
							<c:forEach var="mentor" items="${mentorlist}">
								<div class="col-xl-4 col-lg-4 col-md-6">
									<div class="single-product mb-60" style="border: 2px solid black;">
										<div class="product-img">
											<a href="javascript:detail('${mentor.mentor_code}');" >
												<c:if test="${mentor.mentor_pic1 == null}">
													<img  style="height:250px" src="${pageContext.request.contextPath}/resources/image/mmatch/default.jpg" alt="">
												</c:if>
												<c:if test="${mentor.mentor_pic1 != null}">
													<img  style="height:250px" src="<spring:url value='/matchupload${mentor.mentor_pic1}'/>" alt=""/>
												</c:if>
											</a>
										</div>
										<div class="product-caption">
											<h4><b>${mentor.mentor_title}</b></h4>
											<div class="price">
												<table class="table">
													<tr>
														<th>종목</th>
														<td>${mentor.sports_name}</td>
													</tr>
													<tr>
														<th>장소</th>
														<td>${mentor.city}&nbsp;${mentor.sigungu}</td>
													</tr>
													<tr>
														<th>인원</th>
														<td>${mentor.mentor_number}명</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:if>
						<c:if test="${listcount == 0 }">
							<font style="padding-left:10px;" size=5>등록된 글이 없습니다.</font>
						</c:if>
					</div>
					<hr>
					<!-- 작성자 (hidden) -->
					<input id="user_id" name="user_id" value="${USER_ID}" type="hidden" >
					<div id="write-b">
						<c:if test="${empty USER_ID}">
							<a href="${pageContext.request.contextPath}/member/login"
								class="btn header-btn">글쓰기</a>
						</c:if>
						<c:if test="${!empty USER_ID}">
							<a href="${pageContext.request.contextPath}/mmatch/mentorWrite"
								class="btn header-btn">글쓰기</a>
						</c:if>
					</div>
					<div class="pagination justify-content-center">
						<c:if test="${page <= 1 }">
							<a class="gray" href="javascript:go(${page -1});" id="paging">&laquo;</a> 
						</c:if>
						<c:if test="${page > 1 }">	
							<a href="#" id="paging">&laquo;</a> 		
						</c:if>
						<c:forEach var="a" begin="${startpage}" end="${endpage}">
							<c:if test="${a == page }">
								<a class="active" id="paging">${a}</a>	
							</c:if>
							<c:if test="${a != page }">
								<a href="javascript:go(${a});" id="paging">${a}</a>
							</c:if>
						</c:forEach>
						<c:if test="${page >= maxpage }">
							<a class="gray" id="paging">&raquo;</a>
						</c:if>
						<c:if test="${page < maxpage }">
							<a href="javascript:go(${page+1});" id="paging">&raquo;</a>
						</c:if>					
					</div>
			   </div>
		   </div>
	   </div>
	</section>
	
   <!-- 상세보기 modal -->
   <div class="modal" id="detailModal">
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
					  <div id="slidePic" class="carousel-inner">
					  </div>
					  
					  <!-- Left and right controls -->
					  <a class="carousel-control-prev" href="#demo" data-slide="prev">
					    <span class="carousel-control-prev-icon"></span>
					  </a>
					  <a class="carousel-control-next" href="#demo" data-slide="next">
					    <span class="carousel-control-next-icon"></span>
					  </a>
					</div>				
				
					<br><h2 id="detail_title" class="mb-30">수업타이틀</h2>
					<div style="text-align:left">
					   <div id="accordion">
						    <div class="card" style="border-bottom:none;">
							      <div class="card-header" style="background-color:white;border-bottom:none;">
							      	  <div>
											<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/detail_class.png" alt="">
											<h4 class="mb-30 element_inline">수업소개</h4>
											<a class="card-link element_inline" data-toggle="collapse" href="#collapseOne">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="collapseOne" class="collapse" data-parent="#accordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li>수업 과목 : <div id="detail_subject" class="element_inline">수업종목</div></li>
								      		<li>수업 시간 :
								      			<div id="detail_time">
									      		    수업시간정보
								      			</div>
								      		</li>
								      		<li>수업 장소 : <div id="detail_loc" class="element_inline">수업장소정보</div></li>
								      		<li>수업 가격 : <div id="detila_amount" class="element_inline">수업가격정보</div>원</li>
								      	</ul>
								      </div>
							      </div>
						    </div>
						    <div class="card" style="border-bottom:none;">
							      <div class="card-header" style="background-color:white;border-bottom:none;">
							      	  <div>
											<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/detail_person.png" alt="">
											<h4 class="mb-30 element_inline">멘토소개</h4>
											<a class="card-link element_inline" data-toggle="collapse" href="#collapseTwo">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="collapseTwo" class="collapse" data-parent="#accordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li>멘토 이름 : <div id="deatil_name" class="element_inline">이름</div></li>
								      		<li>멘토 경력 :
								      			<div id="detail_career">
								      			경력
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
											<a class="card-link element_inline" data-toggle="collapse" href="#collapseThree">
										  		<img class="icon_img element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/arrow_down.png" alt="">  
								      		</a>
									  </div>   
								  </div>
								 <div id="collapseThree" class="collapse" data-parent="#accordion">
								      <div class="card-body" style="padding-top: 0px;">
								      	<ul style="font-size:20px;padding-left: 20px">
								      		<li id="detail_caution">수업주의사항</li>
								      	</ul>
								      </div>
							      </div>
						    </div>
					   </div>
				    </div>
				    <div id="detail_btn" class="mt-40">
<!-- 						<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal">신청하기</button>
						<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal">수정하기</button>
						<button style="width:48%" type="button" class="genric-btn danger  circle" data-dismiss="modal">삭제하기</button> -->
					</div>
					<br> 
				</div>
			</div>
		</div>
	</div> 
	
	</main>
	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/js/mmatch/mentor_main.js"></script>
	<script>
		//글 작성 ,글 수정 이벤트 결과를 alert으로 출력 
		var result="${result}";
		if(result == 'writeSuccess'){
			alert("글 작성을 완료했습니다.");
		}else if(result == 'modifySuccess'){
			alert("글 수정을 완료했습니다.");
		}
		//화면처리 ajax
		function ajax(sdata){
			console.log(sdata);
			output = "";
			$.ajax({
				url : "mentorPage_ajax",
				type : "get", 
				data : sdata,
				dataType : "json",
				cache : false,
				success : function(data){
					//멘토 게시글 컨텐츠 삭제
					$('#nav-home > .row').empty(); 
					
					//pagination 삭제
					$(".pagination").empty();
					
					//검색 결과 갯수와 검색키워드 표시
					$('#writingcount').text(data.listcount);
					if(data.search_field != ''){  //검색 키워드가 있으면 
						$('#searchkeyword').text(data.search_field+'-'+data.search_word);
					}else{ 						  //검색 키워드가 없으면
						$('#searchkeyword').text("전체 검색");
					}
					
					
					if(data.listcount > 0 ){
						var output='';
						//ajax로 가져온 list로 col 구성 
						$(data.mentorlist).each(function(index,item){
						  output+='<div class="col-xl-4 col-lg-4 col-md-6">'
							     +  '<div class="single-product mb-60" style="border: 2px solid black;">'
								 +    '<div class="product-img">'
								 +      '<a href="javascript:detail('+"'"+ item.mentor_code+"'" +');">';
						  if(item.mentor_pic1 == null){ //사진이없으면 default 사진을 출력
						    output+=       '<img style="height:250px" src="/sports/resources/image/mmatch/default.jpg" alt="">';
						  }else{  //사진이 있으면 해당 사진으로 출력
						    output+=       '<img style="height:250px" src="<spring:url value="/matchupload'+item.mentor_pic1+'"/>" alt=""/>'; 
						  }
						 output+='       </a>'
								 +    '</div>'
								 +    '<div class="product-caption">'
								 +	    '<h4><b>'+item.mentor_title+'</b></h4>'
								 +	    '<div class="price">'
								 +		   '<table class="table">'
								 +			  '<tr><th>종목</th><td>'+item.sports_name+'</td></tr>'
								 +			  '<tr><th>장소</th><td>'+item.city+'&nbsp;'+item.sigungu+'</td></tr>'
								 +			  '<tr><th>인원</th><td>'+item.mentor_number+'명</td></tr>'
								 +		   '</table>'
								 +	    '</div>'
								 +    '</div>'
							     +  '</div>'
						         +'</div>';
						});
						//해당 결과를 append
						$('#nav-home > .row').append(output); 
						
						
						//pagination 시작
						output = "";
						
						digit = '&laquo;';
						href="";
						if(data.page > 1){
							href = 'href=javascript:go('+(data.page-1) + ')';
						}
						output += setPaging(href,digit);
						
						for(var i = data.startpage; i<=data.endpage; i++){
							digit=i;
							href="";
							if(i !=data.page){
								href='href=javascript:go('+i+')';
							}
							else{
								href='class="active"';
							}
							output += setPaging(href,digit);
						}
						
						digit = '&raquo;';
						href="";
						if(data.page < data.maxpage){
							href = 'href=javascript:go('+(data.page+1) + ')';
						}
						output += setPaging(href,digit);
						$('.pagination').append(output);
					}
					else{
						//등록글 없음 표시 붙이기
						output='<font style="padding-left:10px;" size=5>등록된 글이 없습니다.</font>';
						$('#nav-home > .row').append(output); 
					}
				},
				error : function(){
					console.log('에러');
				}
			});
		}
		
		//상세정보 보기
		function detail(code){
			console.log("code : "+ code);
			$.ajax({
				url : "sportDetail",
				type : "get", 
				data : {"code":code},
				dataType : "json",
				cache : false,
				success : function(data){
					var output='';
					console.log("성공");
					
					$('#detail_title').text(data.mentor_title);  //수업 타이틀 
					$('#detail_subject').text(data.sports_name); //수업 종목 
					$('#detail_loc').text(data.city+" "+data.sigungu+" "+data.mentor_loc_detail); //수업 장소
					$('#detila_amount').text(data.mentor_amount); //수업 금액
					$('#deatil_name').text(data.mentor_name);	  //멘토 이름
					$('#detail_caution').text(data.mentor_caution); //수업 주의사항
					
					//수업 시간 
					var times=data.mentor_date.split(",");
					$('#detail_time').empty();
					for(var i=0;i<times.length;i++){
						var detailTimes=times[i].split("/");
		    			output+="<div> - "+detailTimes[0]+"&nbsp;"+detailTimes[1]+"~"+detailTimes[2]+"</div>"
					}
					$('#detail_time').append(output);
					
					
					//업로드 사진 슬라이드 출력
					output='';
					$('#slidePic').empty();
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
					$('#slidePic').append(output);  
					
					
					//멘토 경력 (append 대신 text 사용(context에 태그시 이슈)
					output="<div></div>";
					$('#detail_career').empty();
					var content = data.mentor_career.split(/\n|\r/);
					for(var i=0; i<content.length; i++){
						$('#detail_career').append(output);
						$("#detail_career>div").eq(i).text(content[i]);
						console.log(content[i]);
					} 
					
					//버튼 표시
					if($('#user_id').val() != data.user_id){ //작성자가 아니면
						$('#detail_btn').empty();
						output='<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal" onclick="javascript:apply('+"'"+data.mentor_code+"'"+');">신청하기</button>';
						$('#detail_btn').append(output);                                                                    
					}else{ //해당 글의  작성자면
						$('#detail_btn').empty();
						output='<button style="width:48%" type="button" class="genric-btn info circle" data-dismiss="modal" onclick="javascript:modify('+"'"+data.mentor_code+"'"+');">수정하기</button>'
						      +'<button style="width:48%" type="button" class="genric-btn danger  circle" data-dismiss="modal" onclick="javascript:del('+"'"+data.mentor_code+"'"+');">삭제하기</button> ';
						$('#detail_btn').append(output);						
					}
					 $("#detailModal").modal();
				},
				error : function(){
					console.log('에러');
				}
			});
		}
	</script>
</body>
</html>