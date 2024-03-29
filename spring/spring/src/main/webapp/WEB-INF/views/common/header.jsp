<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href='<c:url value="/"/>'>Logo</a>
	<ul class="navbar-nav">
		<c:if test="${user == null}">
			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/signup"/>'>회원가입</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/login"/>'>로그인</a>
			</li>
		</c:if>
		<c:if test="${user != null}">
			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/board/list"/>'>게시글</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/mypage"/>'>내 정보</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href='<c:url value="/logout"/>'>로그아웃</a>
			</li>
		</c:if>
	</ul>
</nav>