package com.example.lucas.nbastats.model;

import com.google.gson.annotations.SerializedName;

public class Players {

    @SerializedName("rookieYear")
    private Integer rookieYear;

    @SerializedName("fullName")
    private String fullName;

    @SerializedName("birthDate")
    private String birthDate;

    @SerializedName("status")
    private String status;

    @SerializedName("team")
    private String team;


    public Players(Integer rookieYear, String fullName, String birthDate, String status, String team) {
        this.rookieYear = rookieYear;
        this.fullName   = fullName;
        this.birthDate  = birthDate;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
}
