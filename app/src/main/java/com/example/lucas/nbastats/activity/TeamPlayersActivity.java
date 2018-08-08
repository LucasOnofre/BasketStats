package com.example.lucas.nbastats.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

public class TeamPlayersActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private PlayersAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_players);

        recyclerView = findViewById(R.id.recycle_list_team_players);

        //Configura o recycleView
        layoutManager = new LinearLayoutManager(TeamPlayersActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        String teamName     = getIntent().getStringExtra("teamName");
        String teamInitial  = getIntent().getStringExtra("teamInitials");

        //Configurando a toolbar
        toolbar = findViewById(R.id.toolbar_team_players);
        toolbar.setTitle(teamName);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //Progress dialog que aparece antes da chamada e some após a mesma ser realizada
        progressDialog = new ProgressDialog(TeamPlayersActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        //Faz o request passando como parametro a sigla do time, que vem da ChooseTeamActivity
        new RequestPlayer().getPlayersFrom(teamInitial).enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                progressDialog.dismiss();
                GenerateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {

                progressDialog.dismiss();
                Log.i("Error: ",t.toString());
                Toast.makeText(TeamPlayersActivity.this, "Error, please try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Pega a resposta do request e manda para o adapter
    private void GenerateDataList(List<Player> playersList){
        adapter      = new PlayersAdapter(this,playersList);
        recyclerView.setAdapter(adapter);
    }


    //Método que cuida dos itens selecionados no menu/toolbar
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

