package com.jlearn.Spring.exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author MJ
 * Dec 29, 2018
 */

// applicable to all the controllers by default
// Use selectors {@basePackageClasses()}, and {@basePackages()}
// to define a more narrow subset of targeted Controllers.
// Classes with {@code @ControllerAdvice} can be declared explicitly as Spring
// beans or auto-detected via classpath scanning.

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(Exception ex){		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), "");		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleException(Exception ex){		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), "");		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, 
			HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "validation failed", 
				ex.getBindingResult().toString()); // retrieving the validation failed detail, Javax.validation api.
		
		//ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
		//ex.getBindingResult().toString());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
