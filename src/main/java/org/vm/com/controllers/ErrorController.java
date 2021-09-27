package org.vm.com.controllers;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.vm.com.models.ResponseBody;

import com.google.gson.Gson;

@ControllerAdvice
public class ErrorController {
	
	Gson gson = new Gson();
	
	@ExceptionHandler(Exception.class)
	public String customExceptionHandler(Exception e)
	{
		ResponseBody response = new ResponseBody("Contact Admin! "+e.getMessage(),
												  HttpStatus.INTERNAL_SERVER_ERROR,
				 								  Arrays.asList());
		

		HttpHeaders headers = new HttpHeaders();
				    headers.setContentType(MediaType.APPLICATION_JSON);
				    
	  
		return   gson.toJson(new ResponseEntity<ResponseBody>(response,headers,HttpStatus.INTERNAL_SERVER_ERROR));    
	}

}
