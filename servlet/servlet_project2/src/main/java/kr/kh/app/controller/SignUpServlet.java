package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/signup") //post 필요
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에서 보낸 데이터를 가져옴
		//form태그 안 입력 태그에 name이 id요소의 값을 가져옴
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		//이용중이라는 회원 상태가 DB에 저장되있는 경우
		MemberVO member = new MemberVO(id, pw, email, "이용중");
		//member을 주고 회원가입 시켜주세요.
		boolean res = memberService.signup(member);
		if(res) {
			//성공하면 메인페이지(sendRedirect는 url을 바꿔줌)
			request.setAttribute("msg", "회원가입에 성공했습니다.");
			request.setAttribute("url", "");
		} else {
			//실패하면 회원가입 페이지
			request.setAttribute("msg", "회원가입에 실패했습니다.");
			request.setAttribute("url", "signup");
		}
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
