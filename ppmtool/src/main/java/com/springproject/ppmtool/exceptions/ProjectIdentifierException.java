package com.springproject.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)//this class defines the Exception
public class ProjectIdentifierException extends RuntimeException {

	public ProjectIdentifierException(String arg0) {
		super(arg0);
	}
	

}
