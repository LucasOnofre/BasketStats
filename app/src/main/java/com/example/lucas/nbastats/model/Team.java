package com.example.lucas.nbastats.model;

public class Team {

    private int    logo;
    private String initials;
    private String fullName;

    public Team(String fullName, String initials, int logo) {
        this.logo = logo;
        this.initials = initials;
        this.fullName = fullName;
    }

    public Team(String initials, int logo) {
        this.logo = logo;
        this.initials = initials;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
