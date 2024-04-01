<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<button class="btn1">json - json</button>
	<br>
	<button class="btn2">object - json</button>
	<br>
	<!-- 
	화면에서 이름과 나이를 입력받아 서버에 ajax로 전송하고,
	서버에서는 화면에서 보내준 이름과 나이를 콘솔에 출력하고,
	화면에 result값으로 "성공"을 전송.
	화면에서는 서버에서 보낸 result를 alert창으로 출력
	1. 화면 구성
	2. 이벤트 등록
	3. 이벤트에서 ajax로 통신하기 위해
		- 화면에 입력된 정보를 가져옴
		- ajax로 서버에 전송
		- 서버에서는 화면에서 보낸 정보를 받아서 콘솔에 출력
		- 서버에서 화면에 데이터를 전송
		- 화면에서는 서버에서 보낸 데이터를 alert창으로 출력
	 -->
	 <form action="">
		 <input type="text" name="name" placeholder="이름">
		 <br>
		 <input type="text" name="age" placeholder="나이">
		 <button type="submit" class="btn3">전송</button>
	 </form>
	 <button type="button" class="btn4">object - object</button>
	 
	<!-- btn1 -->
	<script type="text/javascript">
	//로그인할 때 참고(this와 return 잘 사용하기!)
		//서버에서 보낸 이름을 가져오는 함수
		function clickTest1(obj) {
			let name = "";
			$.ajax({
				//동기는 작업1이 다 끝날때까지 기다린 후 작업2가 실행
				//비동기는 작업1이 실행된 후, 끝날때까지 기다리지 않고 작업2가 실행
				async : false, //생략하면 true(비동기)
				url : '<c:url value="/ajax/json/json"/>', 
				type : 'post', 
				data : JSON.stringify(obj), //객체를 json형태의 문자열로 변환
				//서버로 보내는 데이터의 타입. 위에 있는 data의 타입
				contentType : "application/json; charset=utf-8",
				//서버에서 화면으로 보내는 데이터의 타입. 아래에 있는 success의 data 타입
				dataType : "json", 
				success : function (data){
					//서버에서 보낸 name과 회원 id, pw을 콘솔창에 출력하는 코드를 작성
					console.log(data.member.id);
					console.log(data.member.pw);
					console.log(data.name);
					//2번 this : succecss가 발생한 버튼
					$(this); //1번 this와 2번 this는 같다? (X)
							
					//clickTest1의 return을 원하지만 success에 구현한 함수에 
					//return을 지정하면 success함수의 결과를 리턴
					//return data.name; -> success에 대한 return이다. btn1에 대한 리턴이 아니기 때문에 undefined가 뜨는 것
					name = data.name;
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			console.log(data); //data는 ajax의 success 안의 매개변수이기 때문에 사용하지 X(에러 : data is not defined)
			//ajax가 끝난 다음 리턴해줘야 함
			return name;
		}
		$(".btn1").click(function(){
			let obj = {
				id : "abc",
				pw : "def"
			}
			//1번 this : 클릭 이벤트가 발생한 버튼
			$(this); //이벤트가 발생한 요소를 this를 통해 사용 가능
			//작업1
			let name = clickTest1(obj);
			console.log(name);
			//작업2
		});
	</script>
	
	<!-- btn2 -->
	<script type="text/javascript">
		$(".btn2").click(function() {
			let obj = {
				id : "abc",
				name : "홍길동"
			}
			$.ajax({
				async : true, 
				url : '<c:url value="/ajax/test"/>', 
				type : 'get', 
				data : obj, 
				dataType : "json", 
				success : function (data){
					console.log(data.age);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>

	<!-- btn3 -->
	<script type="text/javascript">
		$("form").submit(function() {
			//serialize() : form 태그 안의 name들을 하나의 문자열로 만들어 준다. name명=값& 형태로
			let obj = $(this).serialize();
			//object -> json
			$.ajax({
				async : true, 
				url : '<c:url value="/ajax/object/json2"/>', 
				type : 'get', 
				data : obj, 
				dataType : "json", 
				success : function (data){
					alert(data.result);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			return false;
		});
	</script>
	
	<!-- btn4 -->
	<script type="text/javascript">
		$(".btn4").click(function() {
			let obj = {name : "홍길동"};
			$.ajax({
				async : true, 
				url : '<c:url value="/ajax/object/object"/>', 
				type : 'get', 
				data : obj, 
				success : function (data){
					console.log(data)
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
	
	
</body>
</html>