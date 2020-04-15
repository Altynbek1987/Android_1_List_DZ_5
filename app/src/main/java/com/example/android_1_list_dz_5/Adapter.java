package com.example.android_1_list_dz_5;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Students> list;
    onClick onClick;

    public Adapter() {
        list = new ArrayList<>();
    }

    public void update(ArrayList<Students> students) {
        list = students;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_students, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.listener = onClick;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.listener = onClick;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
