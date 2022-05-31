package com.eco.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserComplaint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String fullName;
    private String contact;
    private String videoUrl;
    private String type;
    private String date;
    private String description;
    private String location;
    private String status="inactive";

    public UserComplaint() {
    }

    public UserComplaint(String fullName, String contact, String videoUrl, String type, String date, String description, String location, String status) {
        this.fullName = fullName;
        this.contact = contact;
        this.videoUrl = videoUrl;
        this.type = type;
        this.date = date;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
