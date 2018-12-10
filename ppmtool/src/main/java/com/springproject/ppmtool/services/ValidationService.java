package com.springproject.ppmtool.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
@Service
public class ValidationService {
	
	public ResponseEntity<HashMap<String, String>> getMapErrors(BindingResult result){
		if(result.hasErrors()) {
			HashMap<String, String> errors=new HashMap<String,String>();
			List<FieldError> fieldErrorList=result.getFieldErrors();
			for(FieldError error:fieldErrorList) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<HashMap<String, String>>(errors, HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
