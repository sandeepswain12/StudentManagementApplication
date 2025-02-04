package com.spring.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.crud.dtos.ApiResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessage> ResourceNotFoundExceptionsHandler(ResourceNotFoundException exception){
		ApiResponseMessage responseMessage = new ApiResponseMessage();
		responseMessage.setMessage(exception.getMessage());
		responseMessage.setStatus(HttpStatus.NOT_FOUND);
		responseMessage.setSuccess(true);
		return new ResponseEntity<>(responseMessage,HttpStatus.NOT_FOUND);
	}
}
