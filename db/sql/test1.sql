# 유저 생성 아이디 비밀번호
-- 계정명이 abc, 비번이 abc이고 내부에서만 접근 가능한 계정을 생성하는 쿼리
-- 계정 생성 시 비밀번호는 생략될 수 있지만 보안을 위해 비번을 설정해야 함
-- 계정 생성 권한이 있는 사용자만(root) 계정을 추가할 수 있다.
create user 'abc'@'localhost' identified by 'abc';
create user 'def'@'localhost' identified by 'def';
-- def계정으로 접속해서 계정 추가를 시도하면
-- you need (at least one of) the CREATE USER privilege(s) for this operation 에러 발생
# create user 권한을 부여하면 계정을 생성할 수 있다.
grant create user on *.* to 'def'@'localhost';
select * from mysql.user;
flush privileges;

# 모든 사용자 계정을 조회하는 쿼리. mysql이라는 db에 user라는 테이블 조회
select * from mysql.user;
# abc 계정에 모든 DB에 접근하는 권한을 부여(all privileges : 모든 권한)
-- grant : 권한 부여
grant all privileges on *.* to 'abc'@'localhost';
-- abc 계정에게 account의 모든 테이블(on account.*)에 대한 모든 권한 부여
grant all privileges on account.* to 'abc'@'localhost';

# 각 DB별 사용자 계정 권한을 조회하는 쿼리
select * from mysql.db;
# abc 계정에 계정 생성(create user) 권한만 부여
grant create user on *.* to 'abc'@'localhost';

# MySQL 에서는 AND 연산자가 OR 연산자 보다 우선 순위가 높다.(AND > OR)
-- A or B and C와(A or B) and C는 결과가 다름
-- 그래서  or 연산자를 먼저 계산하려면 ()를 반드시 붙여야 함

# 속성값이 null이 아닌 값만 조회하는 쿼리
select * from 테이블명 where 속성 is not null;

# %가 들어간 문자열을 검색할 때
select * from 테이블명 where 속성 like '%\%%';
# 제품명에 '우' 라는 글자가 포함된 제품을 조회하는 쿼리
use shoppingmall;
select * from product where pr_title like '%우%';
# 제품명에 '%' 라는 글자가 포함된 제품을 조회하는 쿼리 
select * from product where pr_title like '%\%%';
-- %%%는 전체 조회, %를 문자로 인식하려면 "역슬래시(\)"를 써준다. -> %\%%

# 제품 가격순으로 순위를 추가해서 조회
-- row_number() : 값이 같더라도 다른 번호를 부여
-- row_number() over(order by 속성) : 검색 결과에 순서를 부여
select row_number() over(order by pr_price desc) as '순위', product.* 
from product;
select *, row_number() over(order by pr_price desc) as '순위'
from product;
-- 검색 결과를 이용하여 조건을 작업하려면 서브쿼리를 이용해야 함.
select * from
(select 속성들, row_number() over(order by 속성 desc|asc) as 순서 from 테이블명) as tmp
where 순서 > 3;
# 제품 가격순으로 순위를 추가해서 3위 까지 조회
select * from
(select row_number() over(order by pr_price desc) as '순위', product.* from product) 
as product_tmp
where 순위 <= 3;


# 조건에 집계함수 결과를 이용하려면 having 절에 조건을 추가해야 함
select 테이블명.*, count(속성명2) as 개수 from 테이블명
group by 속성명
having 개수 >= 5;

# 각 카테고리별 제품 가격 평균을 조회
select pr_ca_num, floor(avg(pr_price)) as '가격평균'
from product
group by pr_ca_num;
# 각 카테고리별 제품 가격이 평균이 6500원 이상인 카테고리를 조회
select pr_ca_num, floor(avg(pr_price)) as '가격평균'
from product
group by pr_ca_num
-- avg가 집계함수라서 where절 말고 having절을 사용
having 가격평균 >= 6500;

# M(member)테이블 생성
create table M(
	id varchar(10) primary key,
    pw varchar(20) not null
);

# B(board) 테이블 생성
create table B(
	num int primary key,
    title text,
    id varchar(10)
);

insert into B values(1, 'abc123', 'abc123');
insert into M values('제목1', 'abc123');

# 테이블 B의 id 속성이 테이블 M의 id 속성에 참조되는 경우 join 하는 쿼리
select * from B join M on B.id = M.id;
select * from B join M using(id);

select * 
from B
join M on m.id = b.id;
-- using(id) = on m.id = b.id
-- using 사용 조건 : 속성이름이 같을 때 사용, 속성이름이 다르면 사용 X
-- B 테이블에 id가 있고, M 테이블에 id가 있을 때 using 사용
select * from B join M using(id);

# 시험과목 3개