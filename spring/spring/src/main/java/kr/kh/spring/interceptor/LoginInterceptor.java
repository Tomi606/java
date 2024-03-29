package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;
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

	@Autowired
	private MemberService memberService;
	
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
		//로그인에 성공 했으면
		if(user != null) {
			//세션에 user 정보 저장
			request.getSession().setAttribute("user", user);
			
			//자동 로그인을 체크했으면
			if(user.isAutoLogin()) {				
				//쿠키를 생성해서
				String value = request.getSession().getId(); //세션의 아이디를 가져와서 밑 쿠키에 저장
				Cookie cookie = new Cookie("loginCookie", value); //("쿠키명", 쿠키값)
				cookie.setPath("/"); //"쿠키가 유효한 URL 경로", 모든 url에서 유효하도록 /
				//7일
				int time = 7 * 24 * 60 * 60; //(7일 24시간 60분 60초)7일을 초로 환산
				cookie.setMaxAge(time); //쿠키유지기간(seconds기준)
				
				//화면에 전송(response 객체에 쿠키를 담아서 전송
				response.addCookie(cookie);
				
				//DB에 관련 정보를 추가
				//세션 아이디와 만료시간
				user.setMe_cookie(value);
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_cookie_limit(date);
				memberService.updateMemberCookie(user);
			}
			//되돌아 갈 url이 있으면 해당 url로 돌아감.
			String url = (String)request.getSession().getAttribute("prevUrl");
			//돌아갈 url이 있다면
			if(url != null) {
				response.sendRedirect(url);
				request.getSession().removeAttribute("prevUrl");
			}
		}
		
	}
	
}
