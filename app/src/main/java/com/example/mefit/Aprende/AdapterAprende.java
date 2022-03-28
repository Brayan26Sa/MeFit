package com.example.mefit.Aprende;

import android.content.Context;
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

import com.example.mefit.Contact.ModalContact;
import com.example.mefit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAprende extends RecyclerView.Adapter<AdapterAprende.ViewHolder> {

    private List<ModalAprende> mData;
    private LayoutInflater mInflater;
    private Context context;
    final AdapterAprende.OnItemClickListener listener;

    public interface OnItemClickListener{
        void OnItemClick(ModalAprende item);
    }

    public AdapterAprende(List<ModalAprende> mData, Context context, OnItemClickListener listener) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterAprende.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.from(parent.getContext()).inflate(R.layout.aprende_item,parent,false);
        return new AdapterAprende.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAprende.ViewHolder holder, int position) {
        holder.LnyAprende.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView TitleA;
        private TextView InfoA;
        private ImageView Aprende;
        private CardView LnyAprende;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TitleA = itemView.findViewById(R.id.idTVTitleA);
            InfoA = itemView.findViewById(R.id.idTVInfoA);
            Aprende = itemView.findViewById(R.id.idIVAprende);
            LnyAprende = itemView.findViewById(R.id.lnyAprende);

        }
        void bindData(final ModalAprende item){

            TitleA.setText(item.getTitleA());
            InfoA.setText(item.getInfoA());
            Picasso.get().load(item.getAprende()).into(Aprende);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(item);
                }
            });
        }
    }
}
