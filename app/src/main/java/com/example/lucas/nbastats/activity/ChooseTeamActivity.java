package com.example.lucas.nbastats.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.TeamsAdapter;

import java.util.ArrayList;

public class ChooseTeamActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TeamsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<String> teamList = new ArrayList<>();

    private String[] teams = new String[]{
            "Atlanta Hawks",
            "Brooklyn Nets","Boston Celtics",
            "Charlotte Hornets","Chicago Bulls","Cleveland Cavaliers",
            "Dallas Mavericks","Denver Broncos","Detroit Pistons","Golden State Warriors","Houston Rockets",
            "Indiana Pacers","Los Angeles Clippers","Los Angeles Lakers",
            "Memphis Grizzlies","Miami Heat","Milwaukee Bucks", "Minnesota Timberwolves",
            "New Orleans Pelicans","New York Knicks",
            "Oklahoma City Thunder","Orlando Magic",
            "Philadelphia 76ers","Phoenix Suns","Portland Trail Blazers",
            "Sacramento Kings","San Antonio Spurs",
            "Toronto Raptors","Utah Jazz","Washington Wizards"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        recyclerView = findViewById(R.id.recycle_list_teams);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        for (String item:teams) {
            teamList.add(item);
        }

        adapter = new TeamsAdapter(this,teamList);
        recyclerView.setAdapter(adapter);







    }
}
