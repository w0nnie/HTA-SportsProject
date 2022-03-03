$(function (){
	getList(1);

	$('#sports_name').click(function(){
	   var select = $("#sports_name").val();
      $.ajax({
         url : "../pm/select",
         data :{
        	 "select" : select
         },
         success : function(rdata){
        	console.log(rdata);
            if(rdata.length > 0){
            	//기존 select option을 제거
            	$("#sports_name > option").remove();
            	var output="<option selected>-- 선택 --</option>"
            	
            	//ajax로 가져온 select option구성
            	$(rdata).each(function(index,item){
            		value = '"' +  item.sports_NAME  + ' ' + item.cal + ' ' + item.sports_IMG + '"' ; 
            		output += '<option value=' +  value +'>'+item.sports_NAME+'</option>'
            	})
            	
            	console.log(output);
            	
            	//구성한 option을 append
            	$('#sports_name').append(output);
            	//console.log("select=" + select);
            	//$("#sports_name").val(select);
            	//console.log(select)
            }
         },
         error : function(){
        	 console.log('에러');
         }
      });//ajax
   });//click
   
   $("#add").click(function(){
	   console.log("time"+time);
	   var data = $('#sports_name').val().split(" ");
		   $.ajax({
			   type:"post",
			   url : "../pm/add",
			   async : false,
			   data:{
				   cal : data[1],
				   sports_name : data[0],
				   sports_img : data[2],
				   time : $("#time").val()
			   },
			   success : function(){
				   console.log("성공")
				   $("#sports_name").val('-- 선택 --').prop("selected", true);
				   $("#time").val('');
				   $("#time").attr("placeholder", "운동 시간");
			   }
	   })//ajax end
	   getList(1);
		   
   });
   

   $(document).on('click', '#remove', function(){
	var delnum = $(this).next().val();
	console.log(delnum);
	if(!confirm("해당 칼로리를 삭제하시겠습니까?")){
		return;
	}
	$.ajax({
		url : "../pm/delete",
		data :{
			"num" : delnum 
		},
		success: function(data){
			console.log("성공");
			getList(1);
		}
	})
	
})//click
   
})//전체

function go(page){
	getList(page);
}

function setPaging(href, digit){
	var output = "<li class=page-item>";
	gray="";
	if(href==""){
		gray=" gray";
	}
	anchor = "<a class='page-link" + gray + "'" + href + ">"+ digit + "</a></li>";
	output += anchor;
	return output; 
}

function getList(page){
	$.ajax({
		url: "../pm/list",
		data:{"page":page},
		dataType:"json",
		success : function(rdata){//rdata = object
		console.log("page : " + page);
			
			$("#kcal_list>thead tbody").remove();
			var output = '';
        	$(rdata.list).each(function(index,item){
        	var img = item.sports_IMG;
        	console.log(img);
        	console.log("성공");
			console.log("list : " + item.pm_NO);
			console.log("list : " + item.user_ID);
			console.log("list : " + item.pm_KCAL);
			console.log("list : " + item.sports_NAME);
			console.log("list : " + item.sports_IMG);
        	var src ='../resources/image/mmatch/'+img;
			output += "<tr><td class='product-thumb'><img  src=" + src + " alt='사진' width='50 height='50' id='sports_img'>"; 
  			output += "</td><td></td>";
			output += "<td colspan='1' class='product-category'>" + item.sports_NAME +"</td>";
			output += "<td class='text-center'>" + item.pm_KCAL + "</td>";
			output += "<td class='action' data-title='Action'><div class=''>" +
					  "<ul class='list-inline	justify-content-center'>" +
					  "<li	class='list-inline-item'><a data-toggle='tooltip' data-placement='top' title='Delete' class='delete'>";
			output += "<i id='remove' class='fa fa-trash'></i><input id='num' type='hidden' value=" + item.pm_NO + "></a></li></ul>";
			output += "</div></td></tr>";
  			/*console.log("PM_NO" + item.PM_NO);*/
		})//each
       /* 	var pm_no = $('#num').val();
			console.log(pm_no);*/
		$("#kcal_list tbody").empty(output);
		$("#kcal_list tbody").append(output);
		
		$(".pagination").empty();//페이징 처리 영역 내용 제거
		output = "";
		console.log("maxpage:"+ rdata.maxpage);
		console.log("endpage:" +rdata.endpage);
		console.log("startpage:" + rdata.startpage);
		digit = '이전&nbsp;'
		href="";
		if (rdata.page > 1){
			href = 'href=javascript:go(' + (rdata.page - 1) + ')';
		}
		output += setPaging(href, digit);
		
		for (var i = rdata.startpage; i <= rdata.endpage; i++){
			digit = i;
			href="";
			if(i != rdata.page){
				href = 'href=javascript:go(' + i + ')';
			}
			output += setPaging( href, digit);
		}
		//&nbsp;다음&nbsp;
		digit = '다음&nbsp;';
		href="";
		if (rdata.page < rdata.maxpage){
			href = 'href=javascript:go(' + (rdata.page + 1) + ')';
		}
		output += setPaging( href, digit);
		
		$('.pagination').append(output)	
		
	},//success end
	error : function(){
		console.log('에러')
	}
	})//ajax
}//getList function end
		

