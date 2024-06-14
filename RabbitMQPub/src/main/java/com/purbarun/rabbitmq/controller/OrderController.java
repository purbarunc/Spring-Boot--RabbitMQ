package com.purbarun.rabbitmq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purbarun.rabbitmq.model.OrderRequest;
import com.purbarun.rabbitmq.service.OrderPublisher;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderController {
	private OrderPublisher orderPublisher;

	public OrderController(OrderPublisher orderPublisher) {
		this.orderPublisher = orderPublisher;
	}

	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		log.info("Order Request Received => {}", orderRequest);
		String msgId = orderPublisher.pushOrderToQueue(orderRequest);
		String responseMeassge = "Order Received with Message Id:" + msgId;
		return new ResponseEntity<>(responseMeassge, HttpStatus.OK);
	}
}
