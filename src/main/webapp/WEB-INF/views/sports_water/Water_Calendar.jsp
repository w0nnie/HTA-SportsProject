<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>마이페이지>물섭취량</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="manifest" href="site.webmanifest">-->
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link href='${pageContext.request.contextPath}/resources/calendar/packages/core/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath}/resources/calendar/packages/daygrid/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath}/resources/calendar/packages/timegrid/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/calendar/packages/core/main.js'></script>
<script src='${pageContext.request.contextPath}/resources/calendar/packages/interaction/main.js'></script>
<script src='${pageContext.request.contextPath}/resources/calendar/packages/daygrid/main.js'></script>
<script src='${pageContext.request.contextPath}/resources/calendar/packages/timegrid/main.js'></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
<script>
$(document).ready(function() {
    var calendarEl = document.getElementById('calendar');
    var today = new Date();
    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);
    var dateString = year + '-' + month  + '-' + day;
    var yearMonth=year+"-"+month; 

    var result=getData();
    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid'],
      header: {
  	    left:   '',
	    center: 'title',
	    right:  '',
      },
      defaultDate:dateString,
      //변경
      navLinks: true, // can click day/week names to navigate views
      selectable: false,
      selectMirror: true,
      //update처리(눌렀을 때 반응 처리) 
      select: function(arg) { 
    	console.log(arg);
    	console.log(arg.startStr);
        var title = prompt('물 섭취량:');
        if (title) {
          	calendar.addEvent({
            title: title,
            start: arg.startStr,
            end: arg.endStr,
          })
        }
        calendar.unselect()
      },
      editable: true,
      eventLimit: true, // allow "more" link when too many events
      
     events: result
    });
	
	function getData(){
		 $.ajax({
            url: '${pageContext.request.contextPath}/water/getCalendar',
            data: {"dateString" : dateString
            	  },
            dataType: 'json',
            async:false,
            success: 
                function(result) {

                    items = [];
                   
                    if(result!=null){    
                            $.each(result, function(index, element) {
                             console.log("kcal=" + element.PM_KCAL)
                             if(element.TITLE != null){
                               	 items.push({
                                     title: element.TITLE + "L",
                                     start: element.TIME_START,
                                     color : '#4db151'
                                 }); //.push()
                             }
                             if(element.PM_KCAL !=null){
                            	 items.push({
                                     title: element.PM_KCAL + "kcal",
                                     start: element.PM_DATE,
                                     color : '#cedc4a'
                              }); //.push()
                             }
                             
                             
                        }); //.each()
                    }//if end                           
                                                  
                }//success: function end                          
     }); //ajax end 
     console.log("items:" + items);
     return items;
	}
	
	
    calendar.render();	
    $(".fc-center h2").css("display","none");
    year=$(".fc-center h2").text().split(" ")[1];
    $('#yearMonth').text(year+'년 '+month+'월 ');
    
    $("#prev").click(function(){
    	month=Number(month)-1;
    	if(month==0){
    		month=12;
    		year=Number(year)-1;
    	}
    	console.log(month);
    	calendar.prev();
    	$(".fc-center h2").css("display","none");
    	year=$(".fc-center h2").text().split(" ")[1];
    	$('#yearMonth').text(year+'년 '+month+'월 ');
    });
    
    $("#next").click(function(){
    	month=Number(month)+1;
    	if(month==13){
    		month=1;
    		year=Number(year)+1;
    	}
    	console.log(month);
    	calendar.next();
    	$(".fc-center h2").css("display","none");
    	year=$(".fc-center h2").text().split(" ")[1];
    	$('#yearMonth').text(year+'년 '+month+'월 ');
    });
 
  });


</script>
<style>

  body {
     /* margin: 40px 10px; */
     padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 800px;
    margin: 0 auto;
  }

  #prev,#next {
    -moz-user-select: none;
    text-transform: capitalize;
    color: #fff;
    cursor: pointer;
    display: inline-block;
    font-size: 18px;
    font-weight: 400;
    letter-spacing: 1px;
    line-height: 0;
    margin-bottom: 0;
    padding: 27px 44px;
    border-radius: 25px;
    margin: 10px;
    cursor: pointer;
    transition: color 0.4s linear;
    position: relative;
    z-index: 1;
    border: 0;
    overflow: hidden;
    margin: 0;
  	background-color: #151c3e;
  }
</style>
</head>
<body>
 <!-- slider Area Start-->
    <div class="slider-area ">
        <!-- Mobile Menu -->
        <div class="single-slider slider-height2 d-flex align-items-center" data-background="${pageContext.request.contextPath}/resources/image/water/calendar1.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center">
                            <h2>CALENDAR</h2>
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
    <!-- 마이페이지 중앙 article -->
	<article class="ftco-section">
		<div style="border:1px solid black;">
			<div class="d-flex justify-content-around mb-3" style="margin:16px 0px 0px 0px !important">
		 		<button id="prev" class="p-2 prev btn-dark">이전달</button>
		 		<div id="yearMonth" style="vertical-align: center; font-size: 30px;"></div>
	  			<button id="next" class="p-2 next btn-dark">다음달</button>
	  		</div>
	  		<br>
	  		<br>
	  		<input type="hidden" id="USER_ID" name="USER_ID" value="${USER_ID}"> 
	  		<div id='calendar'></div>
	  		<br>
  		</div>
	</article> 
    </div>
  </div> 
</section>

<!-- Footer 영역  -->
<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>
</body>
</html>