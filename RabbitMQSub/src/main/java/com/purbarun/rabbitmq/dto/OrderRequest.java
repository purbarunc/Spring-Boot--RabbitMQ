package com.purbarun.rabbitmq.dto;

public record OrderRequest(String item,int quantity,int value) {
}
