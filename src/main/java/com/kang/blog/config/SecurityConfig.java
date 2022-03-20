package com.kang.blog.config;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kang.blog.config.auth.PrincipalDetailService;

// 빈 등록 : 스프링컨테이너에서 객체를 관리 할 수 있게 하는 것
@Configuration // 빈 등록
@EnableWebSecurity // 시큐리티 필터가 등록이 됨
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크함
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	
	@Bean //IOC가 됨
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder(); 
	}
	
	// 시큐리티가 대신 로그인해주는데 password를 가로채기하는데
	// 해당 password가 멀로 해쉬가 되어 회원가입이 되었는지 알아야
	// 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable() // csrf 토큰 비활성화 (테스트 시 거는게 좋음)
			.authorizeRequests() //어떤 요청에 대한 인가가 들어오면
				.antMatchers("/","/auth/**", "/js/**", "/css/**", "/image/**") // auth이하의 주소에 대해
				.permitAll() // 누구나 페이지 출입 허용
				.anyRequest() // 그 외의 다른 모든 요청이 들어오면
				.authenticated() // 인증된 사용자만 출입 허가
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신로그인해줌
				.defaultSuccessUrl("/"); // 정상적으로 요청이 완료되면 이쪽으로 이동
	}
}
