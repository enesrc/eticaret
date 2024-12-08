package com.ee.eticaret.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ee.eticaret.entities.Product;

@Controller
public class WebSocketController {

    @MessageMapping("/stockUpdate")
    @SendTo("/topic/stockUpdate")
    public Product sendStockUpdate(Product product) {
        return product;
    }
}