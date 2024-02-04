# 가입된 회원 전체를 조회
select * from member;

# 아이디가 id1인 회원의 정보를 조회
select * from member where id="id1";

#모든 회원의 아이디와 이메일을 조회
select id, email from member;

#2024년도에 가입한 회원을 조회
select * from member where REG_DATE like "2024-%";

# 이메일이 네이버인 회원을 조회
select * from member where email like "%_@naver.com";