package com.t.avd.exception;


public class RoomException extends TException{
	
	private static final long serialVersionUID = 1L;
	
	public RoomException(String key, String message){
		super(key, message);
	}
}
