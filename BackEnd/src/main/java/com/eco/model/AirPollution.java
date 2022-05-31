package com.eco.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AirPollution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long authorId;
    private String location;
    private String date;
    private Double pm1;
    private Double pm2_5;
    private Double pm10;
    private Double temperature;
    private Double humidity; //вологість
    private Double pressure; //тиск

    private String description;

    public AirPollution() {
    }

    public AirPollution(Long authorId, String location, String date, Double pm1, Double pm2_5, Double pm10, Double temperature, Double humidity, Double pressure, String description) {
        this.authorId = authorId;
        this.location = location;
        this.date = date;
        this.pm1 = pm1;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.description = description;
    }

    public Double getPm1() {
        return pm1;
    }

    public void setPm1(Double pm1) {
        this.pm1 = pm1;
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

    public Double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(Double pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
