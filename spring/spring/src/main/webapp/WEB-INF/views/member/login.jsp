<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<form action='<c:url value="/login"/>' method="post">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter id" >
		</div>
		<div class="form-group">
			<label for="pw">비번</label>
			<input type="password" class="form-control" id="pw" name="pw" placeholder="Enter pw">
		</div>
		<div class="form-check">		
			<label class="form-check-labe">
				<input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
			</label>
		</div>
		<button class="btn btn-outline-success col-12">로그인</button>
	</form>
</div>
</body>
</html>