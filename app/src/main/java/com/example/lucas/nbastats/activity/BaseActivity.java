package com.example.lucas.nbastats.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.model.Team;

public class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Set the toolbar, if exists
     */
    protected void setupToolbar(String title) {
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(title);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

        /**
         * Array with every team in NBA, as their initials and logo
         */
    protected Team[] getTeamInfo() {

        Team[] teams = new Team[]{
                new Team("Atlanta Hawks"            , "ATL" , R.drawable.atlanta),
                new Team("Brooklyn Nets"            , "BKN" , R.drawable.brooklyn),
                new Team("Boston Celtics"           , "BOS" , R.drawable.boston),
                new Team("Charlotte Hornets"        , "CHA" , R.drawable.charlotte),
                new Team("Chicago Bulls"            , "CHI" , R.drawable.chicago),
                new Team("Cleveland Cavaliers"      , "CLE" , R.drawable.cleveland),
                new Team("Dallas Mavericks"         , "DAL" , R.drawable.dallas),
                new Team("Detroit Pistons"          , "DET" , R.drawable.detroit),
                new Team("Denver Nugguets"          , "DEN" , R.drawable.ic_denver),
                new Team("Golden State Warriors"    , "GSW" , R.drawable.golden),
                new Team("Houston Rockets"          , "HOU" , R.drawable.houston),
                new Team("Indiana Pacers"           , "IND" , R.drawable.indiana),
                new Team("Los Angeles Clippers"     , "LAC" , R.drawable.clippers),
                new Team("Los Angeles Lakers"       , "LAL" , R.drawable.lakers),
                new Team("Memphis Grizzlies"        , "MEM" , R.drawable.memphis),
                new Team("Miami Heat"               , "MIA" , R.drawable.miami),
                new Team("Milwaukee Bucks"          , "MIL" , R.drawable.milwaukee),
                new Team("Minnesota Timberwolves"   , "MIN" , R.drawable.minnesota),
                new Team("New Orleans Pelicans"     , "NOP" , R.drawable.pelicans),
                new Team("New York Knicks"          , "NYK" , R.drawable.knicks),
                new Team("Oklahoma City Thunder"    , "OKC" , R.drawable.oklahoma),
                new Team("Orlando Magic"            , "ORL" , R.drawable.orlando),
                new Team("Philadelphia 76ers"       , "PHI" , R.drawable.philidephia),
                new Team("Phoenix Suns"             , "PHX" , R.drawable.phoenix),
                new Team("Portland Trail Blazers"   , "POR" , R.drawable.portland),
                new Team("Sacramento Kings"         , "SAC" , R.drawable.sacramento),
                new Team("San Antonio Spurs"        , "SAS" , R.drawable.san),
                new Team("Toronto Raptors"          , "TOR" , R.drawable.toronto),
                new Team("Utah Jazz"                , "UTA" , R.drawable.uta),
                new Team("Washington Wizards"       , "WAS" , R.drawable.washington)
        };
        return teams;
    }
}


