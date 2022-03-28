package com.example.mefit.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.R;
import com.example.mefit.UsuarioActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class CamPassActivity extends AppCompatActivity {

    TextView jtxtCorreoActual,jtxtContraseñaActual;
    EditText jtxtActualPass,jtxtNewPass;
    Button jbtnActualizar;
    DatabaseReference USUARIOS_DE_APP;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_pass);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jtxtCorreoActual=findViewById(R.id.xtxtCorreoActual);
        jtxtContraseñaActual=findViewById(R.id.xtxtContraseñaActual);
        jtxtActualPass=findViewById(R.id.xtxtActualPass);
        jtxtNewPass=findViewById(R.id.xtxtNewPass);
        jbtnActualizar=findViewById(R.id.xbtnActualizar);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        USUARIOS_DE_APP = FirebaseDatabase.getInstance().getReference("USUARIOS_DE_APP");
        progressDialog = new ProgressDialog(CamPassActivity.this);

        //Consultamos el correo y contraseña del Usuario
        Query query = USUARIOS_DE_APP.orderByChild("correo").equalTo(user.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    //Obtenemos los valores
                    String correo = ""+ds.child("correo").getValue();
                    String pass = ""+ds.child("pass").getValue();

                    //Sentremos los datos en el textView
                    jtxtCorreoActual.setText(correo);
                    jtxtContraseñaActual.setText(pass);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Creamos el evento para cambiar la contraseña
        jbtnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PASS_ANTERIOR = jtxtActualPass.getText().toString().trim();
                String NUEVO_PASS = jtxtNewPass.getText().toString().trim();

                //Creamos las siguientes condiciones
                if(TextUtils.isEmpty(PASS_ANTERIOR)){
                    Toast.makeText(CamPassActivity.this,"El campo contraseña actual esta vacio",Toast.LENGTH_SHORT).show();

                }if (TextUtils.isEmpty(NUEVO_PASS)){
                    Toast.makeText(CamPassActivity.this,"El campo contraseña actual esta vacio",Toast.LENGTH_SHORT).show();
                }if (!NUEVO_PASS.equals("") && NUEVO_PASS.length() >= 6){
                    //Se ejecuta el metodo para actializar password
                    CAMBIO_DE_PASS(PASS_ANTERIOR,NUEVO_PASS);
                }else {
                    jtxtNewPass.setError("La contraseña deve ser mayor a 6 caracteres");
                    jtxtNewPass.setFocusable(true);
                }
            }
        });
    }
    private void CAMBIO_DE_PASS(String pass_anterior, String nuevo_pass) {
        progressDialog.show();
        progressDialog.setTitle("Actualizando");
        progressDialog.setMessage("Espere por favor");
        user = FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(),pass_anterior);
        user.reauthenticate(authCredential)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        user.updatePassword(nuevo_pass)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        progressDialog.dismiss();
                                        String value = jtxtNewPass.getText().toString().trim();
                                        HashMap<String, Object> result = new HashMap<>();
                                        result.put("pass",value);
                                        USUARIOS_DE_APP.child(user.getUid()).updateChildren(result)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        Toast.makeText(CamPassActivity.this, "Contraseña Actualizada", Toast.LENGTH_SHORT).show();
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                progressDialog.dismiss();
                                            }
                                        });
                                        //Se cierra cecion
                                        firebaseAuth.signOut();
                                        startActivity(new Intent(CamPassActivity.this, UsuarioActivity.class));
                                        finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        progressDialog.dismiss();
                                    }
                                });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(CamPassActivity.this, "La contraseña actual no es correcta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}