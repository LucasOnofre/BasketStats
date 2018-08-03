package com.example.lucas.nbastats.activity;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lucas.nbastats.R;

public class ChoseActivity extends AppCompatActivity {

    private ActionBar ActionBar;
    private BottomNavigationView bottomNavigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);

        ActionBar = getSupportActionBar();
        bottomNavigationBar = findViewById(R.id.navigationView);



    }
}
