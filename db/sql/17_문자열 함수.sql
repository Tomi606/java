#문자열 함수
select length('안녕'); -- 바이트 수를 리턴
select char_length('안녕'); -- 글자 수를 리턴
select concat('%', '안녕', '%'); -- 문자열들을 이어붙여 리턴
select field('안녕', 'hi', 'hello', '안녕', '안녕하세요'); -- 앞에있는 문자(안녕)이 몇번째에 있는지 리턴(1부터 시작, 없으면 0)
select instr('안녕하세요', '안녕'); -- 안녕의 시작 위치를 리턴, 1부터 시작
select locate('안녕', '안녕하세요'); -- 안녕의 시작 위치를 리턴, 1부터 시작
select format(10000.123456, 2); -- 소수점 2째 자리 까지 표현. 3자리마다 , 추가
select bin(31), oct(31), hex(31); -- 2,8,16진수로 반환
select concat(lpad(hex(255),2,0), lpad(hex(0),2,0), lpad(hex(0),2,0)) as 색상코드; -- 16진수를 색상표현 시 사용
select insert('c의 정석', 1, 1, 'java'); -- 기존 문자열의 1번지 부터 1글자를 제거하고 주어진 문자열(java)를 추가
select left('안녕하세요', 2); -- 왼쪽을 기준으로 2글자
select right('안녕하세요', 4); -- 오른쪽을 기준으로 4글자
select lower('ABCdef'), upper('ABCdef'); -- 소문자, 대문자
select lpad(1, 3, 0), rpad(1, 3, 0); -- 왼쪽에 붙이기, 오른쪽에 붙이기
select repeat('안녕', 2); -- 문자열 몇회 반복
select replace('c의 정석', 'c', 'java'); -- 교환
select reverse('abcdef'); -- 거꾸리
select substring('자바의 정석', 1, 2);

# 시간 함수
select adddate(now(), 2); -- 날짜 더하기
select subdate(now(), 2); -- 날짜 빼기
select addtime('11:30', '2:00:00'); -- 설정 시간, 추가할 시간
select subtime('11:30', '2:00:00');
select year(now()), month(now()), day(now());
select date(now()), time(now());
select datediff('2024-03-02',now());
select timediff('11:30', '9:00');

