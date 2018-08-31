package com.example.lucas.nbastats.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lucas.nbastats.R;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.MyViewHolder> {

    public interface OnFilterSelected{
         void onSelected(String letter);
    }

    private String[] list;
    private OnFilterSelected onFilterSelected;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView letter;
        public MyViewHolder(TextView v) {
            super(v);
            letter = v;
        }
    }


    public FilterAdapter(String[] myDataset, OnFilterSelected onFilterSelected) {
        list = myDataset;
        this.onFilterSelected = onFilterSelected;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.side_index_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.letter.setText(list[position]);
        holder.letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = String.valueOf(holder.letter.getText());
                onFilterSelected.onSelected(text);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.length;
    }
}
