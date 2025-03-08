package com.example.demo.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.exchange.name}")
	private String exchange;
	
	@Value("${spring.routingkey.name}")
	private String rountingkey;
	
	
	public void sendMessage(String message){
		log.info("message sent -> " + message);
		rabbitTemplate.convertAndSend(exchange, rountingkey, message);
	}
	
}
