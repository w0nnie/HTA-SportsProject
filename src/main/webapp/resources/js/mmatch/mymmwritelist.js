function mentorModify(code){
	console.log("modity:"+code);	
	location.href="/sports/mmatch/mentorModify?code="+code;
}
function menteeModify(code){
	console.log("modity:"+code);	
	location.href="/sports/mmatch/menteeModify?code="+code;
}
function mentorDel(code){
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
					goMentor(1);
				}   				
			},
			error : function(){
				console.log('에러');
			}
		});		
	}
}
function menteeDel(code){
	console.log("del:" + code);
	if(confirm("해당글을 삭제하시겠습니까?")){
		$.ajax({
			url : "delWMentee",
			type : "Post", 
			data : {"code":code,},
			dataType : "json",
			cache : false,
			success : function(data){
				if(data == 1){
					alert("해당글을 삭제 했습니다.");
					goMentee(1);
				}   				
			},
			error : function(){
				console.log('에러');
			}
		});		
	}
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


//ajax 화면 처리를 위한 최상위 메소드
function goMentor(page){
	//출력 페이지,검색항목,검색키워드로 쿼리스트링 작성
	var data = "page="+page;
	ajaxMentor(data);
}

//화면처리 ajax
function ajaxMentor(sdata){
	console.log(sdata);
	output = "";
	$.ajax({
		url : "mentorwriteList_ajax",
		type : "get", 
		data : sdata,
		dataType : "json",
		cache : false,
		success : function(data){
			//멘토 게시글 리스트 삭제
			$('#mentorbody').empty(); 
				
			//pagination 삭제
			$("#mentorPagination").empty();
			
			//검색 결과 갯수와 검색키워드 표시
			$('#writingcount1').text(data.listcount);
			
			if(data.listcount > 0 ){
				var output='';
				//ajax로 가져온 list로 col 구성 
				$(data.mentorlist).each(function(index,item){
				  output +='<tr><td><div class="classalign">'+item.sports_name+'</div></td>'
						 +'<td colspan="3"><div class="classalign">'+item.mentor_title+'</div></td>'
					     +'<td><div class="classalign">'+item.mentor_amount+'</div></td>'
					     +'<td><div class="classalign">'+item.mentor_number+'</div></td>'
						 +'<td><div id="btnSubmit1" onclick="javascript:mentorDetail('+"'"+item.mentor_code+"'"+')" class="submit5">상세보기</div></td>'
					     +'</td></tr>';
				});
				//해당 결과를 append
				$('#mentorbody').append(output); 
				
				
				//pagination 시작
				output = "";
				
				digit = '&laquo;';
				href="";
				if(data.page > 1){
					href = 'href=javascript:goMentor('+(data.page-1) + ')';
				}
				output += setPaging(href,digit);
				
				for(var i = data.startpage; i<=data.endpage; i++){
					digit=i;
					href="";
					if(i !=data.page){
						href='href=javascript:goMentor('+i+')';
					}
					else{
						href='class="active"';
					}
					output += setPaging(href,digit);
				}
				
				digit = '&raquo;';
				href="";
				if(data.page < data.maxpage){
					href = 'href=javascript:goMentor('+(data.page+1) + ')';
				}
				output += setPaging(href,digit);
				$('#mentorPagination').append(output);
			}
			else{
				//등록글 없음 표시 붙이기
				output='<tr><td colspan="5" style="text-align: left !important;"><font style="padding-left:10px;" size=5>등록된 글이 없습니다.</font></td><tr>'
				$('#mentorbody').append(output); 
			}
		},
		error : function(){
			console.log('에러');
		}
	});
}



//ajax 화면 처리를 위한 최상위 메소드
function goMentee(page){
	//출력 페이지,검색항목,검색키워드로 쿼리스트링 작성
	var data = "page="+page;
	ajaxMentee(data);
}

//화면처리 ajax
function ajaxMentee(sdata){
	console.log(sdata);
	output = "";
	$.ajax({
		url : "menteewriteList_ajax",
		type : "get", 
		data : sdata,
		dataType : "json",
		cache : false,
		success : function(data){
			//멘토 게시글 리스트 삭제
			$('#menteebody').empty(); 
			
			//pagination 삭제
			$("#menteePagination").empty();
			
			//검색 결과 갯수와 검색키워드 표시
			$('#writingcount2').text(data.listcount);
			
			if(data.listcount > 0 ){
				var output='';
				//ajax로 가져온 list로 col 구성 
				$(data.menteelist).each(function(index,item){
			      output +='<tr><td><div class="classalign">'+item.sports_name+'</div></td>'
						 +'<td colspan="3"><div class="classalign">'+item.mentee_title+'</div></td>'
					     +'<td><div class="classalign">'+item.mentee_amount+'</div></td>'
					     +'<td><div class="classalign">'+item.mentee_gender+'</div></td>'
						 +'<td><div id="btnSubmit2" onclick="javascript:menteeDetail('+"'"+item.mentee_code+"'"+')" class="submit5">상세보기</div></td>'
					     +'</td></tr>';
				});
				//해당 결과를 append
				$('#menteebody').append(output); 
				
				
				//pagination 시작
				output = "";
				
				digit = '&laquo;';
				href="";
				if(data.page > 1){
					href = 'href=javascript:goMentee('+(data.page-1) + ')';
				}
				output += setPaging(href,digit);
				
				for(var i = data.startpage; i<=data.endpage; i++){
					digit=i;
					href="";
					if(i !=data.page){
						href='href=javascript:goMentee('+i+')';
					}
					else{
						href='class="active"';
					}
					output += setPaging(href,digit);
				}
				
				digit = '&raquo;';
				href="";
				if(data.page < data.maxpage){
					href = 'href=javascript:goMentee('+(data.page+1) + ')';
				}
				output += setPaging(href,digit);
				$('#menteePagination').append(output);
			}
			else{
				//등록글 없음 표시 붙이기
				output='<tr><td colspan="5" style="text-align: left !important;"><font style="padding-left:10px;" size=5>등록된 글이 없습니다.</font></td><tr>'
				$('#menteebody').append(output); 
			}
		},
		error : function(){
			console.log('에러');
		}
	});
}