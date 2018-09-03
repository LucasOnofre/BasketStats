package com.example.lucas.nbastats.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.PlayersAdapter;
import com.example.lucas.nbastats.model.Player;
import com.example.lucas.nbastats.request.RequestPlayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private PlayersAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * Empty constructor
     */

    public PlayersFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.players_fragment, container, false);

        /**
         * Initialize and set's the recycler view and his layout type
         */

        recyclerView    = container.findViewById(R.id.recycle_players_fragment);
        layoutManager   = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        /**
         * Get's the team initials saved in the device
         */

        SharedPreferences pref  = getContext().getSharedPreferences("MyPref", 0);
        String teamInitials     = pref.getString("teamInitials", null);


        /**
         * Make's the request with the team initials as params
         */

        new RequestPlayer().getPlayersFrom(teamInitials).enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {

                GenerateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {

                Log.i("Error: ",t.toString());
                Toast.makeText(getContext(), "Error, please try again!", Toast.LENGTH_SHORT).show();
            }
        });
        return container;
    }
    /**
     * Get's the response and send to the adapter
     */

    private void GenerateDataList(List<Player> playersList){
        adapter      = new PlayersAdapter(getContext(),playersList);
        recyclerView.setAdapter(adapter);

    }

}
