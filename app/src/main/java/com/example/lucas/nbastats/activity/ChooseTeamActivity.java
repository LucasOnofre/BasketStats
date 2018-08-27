package com.example.lucas.nbastats.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.cardPager.CardItem;
import com.example.lucas.nbastats.cardPager.CardPagerAdapter;
import com.example.lucas.nbastats.cardPager.ShadowTransformer;
import com.example.lucas.nbastats.model.Team;

public class ChooseTeamActivity extends BaseActivity {


    private Team []           teams;

    private ViewPager         viewPager;
    private CardPagerAdapter  cardAdapter;
    private ShadowTransformer cardShadowTransformer;

    private String[]          seasons = new String[]{"2015","2016","2017"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        teams = getTeamInfo();

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

            generateAlertDialog();


        }
    };

    /**
     * Intent que abre a activity TeamInfo
     */

    private void openTeamInfo() {

            Intent intent = new Intent(ChooseTeamActivity.this,TeamInfoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.transition_from_activity, 0);
    }

    /**
     * Salva no device o nome e inicial do time selecionado
     */

    private void  saveInDeviceValues(String initial,String nameTeam){

        SharedPreferences pref          = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("teamInitials",initial);
        editor.putString("teamName",nameTeam);
        editor.commit();

    }

    /**
     * Gera o alertDialog com as temporadas para a chamada
     */

    private void generateAlertDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose the season");

        builder.setItems(seasons, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {

                String yearSelected = seasons[position].toString();

                saveSeasonChoosed(yearSelected);

                openTeamInfo();
            }
        });
        builder.show();
    }

    /**
     * Salva a temporada selecionada no alertDialog
     */

    private void saveSeasonChoosed(String yearSelected) {

        SharedPreferences pref          = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("seasonSelected",yearSelected);
        editor.commit();
    }


}