package com.kang.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kang.blog.model.Board;
import com.kang.blog.model.User;



@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

}

