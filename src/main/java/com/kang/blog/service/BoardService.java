package com.kang.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kang.blog.model.Board;
import com.kang.blog.model.RoleType;
import com.kang.blog.model.User;
import com.kang.blog.repository.BoardRepository;
import com.kang.blog.repository.UserRepository;


@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@org.springframework.transaction.annotation.Transactional
	public void 글쓰기(Board board, User user) { //title, content 받는다.
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다");
				});
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void 글수정하기(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다");
				}); //영속화
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시(Service가 종료될때) 트랜잭션이 종료됨. 이때 더티 체킹 - 자동 업데이트가 됨 db로 flush됨
	}
}
