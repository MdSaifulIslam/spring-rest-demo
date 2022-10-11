package com.springlearn.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add a exception handler using @exceptionHandler

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

		StudentErrorResponse theStudentErrorResponse = new StudentErrorResponse();

		theStudentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		theStudentErrorResponse.setMessage(exc.getMessage());
		theStudentErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(theStudentErrorResponse, HttpStatus.NOT_FOUND);

	}

	// add a exception handler for all using @exceptionHandler

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

		StudentErrorResponse theStudentErrorResponse = new StudentErrorResponse();

		theStudentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		theStudentErrorResponse.setMessage(exc.getMessage());
		theStudentErrorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(theStudentErrorResponse, HttpStatus.BAD_REQUEST);

	}

}
