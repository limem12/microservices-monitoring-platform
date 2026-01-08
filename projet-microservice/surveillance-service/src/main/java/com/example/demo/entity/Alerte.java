package com.example.demo.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerte")
public class Alerte implements Serializable {

    private static final long serialVersionUID = 1L;

    // ✅ Clé primaire obligatoire
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Champs utilisés par SurveillanceService
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String message;

    @Column(name = "niveau_gravite", nullable = false)
    private String niveauGravite;

    @Column(name = "date_detection", nullable = false)
    private LocalDateTime dateDetection;

    // ✅ Constructeur par défaut (OBLIGATOIRE JPA)
    public Alerte() {
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public LocalDateTime getDateDetection() {
        return dateDetection;
    }

    public void setDateDetection(LocalDateTime dateDetection) {
        this.dateDetection = dateDetection;
    }
}
