package com.example.mefit.Entrenamiento;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mefit.R;
import com.example.mefit.Settings.CategoryRVAdapter;
import com.example.mefit.Settings.NewsRVAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter <ListAdapter.ViewHolder> {

    private List<ListModal> mData;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapter.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(ListModal item);
    }

    public ListAdapter(List<ListModal>itemList, Context context,ListAdapter.OnItemClickListener listener) {
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =mInflater.from(parent.getContext()).inflate(R.layout.list_element,parent,false);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.cv.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title, series, Day, Muscle, RM;
        private ImageView Ejercicio;
        private LinearLayout cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.xtxtTitle);
            series = itemView.findViewById(R.id.xtxtSeries);
            Day = itemView.findViewById(R.id.xtxtDay);
            Muscle=itemView.findViewById(R.id.xtxtMuscle);
            RM=itemView.findViewById(R.id.xtxtRM);
            Ejercicio = itemView.findViewById(R.id.ximgEjercicio);
            cv=itemView.findViewById(R.id.cv);
        }
        void bindData(final ListModal item){
            title.setText(item.getTitle());
            series.setText(item.getSeries());
            Day.setText(item.getDay());
            Muscle.setText(item.getMuscle());
            RM.setText(item.getRM());
            Picasso.get().load(item.getUrlToImage()).into(Ejercicio);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });



        }
    }
}
