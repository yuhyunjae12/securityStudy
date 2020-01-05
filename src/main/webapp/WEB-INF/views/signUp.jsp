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

<div>회원 가입</div>

	<form:form action="/signUp" method="POST">
		아아디 : <input type="text" name="id" />
		<br/>
		비빌번호 : <input type="text" name="pw"/>
		<br/>
		이름 : <input type="text" name="name"/>
		<input type="submit" value="가입" />
		<sec:csrfInput />
	</form:form>

</body>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</html>