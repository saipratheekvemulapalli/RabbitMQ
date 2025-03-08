package com.example.demo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.queue.name}")
	private String queue;
	
	@Value("${spring.exchange.name}")
	private String exchange;
	
	@Value("${spring.routingkey.name}")
	private String rountingkey;
	
	
	@Value("${spring.queue2.name")
	private String queue2;
	
	@Value("${spring.rountingkey2.name")
	private String rountingkey2;
	
	
	
	
	
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}
	
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(rountingkey);
	}
	
	//////////////////////////////////////////////////////////////////////
	
	@Bean
	public Queue queue2() {
		return new Queue(queue2);
	}
	
	@Bean
	public Binding binding2() {
		return BindingBuilder.bind(queue2()).to(exchange()).with(rountingkey2);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}
	

}
