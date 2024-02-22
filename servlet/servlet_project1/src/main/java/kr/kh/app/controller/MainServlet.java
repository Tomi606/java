package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//"data"는 home.jsp의 <a href="/servlet_project1?data=안녕"의 data이다.
		//지금까지한건 화면에서 서버로 정보를 보낸 것
		String data = request.getParameter("data");
		System.out.println("전송 받은 데이터 : " + data);
		String id = request.getParameter("id");
		System.out.println("전송 받은 ID : " + id);

		//서버에서 화면으로 정보 보내기
		//화면으로 나이를 전송
		int age = 30;
		request.setAttribute("age", age); //서버에서 화면으로 age를 전송
		//이게 밑에 있어야 age가 서버에서 화면으로 전송된다.
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

}
