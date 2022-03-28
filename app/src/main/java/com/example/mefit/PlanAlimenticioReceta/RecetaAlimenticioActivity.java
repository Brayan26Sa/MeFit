package com.example.mefit.PlanAlimenticioReceta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecetaAlimenticioActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    PlanRecetaAdapter planRecetaAdapter;
    ArrayList<PlanRecetaModal> list;
    ImageView jimgPhotoReceta;
    TextView jtxtUrlReceta;
    FirebaseUser user;


    private FirebaseAuth firebaseAuth;
    DatabaseReference BASE_DE_DATOS;
    String Url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta_alimenticio);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        recyclerView = findViewById(R.id.idRVPlanAliment);
        jimgPhotoReceta = findViewById(R.id.ximgPhotoRecta);
        jtxtUrlReceta = findViewById(R.id.xtxtUrlReceta);

        firebaseAuth= FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("RECURCES_APP/RECETAPLANPDF");

        BASE_DE_DATOS.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String imagen = ""+snapshot.child("imagen").getValue();
                    String url = ""+snapshot.child("url").getValue();


                    Picasso.get().load(imagen).into(jimgPhotoReceta);
                    Url=url;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        jtxtUrlReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Url));
                startActivity(intent);
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("RECURCES_APP/PLAN_RECETA");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        planRecetaAdapter = new PlanRecetaAdapter(this,list);
        recyclerView.setAdapter(planRecetaAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    PlanRecetaModal plan = dataSnapshot.getValue(PlanRecetaModal.class);
                    list.add(plan);
                }
                planRecetaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}