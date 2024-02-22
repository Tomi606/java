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
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();

    /* 화면에서 전달한 id와 pw을 콘솔창에 출력 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. login을 처리하는 서블릿 생성
		//4. 코드 구현
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//로그인에 성공하면 user의 정보를 받아옴.
		MemberVO user = memberService.login(new LoginDTO(id, pw));
		//System.out.println(user); 데이터 잘 가져오는지 확인, 비번틀리면 null로 가져옴
		
		//로그인에 성공했을 시
		//session : request에 있다. 로그인 연결 유지, 서버쪽에 저장됨. 연결끊김 또는 시간만료가 되면 세션이 사라짐.
		if(user != null) {
			//세션에 회원 정보를 저장하여 로그인 유지
			HttpSession session = request.getSession(); //요청한 정보(request, 서버쪽에서 만들어짐)에서 세션을 가져옴
			session.setAttribute("user", user); //세션에 user라는 이름으로 회원 정보 저장
			//로그인이 성공하면 웹 브라우저에 toString이 출력됨
		}
		doGet(request, response);
	}

}
