package com.kang.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kang.blog.model.RoleType;
import com.kang.blog.model.User;
import com.kang.blog.repository.UserRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;


// html파일이 아니라 db를 리턴해주는 컨트롤러
@RestController //응답만 해줄수 있게
public class DummyControllerTest {
	
	
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return "삭제에 실패하였습니다. 해당 id는 db에 없습니다.";
		} 
		return "삭제되었습니다 id : "+id;
	}
	
	
	@Transactional // 함수 종료 시에 자동 commit이 됨
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id,@RequestBody  User requetUser) {
		//json 데이터를 요청 -> Java Object로 변환해서 받아줌
		//MessageConverter의 Jackson라이브러리가 변환해서 받아줌.
		
		System.out.println("id : "+id);
		System.out.println("password : "+requetUser.getPassword());
		System.out.println("email : "+requetUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()-> {
			return new  IllegalArgumentException("수정에 실패하였습니다");
		}); // 이후 영속화가 됨
		user.setPassword(requetUser.getPassword());
		user.setEmail(requetUser.getEmail());

		// userRepository.save(user);
		//save함수는 id를 전달하지 않으면 insert를 해주고
		// save함수는 id를 전달하면  해당 id에 대한 데이터가 있으면 update를 해주고
		// save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 함
		
		// 더티 체킹
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}// 모든 User DB select
	
	// 한페이지 당 2건의 데이터를 리턴
	@GetMapping("/dummy/user")
	public List<User> pagelist (@PageableDefault(size=2, sort = "id", direction = org.springframework.data.domain.Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return users;
	} //아이디 정렬해서 보여주고 최신순으로 정렬해서 보여줌다.
	
	// {id} 주소로 파라미터를 전달받을수 있음
	// http://localhost:8000/blog/dummy/user/{id}
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// user/4를 찾으면 내가 DB에서 못찾아오게되면 user가 null이됨
		// 그럼 return 할때 null이 return됨
		// Optional로 너의 user객체를 감싸서 가져올테니 null인지 아닌지 판단해서
		// return 해라
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id :"+id);
			}
		});
		// 요청: 웹브라우저
		// user객체는 자바오브젝트
		// 변환 (웹브라우저가 이해할수 있는 데이터) -> JSON
		// 스프링부트는 MessasgeConverter라는 것이 응답시 작동
		// 만약 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson
		//이라는 라이브러리를 호출해서 user 오브젝트를 json으로 변환해서 던져줌
		return user;
	}
	
	// http://localhost:8000/blog/dummy/join (request)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(User user) {
		//매개변수에 key=value(약속된 규칙) 형태의 데이터를 파싱해서 받아줌 
		System.out.println("id : " +user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("creatdate : " + user.getCreateDate());
		
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
		
	}
}
