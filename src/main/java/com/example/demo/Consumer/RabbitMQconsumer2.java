package com.example.demo.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQconsumer2 {
	
	
	@RabbitListener(queues = {"${spring.queue2.name}"})
	public void recieveUserBody(User user) {
		log.info("User Body sent ->" + user);
	}
	
}
