package com.example.mefit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegistrarActivity extends AppCompatActivity {

    EditText jtxtContraseña,jtxtCorreo,jtxtNombre,jtxtTelefono,jtxtEdad,jtxtPeso,jtxtTalla,jtxtIMC,jtxtNSS,jtxtPlanta;
    CardView jbtnRegistrar;
    CardView jcdvSiguienteUno,jcdvSiguienteDos,jcdvSiguienteTres;
    CardView jcdvRUno,jcdvRDos;
    Animation ScaleUp,ScaleDown,fade_transition;
    int Password;

    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        jcdvRUno = findViewById(R.id.xcdvROne);
        jcdvRDos = findViewById(R.id.xcdvRTwo);
        jcdvSiguienteUno = findViewById(R.id.xcdvSiguienteUno);
        jcdvSiguienteDos = findViewById(R.id.xcdvSiguienteDos);
        jtxtContraseña=findViewById(R.id.xtxtContraseña);
        jtxtCorreo=findViewById(R.id.xtxtCorreo);
        jtxtNombre=findViewById(R.id.xtxtNombre);
        jtxtTelefono=findViewById(R.id.xtxtTelefono);
        jtxtEdad=findViewById(R.id.xtxtEdad);
        jtxtPeso=findViewById(R.id.xtxtPeso);
        jtxtTalla=findViewById(R.id.xtxtTalla);
        jtxtIMC=findViewById(R.id.xtxtIMC);
        jtxtNSS=findViewById(R.id.xtxtNSS);
        jtxtPlanta=findViewById(R.id.xtxtPlanta);
        jbtnRegistrar=findViewById(R.id.xbtnRegister);

        ScaleUp= AnimationUtils.loadAnimation(RegistrarActivity.this,R.anim.scale_up);
        ScaleDown= AnimationUtils.loadAnimation(RegistrarActivity.this,R.anim.scale_down);
        fade_transition = AnimationUtils.loadAnimation(RegistrarActivity.this,R.anim.fade_transition);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(RegistrarActivity.this);

        jcdvSiguienteUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jcdvRDos.startAnimation(fade_transition);
                jcdvRDos.setVisibility(View.VISIBLE);
            }
        });
        jcdvSiguienteDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jcdvRUno.startAnimation(fade_transition);
                jcdvRUno.setVisibility(View.VISIBLE);
            }
        });

        jbtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jbtnRegistrar.startAnimation(ScaleUp);
                jbtnRegistrar.startAnimation(ScaleDown);

                String mail=jtxtCorreo.getText().toString();
                String pass=jtxtContraseña.getText().toString();

                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    jtxtCorreo.setError("Correo no valido");
                    jtxtCorreo.setFocusable(true);
                }else if(pass.length()<6){
                    jtxtContraseña.setError("Contraseña debe ser mayor a 6");
                    jtxtContraseña.setFocusable(true);
                }else {
                    Registrar(mail,pass);
                }
            }
        });

    }
    private void Registrar(String mail, String pass) {
        progressDialog.setTitle("Registrando");
        progressDialog.setMessage("Espere por favor...");
        progressDialog.setCancelable(true);
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(mail,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            FirebaseUser user=firebaseAuth.getCurrentUser();
                            //Verificar correo electronico
                            user.sendEmailVerification();
                            //Aqui van los datos que queremos registrar
                            assert user!=null;
                            String uid=user.getUid();
                            String nombre=jtxtNombre.getText().toString();
                            String correo=jtxtCorreo.getText().toString();
                            String pass=jtxtContraseña.getText().toString();
                            String edad=jtxtEdad.getText().toString();
                            String telefono=jtxtTelefono.getText().toString();
                            String peso=jtxtPeso.getText().toString();
                            String talla=jtxtTalla.getText().toString();
                            String imc=jtxtIMC.getText().toString();
                            String nss=jtxtNSS.getText().toString();
                            String planta=jtxtPlanta.getText().toString();


                            HashMap<Object,String> DatosUsuario = new HashMap<>();

                            DatosUsuario.put("uid",uid);
                            DatosUsuario.put("nombre",nombre);
                            DatosUsuario.put("correo",correo);
                            DatosUsuario.put("pass",pass);
                            DatosUsuario.put("edad",edad);
                            DatosUsuario.put("telefono",telefono);
                            DatosUsuario.put("peso",peso);
                            DatosUsuario.put("talla",talla);
                            DatosUsuario.put("imc",imc);
                            DatosUsuario.put("nss",nss);
                            DatosUsuario.put("planta",planta);
                            DatosUsuario.put("imagen","");
                            DatosUsuario.put("portada","");


                            FirebaseDatabase database= FirebaseDatabase.getInstance();
                            DatabaseReference reference=database.getReference("USUARIOS_DE_APP");
                            reference.child(uid).setValue(DatosUsuario);

                            Toast.makeText(RegistrarActivity.this,"Se registro exitosamente",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrarActivity.this,UsuarioActivity.class));
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(RegistrarActivity.this,"Algo a salido mal",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                progressDialog.dismiss();
                Toast.makeText(RegistrarActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}