package com.example.maintenance.repository;

import com.example.maintenance.entity.TicketMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketMaintenanceRepository
        extends JpaRepository<TicketMaintenance, Long> {
}
