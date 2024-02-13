# 쇼핑몰을 이용한 윈도우 함수 예제
use shoppingmall;

# 제품을 가격순으로 정렬(row_number)
select row_number() over(order by pr_price desc) as '순서', product.*
from `product`;

# 제품을 가격순으로 정렬(rank)
select rank() over(order by pr_price desc) as '금액순', product.*
from `product`;

# 제품을 가격순으로 정렬(dense_rank)
select dense_rank() over(order by pr_price desc) as '금액순', product.*
from `product`;

# 제품을 비싼 제품, 싼 제품으로 정렬(ntile) : 1이면 비싼제품, 2이면 싼제품
select ntile(2) over(order by pr_price desc) as '그룹', product.*
from `product`;

# 이 예제 잘 기억!!!) 가장 비싼 제품들을 조회하는 쿼리(dense_rank + 서브 쿼리)
select * 
from(
	select dense_rank() over(order by pr_price desc) as 'pr_rank', product.*
	from product	
) as ranked_product
where pr_rank = 1;







