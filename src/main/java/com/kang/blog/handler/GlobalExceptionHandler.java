package com.kang.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.kang.blog.dto.ResponseDto;


@ControllerAdvice //Exception이 발생하면 이 클래스로 들어오게 됨
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseDto<String> handleArgumentException(Exception e) {
		return new ResponseDto<String> (HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
	}
}
