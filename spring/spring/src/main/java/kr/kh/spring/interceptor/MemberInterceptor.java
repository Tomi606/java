package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

//회원만 입장 가능하게 만드는 인터셉터
public class MemberInterceptor extends HandlerInterceptorAdapter {

	/* 
	 preHandle에서 return값이 true이면 가려던 컨트롤러로 가서 작업을 진행
	 반대로, return 값이 false이면 가려던 컨트롤러로 가지마세요 -> 리다이렉트할 경로가 있으면 해당 경로로 이동
	 */
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
	    throws Exception {
		//회원정보를 리퀘스트에서 가져옴
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//로그인 안 했으면
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		
		return true;
	}
	
}
