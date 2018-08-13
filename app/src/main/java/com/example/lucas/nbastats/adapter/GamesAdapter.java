package com.example.lucas.nbastats.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.model.Game;
import com.example.lucas.nbastats.model.Player;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.CustomViewHolder> {

    private List<Game> dataList;
    private Context context;

    public GamesAdapter(Context context, List<Game> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;



        CustomViewHolder(View itemView) {

            super(itemView);

            view        = itemView;

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line_players, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}