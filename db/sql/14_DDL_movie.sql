drop database if exists `movie`;
create database if not exists `movie`;

use `movie`;

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`s_num`	int	primary key auto_increment,
	`s_name`	varchar(3) not null,
	`s_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc_num`	int	primary key auto_increment,
	`sc_name`	int not null,
	`sc_seat`	int not null default 0,
	`sc_t_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`t_num`	int	primary key auto_increment,
	`t_name`	varchar(10) not null,
	`t_address`	varchar(100) not null,
	`t_screen`	int not null,
	`t_seat`	int not null default 0,
	`t_r_name`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
	`r_name`	varchar(10)	primary key
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`sh_num`	int	primary key auto_increment,
	`sh_date`	date not null,
	`sh_time`	time not null,
	`sh_sale`	int not null default 0,
	`sh_mv_num`	int	NOT NULL,
	`sh_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
	`tc_num`	int	primary key auto_increment,
	`tc_adult`	int not null,
	`tc_teenager`	int not null,
	`tc_total_price`	int not null,
	`tc_sit`	int not null,
	`tc_m_id`	varchar(12)	NOT NULL,
	`tc_sh_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`m_id`	varchar(12)	primary key,
	`m_pw`	varchar(15) not null,
    `m_authority` varchar(5) default 'user'
);

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mv_num`	int	primary key auto_increment,
	`mv_title`	varchar(50) not null,
	`mv_date`	date not null,
	`mv_content`	text not null,
	`mv_running`	int not null,
	`mv_ag_name`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `artist`;

CREATE TABLE `artist` (
	`a_num`	int	primary key auto_increment,
	`a_role`	char(2) not null,
	`a_picture`	varchar(50) null,
	`a_c_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`g_name`	varchar(10)	primary key
);

DROP TABLE IF EXISTS `nation`;

CREATE TABLE `nation` (
	`n_name`	varchar(20)	primary key
);

DROP TABLE IF EXISTS `character`;

CREATE TABLE `character` (
	`c_num`	int	primary key auto_increment,
	`c_name`	varchar(30) not null,
	`c_birth`	date,
	`c_content`	text,
	`c_n_name`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `movie_file`;

CREATE TABLE `movie_file` (
	`mf_num`	int	primary key auto_increment,
	`mf_filename`	varchar(50) not null,
	`mf_type`	varchar(10),
	`mf_mv_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `age`;

CREATE TABLE `age` (
	`ag_name`	varchar(10)	primary key
);

DROP TABLE IF EXISTS `join`;

CREATE TABLE `join` (
	`j_num`	int	primary key auto_increment,
	`j_casting`	varchar(20) not null,
	`j_mv_num`	int	NOT NULL,
	`j_a_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `production_nation`;

CREATE TABLE `production_nation` (
	`pn_num`	int	primary key auto_increment,
	`pn_n_name`	varchar(20)	NOT NULL,
	`pn_mv_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `genre_include`;

CREATE TABLE `genre_include` (
	`gi_num`	int	primary key auto_increment,
	`gi_mv_num`	int	NOT NULL,
	`gi_g_name`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `ticketing_list`;

CREATE TABLE `ticketing_list` (
	`tl_num`	int	primary key auto_increment,
	`tl_tc_num`	int	NOT NULL,
	`tl_s_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
	`pr_num`	int	primary key auto_increment,
	`pr_type`	varchar(5)	NOT NULL,
	`pr_price`	int	NOT NULL
);


-- 위의 PK 코드는 삭제 
ALTER TABLE `seat` ADD CONSTRAINT `FK_screen_TO_seat_1` FOREIGN KEY (
	`s_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_theater_TO_screen_1` FOREIGN KEY (
	`sc_t_num`
)
REFERENCES `theater` (
	`t_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `FK_region_TO_theater_1` FOREIGN KEY (
	`t_r_name`
)
REFERENCES `region` (
	`r_name`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sh_mv_num`
)
REFERENCES `movie` (
	`mv_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_screen_TO_schedule_1` FOREIGN KEY (
	`sh_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`tc_m_id`
)
REFERENCES `member` (
	`m_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`tc_sh_num`
)
REFERENCES `schedule` (
	`sh_num`
);

ALTER TABLE `movie` ADD CONSTRAINT `FK_age_TO_movie_1` FOREIGN KEY (
	`mv_ag_name`
)
REFERENCES `age` (
	`ag_name`
);

ALTER TABLE `artist` ADD CONSTRAINT `FK_character_TO_artist_1` FOREIGN KEY (
	`a_c_num`
)
REFERENCES `character` (
	`c_num`
);

ALTER TABLE `character` ADD CONSTRAINT `FK_nation_TO_character_1` FOREIGN KEY (
	`c_n_name`
)
REFERENCES `nation` (
	`n_name`
);

ALTER TABLE `movie_file` ADD CONSTRAINT `FK_movie_TO_movie_file_1` FOREIGN KEY (
	`mf_mv_num`
)
REFERENCES `movie` (
	`mv_num`
);

ALTER TABLE `join` ADD CONSTRAINT `FK_movie_TO_join_1` FOREIGN KEY (
	`j_mv_num`
)
REFERENCES `movie` (
	`mv_num`
);

ALTER TABLE `join` ADD CONSTRAINT `FK_artist_TO_join_1` FOREIGN KEY (
	`j_a_num`
)
REFERENCES `artist` (
	`a_num`
);

ALTER TABLE `production_nation` ADD CONSTRAINT `FK_nation_TO_production_nation_1` FOREIGN KEY (
	`pn_n_name`
)
REFERENCES `nation` (
	`n_name`
);

ALTER TABLE `production_nation` ADD CONSTRAINT `FK_movie_TO_production_nation_1` FOREIGN KEY (
	`pn_mv_num`
)
REFERENCES `movie` (
	`mv_num`
);

ALTER TABLE `genre_include` ADD CONSTRAINT `FK_movie_TO_genre_include_1` FOREIGN KEY (
	`gi_mv_num`
)
REFERENCES `movie` (
	`mv_num`
);

ALTER TABLE `genre_include` ADD CONSTRAINT `FK_genre_TO_genre_include_1` FOREIGN KEY (
	`gi_g_name`
)
REFERENCES `genre` (
	`g_name`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`tl_tc_num`
)
REFERENCES `ticketing` (
	`tc_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_seat_TO_ticketing_list_1` FOREIGN KEY (
	`tl_s_num`
)
REFERENCES `seat` (
	`s_num`
);
