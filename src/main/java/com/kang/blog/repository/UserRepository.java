package com.kang.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kang.blog.model.User;


// 자동으로 bean등록이 된다.
@Repository //생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	// SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
}

//해당 JPaRepository는 User테이블이 관리함 그리고 User테이블의 
//프라이머리 키는 integer이다
	// JPA Naming 전략
	// SELECT * FROM user WHERE username =? AND password = ? ;
//User findByUsernameAndPassword(String username, String password);

	//@Query(value = "SELECT * FROM user WHERE username =? AND password = ?", nativeQuery = true)
	//User login(String username, String password);
