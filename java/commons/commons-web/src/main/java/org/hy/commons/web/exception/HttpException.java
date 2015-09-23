package org.hy.commons.web.exception;

import org.hy.commons.lang.exception.CommonRuntimeException;

public class HttpException extends CommonRuntimeException{

	public HttpException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HttpException(String message, Throwable nested) {
		super(message, nested);
		// TODO Auto-generated constructor stub
	}

	public HttpException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HttpException(Throwable nested) {
		super(nested);
		// TODO Auto-generated constructor stub
	}

}
