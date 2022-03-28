package com.example.mefit.Comunicados;

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

public class ComunicadoAdapter extends RecyclerView.Adapter<ComunicadoAdapter.MyViewHolder> {

    Context context;
    ArrayList<ComunicadoModal> list;

    public ComunicadoAdapter(Context context, ArrayList<ComunicadoModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comunicados_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Dia, Informacion, web;
        ImageView Comunicados;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Dia = itemView.findViewById(R.id.idTVFecha);
            Informacion = itemView.findViewById(R.id.idTVInformacion);
            web = itemView.findViewById(R.id.idTVWeb);
            Comunicados = itemView.findViewById(R.id.idIVComunicado);
            }
            void bindData(final ComunicadoModal item){
                Dia.setText(item.getFecha());
                Informacion.setText(item.getInformacion());
                web.setText(item.getWeb());
                Picasso.get().load(item.getImageUrlComunicado()).into(Comunicados);
            }
    }
}
