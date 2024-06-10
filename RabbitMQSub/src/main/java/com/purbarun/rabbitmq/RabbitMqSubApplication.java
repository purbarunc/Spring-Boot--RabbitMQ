package com.purbarun.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqSubApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RabbitMqSubApplication.class, args);
		Thread.currentThread().join();
	}
}
