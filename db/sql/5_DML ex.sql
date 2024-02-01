/*
테이블명만 쓰는 것과 DB명.테이블명을 쓰는 것의 차이
- 테이블명만 쓰는 경우는 내가 작업하려는 DB를 커서로 선택하고 사용
- DB명.테이블명은 현재 선택된 DB와 상관없이 작업할 수 있다.
	좀 더 안정적으로 쓰고 싶으면 앞에 DB명을 쓴다.
*/
# 테이블명만 사용할 때
use test;
insert into `member`() values();

# DB명.테이블명으로 사용할 때
insert into `test`.`member`() values();

# 쓰지 않는 속성들은 기본값으로 null로 들어간다. not null + 기본값이 없는 속성은 추가해줘야한다.
# 테이블에 등록된 컬럼 순서에ㅔ 상관 없이 추가할 때 나열한 컬럼 순서대로 값들을 넣어주면 됨.
insert into `test`.`member`(id, pw, email, REG_DATE) 
		values("abc", "def", "abc@naver.com", now());
insert into `test`.`member`(id, pw,REG_DATE ,email) 
		values("123", "456", now(), "123@naver.com");

# 속성명을 생략한 대신, 테이블에 등록된 컬럼 순서대로 값들을 넣어주어야 함.
insert into member values("id1", "pw1", "1@naver.com", now());
# now()를 이용해서 날짜를 문자열에 저장하면 날짜가 문자열로 변환되서 문제가 없음
# 하지만 날짜형태가 아닌 문자열을 datetime에 저장하려 하면 에러가 발생!
# insert into member values("id2", "pw2", now(), "2@naver.com");
# 날짜형태인 문자열을 datetime에 저장하려 하면 변환이 가능하기 때문에 정상 동작된다!
insert into member values("id2", "pw2", now(), "2024-02-01 16:25:00");

# 아이디가 id2인 회원의 이메일을 id2@naver.com으로 수정하는 쿼리
# 멤버테이블을 수정한다 / 이메일을 id@naver.com로 / id가 id2인 조건인 경우
update member set email = "id2@naver.com" where id = "id2";

# 아이디가 id1인 회원의 비번을 idabc로, 이메일을 idabc@naver.com으로 수정하는 쿼리
update member set pw = "idabc" where id = "id1";
update member set email = "idabc@naver.com" where id = "id1";

# 아이디가 abc인 회원의 정보를 삭제하는 쿼리
delete from member where id = "abc";

# member 테이블을 조회
select id, pw, email, REG_DATE from member;
# 모든 속성을 조회하는 경우 : *(전체)
select * from member;

# id가 id1인 회원의 정보를 조회
select * from member where id = "id1";
