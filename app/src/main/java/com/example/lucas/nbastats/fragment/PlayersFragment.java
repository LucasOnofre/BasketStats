package com.example.lucas.nbastats.fragment;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.activity.TeamPlayersActivity;
import com.example.lucas.nbastats.adapter.PlayersAdapter;
import com.example.lucas.nbastats.model.Player;
import com.example.lucas.nbastats.request.RequestPlayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayersFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlayersAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressDialog progressDialog;

    public PlayersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container = (ViewGroup) inflater.inflate(R.layout.players_fragment, container, false);

        recyclerView = container.findViewById(R.id.recycle_players_fragment);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //Progress dialog que aparece antes da chamada e some após a mesma ser realizada
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();



        //Retorna os dados salvos dos times ao serem escolhidos
        SharedPreferences pref  = getContext().getSharedPreferences("MyPref", 0);
        String teamInitials     = pref.getString("teamInitials", null);



        //Faz o request passando como parametro a sigla do time, que vem da ChooseTeamActivity
        new RequestPlayer().getPlayersFrom(teamInitials).enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                progressDialog.dismiss();
                GenerateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {

                progressDialog.dismiss();
                Log.i("Error: ",t.toString());
                Toast.makeText(getContext(), "Error, please try again!", Toast.LENGTH_SHORT).show();
            }
        });
        return container;
    }

    // Pega a resposta do request e manda para o adapter
    private void GenerateDataList(List<Player> playersList){
        adapter      = new PlayersAdapter(getContext(),playersList);
        recyclerView.setAdapter(adapter);

    }

}
