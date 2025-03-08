package com.example.demo.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class rabbitMQProducer2 {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${spring.exchange.name}")
	private String exchange;

	
	@Value("${spring.rountingkey2.name}")
	private String rountingkey2;
	
	
	public void sendUserBody(User user) {
		log.info("User body sent -> "+user);
		rabbitTemplate.convertAndSend(exchange,rountingkey2,user);
	}
	
}
