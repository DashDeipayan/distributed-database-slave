package com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class NodeAction {
	private final String message;
	private final HttpStatus code;

	public NodeAction(String message, HttpStatus code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getCode() {
		return code;
	}
}
