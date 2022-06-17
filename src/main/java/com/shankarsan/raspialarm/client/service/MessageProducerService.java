package com.shankarsan.raspialarm.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.shankarsan.raspialarm.common.dto.MessageDTO;

@Service
public class MessageProducerService {

	@Autowired private KafkaTemplate<String, MessageDTO> kafkaTemplate;
	
	public void produceMessage(String topic, MessageDTO messageDTO) {
		kafkaTemplate.send(topic, messageDTO).addCallback((result) -> {
			System.out.println("Success. Result: " + result);
		}, (th) -> {
			System.out.println("Failure");
		});
		System.out.println("Returning");
	}
}
