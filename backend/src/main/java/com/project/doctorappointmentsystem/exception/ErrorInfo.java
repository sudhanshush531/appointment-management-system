package com.project.doctorappointmentsystem.exception;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ErrorInfo {

	private Date timestamp;
	private String message;
	private String details;
	private int status;

	public ErrorInfo(Date timestamp, String message, String details, int code) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.status = code;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}