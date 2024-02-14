use movie;

# 상영관에 좌석이 추가되면 상영관 전체 좌석수와 영화관 전체 좌석수를 업데이트하는 트리거 생성
-- seat 테이블에 좌석이 추가되면 screen 테이블과 theater 테이블의 좌석수를 수정하는 트리거
drop trigger if exists insert_seat;

delimiter //
-- 좌석 테이블에 인서트 된 후에 생성(이미 만들어졌음)
create trigger insert_seat after insert on seat
for each row
begin
	declare _sc_num int;
    declare _sc_seat int;
    declare _th_num int;
    declare _th_seat int;
    
    # 상영관 번호
    set _sc_num = new.se_sc_num;
    # 상영관에 있는 전체 좌석수 계산
    set _sc_seat = (select count(*) from seat where se_sc_num = _sc_num);
    # 상영관에 있는 전체 좌석수를 업데이트
    update screen set sc_seat = _sc_seat where sc_num = _sc_num;
    
    # 영화관 번호
    set _th_num = (select sc_th_num from screen where sc_num = _sc_num);
    # 영화관 전체 좌석 수
    set _th_seat = (select count(*) from seat where se_sc_num in (select sc_num from screen where sc_th_num));
	# 영화관에 있는 전체 좌석수 업데이트
    update theater set th_seat = _th_seat where th_num = _th_num;
end //
delimiter ;

drop trigger if exists insert_screen;
# 상영관이 추가되면 영화관 전체 상영관수를 업데이트하는 트리커
delimiter //

create trigger insert_screen after insert on screen
for each row
begin
	declare _th_num int;
    declare _th_screen int;
    
	# 영화관 번호
    set _th_num = new.sc_th_num;
    # 영화관 전체 좌석 수
    set _th_screen = (select count(*) from screen where sc_th_num = _th_num);
	# 영화관에 있는 전체 좌석수 업데이트
    update theater set th_screen = _th_screen where th_num = _th_num;
end //
delimiter ;
insert into screen(sc_name, sc_seat, sc_th_num) values(4, 0, 1);
select * from theater;

select count(*) from seat where se_sc_num in (select sc_num from screen where sc_th_num);