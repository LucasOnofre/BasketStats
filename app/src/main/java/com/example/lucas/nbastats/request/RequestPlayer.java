package com.example.lucas.nbastats.request;

import com.example.lucas.nbastats.model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public class RequestPlayer{

    private Service service;

    public RequestPlayer(){
        service = RetrofitClient.getRetrofitInstance().create(Service.class);
    }

    public Call<List<Player>> getPlayersFrom(String team){
        String endpoint = "/nba/v0/players/" + team;

        return  service.getPlayersFrom(endpoint);
    }

    private interface Service {

        @GET()
        Call<List<Player>> getPlayersFrom(@Url String url);
    }
}
