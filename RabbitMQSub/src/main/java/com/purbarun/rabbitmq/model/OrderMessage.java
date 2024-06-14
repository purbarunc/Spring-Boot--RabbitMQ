package com.purbarun.rabbitmq.model;

public record OrderMessage (OrderRequest orderRequest,String messageId) {
}
