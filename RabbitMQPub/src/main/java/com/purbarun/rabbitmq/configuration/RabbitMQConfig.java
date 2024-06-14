package com.purbarun.rabbitmq.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.purbarun.rabbitmq.service.RabbitMQProperties;

@Configuration
public class RabbitMQConfig {
	private RabbitMQProperties rabbitMQProperties;

	public RabbitMQConfig(RabbitMQProperties rabbitMQProperties) {
		this.rabbitMQProperties = rabbitMQProperties;
	}

	@Bean
	Exchange myExchange() {
		return ExchangeBuilder.topicExchange(rabbitMQProperties.getExchange()).durable(true).build();
	}

	@Bean
	MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	@Primary
	AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}

}
