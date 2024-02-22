package kr.kh.app.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본 생성자(매개변수 없는 생성자)
public class MemberVO {
	
	//MySql에서 복사해온 변수명
	private String me_id;
	private String me_ms_state;
	private String me_pw;
	private String me_email;
	private String me_autority;
	private Date me_stop;
	private int me_fail;
	
	//회원가입 시 id, pw, email 받기
	public MemberVO(String me_id, String me_pw, String me_email) {
		this.me_id = me_id;
		this.me_pw = me_pw;
		this.me_email = me_email;
	}
	
	
}
