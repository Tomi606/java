<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>게시글 상세</h1>
	<div>
		<label>제목</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<br>
	<div>
		<label>작성자 : ${board.bo_me_id}</label>
	</div>
	<div>
		<label>조회수 : ${board.bo_view}</label>
	</div>
	<div class="input-group mb-3 mt-3">
		<button class="btn btn-outline-success btn-up col-5">추천(${board.bo_up})</button>
		<hr>
		<button class="btn btn-outline-success btn-down col-5">비추천(${board.bo_down})</button>
	</div>
	<div>
	 	<label>내용</label>
	 	<textarea class="form-control">${board.bo_content}</textarea>
	</div>
	<div>
		<c:choose>
			<c:when test="${fileList.size() != 0}">
				<label>첨부파일</label>
				<c:forEach items="${fileList}" var="file">
					<a href='<c:url value="/download${file.fi_name}"/>'
						class="form-control"
						download="${file.fi_ori_name}">${file.fi_ori_name}
					</a>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>첨부파일 없음</div>
			</c:otherwise>
		</c:choose>
		<a href='<c:url value=""/>'></a>
	</div>
	<br>
	<c:url value="/board/list" var="url">
		<c:param name="page" value="${cri.page}"/>
		<c:param name="type" value="${cri.type}"/>
		<c:param name="search" value="${cri.search}"/>
	</c:url>
	<a href="${url}" class="btn btn-outline-dark">목록으로</a>
	<c:if test="${user.me_id == board.bo_me_id}">
		<a href='<c:url value="/board/delete?boNum=${board.bo_num}"/>' class="btn btn-outline-danger">삭제</a>
		<a href='<c:url value="/board/update?boNum=${board.bo_num}"/>' class="btn btn-outline-warning">수정</a>
	</c:if>
</div>
</body>
</html>