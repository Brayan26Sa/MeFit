package com.example.mefit.Settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mefit.Entrenamiento.ListAdapter;
import com.example.mefit.Entrenamiento.ListModal;
import com.example.mefit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.http.Url;

public class AdapterSettings extends RecyclerView.Adapter <AdapterSettings.ViewHolder> {

    private List<SettingsModel> mData;
    private LayoutInflater mInflater;
    private Context context;
    final AdapterSettings.OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.from(parent.getContext()).inflate(R.layout.settings_item,parent,false);
        return new AdapterSettings.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.CVSettings.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener{
        void onItemClick(SettingsModel item);
    }

    public AdapterSettings(List<SettingsModel> mData, Context context, OnItemClickListener listener) {
        this.mData = mData;
        this.mInflater=LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView NameSettings;
        private ImageView UrlImageSettings;
        private CardView CVSettings;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            NameSettings = itemView.findViewById(R.id.idTVNameSettings);
            UrlImageSettings = itemView.findViewById(R.id.idIVIconSettings);
            CVSettings = itemView.findViewById(R.id.idCVSettings);
        }
        void bindData(final SettingsModel item){

            NameSettings.setText(item.getNameSettings());
            Picasso.get().load(item.getUrlImageSettings()).into(UrlImageSettings);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });

        }
    }
}
