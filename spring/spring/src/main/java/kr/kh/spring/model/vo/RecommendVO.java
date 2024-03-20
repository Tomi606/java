package kr.kh.spring.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendVO {

	private int re_num;
	private String re_me_id;
	private int re_bo_num; 
	private int re_state;
	
	public RecommendVO(int num, String me_id) {
		re_num = num;
		re_me_id = me_id;
	}
}
