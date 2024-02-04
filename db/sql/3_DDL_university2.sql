# ERDcloud 이용
DROP DATABASE IF EXISTS university2;
CREATE DATABASE IF NOT EXISTS university2;

USE university2;

DROP TABLE IF EXISTS `Student`;

CREATE TABLE `Student` (
	`st_num`	char(10)	NOT NULL,
	`st_name`	varchar(30) not null	,
	`st_major`	varchar(15) not null	,
	`st_grade`	int not null default 1	
);

DROP TABLE IF EXISTS `Professor`;

CREATE TABLE `Professor` (
	`pr_num`	char(10)	NOT NULL,
	`pr_name`	varchar(30) not null	,
	`pr_room`	varchar(100)	,
	`pr_major`	varchar(15) not null	
);

DROP TABLE IF EXISTS `Lecture`;

CREATE TABLE `Lecture` (
	`le_num`	int	primary key auto_increment, -- primary key, auto_increment 추가
	`le_title`	varchar(30) not null	,
	`le_room`	varchar(20)	,
	`le_schedule`	varchar(50) not null	,
	`le_point`	int not null default 0	,
	`le_time`	int not null default 0	,
	`pr_num`	char(10) -- 이상함 다시 보기!!!!!
);

DROP TABLE IF EXISTS `Course`;

CREATE TABLE `Course` (
	`co_num`	int	primary key auto_increment,
	`co_st_num`	char(10)	NOT NULL,
	`co_le_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `Contact`;

CREATE TABLE `Contact` (
	`ct_st_num`	char(10)	NOT NULL,
	`ct_phone`	varchar(11) not null	,
	`ct_addr`	varchar(30) not null	,
	`ct_detail`	varchar(30) not null default""	
);

ALTER TABLE `Student` ADD CONSTRAINT `PK_STUDENT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `Professor` ADD CONSTRAINT `PK_PROFESSOR` PRIMARY KEY (
	`pr_num`
);
# 위에서 primary key 로 지정한 테이블은 삭제
ALTER TABLE `Lecture` ADD CONSTRAINT `FK_Professor_TO_Lecture_1` FOREIGN KEY (
	`pr_num`
)
REFERENCES `Professor` (
	`pr_num`
);

ALTER TABLE `Course` ADD CONSTRAINT `FK_Student_TO_Course_1` FOREIGN KEY (
	`co_st_num`
)
REFERENCES `Student` (
	`st_num`
);

ALTER TABLE `Course` ADD CONSTRAINT `FK_Lecture_TO_Course_1` FOREIGN KEY (
	`co_le_num`
)
REFERENCES `Lecture` (
	`le_num`
);

ALTER TABLE `Contact` ADD CONSTRAINT `FK_Student_TO_Contact_1` FOREIGN KEY (
	`ct_st_num`
)
REFERENCES `Student` (
	`st_num`
);

