package com.purbarun.rabbitmq.model;

public record OrderRequest(String item,int quantity,int value) {
}
