package com.example.notification.messaging;

import com.example.notification.config.RabbitMQConfig;
import com.example.notification.dto.AlerteDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AlerteListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void recevoir(AlerteDTO alerte) {
        System.out.println("📩 Alerte reçue : " + alerte.getMessage());
    }
}
