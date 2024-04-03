package kr.kh.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/post/list")
	public String postList(Model model, Criteria cri) {
		cri.setPerPageNum(2); //한 페이지 당 5개의 게시글
		//현재 페이지 정보를 주면서 게시글 목록을 가져오라고 요청
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보를 주면서 전체 게시글을 가져오라 명령
		int totalCount = boardService.getBoardTotalCount();
		//전체 게시글 목록 수, 현재 페이지 정보, 한 페이지네이션의 페이지 개수를 정해서 PageMaker 객체를 생성
		PageMaker pm = new PageMaker(5, cri, totalCount);
		
		model.addAttribute("title", "게시글");
		model.addAttribute("list", list);
		model.addAttribute("pm", pm); //화면에서 PageMaker 객체를 전송
		return "/post/list";
	}
	
}
