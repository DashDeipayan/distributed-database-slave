package com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NodeWordsData {
	private final String message;
	private final List<String> words;

	public NodeWordsData(String message, List<String> words) {
		this.message = message;
		this.words = words;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getWords() {
		return words;
	}
}
