package com.example.lucas.nbastats.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.model.Player;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.CustomViewHolder> {

    private List<Player> dataList;
    private Context context;

    public PlayersAdapter(Context context, List<Player> dataList) {
        this.context  = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        View      view;
        TextView  name;
        TextView  teams;
        TextView  status;
        TextView  rookieYear;
        ImageView playerHeadshot;


        CustomViewHolder(View itemView) {

            super(itemView);

            view            = itemView;
            name           = view.findViewById(R.id.name);
            teams           = view.findViewById(R.id.team);
            status          = view.findViewById(R.id.status);
            rookieYear      = view.findViewById(R.id.rookieYear);
            playerHeadshot  = view.findViewById(R.id.player_headAhot);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line_players, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {

        String firstName    = dataList.get(position).getFirstName();
        String lastName     = dataList.get(position).getLastName();

        Picasso.get().load("https://nba-players.herokuapp.com/players/" + lastName+ "/" + firstName).into(holder.playerHeadshot, new Callback() {
            @Override
            public void onSuccess() {
                holder.playerHeadshot.setBackgroundColor(Color.WHITE);

            }

            @Override
            public void onError(Exception e) {


                holder.playerHeadshot.setBackgroundColor(Color.GRAY);
            }
        });

        holder.name .setText(dataList.get(position).getFullName());

        String status = dataList.get(position).getStatus();

        if (status.equals("Active"))
            holder.status.setTextColor(ContextCompat.getColor(context,R.color.green));

        holder.status    .setText(status);

        holder.rookieYear.setText(dataList.get(position).getRookieYear().toString());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}