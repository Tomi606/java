# 유저 생성 아이디 비밀번호
-- 계정명이 abc, 비번이 abc이고 내부에서만 접근 가능한 계정을 생성하는 쿼리
create user 'abc'@'localhost' identified by 'abc';
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
# A or B and C와(A or B) and C는 결과가 다름

# 제품명에 '우' 라는 글자가 포함된 제품을 조회하는 쿼리
use shoppingmall;
select * from product where pr_title like '%우%';
# 제품명에 '%' 라는 글자가 포함된 제품을 조회하는 쿼리 
select * from product where pr_title like '%\%%';
-- %%%는 전체 조회, %를 문자로 인식하려면 "역슬래시(\)"를 써준다. -> %\%%

# 제품 가격순으로 순위를 추가해서 조회
-- row_number() : 값이 같더라도 다른 번호를 부여
select row_number() over(order by pr_price desc) as '순위', product.* 
from product;
select *, row_number() over(order by pr_price desc) as '순위'
from product;
# 제품 가격순으로 순위를 추가해서 3위 까지 조회
select * from
(select row_number() over(order by pr_price desc) as '순위', product.* from product) 
as product_tmp
where 순위 <= 3;

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

insert into B values('abc123', 'abc123');
insert into M values(1, '제목1', 'abc123');
select * 
from B
join M on m.id = b.id;
-- using(id) = on m.id = b.id
-- using 사용 조건 : 속성이름이 같을 때 사용, 속성이름이 다르면 사용 X
-- B 테이블에 id가 있고, M 테이블에 id가 있을 때 using 사용
select * from B join M using(id);

# 시험과목 3개