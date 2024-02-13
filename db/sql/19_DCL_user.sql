SELECT User, Host FROM mysql.user;
# 사용자 추가
create user 'stajun'@'%' identified by 'abc123';
# 사용자 비번 변경
SET PASSWORD FOR 'stajun'@'%' = 'def123';
# 사용자 삭제
DROP USER 'stajun'@'%';

# 계정에 권한 부여
-- grant 권한종류 DB명.테이블명 to '사용자명'@'호스트명';
# 권한 부여
grant all privileges on `shoppingmall`.product to 'stajun'@'%';
# 권한 제거
revoke all privileges on `shoppingmall`.product from 'stajun'@'%';

grant all privileges on `shoppingmall`.* to 'stajun'@'%';