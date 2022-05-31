package com.eco.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SoilPollution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long authorId;
    private String location;
    private String date;
    private String description;

    private Double pH;
    private Double acidity;
    private Double minerals;
    private Double humidity;

    public SoilPollution() {
    }

    public SoilPollution(Long authorId, String location, String date, String description, Double pH, Double acidity, Double minerals, Double humidity) {
        this.authorId = authorId;
        this.location = location;
        this.date = date;
        this.description = description;
        this.pH = pH;
        this.acidity = acidity;
        this.minerals = minerals;
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getpH() {
        return pH;
    }

    public void setpH(Double pH) {
        this.pH = pH;
    }

    public Double getAcidity() {
        return acidity;
    }

    public void setAcidity(Double acidity) {
        this.acidity = acidity;
    }

    public Double getMinerals() {
        return minerals;
    }

    public void setMinerals(Double minerals) {
        this.minerals = minerals;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}