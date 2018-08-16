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

import org.w3c.dom.Text;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.CustomViewHolder> {

    private List<Game> dataList;
    private Context    context;

    public GamesAdapter(Context context, List<Game> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView choosenTeamInitial;
        TextView choosenTeamScore;
        TextView otherTeamInitial;
        TextView otherTeamScore;

        CustomViewHolder(View itemView) {

            super(itemView);

            view                = itemView;
            otherTeamScore      = view.findViewById(R.id.alwayTeamScore);
            choosenTeamScore    = view.findViewById(R.id.homeTeamScore);
            otherTeamInitial    = view.findViewById(R.id.alwayTeamInitial);
            choosenTeamInitial  = view.findViewById(R.id.homeTeamInitial);



        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line_games, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {


        holder.choosenTeamInitial.setText(dataList.get(position).getHomeTeam().getTeamId());
        holder.choosenTeamScore  .setText(String.valueOf(dataList.get(position).getHomeTeam().getFinalScore()));

        holder.otherTeamInitial  .setText(dataList.get(position).getAwayTeam().getTeamId());
        holder.otherTeamScore    .setText(String.valueOf(dataList.get(position).getAwayTeam().getFinalScore()));


        int alwayScore = dataList.get(position).getAwayTeam().getFinalScore();
        int homeScore  = dataList.get(position).getHomeTeam().getFinalScore();

        if (homeScore > alwayScore){

            holder.choosenTeamScore .setTextColor(ContextCompat.getColor(context,R.color.green));
            holder.otherTeamScore   .setTextColor(ContextCompat.getColor(context,R.color.red));


        }else if (homeScore < alwayScore) {

            holder.otherTeamScore.setTextColor(ContextCompat.getColor(context, R.color.green));
            holder.choosenTeamScore.setTextColor(ContextCompat.getColor(context, R.color.red));
        }

        holder.otherTeamScore    .setText(String.valueOf(dataList.get(position).getAwayTeam().getFinalScore()));
        holder.choosenTeamScore  .setText(String.valueOf(dataList.get(position).getHomeTeam().getFinalScore()));



    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}