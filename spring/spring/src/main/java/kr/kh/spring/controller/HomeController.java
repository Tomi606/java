package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controller = 여러개의 Servlet
@Controller
public class HomeController {
	
	//@RequestMapping : ó���� url ����/ value : url, method : 전송 방식(get, post)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		//���ϴ� jsp�� �־��ָ� ����
		return "home";
	}
	
}
