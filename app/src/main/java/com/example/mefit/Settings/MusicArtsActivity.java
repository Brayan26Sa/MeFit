package com.example.mefit.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mefit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class MusicArtsActivity extends AppCompatActivity {

    ImageView jtxtArtistaUno,jtxtArtistaDos,jtxtArtistaTres,jtxtArtistaCuatro,jtxtArtistaCinco,jtxtArtistaSeis,jtxtArtistaSiete,jtxtArtistaOcho,jtxtArtistaNueve,
            jtxtArtistaDies,jtxtArtistaOnce,jtxtArtistaDoce,jtxtArtistaTrece,jtxtArtistaCatorce,jtxtArtistaQuince,jtxtArtistaDiesyseis;

    ImageView jimgArtistaCero,jimgArtistaCeroUno,jimgArtistaCeroDos,jimgArtistaCeroTres;
    TextView jtxtVideoCip;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth firebaseAuth;
    DatabaseReference BASE_DE_DATOS;

    String Url="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_arts);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jtxtArtistaUno = findViewById(R.id.ximgArtistaUno);
        jtxtArtistaDos = findViewById(R.id.ximgArtistaDos);
        jtxtArtistaTres = findViewById(R.id.ximgArtistaTres);
        jtxtArtistaCuatro = findViewById(R.id.ximgArtistaCuatro);
        jtxtArtistaCinco = findViewById(R.id.ximgArtistaCinco);
        jtxtArtistaSeis = findViewById(R.id.ximgArtistaSeis);
        jtxtArtistaSiete = findViewById(R.id.ximgArtistaSiete);
        jtxtArtistaOcho = findViewById(R.id.ximgArtOcho);
        jtxtArtistaNueve = findViewById(R.id.ximgArtNueve);
        jtxtArtistaDies = findViewById(R.id.ximgArtDies);
        jtxtArtistaOnce = findViewById(R.id.ximgArtOnce);
        jimgArtistaCero = findViewById(R.id.ximgArtistaCero);
        jimgArtistaCeroUno = findViewById(R.id.ximgArtistaCeroUno);
        jimgArtistaCeroDos = findViewById(R.id.ximgArtistaCeroDos);
        jimgArtistaCeroTres = findViewById(R.id.ximgArtistaCeroTres);
        jtxtArtistaDoce = findViewById(R.id.ximgArtistaDoce);
        jtxtArtistaTrece = findViewById(R.id.ximgArtistaTrece);
        jtxtArtistaCatorce = findViewById(R.id.ximgArtistaCatorce);
        jtxtArtistaQuince = findViewById(R.id.ximgArtistaQuince);
        jtxtArtistaDiesyseis = findViewById(R.id.ximgArtistaDiesciseis);
        jtxtVideoCip = findViewById(R.id.xtxtVideoClip);

        firebaseAuth=FirebaseAuth.getInstance();

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("RECURCES_APP/MusucArts");

        BASE_DE_DATOS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String ArtistaUno = ""+snapshot.child("ArtistaUno").getValue();
                    String ArtistaDos = ""+snapshot.child("ArtistaDos").getValue();
                    String ArtistaTres = ""+snapshot.child("ArtistaTres").getValue();
                    String ArtistaCuatro = ""+snapshot.child("ArtistaCuatro").getValue();
                    String ArtistaCinco = ""+snapshot.child("ArtistaCinco").getValue();
                    String ArtistaSeis = ""+snapshot.child("ArtistaSeis").getValue();
                    String ArtistaSiete = ""+snapshot.child("ArtistaSiete").getValue();
                    String ArtistaOcho = ""+snapshot.child("ArtistaOcho").getValue();
                    String ArtistaNueve = ""+snapshot.child("ArtistaNueve").getValue();
                    String ArtistaDies = ""+snapshot.child("ArtistaDies").getValue();
                    String ArtistaOnce = ""+snapshot.child("ArtistaOnce").getValue();
                    String ArtistaCero = ""+snapshot.child("ArtistaCero").getValue();
                    String ArtistaCeroUno = ""+snapshot.child("ArtistaCeroUno").getValue();
                    String ArtistaCeroDos = ""+snapshot.child("ArtistaCeroDos").getValue();
                    String ArtistaCeroTres = ""+snapshot.child("ArtistaCeroTres").getValue();
                    String ArtistaDoce = ""+snapshot.child("ArtistaDoce").getValue();
                    String ArtistaTrece = ""+snapshot.child("ArtistaTrece").getValue();
                    String ArtistaCatorce = ""+snapshot.child("ArtistaCatorce").getValue();
                    String ArtistaQuince = ""+snapshot.child("ArtistaQuince").getValue();
                    String ArtistaDiesyseis = ""+snapshot.child("ArtistaDiesyseis").getValue();
                    String VideoClip = ""+snapshot.child("VideoClip").getValue();

                    //URL's
                    String UrlArtUno = ""+snapshot.child("UrlArtUno").getValue();
                    String UrlArtDos = ""+snapshot.child("UrlArtDos").getValue();




                    Picasso.get().load(ArtistaUno).into(jtxtArtistaUno);
                    Picasso.get().load(ArtistaDos).into(jtxtArtistaDos);
                    Picasso.get().load(ArtistaTres).into(jtxtArtistaTres);
                    Picasso.get().load(ArtistaCuatro).into(jtxtArtistaCuatro);
                    Picasso.get().load(ArtistaCinco).into(jtxtArtistaCinco);
                    Picasso.get().load(ArtistaSeis).into(jtxtArtistaSeis);
                    Picasso.get().load(ArtistaSiete).into(jtxtArtistaSiete);
                    Picasso.get().load(ArtistaOcho).into(jtxtArtistaOcho);
                    Picasso.get().load(ArtistaNueve).into(jtxtArtistaNueve);
                    Picasso.get().load(ArtistaDies).into(jtxtArtistaDies);
                    Picasso.get().load(ArtistaOnce).into(jtxtArtistaOnce);
                    Picasso.get().load(ArtistaCero).into(jimgArtistaCero);
                    Picasso.get().load(ArtistaCeroUno).into(jimgArtistaCeroUno);
                    Picasso.get().load(ArtistaCeroDos).into(jimgArtistaCeroDos);
                    Picasso.get().load(ArtistaCeroTres).into(jimgArtistaCeroTres);
                    Picasso.get().load(ArtistaDoce).into(jtxtArtistaDoce);
                    Picasso.get().load(ArtistaTrece).into(jtxtArtistaTrece);
                    Picasso.get().load(ArtistaCatorce).into(jtxtArtistaCatorce);
                    Picasso.get().load(ArtistaQuince).into(jtxtArtistaQuince);
                    Picasso.get().load(ArtistaDiesyseis).into(jtxtArtistaDiesyseis);
                    jtxtVideoCip.setText(VideoClip);

                    Url=UrlArtUno;
                    Url=UrlArtDos;



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        jtxtArtistaUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Url));
                startActivity(intent);
            }
        });
        jtxtArtistaDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Url));
                startActivity(intent);
            }
        });

    }
}