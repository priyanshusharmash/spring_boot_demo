package com.example.demo;

public record Order(
        String orderId,
        String  orderName,
        int quantity
){}
