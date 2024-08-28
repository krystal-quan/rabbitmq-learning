package com.krystalquan.rabbitmq.controller;

import com.krystalquan.rabbitmq.dto.UserDTO;
import com.krystalquan.rabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageJsonController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/sendJson")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDTO user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("JSON message sent successfully");
    }

}
