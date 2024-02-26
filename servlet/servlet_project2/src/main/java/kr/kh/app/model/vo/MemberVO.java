package kr.kh.app.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {

	private String me_id;
	private String me_ms_state;
	private String me_pw;
	private String me_email;
	private String me_autority;
	private Date me_stop;
	private int me_fail;
	
	//회원가입 회원의 id,pw,email,me_ms_state을 담는 생성자
	//sql에 있는 속성들의 not null과 default 값을 보고 넣어준다.
	public MemberVO(String me_id, String me_pw, String me_email, String me_ms_state) {
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_email = me_email;
		this.me_ms_state = me_ms_state;
	}
		
}
