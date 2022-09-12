package com.purbarun.rabbitmq.service;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purbarun.rabbitmq.configuration.RabbitMQConfig;
import com.purbarun.rabbitmq.dto.OrderMessage;
import com.purbarun.rabbitmq.dto.OrderRequest;

@Service
public class OrderPublisher {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public String pushOrderToQueue(OrderRequest orderRequest) {
		String msgId = UUID.randomUUID().toString();
		OrderMessage orderMessage = new OrderMessage(orderRequest, msgId);
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderMessage);
		return msgId;
	}
}
