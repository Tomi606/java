DROP DATABASE IF EXISTS `controversy_wiki`;

CREATE DATABASE IF NOT EXISTS `controversy_wiki`;

USE `controversy_wiki`;

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
	`ps_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`ps_name`	varchar(100) NOT NULL,
	`ps_nickname`	varchar(255) NOT NULL,
	`ps_birth`	date	NULL,
	`ps_gender`	varchar(50)	NULL,
	`ps_me_id`	varchar(12)	NOT NULL,
    `ps_mbti_num`	int	NOT NULL,
	`ps_na_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
	`lk_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`lk_instagram`	varchar(255)	NULL,
	`lk_blog`	varchar(255)	NULL,
	`lk_etc`	varchar(255)	NULL,
	`lk_ps_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(12)	PRIMARY KEY,
	`me_password`	varchar(20)	NULL,
	`me_nickname`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`cmt_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`cmt_content`	text NOT NULL,
	`cmt_me_id`	varchar(12)	NOT NULL,
	`cmt_wk_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
	`re_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`re_state`	int	NULL DEFAULT 0,
	`re_me_id`	varchar(12)	NOT NULL,
	`re_wk_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `wiki`;

CREATE TABLE `wiki` (
	`wk_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`wk_title`	varchar(20)	NOT NULL,
	`wk_content`	text NOT NULL,
	`wk_view`	int	NULL DEFAULT 0,
    `wk_datetime` datetime NOT NULL,
	`wk_me_id`	varchar(12)	NOT NULL,
	`wk_ps_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `nation`;

CREATE TABLE `nation` (
	`na_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`na_title`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `mbti`;

CREATE TABLE `mbti` (
	`mbti_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`mbti_title`	char(4)	NOT NULL
);

ALTER TABLE `person` ADD CONSTRAINT `FK_mbti_TO_person_1` FOREIGN KEY (
	`ps_mbti_num`
)
REFERENCES `mbti` (
	`mbti_num`
);

ALTER TABLE `person` ADD CONSTRAINT `FK_nation_TO_person_1` FOREIGN KEY (
	`ps_na_num`
)
REFERENCES `nation` (
	`na_num`
);

ALTER TABLE `person` ADD CONSTRAINT `FK_member_TO_person_1` FOREIGN KEY (
	`ps_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `link` ADD CONSTRAINT `FK_person_TO_link_1` FOREIGN KEY (
	`lk_ps_num`
)
REFERENCES `person` (
	`ps_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cmt_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_wiki_TO_comment_1` FOREIGN KEY (
	`cmt_wk_num`
)
REFERENCES `wiki` (
	`wk_num`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_wiki_TO_recommend_1` FOREIGN KEY (
	`re_wk_num`
)
REFERENCES `wiki` (
	`wk_num`
);

ALTER TABLE `wiki` ADD CONSTRAINT `FK_member_TO_wiki_1` FOREIGN KEY (
	`wk_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `wiki` ADD CONSTRAINT `FK_person_TO_wiki_1` FOREIGN KEY (
	`wk_ps_num`
)
REFERENCES `person` (
	`ps_num`
);

