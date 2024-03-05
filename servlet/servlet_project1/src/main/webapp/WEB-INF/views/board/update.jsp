<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="/board/update"/>" method="post" enctype="multipart/form-data">
		<h1>게시글 수정</h1>
	<!-- hidden으로 보드 넘버를 가림 -->
		<input type="hidden" name="num" value="${board.bo_num}">
		<div class="mb-3 mt-3">
		    <label for="community" class="form-label">게시판:</label>
		    <select class="form-control" id="community" name="community">
		    	<c:forEach items="${list}" var="community">
			    	<option value="${community.co_num}">${community.co_name}</option>
		    	</c:forEach>
		    </select>
		</div>
		<div class="mb-3 mt-3">
		    <label for="title" class="form-label">제목:</label>
		    <input type="text" class="form-control" id="title" name="title" value="${board.bo_title}" placeholder="제목을 입력하세요.">
		</div>
		<div class="mb-3 mt-3">
		    <label for="writer" class="form-label">작성자:</label>
		    <input type="text" class="form-control" id="writer" name="writer" value="${user.me_id}" readonly>
		</div>
		<div class="mb-3 mt-3">
		    <label for="content" class="form-label">내용:</label>
		    <textarea rows="10" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">${board.bo_content}</textarea>
		</div>
		<div class="mb-3 mt-3" id="attachment">
		    <label class="form-label">첨부파일:</label>
		    <c:choose>
		    	<c:when test="${file != null }">
		    		<span class="form-control">${file.fi_ori_name} <a id="btnDel" class="text-right" data-target="${file.fi_num}">X</a> </span>
		    	</c:when>
		    	<c:otherwise>
		    		<input type="file" name="file" class="form-control">
		    	</c:otherwise>
		    </c:choose>
		</div>
		<button class="btn btn-outline-danger col-12">글수정</button>
	</form>
	<!-- a태그가 아니라 -> button 태그로 수정 후 value도 삭제 -->
</div>
<script type="text/javascript">
	let btnDel = document.querySelector("#btnDel");
	let attachment = document.querySelector("#attachment");
	btnDel.onclick = function(e) {
		e.preventDefault();
		//input hidden으로 삭제할 첨부파일 번호를 추가
		let num = this.getAttribute("data-target");
		let str = `<input type="hidden" name="fi_num" value="\${num}"`;
		attachment.innerHTML += str;
		//span 태그를 삭제함
		let span = attachment.querySelector("span.form-control");
		attachment.removeChild(span);
		let input = `<input type="file" name="file">`;
		attachment.innerHTML += input;
	}
</script>
</body>
</html>