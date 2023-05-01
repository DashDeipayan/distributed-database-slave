package com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response;

import org.springframework.stereotype.Component;

@Component
public class NodeIdData {
	private String message;
	private String nodeId;

	public NodeIdData(String message, String nodeId) {
		this.message = message;
		this.nodeId = nodeId;
	}

	public NodeIdData() {
	}

	public String getMessage() {
		return message;
	}

	public String getNodeId() {
		return nodeId;
	}
}
