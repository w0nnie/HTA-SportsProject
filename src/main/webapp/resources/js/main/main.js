    $(function() {    
    	//추천 운동 저장 변수
    	var recomm_mise;
		var recomm_weather;
		var recomm_temp;
		var recomm_hour;
		
		//미세먼지 기준
    	var miscutLine = [
			{img:"/sports/resources/image/dust/good.png", min_val:0, max_val:25,comment1:"좋음",comment2:"공기가 매우 좋습니다"}, 
			{img:"/sports/resources/image/dust/normal.png",min_val:26, max_val:50,comment1:"보통",comment2:"그냥 무난한 날이네요"}, 
			{img:"/sports/resources/image/dust/bad.png", min_val:51, max_val:90,comment1:"나쁨",comment2:"외출을 자제 해주세요"}, 
			{img:"/sports/resources/image/dust/worst.png", min_val:91, max_val:300,comment1:"매우나쁨",comment2:"절대로 나가지 마세요"}, 
		];
		

		// Geolocation API에 액세스할 수 있는지를 확인
		function SetCurentloaction(){
			if (navigator.geolocation) {
			 	navigator.geolocation.getCurrentPosition(success, error);
			 } else {
			 	console.log("미지원 에러 발생");
			 }
		}
		function success(position) {
		     const latitude  = position.coords.latitude;
		     const longitude = position.coords.longitude;
		 	 console.log(latitude+","+longitude);
		 	 weather_ajax(latitude,longitude);
		 	 airCondtion_ajax(latitude,longitude);
		 	 airCondtionforecast_ajax(latitude,longitude);
		 	 recommSport();
		 	 console.log("done");
		   }
		function error() {
		   status.textContent = '위치정보를 가져올 수 없습니다.';
		}
				
		//기상(날씨) 정보(현재/예측)
		function weather_ajax(lat,lon){
			var url ="https://api.openweathermap.org/data/2.5/onecall?lat="
					+lat +"&lon="+lon+"&exclude=minutely,alerts,daily&lang=kr&units=metric"
					+"&appid=92eab0693901a9367493c022126b2a78";
			$.ajax({
				url : url,
				type : "get", 
				dataType : "json",
				cache : false,
				async: false,
				success : function(data){
					console.log("성공");
	 				
					//현재 시간 표시 
			    	var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');
					var today = new Date();
			    	var year = today.getFullYear(); // 년도
			    	var month = today.getMonth() + 1;  // 월
			    	var date = today.getDate();  // 날짜
			    	var yoil = week[today.getDay()]; //요일
			    	var hours = today.getHours();  //현재 시간
			    	
			    	//날씨,미세먼지 form에 오늘의 날짜,요일 표시
					$('.date-day').text(year+"년"+month+"월"+date+"일");
			    	$('.date-dayname').text(yoil);
			    	
			    	//전체 수신 로그
					console.log(data.hourly);
			    	
					//온도,강수확률,습도,풍속,날씨 정보를 저장하는 변수
			    	//현 시간 상세 정보
					var temp = parseInt(data.hourly[0].temp);
					var pop = Number(data.hourly[0].pop)*100;
					var windspeed = data.hourly[0].wind_speed;
					var humidity = data.hourly[0].humidity;
					var weather = data.hourly[0].weather[0].main;
					var weather_icon = data.hourly[0].weather[0].icon;
			    	var imgurl="http://openweathermap.org/img/wn/"+weather_icon+".png";
			    	recomm_weather = weather;
			    	recomm_temp = temp;
			    	recomm_hour = hours;
			    	
			    	//현시간 날짜 이미지,온도,상태 표시
					$('#now-weather > img').attr("src",imgurl);
					$('#now-weather > h1').text(temp+"°C");
					$('#now-weather > h3').text(weather);
					
					//현시간 강수확률,습도,풍속 표시
					$('#now-detail  > .precipitation > .value').text(pop+" %");
					$('#now-detail  > .humidity > .value').text(humidity+" °C");
					$('#now-detail > .wind > .value').text(windspeed+" m/s");
					
					//3시간 단위로 예측된 날씨정보를 표시(json list 배열의 3,6,9,12번쨰를 가져와 출력)
					$('#hour_weather >li').each(function(index,item){
						today = new Date();
				    	today.setHours(today.getHours()+((index+1)*3));
				    	hours = today.getHours(); 			    	
				    	//온도/강수확률/풍속/습도/날씨
				    	temp = parseInt(data.hourly[((index+1)*3)].temp);
						weather_icon = data.hourly[((index+1)*3)].weather[0].icon;
				    	
				    	//이미지 변경
				    	imgurl = "http://openweathermap.org/img/wn/"+weather_icon+".png";
				    	$(item).find('img').attr("src", imgurl);
				    	
				    	//시간 값
				    	$(item).children('.day-name').text(hours+"시");
				    	
				    	//온도 값 
				    	$(item).children('.day-temp').text(temp+"°C");

					});
					
				},
				error : function(){
					console.log('에러');
				}
			});
		}
		
	    //미세먼지 현재 정보
		function airCondtion_ajax(lat,lon){
			var url ="http://api.openweathermap.org/data/2.5/air_pollution?lat="
				    +lat+"&lon="+lon+"&appid=92eab0693901a9367493c022126b2a78";
	    	$.ajax({
				url :  url,
				type : "get", 
				dataType : "json",
				cache : false,
				async: false,
				success : function(data){
					console.log("성공");
	 				
			    	//전체 수신 로그
					console.log(data);
			    	
					//미세먼지,초미세먼지,오존 저장
			    	//현 시간 상세 정보
					var mise = parseInt(data.list[0].components.pm10);
					var supermise = parseInt(data.list[0].components.pm2_5);
					var ozone = parseInt(data.list[0].components.o3);
					recomm_mise = mise;
					
			    	//미세먼지,초미세먼지,오존 표시
					$('#now-air  > .precipitation > .value').text(mise+" uM");
					$('#now-air  > .humidity > .value').text(supermise+" uM");
					$('#now-air  > .wind > .value').text(ozone+" mm");


			    	//좌측 이미지,멘티 변경(미세먼지 상태에 따른 이미지 변경)				    	
			    	for(var i=0; i<miscutLine.length;i++){
			    		if(miscutLine[i].min_val<= mise && miscutLine[i].max_val >=mise){
							$('#now-air-condition > img').attr("src", miscutLine[i].img);
							$('#now-air-condition > h1').text(miscutLine[i].comment1);
							$('#now-air-condition > h3').text(miscutLine[i].comment2);
			    			break;
			    		}
			    	}
				},
				error : function(){
					console.log('에러');
				}
			});
		}
		
		//미세먼지 예측 정보
		function airCondtionforecast_ajax(lat,lon){
			var url="http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat="
					+lat+"&lon="+lon+"&appid=92eab0693901a9367493c022126b2a78";
			$.ajax({
				url : url,
				type : "get", 
				dataType : "json",
				cache : false,
				async: false,
				success : function(data){
					console.log("성공");

			    	//전체 수신 로그(json list 배열의 2,5,8,11번쨰를 가져와 출력)
					console.log(data);
					$('#hour_air-condition >li').each(function(index,item){
						var today = new Date();
				    	today.setHours(today.getHours()+(((index+1)*3))); 
				    	var hours = today.getHours(); 	
				    	
				    	//미세먼지 표시
						var mise = parseInt(data.list[((index*3)+2)].components.pm10);
				    	
				    	//이미지 변경(미세먼지 상태에 따른 이미지 변경)				    	
				    	for(var i=0; i<miscutLine.length;i++){
				    		if(miscutLine[i].min_val<= mise && miscutLine[i].max_val >=mise){
				    			$(item).find('img').attr("src", miscutLine[i].img);
				    			break;
				    		}
				    	}
				    	
				    	//시간 값
				    	$(item).children('.day-name').text(hours+"시");
				    	
				    	//온도 값 
				    	$(item).children('.day-temp').text(mise+"㎛");
					});
					
				},
				error : function(){
					console.log('에러');
				}
			});
		}
		
		function recommSport(){
		    //1.미세먼지 좋음 이상   2.날씨가 구름,맑음   3.온도가 12~26도 사이   4.시간이 적정시간대(10~19시)
		    //위조건 만족시 실외운동 추천
		    if(recomm_mise <= 50  &&   
		        (recomm_weather =='Clouds' || recomm_weather =='Clear') &&
		        (recomm_temp >= 12 && recomm_temp <= 26)  &&
		    	(recomm_hour >= 10 && recomm_hour <= 19) ){
		    	recommSport_ajax(2);
		    }else{  //그외는 실내 운동 추천
		    	recommSport_ajax(1);
		    }
		}
		
		function recommSport_ajax(state){
			var url;
			var path = $(location).attr('pathname');
			console.log(state);
			console.log(path); 

			if(path.indexOf("mainPage") == -1){
				url ="main/recommSport";
				console.log("index.jsp로 접속"); 
			}else{
				url ="recommSport";
				console.log("redirect로 접속"); 
			}
			
			$.ajax({
				url : url,
				type : "get", 
				data : {"state":state},
				dataType : "json",
				cache : false,
				async: false,
				success : function(data){
					console.log("성공");
					console.log(data);
					$(".recomm_img").each(function(index){
						console.log(data[index].sports_NAME);
						console.log(data[index].sports_IMG);
						var src ="/sports/resources/image/mmatch/"+data[index].sports_IMG;
						$(this).find('h2').text(data[index].sports_NAME);
						$(this).find('img').attr("src", src);
					});
				},
				error : function(){
					console.log('에러');
				}
			});
		}
		
		//위도경도 얻은 뒤 해당 위치정보로 날씨/대기 정보를 수신 후 상태에 따라 운동 추천
	    SetCurentloaction();
	    
	    //날씨/대기 새로고침 버튼 클릭 이벤트
	    $('.location-button').click(function(){
	    	console.log("새로고침 버튼 클릭");
	    	SetCurentloaction();
	    })
    });