package kr.kh.app.pagination;

import lombok.Data;

@Data
public class PageMaker {
	//전체 게시글이 131개, 한 페이지에 게시글이 10개 조회, 14페이지 까지 나옴
	private int totalCount; //전체 컨텐츠 개수 => 마지막 페이지네이션의 마지막 페이지를 계산하기 위해
	private int startPage; //페이지네이션 시작 페이지번호
	private int endPage; //페이지네이션 끝 페이지번호
	private boolean prev; //이전버튼 활성화
	private boolean next; //다음버튼 활성화
	private int displayPageNum; //한 페이지네이션에서 보여준 페이지의 최대 숫자 개수(밑에 있는 페이지)
	private Criteria cri;
	
	//totalCount, displayPageNum, perPageNum(cri)을 이용하여
	//endPage, startPage, prev, next를 계산하는 메서드
	public void calculate() {
		//현재 페이지에 대한 최대 페이지번호(마지막페이지)
		//현재 페이지가 4페이지 이고, 한 페이지에 컨텐츠 개수가 10개 이고, 한 페이지네이션의 페이지 개수가 10개 일 때
		/*
		endPage = (int)(Math.ceil(4/10.0) * 10);
		endPage = (int)(Math.ceil(0.4) * 10);
		cri.getPage() : 현재 페이지(4)
		(double)displayPageNum : 한 페이지 컨텐츠 개수(10.0)
		displayPageNum : 한 페이지네이션의 페이지 개수(10)
		*/
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		//시작페이지 : 1, 11, 21... 에서 시작
		startPage = endPage - displayPageNum + 1;
		
		//컨텐츠 개수를 이용하여 계산한 최대 페이지 번호 : 14
		//totalCount = 131개, (double)cri.getPerPageNum() = 10.0 후 반올림 = 14
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		//endPage와 tmpEngPage 둘 중에 작은 수를 endPage로 넣으면 됨 ex)14랑 20이랑 비교했을 때 14를 endPage로 설정
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		//첫번째 페이지네이션이면 false 아니면 true
		prev = startPage == 1? false : true;
		//마지막 페이지네이션이면 false 아니면 true
		next = endPage == tmpEndPage? false : true;
	}
	
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
}
