package com.deipayandash.kentaurus.DistributedDatabaseSlave.controller;

import com.deipayandash.kentaurus.DistributedDatabaseSlave.model.NodeModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SlaveController {

	@GetMapping("/")
	public ResponseEntity<NodeModel> getUsers(){
		NodeModel nodeModel = new NodeModel(1,"abc123");
		nodeModel.setActive(true);
		nodeModel.setWords(new ArrayList<>());
		return new ResponseEntity<>(nodeModel, HttpStatus.OK);
	}
}
