package com.eco.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class WaterPollution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long authorId;
    private String location;
    private String date;
    private String description;

    private Double pH;
    private Double density;
    private Double hardness;
    private Double sulfates;
    private Double chlorides;
    private Double copper;
    private Double manganese;
    private Double iron;
    private Double chlorophenol;

    public WaterPollution() {
    }

    public WaterPollution(Long authorId, String location, String date, String description, Double pH, Double density, Double hardness, Double sulfates, Double chlorides, Double copper, Double manganese, Double iron, Double chlorophenol) {
        this.authorId = authorId;
        this.location = location;
        this.date = date;
        this.description = description;
        this.pH = pH;
        this.density = density;
        this.hardness = hardness;
        this.sulfates = sulfates;
        this.chlorides = chlorides;
        this.copper = copper;
        this.manganese = manganese;
        this.iron = iron;
        this.chlorophenol = chlorophenol;
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

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getHardness() {
        return hardness;
    }

    public void setHardness(Double hardness) {
        this.hardness = hardness;
    }

    public Double getSulfates() {
        return sulfates;
    }

    public void setSulfates(Double sulfates) {
        this.sulfates = sulfates;
    }

    public Double getChlorides() {
        return chlorides;
    }

    public void setChlorides(Double chlorides) {
        this.chlorides = chlorides;
    }

    public Double getCopper() {
        return copper;
    }

    public void setCopper(Double copper) {
        this.copper = copper;
    }

    public Double getManganese() {
        return manganese;
    }

    public void setManganese(Double manganese) {
        this.manganese = manganese;
    }

    public Double getIron() {
        return iron;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }

    public Double getChlorophenol() {
        return chlorophenol;
    }

    public void setChlorophenol(Double chlorophenol) {
        this.chlorophenol = chlorophenol;
    }
}