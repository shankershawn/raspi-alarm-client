package com.shankarsan.raspialarm.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shankarsan.raspialarm.client.service.MessageProducerService;
import com.shankarsan.raspialarm.common.dto.MessageDTO;

@RestController
public class MessageProducerController {
	
	@Autowired private MessageProducerService messageProducerService;

	@PostMapping(value = "/v1/message/{topic}")
	public ResponseEntity<String> postMessage(@PathVariable(name = "topic") String topic, @RequestBody MessageDTO messageDTO){
		messageProducerService.produceMessage(topic, messageDTO);
		System.out.println("After call");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Posted", HttpStatus.OK);
		return responseEntity;
	}
}
