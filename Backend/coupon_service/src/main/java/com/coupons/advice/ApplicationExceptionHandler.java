package com.coupons.advice;

import java.util.HashMap;
import java.util.Map;

import com.coupons.exception.CouponsNotFoundException;

import org.springframework.http.HttpStatus;
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
	@ExceptionHandler(CouponsNotFoundException.class)
	public Map<String,String> handleUserNotFoundException(CouponsNotFoundException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("error message", ex.getMessage());
		return errorMap;
		
	}
}

