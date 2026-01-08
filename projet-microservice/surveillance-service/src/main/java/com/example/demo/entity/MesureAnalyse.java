package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MesureAnalyse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceId;

    private Double valeur;

    private String indicateur;

    private LocalDateTime date;

    // ✅ CONSTRUCTEUR PAR DÉFAUT (OBLIGATOIRE)
    public MesureAnalyse() {
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public String getIndicateur() {
        return indicateur;
    }

    public void setIndicateur(String indicateur) {
        this.indicateur = indicateur;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
