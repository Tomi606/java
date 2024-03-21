package kr.kh.spring.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {

	private String me_id;
	private String me_pw;
	private String me_ms_state;
	private String me_email;
	private String me_autority;
	private String me_stop;
	private int me_fail;
	private boolean autoLogin; //DB에는 안넣음. boolean 타입은 "is~()"로 가져온다.(set, get X)
	private String me_cookie;
	private Date me_cookie_limit;
}
