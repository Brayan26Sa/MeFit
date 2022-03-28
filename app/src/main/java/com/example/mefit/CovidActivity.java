package com.example.mefit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CovidActivity extends AppCompatActivity {

    private TextView CasosT, CasosA, Vacunados, Defunciones;
    private TextView MayorNumero;
    private ImageView Lugar;
    private Spinner spinner;
    private ArrayList<String> arrayList = new ArrayList<>();

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    DatabaseReference BASE_DE_DATOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);


        CasosT = findViewById(R.id.xtxtCasosT);
        CasosA = findViewById(R.id.xtxtCasosA);
        Vacunados = findViewById(R.id.xtxtVacunados);
        Defunciones = findViewById(R.id.xtxtDefunciones);
        MayorNumero = findViewById(R.id.xtxtMayor);
        Lugar = findViewById(R.id.ximgLugar);
        spinner = findViewById(R.id.idSPCity);

        showDataSpinner();

        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("COVID_SETTINGS");

        BASE_DE_DATOS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String casost = ""+snapshot.child("casost").getValue();
                    String casosa = ""+snapshot.child("casosa").getValue();
                    String vacunados = ""+snapshot.child("vacunados").getValue();
                    String defunciones = ""+snapshot.child("defunciones").getValue();
                    String mayor = ""+snapshot.child("mayor").getValue();

                    String lugar = ""+snapshot.child("lugar").getValue();

                    CasosT.setText(casost);
                    CasosA.setText(casosa);
                    Vacunados.setText(vacunados);
                    Defunciones.setText(defunciones);
                    MayorNumero.setText(mayor);
                    Picasso.get().load(lugar).into(Lugar);



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void showDataSpinner(){
        databaseReference.child("Lugares").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                arrayList.clear();
                for(DataSnapshot item : datasnapshot.getChildren()){
                    arrayList.add(item.child("Lugares").getValue(String.class));
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(CovidActivity.this,R.layout.spinner_item);
                spinner.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}