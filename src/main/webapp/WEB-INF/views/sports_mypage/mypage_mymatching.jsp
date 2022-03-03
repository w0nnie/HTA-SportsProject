<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/match/mymatch.js"></script>
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
</style>
<body>
	<!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp" />

	<!-- slider Area Start-->
	<div class="slider-area ">
		<!-- Mobile Menu -->
		<div class="single-slider slider-height2 d-flex align-items-center"
			data-background="${pageContext.request.contextPath}/resources/image/sport/sport_banner.png">
			<div id="user_id" style="display:none;">${USER_ID}</div>
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap text-center">
							<h2 style = "font-family :'나눔고딕'"><b>내 매칭 정보</b></h2>
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
									 <a id="Apply" href="#">
									 <i class="fas fa-running"></i>&nbsp;&nbsp;내가 등록한 매칭</a><br>
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">스포츠</th>
												<th scope="col">지역</th>
												<th scope="col">세부지역</th>
												<th scope="col">날짜</th>
												<th scope="col">인원</th>
												<th scope="col">실력</th>
												<th scope="col">상태</th>
												<th scope="col">수정</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="r" items="${RegiList}">
										<div id="REGISTER_NUM" class="classalign" style="display:none;">${r.REGISTER_NUM}</div>
										<div id="sport_num1" class="classalign" style="display:none;">${r.SPORT_NUM}</div>
											<tr>
												<td><div id="sport_num" class="classalign" name="regi_list">${r.SPORT_NUM}</div></td>
												<td><div class="classalign">${r.MATCH_ADR}</div></td>	
												<td><div class="classalign">${r.MATCH_DTL_ADR}</div></td>
												<td><div class="classalign">${r.MATCH_TIME}</div></td>
												<td><div class="classalign">${r.MATCH_PRS}</div></td>
												<td><div class="classalign">${r.MATCH_SKL}</div></td>
												
											<c:if test="${r.REGISTER_STUS == 0}">
												<td><div id="btnSubmit2" onclick="" class="submit5">신청 모집중</div></td>
											</c:if>
											<c:if test="${r.REGISTER_STUS == 1}">
												<td><div id="btnSubmit2" onclick="RegiOk(${r.REGISTER_NUM},${r.SPORT_NUM})" class="submit4">응답하기</div></td>
											</c:if>
											<c:if test="${r.REGISTER_STUS == 0}">
												<td><div id="btnSubmit2" onclick="UpdateClick(${r.REGISTER_NUM})" class="submit5">수정/삭제</div></td>
											</c:if>
											<c:if test="${r.REGISTER_STUS == 1}">
												<td><div id="btnSubmit2" onclick="" class="submit6">수정/삭제</div></td>
											</c:if>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<br>
							<hr>
							<br>

							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									<a id="Register" 
									href="#"
									><i class="fas fa-running"></i>&nbsp;&nbsp;내가 신청한 매칭</a><br>
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">스포츠</th>
												<th scope="col">지역</th>
												<th scope="col">세부지역</th>
												<th scope="col">날짜</th>
												<th scope="col">인원</th>
												<th scope="col">실력</th>
												<th scope="col">상태</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="a" items="${ApplyList}">
											<tr>
												<td><div class="classalign" name="apply_list">${a.SPORT_NUM}</div></td>
												<td><div class="classalign" >${a.MATCH_ADR}</div></td>
												<td><div class="classalign" >${a.MATCH_DTL_ADR}</div></td>
												<td><div class="classalign">${a.MATCH_TIME}</div></td>
												<td><div class="classalign">${a.MATCH_PRS}</div></td>
												<td><div class="classalign">${a.MATCH_SKL}</div></td>
												<td><div id="btnSubmit2" onclick="" class="submit3">응답 대기중</div></td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<br>
							<hr>
							<br>
							<div class="dmoain-pricing">
								<div class="table-responsive-sm">
									<a id="Deadline"><i class="fas fa-running"></i>
									&nbsp;마감 매칭</a><br> 
									<br>
									<table>
										<thead>
											<tr class="domain-head">
												<th scope="col">스포츠</th>
												<th scope="col">등록ID</th>
												<th scope="col">신청ID</th>
												<th scope="col">지역</th>
												<th scope="col">세부지역</th>
												<th scope="col">날짜</th>
												<th scope="col">인원</th>
												<th scope="col">실력</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="d" items="${DeadList}">
											<tr>
												<td><div class="classalign" name="dead_list">${d.SPORT_NUM}</div></td>
												<td><div class="classalign">${d.REGISTER_ID}</div></td>
												<td><div class="classalign">${d.APPLY_ID}</div></td>
												<td><div class="classalign">${d.MATCH_ADR}</div></td>
												<td><div class="classalign">${d.MATCH_DTL_ADR}</div></td>
												<td><div class="classalign">${d.MATCH_TIME}</div></td>
												<td><div class="classalign">${d.MATCH_PRS}</div></td>
												<td><div class="classalign">${d.MATCH_SKL}</div></td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<hr>
						<!-- end title -->
					</div>
					<!-- end container -->
				</div>
				<!-- end section -->
			</div>
		</div>
	</section>
	<!--  수정 모달 -->
	<div id="UpdateModal" class="modal hide" style="display: none;">
	   	 <div class="wrapper">
	        	<div class="container">
	            	<div class="row_subject">매칭수정</div><div id="modal_id" class="modal_id">${USER_ID}</div>
	            	<div id="regi_num" style="display:none;"></div>
            		<div class="row1">
                        <label class="radio radio-sm">
                            <div class="container">
                                <div class="label">Sport</div>
                                 <input id="Sport" class="modal_input" name="Sport" type="text" readonly>
                            </div>
                        </label>
                         <label>
                            <div class="container ">
                                <div class="label">Skill</div>
                        <select id="Skill" name="Skill" class="form-control1">
	                   		<option value="상">상</option>
	                   		<option value="중">중</option>
	                   		<option value="하">하</option>
	                   	</select>
                            </div>
                        </label>
                    </div>
                    <div class="row1">
                        <label class="radio radio-sm">
                            <div class="container">
                                <div class="label">City</div>
                                 <input id="City" class="modal_input" name="City" type="text" readonly>
                            </div>
                        </label>
                         <label>
                            <div class="container ">
                                <div class="label">detail</div>
                                 <input id="Detail" class="modal_input" name="detail" type="text" readonly>
                            </div>
                        </label>
                    </div>
                     <div class="row1">
                        <label>
                            <div class="container">
                                <div class="label">Date</div>
                                 <input id="Date" class="modal_input" name="Date" type="date"  max="2022-12-31">
                            </div>
                        </label>
                         <label>
                            <div class="container">
                                <div class="label">Person</div>
                                 <input style="width : 181.53px;" id="Person" class="modal_input" name="Person" type="number" min="0" max="11" value="">
                            </div>
                        </label>
                    </div>
         		</div>
            <div class="modal_row">
                <div class="modalbutton">
                    <button class="closeModal row btn" onclick="javascript:closeModal1();">닫기</button>
                </div>
                <div class="modalbutton">
                    	<button class="btnSearch row btn btn-fill btn-blue-light" onclick="javascript:deleteModal()">삭제</button>
                </div>
                  <div class="modalbutton">
                    	<button class="btnSearch row btn btn-fill btn-blue-light" onclick="javascript:updateModal()">수정</button>
                </div>
            </div>
        </div>
    </div>
	<script>
	</script>

	<!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp" />

</body>
</html>