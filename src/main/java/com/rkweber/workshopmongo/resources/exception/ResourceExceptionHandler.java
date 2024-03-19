package com.rkweber.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rkweber.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // tratar possiveis erros nas requisições
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandError err = new StandError(System.currentTimeMillis(), status.value(), "Not found", exception.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
