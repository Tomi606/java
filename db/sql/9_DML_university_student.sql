/*
학과 코드 번호
컴퓨터 공학 : 160
화학 공학 : 135
기계 공학 : 123
전공이 컴퓨터 공학인 신입생이 5명이고, 5명을 등록하는 쿼리
컴공 학생 : 홍길동, 임꺽정, 유재석, 둘리, 고길동

전공이 화학 공학인 신입생이 3명이고, 3명을 등록하는 쿼리
나영석, 강호동, 이수근

전공이 기계 공학인 신입생이 3명이고, 3명을 등록하는 쿼리
가나다, 박두리, 마루리
# 학번은 계산해서 넣으세요.
*/

# drop, create 데이터베이스를 만들고 use 데이터베이스 코드를 생성
-- drop database if exists university;
-- create database if not exists university;
-- use university;

# 전공에 맞게 학생들을 등록한다(insert student)
insert into student(st_num, st_name, st_major) values
("2024160001", "고길동", "컴퓨터공학"),
("2024160002", "둘리", "컴퓨터공학"),
("2024160003", "유재석", "컴퓨터공학"),
("2024160004", "임꺽정", "컴퓨터공학"),
("2024160005", "홍길동", "컴퓨터공학");
insert into student(st_num, st_name, st_major) values
("2024135001", "강호동", "화학공학"),
("2024135002", "나영석", "화학공학"),
("2024135003", "이수근", "화학공학");
insert into student(st_num, st_name, st_major) values
("2024123001", "가나다", "기계공학"),
("2024123002", "마루리", "기계공학"),
("2024123003", "박두리", "기계공학");
select * from student;

# 교수 등록
# 신입교수 박교수 3관 101호 컴퓨터공학
insert into professor(pr_num, pr_name, pr_room, pr_major) values ("2024160001", "박교수", "3관 101호", "컴퓨터공학");
# 신입교수 이교수 3관 201호 화학공학
insert into professor(pr_num, pr_name, pr_room, pr_major) values ("2024135001", "이교수", "3관 201호", "화학공학");
# 신입교수 김교수 3관 301호 기계공학
insert into professor(pr_num, pr_name, pr_room, pr_major) values ("2024123001", "김교수", "3관 301호", "기계공학");
select * from professor;

# 강의 등록
# 컴퓨터개론, 1관 101호, 월 1A,1B,2A,2B, 2학점, 2시간, 2024160001(컴퓨터공학 박교수(교번입력))
insert into lecture
		-- auto-increment가 되어 있기 때문에 null을 사용
        -- 1,2,3이 아니라 null로 했기 때문에 중복으로 들어갈 수 있다.(1,2,3으로 하면 지정했기 때문에 충돌이 나서 안들어간다)
values (null, "컴퓨터개론", "1관 101호", "월 1A,1B,2A,2B", 2, 2, "2024160001");
# 프로그래밍언어, 1관 101호, 월 5A,5B,6A,6B, 수 5A,5B,5A,5B, 3학점, 4시간, 2024160001
insert into lecture 
values (null, "프로그래밍언어", "1관 101호", "월 5A,5B,6A,6B, 수 5A,5B,5A,5B", 3, 4, "2024160001");
# 화학 기초, 2관 101호, 화 1A,1B,2A,2B, 금 1A,1B,2A,2B, 3학점, 4시간, 2024135001
insert into lecture 
values (null, "화학 기초", "2관 101호", "화 1A,1B,2A,2B, 금 1A,1B,2A,2B", 3, 4, "2024135001");
# 동역학, 4관 101호, 수 1A,1B,2A,2B,3A,3B,4A,4B, 3학점, 4시간, 2024123001
insert into lecture 
values (null, "동역학", "4관 101호", "수 1A,1B,2A,2B,3A,3B,4A,4B", 3, 4, "2024123001");
select * from lecture;

# 수강 신청(course)
# 컴공 고길동, 임꺽정 학생은 컴퓨터개론, 프로그래밍 언어를 수강 신청
							-- co_num이 AI(auto_increment)가 선택되지 않아서 에러
insert into course(co_st_num, co_le_num) values
("2024160001", 1),
("2024160001", 2),
("2024160004", 1),
("2024160004", 2);
# 컴공 둘리, 홍길동 학생은 컴퓨터개론을 수강 신청
insert into course(co_st_num, co_le_num) values
("2024160002", 1),
("2024160005", 1);
# 컴공 유재석 학생은 프로그래밍 언어를 수강 신청
insert into course(co_st_num, co_le_num) values
("2024160003", 2);
#화공 강호동, 나영석 학생은 화학기초를 수강 신청
insert into course(co_st_num, co_le_num) values
("2024135001", 3),
("2024135002", 3);
# 기공 가나다, 박두리, 마루리 학생은 동역학을 수겅 신청
insert into course(co_st_num, co_le_num) values
("2024123001", 4),
("2024123002", 4),
("2024123003", 4);
# 기공 가나다 학생은 프로그래밍 언어를 수강 신청
insert into course(co_st_num, co_le_num) values
("2024123001", 2);
select * from course;




