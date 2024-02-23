package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.vo.MemberVO;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 작성은 회원만 작성 가능하기 때문에 아래 작업을 진행 - 게시글 등록은 회원만 가능, 비회원은 등록 불가능(요구사항)
		//로그인한 회원 정보를 가져옴 => session 에서 user(로그인서블렛에서 정한게 "user"라서) 정보를 가져옴
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user"); //getAttribute는 Object 클래스
		//MemberVO user = (MemberVO)request.getSession().getAttribute("user"); 위의 코드를 1줄로 작성
		
		//회원정보가 없으면 게시글 리스트로 이동
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/board/list");
			return; //밑의 코드 실행되면 안되니까 리턴
		}
		
		//유저 정보가 있으면 board/insert.jsp로 이동
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
