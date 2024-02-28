package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 게시글 번호를 가져옴
		int num;
		//형변환이 안될 경우 예외 처리
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch(Exception e) {
			//예외가 뜨면 num이 0으로 들어간다.
			num = 0;
		}
		//boardService에게 게시글 번호(num)을 주면서 게시글(detail)을 가져오라고 명령
		BoardVO board = boardService.getBoard(num);
		//화면에 게시글을 전송
		request.setAttribute("board", board);
		//화면을 전송
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
	}

}
