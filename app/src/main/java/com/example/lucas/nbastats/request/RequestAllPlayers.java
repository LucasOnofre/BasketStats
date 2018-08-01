package com.example.lucas.nbastats.request;

import com.example.lucas.nbastats.model.Players;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class RequestAllPlayers{

    private Service service;

    public RequestAllPlayers(){
        service = RetrofitClient.getRetrofitInstance().create(Service.class);
    }

    public Call<List<Players>> getAllPlayers(){
        String endpoint = "/nba/v0/players";

        return  service.getAllPlayers(endpoint);
    }

    private interface Service {

        @GET()
        Call<List<Players>> getAllPlayers(@Url String url);
    }
}
