package db.mybatis.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	
	// table과 멤버변수 이름을 맞추면 편함
	private String id;
	private String pw;
	private String email;
	private Date reg_date;
	
	public MemberVO(String id, String pw, String email) {
		this.id = id;
		this.pw = pw;
		this.email = email;
	}
}
