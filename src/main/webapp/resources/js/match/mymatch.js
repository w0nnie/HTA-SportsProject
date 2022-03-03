

$(document).ready(function(){
	setSportName();
});

function setSportName(){
	 $("div[name=regi_list]").each(function(i){
		   var sport_num = $("div[name=regi_list]").eq(i).text();
		   $("div[name=regi_list]").eq(i).text(getSportName(sport_num));
	 });
	 $("div[name=apply_list]").each(function(i){
		   var sport_num = $("div[name=apply_list]").eq(i).text();
		   $("div[name=apply_list]").eq(i).text(getSportName(sport_num));
	 });
	 $("div[name=dead_list]").each(function(i){
		   var sport_num = $("div[name=dead_list]").eq(i).text();
		   $("div[name=dead_list]").eq(i).text(getSportName(sport_num));
	 });
}

function getSportName(num){
	var sendData = {sports_num: num};
	$.ajax({
		type: "POST",
		contentType: "application/json; charset=utf-8;",
		async: false,
		url: "./selSportName",
		data : JSON.stringify(sendData),
		success: function (result) {
			sport_name = result;
		},
		error:function(){
		}
	});
	return sport_name;
}

function RegiOk(Regi_num, sport_num){ //응답하기 버튼 
	var REGISTER_NUM = Regi_num;
	var SPORT_NUM = sport_num;
	console.log(REGISTER_NUM);
	console.log(SPORT_NUM);
	if(confirm('요청에 수락하시겠습니까?')){
		//
		$.ajax({
			type: "post",
			async: false,
			dataType: "json",
			url: "./deadLine",
			data:{
				"REGISTER_NUM": REGISTER_NUM,
				"SPORT_NUM" : SPORT_NUM
			},
			success: function (result) {
				alert("요청수락성공");
				location.reload();
			},
			error:function(request,status,error){
		        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		});
	}else
		return false;
}

function UpdateClick(Regi_num){ //수정삭제 버튼 클릭시 모달에 해당 값 불러오기
	console.log(Regi_num);
	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	var yyyy = today.getFullYear();
	if(dd<10){
	  dd='0'+dd
	} 
	if(mm<10){
	  mm='0'+mm
	} 

	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("Date").setAttribute("min", today);
	
	$.ajax({
		async: false,
		type: "post",
		url: "./selRegi",
		dataType: "json",
		data:{
			"REGISTER_NUM": Regi_num
		},
		success: function (result) {
			console.log(result);
			var num = result[0]["register_NUM"];
			var city =result[0]["match_ADR"];
			var city_detail =result[0]["match_DTL_ADR"];
			var person =result[0]["match_PRS"];
			var date =result[0]["match_TIME"];
			var skill =result[0]["match_SKL"];
			var sport_name = getSportName(result[0]["sport_NUM"]);
			console.log(skill);
			$("#UpdateModal #regi_num").val(num);
			$("#UpdateModal #City").val(city);
			$("#UpdateModal #Detail").val(city_detail);
			$("#UpdateModal #Date").val(date);
			$("#UpdateModal #Person").val(person);
			$("#Skill").val(skill).prop("selected", true);
			$("#UpdateModal #Sport").val(sport_name);
		}, 
		error: function(){
			alert("불러오기실패");
		}
	});
	$("#UpdateModal").css({
		"display" :"block"
	});
}

function updateModal(){
	if(confirm('정말 수정 하시겠습니까?')){
		var Regi_num = $("#UpdateModal #regi_num").val();
		var MATCH_TIME = $("input[name=Date]").val();
		var MATCH_PRS =  $("input[name=Person]").val();
		var MATCH_SKL =	 $("select[name=Skill]").val();
		
		if($.trim($("input[name=Person]").val())=="0"){
			alert("1명이상 입력하세요.");
			$("#RegisterModal").css({
				"display" :"none"
			});
			return false;
		}
		
		$.ajax({
			async: false,
			type: "post",
			url: "./MactingUpdate",
			dataType: "json",
			data:{
	    	   "REGISTER_NUM": Regi_num,
	    	   "MATCH_TIME" : MATCH_TIME,
	    	   "MATCH_PRS" : MATCH_PRS,
	    	   "MATCH_SKL" : MATCH_SKL
			},
			success: function (result) {
					alert('수정 되었습니다.');
					location.reload();
			}, error:function(request,status,error){
		        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }
		});
	}else{
		return false;
	}
}

function deleteModal(){
	if(confirm('정말 삭제 하시겠습니까?')){
		var Regi_num = JSON.parse($("#UpdateModal #regi_num").val());
		$.ajax({
			async: false,
			type: "post",
			url: "./Regidelete",
			dataType: "json",
			data:{
	    	   "REGISTER_NUM": Regi_num,
			},
			success: function (result) {
					alert('삭제 되었습니다.');
					location.reload();
			}, error:function(request,status,error){
		        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }
		});
	}else{
		return false;
	}
	
}

function closeModal1(){
	$("#UpdateModal").css({
		"display" :"none"
	});
}