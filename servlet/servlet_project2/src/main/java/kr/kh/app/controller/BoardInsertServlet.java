package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/insert")
@MultipartConfig(
	maxFileSize = 1024 * 1024 * 10, //10Mb
	maxRequestSize = 1024 * 1024 * 10 * 3, //10Mb 최대 3개
	fileSizeThreshold = 1024 * 1024 //1Mb : 파일 업로드 시 메모리에 저장되는 임시 파일 크기
)
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 회원 정보를 가져옴(게시글 등록은 로그인한 회원만 가능하기 때문에)
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user"); //->"user"인 이유? 로그인 서블릿가면 로그인 성공했을 때 setAttribute에 "user"라고 했기 때문에
		//회원 정보가 없으면 로그인이 필요한 서비스입니다 라고 출력 후 게시글 리스트로 이동
		if(user == null) {
			//화면에 로그인이 필요한 서비스 입니다라고 출력
			request.setAttribute("msg","로그인이 필요한 서비스 입니다.");
			//화면에 url로 게시판 리스트로 이동
			request.setAttribute("url", "board/list"); //->앞에 슬래쉬가 붙어있기 때문에 앞에 떼고
			//message.jsp로 전송
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		//있으면 게시글 등록 화면을 전송
		else {
			//서비스에게 게시판 리스트를 가져오라고 시킴 : getCommunityList
			ArrayList<CommunityVO> list = boardService.getCommunityList();	
			//화면에 게시판 리스트를 보냄
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 제목, 내용을 가져옴
		String title = request.getParameter("title"); //""은 jsp의 name과 맞춰야함
		String content = request.getParameter("content");
		//세션에서 회원 정보를 가져옴
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//회원 정보가 없으면
		if(user == null) {
			//화면에 msg로 로그인이 필요한 서비스입니다 라고 전송
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			//화면에 url로 board/list 전송
			request.setAttribute("url", "board/list");
			//message.jsp를 전송
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return; //else 안써도됨
		}
		//회원 정보가 있으면
		//작성자에 회원 아이디를 저장
		String writer = user.getMe_id();
		//게시판 번호는 1번으로 저장 -> 고른걸로 설정
		int co_num = Integer.parseInt(request.getParameter("community"));
		//제목, 내용, 작성자, 게시판 번호를 이용하여 게시글 객체를 생성
		BoardVO board = new BoardVO(title, content, writer, co_num);
		
		//첨부파일들을 가져옴
		ArrayList<Part> partList = (ArrayList<Part>)request.getParts();
		
		//서비스에게 게시글 객체를 주면서 등록하라고 시킴
		boolean res = boardService.insertBoard(board, partList);
		//등록하면 화면에 msg로 게시글을 등록했습니다 라고 전송
		if(res) {
			request.setAttribute("msg", "게시글을 등록했습니다.");
		}
		//등록하지 못하면 화면에 msg로 게시글을 등록하지 못했습니다 라고 전송
		else {
			request.setAttribute("msg", "게시글을 등록하지 못했습니다.");
		}
		//화면에 url로 board/list 전송
		request.setAttribute("url", "board/list");
		//message.jsp를 전송
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
