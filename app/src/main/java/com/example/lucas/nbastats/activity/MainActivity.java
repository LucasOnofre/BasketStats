package com.example.lucas.nbastats.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.PlayersAdapter;
import com.example.lucas.nbastats.model.Player;
import com.example.lucas.nbastats.request.RequestAllPlayers;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private PlayersAdapter adapter;
    private RecyclerView  recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_list);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        final ProgressDialog progressDialog = generateProgressDialog(MainActivity.this);

        new RequestAllPlayers().getAllPlayers().enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                progressDialog.dismiss();
                GenerateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {

                progressDialog.dismiss();
                Log.i("Error: ",t.toString());
                Toast.makeText(MainActivity.this, "Tente novamente...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void GenerateDataList(List<Player> playersList){
        adapter      = new PlayersAdapter(this,playersList);
        recyclerView.setAdapter(adapter);
    }
}
