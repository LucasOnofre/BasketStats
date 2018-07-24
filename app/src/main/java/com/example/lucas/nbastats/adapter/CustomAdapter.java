package com.example.lucas.nbastats.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.nbastats.R;
import com.example.lucas.nbastats.model.Players;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Players> dataList;
    private Context context;

    public CustomAdapter(Context context,List<Players> dataList){
        this.context    = context;
        this.dataList   = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

         View      view;
         TextView  names;
         TextView  teams;
         TextView  status;
         TextView  rookieYear;
         TextView  birthDate;


        CustomViewHolder(View itemView) {
            super(itemView);

            view       = itemView;
            names      = view.findViewById(R.id.name);
            teams      = view.findViewById(R.id.team);
            status     = view.findViewById(R.id.status);
            birthDate  = view.findViewById(R.id.birthDate);
            rookieYear = view.findViewById(R.id.rookieYear);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.names      .setText(dataList.get(position).getFullName());
        holder.teams      .setText(dataList.get(position).getTeam());
        holder.status     .setText(dataList.get(position).getStatus());
        holder.birthDate  .setText(dataList.get(position).getBirthDate());
        holder.rookieYear .setText(dataList.get(position).getRookieYear().toString());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}