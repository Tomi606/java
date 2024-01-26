let list = [];
function btnClick() {
	//입력한 제목, 내용, 작성자를 가져옴
	// 입력하는 표준 속성은 value이기 때문에 뒤에 붙여준다.
	let title = $("#title").val();
	let writer = $("#writer").val();
	let content = $("#content").val();
	let num;

	//리스트 배열이 0이면 / ! = false = 0
	if(!list.length) {
		num = 1;
	}else{
		num = parseInt(list[0]["num"]) + 1; //정수로 변환 후 더해줌
	}
	let view = 0;
	// 가져온 제목, 내용, 작성자와 번호, 조회수(0)를 이용해서 {객체}를 생성
	let obj = {
		// 속성이름 : 값, 변수이름과 값이 같으면 하나만 적어도됨
		num,
		title, //title : title;
		writer,
		view,
		content
	}
	// 모든 내용을 입력안하면 나오는 메세지
	if(!checkBoard(obj)) {
		alert("모든 항목은 필수 항목입니다.");
		return false;
	}
	//생성된 객체를 배열에 앞에 추가
	list.unshift(obj);
	// display 함수를 호출 : table에 list를 출력하는 함수
	display(list);
	// 입력값들을 비워줌
	initForm();
	// return false를 통해 서버로 전송되는 것을 막아줌
	// return false는 form 태그의 submit으로 가서 서버로 전송되는걸 막음
	return false;
}

// 리스트에서 num(게시글번호)와 일치하는 게시글 번호를 가진 게시글을 반환하는 함수
function getBoard(list, num) {
	// let i=0;list.length;i++ = board of list
	for(board of list) {
		if(board["num"] == num) {
			return board;
		}
	}
	return null;
}

// 제목을 클릭하면 모달 박스가 뜸
function linkClick() {
	$(".modal-box").show();
	let num = $(this).data("num");
	console.log(num);
	let board = getBoard(list, num);
	console.log(board);
	if(board) {
		++board["view"];
		// 번호, 제목, 작성자, 조회수, 내용 구성 후 모달창에 출력 : html 코드를 문자열로
		let html = 
		`
		<h1>게시글 상세</h1>
		<div class="input-box">
			<label class="label">번호 : </label>
			<input type="text" name="num" class="input" readonly value = "${board.num}"> 
		</div>
		<div class="input-box">
			<label class="label">제목 : </label>
			<input type="text" name="title" class="input" readonly value = "${board.title}"> 
		</div>
		<div class="input-box">
			<label class="label">작성자 : </label>
			<input type="text" name="writer" class="input" readonly value = "${board.writer}"> 
		</div>
		<div class="input-box">
			<label class="label">조회수 : </label>
			<input type="text" name="view" class="input" readonly value = "${board.view}">
		</div>
		<div class="input-box">
			<label class="label">내용 : </label>
			<textarea name="content" rows="10" class="input text-area" readonly>${board.content}</textarea>
		</div>
		`;
		$(".modal-box .content-box").html(html);
	}else {
		// 없는 게시글입니다를 구성해 모달창에 출력
		let html = "<h1>없는 게시글입니다.</h1>";
		$(".modal-box .content-box").html(html);
	}
}

// display 함수
function display(list) {
	// list가 비어있으면
	if(!list.length) {
		let tr = 
		`<tr>
			<th colspan="4">등록된 게시글이 없습니다.</th>
		</tr>`;
		$("tbody").html(tr);
		return;
	}
	$("tbody").empty();
	//list가 비어 있지 않으면
	// 리스트가 있으면 반복문으로 list 전체를 반복
	for(let i=0;i<list.length;i++) {
		// tr 태그 생성
		let tr = `<tr>`;
		// 반복문 : list[i]에 있는 객체를 반복문으로 속성 값을 꺼냄, for in
		for(let key in list[i]) {
			if(key == "content") {
				continue;
			}
			let obj = list[i]; //리스트에서 꺼낸 객체 하나를 obj라 함
			if(key != "title") {
				tr += `<td class="${key}">${obj[key]}</td>`;
			}else {
				tr +=
				`
				<td class="${key}">
					<a href="#" class="link" data-num="${obj["num"]}">${obj[key]}</a>	
				</td>
				`;
			}
		}
		tr += `</tr>`; //닫는 태그
		// tbody 태그에 tr 태그를 추가
		$("tbody").append(tr);
	}
}

// 게시글에 빈 항목이 있는지 없는지 알려주는 함수(jquery에선 필요없다)
function checkBoard(board) {
	if(!board) {
		return false;
	}
	//board가 객체가 아니면(실수로 정수로 넘겨주는 경우 등)
	if(typeof board != "object") {
		return false;
	}
	// 제목체크, trim : 앞뒤공백 지워줌
	if(!board["title"].trim().length) {
		return false;
	}
	// 작성자 체크
	if(!board["writer"].trim().length) {
		return false;
	}
	// 내용 체크
	if(!board["content"].trim().length) {
		return false;
	}
	return true;
}

// form 태그의 입력값들을 초기화 하는 함수
function initForm() {
	// input = 제목, 작성자, 내용
	$(".input").val("");
}