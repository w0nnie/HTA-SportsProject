<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 마이 페이지 좌측 side 메뉴들 -->
<div class="container">
  <div class="blog_right_sidebar">
      <aside class="single_sidebar_widget post_category_widget">
          <a href="${pageContext.request.contextPath}/mypage/main" class="d-flex">
              <p style="margin-bottom :0px">마이페이지</p>
           </a>
          <hr>
          <ul>
          	  <li>
                  <a href="${pageContext.request.contextPath}/member/update" class="d-flex">
                      <p>개인정보수정</p>
                  </a>
              </li>
              <li>
                  <a href="${pageContext.request.contextPath}/pm/doughnut" class="d-flex">
                      <p>당일 운동/물섭취</p>
                  </a>
              </li>
               <li>
                  <a href="${pageContext.request.contextPath}/water/calendar" class="d-flex">
                      <p>캘린더</p>
                  </a>
              </li>
              <li>
                  <a href="${pageContext.request.contextPath}/member/info" class="d-flex">
                      <p>내 정보</p>
                  </a>
              </li>
              <li>
                  <a  href="${pageContext.request.contextPath}/Mydeal/main" class="d-flex">
                      <p>내 거래 내역</p>
                  </a>
              </li>
              <li>
                  <a href="${pageContext.request.contextPath}/mypage/mymatching" class="d-flex">
                      <p>내 매칭 정보</p>
                  </a>
              </li>
              <li>
                  <a href="${pageContext.request.contextPath}/mypage/mmwriteList" class="d-flex">
                      <p>내 작성 멘토/멘티</p>
                  </a>
              </li>
              <li>
                  <a href="${pageContext.request.contextPath}/mypage/mmApplyList" class="d-flex">
                      <p>멘티/멘토 신청</p>
                  </a>
              </li>
                            <li>
                   <a href="${pageContext.request.contextPath}/mypage/mmReqList" class="d-flex">
                      <p>멘티/멘토 요청</p>
                  </a>
              </li>
          </ul>
      </aside>
  </div>
</div>