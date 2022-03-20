package com.kang.blog.test;

public class People {
	private int hungryState = 50; //100이 만땅
	// 다이렉트로 접근할 수 없게 private로 변수 선언함
	
	public void eat() {
		hungryState += 10;
	}
	
	
	public static void main(String[] args) {
		People p = new People();
		// p.hungryState = 100; 이렇게하는게 아님
		p.eat(); // 함수를 통해서 접근
	}
}
// 배고픈 상태가 50인데 바로 변수에 접근해서 100으로 마법을
// 부리는건 객체지향과 맞지않다