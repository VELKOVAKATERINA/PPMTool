package com.springproject.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //ControllerAdvice makes the exception global for all controllers not just for ProjectController
@RestController //if the ProjectIdentifierException was thrown this class tells how the exception to be handled
public class ProjectIdentifierExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIdException(ProjectIdentifierException ex, WebRequest request){
		ProjectIdentifierExceptionResponse exceptionResponse=new ProjectIdentifierExceptionResponse(ex.getMessage());
//		return handleExceptionInternal(ex, ex.getMessage(), 
//		          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}

}
