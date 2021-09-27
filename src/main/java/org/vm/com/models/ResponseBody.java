package org.vm.com.models;


import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseBody {
	
	private String message;
	private HttpStatus httpCode;
	private List<?> data;
	

	public ResponseBody() {
		super();
		
	}


	public ResponseBody(String message, HttpStatus httpCode, List<?> data) {
		super();
		this.message = message;
		this.httpCode = httpCode;
		this.data = data;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public HttpStatus getHttpCode() {
		return httpCode;
	}


	public void setHttpCode(HttpStatus httpCode) {
		this.httpCode = httpCode;
	}


	public List<?> getData() {
		return data;
	}


	public void setData(List<?> data) {
		this.data = data;
	}
	
	



	
	
	
	

}
