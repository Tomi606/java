SELECT * FROM shoppingmall.certification;
drop event delete_certification;

# 인증시간이 만료되면 1초마다 체크해서 인증정보를 삭제
create event delete_certification
on schedule every 1 second
do
	delete from certification where ce_limit <= now();
# 이벤트 스케쥴러 ON
SET GLOBAL event_scheduler = ON;
# 이벤트 작업 내용
SELECT * FROM information_schema.EVENTS;

# 지정 시간에 이벤트가 1번만 실행됨 그 후 이벤트 삭제
create event delete_certification
on schedule at '2024-02-15 09:46:00'
on completion not preserve
do
	delete from certification where ce_limit <= now();