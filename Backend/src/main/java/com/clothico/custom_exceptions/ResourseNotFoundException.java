package com.clothico.custom_exceptions;

public class ResourseNotFoundException extends RuntimeException {

	public ResourseNotFoundException(String msg) {
		super(msg);
	}

}
