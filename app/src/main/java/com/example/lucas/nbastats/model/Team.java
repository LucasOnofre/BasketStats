package com.example.lucas.nbastats.model;

public class Team {

    private int    logo;
    private String team;
    private String fullName;

    public Team(String fullName, String team, int logo) {
        this.logo = logo;
        this.team = team;
        this.fullName = fullName;
    }

    public Team(String team, int logo) {
        this.logo = logo;
        this.team = team;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
