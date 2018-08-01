package com.example.lucas.nbastats.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.TeamsAdapter;
import com.example.lucas.nbastats.cardPager.CardItem;
import com.example.lucas.nbastats.cardPager.CardPagerAdapter;
import com.example.lucas.nbastats.cardPager.ShadowTransformer;
import com.example.lucas.nbastats.model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChooseTeamActivity extends AppCompatActivity{

//    private String[] teams = new String[]{
//            "Atlanta Hawks",
//            "Brooklyn Nets","Boston Celtics",
//            "Charlotte Hornets","Chicago Bulls","Cleveland Cavaliers",
//            "Dallas Mavericks","Detroit Pistons","Golden State Warriors","Houston Rockets",
//            "Indiana Pacers","Los Angeles Clippers","Los Angeles Lakers",
//            "Memphis Grizzlies","Miami Heat","Milwaukee Bucks","Minnesota Timberwolves",
//            "New Orleans Pelicans","New York Knicks",
//            "Oklahoma City Thunder","Orlando Magic",
//            "Philadelphia 76ers","Phoenix Suns","Portland Trail Blazers",
//            "Sacramento Kings","San Antonio Spurs",
//            "Toronto Raptors","Utah Jazz","Washington Wizards"};

    private Team[] teams = new Team[]{
            new Team("Atlanta"       ,"ATL",  R.drawable.atlanta),
            new Team("Brooklin Nets" ,"BRK",  R.drawable.brooklyn),
            new Team("Boston Celtics","BOS",  R.drawable.boston),
            new Team("Chicago Bulls" ,"CHB",  R.drawable.chicago)
//
//            R.drawable.atlanta  ,R.drawable.brooklyn    ,R.drawable.boston  ,R.drawable.charlotte   ,R.drawable.chicago,
//            R.drawable.cleveland,R.drawable.dallas      ,R.drawable.detroit ,R.drawable.golden      ,R.drawable.houston,
//            R.drawable.indiana  ,R.drawable.clippers    ,R.drawable.lakers  ,R.drawable.memphis     ,R.drawable.miami,
//            R.drawable.milwaukee,R.drawable.minnesota   ,R.drawable.pelicans,R.drawable.knicks      ,R.drawable.oklahoma,
//            R.drawable.orlando  ,R.drawable.philidephia ,R.drawable.phoenix ,R.drawable.portland    ,R.drawable.sacramento,
//            R.drawable.san      ,R.drawable.toronto     ,R.drawable.uta     ,R.drawable.washington,
    };


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
            String sigla = teams[teamIndex].getTeam();
            System.out.println(sigla);
        }
    };
}

