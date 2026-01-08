package com.example.maintenance.controller;

import com.example.maintenance.entity.TicketMaintenance;
import com.example.maintenance.repository.TicketMaintenanceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class TicketMaintenanceController {

    private final TicketMaintenanceRepository repository;

    public TicketMaintenanceController(TicketMaintenanceRepository repository) {
        this.repository = repository;
    }

    // ====================================
    // 1️⃣ CRÉER UN NOUVEAU TICKET
    // ====================================
    @PostMapping("/tickets")
    public TicketMaintenance createTicket(@RequestBody TicketMaintenance ticket) {
        return repository.save(ticket);
    }

    // ====================================
    // 2️⃣ LISTER TOUS LES TICKETS
    // ====================================
    @GetMapping("/tickets")
    public List<TicketMaintenance> getAllTickets() {
        return repository.findAll();
    }

    // ====================================
    // 3️⃣ CONSULTER UN TICKET PAR ID
    // ====================================
    @GetMapping("/tickets/{id}")
    public TicketMaintenance getTicketById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket non trouvé avec id = " + id));
    }

    // ====================================
    // 4️⃣ CHANGER LE STATUT D'UN TICKET
    // ====================================
    @PutMapping("/tickets/{id}/statut")
    public TicketMaintenance changerStatut(
            @PathVariable Long id,
            @RequestParam String statut) {

        TicketMaintenance ticket = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket non trouvé"));

        ticket.setStatut(statut);
        return repository.save(ticket);
    }
}
