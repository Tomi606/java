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

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
	
    public SignUpServlet() {
    }

    //1. 서블릿 생성 후 doGet에 request.getRequestDispatcher 구현
    //지금까지한건 화면에서 서버로 정보를 보낸 것
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		//id가 중복일 때
		if(memberService.signup(new MemberVO(id, pw, email))) {
			//회원가입에 성공하면 메인 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/"); // "/" : 메인페이지			
		}
		else {
			//실패하면 회원가입 페이지 유지
			doGet(request, response);
		}

	}

}
