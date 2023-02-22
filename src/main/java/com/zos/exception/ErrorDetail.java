package com.zos.exception;

import java.time.LocalDateTime;

public class ErrorDetail {
	
	private String message;
	private String detail;
	private LocalDateTime timestamp;
	
	public ErrorDetail() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetail(String message, String detail, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.detail = detail;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	

}
