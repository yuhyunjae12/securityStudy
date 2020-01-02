<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>로그인 성공</div>

	<form action="/logout" method="POST">
		<input type="submit" value="로그아웃" />
	</form>

</body>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</html>