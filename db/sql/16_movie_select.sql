# 영화 웡카의 영화 정보를 검색하는 쿼리(배우X, 감독X, 제작국가X, 장르X)
select * from movie;

# 영화 웡카에 출연한 배우 및 감독을 조회하는 쿼리
select mv_title as 영화명, a_role as 역할, c_name as 이름
from movie
join `join` on j_mv_num = mv_num
join `artist` on j_a_num = a_num
join `character` on a_c_num = c_num
where mv_title like '웡카%';