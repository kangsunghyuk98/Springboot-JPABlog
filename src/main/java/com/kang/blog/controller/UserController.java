package com.kang.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth 이하로 허용
// 그냥 주소가 /이면 index.jsp로 가는것 허용
// static이하에 있는 /js 이하나 /css 이하나 img 이하 리소스파일들 허용
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		// 회원가입 굳이 인증 필요없음
		
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		
		
		return "user/loginForm";
	}
}
