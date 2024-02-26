package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디와 비번을 받아옴
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//받아온 아이디와 비번을 이용하여 LoginDTO 객체를 생성
		LoginDTO loginDto = new LoginDTO(id, pw);
		
		//LoginDto 객체(사용자가 입력한 객체)를 이용해서 memberService에게 MemberVO(DB에 있는 정보) 객체를 달라고 요청.
		MemberVO user = memberService.getMember(loginDto);	//중요!!!
		
		//성공하면 세션에 회원 정보를 지정하고 메인 페이지로 이동
		if(user != null) {
			request.setAttribute("msg", "로그인 성공");
			request.setAttribute("url", ""); //메인 페이지로 이동
			request.getSession().setAttribute("user", user); //세션 + 어트리부트
			
		}
		//실패하면 로그인 페이지로 이동
		else {
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("url", "login"); //로그인 페이지로 이동
		}
		//메세지로 화면 전송
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
