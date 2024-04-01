package kr.kh.spring2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring2.model.dto.LoginDTO;

@RestController //@Controller + @ResponseBody : return 값 자체를 데이터로 전송
@RequestMapping("/ajax")
public class AjaxController {

	@PostMapping("/json/json")
	public Map<String, Object> jsonJson(@RequestBody LoginDTO member) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(member);
		//"화면에서 쓸 이름(String)", 다양한 클래스 객체(Object : 어떠한 객체든 전달 가능)
		map.put("member", member);
		map.put("name", "홍길동");
		return map;
	}
	
	@GetMapping("/object/json")
	public Map<String, Object> objectJson(
			@RequestParam("id")String id, @RequestParam("name") String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(id);
		System.out.println(name);
		map.put("age", 21);
		return map;
	}
	
	@GetMapping("/object/json2")
	public Map<String, Object> objectJson2(
			@RequestParam("name")String name, @RequestParam("age") int age) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(name);
		System.out.println(age);
		map.put("result", "성공");
		return map;
	}
	
	@GetMapping("/object/object") //타입을 자유롭게 변형가능 문자열 보내고 싶다 -> String, 문자열 -> ArrayList<E>
	public String objectObject(@RequestParam("name")String name) {
		System.out.println(name);
		return "";
//		public ArrayList<String>일 경우
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("안녕하세요");
//		return list;
	}
}
