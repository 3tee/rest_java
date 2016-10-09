package com.t.avd.exception;

public class TException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1458894362490241634L;

	private String key;

	private String message;

	public TException() {
		super();
	}

	public TException(String key, String message) {
		this.key = key;
		this.message = message;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String code) {
		this.key = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
