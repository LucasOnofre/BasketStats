package com.example.lucas.nbastats.request;

import com.example.lucas.nbastats.model.Players;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataPlayers {

    @GET("/nba/v0/players")
    Call<List<Players>> getAllPlayers();
}
