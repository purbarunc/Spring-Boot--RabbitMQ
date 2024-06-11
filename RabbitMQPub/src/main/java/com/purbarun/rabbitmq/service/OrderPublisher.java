package com.purbarun.rabbitmq.service;

import java.util.UUID;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import com.purbarun.rabbitmq.configuration.RabbitMQProperties;
import com.purbarun.rabbitmq.dto.OrderMessage;
import com.purbarun.rabbitmq.dto.OrderRequest;

@Service
public class OrderPublisher {
	private RabbitTemplate rabbitTemplate;
	private RabbitMQProperties rabbitMQProperties;

	public OrderPublisher(RabbitTemplate rabbitTemplate, RabbitMQProperties rabbitMQProperties) {
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitMQProperties = rabbitMQProperties;
	}

	public String pushOrderToQueue(OrderRequest orderRequest) {
		String msgId = UUID.randomUUID().toString();
		OrderMessage orderMessage = new OrderMessage(orderRequest, msgId);
		rabbitTemplate.convertAndSend(rabbitMQProperties.getExchange(), rabbitMQProperties.getRoutingKey(),
				orderMessage);
		return msgId;
	}
}
