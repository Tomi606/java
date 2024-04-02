<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<body>
<div class="container">
	<h1 class="mt-3">회원가입</h1>	
	<form action='<c:url value="/signup"/>' method="post">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" class="form-control" id="id" name="me_id" required placeholder="Enter id">
		</div>
		<div class="form-group">
			<label for="pw">비번</label>
			<input type="password" class="form-control" id="pw" name="me_pw" required placeholder="Enter pw">
		</div>
		<div class="form-group">
			<label for="pw2">비번확인</label>
			<input type="text" class="form-control" id="pw2" name="me_pw2" placeholder="Enter pw2">
		</div>
		<div class="form-group">
			<label for="email">이메일</label>
			<input type="email" class="form-control" id="email" name="me_email" required placeholder="Enter email">
		</div>
		<button class="btn btn-outline-success col-12" type="submit">회원가입</button>
	</form>
</div>
</body>
</html>