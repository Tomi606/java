# abcd123 회원이 주문 내역을 확인하는 쿼리
select * from `order` where or_me_id = "abcd123";

# 기타(1)에 포함된 모든 제품을 조회하는 쿼리
select * from product where pr_ca_num = 1;

# 기타(1), 자동차(5), 의류(3)에 포함된 모든 제품을 조회하는 쿼리
select * from product where pr_ca_num = 1 or pr_ca_num = 3 or pr_ca_num = 5;
select * from product where pr_ca_num in (1, 3, 5);

# 등록된 제품들의 카테고리 번호를 조회하는 쿼리
select distinct pr_ca_num from product;

# 가격이 높은 순으로 제품을 정렬하는 쿼리, 가격이 같은 경우 pr_code 순으로
select * from product order by pr_price desc, pr_code;

# 제품 페이지에서 1페이지에 있는 제품을 조회하는 쿼리(가정 : 한 페이지에 제품은 2개 조회된다)
select * from product limit 0, 2;

# 2페이지에 있는 제품을 조회하는 쿼리(한 페이지에 2개 조회)
# *잘기억!(페이지네이션) 2번지 = 컨텐츠 개수 2 * (현재 페이지 2 - 1)
select * from product limit 2, 2;

# 10페이지에 있는 제품을 조회하는 쿼리
select * from product limit 18, 2;

# 카테고리별 등록된 제품의 개수를 조회
-- as : 이름을 바꿔줌
select pr_ca_num as '카테고리 번호', count(pr_ca_num) as '제품수' from product group by pr_ca_num;

# 카테고리 별 등록된 제품의 개수가 2개 이상인 카테고리를 조회
-- having 집계함수에 조건을 걸고싶을 때 사용
select pr_ca_num as '카테고리 번호', count(pr_ca_num) as '제품수' 
from product 
group by pr_ca_num 
having count(pr_ca_num) >= 2;

# abcd123 회원이 지금까지 주문한 총 금액을 조회하는 쿼리
select or_me_id as '구매아이디', sum(or_total_price) as '총 구매금액' 
from `order` 
-- 반품, 환불이 아닌경우는 포함 안시킴(이런 세세한 항목 잘 체크!)
where or_me_id = "abcd123" and or_state not in("반품", "환불")
group by or_me_id; 

# 제품별 판매된 개수를 조회하는 쿼리
select or_pr_code, sum(or_amount) 
from `order` 
where or_state not in("반품", "활불") 
group by or_pr_code;

# 제품별 카테고리명을 조회하기 위한 inner join 쿼리
-- 제품의 모든 것 중에 카테고리 이름 조회
select product.*, ca_name
from product
join category
-- product의 외래키를 category의 기본키와 연결
-- 속성명이 다르면 테이블명을 생략할 수 있다.
-- on product.pr_ca_num = category.ca_num;
on pr_ca_num = ca_num;

# 기타로 등록된 제품들을 조회하는 쿼리(inner join)
select * 
from product 
join category on pr_ca_num = ca_num
where ca_name = '기타';

# abcd123 회원이 주문한 제품목록을 조회하는 쿼리
select *
from `order`
join product on or_pr_code = pr_code
where or_me_id = "abcd123" and or_state not in("환불", "반품");

# 각 제품별 판매된 개수(판매된 제품에 한해서)
select pr_title, sum(or_amount) as 판매수 -- 한글에 공백이 있다면 ''을 사용, 없으면 사용안해도 됨.
from `order` 
join product on or_pr_code = pr_code
where or_state not in("반품", "환불")
-- pr_code를 기준으로
group by pr_code;

# 각 제품별 판매된 개수(모든 제품에 한해서)
				-- ifnull(속성, 값A) 속성이 null인 경우, null 대신 값A로 변경
-- 1) left
select pr_title as 제품명, ifnull(sum(or_amount), 0) as 판매수량
-- product를 기준으로
from product 
-- pr_code와 같은 or_pr_code를 왼쪽에 붙인다.
left join `order` on pr_code = or_pr_code
-- 판매상태가 null 이거나 판매상태가 환불, 반품이 아닌 경우
where or_state is null or or_state not in("환불", "반품")
group by pr_code;
-- 2) right
select pr_title as 제품명, ifnull(sum(or_amount), 0) as 판매수량
from  `order`
right join product on pr_code = or_pr_code
where or_state is null or or_state not in("환불", "반품")
group by pr_code;

