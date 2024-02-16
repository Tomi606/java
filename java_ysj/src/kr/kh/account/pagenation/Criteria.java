package kr.kh.account.pagenation;

import lombok.Data;

//현재 페이지 정보를 관리하는 클래스
@Data
public class Criteria {

	private int page; //현재 페이지
	private int perPageNum; //한 페이지에 최대 컨텐츠 개수, 2가지는 필수
	private String search; //검색어. 검색 기능이 필요한 경우
	
	//생성자
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	//쿼리 컨텐츠 갯수 = limit(시작번지, 개수)
	//페이지를 번지를 접는하는 메서드
	public int getPageStart() {
		return (page -1) * perPageNum;
	}
}
