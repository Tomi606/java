# 아이디가 abc123, 비번이 asd123으로 회원가입을 진행
insert into member values('abc123', 'asd123', 'user');
# 사용자가 아이디가 qwe123, 비번이 qweqwe으로 회원가입을 진행
insert into member values('qwe123', 'qweqwe', 'user');
# 관리자가 아이디가 admin, 비번이 admin으로 회원 가입을 진행
insert into member values('admin', 'admin', 'admin');
-- delete from member where m_id = "admin";
-- select * from member;

# CGV에서 영화 웡카를 관리자가 등록하려고 한다. 이때 해야하는 쿼리를 순서대로 써보세요.
# 영화 정보(제목, 내용, 개봉일, 러닝타임), 감독, 배우들, 장르, 연령, 제작 국가, 트레일러, 스틸컷
/*	-- 처음 등록되는 영화인과 인물만 추가 
	1. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스
	추가할려면 character 테이블에 추가(artist에 a_c_num이 있어서) 
	2. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스
	movie_person 테이블에 추가(1에서 추가한 정보를 이용)
    3. 영화 정보를 이용하여 영화를 등록(movie 테이블)
    4. join 테이블에 추가(2, 3에서 추가한 정보를 이용), 배역을 모르면 ""로 처리
    -- 5, 6번은 최초 1번만 등록하면 됨
    5. 모든 장르를 genre 테이블에 추가(액션, 범죄, SF, 드라마, 환타지, 코미디, 로맨스, 스릴러, 공포, 멜로)
    6. 모든 연령을 age 테이블에 추가(전체관람가, 12세 이상 관람가, 15세 이상 관람가, 청소년 관람불가, 제한관람가)
    7. 모든 국가를 nation 테이블에 추가(미국, 영국, 한국, 일본, 중국)
    8. 트레일러 정보를 추가, 파일명은 임의로 생성해서 추가 / 트레일러 3개, 스틸컷 4개 
    9. 영화 제작에 영화와 제작 국가 정보를 추가 
    10. 장르 포함에 영화와 장르를 추가
    */

-- 5. 장르 추가
select * from genre;
insert into genre values ("액션"), ("범죄"), ("SF"), ("드라마"), ("환타지"),
						("코미디"), ("로맨스"), ("스릴러"), ("공포"), ("멜로");
-- 6. 연령 추가
select * from age;
insert into age values ("전체관람가"), ("12세 이상 관람가"), 
						("15세 이상 관람가"), ("청소년 관람불가"), ("제한관람가");
-- 7. 국가 추가
select * from nation;
insert into nation values("미국"), ("영국"), ("한국"), ("일본"), ("중국");

-- 1. 폴 킹, 티모시 샬라메,  칼라 레인,  올리비아 콜맨,  톰 데이비스,  휴 그랜트,  샐리 호킨스
-- 추가할려면 character 테이블에 추가(artist에 a_c_num이 있어서)
select * from `character`;
insert into `character` values
(1, "폴 킹", "1978-07-29", "바이오그래피", "미국"),
(2, "티모시 샬라메", "1995-12-27", "바이오그래피", "미국"),
(3, "칼라 레인", "2009-04-20", "바이오그래피", "미국"),
(4, "올리비아 콜맨", "1974-01-30", "바이오그래피", "영국"),
(5, "톰 데이비스", "1979-04-27", "바이오그래피", "영국"),
(6, "휴 그랜트", "1960-09-09", "바이오그래피", "영국"),
(7, "샐리 호킨스", "1976-04-27", "바이오그래피", "영국");

-- 2. 폴 킹, 티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨스
-- artist 테이블에 추가(1에서 추가한 정보를 이용)
select * from `artist`;
insert into `artist` values
(1, "감독", "", 1),
(2, "배우", "", 2),
(3, "배우", "", 3),
(4, "배우", "", 4),
(5, "배우", "", 5),
(6, "배우", "", 6),
(7, "배우", "", 7);

-- 3. 영화 정보를 이용하여 영화를 등록(movie 테이블)
select * from `movie`;
insert into `movie` values 
(1, "웡카(Wonka)", "2024-01-31", "세상에서 가장 달콤한 여정, 좋은 일은 모두 꿈에서부터 시작된다!", 116, "전체관람가");

-- 4. join 테이블에 추가(2, 3에서 추가한 정보를 이용), 배역을 모르면 ""로 처리
select * from `join`;
insert into `join`(j_casting, j_mv_num, j_a_num) values 
("감독", 1, 1),
("", 1, 2),
("", 1, 3),
("", 1, 4),
("", 1, 5),
("", 1, 6),
("", 1, 7);

-- 8. 트레일러 정보를 추가, 파일명은 임의로 생성해서 추가 / 트레일러 3개, 스틸컷 4개
select * from `movie_file`;
insert into `movie_file`(mf_filename, mf_type, mf_mv_num) values 
('웡카_트레일러1.mp4', '트레일러', 1),
('웡카_트레일러2.mp4', '트레일러', 1),
('웡카_트레일러3.mp4', '트레일러', 1),
('웡카_스틸컷1.png', '스틸컷', 1),
('웡카_스틸컷2.png', '스틸컷', 1),
('웡카_스틸컷3.png', '스틸컷', 1),
('웡카_스틸컷4.png', '스틸컷', 1);

-- 9. 영화 제작에 영화와 제작 국가 정보를 추가 
select * from `production_nation`;
insert into production_nation(pn_n_name, pn_mv_num) values('미국', 1), ('영국', 1);

-- 10. 장르 포함에 영화와 장르를 추가
select * from `genre_include`;
insert into genre_include(gi_mv_num, gi_g_name) values(1, '환타지'), (1, '드라마');

-- ---------------------------------------------------------------------------
-- 2/8
 
# 지역을 추가하는 쿼리
# (서울, 경기, 인천, 강원, 대전/충청, 대구, 부산/울산, 경상, 광주/전라/제주)
insert into region values('서울'),('경기'),('인천'),('강원'),('대전/충청'),
('대구'),('부산/울산'),('경상'),('광주/전라/제주');

# 영화관을 추가하는 쿼리
# CGV강남, 서울특별시 강남구 역삼동, 좌석수 : 0, 상영관수 : 3, 서울
# CGV영등포, 서울특별시 영등포구 4가, 좌석수 : 0, 상영관수 : 4, 서울 

insert into theater value(null, 'CGV강남', '서울특별시 강남구 역삼동', 0, 3, '서울'),
(null, 'CGV영등포', '서울특별시 영등포구 4가', 0, 4, '서울');

# CGV강남에 상영관과 좌석을 추가하는 쿼리
# 1관, 10좌석, 2관, 12좌석, 3관 6좌석
# 1관 : A1~A3, B1~B3, C1~C4
# 2관 : A1~A4, B1~B4, C1~C4
# 3관 : A1,A2, B1,B2, C1,C2

insert into screen(sc_name, sc_seat, sc_t_num) values(1, 10, 1);
insert into seat(s_name, s_sc_num) values
('A1', 1),('A2', 1),('A3', 1),
('B1', 1),('B2', 1),('B3', 1),
('C1', 1),('C2', 1),('C3', 1),('C4', 1);

insert into screen(sc_name, sc_seat, sc_t_num) values(2, 12, 1);
insert into seat(s_name, s_sc_num) values
('A1', 2),('A2', 2),('A3', 2),('A4', 2),
('B1', 2),('B2', 2),('B3', 2),('B4', 2),
('C1', 2),('C2', 2),('C3', 2),('C4', 2);

insert into screen(sc_name, sc_seat, sc_t_num) values(3, 6, 1);
insert into seat(s_name, s_sc_num) values
('A1', 3),('A2', 3),
('B1', 3),('B2', 3),
('C1', 3),('C2', 3);

# 극장 좌석 수정
UPDATE theater 
SET 
    t_seat = 28
WHERE
    t_name = 'CGV강남';
/* 서브 쿼리를 이용하여 CGV강남에 등록된 좌석수를 계산해서 영화관 전체 좌석수에 업데이트 하는 쿼리
- 서브 쿼리로 A테이블을 업데이트할 때, 서브 쿼리에 A테이블을 단순 이용하면 업데이트가 되지 않음 
- 이럴 때, A테이블이 아닌 A테이블을 조회한 결과를 이용하면 가능 
- 서브쿼리가 select count(*) from A일 때, A 대신 
  select count(*) from (select * from A) as 임시이름 
  을 이용해야 한다 
*/
UPDATE theater 
SET 
    t_seat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON s_sc_num = sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS t ON sc_t_num = t_num
        WHERE
            t_name = 'CGV강남')
WHERE
    t_name = 'CGV강남';

# CGV영등포에 상영관과 좌석을 추가하는 쿼리
# 1관, 14좌석, 2관, 16좌석, 3관 10좌석, 4관 25좌석
# 1관 : A1~A3, B1~B3, C1~C4, D1~D4
# 2관 : A1~A4, B1~B4, C1~C4, D1~D4
# 3관 : A1,A2, B1,B2, C1,C2, D1,D2, E1,E2
# 4관 : A1~A5, B1~B5, C1~C5, D1~D5, E1~E5

insert into screen(sc_name, sc_seat, sc_t_num) values
(1, 14, 2),
(2, 16, 2),
(3, 10, 2),
(4, 15, 2);
select * from screen;

insert into seat(s_name, s_sc_num) values
# CGV영등포 1관
('A1', 4),('A2', 4),('A3', 4),
('B1', 4),('B2', 4),('B3', 4),
('C1', 4),('C2', 4),('C3', 4),('C4', 4),
('D1', 4),('D2', 4),('D3', 4),('D4', 4),
# CGV영등포 2관
('A1', 5),('A2', 5),('A3', 5),('A4', 5),
('B1', 5),('B2', 5),('B3', 5),('B4', 5),
('C1', 5),('C2', 5),('C3', 5),('C4', 5),
('D1', 5),('D2', 5),('D3', 5),('D4', 5),
# CGV영등포 3관
('A1',6),('A2',6),
('B1',6),('B2',6),
('C1',6),('C2',6),
('D1',6),('D2',6),
('E1',6),('E2',6),
# CGV영등포 4관
('A1',7),('A2',7),('A3',7),('A4',7),('A5',7),
('B1',7),('B2',7),('B3',7),('B4',7),('B5',7),
('C1',7),('C2',7),('C3',7),('C4',7),('C5',7),
('D1',7),('D2',7),('D3',7),('D4',7),('D5',7),
('E1',7),('E2',7),('E3',7),('E4',7),('E5',7);
UPDATE theater 
SET 
    t_seat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON s_sc_num = sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS t ON sc_t_num = t_num
        WHERE
            t_name = 'CGV영등포')
WHERE
    t_name = 'CGV영등포';

# 상영시간을 추가
# CGV강남 1관 상영시간
# 웡카 - 2월 9일 10:30, 13:00, 16:00, 18:10, 20:30
 # CGV강남 2관 상영시간
# 웡카 - 2월 9일 11:30, 14:00, 15:00, 19:10, 21:30
# CGV강남 3관 상영시간
# 웡카 - 2월 9일 12:20, 14:30, 17:30, 19:50

insert into schedule values 
(null, "2024-02-09", "10:30", 1, 1, 1),
(null, "2024-02-09", "13:00", 0, 1, 1),
(null, "2024-02-09", "16:00", 0, 1, 1),
(null, "2024-02-09", "18:10", 0, 1, 1),
(null, "2024-02-09", "20:30", 0, 1, 1),
(null, "2024-02-09", "11:30", 1, 2, 1),
(null, "2024-02-09", "14:00", 0, 2, 1),
(null, "2024-02-09", "15:00", 0, 2, 1),
(null, "2024-02-09", "19:10", 0, 2, 1),
(null, "2024-02-09", "21:30", 0, 2, 1),
(null, "2024-02-09", "12:20", 0, 3, 1),
(null, "2024-02-09", "14:30", 0, 3, 1),
(null, "2024-02-09", "17:30", 0, 3, 1),
(null, "2024-02-09", "19:50", 0, 3, 1);
# 조조할인 적용(12시 이전) 
UPDATE schedule 
SET 
    sh_morning = 1
WHERE
    sh_time <= '12:00';

# 기본 요금을 등록
insert into price values(null, '성인', 14000), (null, '청소년', 10000), 
(null, '성인조조', 11200), (null, '청소년조조', 8000);

# abc123 회원이 웡카를 예매했을 때 쿼리 
# CGV강남 1상영관 10:30 영화를 성인 2명, A1, A2를 예매
# ticketing 테이블에 데이터 추가
insert into ticketing values(null, 2, 0, 11200*2, 1, 'abc123');

# ticketing_list 테이블에 데이터 추가 
insert into ticketing_list(tl_tc_num, tl_s_num)
values(1, 1), (1,2);