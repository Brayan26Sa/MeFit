package com.example.mefit.PlanAlimenticioReceta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mefit.R;

import java.util.ArrayList;

public class PlanRecetaAdapter extends RecyclerView.Adapter<PlanRecetaAdapter.MyViewHolder> {

    Context context;
    ArrayList<PlanRecetaModal> list;

    public PlanRecetaAdapter(Context context, ArrayList<PlanRecetaModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PlanRecetaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reseta_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanRecetaAdapter.MyViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Title,Dia;
        TextView TDesayuno,DDesayuno;
        TextView TAlmuerso,DAlmuerso;
        TextView TMerienda,DMerienda;
        TextView TComida,DComida;
        TextView TCena,DCena;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.idTVTitleReceta);
            Dia = itemView.findViewById(R.id.idTVDia);
            TDesayuno = itemView.findViewById(R.id.idTVTDesayuno);
            DDesayuno = itemView.findViewById(R.id.idTVDDesayuno);
            TAlmuerso = itemView.findViewById(R.id.idTVTAlmuerso);
            DAlmuerso = itemView.findViewById(R.id.idTVDAlmuerso);
            TMerienda = itemView.findViewById(R.id.idTVTMerienda);
            DMerienda = itemView.findViewById(R.id.idTVDMerienda);
            TComida = itemView.findViewById(R.id.idTVTComida);
            DComida = itemView.findViewById(R.id.idTVDComida);
            TCena = itemView.findViewById(R.id.idTVTCena);
            DCena = itemView.findViewById(R.id.idTVDCena);

        }
        void  bindData(final PlanRecetaModal item){
            Title.setText(item.getTitle());
            Dia.setText(item.getDia());
            TDesayuno.setText(item.getTDesayuno());
            DDesayuno.setText(item.getDDesayuno());
            TAlmuerso.setText(item.getTAlmuerso());
            DAlmuerso.setText(item.getDAlmuerso());
            TMerienda.setText(item.getTMerienda());
            DMerienda.setText(item.getDMerienda());
            TComida.setText(item.getTComida());
            DComida.setText(item.getDComida());
            TCena.setText(item.getTCena());
            DCena.setText(item.getDCena());
        }
    }
}
