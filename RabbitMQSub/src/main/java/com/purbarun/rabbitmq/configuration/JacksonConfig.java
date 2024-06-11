package com.purbarun.rabbitmq.configuration;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
	@Bean
	MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
