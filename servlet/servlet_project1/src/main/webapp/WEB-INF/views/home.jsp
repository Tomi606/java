<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath() %>/">KH Cafe</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/signup">회원가입</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/login">로그인</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	<%
	//java를 이용하고 싶으면 <%%.>태그사용
	int num = 10;
	%>
	<h1>메인 페이지입니다.</h1>
	<a href="<%=request.getContextPath() %>?data=안녕">데이터 전송</a>
	<form action="<%=request.getContextPath() %>">
		<h2>form태그 get방식 전송</h2>
		<input type="text" name="id">
		<button>전송</button>
	</form>
	<h1><%=num %></h1>
	<h1><%=request.getContextPath() %>1</h1>
	<!-- 복붙해서 사용할 때contextPath가 달라도 정상적으로 작동된다. -->
	
	<!-- /login을 처리하는 서블릿을 추가한 후 login.jsp와 연결하는 작업 -->
	<a href="<%=request.getContextPath() %>/login">로그인으로</a>
	<!-- /signup을 처리하는 서블릿을 추가한 후 signup.jsp와 연결하는 작업 -->
	<a href="<%=request.getContextPath() %>/signup">회원가입으로</a>
	
	<h1>서버에서 보낸 나이 : ${age}</h1>
	
	<script type="text/javascript">
		let age = 20;
		let str = `나이 : \${age}`;
		console.log(str);
	</script>
	${user}
	${age}
</body>
</html>