package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
//서블릿에 같이 user정보 저장했던 걸 인터셉터 클래스로 나눠서 저장하는 거
public class LoginInterceptor extends HandlerInterceptorAdapter {
	//디스패처 서블릿에서 컨트롤러로 들어가기 전 작업할 내용 : 컨트롤러 실행 전 동작
	//멤버 필터, 게스트 필터를 구현할 수 있다.(어떤 url에 들어가기 전에 멤버인지 아닌지 체크)
//	@Override
//	public boolean preHandle(
//			HttpServletRequest request, 
//			HttpServletResponse response, 
//			Object handler)
//	    throws Exception {
//		return true;
//	}

	//컨트롤러에서 디스패처 서블릿으로 가기 전 작업할 내용 : 컨트롤러 실행 후 동작
	//로그인
	@Override
	public void postHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler, 
		ModelAndView modelAndView)
		throws Exception {
		//홈 컨트롤러의 로그인 된 user의 정보를 가져옴
		//ModelAndView 객체에서 model 객체에 넣어준 user를 가져오는 코드
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		System.out.println(user);
		//로그인에 성공 했으면
		if(user != null) {
			//세션에 user 정보 저장
			request.getSession().setAttribute("user", user);
		}
		
	}
	
}
