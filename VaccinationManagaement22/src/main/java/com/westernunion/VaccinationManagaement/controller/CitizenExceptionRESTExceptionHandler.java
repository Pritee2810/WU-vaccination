package com.westernunion.VaccinationManagaement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CitizenExceptionRESTExceptionHandler 
{

	@ExceptionHandler
	public ResponseEntity<CitizenErrorResponse> handleException(CitizenNotFoundException cnfe)
	{
		CitizenErrorResponse myResponse=new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),cnfe.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity(myResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CitizenErrorResponse> handleException(Exception e)
	{
		CitizenErrorResponse myResponse=new CitizenErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		
		
		return new ResponseEntity(myResponse,HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler
	public ResponseEntity<CitizenErrorResponse> handleException(GenericException ge)
	{
		CitizenErrorResponse myResponse=new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),ge.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity(myResponse,HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
