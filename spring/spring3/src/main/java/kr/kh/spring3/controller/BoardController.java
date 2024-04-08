package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
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
		cri.setPerPageNum(3); //한 페이지 당 5개의 게시글
		//현재 페이지 정보를 주면서 게시글 목록을 가져오라고 요청
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		//현재 페이지 정보를 주면서 전체 게시글을 가져오라 명령
		int totalCount = boardService.getBoardTotalCount(cri);
		//전체 게시글 목록 수, 현재 페이지 정보, 한 페이지네이션의 페이지 개수를 정해서 PageMaker 객체를 생성
		PageMaker pm = new PageMaker(3, cri, totalCount);

		model.addAttribute("title", "게시글");
		model.addAttribute("list", list);
		model.addAttribute("pm", pm); //화면에서 PageMaker 객체를 전송
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String postInsert(Model model) {
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		log.info(list);
		model.addAttribute("list", list);
		model.addAttribute("title", "게시글 등록");
		return "/post/insert";
	}
	
	@PostMapping("/post/insert")
	public String postInsertPost(Model model, BoardVO board, HttpSession session, MultipartFile [] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertBoard(board, user, files);
		log.info(user);
		log.info(board);
		log.info(files);
		if(res) {
			model.addAttribute("msg", "게시글 등록 완료");
			model.addAttribute("url", "/post/list");
		}else {
			model.addAttribute("msg", "게시글 등록 실패");
			model.addAttribute("url", "/post/insert");
		}
		
		return "message";
	}
	
	@GetMapping("/post/detail")
	public String postDetail(Model model, int num) {
		log.info(num);
		//조회수 증가
		boardService.updateView(num);
		//상세 페이지 조회
		BoardVO board = boardService.getPostDetail(num);
		//첨부파일
		ArrayList<FileVO> list = boardService.getFileList(num);
		//화면에 게시글, 첨부파일 전송
		model.addAttribute("board", board);
		model.addAttribute("list", list);
		return "/post/detail";
	}
	
}
