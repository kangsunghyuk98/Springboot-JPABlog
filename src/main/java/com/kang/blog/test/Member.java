package com.kang.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@Data
//@AllArgsConstructor
//전체생성자
@NoArgsConstructor
//빈생성자
//@RequiredArgsConstructor
// final 붙은 변수들에 대한 생성자 만들어줌
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	// private로 만드는 이유?
	// 다이렉트로 변수에 접근할 수 없게 하기위함임
	// 함수를 거쳐 함수에서 동작이 일어나서 변수에 접근함
	/* 데이터베이스에 있는 값을 가져와서 집어넣을거라서 
	 * 데이터가 변경되지 않게 final로 데이터를 딱 잡아놓는다
	   불변성유지를 위함
	   변경하고 싶다면 final 붙이면 안된다
	*/
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	//빌더패턴은 롬복쓰면 빌드패턴 다만들어줌
	// 장점은 값의 순서를 안지켜도됨 생성자 필드의 순서를 안지켜도됨.
}
