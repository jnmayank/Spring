package com.jlearn.Spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/*
	 * Default structure for spring default exception handler.
	 {
	    "timestamp": "2018-12-28T18:32:48.446+0000",
	    "status": 404,
	    "error": "Not Found",
	    "message": "topic doesn't exist",
	    "path": "/topics/deleteTopic/4"
	  }
	  */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7112861163496875412L;

	public NotFoundException(String message) {
		super(message);
	}

}
