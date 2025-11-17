package com.example.clubmanagement.models;

public class Event {
    private int id;
    private String title;
    private String date;
    private String location;
    private String status;
    private boolean isRegistered;

    public Event(int id, String title, String date, String location) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
        this.status = "Upcoming";
        this.isRegistered = false;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isRegistered() { return isRegistered; }
    public void setRegistered(boolean registered) { isRegistered = registered; }
} 