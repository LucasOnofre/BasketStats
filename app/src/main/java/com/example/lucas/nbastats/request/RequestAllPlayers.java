package com.example.lucas.nbastats.request;

import com.example.lucas.nbastats.model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class RequestAllPlayers{

    private Service service;

    public RequestAllPlayers(){
        service = RetrofitClient.getRetrofitInstance().create(Service.class);
    }

    public Call<List<Player>> getAllPlayers(){
        String endpoint = "/nba/v0/players";

        return service.getAllPlayers(endpoint);
    }

    private interface Service {

        @GET()
        Call<List<Player>> getAllPlayers(@Url String url);
    }
}
