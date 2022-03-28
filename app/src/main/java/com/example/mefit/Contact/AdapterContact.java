package com.example.mefit.Contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mefit.Nutrition.FoodList;
import com.example.mefit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ViewHolder>{

    private List<ModalContact> mData;
    private LayoutInflater mInflater;
    private Context context;
    final AdapterContact.OnItemClickListener listener;

    @NonNull
    @Override
    public AdapterContact.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.from(parent.getContext()).inflate(R.layout.listcontact,parent,false);
        return new AdapterContact.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterContact.ViewHolder holder, int position) {
            holder.LNYContact.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition));
            holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public AdapterContact(List<ModalContact> mData, Context context, OnItemClickListener listener) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void OnItemClick(ModalContact item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView AgendarCita, Especialidad, Ubicacion;
        private ImageView UrlImagePersona, UrlImageLogo;
        private LinearLayout LNYContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            AgendarCita = itemView.findViewById(R.id.xtxtAgenda);
            Especialidad = itemView.findViewById(R.id.xtxtEspe);
            Ubicacion = itemView.findViewById(R.id.xtxtUbica);
            UrlImagePersona = itemView.findViewById(R.id.ximgContact);
            UrlImageLogo = itemView.findViewById(R.id.ximgLogoUni);
            LNYContact = itemView.findViewById(R.id.LNYContact);
            }
            void bindData(final ModalContact item){

                AgendarCita.setText(item.getAgenda());
                Especialidad.setText(item.getEspe());
                Ubicacion.setText(item.getUbica());
                Picasso.get().load(item.getUrlImagePerson()).into(UrlImagePersona);
                Picasso.get().load(item.getUrlImageUni()).into(UrlImageLogo);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.OnItemClick(item);
                    }
                });
            }
    }
}
