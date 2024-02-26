package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {

	private int bo_num; 
	private int bo_co_num; //게시글의 게시판(카테고리) 번호
	private String bo_me_id;
	private String bo_title;
	private String bo_content;
	private int bo_view;
	private int bo_report_count;
	//private CommunityVO community;
}
