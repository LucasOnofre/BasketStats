package com.example.lucas.nbastats.cardPager;

import com.example.lucas.nbastats.model.Team;

public class CardItem {

    private Team team;


    public CardItem(Team team) {
        this.team  = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
