# 제품을 추가하는 프로시저
# 제품코드는 영문3자리(주어짐), 숫자3자리(같은 카테고리로 등록된 제품들 수를 이용)
# 주어지는 정보 : 제품코드 영문 3자리, 제품명, 내용, 가격, 카테고리명
# 프로시저 실행 결과 : 제품이 등록
use shoppingmall;
select * from product;

drop procedure if exists insert_product;
delimiter //
create procedure insert_product(
-- 언더바를 안쓰면 셀렉해서 가져올 때 이 변수명과 같을 때 오류날 수 있다.
-- 이 코드에 숫자를 붙여야됨
	in _code char(3),
    in _title varchar(50),
    in _content text,
    in _price int,
    in _category varchar(10)
)
begin
-- 변수 선언
	declare _count int;
    declare _pr_code varchar(15);
    declare _ca_num int;
    -- set이라는 키워드를 써야 저장됨! 쿼리는 소괄호로 감싸줘야 됨.
    -- _category와 일치하는 등록된 제품 수를 찾아서 +1을 한 후 변수에 저장
    set _count = (
    -- + 1을 해야 뒤의 숫자가 늘어난다.
		select count(*) + 1
		from product 
		join category on pr_ca_num = ca_num
		where ca_name = _category);
	
    # _code와 _count를 이용하여 _pr_code를 생성
    -- lpad(_count, 3, 0) : _count가 3자리를 기준으로 비어있으면 0으로 채움
    set _pr_code = concat(_code, lpad(_count,3, 0));
    
    # _category를 이용하여 _ca_num을 찾음
    set _ca_num = (select ca_num from category where ca_name = _category);
    if _ca_num is not null then
		insert into product(pr_code, pr_title, pr_content, pr_price, pr_ca_num)
				values(_pr_code, _title, _content, _price, _ca_num);
    end if;
end //
delimiter ;

show procedure status;
show create procedure insert_product;
-- 한번 실행 했으니 주석 처리
-- call insert_product('ABC', '수정펜', '수정펜입니다', 3000, '기타');
-- ABC 카테고리명은 없어서 추가안됨(0 row affected)
call insert_product('ABC', '수정펜', '수정펜입니다', 3000, 'ABC');

# 제품을 주문하는 프로시저
drop procedure if exists insert_order;
delimiter //
create procedure insert_order(
	in _amount int,
    in _id varchar(13),
    in _pr_code varchar(15)
)
begin
	declare _price int; -- 제품 가격
    declare _total_price int; -- 제품 총 가격
	
    # 제품 가격을 가져옴
    set _price = (select pr_price from product where pr_code = _pr_code);
	# 제품 총 가격을 계산
	set _total_price = _price * _amount;
    # order 테이블에 데이터를 추가
    insert 
    into `order`(or_amount, or_total_price, or_me_id, or_pr_code)
    values(_amount, _total_price, _id, _pr_code);
end //
delimiter ;
call insert_order(3, 'qwe123', 'ABC004');
select * from `order`;

-- 카테고리 번호가 주어졌을 때 카테고리 수를 조회 -> 카테고리명을 입력해서 조회(join category), join을 안하면 서브쿼리 이용
select count(*) 
from product 
join category on pr_ca_num = ca_num
where ca_name = '기타';

-- 서브쿼리(join 이용 X)
select count(*) + 1 
from product 
where pr_ca_num = (select ca_num from category where ca_name = '기타');



