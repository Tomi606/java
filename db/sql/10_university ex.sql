# 컴퓨터공학 고길동 학생이 수강 신청한 강의 개수를 조회하는 쿼리
select st_name as "이름", st_major as "전공", count(*) as "신청한 강의 수"
-- course에 학생 정보가 안나오기 때문에 join student
from course join student on co_st_num = st_num
-- 어떤 학생
where st_major = "컴퓨터공학" and st_name = "고길동";

# 컴퓨터공학 고길동 학생이 수강 신청한 학점을 조회하는 쿼리
											-- sum(속성명)을 넣어준다
select st_name as "이름", st_major as "전공", sum(le_point) as "수강 신청한 학점"
from course
-- inner join은 순서 상관 X
join student on co_st_num = st_num
-- 학점은 강의에 있다
join lecture on co_le_num = le_num
where st_major = "컴퓨터공학" and st_name = "고길동";

# 24학년 신입생을 조회하는 쿼리
select *
										-- 편입생이 있을 수 있어서
from student where st_num like "2024%" and st_grade = 1;

# 각 전공별 학생 수를 조회하는 쿼리
select st_major as "전공", count(*) as "학생수"
from student
-- 각 전공을 그룹화
group by st_major;

# 강의별 수강 신청한 학생 수를 조회하는 쿼리 : 강의명, 학생수 순으로 조회
select le_title as "강의명", count(co_st_num) as "수강생 수"
from course
join lecture on co_le_num = le_num
group by le_num; -- le_title로 하지 않은 이유? unique를 쓰지 않았고, 강의의 제목이 중복될 수 있기 때문에




