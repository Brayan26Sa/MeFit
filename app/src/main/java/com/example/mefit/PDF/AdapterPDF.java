package com.example.mefit.PDF;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mefit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPDF extends RecyclerView.Adapter <AdapterPDF.ViewHolder> {

    private List<Modalpdf> mData;
    private LayoutInflater mInflater;
    private Context context;
    final AdapterPDF.OnItemClickListener listener;

    @NonNull
    @Override
    public AdapterPDF.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.from(parent.getContext()).inflate(R.layout.pdf_item,parent,false);
        return new AdapterPDF.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPDF.ViewHolder holder, int position) {
        holder.CvPDF.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public interface OnItemClickListener {
        void onItemClick(Modalpdf item);
    }

    public AdapterPDF(List<Modalpdf> mData, Context context, AdapterPDF.OnItemClickListener listener) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView TitlePDF;
        private ImageView UriImgPDF,TypeDocument;
        private CardView CvPDF;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TitlePDF = itemView.findViewById(R.id.idTVTitlePDF);
            UriImgPDF = itemView.findViewById(R.id.idIVPDF);
            TypeDocument = itemView.findViewById(R.id.ximgTypeDocument);
            CvPDF = itemView.findViewById(R.id.CV_PDF);

        }
        void bindData(final Modalpdf item){

            TitlePDF.setText(item.getTitlePDF());
            Picasso.get().load(item.getUriImgPDF()).into(UriImgPDF);
            Picasso.get().load(item.getTypeDocument()).error(R.drawable.ic_nowifi).into(TypeDocument);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
