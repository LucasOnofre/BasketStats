package com.example.lucas.nbastats.model;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("rookieYear")
    private Integer rookieYear;

    @SerializedName("fullName")
    private String fullName;

    @SerializedName("status")
    private String status;

    @SerializedName("team")
    private String team;


    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;


    public Player(Integer rookieYear, String fullName, String status, String team) {
        this.rookieYear = rookieYear;
        this.fullName   = fullName;
        this.status     = status;
        this.team       = team;
    }

    public Integer getRookieYear() {
        return rookieYear;
    }

    public void setRookieYear(Integer rookieYear) {
        this.rookieYear = rookieYear;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
