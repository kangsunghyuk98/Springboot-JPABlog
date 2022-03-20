package com.kang.blog.model;

import java.security.Timestamp;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@NoArgsConstructor // 빈생성자
@AllArgsConstructor // 전체생성자
@Builder // 빌더패턴
@Entity // 동작 시 User 클래스가 변수를 읽어서 테이블화 시킴
//@DynamicInsert // insert시에 null인 필드제외시켜줌
public class User {
	//GeneratedType이 Identity이면 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //시퀀스, auto_increment
	
	
	@Column(nullable = false, length = 30, unique = true) //빈칸 안됨, 길이최대 30, 중복안됨
	private String username; //id
	@Column(nullable = false, length = 100) //빈칸 안됨, 길이최대 100 암호화 위해 넉넉히
	private String password; //pw
	@Column(nullable = false, length = 50)
	private String email; //email
	
	
	// @ColumnDefault("'user'")
	// DB는 RoleType이라는 게 없다
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. // ADMIN, USER
	
	
	@CreationTimestamp //시간이 자동으로 입력됨
	private java.sql.Timestamp createDate; //자바가 가지고 있는 타임스탬프
	// 가입할 때 비워놔도 CreationTimestamp를 걸었기 때문에 자동으로 입력됨.
	
}
