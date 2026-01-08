package com.example.notification.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AlerteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;
    private String message;
    private String niveauGravite;
    private LocalDateTime dateDetection;

    // 🔹 Constructeur par défaut (OBLIGATOIRE pour AMQP / Jackson)
    public AlerteDTO() {
    }

    // 🔹 Constructeur utile (optionnel)
    public AlerteDTO(String type, String message, String niveauGravite, LocalDateTime dateDetection) {
        this.type = type;
        this.message = message;
        this.niveauGravite = niveauGravite;
        this.dateDetection = dateDetection;
    }

    // ===== GETTERS =====

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getNiveauGravite() {
        return niveauGravite;
    }

    public LocalDateTime getDateDetection() {
        return dateDetection;
    }

    // ===== SETTERS =====

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNiveauGravite(String niveauGravite) {
        this.niveauGravite = niveauGravite;
    }

    public void setDateDetection(LocalDateTime dateDetection) {
        this.dateDetection = dateDetection;
    }
}
