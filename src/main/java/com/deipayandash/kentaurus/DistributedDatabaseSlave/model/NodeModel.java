package com.deipayandash.kentaurus.DistributedDatabaseSlave.model;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class NodeModel {

	private final int MAX_WORDS_IN_NODE = 25;
	private String NodeId;

	private String NodeAddress;

	private List<String> words;

	private Set<String> wordsSet;
	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public List<String> getWords() {
		return words;
	}

	public void addWords(List<String> newWords){
		this.wordsSet.addAll(newWords);
		this.words.addAll(newWords);
	}

	public void setWordsSet(Set<String> wordsSet) {
		this.wordsSet = wordsSet;
	}

	public boolean hasWord(String word){
		return wordsSet.contains(word);
	}

	public boolean deleteWord(String word){
		if(!hasWord(word)) return false;
		wordsSet.remove(word);
		words.remove(word);
		return true;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public NodeModel(Dotenv dotenv) {
		NodeId = dotenv.get("NODE_ID");
		NodeAddress = dotenv.get("NODE_ADDRESS");
		this.wordsSet = new HashSet<>();
		this.words = new LinkedList<>();
		isActive=true;
	}

	public String getNodeId() {
		return NodeId;
	}


	public void setNodeId(String nodeId) {
		NodeId = nodeId;
	}

	public String getNodeAddress() {
		return NodeAddress;
	}

	public void setNodeAddress(String nodeAddress) {
		NodeAddress = nodeAddress;
	}
}
