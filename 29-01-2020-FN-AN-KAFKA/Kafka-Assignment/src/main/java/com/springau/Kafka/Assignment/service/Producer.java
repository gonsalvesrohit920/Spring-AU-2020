package com.springau.Kafka.Assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Producer { // Produces the random number at the interval of 2 seconds

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "simple";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate; // template to send message

	Random random = new Random();

	public void sendMessage() {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				String message = random.nextInt(3000) + "";	// choose a random number to send
				kafkaTemplate.send(TOPIC, message); 		// send the message
				logger.info(String.format("Producer: %s", message));

			}
		}, 0, 2000);

	}
}
