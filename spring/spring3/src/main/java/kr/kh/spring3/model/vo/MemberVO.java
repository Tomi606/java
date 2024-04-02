package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	
	private String me_id;
	private String me_pw;
	private String me_pw2;
	private String me_email;
	private String me_ms_state;
	
	//회원가입 시
	public MemberVO(String id, String pw, String email, String me_ms_state) {
		super();
		me_id = id;
		me_pw = pw;
		me_email = email;
		this.me_ms_state = me_ms_state;
	}
	
	
}
