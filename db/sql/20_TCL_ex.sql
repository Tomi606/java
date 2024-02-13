# 트랜잭션 시작
start transaction;
-- begin / begin work;

use shoppingmall;

# FOO002 가격을 2000원으로 수정
update product set pr_price = 2000 where pr_code = 'FOO002';

rollback; -- 트랙잭션을 쓰고 롤백을 써야 돌아감
select * from product;