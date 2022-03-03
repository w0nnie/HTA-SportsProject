var yoil_json;
var filecheck; //파일 변경여부를 체크하는 변수
$(function(){
	//select option 정보를 json 파일에서 불러와서 세팅
	initJson();
	initSportList();
	initYoilList();
	
	//select option 정보를 DB 파일에서 불러와서 세팅
	initCityList();
	
	//modify할 값들을 화면에 표시해준다.
	setSubject(); 
	setTime();
	setLoc();
	
	
	//수업 종목(대항목) 선택시 카테고리(소항목)의 option 정보를 갱신
	$('#mentee_sports_category1').change(function(){
		var selType= $("#mentee_sports_category1").val();
		console.log("selectType : " + selType);
		$.ajax({
			url : "sportlist",
			type : "get", 
			data : {"selType":selType},
			dataType : "json",
			cache : false,
			success : function(data){
				if(data.length > 0){
					//기존 select option을 전부 제거 
					$('#mentee_sports_category2 > option').remove();
					output="<option selected>-- 선택 --</option>";
					
					//ajax로 가져온 list로 option 구성
					$(data).each(function(index,item){
						output += '<option value='+"'"+item+"'"+'>'+item+'</option>'
					})
					
					//구성한 option을 append
					$('#mentee_sports_category2').append(output)
				}
			},
			error : function(){
				console.log('에러');
			}
		});
    });
	
	//수업 장소(시) 선택시 카테고리(군구)의 option 정보를 갱신
	$('#mentee_loc_category1').change(function(){
		var selType= $("#mentee_loc_category1").val();
		console.log("selectType : " + selType);
		$.ajax({
			url : "dongList",
			type : "get", 
			data : {"selType":selType},
			dataType : "json",
			cache : false,
			success : function(data){
				if(data.length > 0){
					//기존 select option을 전부 제거 
					$('#mentee_loc_category2 > option').remove();
					output="<option selected>-- 선택 --</option>";
					
					//ajax로 가져온 list로 option 구성
					$(data).each(function(index,item){
						output += '<option value='+"'"+item+"'"+'>'+item+'</option>'
					})
					
					//구성한 option을 append
					$('#mentee_loc_category2').append(output)
				}
			},
			error : function(){
				console.log('에러');
			}
		});
    });
	
	$("#addTime img").click(function(){ //추가 수업날짜 정보 div추가
		 var output='<div> 요일&nbsp;'
			  +'  <select name="mentee_yoil">'
			  +'    <option selected>-- 선택 --</option>'
			  +'  </select> &nbsp;&nbsp;&nbsp;시작시간 &nbsp;'
		      +'  <input name="mentee_startTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>'
		      +'  &nbsp;&nbsp;&nbsp;종료시간 &nbsp;'
		      +'  <input name="mentee_endTime" class="element_inline" style="width:140px;" type="time" class="form-control"/>'
		      +'  <div class="element_inline" id="deleteTime">'
			  +'     <img src="/sports/resources/image/mmatch/minus_icon.png" alt="">'							
		      +'  </div>'
		      +'</div>';
		$('#mentee_time_list').append(output);
		addYoilList();
	});
	
	//취소 버튼 클릭시 이전 페이지로 이동
	$("input[type=button]").click(function(){
		if(confirm("작성을 취소하시겠습니까?")){
			location.href="menteePage";
		}
	});
	
	//submit 버튼 클릭시 유효성 체크 후 submit 수행
	$("input[type=submit]").click(function(){
		
		console.log("user_id : " + $("#user_id").val()); 
		//제목 체크
		if($.trim($("#mentee_title").val()) ==""){
			alert("수업제목을 입력해주세요.");
			$("#mentee_title").focus();
			return false;
		}
		
		//종목 체크
		if($("#mentee_sports_category1").val() =="-- 선택 --"){
			alert("수업 종목(대항목)을 선택해주세요.");
			return false;
		}
		if($("#mentee_sports_category2").val() =="-- 선택 --"){
			alert("수업 카테고리(소항목)를 선택해주세요.");
			return false;
		}
		
		//시간 체크
		var timeCheck=true;
		$("#mentee_time_list>div").each(function(index,item){
			if($(item).children().eq(0).val() =="-- 선택 --"){
				timeCheck = false;
			}
			if($(item).children().eq(1).val() =="" || $(item).children().eq(2).val() ==""){
				timeCheck = false;
			}
		})
		if(timeCheck == false){
			alert("수업 시간 항목을 전부 입력해주세요.");
			return false;
		}
		
		//장소 체크
		if($("#mentee_loc_category1").val() =="-- 선택 --"){
			alert("수업 장소(대항목)을 선택해주세요.");
			return false;
		}
		if($("#mentee_loc_category2").val() =="-- 선택 --"){
			alert("수업 장소(소항목)을 선택해주세요.");
			return false;
		}
		if($.trim($("#mentee_loc_detail").val()) ==""){
			alert("수업 상세 장소를 입력하세요.");
			$("#mentee_loc_detail").focus();
			return false;
		}
		
		//가격 체크
		if($.trim($("#mentee_price").val()) ==""){
			alert("수업 가격을 입력해주세요.");
			$("#mentee_price").focus();
			return false;
		}
		if(Number($("#mentee_price").val()) > 500000){
			alert("수업 가격은 50만 이하로 입력하세요");
			$("#mentee_price").focus();
			return false
		}
		//성별 입력 체크
		if($("#mentee_gender").val() =="-- 선택 --"){
			alert("성별을 선택해주세요");
			return false;
		}
		
		//파일 체크
		if(filecheck == 0 ){
			/*
		 	1.파일 첨부를 변경하지 않은 경우
		 	  파일 첨부를 변경하지 않으면  $('#filevalue').text()의 파일명을
		 	 check 파라미터에 담아 form에 추가하여 전송
		 	2.파일 첨부의 remove 이미지를 클릭한 경우
		 	  파일 첨부의 remove 이미지 클릭하여 파일을 제거하면  
		 	 check 파라미터에 value 값 '' 을 담아 form에 추가하여 전송
			 */  
			value =$(".remove+div > label").text();
			html = "<input type='hidden' value='"+value+"' name='check'>";
		}
	});
	
	
	//파일 유무에 따른 remove 버튼 표시 
	function show(){
		//파일 이름이 있는 경우 remove 이미지 표시 
		//파일 이름이 없는 경우 remove 이미지 미표시
		if($(".remove+div > label").text() == ''){
			$(".remove").css('display','none');
		}
		else{
			$(".remove").css('display','inline');
		}
	}
	
	//파일을 변경한 경우 
	$("input[type=file]").change(function(){
		var id = $(this).attr('id');
		filecheck++;
		show();
	});
	
	//파일 삭제 이미지 버튼 클릭 이벤트
	$(".remove").click(function(){
		$(this).next().children('label').text('');
		show();
	});
	
	show();
});


$("body").on("click","#deleteTime img",function(){ //구성된 수업날짜 div 삭제
	$(this).parent().parent().remove();
});

$(".custom-file-input").on("change", function() { //파일 선택 처리
	  var fileName = $(this).val().split("\\").pop();
	  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});

function initJson() {  //요일(수업시간),항목(수업종목) list가져오기
	  $.ajax({
	     async: false,
	     dataType: "json",
	     url: "../resources/json/mmatch.json",
	     success: function (result) {
	    	 yoil_json = result;
	     }
	  });
}
function setYoilList(){ //셀렉바 구성 메서드
	var yoil = yoil_json.yoil;
	var output='';
	for(var i = 0; i < yoil.length; i++){
		output+='<option value="'+ yoil[i] +'">'+ yoil[i] +'</option>';
	}
	return output;
}
function initYoilList(){//초기 구성된 셀렉바에 옵션 추가
	var output= setYoilList();
	$("#mentee_time_list select").append(output);
}
function addYoilList(){//추가 구성되는 셀렉바에 옵션 추가
	var output= setYoilList();
	$("#mentee_time_list select").last().append(output);
}
function initSportList(){//페이지 로딩되면 수업종목의 항목 셀렉바 옵션 추가
	var sports = yoil_json.sports;
	var output='';
	for(var i = 0; i < sports.length; i++){
		output+='<option value="'+ (i+1) +'">'+ sports[i] +'</option>';
	}
	$("#mentee_sports_category1").append(output);
}

function initCityList(){//페이지 로딩되면 수업장소의 시에 해당되는 항목 셀렉바 옵션 추가
	$.ajax({
		url : "siList",
		type : "get", 
		cache : false,
		async: false,
		success : function(data){
			if(data.length > 0){
				var output="";
				
				//ajax로 가져온 list로 option 구성
				$(data).each(function(index,item){
					output += '<option value='+item+'>'+item+'</option>'
				})
				
				//구성한 option을 append
				$("#mentee_loc_category1").append(output);
			}
		},
		error : function(){
			console.log('에러');
		}
	});
}