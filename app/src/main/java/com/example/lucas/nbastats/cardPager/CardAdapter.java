package com.example.lucas.nbastats.cardPager;

import android.support.v7.widget.CardView;

public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float GetBaseElevation();
    CardView getCardViewAt(int position);
    int getCount();
}
