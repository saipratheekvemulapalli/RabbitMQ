package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Producer.RabbitMQProducer;


@RestController
@RequestMapping("/rabbitMQ")
public class RabbitMQController {
	
	@Autowired
	private RabbitMQProducer rabbitMQProducer;
	
	@PostMapping("/sendmssg")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		rabbitMQProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent successfully");
	}
	
}
