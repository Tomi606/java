<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<form action='<c:url value="/login"/>' method="post">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" class="form-control" id="id" name="me_id" required placeholder="Enter id">
		</div>
		<div class="form-group">
			<label for="pw">비번</label>
			<input type="password" class="form-control" id="pw" name="me_pw" required placeholder="Enter pw">
		</div>
		<button type="submit" class="btn btn-outline-success col-12">로그인</button>
	</form>
</div>
</body>
</html>