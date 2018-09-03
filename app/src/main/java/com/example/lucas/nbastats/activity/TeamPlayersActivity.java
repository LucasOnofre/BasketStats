package com.example.lucas.nbastats.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.PlayersAdapter;
import com.example.lucas.nbastats.model.Player;
import com.example.lucas.nbastats.request.RequestPlayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamPlayersActivity extends BaseActivity {

    private PlayersAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_players);


        /**
         * Set's the recyclerView
         */
        recyclerView  = findViewById(R.id.recycle_list_team_players);
        layoutManager = new LinearLayoutManager(TeamPlayersActivity.this);
        recyclerView.setLayoutManager(layoutManager);


        /**
         * Receives the information saved in ChooseTeamActivity
         */

        String teamName     = getIntent().getStringExtra("teamName");
        String teamInitial  = getIntent().getStringExtra("teamInitials");

        /**
         * Set's the toolbar that comes from BaseActivity
         */

        setupToolbar(teamName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        /**
         * Make's the request passing the chooses team initials as params
         */

        new RequestPlayer().getPlayersFrom(teamInitial).enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {

                GenerateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {

                Log.i("Error: ",t.toString());
                Toast.makeText(TeamPlayersActivity.this, "Error, please try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Get's the response and send's to the adapter
     */

    private void GenerateDataList(List<Player> playersList){
        adapter      = new PlayersAdapter(this,playersList);
        recyclerView.setAdapter(adapter);
    }



    /**
     * Manage the selected itens in the toolbar
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

