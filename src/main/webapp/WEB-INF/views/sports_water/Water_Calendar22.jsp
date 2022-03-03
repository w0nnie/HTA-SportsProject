<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>마이페이지>물섭취량</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
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

	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      headerToolbar: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
	      },
	      initialDate: 'dayGridMonth',
	      navLinks: true, // can click day/week names to navigate views
	      selectable: true,
	      selectMirror: true,
	      select: function(arg) {
	        var title = prompt('Event Title:');
	        if (title) {
	          calendar.addEvent({
	            title: title,
	            start: arg.start,
	            end: arg.end,
	            allDay: arg.allDay
	          })
	        }
	        calendar.unselect()
	      },
	      eventClick: function(arg) {
	        if (confirm('Are you sure you want to delete this event?')) {
	          arg.event.remove()
	        }
	      },
	      editable: true,
	      dayMaxEvents: true, // allow "more" link when too many events
	      events:
	    calendar.render();
	  });

	</script>
	<style>

	  body {
	    margin: 40px 10px;
	    padding: 0;
	    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	    font-size: 14px;
	  }

	  #calendar {
	    max-width: 1100px;
	    margin: 0 auto;
	  }

	</style>
	</head>
	<body>

	  <div id='calendar'></div>

	</body>
	</html>
