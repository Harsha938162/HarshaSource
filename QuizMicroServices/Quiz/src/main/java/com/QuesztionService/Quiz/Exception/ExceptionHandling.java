package com.QuesztionService.Quiz.Exception;

public class ExceptionHandling extends RuntimeException{
	public String ErrorMsg;
	public ExceptionHandling(String ErrorMessage)
	{
		super();
		this.ErrorMsg=ErrorMessage;
		
	}

}
