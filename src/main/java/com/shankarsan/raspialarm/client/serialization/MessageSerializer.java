package com.shankarsan.raspialarm.client.serialization;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shankarsan.raspialarm.common.dto.MessageDTO;

@Component
public class MessageSerializer implements Serializer<MessageDTO> {
	
	private final ObjectMapper mapper = new ObjectMapper();

	public MessageSerializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] serialize(String topic, MessageDTO data) {
		if(null == data) {
			return null;
		}
		try {
			return mapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
