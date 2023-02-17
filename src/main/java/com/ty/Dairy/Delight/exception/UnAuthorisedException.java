package com.ty.Dairy.Delight.exception;

public class UnAuthorisedException extends RuntimeException{
	
	private String msg="Invalid Username Or Password";

	public UnAuthorisedException() {
		super();
	}
	
	public String getMessage()
	{
		return this.msg;
	}

}
