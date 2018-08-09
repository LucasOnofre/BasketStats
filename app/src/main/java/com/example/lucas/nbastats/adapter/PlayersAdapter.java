package com.example.lucas.nbastats.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.model.Player;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.CustomViewHolder> {

    private List<Player> dataList;
    private Context context;

    public PlayersAdapter(Context context, List<Player> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView names;
        TextView teams;
        TextView status;
        TextView rookieYear;


        CustomViewHolder(View itemView) {

            super(itemView);

            view        = itemView;
            names       = view.findViewById(R.id.name);
            teams       = view.findViewById(R.id.team);
            status      = view.findViewById(R.id.status);
            rookieYear  = view.findViewById(R.id.rookieYear);
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

        holder.names .setText(dataList.get(position).getFullName());

        String status = dataList.get(position).getStatus();

        if (status.equals("Active"))
            holder.status.setTextColor(Color.GREEN);

        holder.status    .setText(status);
        holder.rookieYear.setText(dataList.get(position).getRookieYear().toString());

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}