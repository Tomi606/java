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

--------------------------------------------------------------
# 2/6, 두번째에 있는 코드는 강사님
select * from student;
# 컴퓨터공학을 다니는 학생 정보를 조회하는 쿼리 (O)
select * from student where st_major = "컴퓨터공학";

# 컴퓨터공학을 다니는 1학년 학생 정보를 조회 (O)
select * from student where st_major = '컴퓨터공학' and st_grade = 1;

# 컴퓨터공학 또는 화학공학을 다니는 1학년 학생 정보를 조회 (O)
-- and, or이 많다면 괄호를 쳐서 구분, 누굴 먼저 조회해야 될지 구분
select * from student where (st_major = '컴퓨터공학' or st_major = '화학공학') and st_grade = 1;
select * from student where st_major in('컴퓨터공학', '화학공학') and st_grade = 1;

# 컴퓨터공학을 다니는 학생 수를 조회 (O)
select st_major as 학과이름, count(st_num) as 학생수 from student where st_major = '컴퓨터공학';
select count(*) from student where st_major = '컴퓨터공학' group by st_major;

# 학생들이 등록된 학과를 조회 (X)
select distinct st_major from student;

# 학생들이 3명 이상 등록된 학과들을 조회 (O)
select st_major as 학과이름, count(st_num >= 3) as 학생수 from student group by st_major;
select st_major from student group by st_major having count(st_num) >= 3;

select * from lecture;
# 컴퓨터개론을 수강하는 학생 수를 조회 (X)
-- 1)
select le_title as 수강과목, count(co_num) as 학생수
from course
join lecture on co_le_num = le_num
where le_title = '컴퓨터개론';
-- 2) 강사
select count(*)
from course
join lecture on co_le_num = le_num
where le_title = '컴퓨터개론'
group by co_le_num;

# 각 강의별 수강하는 학생 수를 조회(강의명, 학생수) (X)
select le_title as 수강과목, count(co_st_num) as 학생수
from course
join lecture on co_le_num = le_num
group by co_le_num;

# 홍길동 학생이 수강하는 강의목록을 조회 (X)
-- 1)
select st_name as 학생이름, le_title as 수강목록
from student 
join lecture
where st_name = '홍길동';
-- 2) 강사
select st_name, le_title
from course 
join student on co_st_num = st_num
join lecture on co_le_num = le_num
where st_name = '홍길동';

select * from professor;
# 기계공학에 소속된 교수의 수를 조회
select count(pr_major) as "기계공학 교수의 수" from professor where pr_major = '기계공학';
-- where로 기계공학이라는 경우를 줘서 count(*)로 한다.
select count(*) from professor where pr_major = '기계공학';

# 김교수가 강의하는 강의명을 조회
-- 1)
select pr_name as "교수 이름", le_title as 강의명
from professor
join lecture on le_pr_num = pr_num
where pr_name = '김교수';
-- 2)
select pr_name as 교수이름, le_title as 강의명
from course
join lecture on co_le_num = le_num
join professor on le_pr_num = pr_num
where pr_name = "김교수";






