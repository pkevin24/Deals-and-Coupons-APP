package com.user.advice;

import java.util.HashMap;
import java.util.Map;

import com.user.exception.AdminAuthenticationException;
import com.user.exception.PasswordNotMatchingException;
import com.user.exception.UserNameEmailDuplicateException;
import com.user.exception.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException ex){
		Map<String,String> errorMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		}
		);
		return errorMap;
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleUserNotFoundException(UserNotFoundException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message",ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNameEmailDuplicateException.class)
	public Map<String,String> handleUserNotFoundException(UserNameEmailDuplicateException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message",ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PasswordNotMatchingException.class)
	public Map<String,String> handleUserNotFoundException(PasswordNotMatchingException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message",ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(AdminAuthenticationException.class)
	public Map<String,String> handleUserNotFoundException(AdminAuthenticationException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message",ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BadCredentialsException.class)
	public Map<String,String> handleUserNotFoundException(BadCredentialsException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message",ex.getMessage());
		return errorMap;
	}
}
