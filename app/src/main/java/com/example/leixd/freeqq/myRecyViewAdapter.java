package com.example.leixd.freeqq;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by leixd on 17-12-6.
 */

public class myRecyViewAdapter extends RecyclerView.Adapter {
    public int size;
    public myRecyViewAdapter(int size) {

        super();
        this.size=size;

    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return size;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listview1,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }
}
