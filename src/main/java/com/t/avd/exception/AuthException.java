package com.t.avd.exception;


public class AuthException extends TException{
	
	private static final long serialVersionUID = 1L;
	
	public AuthException(String key, String message){
		super(key, message);
	}
}
