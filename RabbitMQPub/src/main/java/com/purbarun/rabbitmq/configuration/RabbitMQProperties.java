package com.purbarun.rabbitmq.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProperties {
	@Value("${rabbitmq.queue}")
	private String queue = "MyQueue";

	@Value("${rabbitmq.exchange}")
	private String exchange = "MyTopicExchange";

	@Value("${rabbitmq.routingKey}")
	private String routingKey = "topic";
	
	public String getQueue() {
		return queue;
	}

	public String getExchange() {
		return exchange;
	}

	public String getRoutingKey() {
		return routingKey;
	}
}
