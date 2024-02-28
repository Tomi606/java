<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입, 2. jsp 생성</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url value="/"/>">KH Cafe</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
      	<c:if test="${user == null}">
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<c:url value="/login"/>">로그인</a>
	        </li>
      	</c:if>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<h1>회원가입</h1>
	<!-- 아이디, 비번, 비번확인, 이메일을 입력받아 서버로 전송하는 코드를 작성, get과 post 중에 선택해서 전송 -->
	<form action="<%=request.getContextPath() %>/signup" method="post">
	<div class="mb-3 mt-3">
	    <label for="id" class="form-label">아이디:</label>
	    <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요." name="id">
	</div>
	<div class="mb-3 mt-3">
	    <label for="pw" class="form-label">비번:</label>
	    <input type="password" class="form-control" id="pw" placeholder="비밀번호를 입력하세요." name="pw">
	</div>
	<div class="mb-3 mt-3">
	    <label for="pw2" class="form-label">비번확인:</label>
	    <input type="password" class="form-control" id="pw2" placeholder="비밀번호 확인" name="pw2">
	</div>
	<div class="mb-3 mt-3">
	    <label for="email" class="form-label">이메일:</label>
	    <input type="text" class="form-control" id="email" placeholder="이메일을 입력하세요." name="email">
	</div>
		<button class="btn btn-outline-success col-12">회원가입</button>
	</form>
</div>
</body>
</html>
	