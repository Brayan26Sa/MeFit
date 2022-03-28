package com.example.mefit.Nutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mefit.Contact.AdapterContact;
import com.example.mefit.Contact.ModalContact;
import com.example.mefit.Entrenamiento.ListAdapter;
import com.example.mefit.R;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.MyViewHolder> {

    Context context;
    ArrayList<FoodList> list;

    public AdapterFood(Context context, ArrayList<FoodList> foodListArrayList) {
        this.context = context;
        this.list = foodListArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.element_foods,parent,false);
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

        TextView food, carbohidratos, proteinas, grasas, portion;
        ImageView urlfood;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            food = itemView.findViewById(R.id.idTVFood);
            carbohidratos = itemView.findViewById(R.id.idTVCarbo);
            proteinas = itemView.findViewById(R.id.idTVProteinas);
            grasas = itemView.findViewById(R.id.idTVGrasas);
            portion = itemView.findViewById(R.id.idTVPortion);
            urlfood = itemView.findViewById(R.id.xidIVFood);

            }

            void bindData(final FoodList item){
                food.setText(item.getFood());
                carbohidratos.setText(item.getCarbohidratos());
                proteinas.setText(item.getProteinas());
                grasas.setText(item.getGrasas());
                portion.setText(item.getPortion());
                Picasso.get().load(item.getUrlfood()).into(urlfood);
            }
    }
}
