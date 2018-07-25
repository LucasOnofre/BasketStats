package com.example.lucas.nbastats.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.PlayersAdapter;
import com.example.lucas.nbastats.model.Players;
import com.example.lucas.nbastats.request.GetDataPlayers;
import com.example.lucas.nbastats.request.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private PlayersAdapter adapter;
    private RecyclerView  recyclerView;
    private ProgressDialog progressDialog;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_list);

        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        GetDataPlayers service = RetrofitClient.getRetrofitInstance().create(GetDataPlayers.class);
        Call<List<Players>> call = service.getAllPlayers();

        call.enqueue(new Callback<List<Players>>() {
            @Override
            public void onResponse(Call<List<Players>> call, Response<List<Players>> response) {
                progressDialog.dismiss();
                GenerateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<Players>> call, Throwable t) {

                progressDialog.dismiss();
                Log.i("Error: ",t.toString());
                Toast.makeText(MainActivity.this, "Error, please try again!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void GenerateDataList(List<Players> playersList){
        adapter      = new PlayersAdapter(this,playersList);
        recyclerView.setAdapter(adapter);
    }
}
