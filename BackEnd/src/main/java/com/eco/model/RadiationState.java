package com.eco.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RadiationState implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long authorId;
    private String location;
    private Double radiationLevel;
    private String date;
    private String description;

    public RadiationState() {
    }

    public RadiationState(Long authorId, String location, Double radiationLevel, String date, String description) {
        this.authorId = authorId;
        this.location = location;
        this.radiationLevel = radiationLevel;
        this.date = date;
        this.description = description;
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

    public Double getRadiationLevel() {
        return radiationLevel;
    }

    public void setRadiationLevel(Double radiationLevel) {
        this.radiationLevel = radiationLevel;
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
}
