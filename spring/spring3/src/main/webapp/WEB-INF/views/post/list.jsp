<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
<div class="container">
	<h1 class="mt-3">게시글 목록</h1>
	<form action='<c:url value="/post/list"/>' method="get" id="searchForm">
		<div class="input-group mb-3">
			<select name="type" class="form-control">
				<option value="all" <c:if test="${pm.cri.search == 'all'}">selected</c:if>>전체</option>
				<option value="title" <c:if test="${pm.cri.search == 'title'}">selected</c:if>>제목</option>
				<option value="writer" <c:if test="${pm.cri.search == 'writer'}">selected</c:if>>작성자</option>
			</select>
			<input type="text" name="search" value="${pm.cri.search}" class="form-control">
			<button class="btn btn-outline-success">검색</button>
		 </div>
		 <select class="form-control col-4 mb-3 offset-8" name="order">
		 	<option value="bo_num" <c:if test="${pm.cri.order == 'bo_num'}">selected</c:if>>최신순</option>
		 	<option value="bo_view" <c:if test="${pm.cri.order == 'bo_view'}">selected</c:if>>조회수순</option>
		 </select>
	</form>
	<table class="table table-hover">
		<thead>
			<tr>
			  <th>번호</th>
			  <th>제목</th>
			  <th>작성자</th>
			  <th>리뷰</th>
			</tr>
		</thead>
		<tbody>
		<!-- 변수정보를 varStatus에 의해서 확인가능, 순서대로 번호가 나온다. vs.index 또는 vs.count -->
			<c:forEach items="${list}" var="post" varStatus="vs"> 
				<tr>
				  <td>${pm.totalCount - vs.index - pm.cri.pageStart}</td>
				  <td>
					<a href='<c:url value="/post/detail?num=${post.bo_num}"/>'>${post.bo_title}</a>
				  </td>
				  <td>${post.bo_me_id}</td>
				  <td>${post.bo_view}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value='/post/insert'/>" class="btn btn-outline-success col-2 mb-3 offset-10">
	게시글 등록
	</a>
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">		
			<li class="page-item">
				<c:url var="url" value="/post/list">
					<c:param name="page" value="${pm.startPage - 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="order" value="${pm.cri.order}"/>
				</c:url>
				<a class="page-link" href="${url}">이전</a>
			</li>
		</c:if>
		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
			<c:set var="active" value="${pm.cri.page == i ? 'active' : ''}"/>
			<li class="page-item ${active}">
				<c:url var="url" value="/post/list">
					<c:param name="page" value="${i}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="order" value="${pm.cri.order}"/>
				</c:url>
				<a class="page-link" href="${url}">${i}</a>
			</li>
		</c:forEach>
		<c:if test="${pm.next}">		
			<li class="page-item">
				<c:url var="url" value="/post/list">
					<c:param name="page" value="${pm.endPage + 1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="order" value="${pm.cri.order}"/>
				</c:url>
				<a class="page-link" href="${url}">다음</a>
			</li>
		</c:if>
	</ul>
</div>
<script type="text/javascript">
$('[name=order]').change(function() { //이벤트 등록
	$("#searchForm").submit(); //이벤트 실행
});
</script>
</body>
</html>
