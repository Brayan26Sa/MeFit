package com.example.mefit.Aprende;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.mefit.Histology.HistologiaActivity;
import com.example.mefit.Quiz.EmbriologiaActivity;
import com.example.mefit.R;

import java.util.ArrayList;
import java.util.List;

public class AprendeActivity extends AppCompatActivity {

    List<ModalAprende> modalAprendeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        getCategories();

    }

    private void getCategories() {
        modalAprendeList = new ArrayList<>();
        modalAprendeList.add(new ModalAprende("Bioquimica", "La bioquímica es una rama de la ciencia que estudia la composición química de los seres vivos, especialmente las proteínas, carbohidratos, lípidos y ácidos nucleicos.",
                "https://www.iidenut.org/instituto/wp-content/uploads/2020/03/39-Bioqu%C3%ADmica.jpg",0));
        modalAprendeList.add(new ModalAprende("Embriología", "La embriología es un área de la genética que se encarga del estudio del desarrollo del embrión,  es decir, desde la fecundación del óvulo hasta el nacimiento.",
                "https://sydweb.neocities.org/biologia/23.png",1));
        modalAprendeList.add(new ModalAprende("Histología", "La embriología es un área de la genética que se encarga del estudio del desarrollo del embrión,  es decir, desde la fecundación del óvulo hasta el nacimiento.",
                "http://comofuncionaque.com/wp-content/uploads/2015/05/Imagen-al-microscopio-de-celulas-vegetales.jpg.jpg",2));
        modalAprendeList.add(new ModalAprende("Histología", "La embriología es un área de la genética que se encarga del estudio del desarrollo del embrión,  es decir, desde la fecundación del óvulo hasta el nacimiento.",
                "http://comofuncionaque.com/wp-content/uploads/2015/05/Imagen-al-microscopio-de-celulas-vegetales.jpg.jpg",3));
        modalAprendeList.add(new ModalAprende("Histología", "La embriología es un área de la genética que se encarga del estudio del desarrollo del embrión,  es decir, desde la fecundación del óvulo hasta el nacimiento.",
                "http://comofuncionaque.com/wp-content/uploads/2015/05/Imagen-al-microscopio-de-celulas-vegetales.jpg.jpg",4));
        modalAprendeList.add(new ModalAprende("Histología", "La embriología es un área de la genética que se encarga del estudio del desarrollo del embrión,  es decir, desde la fecundación del óvulo hasta el nacimiento.",
                "http://comofuncionaque.com/wp-content/uploads/2015/05/Imagen-al-microscopio-de-celulas-vegetales.jpg.jpg",5));
        modalAprendeList.add(new ModalAprende("Histología", "La embriología es un área de la genética que se encarga del estudio del desarrollo del embrión,  es decir, desde la fecundación del óvulo hasta el nacimiento.",
                "http://comofuncionaque.com/wp-content/uploads/2015/05/Imagen-al-microscopio-de-celulas-vegetales.jpg.jpg",6));

        AdapterAprende adapterAprende = new AdapterAprende(modalAprendeList, this, new AdapterAprende.OnItemClickListener() {
            @Override
            public void OnItemClick(ModalAprende item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler_view_Aprende);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterAprende);
    }

    private void moveToDescription(ModalAprende item) {
        if(item.getID()==0){
            Toast.makeText(AprendeActivity.this, "Hola Wapo", Toast.LENGTH_SHORT).show();
        }else if(item.getID()==1){
            startActivity(new Intent(AprendeActivity.this, EmbriologiaActivity.class));
        }else if(item.getID()==2){
            startActivity(new Intent(AprendeActivity.this, HistologiaActivity.class));
        }
    }
}