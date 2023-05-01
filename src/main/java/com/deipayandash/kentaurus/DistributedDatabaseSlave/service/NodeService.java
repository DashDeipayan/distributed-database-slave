package com.deipayandash.kentaurus.DistributedDatabaseSlave.service;

import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.NodeModel;
import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response.NodeAction;
import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response.NodeWordsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class NodeService {

	@Autowired
	private NodeModel nodeModel;

	public int getNodeId(){
		return nodeModel.getNodeId();
	}

	public boolean getNodeStatus(){
		return nodeModel.isActive();
	}

	public NodeAction setNodeStatus(boolean activate){
		if(nodeModel.isActive() && activate) return new NodeAction("Node already active", HttpStatus.BAD_REQUEST);
		if(!nodeModel.isActive() && !activate) return new NodeAction("Node already inactive", HttpStatus.BAD_REQUEST);

		nodeModel.setActive(activate);
		return new NodeAction("Node is active="+activate,HttpStatus.OK);
	}

	public NodeWordsData getNodeWords(){
		return new NodeWordsData("Node data fetched successfully", nodeModel.getWords());
	}

	public NodeAction deleteNodeWords(){
		nodeModel.setWords(new LinkedList<>());
		nodeModel.setWordsSet(new HashSet<>());
		return new NodeAction("Node data deleted successfully", HttpStatus.OK);
	}

	public NodeAction deleteNodeWord(String word){
		boolean wasDeleted = nodeModel.deleteWord(word);
		return wasDeleted?new NodeAction("Word was deleted", HttpStatus.OK):new NodeAction("Word doesn't exists", HttpStatus.NOT_FOUND);
	}

	public NodeAction addWords(List<String> newWords){
		nodeModel.addWords(newWords);
		return new NodeAction("Words added Successfully", HttpStatus.CREATED);
	}
}
