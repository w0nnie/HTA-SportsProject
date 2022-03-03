
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
document.getElementById("match_Date").setAttribute("min", today);

var sport_name= null;

$(document).ready(function(){
	  initJson();//json 파일 가져오는 함수
	  initPage();//city 세팅해주는 함수
	  initSport();
});

function logNow(logContents){
	console.log(logContents);
}


function initSport(){
	var sport_num = Number($("#sport_num").text());
	var sendData = {sports_num: sport_num};
	
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
}

var address_json = null;//전역으로 사용
function initJson() {
	  $.ajax({
	     async: false,
	     dataType: "json",
	     url: "../resources/json/address.json",//이 주소에서
	     success: function (result) {//결과가져오기 > object형태임 > 로그보셈
	    	 address_json = result;
	     }
	  });
}

function initPage(){//페이지 로딩되면 city 셀렉바 옵션 추가
	var city = address_json.city;
	for(var i = 0; i < city.length; i++){
		$("#city").append('<option value="'+ i +'">'+ city[i] +'</option>');
	}
}

function initAddress(){//선택된 city에 해당하는 디테일 주소 초기화 //city 변경될때마다 = onchange 될때마다 함수호출
	$("#city_detail option").remove();//기존 옵션 내용 초기화
	
	var tmp_txt = "city_detail_" + $("#city").val();;//선택된 city에 해당하는 json 파일의 key값 스트링으로 생성
	eval("var address_detail = address_json." + tmp_txt);//eval > 코드로 인식해주는 함수
	//var address_detail = address_json.city_detail_@ 
	//@에 숫자 들어간 형태로 코드생성 > json에서 해당 키값에 해당하는 데이터 가져옴
	$("#city_detail").append('<option value="">&nbsp;세부지역&nbsp;&nbsp;</option>');//옵션 첫 디폴트값 생성
	for(var i = 0; i < address_detail.length; i++){//디테일 지역 옵션 추가
		$("#city_detail").append('<option value="'+ i +'">'+ address_detail[i] +'</option>');
	}
}

function showSocialMatching(){
	console.log("소셜매칭");
	$("#container").show();
	$("#btnSubmit").attr("onclick", "SearchClick();");
	$("#text").html("Social<br>Match<br>");
	$("#btnSubmit").html("Search&nbsp&nbsp;");
	$("#city option:eq(0)").prop("selected", true); //값이 1인 option 선택
	$("#city_detail option:eq(0)").prop("selected", true);
	$("#date").find('input[type=date]').each(function(){
		$(this).val('');
	});
	$("#person").find('input[type=number]').each(function(){
		$(this).val(0);
	});
	$("#skill option:eq(0)").prop("selected", true);
}

function showMatchingRegi(){
	console.log("매칭등록"); //매칭등록
	$("#container").hide(); //게시판 
	$("#btnSubmit").attr("onclick", "RegiClick();");
	$("#text").html("Match<br>Reigster<br>");
	$("#btnSubmit").html("Reigster");
	$("#city option:eq(0)").prop("selected", true); //값이 1인 option 선택
	$("#city_detail option:eq(0)").prop("selected", true);
	$("#date").find('input[type=date]').each(function(){
		$(this).val('');
	});
	$("#person").find('input[type=number]').each(function(){
		$(this).val(0);
	});
	$("#skill option:eq(0)").prop("selected", true);  //초기값 설정
}

var m_search_list;
function SearchClick(){
	var user_id = $("#user_id").text();   //로그인 유효성검사
	if(user_id == ""){
		location.href="/sports/member/login";
	}else{
		console.log("소셜매칭 클릭");
		var String ="";
		var SPORT_NUM = Number($("#sport_num").text());
		var MATCH_ADR = $("#city option:checked").text();
		var MATCH_DTL_ADR = $.trim($("#city_detail option:checked").text());
		var MATCH_TIME = $("input[name=match_date]").val();
		var MATCH_PRS = $("input[name=person]").val();
		var MATCH_SKL = $("select[name=skill]").val();
		$.ajax({
			async: false,
			type: "get",
			url: "./SearchList",
			dataType:"json",
			data:{
			   "SPORT_NUM" : SPORT_NUM,
	    	   "MATCH_ADR" : MATCH_ADR,
	    	   "MATCH_DTL_ADR" : MATCH_DTL_ADR,
	    	   "MATCH_TIME" : MATCH_TIME,
	    	   "MATCH_PRS" : MATCH_PRS,
	    	   "MATCH_SKL" : MATCH_SKL
			},
			success: function (result) {
				m_search_list = result;
				console.log(m_search_list);
				showSearchList(1);
			}, error: function(){
				alert('하나 이상의 검색어를 선택해주세요.');
			}
		});
	}
}

function showSearchList(page){
	$("#all_cnt").text(m_search_list.length);
	$("#center-block").html(""); //좀따 위치 수정 요망
	$("#search_list").html("");
	var user_id = $("#user_id").text();
	var start = ((page - 1) * 5); //Array는 0부터 시작 
	var end =  (page * 5) - 1;
	if (end >= m_search_list.length) end = m_search_list.length - 1;
	var table_string = "";
	for(var i = start; i <= end; i++){
		table_string += 
			'<tr>'+
				'<td><div class="classalign">'+ m_search_list[i]["register_ID"] +'</div></td>'+
				'<td><div class="classalign">'+ m_search_list[i]["match_ADR"] +'</div></td>'+
				'<td><div class="classalign">'+ m_search_list[i]["match_DTL_ADR"] +'</div></td>'+	
				'<td><div class="classalign">'+ m_search_list[i]["match_TIME"] +'</div></td>'+
				'<td><div class="classalign">'+ m_search_list[i]["match_PRS"] +'</div></td>'+
				'<td><div class="classalign">'+ m_search_list[i]["match_SKL"] +'</div></td>';
		if([i]["register_ID"]==user_id){
			table_string +=
				'<td><div id="btnSubmit2" onclick="javascript:alertApply();" class="submit3">Apply</div></td>';
			//비활성화
		}else{
			table_string +=
				'<td><div id="btnSubmit2" onclick="javascript:btnApply('+m_search_list[i]["register_NUM"]+');" class="submit2">Apply</div></td>';
		}
		table_string += '</tr>';
	}
	$("#search_list").html(table_string);
	pageNavigation(m_search_list.length, page);
}

function pageNavigation(listcount, page){
	var limit = 5; // 한 화면에 출력할 레코드 갯수
	var maxpage = Math.floor((listcount + limit - 1) / limit); //총페이지 수
	var startpage = (Math.floor((page - 1) /5))* 5 + 1; //현재 페이지에 보여줄 시작 페이지 수(1,6,11, 등..)
	var endpage = startpage + 5 - 1; //현재 페이지에 보여줄 마지막 페이지 수 (5,10,maxpage 등..)
	if(endpage > maxpage) endpage = maxpage;
	
	var html_string = "";
	if(listcount >0){
		html_string += 
			'<ul class="pagination justify-content-center">';
			if(page <= 1 ){
				html_string +=
					'<li class="page-item">'+
						'<a class="page-link gray">이전&nbsp;</a>'+
					'</li>';
			}else{
				html_string +=
					'<li class="page-item">'+
						'<a href="javascript:showSearchList('+ (page-1) +')" class="page-link">이전&nbsp;</a>'+
					'</li>';
			}
			for(var a = startpage; a <= endpage; a++){
				if(a == page){
					html_string +=
						'<li class="page-item " >'+
							'<a class="page-link gray">'+ a +'</a>'+
						'</li>';
				}else{
					html_string +=
						'<li class="page-item">'+
						  	'<a href="javascript:showSearchList('+ a +')" class="page-link">'+ a +'</a>'+
					    '</li>';
				}
					
			}
			if(page >= maxpage){
				html_string +=
					'<li class="page-item">'+
					   	'<a class="page-link gray">&nbsp;다음</a>'+
					'</li>';
			}else{
				html_string +=
					'<li class="page-item">'+
				  		'<a href="javascript:showSearchList('+ (page+1) +')" class="page-link">&nbsp;다음</a>'+
				  	'</li>';
			}
			html_string += '</ul>';
	}else{
		html_string += 
			'<font size=5 style="text-align:center">등록된 글이 없습니다.</font>'
	}	
	$("#center-block").html(html_string);
}


function RegiClick(){
	var user_id = $("#user_id").text();
	if(user_id == ""){
		location.href="/sports/member/login";
	}else{
		console.log("매칭등록 클릭");
		var sport =  sport_name;
		var city = $("#city option:checked").text();
		var city_detail = $("#city_detail option:checked").text();
		var date = $("input[name=match_date]").val();
		var person = $("input[name=person]").val();
		var skill = $("select[name=skill]").val();
		
		$("#RegisterModal #Sport").val(sport);
		$("#RegisterModal #City").val(city);
		$("#RegisterModal #Detail").val(city_detail);
		$("#RegisterModal #Date").val(date);
		$("#RegisterModal #Skill").val(skill);
		$("#RegisterModal #Person").val(person);
		$("#RegisterModal").css({
			"display" :"block"
		});
	}
}

function btnApply(Regi_num){
	console.log(Regi_num);
	var user_id = $("#user_id").text();
	if(user_id == ""){
		location.href="/sports/member/login";
	}else{
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
				$("#ApplyModal #regi_num").val(num);
				$("#ApplyModal #City").val(city);
				$("#ApplyModal #Detail").val(city_detail);
				$("#ApplyModal #Date").val(date);
				$("#ApplyModal #Skill").val(skill);
				$("#ApplyModal #Person").val(person);
				//ApplyModal(num);
			}, 
			error: function(){
				alert("Apply실패");
			}
		});
		
		var sport =  sport_name;
		$("#ApplyModal #Sport").val(sport);
		
		
		$("#ApplyModal").css({
			"display" :"block"
		});
	}
}

function alertApply(){
	alert("자신이 등록한 글입니다.");
}

function closeModal1(){
	$("#RegisterModal").css({
		"display" :"none"
	});
}

function closeModal2(){
	$("#ApplyModal").css({
		"display" :"none"
	});
}

function registerModal(){ //레지스터모달(모달등록버튼) 눌렀을때 이벤트
	var REGISTER_ID = $("#modal_id").text();
	var SPORT_NUM = $("#sport_num").text();
	var MATCH_ADR = $("#city option:checked").text();
	var MATCH_DTL_ADR = $("#city_detail option:checked").text();
	var MATCH_TIME = $("input[name=match_date]").val();
	var MATCH_PRS = $("input[name=person]").val();
	var MATCH_SKL = $("select[name=skill]").val();
	
	if($.trim($("#city option:checked").text())=="지역"){
		alert("지역을 선택하세요.");
		$("#RegisterModal").css({
			"display" :"none"
		});
		return false;
	}
	
	if($.trim($("#city_detail option:checked").text())=="세부지역"){
		alert("세부지역을 선택하세요.");
		$("#RegisterModal").css({
			"display" :"none"
		});
		return false;
	}
	
	if($.trim($("input[name=match_date]").val())==""){
		alert("날짜를 선택하세요.");
		$("#RegisterModal").css({
			"display" :"none"
		});
		return false;
	}
	
	if($.trim($("input[name=person]").val())=="0"){
		alert("1명이상 입력하세요.");
		$("#RegisterModal").css({
			"display" :"none"
		});
		return false;
	}
	
	if($.trim($("select[name=skill]").val())==""){
		alert("실력을 선택하세요.");
		$("#RegisterModal").css({
			"display" :"none"
		});
		return false;
	}
	
	$.ajax({
		async: false,
		type: "post",
		url: "./Regi",
		dataType: "text",
		data:{
    	   "REGISTER_ID": REGISTER_ID,
    	   "SPORT_NUM" : SPORT_NUM,
    	   "MATCH_ADR" : MATCH_ADR,
    	   "MATCH_DTL_ADR" : MATCH_DTL_ADR,
    	   "MATCH_TIME" : MATCH_TIME,
    	   "MATCH_PRS" : MATCH_PRS,
    	   "MATCH_SKL" : MATCH_SKL
		},
		success: function (result) {
			alert('매칭이 등록되었습니다.');
			location.reload();
		}, error: function(){
			alert('이미 등록된 매칭이 있습니다.');
		}
	});
	
}

function ApplyModal(){ //ApplyModal창에서 신청버튼 클릭시 이벤트
	if(confirm('정말 신청 하시겠습니까?')){
		var Regi_num = JSON.parse($("#ApplyModal #regi_num").val());
		var Regi_ID = $("#Regi_ID").text();
		var Apply_ID = $("#user_id").text();
		var SPORT_NUM = Number($("#sport_num").text());
		
		console.log(SPORT_NUM);
		console.log(Apply_ID);
		console.log(Regi_num);
		console.log(Regi_ID);
		$.ajax({
			async: false,
			type: "post",
			url: "./RegiUpdate",
			dataType: "json",
			data:{
			   "SPORT_NUM"   : SPORT_NUM,
	    	   "REGISTER_NUM": Regi_num,
	    	   "REGISTER_ID" : Regi_ID,
	    	   "APPLY_ID" : Apply_ID
			},
			success: function (result) {
					alert('신청 되었습니다.');
					location.reload();
			}, error:function(request,status,error){
		        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		       }
		});
	}else{
		return false;
	}
}

