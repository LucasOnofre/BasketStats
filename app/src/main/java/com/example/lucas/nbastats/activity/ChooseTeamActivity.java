package com.example.lucas.nbastats.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.adapter.FilterAdapter;
import com.example.lucas.nbastats.cardPager.CardItem;
import com.example.lucas.nbastats.cardPager.CardPagerAdapter;
import com.example.lucas.nbastats.cardPager.ShadowTransformer;
import com.example.lucas.nbastats.model.Team;
import java.util.Arrays;

public class ChooseTeamActivity extends BaseActivity {


    private Team []           teams;
    private ViewPager         viewPager;
    private CardPagerAdapter  cardAdapter;
    private ShadowTransformer cardShadowTransformer;

    private RecyclerView      filterList;

    private String[]          seasons = new String[]{"2015","2016","2017"};

    private TextView          index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        teams       = getTeamInfo();
        viewPager   = findViewById(R.id.viewPager);
        cardAdapter = new CardPagerAdapter(onTeamClickListener);

    /**
     *  Create the CardView and sets the team name
     */
            for (Team team:teams){
                cardAdapter.addCardItem(new CardItem(team));
            }
        changeTitle(teams[0]);

        /**
         *  Create and modify the viewPager
         */
        setViewPager();
        
        /**
         *  Set's the Array for the index Scroll
         */

        filterList =  findViewById(R.id.list_index);
        final String[] index = getResources().getStringArray(R.array.fruits_array);
        Arrays.asList(index);


        /**
         * Set's the Recycler view and his layout type
         */

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false);
        filterList.setLayoutManager(layoutManager);
        filterList.setHasFixedSize(true);

        FilterAdapter mAdapter = new FilterAdapter(index, onFilterSelected);
        filterList.setAdapter(mAdapter);

    }

    private void setViewPager() {
        cardShadowTransformer = new ShadowTransformer(viewPager, cardAdapter);
        viewPager.setAdapter(cardAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(pageListener);
        viewPager.setPageTransformer(false, cardShadowTransformer);
    }

    /**
     * Notify when the Carrousel change's pages.
     */
    private ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Team team = teams[position];
            changeTitle(team);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * Change's the Team name
     */

    private void changeTitle(Team teamName) {
        ((TextView)findViewById(R.id.team_name)).setText(teamName.getFullName());
    }

    /**
     * Create's an interface to get the position for the index scroll
     */
    private FilterAdapter.OnFilterSelected onFilterSelected = new FilterAdapter.OnFilterSelected() {
        @Override
        public void onSelected(String letter) {
            itStartsWithLetter(letter);
        }
    };

    private void itStartsWithLetter(String letter) {
        for(int i = 0; i < teams.length; i++){
            Team team = teams[i];
            if(team.getFullName().startsWith(letter)){
                viewPager.setCurrentItem(i);
                return;
            }
        }
    }

    /**
     * Receives the click from the CardView
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
     * Intent that sends to the TeaminfoAcitivity
     */

    private void openTeamInfo() {

            Intent intent = new Intent(ChooseTeamActivity.this,TeamInfoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.transition_from_activity, 0);
    }

    /**
     * Save in the device the name and initial of the selected team
     */

    private void  saveInDeviceValues(String initial,String nameTeam){

        SharedPreferences pref          = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("teamInitials",initial);
        editor.putString("teamName",nameTeam);
        editor.commit();

    }

    /**
     * Generates the alertDialog with the seasons for the call
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
       AlertDialog dialog =  builder.create();
       dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
       dialog.show();
    }

    /**
     * Save the selected season on alertDialog
     */

    private void saveSeasonChoosed(String yearSelected) {

        SharedPreferences pref          = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("seasonSelected",yearSelected);
        editor.commit();
    }

}