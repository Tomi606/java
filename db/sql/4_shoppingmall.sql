# 쇼핑몰 사이트 ERDcloud
#영어랑 한글이랑 바꼈으니 수정하기...

DROP DATABASE IF EXISTS shoppingmall;
CREATE DATABASE IF NOT EXISTS shoppingmall;

USE shoppingmall;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`회원아이디`	varchar(15)	primary key,
	`회원비번`	varchar(20) not null	NULL,
	`회원이메일`	varchar(40) not null	NULL,
	`회원전화번호`	varchar(11) not null	NULL,
	`회원권한`	varchar(10) not null default "user"	,
	`로그인 실패횟수`	int not null default "0"	
);

DROP TABLE IF EXISTS `certification`;

CREATE TABLE `certification` (
	`인증코드`	char(6) primary key,
	`만료기간`	int, -- datetime으로 수정
	`회원아이디`	varchar(15) not null
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`분류코드`	char(6) primary key,
	`분류명`	varchar(20) not null
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`제품코드`	char(6) primary key,
	`제품명`	varchar(30) not null,
	`제품내용`	longtext,
	`제품가격`	int not null default "0",
	`분류코드`	char(6) not null
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`주문코드`	char(6) primary key auto_increment,
	`주문일`	date not null default current_timestamp	NULL,
	`주문상태`	varchar(10) not null default "결제완료",
	`주문수량`	int not null default 0,
	`주문결제액`	int not null,
	`회원아이디`	varchar(15) not null,
	`제품코드`	char(6) not null
);

DROP TABLE IF EXISTS `shopping basket`;

CREATE TABLE `shopping basket` (
	`장바구니코드`	char(6) primary key,
	`장바구니수량`	int not null,
	`회원아이디`	varchar(15) not null,
	`제품코드`	char(6) not null
);

DROP TABLE IF EXISTS `thumbnail`;

CREATE TABLE `thumbnail` (
	`썸네일 코드`	char(6) primary key,
	`썸네일파일명`	text not null,
	`제품코드`	char(6) not null
);

ALTER TABLE `certification` ADD CONSTRAINT `FK_member_TO_certification_1` FOREIGN KEY (
	`회원아이디`
)
REFERENCES `member` (
	`회원아이디`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`분류코드`
)
REFERENCES `category` (
	`분류코드`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`회원아이디`
)
REFERENCES `member` (
	`회원아이디`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_product_TO_order_1` FOREIGN KEY (
	`제품코드`
)
REFERENCES `product` (
	`제품코드`
);

ALTER TABLE `shopping basket` ADD CONSTRAINT `FK_member_TO_shopping basket_1` FOREIGN KEY (
	`회원아이디`
)
REFERENCES `member` (
	`회원아이디`
);

ALTER TABLE `shopping basket` ADD CONSTRAINT `FK_product_TO_shopping basket_1` FOREIGN KEY (
	`제품코드`
)
REFERENCES `product` (
	`제품코드`
);

ALTER TABLE `thumbnail` ADD CONSTRAINT `FK_product_TO_thumbnail_1` FOREIGN KEY (
	`제품코드`
)
REFERENCES `product` (
	`제품코드`
);

