package com.example.lucas.nbastats.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.model.Game;
import com.example.lucas.nbastats.model.Team;

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
        ImageView homeTeamLogo;
        ImageView alwayTeamLogo;
        TextView choosenTeamInitial;
        TextView choosenTeamScore;
        TextView otherTeamInitial;
        TextView otherTeamScore;

        CustomViewHolder(View itemView) {

            super(itemView);

            view = itemView;
            homeTeamLogo = view.findViewById(R.id.homeTeamLogo);
            alwayTeamLogo = view.findViewById(R.id.alwayTeamLogo);
            otherTeamScore = view.findViewById(R.id.alwayTeamScore);
            choosenTeamScore = view.findViewById(R.id.homeTeamScore);
            otherTeamInitial = view.findViewById(R.id.alwayTeamInitial);
            choosenTeamInitial = view.findViewById(R.id.homeTeamInitial);


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
        holder.choosenTeamScore.setText(String.valueOf(dataList.get(position).getHomeTeam().getFinalScore()));

        holder.otherTeamInitial.setText(dataList.get(position).getAwayTeam().getTeamId());
        holder.otherTeamScore.setText(String.valueOf(dataList.get(position).getAwayTeam().getFinalScore()));


        int alwayScore = dataList.get(position).getAwayTeam().getFinalScore();
        int homeScore  = dataList.get(position).getHomeTeam().getFinalScore();

        if (homeScore > alwayScore) {

            holder.choosenTeamScore.setTextColor(ContextCompat.getColor(context, R.color.green));
            holder.otherTeamScore.setTextColor(ContextCompat.getColor(context, R.color.red));

        } else if (homeScore < alwayScore) {

            holder.otherTeamScore.setTextColor(ContextCompat.getColor(context, R.color.green));
            holder.choosenTeamScore.setTextColor(ContextCompat.getColor(context, R.color.red));
        }

        holder.otherTeamScore   .setText(String.valueOf(dataList.get(position).getAwayTeam().getFinalScore()));
        holder.choosenTeamScore .setText(String.valueOf(dataList.get(position).getHomeTeam().getFinalScore()));

        int homelogo  = getTeamLogo(dataList.get(position).getHomeTeam().getTeamId());
        int alwayLogo = getTeamLogo(dataList.get(position).getAwayTeam().getTeamId());


        holder.homeTeamLogo .setImageResource(homelogo);
        holder.alwayTeamLogo.setImageResource(alwayLogo);

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    protected int getTeamLogo(String initial) {

        //Array com todos os times, contendo nome,sigla e logo
        Team[] teams = new Team[]{
                new Team("Atlanta Hawks", "ATL", R.drawable.atlanta),
                new Team("Brooklyn Nets", "BKN", R.drawable.brooklyn),
                new Team("Boston Celtics", "BOS", R.drawable.boston),
                new Team("Charlotte Hornets", "CHA", R.drawable.charlotte),
                new Team("Chicago Bulls", "CHI", R.drawable.chicago),
                new Team("Cleveland Cavaliers", "CLE", R.drawable.cleveland),
                new Team("Dallas Mavericks", "DAL", R.drawable.dallas),
                new Team("Detroit Pistons", "DET", R.drawable.detroit),
                new Team("Denver Nugguets", "DEN", R.drawable.ic_denver),
                new Team("Golden State Warriors", "GSW", R.drawable.golden),
                new Team("Houston Rockets", "HOU", R.drawable.houston),
                new Team("Indiana Pacers", "IND", R.drawable.indiana),
                new Team("Los Angeles Clippers", "LAC", R.drawable.clippers),
                new Team("Los Angeles Lakers", "LAL", R.drawable.lakers),
                new Team("Memphis Grizzlies", "MEM", R.drawable.memphis),
                new Team("Miami Heat", "MIA", R.drawable.miami),
                new Team("Milwaukee Bucks", "MIL", R.drawable.milwaukee),
                new Team("Minnesota Timberwolves", "MIN", R.drawable.minnesota),
                new Team("New Orleans Pelicans", "NOP", R.drawable.pelicans),
                new Team("New York Knicks", "NYK", R.drawable.knicks),
                new Team("Oklahoma City Thunder", "OKC", R.drawable.oklahoma),
                new Team("Orlando Magic", "ORL", R.drawable.orlando),
                new Team("Philadelphia 76ers", "PHI", R.drawable.philidephia),
                new Team("Phoenix Suns", "PHX", R.drawable.phoenix),
                new Team("Portland Trail Blazers", "POR", R.drawable.portland),
                new Team("Sacramento Kings", "SAC", R.drawable.sacramento),
                new Team("San Antonio Spurs", "SAS", R.drawable.san),
                new Team("Toronto Raptors", "TOR", R.drawable.toronto),
                new Team("Utah Jazz", "UTA", R.drawable.uta),
                new Team("Washington Wizards", "WAS", R.drawable.washington)
        };

        for (Team team: teams){
            if (initial.equals( team.getInitials())){
                return team.getLogo();
            }

        }
        return 0;
    }

}