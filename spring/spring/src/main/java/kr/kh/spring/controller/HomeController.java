package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.TestDTO;

//controller = 여러 개의 Servlet
@Controller
public class HomeController {
	
	//@RequestMapping : url 전송/ value : url, method : 전송 방식(get, post)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//model.addAttribute("화면에서 사용할 이름","보낼 데이터");
		model.addAttribute("name","홍길동");
		
		//해당하는 jsp로 리턴
		return "home";
	}
	
	//이 예제 잘 기억!!!
	@RequestMapping(value = "/", method = RequestMethod.POST)
	//매개변수를 추가해주면 자동으로 매핑해줌(jsp의 name과 매개변수가 같으면)
	public String homePost(Model model, TestDTO testDto/*, String name, int age*/) {
		/*
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		TestDTO testDto = new TestDTO(name, age);
		 */
		System.out.println(testDto);
		return "home";
	}
	
	@RequestMapping(value = "/test/{num}", method = RequestMethod.GET)
	//@PathVariable : 경로 변수를 표시하기 위해 메서드에 매개변수에 사용된다. 경로 변수는 중괄호 {id} 값. URL 경로에서 변수 값을 추출하여 매개변수에 할당한다.
	public String test(Model model, @PathVariable("num")int num) {
		System.out.println("경로 데이터 : " + num);
		return "redirect:/";
	}
	
}
