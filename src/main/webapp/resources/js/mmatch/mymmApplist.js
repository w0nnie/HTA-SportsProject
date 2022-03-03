function mentorCancel(code){
	console.log("cancel:" + code);
	if(confirm("신청을 취소하시겠습니까?")){
		$.ajax({
			url : "cancelApply",
			type : "Post", 
			data : {"code":code},
			dataType : "json",
			cache : false,
			success : function(data){
				if(data == 1){
					alert("신청이 취소되었습니다.");
					goMentor(1);
				}   				
			},
			error : function(){
				console.log('에러');
			}
		});		
	}
}
function menteeCancel(code){
	console.log("cancel:" + code);
	if(confirm("신청을 취소하시겠습니까?")){
		$.ajax({
			url : "cancelApply",
			type : "Post", 
			data : {"code":code},
			dataType : "json",
			cache : false,
			success : function(data){
				if(data == 1){
					alert("신청이 취소되었습니다.");
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
		url : "mentorApplyList_ajax",
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
				$(data.applylist).each(function(index,item){
				  output +='<tr><td><div class="classalign">'+item.sports_name+'</div></td>'
						 +'<td colspan="3"><div class="classalign">'+item.mentor_title+'</div></td>'
					     +'<td><div class="classalign">';
						  if(item.match_state == 1){
							  output+='신청 진행 중';
						  }else if(item.match_state == 2){
							  output+='수락 완료';
						  }else if(item.match_state == 3){
							  output+='신청 거절';
						  }
			      output +='</div></td><td>';
			      		 if(item.match_state == 1){
						      output+='<div onclick="javascript:mentorCancel('+"'"+item.match_code+"'"+')" class="submit4">신청취소</div></td>';
					     }else{
					    	  output+='<div class="submit6">수락/거절</div></td>';
					     }
			      output+='<td><div onclick="javascript:mentorDetail('+"'"+item.match_code+"'"+')" class="submit5">상세보기</div></td></tr>';
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
		url : "menteeApplyList_ajax",
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
				$(data.applylist).each(function(index,item){
					  output +='<tr><td><div class="classalign">'+item.sports_name+'</div></td>'
							 +'<td colspan="3"><div class="classalign">'+item.mentee_title+'</div></td>'
						     +'<td><div class="classalign">';
							  if(item.match_state == 1){
								  output+='신청 진행 중';
							  }else if(item.match_state == 2){
								  output+='수락 완료';
							  }else if(item.match_state == 3){
								  output+='신청 거절';
							  }
				      output +='</div></td><td>';
				      		 if(item.match_state == 1){
							      output+='<div onclick="javascript:menteeCancel('+"'"+item.match_code+"'"+')" class="submit4">신청취소</div></td>';
						     }else{
						    	  output+='<div class="submit6">수락/거절</div></td>';
						     }
				      output+='<td><div onclick="javascript:menteeDetail('+"'"+item.match_code+"'"+')" class="submit5">상세보기</div></td></tr>';
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