package com.example.maintenance.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AlerteDTO implements Serializable {

    private String type;
    private String message;
    private String niveauGravite;
    private LocalDateTime dateDetection;

    public AlerteDTO() {}

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
