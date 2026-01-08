package com.example.maintenance.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TicketMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeAlerte;
    private String message;
    private String niveauGravite;
    private LocalDateTime dateCreation;
    private String statut;

    public TicketMaintenance() {}

    public Long getId() {
        return id;
    }

    public String getTypeAlerte() {
        return typeAlerte;
    }

    public void setTypeAlerte(String typeAlerte) {
        this.typeAlerte = typeAlerte;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNiveauGravite() {
        return niveauGravite;
    }

    public void setNiveauGravite(String niveauGravite) {
        this.niveauGravite = niveauGravite;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
