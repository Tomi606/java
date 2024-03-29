package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user"); //세션에 있는 "user"의 정보를 removeAttribute
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.setAttribute("url", "");
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
