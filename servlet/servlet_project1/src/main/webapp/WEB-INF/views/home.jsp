<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
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
     	<li class="nav-item">
        	<a class="nav-link" href="<c:url value="/board/list"/>">게시글</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<h1>메인페이지</h1>
	<c:forEach begin="1" end="4" var="i">
	${i },
	</c:forEach>
	<c:set var="name" value="홍길동"/>
	${name}
	<c:if test='${name == "홍길동" }'>홍길동입니다.</c:if>
	<input tpye="text" value="${id }">
	<c:choose>
		<c:when test='${name == "홍길동" }'>홍길동입니다.</c:when>
		<c:otherwise>홍길동이 아닙니다.</c:otherwise>
	</c:choose>
	<br>
	<c:forTokens items="a/b/c/d" delims="/" var="ch">${ch }</c:forTokens>
	<br>
	<c:url value="/">
		<c:param name="name" value="홍길동"/>
		<c:param name="age" value="30"/>
	</c:url>
</div>
</body>
</html>