# 대학생 관리 프로그램 물리적 설계(직접 작성)

# 1. DB 삭제
drop database if exists `university`;	-- 삭제하고 생성하는게 편함.
# 2. DB 생성
create database if not exists `university`;

# 3. DB 선택
use university;

# table 삭제 : 중간에 추가하면 원래 있던 테이블은 적용이 안되기 때문에 삭제해주고 다시 생성해서 desc로 확인한다.
drop table if exists Student;
# 4. table 생성
create table if not exists Student(
	st_num char(10) primary key, -- not null은 안넣나?
    st_name varchar(30) not null,
    st_major varchar(15) not null,
    st_grade int not null default 1
);
# table - result grid창
desc Student;

drop table if exists Professor;
create table if not exists Professor(
	pr_num char(10) primary key,
    pr_name varchar(30) not null,
    pr_room varchar(100), -- 안정해질 수도 있어서 null
    pr_major varchar(15) not null
);
desc Professor;

drop table if exists Lecture;
create table if not exists Lecture(
	le_num int primary key auto_increment, -- 자동으로 1 증가
    le_title varchar(30) not null,
    le_room varchar(20),
    le_schedule varchar(50) not null, -- 강의시간은 겹치면 안되서 not null
    le_point int not null default 0, -- 학점, 0으로 설정해놓은 이유는 pass같은 학점도 있기 때문
    le_time int not null default 0,
    le_pr_num char(10),
    foreign key(le_pr_num) references Professor(pr_num) -- desc로 확인하면 key에 MUL로 외래키로 지정되있다.
);
desc Lecture;

drop table if exists Course;
create table if not exists Course(
	co_num int primary key,
    co_st_num char(10) not null,
    foreign key(co_st_num) references Student(st_num),
    co_le_num int not null,
    foreign key(co_le_num) references Lecture(le_num)
);
desc Course;

drop table if exists Contact;
create table if not exists Contact(
	ct_st_num char(10) primary key,
    foreign key(ct_st_num) references Student(st_num),
    ct_phone varchar(11) not null,
    ct_addr varchar(30) not null,
    ct_detail varchar(30) not null default "" -- not null 후 빈 문자를 채우는게 용량에 효율적
);
desc Contact;
# 타입설정, not null 신경쓰기!
