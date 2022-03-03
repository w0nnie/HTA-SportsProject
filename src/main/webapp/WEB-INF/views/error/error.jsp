<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>오류 처리 페이지</title>
	<style>
		b{color:orange}
		body{text-align:center}
	</style>
</head>
<body>
	죄송합니다.<br>
	<img src="${pageContext.request.contextPath}/resources/image/tear3.png" width="100px"><br>
	요청하신 <b>${url}</b> 처리에 오류가 발생했습니다.
	<hr>
	${message}
</body>
</html>