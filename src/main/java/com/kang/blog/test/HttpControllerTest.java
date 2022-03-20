package com.kang.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답(html)

//사용자가 요청 -> 데이터를 응답하는게 컨트롤러
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest" ;
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("kang").password("1234").email("kangsh").build();
		System.out.println(TAG+"getter : "+m.getUsername());
		m.setUsername("kangsunghyuk");
		System.out.println(TAG+"setter : "+m.getUsername());
		return "lombok test finish";
	}
	
	// http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청:";
	}
	
	// http://localhost:8080/http/post (insert)
	//인터넷 브라우저 요청은 무조건 get만가능
	@PostMapping("/http/post") // application//json
	public String postTest(@RequestBody Member m) {
		return "post 요청:"+m.getId()+m.getUsername()+m.getPassword()+m.getEmail();
	} //json형식으로 매핑 MessageConverter (스프링부트)
	
	// http://localhost:8080/http/put (update)
	//인터넷 브라우저 요청은 무조건 get만가능
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		
		return "put 요청 :"+m.getId()+m.getUsername()+m.getPassword()+m.getEmail();
	}
	
	// http://localhost:8080/http/delete (delete)
	//인터넷 브라우저 요청은 무조건 get만가능
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
