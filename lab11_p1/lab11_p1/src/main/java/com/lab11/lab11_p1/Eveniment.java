package com.lab11.lab11_p1;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "evenimente")
public class Eveniment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denumire;
    private String locatie;
    private LocalDate data;
    private LocalTime timp;
    private float pret;

    public Eveniment() {}

    public Eveniment(String denumire, String locatie, LocalDate data, LocalTime timp, float pret) {
        this.denumire = denumire;
        this.locatie = locatie;
        this.data = data;
        this.timp = timp;
        this.pret = pret;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getTimp() {
        return timp;
    }

    public void setTimp(LocalTime timp) {
        this.timp = timp;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }
}
