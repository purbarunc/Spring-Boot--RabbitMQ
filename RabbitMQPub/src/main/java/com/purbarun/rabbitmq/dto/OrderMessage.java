package com.purbarun.rabbitmq.dto;

public record OrderMessage (OrderRequest orderRequest,String messageId) {
}
