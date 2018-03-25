package com.am.dto;

public class AccessResponseDTO {

	private String requestId;

	public AccessResponseDTO(String requestId2) {
		this.requestId = requestId2;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
}
