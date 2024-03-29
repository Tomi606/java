<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<!-- 
	/login을 처리하는 서블릿을 추가한 후 login.jsp와 연결하는 작업
	2. jsp 생성
	 -->
	 <!-- 3. id와 pw를 입력받아 서버로 전송하는 코드를 작성(post방식(비번)으로 전송) 
	 method를 post로 해준다. 생략하면 기본 get으로
	 -->
	<form action="<c:url value="/login"/>" method="post">
		<h1>로그인</h1>
		<div class="mb-3 mt-3">
		    <label for="id" class="form-label">아이디:</label>
		    <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요." name="id">
		</div>
		<div class="mb-3 mt-3">
		    <label for="pw" class="form-label">비밀번호:</label>
		    <input type="password" class="form-control" id="pw" placeholder="비밀번호를 입력하세요." name="pw">
		</div>
		<button class="btn btn-outline-success col-12">로그인</button>
	</form>
	<!-- 
	session.setAttribute()는 세선에 정보를 저장하고,
	request.setAttribute()는 요청에 정보를 저장
	세션은 세션이 유지되는 동안에 다른 페이지에서도 사용 가능
	요청은 해당 url에 대해서만 사용 가능(새로고침 X)
	 -->
</div>
</body>
</html>