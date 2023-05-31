package com.example.custome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContollerException {
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Object> notFounExceptionHandler(BusinessException exception) {
		return new ResponseEntity<>("Employee Not Found", HttpStatus.OK);

	}

}
