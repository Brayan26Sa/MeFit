package com.example.mefit.Quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import retrofit2.http.Url;

public class EmbriologiaActivity extends AppCompatActivity {

    RadioGroup RdbQuizUno,RdbQuizDos,RdbQuizTres,RdbQuizCuatro,RdbQuizCinco;
    ImageView jimgMaterial;
    CardView UriEmbrio;
    Button Ok,OkDos,OkTres,OkCuatro,OkCinco;
    TextView TitleOne,TitleTwo,TitleThree,TitleFor,TitleFive;
    String RespUno="",RespDos="", RespTres="",RespCuatro="",RespCinco="";
    String CorrectUno="",CorrectDos="",CorrectTres="",CorrectCuatro="",CorrectCinco="",UrlEmbrio="";


    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    DatabaseReference BASE_DE_DATOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embriologia);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();

        RdbQuizUno = findViewById(R.id.RgpoQuizUno);
        RdbQuizDos = findViewById(R.id.RgpoQuizDos);
        RdbQuizTres = findViewById(R.id.RgpoQuizTres);
        RdbQuizCuatro = findViewById(R.id.RgpoQuizCuatro);
        RdbQuizCinco = findViewById(R.id.RgpoQuizCinco);
        jimgMaterial = findViewById(R.id.ximgMaterial);
        UriEmbrio = findViewById(R.id.UriEmbrio);
        TitleOne = findViewById(R.id.xtxtTitleOne);
        TitleTwo = findViewById(R.id.xtxtTitleTwo);
        TitleThree = findViewById(R.id.xtxtTitleThree);
        TitleFor = findViewById(R.id.xtxtTitleFor);
        TitleFive = findViewById(R.id.xtxtTitleFive);
        Ok = findViewById(R.id.Ok);
        OkDos = findViewById(R.id.OkDos);
        OkTres = findViewById(R.id.OkTres);
        OkCuatro = findViewById(R.id.OkCuatro);
        OkCinco = findViewById(R.id.OkCinco);

        RdbQuizUno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId==R.id.rdbUno){
                    RespUno="UNO";
                }else if(checkedId==R.id.rdbDos){
                    RespUno="DOS";
                }else if(checkedId==R.id.rdbTres){
                    RespUno="TRES";
                }else if(checkedId==R.id.rdbCuatro){
                    RespUno="CUATRO";
                }
            }
        });
        RdbQuizDos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId==R.id.rdbQuizUno){
                    RespDos="UNO";
                }else if(checkedId==R.id.rdbQuizDos){
                    RespDos="DOS";
                }else if(checkedId==R.id.rdbQuizTres){
                    RespDos="TRES";
                }else if(checkedId==R.id.rdbQuizCuatro){
                    RespDos="CUATRO";
                }
            }
        });
        RdbQuizTres.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId==R.id.rdbQuizTUno){
                    RespTres="UNO";
                }else if(checkedId==R.id.rdbQuizTDos){
                    RespTres="DOS";
                }else if(checkedId==R.id.rdbQuizTTres){
                    RespTres="TRES";
                }else if(checkedId==R.id.rdbQuizTCuatro){
                    RespTres="CUATRO";
                }
            }
        });
        RdbQuizCuatro.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId==R.id.rdbQuizCUno){
                    RespCuatro="UNO";
                }else if(checkedId==R.id.rdbQuizCDos){
                    RespCuatro="DOS";
                }else if(checkedId==R.id.rdbQuizCTres){
                    RespCuatro="TRES";
                }else if(checkedId==R.id.rdbQuizCCuatro){
                    RespCuatro="CUATRO";
                }
            }
        });
        RdbQuizCinco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId==R.id.rdbQuizCiUno){
                    RespCinco="UNO";
                }else if(checkedId==R.id.rdbQuizCiDos){
                    RespCinco="DOS";
                }else if(checkedId==R.id.rdbQuizCiTres){
                    RespCinco="TRES";
                }else if(checkedId==R.id.rdbQuizCiCuatro){
                    RespCinco="CUATRO";
                }
            }
        });

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("RECURCES_APP/QUIZEMBRIO/QUIZUNO");

        BASE_DE_DATOS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String correctUno = ""+snapshot.child("CorrectUno").getValue();
                    String correctDos = ""+snapshot.child("CorrectDos").getValue();
                    String correctTres = ""+snapshot.child("CorrectTres").getValue();
                    String correctCuatro = ""+snapshot.child("CorrectCuatro").getValue();
                    String correctCinco = ""+snapshot.child("CorrectCinco").getValue();
                    String uriembrio = ""+snapshot.child("uriembrio").getValue();
                    String imageuri = ""+snapshot.child("imageuri").getValue();

                    CorrectUno=correctUno;
                    CorrectDos=correctDos;
                    CorrectTres=correctTres;
                    CorrectCuatro=correctCuatro;
                    CorrectCinco=correctCinco;
                    UrlEmbrio=uriembrio;
                    Picasso.get().load(imageuri).into(jimgMaterial);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        UriEmbrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(UrlEmbrio));
                startActivity(intent);
            }
        });

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CorrectUno.equals(RespUno)){
                    TitleOne.setText("Bien echo !!!, genial");
                }else {
                    TitleOne.setText("No pu's no, sigue practicando");
                }
            }
        });
        OkDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CorrectDos.equals(RespDos)){
                    TitleTwo.setText("Bien echo !!!, genial");
                }else {
                    TitleTwo.setText("No pu's no, sigue practicando");
                }
            }
        });
        OkTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CorrectTres.equals(RespTres)){
                    TitleThree.setText("Bien echo !!!, genial");
                }else {
                    TitleThree.setText("No pu's no, sigue practicando");
                }
            }
        });
        OkCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CorrectCuatro.equals(RespCuatro)){
                    TitleFor.setText("Bien echo !!!, genial");
                }else {
                    TitleFor.setText("No pu's no, sigue practicando");
                }
            }
        });
        OkCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CorrectCinco.equals(RespCinco)){
                    TitleFive.setText("Bien echo !!!, genial");
                }else {
                    TitleFive.setText("No pu's no, sigue practicando");
                }
            }
        });

    }
}