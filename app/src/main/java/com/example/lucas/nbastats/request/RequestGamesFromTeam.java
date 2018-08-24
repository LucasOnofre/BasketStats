package com.example.lucas.nbastats.request;

import com.example.lucas.nbastats.model.Game;
import com.example.lucas.nbastats.model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class RequestGamesFromTeam{

    private Service service;

    public RequestGamesFromTeam(){
        service = RetrofitClient.getRetrofitInstance().create(Service.class);
    }

    public Call<List<Game>> getGamesFrom(String team, String year){
    String endpoint = "/nba/v0/games/" + team + "/" + year ;

        return service.getGameFrom(endpoint);
    }

    private interface Service {

        @GET()
        Call<List<Game>> getGameFrom(@Url String url);

    }
}