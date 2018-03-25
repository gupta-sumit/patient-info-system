package com.am.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.am.services.DocumentAccessNotConfiguredException;
import com.am.services.RequestNotFoundException;
import com.am.services.impl.RequestAlreadyClosedException;


@ControllerAdvice
@RestController
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RequestNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleException(RequestNotFoundException e) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DocumentAccessNotConfiguredException.class)
	public ResponseEntity<ErrorDetails> handleException(DocumentAccessNotConfiguredException e) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalAccessException.class)
	public ResponseEntity<ErrorDetails> handleException(IllegalAccessException e) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(RequestAlreadyClosedException.class)
	public ResponseEntity<ErrorDetails> handleException(RequestAlreadyClosedException e) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	
	private static class ErrorDetails {
		private Date timestamp;
		private String message;
		private String details;

		public ErrorDetails(Date timestamp, String message, String details) {
			super();
			this.setTimestamp(timestamp);
			this.setMessage(message);
			this.setDetails(details);
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}
	}
	
	
}
