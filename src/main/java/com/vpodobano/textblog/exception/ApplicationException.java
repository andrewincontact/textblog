package com.vpodobano.textblog.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -9094867884480190306L;

	public ApplicationException(String message) {
		super(message);
		
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
