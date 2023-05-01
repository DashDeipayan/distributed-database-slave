package com.deipayandash.kentaurus.DistributedDatabaseSlave.controller;

import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.WordsModel;
import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response.NodeAction;
import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response.NodeIdData;
import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.response.NodeWordsData;
import com.deipayandash.kentaurus.DistributedDatabaseSlave.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class SlaveController {

	@Autowired
	private NodeService nodeService;
	@GetMapping("/node")
	public ResponseEntity<NodeIdData> getNodeId(){
		if(!nodeService.getNodeStatus()) return new ResponseEntity<>(new NodeIdData("Node is inactive", ""),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new NodeIdData("Node Id fetched successfully", nodeService.getNodeId()), HttpStatus.OK);
	}

	@PatchMapping("/node/{activate}")
	public ResponseEntity<String> setNodeStatus(@PathVariable boolean activate){
		NodeAction nodeAction = nodeService.setNodeStatus(activate);
		return new ResponseEntity<>(nodeAction.getMessage(),nodeAction.getCode());
	}

	@GetMapping("/words")
	public ResponseEntity<NodeWordsData> getNodeWords(){
		if(!nodeService.getNodeStatus()) return new ResponseEntity<>(new NodeWordsData("Node is inactive",new LinkedList<>()), HttpStatus.BAD_REQUEST);

		NodeWordsData nodeWordsData = nodeService.getNodeWords();
		return new ResponseEntity<>(nodeWordsData,HttpStatus.OK);
	}

	@DeleteMapping("/words")
	public ResponseEntity<String> deleteWords(){
		if(!nodeService.getNodeStatus()) return new ResponseEntity<>("Node is inactive", HttpStatus.BAD_REQUEST);
		NodeAction nodeAction = nodeService.deleteNodeWords();
		return new ResponseEntity<>(nodeAction.getMessage(),nodeAction.getCode());
	}

	@DeleteMapping("/word/{word}")
	public ResponseEntity<String> deleteWord(@PathVariable String word){
		if(!nodeService.getNodeStatus()) return new ResponseEntity<>("Node is inactive", HttpStatus.BAD_REQUEST);
		NodeAction nodeAction = nodeService.deleteNodeWord(word);
		return new ResponseEntity<>(nodeAction.getMessage(),nodeAction.getCode());
	}

	@PostMapping("/words")
	public ResponseEntity<String> addWords(@RequestBody WordsModel words){
		if(!nodeService.getNodeStatus()) return new ResponseEntity<>("Node is inactive", HttpStatus.BAD_REQUEST);
		NodeAction nodeAction = nodeService.addWords(words.getWords());
		return new ResponseEntity<>(nodeAction.getMessage(),nodeAction.getCode());
	}
}
