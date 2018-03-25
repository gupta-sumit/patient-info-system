package com.ds.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ds.services.DocumentSaveException;

@ControllerAdvice
@RestController
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

	@ExceptionHandler(FobiddenAccessException.class)
	public ResponseEntity<ErrorDetails> handleException(FobiddenAccessException e) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(DocumentSaveException.class)
	public ResponseEntity<ErrorDetails> handleException(DocumentSaveException e) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
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
