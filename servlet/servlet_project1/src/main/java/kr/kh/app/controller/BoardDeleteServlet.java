package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 있는 회원 정보를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//화면에서 보낸 게시글 번호 num을 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch(Exception e) {
			num = 0;
		}
		//보드서비스에게 회원 정보와 게시글 번호를 주면서 삭제하라고 명령 후 삭제 여부 알려달라고 요청
		boolean res = boardService.deleteBoard(num, user);
		
		//삭제에 성공하면
		if(res) {
			//화면에 msg로 게시글을 삭제했습니다. 라고 전송
			request.setAttribute("msg", "게시글을 삭제했습니다.");
			//화면에 url로 board/list로 전송
			request.setAttribute("url", "board/list");	
		}
		//삭제에 실패하면
		else {
			//화면에 msg로 게시글 삭제에 실패했습니다. 라고 전송
			request.setAttribute("msg", "게시글 삭제에 실패했습니다.");
			//화면에 url로 board/detail?num=번호로 전송
			request.setAttribute("url", "board/detail?num="+num);
		}
		//message.jsp 화면을 전송
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
