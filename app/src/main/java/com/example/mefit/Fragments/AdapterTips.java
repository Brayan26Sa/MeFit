package com.example.mefit.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mefit.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterTips extends RecyclerView.Adapter<AdapterTips.MyViewHolder> {

    Context context;
    ArrayList<ListTips> list;

    public AdapterTips(Context context, ArrayList<ListTips> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.element_tips,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ListTips listTips = list.get(position);
        holder.title.setText(listTips.getTitle());
        holder.subtitle.setText(listTips.getSubtitle());
        Picasso.get().load(listTips.getUrlImage()).into(holder.urltips);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, subtitle;
        ImageView urltips;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.idTVTitleTips);
            subtitle = itemView.findViewById(R.id.idTVSubtitleTips);
            urltips = itemView.findViewById(R.id.idIVUrlImage);
        }
    }
}
