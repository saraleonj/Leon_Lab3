package me.pgb.a2021_02_19a.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.pgb.a2021_02_19a.model.Country;
import me.pgb.a2021_02_19a.model.ViewHolder;

public class ItemRecycleViewer extends RecyclerView.Adapter<ViewHolder> {

    private int layout_view;
    private ArrayList<Country> countryArrayList;

    public ItemRecycleViewer(int layout_view,  ArrayList<Country> countryArrayList){
        this.layout_view = layout_view;
        this.countryArrayList = countryArrayList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView name = holder.name;
        TextView capital = holder.capital;
        TextView region = holder.region;

        name.setText(countryArrayList.get(position).name);
        capital.setText(countryArrayList.get(position).capital);
        region.setText(countryArrayList.get(position).region);

    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }
}
