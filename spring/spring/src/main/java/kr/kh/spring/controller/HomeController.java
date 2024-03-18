package kr.kh.spring.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.service.MemberService;

//controller = 여러 개의 Servlet
@Controller
public class HomeController {
	//스프링에서는 new를 안하고 어노테이션 이용
	@Autowired //해당 클래스를 싱글톤으로 만들어줌
	private MemberService memberService;
	private BoardService boardService;
	
	//메인화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//jsp 리턴
		return "/main/home";
	}
	
	//회원가입
	//"태그가 a"이면 무조건 "get" method
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		
		return "/member/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	//spring은 MemberVO member를 멤버변수로 바로 받을 수 있다.
	//주의사항 : 정수로 받을 때 에러 안나게 조심(문자열을 -> 정수로 바꿀 수 없기때문)
	public String signupPost(Model model, MemberVO member) {
		if(memberService.insertMember(member)) {
			model.addAttribute("msg", "회원가입을 완료했습니다.");
			model.addAttribute("url", "/");
		}
		else {
			model.addAttribute("msg", "회원가입을 실패했습니다.");
			model.addAttribute("url", "/signup");
		}
		return "message";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		
		return "/member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, LoginDTO loginDto) {
		MemberVO user = memberService.login(loginDto);
		//확인용 : System.out.println(user);
		if(user != null) {
			model.addAttribute("user", user);
			model.addAttribute("msg", "로그인 되었습니다.");
			model.addAttribute("url", "/");
		}
		else {
			model.addAttribute("msg", "로그인 실패했습니다.");
			model.addAttribute("url", "/login");
		}
		return "message";
	}
	
	@GetMapping(value="/logout")
	public String logout(Model model, HttpSession session) {
		//로그아웃 => 세션에 회원 정보를 제거
		session.removeAttribute("user");
		
		model.addAttribute("msg", "로그아웃 되었습니다.");
		model.addAttribute("url", "/");
		return "message";
	}
	
}
