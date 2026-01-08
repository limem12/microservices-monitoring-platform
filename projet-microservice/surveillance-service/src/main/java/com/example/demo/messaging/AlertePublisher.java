package com.example.demo.messaging;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.dto.AlerteDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlertePublisher {

    private final RabbitTemplate rabbitTemplate;

    public AlertePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void envoyerAlerte(AlerteDTO alerteDTO) {
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE,
            RabbitMQConfig.ROUTING_KEY,
            alerteDTO
        );
    }

}
