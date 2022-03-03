var search_field='';
var search_word='';
var select='';
$(function(){
	//페이지로딩시 수업지역검색 modal의 기본 표시는 [서울특별시]이므로 서울 관련 모달 화면을 구성
	getCityList();
	getGunguList($('#nav-tab-si').children().eq(0).text());
	
	//페이지로딩시 전체과목검색 modal의 기본 표시는 [구기종목]이므로 구기종목 관련 모달 화면을 구성
	getlgSubjectList();
	getsubjectList($('#nav-tab-lgsubject').children().eq(0).text());

	//수업지역검색 modal에서 시를 선택시 선택색상변경(red)
	$('#nav-tab-si').on('click','a',function(){
    	$('#nav-tab-si > a').removeClass("loc_active");  //미션택 도시 대항목 black색
    	$(this).addClass("loc_active");					 //선택된 도시 대항목 red색
    	getGunguList($(this).text());					 //선택된 도시 대항목에 대한 modal화면 재구성(ajax)
    	$(select).next().removeClass("changed");		 //검색 종류 radio에  파란색 윤곽선이 있으면 제거 
    	select='';
    }); 
	
	//전체과목검색 modal에서 대항목을 선택시 선택색상변경(red)
	$('#nav-tab-lgsubject').on('click','a',function(){
    	$('#nav-tab-lgsubject > a').removeClass("loc_active");	//미션택 과목 대항목 black색
    	$(this).addClass("loc_active");							//선택돤 과목 대항목 red색
    	getsubjectList($(this).text());							//선택된 과목 대항목에 대한 modal화면 재구성(ajax)
    	$(select).next().removeClass("changed");				//검색 종류 radio에 파란색 윤곽선이 있으면 제거 
    	select='';
    }); 
	
	//검색 조건 modal의 체크박스 클릭 이벤트 처리
	$('body').on('click', 'input[type=checkbox]',function () {
		//현재 체크박스가 속한 검색종류 radio를 구함
		select="#"+$(this).parent().parent().nextAll('input[type=hidden]').val();
		console.log(select);
		
		//체크박스 유무에 따라 radio에 푸른 윤곽선 임팩트 적용
		if($(this).is(":checked")){
			console.log("check");
			$('input[type="radio"] + label').removeClass('changed');
			$(select).next().addClass("changed");
			
			//검색 조건 modal의 checkbox클릭시 다른 checkbox는 전부 false 시킴
		    $('.modal').find('input[type=checkbox]').not(this).prop("checked",false);
		}
		else{
			console.log("uncheck");
			$(select).next().removeClass("changed");
			select ='';
		}
	}); 
/* 	    	
			$("input[type=hidden] + div > button").on("click", function() { //파일 선택 처리
				console.log("버튼클릭");
				$('#genderModal').modal("hide"); //닫기 
			});
			
	    	
	    	
 	    	//modal 창을 닫을 경우 modal을 초기화 시킴
			$('.modal').on('hidden.bs.modal', function (e) {
				
			    console.log('modal close');
			    //$('.modal').find('input[type=checkbox]').prop("checked",false);
			});  */
	
});


//페이지 로딩되면 지역검색에 대한 시 항목 가져옴 
function getCityList(){
	$.ajax({
		url : "siList",
		type : "get", 
		cache : false,
		async : false,
		success : function(data){
			if(data.length > 0){
				var output="";
				
				//ajax로 가져온 list로 option 구성
				$(data).each(function(index,item){
					output +='<a class="nav-item nav-link ';
					if(index == 0){
						output+='loc_active';
					}
					output +='" id="nav-home-tab"'
					       	+'   data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home"'
					       	+'   aria-selected="true">'+item+'</a>';
                    
				})
				
				//구성한 option을 append
				$("#nav-tab-si").append(output);
			}
		},
		error : function(){
			console.log('에러');
		}
	});
}

//지역검색에 시항목에 해당되는 군/구 정보를 가져옴
function getGunguList(selType){
	console.log("selectType : " + selType);
	$.ajax({
		url : "dongList",
		type : "get", 
		data : {"selType":selType},
		dataType : "json",
		cache : false,
		async : false,
		success : function(data){
			if(data.length > 0){
				 //기존 군/구 화면을 제거
				$('#addressModal .grid>label').remove()
				 
				var output="";
				
				//ajax로 가져온 list로 화면 구성
				$(data).each(function(index,item){
					output+='<label class="card">'
					      +'  <input class="card__input" type="checkbox"/>'
			        	  +'  <div class="card__body">'
			              +'    <div class="card__body-cover">'
				          +'      <img class="card__body-cover-image" src="/sports/resources/image/mmatch/town_gungu.jpg"/>'
				          +'      <span class="card__body-cover-checkbox">'
				          +'  		 <svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">'
				          +'      		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>'
				          +'         </svg>'
				          +'      </span>'
				          +'    </div>'
				          +'    <header class="card__body-header">'
				          +'        <h4 class="card__body-header-title">'+item+'</h4>'
				          +'    </header>'
				          +'  </div>'
				          +'</label>';
				}) 
				
				//구성한 요소들을 append
				$('#addressModal .grid').append(output)
			}
		},
		error : function(){
			console.log('에러');
		}
	});
}

//페이지 로딩되면 종목검색에 대한 대항목(구기운동/기구운동/맨몸운동)을가져옴 
function getlgSubjectList(){
	$.ajax({
	     async: false,
	     dataType: "json",
	     url: "../resources/json/mmatch.json",
	     success: function (result) {
	    	var sport_json = result.sports;
	    	var output="";
	   		for(var i = 0; i < sport_json.length; i++){
		   		output +='<a class="nav-item nav-link ';
				if(i == 0){
					output+='loc_active';
				}
				output +='" id="nav-home-tab"'
				       	+'   data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home"'
				       	+'   aria-selected="true">'+sport_json[i]+'</a>';
	   		}
	   		$("#nav-tab-lgsubject").append(output);
	     }
	});
}

//종목검색에 대항목에 해당되는 운동정보(ex-구기운동:축구,야구,농구등등)를 가져옴
function getsubjectList(subject_sel){
	var selType;
	if(subject_sel =="구기운동"){
		selType = 1;
	}else if(subject_sel =="기구운동"){
		selType = 2;
	}else if(subject_sel =="맨몸운동"){
		selType = 3;
	}
	
	console.log("종목 Type : " + subject_sel);
	console.log("종목 int : " + selType);
	$.ajax({
		url : "sportDeatilList",
		type : "get", 
		data : {"selType":selType},
		dataType : "json",
		cache : false,
		success : function(data){
			if(data.length > 0){
				 //기존 종목 화면 제거
				$('#subjectModal .grid>label').remove()
				 
				var output="";
				
				//ajax로 가져온 list로 화면 구성
				$(data).each(function(index,item){
					output+='<label class="card">'
					      +'  <input class="card__input" type="checkbox"/>'
			        	  +'  <div class="card__body">'
			              +'    <div class="card__body-cover">'
				          +'      <img class="card__body-cover-image"'
				          +'             src="/sports/resources/image/mmatch/'+ item.sports_IMG+'"/>'
				          +'      <span class="card__body-cover-checkbox">'
				          +'  		 <svg class="card__body-cover-checkbox--svg" viewBox="0 0 12 10">'
				          +'      		<polyline points="1.5 6 4.5 9 10.5 1"></polyline>'
				          +'         </svg>'
				          +'      </span>'
				          +'    </div>'
				          +'    <header class="card__body-header">'
				          +'        <h2 class="card__body-header-title">'+item.sports_NAME+'</h2>'
				          +'    </header>'
				          +'  </div>'
				          +'</label>';
				}) 
					

				//구성한 요소들을 append
				$('#subjectModal .grid').append(output)
			}
		},
		error : function(){
			console.log('에러');
		}
	});
}

function apply(code){
	var user_id=$('#user_id').val();
	if(user_id == ''){  //미로그인 상태면 loing 창으로 이동
		location.href="/sports/member/login";
	}
	else{ //로그인 상태면 해당 공고글 신청 가능
		location.href="#";
		$.ajax({
			url : "ApplyWMentor",
			type : "post", 
			data : {
				"code":code,
				"id":user_id
				},
			dataType : "json",
			cache : false,
			success : function(data){
				if(data == 1){
					alert("해당글에 신청 완료했습니다.");
				}else{
					alert("이미 신청한 상태입니다.")
				}	    				
			},
			error : function(){
				console.log('에러');
			}
		});
	}
}

function modify(code){
	console.log("modity:"+code);	
	location.href="/sports/mmatch/mentorModify?code="+code;
}
function del(code){
	console.log("del:" + code);
	if(confirm("해당글을 삭제하시겠습니까?")){
		$.ajax({
			url : "delWMentor",
			type : "Post", 
			data : {"code":code,},
			dataType : "json",
			cache : false,
			success : function(data){
				if(data == 1){
					alert("해당글을 삭제 했습니다.");
					go(1);
				}   				
			},
			error : function(){
				console.log('에러');
			}
		});		
	}
}

//ajax 화면 처리를 위한 최상위 메소드
function go(page){
	//출력 페이지,검색항목,검색키워드로 쿼리스트링 작성
	var data = "page="+page+"&search_field="+search_field+"&search_word="+search_word;
	ajax(data);
}
//페이지네이션 화면 출력 메서드
function setPaging(href,digit){
	var output='<a ';
	if(href==""){
		output+='class="gray" ';
	}
	output+= href + ' id="paging">' + digit + "</a>";
	return output;
}

//검색 버튼 클릭시 이벤트
function search(){
	console.log("검색 클릭");
	switch(select) {
	  case '#location_sel':
			//넘기는 형태 ex)"지역" ,"서울특별시,강남구"
		    var si =$('#nav-tab-si > a.loc_active').text();
		    var gungu = $("input[type='checkbox']:checked+div h4").text();
	    	search_field='지역';
	    	search_word=si+','+gungu;
			console.log("field : "+search_field+", word : " +search_word);
	    	go(1);
		    break;
	  case '#subject_sel':
			//넘기는 형태 ex)"과목",'"축구"
	    	search_field='과목';
	    	search_word=$("input[type='checkbox']:checked+div h2").text();
	    	console.log("field : "+search_field+", word : " +search_word);
		  	go(1);
		    break;
	  case '#money_sel':
			//넘기는 형태 ex)"수업료","10만미만"
	    	search_field='수업료';
	    	search_word=$("input[type='checkbox']:checked+div h2").text();
	    	console.log("field : "+search_field+", word : " +search_word);
	    	go(1);
		    break;
	  case '#gender_sel':
		  	//넘기는 형태 ex)"성별",'남'
	    	search_field='성별';
	    	search_word=$("input[type='checkbox']:checked").val();
	    	console.log("field : "+search_field+", word : " +search_word);
	    	go(1);
		    break;
	  default:
		    alert("검색 키워드 선택해주세요");
	  		break;
	}
}

//검색 취소 버튼 클릭시 이벤트
function searchCancel(){
	console.log("검색 취소");
}