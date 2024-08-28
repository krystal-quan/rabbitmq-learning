package com.krystalquan.rabbitmq.consumer;

import com.krystalquan.rabbitmq.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.other_name}"})
    public void consumeMessage(UserDTO user) {
        logger.info("User received: " + user);
    }
}
