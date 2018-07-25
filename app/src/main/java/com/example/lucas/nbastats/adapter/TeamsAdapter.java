package com.example.lucas.nbastats.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.nbastats.R;

import java.util.ArrayList;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.CustomViewHolder> {

    private ArrayList<String> dataList;
    private Context context;

    public TeamsAdapter(Context context, ArrayList<String> dataList){
        this.context    = context;
        this.dataList   = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        View      view;
        TextView  teams;


        CustomViewHolder(View itemView) {

            super(itemView);

            view       = itemView;
            teams      = view.findViewById(R.id.team);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.line_teams, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.teams.setText((CharSequence) dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
