<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 세부사항</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<!-- readonly - 서버로 전송가능, 읽기만 가능(수정 불가능) -->
<div class="container">
	<c:choose>
		<c:when test="${board != null }">
			<h1>게시글 상세</h1>
			<div>
				<div class="mb-3 mt-3">
				    <label for="community" class="form-label">게시판:</label>
				    <input type="text" class="form-control" id="community" name="community" readonly value="${board.community.co_name}">
			  	</div>
				<div class="mb-3 mt-3">
				    <label for="title" class="form-label">제목:</label>
				    <input type="text" class="form-control" id="title" name="title" readonly value="${board.bo_title }">
			  	</div>
			  	<div class="mb-3 mt-3">
				    <label for="writer" class="form-label">작성자:</label>
				    <input type="text" class="form-control" id="writer" name="writer" readonly value="${board.bo_me_id }">
			  	</div>
			  	<div class="mb-3 mt-3">
				    <label for="view" class="form-label">조회수:</label>
				    <input type="text" class="form-control" id="view" name="view" readonly value="${board.bo_view }">
			  	</div>
			  	<div class="mb-3 mt-3 clearfix">
			  		<button type="button" id="btnUp" data-state="1" class="btn btn-outline-success col-5 float-start">추천</button>
			  		<button type="button" id="btnDown" data-state="-1" class="btn btn-outline-danger col-5 float-end">비추천</button>
			  	</div>
			  	<div class="mb-3 mt-3">
				    <label for="content" class="form-label">내용:</label>
				    <div class="form-control" style="min-height: 400px;">${board.bo_content}</div>
				    <textarea rows="10" class="form-control" id="content" name="content" readonly>${board.bo_content }</textarea>
			  	</div>
			  	<c:if test="${fileList != null && fileList.size() != 0}">
				  	<div class="mb-3 mt-3">
					    <label for="content" class="form-label">첨부파일:</label>
					    <c:forEach items="${fileList}" var="file">
					  	  <a href="<c:url value="/download?filename=${file.fi_name}"/>" class="form-control" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
					    </c:forEach>
				  	</div>
			  	</c:if>
			  	<a href="<c:url value="/board/list"/>" class="btn btn-outline-dark">목록으로</a>
			  	<c:if test="${board.bo_me_id == user.me_id }">
			  		<a href="<c:url value="/board/delete?num=${board.bo_num}"/>" class="btn btn-outline-danger">삭제</a>
			  		<a href="<c:url value="/board/update?num=${board.bo_num}"/>" class="btn btn-outline-danger">수정</a>
			  	</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<h1>등록되지 않은 게시글이거나 삭제된 게시글입니다.</h1>
		</c:otherwise>
	</c:choose>
</div>
<script type="text/javascript">
	let btnUp = document.getElementById("btnUp");
	let btnDown = document.getElementById("btnDown");
	
	btnUp.onclick = recommend;
	
	btnDown.onclick = recommend;
	
	function recommend() {
		//로그인 안했으면
		if('${user.me_id}' == '') {
			//확인 누르면 로그인 페이지로
			if(confirm("로그인이 필요한 서비스입니다. 로그인으로 이동하겠습니까?")) {
				location.href = "<c:url value='/login'/>"
			}
			//취소 누르면 현재 페이지에서 추천/비추 동작 안함
			else {
				return;
			}
		}
		
		let boNum = '${board.bo_num}';
		//state가 1이면 추천, -1이면 비추천
		let state = this.getAttribute("data-state");
		
		//비동기 boNum과 state를 보냄
		fetch(`<c:url value="/recommend"/>?boNum=\${boNum}&state=\${state}`)
		.then(response => response.text())
		.then(data => {
			let str = state == 1 ? '추천' : '비추천';
			switch(data) {
			case "1" : alert('게시글을 추천했습니다.'); break;
			case "-1" : alert('게시글을 비추천했습니다.'); break;
			case "0" : alert(`게시글 \${str}을 취소했습니다.`); break;
			default : alert(data);
			}
		})
		.catch(error => console.error(error));
	}
</script>
</body>
</html>