/*function getList(state){
	    option=state;//현재 선택한 댓글 정렬방식을 저장합니다. 1=>등록순, 2=>최신순
	
	    $.ajax({
			type:"post",
			url:"../BBS_FCM/list",
			data : {
				"FR_NO" : $("#FR_NO").val(),
				"page" : currentPage
			},
			dataType:"json",
			success:function(rdata){
				//댓글의 총 갯수가 표시 됩니다.
				$('#count').text(rdata.listcount).css('font-family','arial,sans-serif')
				var red1='red';		var red2='red';
				if(option==1){  //등록순인 경우 등록순이 'red', 최신순이 'gray'로 글자색을 나타냅니다.
					red2='gray';
				}else if(option==2){ //최신순인 경우 등록순이 'gray', 최신순이 'red'로 글자색을 나타냅니다.
					red1='gray';
				}
				var output="";
				
			 if(rdata.list.length>0){
				   output += '<li class="comment_tab_item ' +  red1 + '" >'
                          + '   <a href="javascript:getList(1)" class="comment_tab_button">등록순 </a>'
                          + '</li>'
                          + '<li class="comment_tab_item ' +  red2 + '" >'
                          + '   <a href="javascript:getList(2)" class="comment_tab_button">최신순</a>'
                          + '</li>';
                     $('.comment_tab_list').html(output);//댓글 수 등록순 최신순 출력
                     
				    output='';
					$(rdata.list).each(function(){
						var lev = this.comment_re_lev;
						//선택한 파일이 나타날지 기본 그림이 나타날지 결정합니다.
						var profile=this.memberfile;
						var src='../resources/image/bbs_fcm/profile.png';
						if(profile){
							src='memberupload/'+profile;
						}
						console.log('no:'+this.fr_NO);
						console.log('id:'+this.user_ID);
						console.log('date:'+this.fcm_REF_DATE);
						console.log('content:'+this.fcm_CONTENT);
						
						output += '<li id="' + this.fcm_NO + '" class="CommentItem' + comment_reply + '">'
							   + '   <div class="comment_area">'
							   + '    <img  src="' + src +'" alt="프로필 사진" width="36" height="36">'
							   + '    <div class="comment_box">'
							   + '      <div class="comment_nick_box">'
							   + '            <div class="comment_nick_info">'
							   + '               <div class="comment_nickname">' + this.user_ID  + '</div>'
							   + '            </div>' //comment_nick_info                  
							   + '       </div>'  // comment_nick_box
							   + '     </div>'   //comment_box
							   + '    <div class="comment_text_box">'
							   + '       <p class="comment_text_view">'
							   + '         <span class="text_comment">' + this.fcm_CONTENT + '</span>'
							   + '       </p>'
							   + '    </div>' //comment_text_box
							   + '    <div class="comment_info_box">'
							   + '      <span class="comment_info_date">' + this.fcm_REF_DATE + '</span>';
						if(lev<2){ //답글쓰기는 답글의 답글까지만 사용하도록 합니다.
						   	  output += '  <a href="javascript:replyform(' + this.fcm_NO +',' 
						   	         + lev + ',' + this.fcm_RE_SEQ +',' 
						   	         + this.fcm_RE_REF +')"  class="comment_info_button">답글쓰기</a>'
						      }
						output += '   </div>' //comment_info_box;
							   
						//글쓴이가 로그인한 경우 나타나는 더보기입니다.
                        //수정과 삭제 기능이 있습니다.							
					    if($("#loginid").val()==this.user_ID){  
						 output +=  '<div class="comment_tool">'
							   + '    <div title="더보기" class="comment_tool_button">'
							   + '       <div>&#46;&#46;&#46;</div>' 
							   + '    </div>'
							   + '    <div id="commentItem' +  this.fcm_NO + '"  class="LayerMore">' //스타일에서 display:none; 설정함
							   + '     <ul class="layer_list">'							   
							   + '      <li class="layer_item">'
							   + '       <a href="javascript:updateForm(' + this.fcm_NO + ')"'
							   + '          class="layer_button">수정</a>&nbsp;&nbsp;'
							   + '       <a href="javascript:del(' + this.fcm_NO + ')"'
							   + '          class="layer_button">삭제</a></li></ul>'
							   + '     </div>'//LayerMore
							   + '   </div>'//comment_tool
					     }
							   
						output += '</div>'// comment_area
							   + '</li>'//li
					})//each
					 $('.comment_list').html(output);
			 }//if(rdata.boardlist.length>0)
			 else{ //댓글 1개가 있었는데 삭제하는 경우 갯수는 0이라  if문을 수행하지 않고 이곳으로 옵니다.
				   //이곳에서 아래의 두 영역을 없앱니다.
				 $('.comment_list').empty();  
				 $('.comment_tab_list').empty(); 
			 }
			}//success end
		});//ajax end
	}//function(getList) end

//더보기 클릭 후 -> 수정 클릭한 경우에 수정 폼을 보여줍니다.
function updateForm(num){	//num: 수정할 댓글 글번호 
	//선택한 내용을 구합니다.
	var content=$('#'+num).find('.text_comment').text();
	
	var selector = '#'+num + ' .comment_area'
	$(selector).hide();	//selector 영역 숨겨요 - 수정에서 취소를 선택하면 보여줄 예정입니다.
	
	//$('.comment_list +.CommentWriter').clone() : 기본 글쓰기 영역 복사합니다.
	//글이 있던 영역에 글을 수정할 수 있는 폼으로 바꿉니다.
	selector=$('#'+num);
	selector.append($('.comment_list+.CommentWriter').clone());
	
	//댓글 쓰기 영역 숨깁니다.
	$('.comment_list+.CommentWriter').hide();
	
	//수정 폼의 <textarea>에 내용을 나타냅니다.
	selector.find('textarea').val(content);
	
	//'.btn_register' 영역에 수정 할 글 번호를 속성 'data-id'에 나타내고 클래스 'update'를 추가하며 등록을 수정 완료
	selector.find('.btn_register').attr('data-id',num).addClass('update').text('수정완료');
	
	//폼에서 취소를 사용할 수 있도록 보이게 합니다.
	selector.find('.btn_cancel').css('display','block').addClass('update_cancel');
	
	selector.find('.comment_inbox_count').text(content.length+"/200");

	}//function(updateForm) end

//더보기 - > 삭제 클릭한 경우 실행하는 함수
function del(num){//num: 댓글 번호
	if(!confirm('댓글을 삭제하시겠습니까?')){
		return;
	}
		$.ajax({
			url:"../BBS_FCM/delete",
			data:{num:num},
			success:function(rdata){
				if(rdata==1){
				getList(option);
				}
			}
		})
}//function(del) end

//답글 달기 폼
function replyform(num,lev,seq,ref){
	//댓글 달기 폼이 열려있다는 것은 다름 폼이 열려있지 않은 경우입니다.
	if($('.comment_list+.CommentWriter').css('display')=='block'){
		var output = '<li class="CommentItem CommentItem--reply lev'
				   + 	lev		+'CommentItem-form"></li>'
				   
		var selector = $('#'+num);
		
		//선택한 글 뒤에 답글 폼을 추가합니다.
		selector.after(output);
		
		//글쓰기 영역 복사합니다.
		output=$('.comment_list+.CommentWriter').clone();
		
		//댓글 쓰기 영역 숨깁니다.
		$('.comment_list+.CommentWriter').hide();
		
		//더보기를 누른 상태에서 답글 달기 폼을 연 경우 더보기의 영역 보이지 않게 합니다.
		$("CommentBox .LaterMore").css('dosplay','none');
		
		//선택한 글 뒤에 답글 폼 생성합니다.
		selector.next().html(output);
		
		//답글 폼의 <textarea>의 속성 'placeholder'를 '답글을 남겨보세요'로 바꾸어 줍니다.
		selector.next().find('textarea').attr('placeholder','답글을 남겨보세요');
		
		//답글 폼의 '.btn_cancel'을 보여주고 클래스 'reply_cancel'를 추가합니다.
		selector.next().find('.btn_cancel').css('display','block')
						.addClass('reply_cancel');
		
		//답글 폼의 '.btn_register'에 클래스 'reply' 추가합니다.
		//속성 'data-ref'에 ref, 'data-lev'에 lev, 'data-seq'에 seq값을 설정합니다.
		selector.next().find('.btn_register').addClass('reply').text('답글 완료')
				.attr('data-ref',ref).attr('data-lev',lev).attr('data-seq',seq);
			
	}else{
		alert('다른 작업 완료 후 선택하세요')
	}
}//function(replyform)end

	
$(function(){
	option=1;
	getList(option); //처음 로드 될 때는 등록 순 정렬
	
	$("form").submit(function(){
		if($("#FR_PASS").val()==''){
			alert("비밀번호를 입력하세요");
			$("#FR_PASS").focus();
			return false;
		}
	})//form 
	
	$('.CommentBox').on('keyup','.comment_inbox_text', function() {
		var length=$(this).val().length;
		$(this).prev().text(length+ '/200');
	});//key up ','.comment_inbox_text',function() {
	
	//등록을 클릭하면 데이터베이스에 저장 -> 저장 성공 후에 리스트 불러옵니다.
	$('ul+.CommentWriter .btn_register').click(function() {
		var content=$('.comment_inbox_text').val();
		if(!content){//내용 없이 등록 클릭한 경우
			alert("댓글을 입력하세요");
			return;
		}
		
		$.ajax({
			url : '../BBS_FCM/add',	//원문 등록
			data : {
					"FCM_CONTENT" : content, //content = $("#content").val();
					"USER_ID" : $("#loginid").val(),
					"FR_NO" : $("#FR_NO").val(),
					"FCM_RE_LEV" : 0, //원문인 경우 comment_re_seq는 0,
									 //comment_re_ref는 댓글의 원문 글번호
					"FCM_RE_SEQ" : 0
			},
			type : 'post',
			success : function(rdata) {
				if(rdata == 1) {
					getList(option);
				}
			}
		})//ajax
		$('.comment_inbox_text').val('');//textarea 초기화
		$('.comment_inbox_count').text('');//입력한 글 카운트 초기화
	})//$('.btn_register').click(function(){
	//더보기를 클릭하면 수정과 삭제 영역이 나타나고 다시 클릭하면 사라져요 - toggle()이용
	$(".comment_list").on('click', '.comment_tool_button', function(){
		var selector = $(this).next();
		
		//댓글쓰기 폼이 나타난 경우에만 더보기를 선택할 수 있도록 합니다.
		if($('.comment_list + .CommentWriter').css('display')=='block'){
			selector.toggle();
			
			//더보기를 여러개 선택하더라도 최종 선택한 더보기 한개만 보이도록 합니다.
			if(selector.css('display')=='block'){	//현재 더보기가 열린 경우
				//$(".LayerMore") 중에서 selector가 아닌 객체들의 display속성을 none으로 설정합니다.
				$(".LayerMore").not(selector).css('display','none');
			}
		}else{
			//답글쓰기 폼이나 수정 폼이 열려 있는 상황에서 더보기를 클릭한 경우
			alert('작업 완료 후 선택해 주세요')
		}
	})//'.comment_tool_button' click end
	
	//더보기를 선택한 후 수정이나 삭제를 클릭한 경우 수정과 삭제 영역이 사라지게 합니다.
	$(".comment_list").on('click','.LayerMore', function(){
		$(this).hide();
	})//.LayerMore click end
	
	//수정 후 수정완료 클릭한 경우
	$('.CommentBox').on('click','.update',function(){
		console.log("수정완료")
	//댓글쓰기 영역 보이도록 합니다.
		$('.comment_list+.CommentWriter').show();
		
		var content = $(this).parent().parent().find('textarea').val();
		if(!content){
			alert('수정할 내용을 입력하세요');
			return
		}
		$.ajax({
			url:'../BBS_FCM/update',
			data:{
				"FCM_NO" : $(this).attr('data-id'), 
				"FC_CONTENT" : content
				},
			success:function(rdata){
				if(rdata==1){
					getList(option);
				}//if
			}//success
		});//ajax
	})//수정 후 등록 버튼을 클릭한 경우
	
	//수정 후 취소 클릭한 경우
	$('.CommentBox').on('click',' .update_cancel',function(){
		//댓글 번호를 구합니다.
		var num = $(this).next().attr('data-id');
		var selector='#' +num;
		
		//selector의 후손 중 .CommentWriter 영역 삭제합니다.
		$(selector + ' .CommentWriter').remove();
		
		//댓글 쓰기 영역 보이도록 합니다.
		$('.comment_list+.CommentWriter').show();
		
		//숨겨두었던 .comment_area 영역 보여줍니다.
		$(selector + '>.comment_area').css('display','block');
	})//수정 후 취소 버튼 클릭한 경우
	
	
	
	
	//답글 달기 -> 답글완료 클릭한 경우
	$('.CommentBox').on('click','.reply',function(){
		var content=$(this).parent().parent().find('.comment_inbox_text').val();
		if(!content){
			alert('답변 내용을 입력하세요');
			return
		}
		//댓글쓰기 영영 보이도록합니다.
		$('.comment_list+.CommentWriter').show();
		
		$.ajax({
			url : 'CommentReply.bo',
			data : {
				"USER_ID" : $("#loginid").val(),
				"FCM_CONTENT" : content,
				"FR_NO" : $("#comment_board_num").val(),
				"FCM_RE_LEV" : $(this).attr('data-lev'),
				"FCM_RE_REF" : $(this).attr('data-ref'),
				"FCM_RE_SEQ" : $(this).attr('data-seq')
			},
			type : 'post',
			success : function(rdata) {
				if(rdata == 1){
					getList(option);
				}
			}
		})//ajax
	})//답변 달기 등록 버튼을 클리한 경우
	
	//답변달기 후 취소 버튼을 클릭한 경우
	$('.CommentBox').on('click','.reply_cancel',function(){
		$(this).parent().parent().parent().remove();
		
		//댓글쓰기 영역 보이도록 합니다.
		$('.comment_list+.CommentWriter').show();
	})//수정 후 취소 버튼을 클릭한 경우

})




*/


$(function() {
	$("#comment table").hide(); // 1
	var page=1;	//더 보기에서 보여줄 페이지를 기억할 변수
	count = parseInt($("#count").text());
	if(count != 0){	//댓글 개수가 0이 아니면
		getList(1);	//첫 페이지의 댓글을 구해옵니다.(한 페이지에 3개씩 가져옵니다.)
		}else{//댓글이 없는 경우
			$("#message").text("등록된 댓글이 없습니다.")
		}
	
	function getList(currentPage){
		$.ajax({
					type : "post",
					url : "../BBS_FCM/list",
					data : {
						"FR_NO" : $("#FR_NO").val(),
						"page" : currentPage
					},
					dataType : "json",
					success : function(rdata) {
						$("#count").text(rdata.listcount);
						if (rdata.listcount > 0){
							$("#comment table").show();	//문서가 로딩될 때 hide() 했던 부분을 보이게 합니다.(1)
							$("#comment tbody").empty();
							$(rdata.list).each(function(){
								console.log('no:'+this.fr_NO);
								console.log('id:'+this.user_ID);
								console.log('date:'+this.fcm_REF_DATE);
								console.log('content:'+this.fcm_CONTENT);
								output = '';
								img = '';
								if ($("#loginid").val() == this.user_ID){
									img = "<img src='../resources/image/bbs_fcm/pencil2.png' width='15px' class='update'>"
										+ "<img src='../resources/image/bbs_fcm/delete.png' width=15px' class='remove'>"
										+ "<input type='hidden' value='" + this.fcm_NO + "' >";
								}
								output += "<tr><td>" + this.user_ID + "</td>";
								output += "<td></td>";
								//output += "<td>" + this.content + "</td>";
								output += "<td>" + this.fcm_REF_DATE + img + "</td></tr>";
								$("#comment tbody").append(output);
								//append한 마지막 tr의 2번째 자식 td를 찾아 text()메서드로 content를 넣습니다.
								$("#comment tbody tr:last").find("td:nth-child(2)").text(this.fcm_CONTENT);
							
							});//each end
							
							if(rdata.listcount > rdata.list.length){ //전체 댓글 개수 > 현재까지 보여준 댓글 개수
								$("#message").text("더보기")
							}else{
								$("#message").text("")
							}
						}else {
							$("#message").text("등록된 댓글이 없습니다.")
							$("#comment tbody").empty();
							$("#comment table").hide()//1
							}
						}
					});//ajax end
		}//function end
	$("#content").on('keyup', function(){
		content = $(this).val();
		length = $(this).val().length;
		if(length > 50) {
			length = 50;
			content = content.substring(0, length);
		}
		$(".float-left").text(length + "/50")
	})
	
	//더보기를 클릭하면 page 내용이 추가로 보여집니다.
	$("#message").click(function(){
		getList(++page);
	})//click end
	
	//등록 또는 수정 완료 버튼을 클릭한 경우
	//버튼의 라벨이 '등록'인 경우는 댓글을 추가하는 경우
	//버튼의 라벨이 '수정완료'인 경우는 댓글을 수정하는 경우
	$("#write").click(function(){
		buttonText = $("#write").text();//버튼의 라벨로 add할지 update할지 결정
		
		$(".float-left").text('총 50자까지 가능합니다.');
		
		if(buttonText == "등록") {//댓글을 추가하는 경우
			url = "../BBS_FCM/add";
			data = {
					"FCM_CONTENT" : content, //content = $("#content").val();
					"USER_ID" : $("#loginid").val(),
					"FR_NO" : $("#FR_NO").val()
			};
		}else { //댓글을 수정하는 경우
			url = "../BBS_FCM/update";
			data = {
					"FCM_NO" : num,
					"FCM_CONTENT" : content
			};
			$("#write").text("등록"); //등록버튼의 라벨을 '수정완료'로 변경합니다.
		}
		
		$.ajax({
			type : "get",
			url : url,
			data : data,
			success : function(result){
				$("#content").val('');
				if(result == 1){
					//page=1
					getList(page); //등록, 수정 완료 후 해당 페이지 보여줍니다.
				}//if
			}//success
		})//ajax end
	})//$("#write") end
	
	// pencil2.png를 클릭하는 경우(수정)
	$("#comment").on('click', '.update', function() {
		before = $(this).parent().prev().text(); //선택한 내용을 가져옵니다.
		$("#content").focus().val(before);  // textarea에 수정전 내용을 보여줍니다.
		num = $(this).next().next().val(); // 수정할 댓글번호를 저장합니다.
		console.log("num" + num)
		$("#write").text("수정완료"); //등록버튼의 라벨을 '수정완료'로 변경합니다.
		
		//$("#comment .update").parent().parent()
		//#comment영역의 update클래스를 가진 엘리먼트의 부모의 부모 => <tr>
		//not(this) : 테이블의 <tr>중에서 현재 선택한 <tr>을 제외한 <tr>에 배경색을 흰색으로 설정합니다.
		//즉, 선택한 수정(.update)만 'lightgray'의 배경색이 나타나도록 하고
		//선택하지 않은 수정의 <tr>엘리먼트는 흰색으로 설정합니다.
		$("#comment .update").parent().parent().not(this).css('background', 'white');
		
		$(this).parent().parent().css('background', 'lightgray'); //수정할 행의 배경색을 변경합니다.
	})

	$("#comment").on('click', '.remove', function(){
		if(!confirm("댓글을 삭제하시겠습니까?")){
			return;
		}
		var deleteNum = $(this).next().val(); //댓글 번호
		$.ajax({
			type : "post",
			url : "../BBS_FCM/delete",
			data : {
				"num" : deleteNum
			},
			success : function(result) {
				if(result == 1){
				//page=1;
				getList(page); //삭제 후 해당 페이지의 내용을 보여줍니다.
			}
		}
		})//ajax end
	})
})//제일 윗부분 end
