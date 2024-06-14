package com.purbarun.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.purbarun.rabbitmq.configuration.ConnectionConfig;
import com.purbarun.rabbitmq.model.OrderMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderSubscriber {
	@RabbitListener(queues = ConnectionConfig.MYQUEUE)
	public void onMessage(OrderMessage orderMessage) throws MessagingException {
		log.info("Order Received from RabbitMQ => {}", orderMessage);
	}
}
