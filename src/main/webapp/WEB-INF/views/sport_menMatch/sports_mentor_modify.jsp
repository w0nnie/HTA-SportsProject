<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>멘토 공고 글 수정</title>
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
								<h2>멘토 글 수정</h2>
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
						<form action="mentorModifyAction" method="post" enctype="multipart/form-data">
							<!-- 작성자 (hidden) -->
							<input id="user_id" name="user_id" value="${USER_ID}" type="hidden">
							<!-- 현재 글 (hidden) -->
							<input name="mentor_code" value="${mentordata.mentor_code}" type="hidden">
							<!-- 파일 1,2,3(hidden)-->
							<input type="hidden" name="mentor_pic1" value="${mentordata.mentor_pic1}">
							<input type="hidden" name="mentor_pic2" value="${mentordata.mentor_pic2}">
							<input type="hidden" name="mentor_pic3" value="${mentordata.mentor_pic3}">
														
							<!-- 수업 타이틀  -->
							<div class="row">
								<div class="col-md-4 form-group">
									<label for="mentor_title"><h4>수업 제목</h4></label>
									<input style="width: 1013px" type="text" id="mentor_title" name="mentor_title" 
										class="form-control form-control-lg" placeholder="제목을 입력하세요"
										value="${mentordata.mentor_title}">
								</div>
							</div>
							<br>
			
							<!-- 수업 종목  -->
							<div class="row">
								<div class="col form-group">
									<h4>수업 종목</h4>
									항목&nbsp;
									<select name='sports_category' id="metor_sports_category1">
										<option selected>-- 선택 --</option>
									</select>
									&nbsp;&nbsp;&nbsp;&nbsp;카테고리
									<select name='sports_name' id="metor_sports_category2">
										<option selected>-- 선택 --</option>
									</select>
								</div>
							</div>
							<br>
						
							<!-- 수업 시간  -->
							<div class="row" id="time_row">
								<div class="col form-group">
									<h4 class="element_inline">수업 시간</h4>
									<div class="element_inline" id="addTime">
										<img style="margin-bottom: 8px" src="${pageContext.request.contextPath}/resources/image/mmatch/plus_icon.png" alt="">
									</div>
									<div id="mentor_time_list">
										<div>
											요일&nbsp;
											<select name='mentor_yoil'>
												<option selected>-- 선택 --</option>
											</select>
											&nbsp;&nbsp;&nbsp;
											시작시간 &nbsp;<input name="mentor_startTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>
											&nbsp;&nbsp;&nbsp;
											종료시간 &nbsp;<input name="mentor_endTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>
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
									<h4>수업 장소</h4>
									장소&nbsp;
									<select name='city' id="mentor_loc_category1" >
										<option selected>-- 선택 --</option>
									</select>
									&nbsp;
									<select name='sigungu' id="mentor_loc_category2">
										<option selected>-- 선택 --</option>
									</select>
									&nbsp;
									<input type="text" id="mentor_loc_detail" name="mentor_loc_detail"
											style="width: 647px" placeholder="&nbsp;상세 주소 입력하세요"
											value="${mentordata.mentor_loc_detail}">
								</div>
							</div>
							<br>
				 			
							<!-- 수업 가격 /수업 인원 -->
							<div class="row">
								<div class="col form-group">
									<h4>수업 가격/수업 인원</h4>
									가격&nbsp;
									<input type="text" id="mentor_price" name="mentor_amount"
											value="${mentordata.mentor_amount}"
											style="width: 140px;text-align:right;" 
											>원
									&nbsp;&nbsp;&nbsp;&nbsp;수업 인원&nbsp;
									<input type="text" id="mentor_member_cnt" name="mentor_number"
											value="${mentordata.mentor_number}"
											style="width: 140px;text-align:right;"
											>명
								</div>
							</div>
							<br>
						
							<!-- 수업 주의사항 -->
							<div class="row">
								<div class="col form-group">
									<h4>주의사항</h4>
									<input style="width:1013px;" type="text" id="mentor_caution" 
									       name="mentor_caution" value="${mentordata.mentor_caution}">
								</div>
							</div>
							<br>
								
							<!-- 수업 정보1:성별,이름 -->	
							<div class="row">
								<div class="col form-group">
									<h4>멘토 성별/멘토 이름</h4>
									이름&nbsp;
									<input type="text" id="mentor_name" name="mentor_name"
											value="${mentordata.mentor_name}"
											style="width: 140px;text-align:left;"
											>
									&nbsp;&nbsp;&nbsp;&nbsp;성별&nbsp;
									<select name='mentor_gender' id="mentor_gender">
										<option>-- 선택 --</option>
									<c:if test="${mentordata.mentor_gender =='남'}">
										<option value="남" selected>남자</option>
										<option value="여">여자</option>
									</c:if>
									<c:if test="${mentordata.mentor_gender =='여'}">
										<option value="남">남자</option>
										<option value="여" selected>여자</option>
									</c:if> 
									</select> 
								</div>
							</div>
							<br>	
												
							<!-- 멘토 소개-->
							<div class="row">
								<div class="col-md-11 form-group">
									<h4>멘토 소개</h4>
									<textarea name="mentor_career" id="memtor_introduce" cols="30"rows="10" 
									 class="form-control">${mentordata.mentor_career}</textarea>
								</div>
							</div>
							<hr>
	
							<!--첨부 사진 -->
							<div class="row">
								<div class="col-md-6 form-group">
									<h4>첨부 사진</h4><br>
									첨부1
									<div style="color:red" class="element_inline">(해당 파일은 공고화면에 표시됩니다.)</div>
									<img style="width:15px;" class="remove element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/remove.png"/>
									<div class="custom-file mb-3"  style="width:1013px;" >
	      								<input type="file" class="custom-file-input" id="customFile1" name="uploadfile1">
	      								<label class="custom-file-label" for="customFile1">${mentordata.mentor_origin_pic1}</label>
	      								
	      							</div>
	      							
	    							첨부2
	    							<img style="width:15px;" class="remove element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/remove.png"/>
	    							<div class="custom-file mb-3"  style="width:1013px;" >
	      								<input type="file" class="custom-file-input" id="customFile2" name="uploadfile2">
	      								<label class="custom-file-label" for="customFile2">${mentordata.mentor_origin_pic2}</label>
	      							</div>
	      							
	    							첨부3
	    							<img style="width:15px;" class="remove element_inline" src="${pageContext.request.contextPath}/resources/image/mmatch/remove.png"/>
	    							<div class="custom-file mb-3"  style="width:1013px;" >
	      								<input type="file" class="custom-file-input" id="customFile3" name="uploadfile3">
	      								<label class="custom-file-label" for="customFile3">${mentordata.mentor_origin_pic3}</label>
	      							</div>
								</div>
								
							</div>
							<hr>
							<br>
							<div class="row" style="text-align: center">
								
								<div class="col-12">
									<input type="submit" value="modify"
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
	<script src="${pageContext.request.contextPath}/resources/js/mmatch/mentor_modify.js"></script>
	<script>
		//현재 공고글 정보중 종목 정보를 세팅
		function setSubject(){
			var subject='${mentordata.sports_name}';
			console.log("subject : " + subject);
			$.ajax({
				url : "getsubjectList",
				type : "get", 
				data : {"subject":subject},
				dataType : "json",
				cache : false,
				success : function(data){
					console.log("성공");
					//category1(항목)의 값 선택
					$('#metor_sports_category1').val(data.seltype).prop("selected", true); 
					
					//기존 select option을 전부 제거 
					$('#metor_sports_category2 > option').remove();
					output="<option selected>-- 선택 --</option>";
						
					//ajax로 가져온 list로 option 구성
					$(data.list).each(function(index,item){
							output += '<option value='+"'"+item+"'"+'>'+item+'</option>'
					})
						
					//구성한 option을 append
					$('#metor_sports_category2').append(output)
					
					
					//category1(항목)의 값 선택
					$('#metor_sports_category2').val(subject).prop("selected", true); 
					
				},
				error : function(){
					console.log('에러');
				}
			});
		}
		//현재 공고글 정보중 시간정보를 세팅
		function setTime(){
				var yoilstr='${mentordata.mentor_date}';
				var yoilList=yoilstr.split(",");
				$('#mentor_time_list').empty(output);
				
				for(var i=0; i<yoilList.length; i++){
					var output='<div> 요일&nbsp;'
						  +'  <select name="mentor_yoil">'
						  +'    <option selected>-- 선택 --</option>'
						  +'  </select> &nbsp;&nbsp;&nbsp;시작시간 &nbsp;'
					      +'  <input name="mentor_startTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>'
					      +'  &nbsp;&nbsp;&nbsp;종료시간 &nbsp;'
					      +'  <input name="mentor_endTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>'
					      +'  <div class="element_inline" id="deleteTime">'
						  +'     <img src="/sports/resources/image/mmatch/minus_icon.png" alt="">'							
					      +'  </div>'
					      +'</div>';
					$('#mentor_time_list').append(output);
					addYoilList();
					
					var times=yoilList[i].split("/");
					console.log("yoil : " + times[0]);
					$('#mentor_time_list select').last().val(times[0]).prop("selected", true);
					$('#mentor_time_list > div:last >input').eq(0).val(times[1]).prop("selected", true);
					$('#mentor_time_list > div:last >input').eq(1).val(times[2]).prop("selected", true);

			    }
		}
		//현재 공고글 정보중 장소 정보를 세팅 
		function setLoc(){
			var selsi='${mentordata.city}';
			var selgungu='${mentordata.sigungu}';
			$.ajax({
				url : "dongList",
				type : "get", 
				data : {"selType":selsi},
				dataType : "json",
				cache : false,
				success : function(data){
					if(data.length > 0){
						//기존 select option을 전부 제거 
						$('#mentor_loc_category2 > option').remove();
						output="<option selected>-- 선택 --</option>";
						
						//ajax로 가져온 list로 option 구성
						$(data).each(function(index,item){
							output += '<option value='+"'"+item+"'"+'>'+item+'</option>'
						})
						
						//구성한 option을 append
						$('#mentor_loc_category2').append(output)
						
						//수업장소 select 생성 완료후 si/gungu에 해당 값을 selected로 세팅
						console.log("cal1: " + selsi);
						console.log("cal2: " + selgungu);
						$('#mentor_loc_category1').val(selsi).prop("selected", true);
						$('#mentor_loc_category2').val(selgungu).prop("selected", true);
					}
				},
				error : function(){
					console.log('에러');
				}
			});
	}
	</script>
</body>
</html>