package com.example.lucas.nbastats.model;

import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("gameId")
    private int gameId;

    @SerializedName("seasonPhase")
    private String seasonPhase;

    @SerializedName("homeTeam")
    private HomeTeam homeTeam;

    @SerializedName("awayTeam")
    private AwayTeam awayTeam;

    public Game(int gameId, String seasonPhase, HomeTeam homeTeam, AwayTeam awayTeam) {
        this.gameId      = gameId;
        this.homeTeam    = homeTeam;
        this.awayTeam    = awayTeam;
        this.seasonPhase = seasonPhase;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getSeasonPhase() {
        return seasonPhase;
    }

    public void setSeasonPhase(String seasonPhase) {
        this.seasonPhase = seasonPhase;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public class HomeTeam {
        @SerializedName("teamID")
        private String teamId;

        @SerializedName("finalScore")
        private int finalScore;

        public HomeTeam(String teamId, int finalScore) {
            this.teamId = teamId;
            this.finalScore = finalScore;
        }

        public String getTeamId() {
            return teamId;
        }

        public void setTeamId(String teamId) {
            this.teamId = teamId;
        }

        public int getFinalScore() {
            return finalScore;
        }

        public void setFinalScore(int finalScore) {
            this.finalScore = finalScore;
        }
    }


    public class AwayTeam {
        @SerializedName("teamID")
        private String teamId;

        @SerializedName("finalScore")
        private int finalScore;

        public AwayTeam(String teamId, int finalScore) {
            this.teamId = teamId;
            this.finalScore = finalScore;
        }

        public String getTeamId() {
            return teamId;
        }

        public void setTeamId(String teamId) {
            this.teamId = teamId;
        }

        public int getFinalScore() {
            return finalScore;
        }

        public void setFinalScore(int finalScore) {
            this.finalScore = finalScore;
        }
    }
}
