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
	private CommunityVO community; 
	//게시글이 조회되면 게시글의 bo_co_num을 이용해서 객체 정보를 가져옴, 보드매퍼에 resultMap 추가
	//BoardMapper의 <collection property="community">에서 사용
	
	//게시글 작성 시 필요
	public BoardVO(int bo_co_num, String bo_title, String bo_content, String me_id) {
		this.bo_co_num = bo_co_num;
		this.bo_title = bo_title;
		this.bo_content = bo_content;
		this.bo_me_id = me_id;
	}

	//수정
	public BoardVO(int num, String title, String content) {
		this.bo_num = num;
		this.bo_title = title;
		this.bo_content = content;
	}

}