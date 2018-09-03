package com.example.lucas.nbastats.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.GamesAdapter;
import com.example.lucas.nbastats.model.Game;
import com.example.lucas.nbastats.request.RequestGamesFromTeam;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamesFragment extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView;
    private GamesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    /**
     * Empty constructor
     */

    public GamesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.games_fragment, container, false);

        /**
         * Initialize and set's the recycler view and his layout type
         */
        recyclerView  = container.findViewById(R.id.recycle_games_fragment);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        /**
         * Set's the progress bar
         */
        progressBar = container.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);


        /**
         * Get's the team Initial saved in devide
         */
        SharedPreferences pref  = getContext().getSharedPreferences("MyPref", 0);
        String teamInitials     = pref.getString("teamInitials", null);


        /**
         * Get's the season selected saved in the device
         */
        String yearSelected = pref.getString("seasonSelected",null);


        /**
         * Make's the request passing as params the team initial and the season selected
         */
        new RequestGamesFromTeam().getGamesFrom(teamInitials,yearSelected).enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                progressBar.setVisibility(View.GONE);
                GenerateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.i("Error: ", t.toString());
                Toast.makeText(getContext(), "Error, please try again!", Toast.LENGTH_SHORT).show();
            }
        });
        return container;
    }

    /**
     * Get's the response from the request and send to the adapter
     */

    private void GenerateDataList(List<Game> gameList) {
        adapter = new GamesAdapter(getContext(), gameList);
        recyclerView.setAdapter(adapter);

    }
}