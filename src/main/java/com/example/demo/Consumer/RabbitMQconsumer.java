package com.example.demo.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQconsumer {
	
	
	@RabbitListener(queues = {"${spring.queue.name}"})
	public void recievemessage(String message) {
		log.info("recieved message" + message);
	}

}
