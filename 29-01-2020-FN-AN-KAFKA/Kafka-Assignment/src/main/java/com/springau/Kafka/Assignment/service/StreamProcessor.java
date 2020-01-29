package com.springau.Kafka.Assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StreamProcessor { // Process the incoming number and send response accordingly
	private final Logger logger = LoggerFactory.getLogger(StreamProcessor.class);

	private String message;
	private static final String TOPIC = "simple2"; // topic to publish message to

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage() {

		logger.info(String.format("Stream Processor Sending: " + this.message));
		this.kafkaTemplate.send(TOPIC, this.message); // Send message
	}

	// Method to consume stream from the producer
	@KafkaListener(topics = "simple", groupId = "group_id")
	public void consume(String message) {

		int number = Integer.parseInt(message);

		if (number % 2 != 0) { // Check if the number is odd

			int length = String.valueOf(message).length();

			this.message = length + "";

		} else {

			this.message = number + "";

		}

		logger.info("Stream Processor Received: " + String.format(message));

		this.sendMessage();
	}
}