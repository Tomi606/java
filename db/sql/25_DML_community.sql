USE COMMUNITY;

# 회원 상태를 추가하는 쿼리(이용 중, 기간 정지, 영구 정지, 탈퇴)
INSERT INTO MEMBER_STATE VALUES('이용중'), ('기간정지'), ('영구정지'), ('탈퇴');
select * from member_state;
# 3명이 각각 회원 가입을 진행할 때 필요한 쿼리 
# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.co.kr, 권한 : USER
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL,ME_MS_STATE) 
VALUES('abc123','abc123','abc123@kh.co.kr', '이용중');

# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.co.kr, 권한 : USER
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL,ME_MS_STATE) 
VALUES('qwe123','qwe123','qwe123@kh.co.kr', '이용중');

# 아이디 : admin, 비번 : admin, 이메일 : admin@kh.co.kr, 권한 : ADMIN
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_AUTHORITY,ME_MS_STATE) 
VALUES('admin','admin','admin@kh.co.kr', 'ADMIN', '이용중');

# 관리자가 커뮤니티를 등록(공지, 자유, 토론, 공부)
INSERT INTO COMMUNITY(CO_NAME) VALUES('공지');
INSERT INTO COMMUNITY(CO_NAME) VALUES('자유');
INSERT INTO COMMUNITY(CO_NAME) VALUES('토론');
INSERT INTO COMMUNITY(CO_NAME) VALUES('공부');

# abc123회원이 자유 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리 
# 제목 : 테스트, 내용 : 테스트 입니다. 첨부파일 : 없음
INSERT INTO BOARD(BO_CO_NUM, BO_ME_ID, BO_TITLE, BO_CONTENT)
VALUES(2, 'abc123', '테스트', '테스트 입니다.');

INSERT INTO BOARD(BO_CO_NUM, BO_ME_ID, BO_TITLE, BO_CONTENT)
SELECT CO_NUM, 'abc123', '테스트', '테스트 입니다.' FROM COMMUNITY WHERE CO_NAME='자유';

# admin 관리자가 공지 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 공지사항, 내용 : 공지사항입니다. 첨부파일 : 공지사항1.jpg
# 첨부파일은 서버업로드 되면 현재 날짜를 기준으로 폴더를 생성해서 업로드 함 
# 업로드된 첨부파일은 /2024/02/14/파일명으로 저장 
INSERT INTO BOARD(BO_CO_NUM, BO_ME_ID, BO_TITLE, BO_CONTENT)
SELECT CO_NUM, 'admin', '공지사항', '공지사항입니다' FROM COMMUNITY WHERE CO_NAME='공지';

INSERT FILE(FI_BO_NUM, FI_NAME, FI_ORI_NAME)
VALUES(3, '/2024/02/14/공지사항1.JPG', '공지사항1.JPG');

# 공지 커뮤니티에 등록된 모든 게시글을 조회하는 쿼리 
SELECT * FROM BOARD JOIN COMMUNITY ON BO_CO_NUM = CO_NUM WHERE CO_NAME = '공지';

# 공지 커뮤니티에 등록된 게시글 중 1페이지에 해당하는 게시글을 조회하는 쿼리 
SELECT 
    *
FROM
    BOARD
        JOIN
    COMMUNITY ON BO_CO_NUM = CO_NUM
WHERE
    CO_NAME = '공지'
ORDER BY BO_NUM DESC 
LIMIT 0, 10;

# 3번 게시글을 상세 조회했을 때 실행되는 쿼리 
# 1. 3번 게시글의 조회수를 증가하는 쿼리
UPDATE BOARD SET BO_VIEW = BO_VIEW + 1 WHERE BO_NUM = 3;
# 2. 3번 게시글 조회하는 쿼리
SELECT * FROM BOARD WHERE BO_NUM = 3;

# 게시글 목록에서 abc123 아이디를 클릭했을 때 실행되는 쿼리 
SELECT 
    *
FROM
    BOARD
WHERE
    BO_ME_ID = 'abc123'
ORDER BY BO_NUM DESC
LIMIT 0 , 10;

# qwe123회원이 1번 게시글의 추천 버튼을 클릭 했을 때 실행되는 쿼리 
# 1. qwe123회원이 1번 게시글에 추천한 기록을 조회 
SELECT * FROM RECOMMEND WHERE RE_ME_ID = 'abc123' AND RE_BO_NUM = 1;

# 2-1. 추천한 기록이 없다면 추천을 추가 
INSERT INTO RECOMMEND(RE_ME_ID, RE_BO_NUM, RE_STATE)
VALUES('abc123', 1, 1);
# 2-2. 추천한 기록이 있다면 추천을 수정 
# 2-2-1. 추천한 기록이 추천인 경우 => 추천을 취소 
UPDATE RECOMMEND SET RE_STATE = 0 WHERE RE_BO_NUM = 1 AND RE_ME_ID = 'abc123';
# 2-2-2. 추천한 기록이 추천이 아닌 경우 => 비추천이거나 추천/비추천을 취소한 경우에서 다시 추천한 경우 
UPDATE RECOMMEND SET RE_STATE = 1 WHERE RE_BO_NUM = 1 AND RE_ME_ID = 'abc123';

# 아이디와 게시글이 주어졌을 때 추천을 추가하거나 수정하는 프로시저
DROP PROCEDURE IF EXISTS BOARD_RECOMMEND;

DELIMITER //
CREATE PROCEDURE BOARD_RECOMMEND(
	IN _ID VARCHAR(13),
    IN _BO_NUM INT,
    IN _STATE INT # 1이면 추천, -1이면 비추천 
)
BEGIN
	DECLARE _RE_NUM INT;
    DECLARE _RE_STATE INT;
    DECLARE _NEW_STATE INT;
    # 1. 아이디, 게시글 번호를 이용하여 등록된 추천 번호를 조회해서 변수에 저장
    SET _RE_NUM = 
		(SELECT RE_NUM FROM RECOMMEND WHERE RE_ME_ID = _ID AND RE_BO_NUM = _BO_NUM);
    # 2-1. 추천 번호가 NULL이면 추천 테이블에 추가 
    IF _RE_NUM IS NULL THEN
		INSERT INTO RECOMMEND(RE_ME_ID, RE_BO_NUM, RE_STATE)
		VALUES(_ID, _BO_NUM, _STATE);
    
    # 2-2. 추천 번호가 NULL이 아니면
    ELSE
		# 2-2-0. 추천 번호에 맞는 추천 상태를 가져옴 
		SET _RE_STATE = (SELECT RE_STATE FROM RECOMMEND WHERE RE_NUM = _RE_NUM);
        /*
        # 2-2-1. 추천 상태가 _STATE와 같으면 취소(0) => 0으로 수정  
        IF _RE_STATE = _STATE THEN
			UPDATE RECOMMEND SET RE_STATE = 0 
            WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID = _ID;
		
        # 2-2-2. 추천 상태가 _STATE와 다르면 _STATE로 수정 
        ELSE
			UPDATE RECOMMEND SET RE_STATE = _STATE 
            WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID = _ID;
        END IF;
        */
        # 2-2-1. 추천 상태가 _STATE와 같으면 취소(0) => 0으로 수정  
        IF _RE_STATE = _STATE THEN
			SET _NEW_STATE = 0;
        # 2-2-2. 추천 상태가 _STATE와 다르면 _STATE로 수정 
        ELSE
			SET _NEW_STATE = _STATE;
        END IF;
        UPDATE RECOMMEND SET RE_STATE = _NEW_STATE 
            WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID = _ID;
	END IF;
END //
DELIMITER ;

CALL BOARD_RECOMMEND('abc123', 1, -1);

use community;
# 공지 커뮤니티에 1페이지에 등록된 게시글 목록을 조회하는 쿼리
select * 
from board 
where bo_co_num = (select co_num from community where co_name = '공지')
-- order by를 통해 내림차순
order by bo_num desc
-- limit을 통해 페이지 제한
limit 0, 10;
select * from board;

# 3번 게시글을 상세 조회하는 쿼리
select * from board where bo_num = 3;

# abc123회원이 3번 게시글에 확인했습니다 라고 댓글을 달았을 때 쿼리
insert into comment(cm_bo_num, cm_me_id, cm_content) values(3, 'abc123', '확인했습니다.'); 
select * from comment;

# 3번 게시글에 등록된 댓글 1페이지를 조회하는 쿼리
select * 
from comment
where cm_bo_num = 3
order by bo_num desc
-- 한페이지에 댓글 최대 5개
limit 0, 5;
select * from comment;

# 신고 사유
insert into `report_type` values('욕설'), ('허위사실유포'), ('음란'), ('커뮤니티에 맞지 않음'), ('기타');

# admin이 1번 댓글을 '기타'로 신고(신고하려면 사유필요 -> 사유등록먼저)
-- 댓글과 외래키가 연결이 안됨
-- table : 게시글인지 댓글인지, target : *번 게시글/댓글
insert 
into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_state, rp_target)
values('admin', '기타', 'comment', '', '신고접수', 1);

# 관리자가 신고 내역을 조회 -> 신고접수된 내역을 조회
select * from report where rp_state = '신고접수';
select * from report;
# 관리자가 1번 신고내역을 '신고반려' 로 처리했을 때
update report 
set rp_state = '신고반려'
where rp_num = 1;

# abc123 회원이 1번 게시글을 '기타', '내용없음'으로 신고
insert 
into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_state, rp_target)
values('abc123', '기타', 'board', '', '신고접수', 1);

# qwe123 회원이 1번 게시글을 '기타', '내용없음'으로 신고
insert 
into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_state, rp_target)
values('qwe123', '기타', 'board', '', '신고접수', 1);

# admin 관리자가 1번 게시글을 '기타', '내용없음'으로 신고
insert 
into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_state, rp_target)
values('admin', '기타', 'board', '', '신고접수', 1);

# 관리자가 1번 게시글을 신고 내역을 모두 '신고처리'로 처리
update report 
set rp_state = '신고처리'
where rp_target = 1 and rp_table = 'board' and rp_state = '신고접수';

SELECT 
    COUNT(*)
FROM
    report
WHERE
    rp_target = 1 AND rp_table = 'board'
        AND rp_state = '신고처리';
        
# 신고처리된 게시글의 신고수를 수정
UPDATE board 
SET 
    bo_report_count = (SELECT 
            COUNT(*)
        FROM
            report
        WHERE
            rp_target = 1 AND rp_table = 'board'
                AND rp_state = '신고처리')
WHERE
    bo_num = 1;
# 3번 신고된 1번 게시글을 삭제하고, 1번 게시글을 작성한 작성자에게 1달 이용정지를 적용
-- 1번 게시글을 삭제하기 위해 1번 게시글에 댓글들을 삭제
delete from comment where cm_bo_num = 1;
-- 1번 게시글을 삭제하기 위해 1번 게시글을 추천한 추천 정보를 삭제
delete from recommend where re_bo_num = 1;
-- 1번 게시글을 삭제
delete from board where bo_num = 1;
-- abc123 회원 1달 이용정지
update member 
set me_ms_state = '기간정지', me_stop = date_add(now(), interval 1 month)
where me_id = 'abc123';

# qwe123 회원이 회원을 탈퇴
update member set me_ms_state = '탈퇴' where me_id = 'qwe123';
-- delete from `member` where me_id = qwe123;
select * from member;
