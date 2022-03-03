<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
form {
    background-color: #e6fffe;
    margin: 5% auto 15% auto;
    border: 1px solid lightgray;
    width: 500px;
    height:900px;
    padding: 16px;
}
td{border: 1px solid #6bd6d2;}
td:first-child{width:110px;}
#join{margin:15px auto; display:block; background-color:lightgreen; width:200px; height:150;}
input:type:text {
  border: 1px solid currentcolor;
}
input:type:button {
  cursor: pointer;
}
input:invalid {
  border: 1px dashed pink;
}
</style>

<script>
$(function(){
	checkid=false;
	checkpass=false;
	//줄 자동넘김
	    $("input:text").keyup (function () {
	        var charLimit = $(this).attr("maxlength");
	        if (this.value.length >= charLimit) {
	            $(this).next('input:text').focus();
	            return false;
	        }
	    });
	//이메일 선택
	$('#EMAIL2').change(function(){  //이메일 뒷자리 선택
		if($(this).val()== '1'){
			$("#EMAIL1").val(''); 
			$("#EMAIL1").attr("disabled",false); 
		}else{
			$("#EMAIL1").val($("#EMAIL2").val());
			//$("#EMAIL1").attr("disabled",true);
		} 
	});
	//선호운동 최대 3개 선택
	$('input[name=USER_PSPORTS]').change(function(event) {//선호운동 선택 max값
	   if($('input:checkbox:checked').length > 3) {
		   alert("선호운동은 최대 3개 선택할 수 있습니다.");
		   $('input:checkbox:checked').prop("checked",false); //비활성화
	   }
	});
	//회원가입버튼 클릭 시 유효성 검사
	$('form').submit(function(){
		if(!checkid){
			alert("ID 중복확인하세요.");
			$(".checkid").focus();
			return false;
		}else if(!checkpass){
			alert("비밀번호를 확인해주세요.")
			$("#passcheck").focus();
			return false;
		}
	});
	//id중복체크,검사
    $("#checkid").click(function(){
		var pattern = /^\w{5,12}$/;
		var id = $("#USER_ID").val();
		if(!pattern.test(id)){//pattern통과하면
			alert("영문,숫자,_로 5~12자 가능합니다.");
			checkid=false;
			return;
		}
		$.ajax({
			url : "idcheck",
			data : {"id" : id},
			success : function(resp){
				if(resp == -1){//db에 해당 id가 없는 경우
					alert("사용 가능한 아이디 입니다.");
					checkid=true;
					$("#USER_PASS").focus();
				} else{//db에 해당 id가 있는 경우(0)
					alert("사용중인 아이디 입니다.");
					$("#USER_ID").focus();
					checkid=false;
				}
			}
		});//ajax
	})
	//비밀번호 검사
	$("#passcheck").keyup(function(){
		var pass = $("#USER_PASS").val();
		var pass1 = $("#passcheck").val();
			if(pass!=pass1){
				checkpass=false;
			}else{
				checkpass=true;
				}
	})
	
})

function Postcode() {//우편번호찾기
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("HOMEADDRESS").value = extraAddr;
            
            } else {
                document.getElementById("HOMEADDRESS").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('DONG').value = data.zonecode;
            document.getElementById("HOME").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("HOMEADDRESS").focus();
        }
    }).open();
}
</script>

</head>
<body>
    
    <!-- 헤더 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/header.jsp"/>
    <form method="post" name="joinform" action="joinProcess">
        <table>
            <tr>
                <td>
                    <label for="USER_ID">ID</label>
                </td>
                <td>
                    <input type="text" name="USER_ID" id="USER_ID" size="20px" pattern="\w{5,12}" required>
                    <input type="button"name="checkid" id="checkid" value="중복확인">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="USER_PASS">비밀번호</label>
                </td>
                <td>
                    <input type="password" name="USER_PASS" id="USER_PASS" size="20px" pattern="\w{10,16}" required>
                    <span class="passalarm"></span><br>
                    <span style=font-size:5px;>*영문 대소문자/숫자를 혼용하여 10~16자</span>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="passcheck">비밀번호 확인</label>
                </td>
                <td>
                    <input type="password" name="passcheck" id="passcheck" size="20px" pattern="\w{10,16}" required>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="USER_NAME">이름</label>
                </td>
                <td>
                    <input type="text" name="USER_NAME" id="USER_NAME" size="20px" required> 
                </td>
            </tr>
            <tr>
                <td>
                    <label for="JUMIN">주민등록번호</label>
                </td>
                <td>
                    <input type="text" name="JUMIN" id="JUMIN" size="10px" pattern="[0-9]{6}" maxlength="6" required>-
                    <input type="text" name="JUMIN1" id="JUMIN1" size="10px" pattern="[0-9]{7}" maxlength="7" required>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="MOBILE">연락처</label>
                </td>
                <td>
                    <select name="MOBILE1">
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="019">019</option>
                    </select>
                    -
                    <input type="text" name="MOBILE2" id="MOBILE2" size="4" maxLength="4" pattern="[0-9]+" required>-
                    <input type="text" name="MOBILE3" id="MOBILE3" size="4" maxLength="4" pattern="[0-9]+" required>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="DONG">우편번호</label>
                </td>
                <td>
                    <input type="text" name="DONG" id="DONG" size="6" pattern="[0-9]+" required>
                    <input type="button" onclick="Postcode()" value="우편번호 찾기">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="HOME">집주소</label>
                </td>
                <td>
                    <input type="text" name="HOME" id="HOME" size="40" required> 
                </td>
            </tr>
            <tr>
                <td>
                    <label for="HOMEADDRESS">상세주소</label>
                </td>
                <td>
                    <input type="text" name="HOMEADDRESS" id="HOMEADDRESS" size="40">   
                </td>
            </tr>
            <tr>
                <td>
                    <label for="EMAIL">이메일</label>
                </td>
                <td>
                    <input type="text" name="USER_EMAIL" id="EMAIL" size="8" required>@
                    <input type="text" name="USER_EMAILDOMAIN" id="EMAIL1" style="width:100px" required>
                    
                    <select id="EMAIL2" name="EMAIL2">
                        <option value="1">직접입력</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="naver.com">naver.com</option>
                        <option value="daum.com">daum.com</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="USER_HEIGHT">키</label>
                </td>
                <td>
                	<input type="text" name="USER_HEIGHT" id="USER_HEIGHT" size="3" maxlength="3" pattern="[0-9]+" required>cm
                </td>
            </tr>
            <tr>
                <td>
                    <label for="USER_PWEIGHT">현재몸무게</label>
                </td>
                <td>
                	<input type="text" name="USER_PWEIGHT" id="USER_PWEIGHT" size="3" maxlength="3" pattern="[0-9]+" required>kg
                </td>
            </tr>
            <tr>
                <td>
                    <label for="USER_WWEIGHT">목표몸무게</label>
                </td>
                <td>
                	<input type="text" name="USER_WWEIGHT" id="USER_WWEIGHT" size="3" maxlength="3" pattern="[0-9]+" required>kg
                </td>
            </tr>
            <tr>
                <td>
                    <label for="SPORTS">선호운동<br>
                    (최소 1개)</label>
                </td>
                <td>
                	<label for="sports1">구기운동</label><br>
                		<input type="checkbox" id="1" name="USER_PSPORTS" value="풋살">풋살	
                		<input type="checkbox" id="2" name="USER_PSPORTS" value="축구">축구	
                		<input type="checkbox" id="3" name="USER_PSPORTS" value="야구">야구	
                		<input type="checkbox" id="4" name="USER_PSPORTS" value="농구">농구	<br>
                		<input type="checkbox" id="5" name="USER_PSPORTS" value="배드민턴">배드민턴	
                		<input type="checkbox" id="6" name="USER_PSPORTS" value="테니스">테니스	
                		<input type="checkbox" id="7" name="USER_PSPORTS" value="탁구">탁구	
                		<input type="checkbox" id="8" name="USER_PSPORTS" value="골프">골프<br><br>
                	<label for="sports2">기구운동</label><br>
                		<input type="checkbox" id="9" name="USER_PSPORTS" value="헬스">헬스	
                		<input type="checkbox" id="10" name="USER_PSPORTS" value="크로스핏">크로스핏	
                		<input type="checkbox" id="11" name="USER_PSPORTS" value="스피닝">스피닝	
                		<input type="checkbox" id="12" name="USER_PSPORTS" value="사이클">사이클	
                		<input type="checkbox" id="13" name="USER_PSPORTS" value="서핑">서핑	<br><br>
                	<label for="sports3">맨몸운동</label><br>
                		<input type="checkbox" id="14" name="USER_PSPORTS" value="요가">요가	
                		<input type="checkbox" id="15" name="USER_PSPORTS" value="필라테스">필라테스	
                		<input type="checkbox" id="16" name="USER_PSPORTS" value="등산">등산	
                		<input type="checkbox" id="17" name="USER_PSPORTS" value="러닝">러닝	
                		<input type="checkbox" id="18" name="USER_PSPORTS" value="주짓수">주짓수	<br>
                		<input type="checkbox" id="19" name="USER_PSPORTS" value="복싱">복싱	
                		<input type="checkbox" id="20" name="USER_PSPORTS" value="태권도">태권도<br><br>
                </td>
            </tr>
            
        </table><br>
        <input type="submit" id="join" value="회원가입" >
    </form>
    <!-- Footer 영역  -->
	<jsp:include page="/WEB-INF/views/sport_comm/footer.jsp"/>

</body>
</html>