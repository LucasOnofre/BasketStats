package com.example.lucas.nbastats.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.cardPager.CardItem;
import com.example.lucas.nbastats.cardPager.CardPagerAdapter;
import com.example.lucas.nbastats.cardPager.ShadowTransformer;
import com.example.lucas.nbastats.model.Team;

public class ChooseTeamActivity extends AppCompatActivity {

    //Array com todos os times, contendo nome,sigla e logo
    private Team[] teams = new Team[]{
            new Team("Atlanta Hawks"                ,"ATL"   ,  R.drawable.atlanta),
            new Team("Brooklyn Nets"                ,"BKN"   ,  R.drawable.brooklyn),
            new Team("Boston Celtics"               ,"BOS"   ,  R.drawable.boston),
            new Team("Chicago Bulls"                ,"CHB"   ,  R.drawable.chicago),
            new Team("Cleveland Cavaliers"          ,"CLE"   ,  R.drawable.cleveland),
            new Team("Dallas Mavericks"             ,"DAL"   ,  R.drawable.dallas),
            new Team("Detroit Pistons"              ,"DET"   ,  R.drawable.detroit),
            new Team("Golden State Warriors"        ,"GSW"   ,  R.drawable.golden),
            new Team("Houston Rockets"              ,"HOU"   ,  R.drawable.houston),
            new Team("Indiana Pacers"               ,"IND"   ,  R.drawable.indiana),
            new Team("Los Angeles Clippers"         ,"LAC"   ,  R.drawable.clippers),
            new Team("Los Angeles Lakers"           ,"LAL"   ,  R.drawable.lakers),
            new Team("Memphis Grizzlies"            ,"MEM"   ,  R.drawable.memphis),
            new Team("Miami Heat"                   ,"MIA"   ,  R.drawable.miami),
            new Team("Milwaukee Bucks"              ,"MIL"   ,  R.drawable.milwaukee),
            new Team("Minnesota Timberwolves"       ,"MIN"   ,  R.drawable.minnesota),
            new Team("New Orleans Pelicans"         ,"NOP"   ,  R.drawable.pelicans),
            new Team("New York Knicks"              ,"NYK"   ,  R.drawable.knicks),
            new Team("Oklahoma City Thunder"        ,"OKC"   ,  R.drawable.oklahoma),
            new Team("Orlando Magic"                ,"ORL"   ,  R.drawable.orlando),
            new Team("Philadelphia 76ers"           ,"PHI"   ,  R.drawable.philidephia),
            new Team("Phoenix Suns"                 ,"PHX"   ,  R.drawable.phoenix),
            new Team("Portland Trail Blazers"       ,"POR"   ,  R.drawable.portland),
            new Team("Sacramento Kings"             ,"SAC"   ,  R.drawable.sacramento),
            new Team("San Antonio Spurs"            ,"SAS"   ,  R.drawable.san),
            new Team("Toronto Raptors"              ,"TOR"   ,  R.drawable.toronto),
            new Team("Utah Jazz"                    ,"UTA"   ,  R.drawable.uta),
            new Team("Washington Wizards"           ,"WAS"   ,  R.drawable.washington)};


    private ViewPager         viewPager;
    private CardPagerAdapter  cardAdapter;
    private ShadowTransformer cardShadowTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        viewPager   = findViewById(R.id.viewPager);

        cardAdapter = new CardPagerAdapter(onTeamClickListener);


            for (Team team:teams){
                cardAdapter.addCardItem(new CardItem(team));
            }

        cardShadowTransformer = new ShadowTransformer(viewPager, cardAdapter);

        viewPager.setAdapter(cardAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(pageListener);
        viewPager.setPageTransformer(false, cardShadowTransformer);

        ((TextView)findViewById(R.id.team_name)).setText(teams[0].getFullName());
    }

    /**
     * Notifca quando o carrossel muda de pagina
     */
    private ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Team team = teams[position];
            ((TextView)findViewById(R.id.team_name)).setText(team.getFullName());
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * Recebe os cliques dado nos items da lista
     */
    private CardPagerAdapter.OnTeamClickListener onTeamClickListener = new CardPagerAdapter.OnTeamClickListener() {
        @Override
        public void onTeamClick(int teamIndex) {

            String initial  = teams[teamIndex].getInitials();
            String nameTeam = teams[teamIndex].getFullName();

            saveInDeviceValues(initial,nameTeam);

            Intent intent = new Intent(ChooseTeamActivity.this,TeamPlayersActivity.class);

            startActivity(intent);
        }
    };

    private void  saveInDeviceValues(String initial,String nameTeam){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("teamInitials",initial);
        editor.putString("teamName",nameTeam);
        editor.commit();

    }

}

