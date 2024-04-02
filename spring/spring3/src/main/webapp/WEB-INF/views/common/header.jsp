<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="nav-link" href="#">Link 1
				<img src='<c:url value="/resources/img/bird.jpg" alt="logo" style="width:30px"/>'>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">Link 2</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">Link 3</a>
		</li>
	</ul>
</nav>
</body>
</html>