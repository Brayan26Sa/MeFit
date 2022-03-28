package com.example.mefit.Nutrition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class CalculosActivity extends AppCompatActivity {

    private String CopyProteinas="",CopyGrasas="",CopyCarbohidratos="";
    private EditText jtxtGrasasC,jtxtProteinasC,jtxtCarbohidratosC;
    private TextView jtxtGrasasR,jtxtProteinasR,jtxtCarbohidratosR,jtxtCaloriasD,jtxtCaloriasC;
    private TextView jtxtCalorias, jtxtCarbohidratos, jtxtProteinas, jtxtGrasas;
    private CardView RegisterG,RegisterC,RegisterP;
    private ImageView jimgGrasas,jimgProteinas,jimgCarbohidratos;
    private ProgressDialog progressDialog;
    private Button jbtnRegistrar,jbtnResetear;

    float xGrasasR=0,xGrasasC=0,xProteinasC=0,xProteinasR=0,xCarboC=0,xCarbR=0;

    DatabaseReference Nutrition_DE_APP;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    DatabaseReference BASE_DE_DATOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        Nutrition_DE_APP = FirebaseDatabase.getInstance().getReference("Nutrition_DE_APP");

        jtxtGrasasC=findViewById(R.id.xtxtGrasasC);
        jtxtCarbohidratosC=findViewById(R.id.xtxtCarbohidratosC);
        jtxtProteinasC=findViewById(R.id.xtxtProteinasC);
        jtxtCaloriasC=findViewById(R.id.xtxtCaloriasC);
        jtxtCaloriasD=findViewById(R.id.xtxtCaloriasD);
        jtxtGrasasR=findViewById(R.id.xtxtGrasasR);
        jtxtProteinasR=findViewById(R.id.xtxtProteinasR);
        jtxtCarbohidratosR=findViewById(R.id.xtxtCarbohidratosR);
        jtxtCalorias=findViewById(R.id.idTVCalorias);
        jtxtCarbohidratos=findViewById(R.id.xtxtCarbohidratos);
        jtxtProteinas=findViewById(R.id.xtxtProteinas);
        jtxtGrasas=findViewById(R.id.xtxtGrasas);
        RegisterG=findViewById(R.id.xcdvRegisterG);
        RegisterC=findViewById(R.id.xcdvRegisterC);
        RegisterP=findViewById(R.id.xcdvRegisterP);
        jimgGrasas=findViewById(R.id.ximgGrasas);
        jimgProteinas=findViewById(R.id.ximgProteinas);
        jimgCarbohidratos=findViewById(R.id.ximgCarbo);
        jbtnRegistrar=findViewById(R.id.xbtnRegistrar);
        jbtnResetear=findViewById(R.id.xbtnRestaurar);

        Picasso.get()
                .load("https://www.webconsultas.com/sites/default/files/styles/wc_adaptive_image__small/public/articulos/tipos-grasas.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGrasas);
        Picasso.get()
                .load("https://upload.wikimedia.org/wikipedia/commons/6/60/Myoglobin.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgProteinas);
        Picasso.get()
                .load("https://mejorconsalud.as.com/wp-content/uploads/2013/07/alimentos-ricos-en-carbohidratos.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCarbohidratos);


        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("Nutrition_DE_APP");

        BASE_DE_DATOS.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String grasas = ""+snapshot.child("grasasc").getValue();
                    String caloriasc = ""+snapshot.child("caloriasc").getValue();
                    String caloriasd = ""+snapshot.child("caloriasd").getValue();
                    String proteinas = ""+snapshot.child("proteinasc").getValue();
                    String carbohidratos = ""+snapshot.child("carbohidratosc").getValue();
                    String copyproteinasc = ""+snapshot.child("copyproteinasc").getValue();
                    String copygrasas = ""+snapshot.child("copygrasasc").getValue();
                    String copycarbohidratos = ""+snapshot.child("copycarbohidratosc").getValue();

                    jtxtCaloriasC.setText(caloriasc);
                    jtxtCaloriasD.setText(caloriasd);
                    jtxtCalorias.setText(caloriasd);

                    CopyProteinas=copyproteinasc;
                    CopyGrasas=copygrasas;
                    CopyCarbohidratos=copycarbohidratos;

                    jtxtGrasasR.setText(grasas);
                    jtxtGrasas.setText(grasas);
                    jtxtProteinasR.setText(proteinas);
                    jtxtProteinas.setText(proteinas);
                    jtxtCarbohidratosR.setText(carbohidratos);
                    jtxtCarbohidratos.setText(carbohidratos);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        jbtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CalculosActivity.this,RegistrarMacroActivity.class));
            }
        });
        jbtnResetear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                HashMap<String, Object> result = new HashMap<>();

                result.put("proteinasc",CopyProteinas);
                result.put("grasasc",CopyGrasas);
                result.put("carbohidratosc",CopyCarbohidratos);

                Nutrition_DE_APP.child(user.getUid()).updateChildren(result)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(CalculosActivity.this, "Restaurado", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                    }
                });
            }
        });
        RegisterP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Proteinas
                xProteinasR=(float) Double.parseDouble(jtxtProteinasR.getText().toString());
                xProteinasC=(float) Double.parseDouble(jtxtProteinasC.getText().toString());

                float TotalP = xProteinasR-xProteinasC;

                HashMap<String, Object> result = new HashMap<>();

                result.put("proteinasc",TotalP);

                Nutrition_DE_APP.child(user.getUid()).updateChildren(result)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(CalculosActivity.this, "Datos Actualizados", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                    }
                });

            }
        });
        RegisterC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Carbohidratos
                xCarbR=(float) Double.parseDouble(jtxtCarbohidratosR.getText().toString());
                xCarboC=(float) Double.parseDouble(jtxtCarbohidratosC.getText().toString());

                float TotalC = xCarbR-xCarboC;

                HashMap<String, Object> result = new HashMap<>();

                result.put("carbohidratosc",TotalC);


                Nutrition_DE_APP.child(user.getUid()).updateChildren(result)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(CalculosActivity.this, "Datos Actualizados", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                    }
                });
            }
        });
        RegisterG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Grasas
                xGrasasR=(float) Double.parseDouble(jtxtGrasasR.getText().toString());
                xGrasasC=(float) Double.parseDouble(jtxtGrasasC.getText().toString());

                //Operaciones
                float Total = xGrasasR-xGrasasC;

                HashMap<String, Object> result = new HashMap<>();

                result.put("grasasc",Total);


                Nutrition_DE_APP.child(user.getUid()).updateChildren(result)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(CalculosActivity.this, "Datos Actualizados", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                    }
                });
            }
        });

    }
}