package com.springau.Kafka.Assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer { // Final end consumer to print the number of digits in the odd number 
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "simple2", groupId = "group_id")
	public void consume(String message) {

		logger.info(String.format("Consumer: " + message)); // Print the Received message

	}
}