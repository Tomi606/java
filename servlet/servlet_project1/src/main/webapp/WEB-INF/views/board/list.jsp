<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
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
	<h1>게시글 리스트</h1>
	<form action="<c:url value="/board/list"/>" class="mb-3 mt-3">
		<div class="input-group">
			<select name="type" class="form-control">
				<option value="all" <c:if test='${pm.cri.type == "all"}'>selected</c:if>>전체</option>
				<option value="title" <c:if test='${pm.cri.type == "title"}'>selected</c:if>>제목</option>			
				<option value="writer" <c:if test='${pm.cri.type == "writer"}'>selected</c:if>>작성자</option>
			</select>
			<input type="text" class="form-control" name="search" value="${pm.cri.search}" placeholder="search">
			<button class="btn btn-outline-warning">검색</button>
		</div>
	</form>
	<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>게시판</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
		    <c:forEach items="${list}" var="board">	    
		      <tr>
		        <td>${board.bo_num}</td>
		        <td>${board.community.co_name}</td>
		        <td>
		        	<a href="">${board.bo_title}</a>
		        </td>
		        <td>
		        	<a href="">${board.bo_me_id}</a>
		        </td>
		        <td>${board.bo_view}</td>
		      </tr>
		    </c:forEach>
		    <c:if test="${list.size() == 0}">
		    	<tr>
		    		<th colspan="5">
		    			<h3>등록된 게시글이 없습니다.</h3>
		    		</th>
		    	</tr>
		    </c:if>
		    
	    </tbody>
 	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<li class="page-item">
				<c:url var="prevUrl" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${pm.startPage-1}"/>
				</c:url>
				<a class="page-link" href="${prevUrl}">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
				<c:url var="page" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${i}"/>
				</c:url>
				<a class="page-link" href="javascript:void(0);">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">
			<li class="page-item">
				<c:url var="nextUrl" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${pm.endPage+1}"/>
				</c:url>
				<a class="page-link" href="${nextUrl}">다음</a>
			</li>
		</c:if>
	</ul>
	<a href="<c:url value="/board/insert"/>" class="btn btn-outline-danger">글등록</a>
</div>
</body>
</html>