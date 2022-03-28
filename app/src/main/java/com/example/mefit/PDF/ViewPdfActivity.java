package com.example.mefit.PDF;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mefit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ViewPdfActivity extends AppCompatActivity {

    List<Modalpdf> modalpdfList;
    String UrlBookUno,UrlBookDos,UrlBookTres,UrlBookCuatro,UrlBookCinco,
    UrlBookSeis,UrlBookSiete,UrlBookOcho,UrlBookNueve,UrlBookDies,UrlBookOnce,UrlBookDoce;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    DatabaseReference BASE_DE_DATOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("RECURCES_APP/BOOKSAPP");
        BASE_DE_DATOS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String bookuno = ""+snapshot.child("bookuno").getValue();
                    String bookdos = ""+snapshot.child("bookdos").getValue();
                    String booktres = ""+snapshot.child("booktres").getValue();
                    String bookcuatro = ""+snapshot.child("bookcuatro").getValue();
                    String bookcinco = ""+snapshot.child("bookcinco").getValue();
                    String bookseis = ""+snapshot.child("bookseis").getValue();
                    String booksiete = ""+snapshot.child("booksiete").getValue();
                    String bookocho = ""+snapshot.child("bookocho").getValue();
                    String booknueve = ""+snapshot.child("booknueve").getValue();
                    String bookdies = ""+snapshot.child("bookdies").getValue();
                    String bookonce = ""+snapshot.child("bookonce").getValue();
                    String bookdoce = ""+snapshot.child("bookdoce").getValue();

                    UrlBookUno=bookuno;
                    UrlBookDos=bookdos;
                    UrlBookTres=booktres;
                    UrlBookCuatro=bookcuatro;
                    UrlBookCinco=bookcinco;
                    UrlBookSeis=bookseis;
                    UrlBookSiete=booksiete;
                    UrlBookOcho=bookocho;
                    UrlBookNueve=booknueve;
                    UrlBookDies=bookdies;
                    UrlBookOnce=bookonce;
                    UrlBookDoce=bookdoce;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        getCategories();

    }

    private void getCategories() {
        modalpdfList=new ArrayList<>();
        modalpdfList.add(new Modalpdf("Embriología basica - langman","https://www.vet-ebooks.com/wp-content/uploads/2021/01/Langmans-Medical-Embryology-14th-Edition.jpg",
                "https://n9.cl/hfqa2",0));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",1));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",2));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",3));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",4));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",5));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",6));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",7));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",8));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",9));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",10));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",11));
        modalpdfList.add(new Modalpdf("Histología, texto y atlas - Ross","https://libreriamedica.com/1852/histologia-texto-y-atlas-septima-edicion.jpg",
                "https://n9.cl/hfqa2",12));
        AdapterPDF adapterPDF = new AdapterPDF(modalpdfList, this, new AdapterPDF.OnItemClickListener() {
            @Override
            public void onItemClick(Modalpdf item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.idRVPDF);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterPDF);
    }

    public void moveToDescription(Modalpdf item){
        if(item.getID()==0){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookUno));
            startActivity(intent);
        }else if(item.getID()==1){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookDos));
            startActivity(intent);
        }else if(item.getID()==2){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookTres));
            startActivity(intent);
        }else if(item.getID()==3){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookCuatro));
            startActivity(intent);
        }else if(item.getID()==4){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookCinco));
            startActivity(intent);
        }else if(item.getID()==5){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookSeis));
            startActivity(intent);
        }else if(item.getID()==6){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookSiete));
            startActivity(intent);
        }else if(item.getID()==7){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookOcho));
            startActivity(intent);
        }else if(item.getID()==8){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookNueve));
            startActivity(intent);
        }else if(item.getID()==9){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookDies));
            startActivity(intent);
        }else if(item.getID()==10){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookOnce));
            startActivity(intent);
        }else if(item.getID()==11){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookDoce));
            startActivity(intent);
        }else if(item.getID()==12){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(UrlBookDoce));
            startActivity(intent);
        }
    }
}