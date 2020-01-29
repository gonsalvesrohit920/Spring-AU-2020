package com.springau.Kafka.Assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springau.Kafka.Assignment.service.Producer;



@RestController 										// Controller to start the producer
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {

		this.producer = producer;

	}

	@RequestMapping(value = "/publish")
	public void sendMessageToKafkaTopic() {

		this.producer.sendMessage();

	}
}
