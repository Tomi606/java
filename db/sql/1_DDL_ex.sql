/* 여러줄 주석
*/

# 데이터베이스 삭제(있으면)
drop database if exists TEST;
# drop schema if exists `TEST`;

# 데이터베이스 추가(없으면)
create database if not exists TEST;
# create schema if not exists `TEST`;

# test 데이터베이스를 쓴다는 명령어
-- 이거를 안쓰고 실행을 안할 때 테이블을 만들면 테이블이 아무곳에서 만들어진다
USE TEST;

# 테이블 삭제
DROP TABLE IF EXISTS MEMBER;

# 테이블 생성
CREATE TABLE IF NOT EXISTS MEMBER(
	-- id 최대 13자 기본키
	ID VARCHAR(13) PRIMARY KEY,
    PW VARCHAR(15) NOT NULL,
    EMAIL VARCHAR(30) NOT NULL UNIQUE
);
# member 테이블 확인
DESC MEMBER;

# board 테이블 삭제(삭제하고 싶으면 이 줄에 커서를 두고 ctrl+엔터를 치면 된다.)
DROP TABLE IF EXISTS BOARD;

# board 테이블 생성
CREATE TABLE IF NOT EXISTS BOARD(
	-- 번호 자동으로 1증가
	NUM INT AUTO_INCREMENT,
    -- 제목 최대 50자 비울 수 없다
    TITLE VARCHAR(50) NOT NULL,
    -- 텍스트 문자열 길이 비울 수 없다
    CONTENT LONGTEXT NOT NULL,
    -- 조회수 정수 비울 수 없다 default를 이용해 초기 설정을 0으로 함
    VIEW INT NOT NULL DEFAULT 0,
    -- 작성자 최대 13자 비울 수 없다
    ID VARCHAR(13) NOT NULL,
    -- 기본키 설정(위의 member처럼 id(PK)옆에 써도 됨)
    PRIMARY KEY(NUM),
    -- 외래키 지정, 내 아이디와 상대방 아이디를 연결
    FOREIGN KEY(ID) REFERENCES MEMBER(ID)
);
-- key MUL이 외래키로 지정된 것
DESC BOARD;

# MEMBER 테이블에 가입일 컬럼 DATE를 추가(만들어진 테이블에 새 속성 추가)
ALTER TABLE `MEMBER` ADD `DATE` DATETIME NOT NULL;
# MEMBER 테이블에 가입일을 의미하는 DATE를 REGmemberDATE_DATE로 변경
ALTER TABLE `MEMBER` CHANGE `DATE` `REG_DATE` DATETIME NOT NULL;

# MEMBER 테이블에 불필요한 컬럼 COUNT 추가
ALTER TABLE `MEMBER` ADD `COUNT` INT NOT NULL;
# MEMBER 테이블에서 COUNT 컬럼을 삭제
ALTER TABLE `MEMBER` DROP `COUNT`;