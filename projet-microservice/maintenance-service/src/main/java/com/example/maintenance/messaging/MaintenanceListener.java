package com.example.maintenance.messaging;

import com.example.maintenance.dto.AlerteDTO;
import com.example.maintenance.entity.TicketMaintenance;
import com.example.maintenance.repository.TicketMaintenanceRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MaintenanceListener {

    private final TicketMaintenanceRepository repository;

    public MaintenanceListener(TicketMaintenanceRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "alerte.queue")
    public void recevoirAlerte(AlerteDTO dto) {

        TicketMaintenance ticket = new TicketMaintenance();
        ticket.setTypeAlerte(dto.getType());
        ticket.setMessage(dto.getMessage());
        ticket.setNiveauGravite(dto.getNiveauGravite());
        ticket.setDateCreation(LocalDateTime.now());
        ticket.setStatut("OUVERT");

        repository.save(ticket);

        System.out.println("🛠️ Ticket créé : " + ticket.getId());
    }
}
