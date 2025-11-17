package com.example.clubmanagement.models;

public class Club {
    private int id;
    private String name;
    private String description;
    private String slogan;
    private String logoUrl;
    private boolean isMember;

    public Club(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.slogan = "Join us today!";
        this.logoUrl = "https://via.placeholder.com/150";
        this.isMember = false;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSlogan() { return slogan; }
    public void setSlogan(String slogan) { this.slogan = slogan; }

    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }

    public boolean isMember() { return isMember; }
    public void setMember(boolean member) { isMember = member; }
} 