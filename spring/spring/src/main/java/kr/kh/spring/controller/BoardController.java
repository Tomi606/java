package kr.kh.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list") //@RequestMapping(value="/board/list", method=RequstMethod.GET)
	public String boardList(Model model, Criteria cri) {
		cri.setPerPageNum(5);
		ArrayList<BoardVO> list = boardService.selectBoardList(cri);
		
		//현재 페이지 정보(cri)를 주면서 총 게시글 개수를 가져오라 명령
		int totalCount = boardService.getBoardTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	
	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		//커뮤니티 리스트를 가져와서 화면에 전송
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list", list);
		return "/board/insert";
	}
	
	//첨부파일 여러개라서 []넣음(1개면 안넣어도됨)
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board,
			HttpServletRequest requst, MultipartFile[] file) {
		MemberVO user = (MemberVO)requst.getSession().getAttribute("user");
		if(boardService.insertBoard(board, user, file)) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/board/list");
		}
		else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		return "message";
	}
	
}
