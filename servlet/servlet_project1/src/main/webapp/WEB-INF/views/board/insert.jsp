<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<form action="<c:url value="/board/insert"/>" method="post" enctype="multipart/form-data">
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
		    <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
		</div>
		<div class="mb-3 mt-3">
		    <label for="writer" class="form-label">작성자:</label>
		    <input type="text" class="form-control" id="writer" name="writer" value="${user.me_id}">
		</div>
		<div class="mb-3 mt-3">
		    <label for="content" class="form-label">내용:</label>
		    <textarea rows="10" class="form-control" id="content" name="content" placeholder="내용을 입력하세요."></textarea>
		</div>
		<div class="mb-3 mt-3">
		    <label for="content" class="form-label">첨부파일:</label>
		    <input type="file" class="form-control" name="file">
		    <input type="file" class="form-control" name="file">
		    <input type="file" class="form-control" name="file">
	  	</div>
		<button class="btn btn-outline-danger">글등록</button>
	</form>
</div>
<script type="text/javascript">
$('[name=content]').summernote({
    placeholder: 'Hello Bootstrap 4',
    tabsize: 2,
    height: 100
  });
</script>
</body>
</html>