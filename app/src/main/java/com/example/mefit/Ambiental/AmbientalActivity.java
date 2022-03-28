package com.example.mefit.Ambiental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.mefit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class AmbientalActivity extends AppCompatActivity {

    ImageView jimgAnimalUno,jimgAnimalDos,jimgAnimalTres,jimgAnimalCuatro,jimgAnimalCinco,jimgAnimalSeis,jimgAnimalSiete,jimgDato;
    ImageView jimgAmbiental,jimgAmbientalDos;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth firebaseAuth;
    DatabaseReference BASE_DE_DATOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambiental);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jimgAmbiental = findViewById(R.id.ximgAmbiental);
        jimgAnimalUno = findViewById(R.id.ximgAnimalUno);
        jimgAnimalDos = findViewById(R.id.ximgAnimalDos);
        jimgAnimalTres = findViewById(R.id.ximgAnimalTres);
        jimgAnimalCuatro = findViewById(R.id.ximgAnimalCuatro);
        jimgAnimalCinco = findViewById(R.id.ximgAnimalCinco);
        jimgAnimalSeis = findViewById(R.id.ximgAnimalSeis);
        jimgAnimalSiete = findViewById(R.id.ximgAnimalSiete);
        jimgAmbientalDos = findViewById(R.id.ximgAmbientalDos);
        jimgDato = findViewById(R.id.ximgDato);


        firebaseAuth=FirebaseAuth.getInstance();

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("RECURCES_APP/AMBIENTAL");

        BASE_DE_DATOS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String Ambiental = ""+snapshot.child("Ambiental").getValue();
                    String AnimalUno = ""+snapshot.child("AnimalUno").getValue();
                    String AnimalDos = ""+snapshot.child("AnimalDos").getValue();
                    String AnimalTres = ""+snapshot.child("AnimalTres").getValue();
                    String AnimalCuatro = ""+snapshot.child("AnimalCuatro").getValue();
                    String AnimalCinco = ""+snapshot.child("AnimalCinco").getValue();
                    String AnimalSeis = ""+snapshot.child("AnimalSeis").getValue();
                    String AnimalSiete = ""+snapshot.child("AnimalSiete").getValue();
                    String AmbientalDos = ""+snapshot.child("AmbientalDos").getValue();
                    String Dato = ""+snapshot.child("Dato").getValue();


                    Picasso.get().load(Ambiental).into(jimgAmbiental);
                    Picasso.get().load(AnimalUno).into(jimgAnimalUno);
                    Picasso.get().load(AnimalDos).into(jimgAnimalDos);
                    Picasso.get().load(AnimalTres).into(jimgAnimalTres);
                    Picasso.get().load(AnimalCuatro).into(jimgAnimalCuatro);
                    Picasso.get().load(AnimalCinco).into(jimgAnimalCinco);
                    Picasso.get().load(AnimalSeis).into(jimgAnimalSeis);
                    Picasso.get().load(AnimalSiete).into(jimgAnimalSiete);
                    Picasso.get().load(AmbientalDos).into(jimgAmbientalDos);
                    Picasso.get().load(Dato).into(jimgDato);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}