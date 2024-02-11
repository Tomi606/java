# 영화 웡카의 영화 정보를 검색하는 쿼리(배우X, 감독X, 제작국가X, 장르X)
select * from movie;

# 영화 웡카에 출연한 배우 및 감독을 조회하는 쿼리
select mv_title as 영화명, a_role as 역할, c_name as 이름
from movie
join `join` on j_mv_num = mv_num
join `artist` on j_a_num = a_num
join `character` on a_c_num = c_num
where mv_title like '웡카%';

# CGV강남 1상영관에 등록된 좌석을 조회하는 쿼리
SELECT 
    *
FROM
    seat
        JOIN
    screen ON s_sc_num = sc_num
        JOIN
    theater ON sc_t_num = t_num
WHERE
    sc_name = 1 AND t_name = 'CGV강남';

# CGV강남에 등록된 좌석을 조회하는 쿼리
SELECT 
    *
FROM
    seat
        JOIN
    screen ON s_sc_num = sc_num
        JOIN
    theater ON sc_t_num = t_num
WHERE
    t_name = 'CGV강남';

# CGV강남에 등록된 좌석수를 조회하는 쿼리
SELECT 
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
    t_name = 'CGV강남';

# 영화 웡카를 상영하고 있는 극장을 조회하는 쿼리 
SELECT DISTINCT
    t_name, mv_title
FROM
    theater
        JOIN
    screen ON sc_t_num = t_num
        JOIN
    schedule ON sh_sc_num = sc_num
        JOIN
    movie ON mv_num = sh_mv_num
WHERE
    mv_title = '웡카';
# CGV강남 1상영관에 웡카 상영 시간을 조회하는 쿼리 
SELECT 
    mv_title as 영화, t_name as 극장, sh_date as 날짜, sh_time as 시간
FROM
    schedule
        JOIN
    screen ON sh_sc_num = sc_num
        JOIN
    theater ON t_num = sc_t_num
        JOIN
    movie ON mv_num = sh_mv_num
WHERE
	t_name = 'CGV강남' and sc_num = 1 and mv_title = '웡카';

# CGV강남 1상영관에 있는 좌석들을 조회하는 쿼리 
SELECT 
    s_name
FROM
    seat
        JOIN
    screen ON sc_num = s_sc_num
        JOIN
    theater ON t_num = sc_t_num
where
	th_name = 'CGV강남' and sc_name = 1;
# 2월 9일 10:30분 CGV강남 1상영관에서 상영하는 웡카의 좌석을 조회하는 쿼리 
SELECT 
    sh_date, sh_time, s_name
FROM
    seat
        JOIN
    screen ON sc_num = s_sc_num
        JOIN
    theater ON th_num = sc_t_num
        JOIN
    schedule ON sh_sc_num = sc_num
WHERE
    t_name = 'CGV강남' AND sc_name = 1
        AND sh_date = '2024-02-09'
        AND sh_time = '10:30';

# CGV강남 1상영관 2월 9일 10:30 웡카를 예매한 좌석들을 조회 
# 1번 스케쥴을 예매한 좌석들을 조회 
SELECT 
    s_name
FROM
    schedule
        JOIN
    ticketing ON tc_sh_num = sh_num
        JOIN
    ticketing_list ON tl_tc_num = tc_num
        JOIN
    seat ON s_num = tl_s_num
WHERE
    sh_num = 1;

# 1번 스케쥴에서 좌석들 예약 상태을 하는 쿼리 (예약되면 tl_num를 보여주고, 아니면 null)
SELECT 
    s_name as 좌석, ifnull(tl_num, 'O')
FROM
    seat JOIN
    screen ON sc_num = s_sc_num JOIN
    schedule ON sh_sc_num = sc_num
        LEFT JOIN
    (SELECT *FROM  ticketing_list
    JOIN ticketing ON tc_num = tl_tc_num
    WHERE
        tc_sh_num = 1) AS t ON tl_s_num = s_num
WHERE
    sh_num = 1;

# abc123회원이 예매한 영화 목록을 조회하는 쿼리 
# ticketing과 schedule과 movie를 join해서 조회 
SELECT DISTINCT
    mv_title
FROM
    ticketing
        JOIN
    schedule ON sh_num = tc_sh_num
        JOIN
    movie ON mv_num = sh_mv_num
WHERE
    tc_m_id = 'abc123';

# 1번 상영시간(웡카, CGV강남 1상영관 10:30 스케쥴)이 예매된 수량을 조회 
SELECT 
    SUM(tc_adult) + SUM(tc_teenager) as 예매수량
FROM
    ticketing
WHERE
    tc_sh_num = 1;

# 폴 킹 감독이 감독으로 연출한 영화를 조회하는 쿼리 
SELECT 
    mv_title
FROM
    movie
        JOIN
    `join` ON j_mv_num = mv_num
        JOIN
    artist ON a_num = j_a_num
        JOIN
    `character` ON c_num = a_c_num
WHERE
    a_role = '감독' AND c_name = '폴킹';

# 장르별 등록된 영화 개수를 조회하는 쿼리 
SELECT 
    g_name, COUNT(gi_mo_num)
FROM
    genre_include
        RIGHT JOIN
    genre ON g_name = gi_g_name
GROUP BY g_name;

# 환타지로 등록된 모든 영화를 조회하는 쿼리 
SELECT 
    mv_title, gi_g_name
FROM
    movie
        JOIN
    genre_include ON gi_mv_num = mv_num
WHERE
    gi_g_name = '환타지';

# 상영 예정인 영화를 조회하는 쿼리 
SELECT 
    *
FROM
    movie
WHERE
    mv_date > '2024-02-08';

# 전체관람가 영화를 조회하는 쿼리 
SELECT 
    *
FROM
    movie
WHERE
    mv_ag_name = '전체관람가';

# 영화 제목에 카를 포함하는 영화를 조회하는 쿼리 
SELECT 
    *
FROM
    movie
WHERE
    mv_title LIKE '%카%';