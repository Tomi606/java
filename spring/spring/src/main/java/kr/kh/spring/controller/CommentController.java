package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.CommentService;

/*
 CommentController에 있는 모드 메서드들이(url을 이용하여 접근하는 메서드)
 ajax로 통신하는 경우, 메서드 위에 있는 @ResponseBody 를 지우고
 클래스 상단에 @Controller 대신 @RestController로 대체할 수 있다.
 그래서 @RestController에 있는 메서드들은 ajax로 통신한다(비동기 통신)
 */
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comment/list") //또는 @PostMapping("경로")
	public Map<String, Object> commentList(@RequestBody Criteria cri){
		Map<String, Object> map = new HashMap<String, Object>();
		cri.setPerPageNum(3); //1 페이지 당 댓글 3개
		//한 페이지(cri)를 주면서 댓글 리스트 가져오라고 명령
		ArrayList<CommentVO> commentList = commentService.getCommentList(cri);
		int totalCount = commentService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		map.put("commentList", commentList);
		map.put("pm", pm);
		return map;
	}
	
	@PostMapping("/comment/insert")
	public Map<String, Object> commentInsert(@RequestBody CommentVO comment, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO) session.getAttribute("user");
		//확인용
		//System.out.println(comment);
		//System.out.println(user);
		
		boolean res = commentService.insertComment(comment, user);
		//success의 console.log(data.result);에서 사용
		map.put("result", res);
		return map;
	}
	
}
