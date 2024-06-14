package com.purbarun.rabbitmq.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProperties {
	@Value("${rabbitmq.exchange}")
	private String exchange = "MyTopicExchange";

	@Value("${rabbitmq.routingKey}")
	private String routingKey = "topic";
	
	public String getExchange() {
		return exchange;
	}

	public String getRoutingKey() {
		return routingKey;
	}
}
