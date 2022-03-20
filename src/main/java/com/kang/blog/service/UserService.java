package com.kang.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kang.blog.model.RoleType;
import com.kang.blog.model.User;
import com.kang.blog.repository.UserRepository;


// spring이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. ioc를 해줌
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@org.springframework.transaction.annotation.Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword(); // 비번 원문
		String encPassword = encoder.encode(rawPassword); // 해쉬화
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
			userRepository.save(user);
	}
	
	// Select 할때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료
//	@org.springframework.transaction.annotation.Transactional(readOnly = true)
//	public User 로그인(User user) {
//			return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
	
}
