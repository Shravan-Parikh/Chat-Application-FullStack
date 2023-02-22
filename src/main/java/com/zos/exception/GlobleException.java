package com.zos.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobleException {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetail> UserExceptionHandler(UserException ue,WebRequest req){
		
		ErrorDetail err =new ErrorDetail(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MessageException.class)
	public ResponseEntity<ErrorDetail> MessageExceptionHandler(MessageException ue,WebRequest req){
		
		ErrorDetail err =new ErrorDetail(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> otherErrorHandler(Exception e,WebRequest req){
		
		ErrorDetail err =new ErrorDetail(e.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}

}
