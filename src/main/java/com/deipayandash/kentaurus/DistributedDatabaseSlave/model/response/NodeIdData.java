package com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response;

import org.springframework.stereotype.Component;

@Component
public class NodeIdData {
	private final String message;
	private final int nodeId;

	public NodeIdData(String message, int nodeId) {
		this.message = message;
		this.nodeId = nodeId;
	}

	public String getMessage() {
		return message;
	}

	public int getNodeId() {
		return nodeId;
	}
}
