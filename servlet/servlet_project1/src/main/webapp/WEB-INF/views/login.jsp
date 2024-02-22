<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<!-- 
	/login을 처리하는 서블릿을 추가한 후 login.jsp와 연결하는 작업
	2. jsp 생성
	 -->
	 <!-- 3. id와 pw를 입력받아 서버로 전송하는 코드를 작성(post방식(비번)으로 전송) 
	 method를 post로 해준다. 생략하면 기본 get으로
	 -->
	<form action="<%=request.getContextPath() %>/login" method="post">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="password" name="pw" placeholder="비번"><br>
		<button>로그인</button>
	</form>
</body>
</html>