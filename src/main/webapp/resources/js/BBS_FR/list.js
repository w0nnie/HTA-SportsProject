function go(page){
	var limit = $('#viewcount').val();
	var data = "limit=" + limit + "&state=ajax&page=" + page;
}
//검색
$(function(){
	//검색 클릭 후 응답화면에는 검색 시 선택한 필드가 선택되도록합니다.
	var selectedValue = '${search_field}'
	if(selectedValue != '-1')
		$("#viewcount").val(selectedValue);
	
	
	//검색어 입력창에 placeholder 나타나도록 합니다.
	$("#viewcount").change(function(){
		selectedValue = $(this).val();
		$("input").val('');
		message=["카테고리", "아이디", "제목", "내용"]
		$("input").attr("placeholder", message[selectedValue] + "입력하세요");
	});	//$("#viewcount").change end
	
})

$(function(){
	$("#viewcount").change(function(){
		go(1);//보여줄 페이지를 1페이지로 설정합니다.
	});	//change end
	
	$("#write").click(function(){
		var USER_ID = $("#USER_ID").val();
		console.log("아이디:" + USER_ID);
		   if(USER_ID == ''||null){
			   alert("로그인 후 이용해주세요");
			   location.href="/sports/member/login";
		   }else{
		location.href="write";
		   }
	})
	
	$("#sub").click(function(){
		location.href="list?search_word="+$("#sinput").val()+"&search_field="+$("#viewcount").val();
	})
})