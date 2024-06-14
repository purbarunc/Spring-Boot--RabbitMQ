package com.purbarun.rabbitmq.service;

import java.util.UUID;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import com.purbarun.rabbitmq.model.OrderMessage;
import com.purbarun.rabbitmq.model.OrderRequest;

@Service
public class OrderPublisher {
	private AmqpTemplate amqpTemplate;
	private RabbitMQProperties rabbitMQProperties;

	public OrderPublisher(AmqpTemplate amqpTemplate, RabbitMQProperties rabbitMQProperties) {
		this.amqpTemplate = amqpTemplate;
		this.rabbitMQProperties = rabbitMQProperties;
	}

	public String pushOrderToQueue(OrderRequest orderRequest) {
		String msgId = UUID.randomUUID().toString();
		OrderMessage orderMessage = new OrderMessage(orderRequest, msgId);
		amqpTemplate.convertAndSend(rabbitMQProperties.getExchange(), rabbitMQProperties.getRoutingKey(),
				orderMessage);
		return msgId;
	}
}
