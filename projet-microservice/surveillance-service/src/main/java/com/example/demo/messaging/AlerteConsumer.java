package com.example.demo.messaging;

import com.example.demo.entity.Alerte;
import com.example.demo.repository.AlerteRepository;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class AlerteConsumer {
	@Autowired
	private AlerteRepository alerteRepository;

    @RabbitListener(queues = "alerte.queue")
    public void recevoirAlerte(Alerte alerte) {
    	 alerteRepository.save(alerte);
        System.out.println("📩 Alerte reçue via AMQP :");
        System.out.println("Type : " + alerte.getType());
        System.out.println("Message : " + alerte.getMessage());
        System.out.println("Gravité : " + alerte.getNiveauGravite());
        System.out.println("Date : " + alerte.getDateDetection());
    }
}
