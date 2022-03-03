<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <title>Sport - Soccer </title>
        
     
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/match/style2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/match/style3.css">
<link rel="stylesheet" href="https://www.baro-match.co.kr/newsite/core/css/swiper.css" />
<link rel="stylesheet" href="https://www.baro-match.co.kr/newsite/web/korean/css/topmenu.css?sng=1632462206" />
<link rel="stylesheet" href="https://www.baro-match.co.kr/newsite/web/korean/css/main.css?sng=1632462206" />
<link rel="stylesheet" href="https://www.baro-match.co.kr/newsite/web/korean/css/sub.css?sng=1632462206" />
<link rel="stylesheet" href="https://www.baro-match.co.kr/newsite/system/banner/css/banner.css?sng=1632462206" />
<link rel="stylesheet" href="https://www.baro-match.co.kr/newsite/system/match/css/match.css?sng=1632462206" />
<link rel ="stylesheet" href="${pageContext.request.contextPath}/resources/css/match/sport_match.css">
<style>
	#icon_box .icon01:after{z-index:1;
						content: '';
					    position: absolute;
					    border-top: 10px solid #eb3b04;
					    border-right: 10px solid transparent;
					    border-left: 10px solid transparent;
					    bottom: -9px;
					    left: 45%;
						}
	.rows{text-align:left;}
	.social {cursor: pointer;}
	.social:hover div{color:#eb3b04;
	}
</style>
  </head>
  <body>
  
   	<!-- 헤더 영역  -->
<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
   <main>
   		<div id="sport_num" style="display:none;">1</div>
   		<div id="user_id" style="display:none;">${USER_ID}</div>
       <!-- slider Area Start -->
       <div class="slider-area ">
       	<div id="icon_box">
			<div class="web_size">
				<ul>
					<a href="mainPage"><li class="icon01 top_icon" data-value="1/" style="background-color:#eb3b04;">축구</li></a>
					<a href="baseball" ><li class="icon03 top_icon" data-value="3/">야구</li></a>
					<a href="football"><li class="icon09 top_icon" data-value="9/">족구</li></a>
					<a href="basketball"><li class="icon02 top_icon" data-value="2/">농구</li></a>
					<a href="volleyball"><li class="icon04 top_icon" data-value="4/">배구</li></a>
					<a href="tabletennis"><li class="icon05 top_icon" data-value="5/">탁구</li></a>
					<a href="badminton"><li class="icon06 top_icon" data-value="6/">배드민턴</li></a>
					<a href="tennis"><li class="icon07 top_icon" data-value="7/">테니스</li></a>
					<a href="bowling"><li class="icon010 top_icon" data-value="10/">볼링</li></a>
					<a href="golf"><li class="icon08 top_icon" data-value="8/">골프</li></a>
					<a href="http://ntler.co.kr" target="_blank">
					<li class="icon00 top_icon">맞춤유니폼</li></a>
				</ul>
			</div>
		</div>
		<br>
		<div class="gnb_wrap">
		<div class="web_size">
			<div class="gnb">
				<ul class="m_menu_box">
					<li>
						<div class="social" onclick="javascript:showSocialMatching();"><div style="text-decoration:none; line-height: 45px; font-size: 15px;">소셜매치</div></div>
					</li>
					<li>
						<div class="social" onclick="javascript:showMatchingRegi();"><div style="line-height: 45px; font-size: 15px;">매칭등록</div></div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	</div>
     <div class="slider-active" id="social">
         <div class="single-slider slider-height" data-background="${pageContext.request.contextPath}/resources/image/sport/soccer.jpg">
             <div class="container1">
                 <div class="row d-flex align-items-center justify-content-between">
                     <div class="col-xl-5 col-lg-6 col-md-6 d-none d-md-block">
                         <div class="hero__img" data-animation="bounceIn" data-delay=".4s">
                             <img class="smallsoccer" src="${pageContext.request.contextPath}/resources/image/sport/soccer.jpg" alt="">
                         </div>
                     </div>
                     <div class="col-xl-5 col-lg-5 col-md-5 col-sm-8">
                         <div class="hero__caption">
                             <h1 id="text" data-animation="fadeInRight" data-delay=".6s" style="color: white; font-size: 90px">Social<br>Match<br></h1>
                             <div class="hero__btn" data-animation="fadeInRight" data-delay="1s">
                                 <a href="#" class="btn hero-btn">Play now</a>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
      </div> 
   <div class="main">
       </div>
       <div class="container1">
           <form id="booking-form" class="booking-form"  action="Search" method="POST">
               <div class="form-group">
                   <div class="city ibx">
                       <label for="city" style="color:white;  width: 30%">City</label>
                       <div class="rows">
                       	<select id="city" name="city" class="form-control1" onchange="javascript:initAddress();">
	                       	<option value="" selected>지역</option>
                       	</select>
                       </div>
                   </div>
                   <div class="city_detail ibx">
                       <label for="city" style="color:white;  width: 30%">detail</label>
                       <div class="rows">
                       	<select id="city_detail" name="city_detail" class="form-control1">
                       		<option value="" selected>세부지역</option>
                       	</select>
                       </div>
                   </div>
                   
                   <div id="date" class="form-date-to form-icon ibx">
                       <label for="date_to" style="color:white">Date</label>
                       <input type="date"
									name="match_date" max="2022-12-31"
									id= "match_Date" class="match_Date"
									 >
                   </div>
                   <div id="person" class="form-quantity ibx">
                       <label for="quantity" style="color:white">PERSON</label>
                       <input type="number" name="person" value="0" min="0" max="11" >
                   </div>
                   
                   <div class="skill ibx">
	                   <div class="rows">
	                   <label for="skill" style="color:white;  width: 30%">Skill</label>
	                   	<select id="skill" name="skill" class="form-control1">
	                   		<option value="" selected>실력</option>
	                   		<option value="상">상</option>
	                   		<option value="중">중</option>
	                   		<option value="하">하</option>
	                   	</select>
	                   </div>
                   </div>
                   <c:if test="${empty USER_ID}">
                    <div id="btnSubmit" onclick="location.href='${pageContext.request.contextPath}/member/login'" class="submit ibx">Search&nbsp;&nbsp;</div>
                	</c:if>
                	<c:if test="${!empty USER_ID}">
                   <div id="btnSubmit" onclick="javascript:SearchClick();" class="submit ibx">Search&nbsp;&nbsp;</div>
                   </c:if>
               </div>
           </form>
       </div>
       <!-- 리스트 -->
      <div id="container" class="container">
					<%-- 게시글이 있는 경우--%> 
					<c:if test="${listcount > 0 }">
			<table class="table table-striped">
				<thead>
					<tr>
					   <th colspan="4">Matching list</th>
					   <th colspan="4">
							<font size=3>Total : <a id="all_cnt">${listcount}</a></font>
					   </th>
					</tr>
					<tr>
						<th><div class="classalign">작성자</div></th>
						<th><div class="classalign">지역</div></th>
						<th><div class="classalign">세부지역</div></th>
						<th><div class="classalign">날짜</div></th>
						<th><div class="classalign">인원</div></th>
						<th><div class="classalign">실력</div></th>
						<th><div class="classalign">신청</div></th>
					</tr>	
				</thead>
				<tbody id="search_list">
					<c:set var="num" value="${listcount-(page-1)*limit}"/>	
					<c:forEach var="m" items="${matchlist}">	
						<tr>
							<td><div id="Regi_ID"class="classalign">${m.REGISTER_ID}</div></td>
							<td><div class="classalign">${m.MATCH_ADR}</div></td>
							<td><div class="classalign">${m.MATCH_DTL_ADR}</div></td>	
							<td><div class="classalign">${m.MATCH_TIME}</div></td>
							<td><div class="classalign">${m.MATCH_PRS}</div></td>
							<td><div class="classalign">${m.MATCH_SKL}</div></td>
						<c:if test="${m.REGISTER_ID == USER_ID}">
							<td><div id="btnSubmit2" onclick="javascript:alertApply()" class="submit3">Apply</div></td>
						</c:if>
						<c:if test="${m.REGISTER_ID != USER_ID}">
							<td><div id="btnSubmit2" onclick="javascript:btnApply(${m.REGISTER_NUM});" class="submit2">Apply</div></td>
						</c:if>
						</tr>
							
					</c:forEach>
				 </tbody>	
			</table>
				<div id="center-block" class="center-block">
					  <ul class="pagination justify-content-center">		
						 <c:if test="${page <= 1 }">
							<li class="page-item">
							  <a class="page-link gray">이전&nbsp;</a>
							</li>
						 </c:if>
						 <c:if test="${page > 1 }">			
							<li class="page-item">
							   <a href="mainPage?page=${page-1}" 
							      class="page-link">이전&nbsp;</a>
							</li> 
						 </c:if>
								
						<c:forEach var="a" begin="${startpage}" end="${endpage}">
							<c:if test="${a == page }">
								<li class="page-item " >
								   <a class="page-link gray">${a}</a>
								</li>
							</c:if>
							<c:if test="${a != page }">
							    <li class="page-item">
								   <a href="mainPage?page=${a}" 
								      class="page-link">${a}</a>
							    </li>	
							</c:if>
						</c:forEach>
						
						<c:if test="${page >= maxpage }">
							<li class="page-item">
							   <a class="page-link gray">&nbsp;다음</a> 
							</li>
						</c:if>
						<c:if test="${page < maxpage }">
						  <li class="page-item">
							<a href="mainPage?page=${page+1}" 
							   class="page-link">&nbsp;다음</a>
						  </li>	
						</c:if>
					 </ul>
				</div>
			</c:if>
			<%-- 게시글이 없는 경우--%>
		<div style="text-align:center">
			<c:if test="${listcount == 0 }">
				<font size=5>등록된 글이 없습니다.</font>
			</c:if>
		</div>
	</div>
	
	<!--  등록모달 영역 -->
	<div id="RegisterModal" class="modal hide" style="display: none;">
	   	 <div class="wrapper">
	        	<div class="container">
	            	<div class="row_subject">매칭등록</div><div id="modal_id" class="modal_id">${USER_ID}</div>
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
                                 <input id="Skill" class="modal_input" name="Skill" type="text" value="" readonly>
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
                                 <input id="Date" class="modal_input" name="Date" type="text" value="" readonly>
                            </div>
                        </label>
                         <label>
                            <div class="container">
                                <div class="label">Person</div>
                                 <input id="Person" class="modal_input" name="Person" type="text" value="" readonly>
                            </div>
                        </label>
                    </div>
         		</div>
            <div class="modal_row">
                <div class="modalbutton">
                    <button class="closeModal row btn" onclick="javascript:closeModal1();">닫기</button>
                </div>
                <div class="modalbutton">
                    	<button class="btnSearch row btn btn-fill btn-blue-light" onclick="javascript:registerModal()">등록</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 신청 모달 -->
    <div id="ApplyModal" class="modal hide" style="display: none;">
	   	 <div class="wrapper">
	        	<div class="container">
	            	<div class="row_subject">매칭신청</div><div id="modal_id" class="modal_id">${USER_ID}</div>
	            	<div id="regi_num" style="display:none;"></div>
            		<div class="row1">
                        <label class="radio radio-sm">
                            <div class="container">
                                <div class="label">Sport</div>
                                 <input id="Sport" class="modal_input" name="Sport" type="text" value="" readonly>
                            </div>
                        </label>
                         <label>
                            <div class="container ">
                                <div class="label">Skill</div>
                                 <input id="Skill" class="modal_input" name="Skill" type="text" value="" readonly>
                            </div>
                        </label>
                    </div>
                    <div class="row1">
                        <label class="radio radio-sm">
                            <div class="container">
                                <div class="label">City</div>
                                 <input id="City" class="modal_input" name="City" type="text"  value="" readonly>
                            </div>
                        </label>
                         <label>
                            <div class="container ">
                                <div class="label">detail</div>
                                 <input id="Detail" class="modal_input" name="detail" type="text" value="" readonly>
                            </div>
                        </label>
                    </div>
                     <div class="row1">
                        <label>
                            <div class="container">
                                <div class="label">Date</div>
                                 <input id="Date" class="modal_input" name="Date" type="text" value="" readonly>
                            </div>
                        </label>
                         <label>
                            <div class="container">
                                <div class="label">Person</div>
                                 <input id="Person" class="modal_input" name="Person" type="text" value="" readonly>
                            </div>
                        </label>
                    </div>
         		</div>
            <div class="modal_row">
                <div class="modalbutton">
                    <button class="closeModal row btn" onclick="javascript:closeModal2();">닫기</button>
                </div>
                <div class="modalbutton">
                    	<button class="btnSearch row btn btn-fill btn-blue-light" onclick="javascript:ApplyModal()">신청</button>
                </div>
            </div>
        </div>
    </div>
   <script src="${pageContext.request.contextPath}/resources/js/match/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/match/jquery-ui.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/match/match.js"></script>
   </main>
<!-- Footer 영역  -->
<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
    </body>
</html>