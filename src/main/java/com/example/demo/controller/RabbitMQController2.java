package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.User;
import com.example.demo.Producer.rabbitMQProducer2;

@RestController
@RequestMapping("/rabbitMQ2")
public class RabbitMQController2 {
	
	@Autowired
	private rabbitMQProducer2 rabbitMQProducer2;
	
	@PostMapping("/sendUserBody")
	public ResponseEntity<User> sendUserBody(@RequestBody User user){
		rabbitMQProducer2.sendUserBody(user);
		return ResponseEntity.ok(user);
	}
	
}
