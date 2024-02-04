show tables;
use shoppingmall;

# member 테이블의 권한은 일반회원 : user, 관리자 : admin
# 아이디가 admin이고, 비번이 admin, 이메일이 admin@gmail.com, 번호가 010-0000-0000인 관리자가
# 회원가입했을 때 필요한 쿼리를 작성
insert into member values("admin", "admin", "admin@gmail.com", "010-0000-0000", "admin", 0);

DROP DATABASE IF EXISTS shoppingmall;
CREATE DATABASE IF NOT EXISTS shoppingmall;

use shoppingmall;
select * from shoppingmall;
# 관리자가 다음의 제품을 등록할 때 필요한 쿼리
# 1. 카테고리를 등록 : 기타
insert into category values(null, "기타");
# 2. 등록된 기타 카테고리의 기본키를 확인 후 아래 제품에 추가 : 클릭으로 추가함
select * from category;
# 3. 코드 : ABC001, 제품명 : 텀블러, 가격 : 20000, 내용 : 스타벅스 텀블러입니다, 카테고리 : 기타
insert into `product` values("ABC001", "텀블러", "스타벅스 텀블러입니다.", 20000, 1);
# 카테고리 추가 : 전자제품, 의류, 식품, 자동차
insert into category (CA_NAME) values("전자제품"),("의류"),("식품"),("자동차");
select * from category;

/*
코드 : ABC002, 제품명 : 볼펜, 내용 : 모나미 볼펜, 가격 : 1000, 카테고리 : 기타 1
코드 : ABC003, 제품명 : 지우개, 내용 : 잘 지워지는 지우개, 가격 : 500, 카테고리 : 기타 1
코드 : ELC001, 제품명 : 마우스, 내용 : 무선 마우스, 가격 : 10000, 카테고리 : 전자제품 2
코드 : ELC002, 제품명 : 키보드, 내용 : 무선 키보드, 가격 : 20000, 카테고리 : 전자제품 2
코드 : CLO001, 제품명 : 모자, 내용 : 좋은 모자, 가격 : 10000, 카테고리 : 의류 3
코드 : CLO002, 제품명 : 셔츠, 내용 : 구김 없는 셔츠, 가격 : 50000, 카테고리 : 의류 3
코드 : FOO001, 제품명 : 만두, 내용 : 고기만두, 가격 : 5000, 카테고리 : 식품 4
코드 : FOO002, 제품명 : 라면, 내용 : 맛있는 라면, 가격 : 3000, 카테고리 : 식품 4
코드 : CAR001, 제품명 : 방향제, 내용 : 향기 좋음, 가격 : 5000, 카테고리 : 자동차 5
*/
insert into product values
("ABC002", "볼펜", "모나미 볼펜", 1000, 1),
("ABC003", "지우개", "잘 지워지는 지우개", 500, 1),
("ELC001", "마우스", "무선 마우스", 10000, 2),
("ELC002", "키보드", "무선 키보드", 20000, 2),
("CLO001", "모자", "좋은 모자", 10000, 3),
("CLO002", "셔츠", "구김 없는 셔츠", 50000, 3),
("FOO001", "만두", "고기만두", 5000, 4),
("FOO002", "라면", "맛있는 라면", 3000, 4),
("CAR001", "방향제", "향기 좋음", 5000, 5);
select * from product;

# 아이디 : abcd123, 비번 : abcd123, 이메일 : abcd123@kh.com, 폰번호 : 010-0000-0000
# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.com, 폰번호 : 011-1111-1111
insert into member(me_id, me_pw, me_email, me_phone) values
("abc123", "abc123", "abc123@kh.com", "00-0000-0000"),
("abcd123", "abcd123", "abcd123@kh.com", "010-0000-0000"),
("qwe123", "qwe123", "qwe123@kh.com", "011-1111-1111");
select * from member;

# abcd123 회원이 마우스를 장바구니에 2개 담았을 때 실행되는 쿼리
insert into basket(ba_amount, ba_me_id, ba_pr_code) values (2, "abcd123", "ELC001");

# abcd123 회원이 마우스를 장바구니에 3개 담았을 때 실행되는 쿼리
-- 장바구니에 제품을 추가하게 수량이 변경한다고 요구사항에 정의됨 -> update(요구사항에 맞게 쿼리를 작성)
update basket set ba_amount = 3 where ba_me_id = "abcd123" and ba_pr_code = "ELC001";
select * from basket where ba_me_id = "abcd123";
select * from product where pr_code = "ELC002";
# abcd123 회원이 키보드를 장바구니에 1개 담았을 때 실행되는 커리
insert into basket(ba_amount, ba_me_id, ba_pr_code) values (1, "abcd123", "ELC002");

# abcd123 회원이 장바구니에 담긴 모든 제품을 주문했을 때 실행 되는 쿼리
-- order는 키워드라서 ``
-- or_date는 기본키라서 지움
insert into `order`(or_amount, or_total_price, or_me_id, or_pr_code)
			values(3, 3*10000, "abcd123", "ELC001"),
				  (1, 1*50000, "abcd123", "ELC002");
# 장바구니에 담긴 제품을 구매하면 장바구니에는 해당 제품을 제거
delete from basket where ba_num = 1;
delete from basket where ba_num = 2;





