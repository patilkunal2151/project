package com.app.customException;

@SuppressWarnings("serial")
public class RecordNotFoundException  extends RuntimeException {

	
	public  RecordNotFoundException(String msg)
	{
		super(msg);
	}
	
}
