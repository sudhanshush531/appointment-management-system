package com.project.doctorappointmentsystem.exception;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private int code;

	public NotFoundException(String exception) {
		super(exception);
	}

	public NotFoundException(String exception, int code) {
		super(exception);
		this.code = code;
	}
}