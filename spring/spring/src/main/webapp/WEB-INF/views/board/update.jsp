<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<title>게시글 수정</title>
</head>
<body>
<div class="container">
	<form action='<c:url value="/board/update"/>' method="post" enctype="multipart/form-data">
		<h1>게시글 수정</h1>
		<input type="hidden" name="bo_num" value="${board.bo_num}">
		<div class="form-group">
			<label for="bo_title">게시판</label>
			<select name="bo_co_num" class="form-contorl">
				<c:forEach items="${list}" var="co">
					<option value="${co.co_num}" <c:if test="${co.co_num == board.bo_num}">selected</c:if>>${co.co_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="bo_title">제목</label>
			<input type="text" class="form-control" id="bo_title" name="bo_title" value="${board.bo_title}">
		</div>
		<div class="form-group">
			<label for="bo_content">내용</label>
			<textarea class="form-control" id="bo_content" name="bo_content">${board.bo_content}</textarea>
		</div>
		<div class="form-group box-attachment">
			<label>첨부파일(위 forEach : 이미 있던 파일, 밑 : 수정해서 보낼 파일)</label>
			<c:forEach items="${fileList}" var="file">
				<div class="form-control">
					<span>${file.fi_ori_name}</span>
					<a href="javascript:void(0);" class="btn_del" data-num="${file.fi_num}">&times;</a>
				</div>
			</c:forEach>
			<c:forEach begin="1" end="${3 - fileList.size()}">
				<input type="file" class="form-control" name="file">
			</c:forEach>
		</div>
		<button class="btn btn-outline-success col-12">게시글 수정</button>
	</form>
</div>
<!-- 제목, 내용 유효성 검사 및 썸머노트 적용 -->
<script type="text/javascript"></script>
<!-- 첨부파일 X버튼 삭제 구현 --> 
<script type="text/javascript">
$(".btn_del").click(function() {
	let num = $(this).data("num");
	//input hidden 삭제한 첨부파일 번호를 추가 / "\${num}" 인 이유? 위의 자바스크립트 num을 가져와야 되서
	$(this).parents(".box-attachment").prepend(`<input type="hidden" name="delNums" value="\${num}">`);
	//input hidden 삭제한 첨부파일 번호를 추가(box-attachment) / 클릭한 버튼(this)의 부모(.box-attachment) 뒤에 붙임(append)
	$(this).parents(".box-attachment").append(`<input type="file" class="form-control" name="file">`);
	//클릭한 x버튼의 첨부파일을 삭제 / 클릭한 요소(this)의 부모(parent = div 태그)를 삭제(remove)
	$(this).parent().remove();
});
</script>
</body>
</html>