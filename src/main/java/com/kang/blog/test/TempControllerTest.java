package com.kang.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//컨트롤러는 해당 경로 이하에 있는 파일을 리턴해준다
@Controller
public class TempControllerTest {

	// http://localhost:8000/blog/temp/home
	@GetMapping("temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일리턴 기본경로 : src/main/resources/static
		//리턴명을 : /home.html 이라고 해야 경로가 제대로 설정됨
		return "/home.html";
	}
	
	@GetMapping("temp/jsp")
	public String tempJsp() {
		//prefix : /WEB-INF/views/
		//suffix : .jsp
		// 플네임 : /WEB-INF/views/test.jsp
		return "test";
	}
	//jsp는 정적인 파일이아니라 동적인 파일임 (컴파일이 일어나야되는 파일)
	
	
	
}

