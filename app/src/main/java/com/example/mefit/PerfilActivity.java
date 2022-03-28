package com.example.mefit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.Settings.CamPassActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;
import io.alterac.blurkit.BlurLayout;

public class PerfilActivity extends AppCompatActivity {

    ImageView xjpgPerfil,jimgEgreso;
    ImageView jimgPortada;
    TextView UidDato,jtxtUsuario,jtxtPeso,jtxtCorreo,jtxtPassword,jtxtEdad,jtxtTelefono, jtxtAnimal, jtxtTalla, jtxtIMC;
    TextView jtxtCamPass,jtxtPlanta;
    Button jbtnCerrar,jbtnActualizar;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    DatabaseReference BASE_DE_DATOS;

    private StorageReference ReferenciadeAlamacenamiento;
    private String RutaAlmacenamiento = "FotosDePerfil/*";

    //Permisos
    private static final int CODIGO_DE_SOLICITUD = 200;
    private static final int CODIGO_SELECCION_IMAGEN = 300;

    //Matices
    private String [] PermisosdeAlmacenamiento;
    private Uri imagen_uri;
    private String perfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        UidDato=findViewById(R.id.xtxtid);
        jbtnCerrar=findViewById(R.id.xbtnCerrar);
        xjpgPerfil=findViewById(R.id.xjpgUsuario);
        jimgPortada=findViewById(R.id.ximgPortada);
        jtxtUsuario=findViewById(R.id.xtxtUsuario);
        jtxtCorreo=findViewById(R.id.xtxtCorreo);
        jtxtPassword=findViewById(R.id.xtxtPassword);
        jtxtEdad=findViewById(R.id.xtxtEdad);
        jtxtTelefono=findViewById(R.id.xtxtTelefono);
        jtxtCamPass=findViewById(R.id.xtxtCamPass);
        jtxtPeso=findViewById(R.id.xtxtPeso);
        jtxtTalla=findViewById(R.id.xtxtTalla);
        jtxtIMC=findViewById(R.id.xtxtIMC);
        jtxtPlanta=findViewById(R.id.xtxtPlanta);



        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        ReferenciadeAlamacenamiento = FirebaseStorage.getInstance().getReference();
        PermisosdeAlmacenamiento = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        xjpgPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfil = "imagen";
                ActualizarFoto();
            }
        });


        jtxtCamPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PerfilActivity.this,CamPassActivity.class));
            }
        });

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("USUARIOS_DE_APP");

        BASE_DE_DATOS.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String nombre = ""+snapshot.child("nombre").getValue();
                    String correo = ""+snapshot.child("correo").getValue();
                    String pass = ""+snapshot.child("pass").getValue();
                    String edad = ""+snapshot.child("edad").getValue();
                    String telefono = ""+snapshot.child("telefono").getValue();
                    String peso = ""+snapshot.child("peso").getValue();
                    String talla = ""+snapshot.child("talla").getValue();
                    String imc = ""+snapshot.child("imc").getValue();
                    String planta = ""+snapshot.child("planta").getValue();

                    String imagen = ""+snapshot.child("imagen").getValue();
                    String portada = ""+snapshot.child("portada").getValue();

                    UidDato.setText(uid);
                    jtxtUsuario.setText(nombre);
                    jtxtCorreo.setText(correo);
                    jtxtPassword.setText(pass);
                    jtxtEdad.setText(edad);
                    jtxtTelefono.setText(telefono);
                    jtxtPeso.setText(peso);
                    jtxtTalla.setText(talla);
                    jtxtIMC.setText(imc);
                    jtxtPlanta.setText("El "+planta);


                    /*Mostrar foto Perfil*/

                    try{
                        Picasso.get().load(imagen).placeholder(R.drawable.kaleb).into(xjpgPerfil);
                        Picasso.get().load(imagen).placeholder(R.drawable.kaleb).into(jimgPortada);
                    }catch (Exception e){
                        Picasso.get().load(R.drawable.profile).into(xjpgPerfil);
                        Picasso.get().load(R.drawable.profile).into(jimgPortada);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        jbtnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(PerfilActivity.this,"Cecion cerrada",Toast.LENGTH_SHORT).show();

                gologin();
            }
        });
    }

    private void ActualizarFoto() {
        String [] opciones = {"Galeria"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccionar imagen de: ");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    //Seleccion de galeria
                    if(!ComprobarPermisos()){

                        SolicitarPermisos();
                    }else{
                        ElegirImagendeGaleria();
                    }
                }
            }
        });
        builder.create().show();
    }


    //Permiso de Almacenamiento
    private void SolicitarPermisos() {
        requestPermissions(PermisosdeAlmacenamiento,CODIGO_DE_SOLICITUD);
    }
    //Comprueba si los permisos estan habilitados
    private boolean ComprobarPermisos() {
        boolean resultado = ContextCompat.checkSelfPermission(PerfilActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                (PackageManager.PERMISSION_GRANTED);
        return resultado;
    }
    //Se llama cuando oorga o deniega el permiso
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case CODIGO_DE_SOLICITUD:{
                //Selecciona la galeria
                if(grantResults.length>0){
                    boolean EscrituradeAlmacenamientoAceptado = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(EscrituradeAlmacenamientoAceptado){
                        //Permiso que habilito
                        ElegirImagendeGaleria();
                    }else{
                        Toast.makeText(PerfilActivity.this, "Habilite el permiso", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    //Se llama el metodo cuando el usuario ya haya elegido la galeria
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            //De la imagen vamos a obtener
            if(requestCode == CODIGO_SELECCION_IMAGEN){
                imagen_uri = data.getData();
                SubirFoto(imagen_uri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    //Este metodo cambia la foto del usuario y actualiza la base de datos
    private void SubirFoto(Uri imagen_uri) {
        String RutadeArchivoyNombre = RutaAlmacenamiento + "" +perfil+""+user.getUid();
        StorageReference storageReference = ReferenciadeAlamacenamiento.child(RutadeArchivoyNombre);
        storageReference.putFile(imagen_uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isSuccessful());
                        Uri downloaduri = uriTask.getResult();
                        if(uriTask.isSuccessful()){
                            HashMap<String,Object> resultado = new HashMap<>();
                            resultado.put(perfil,downloaduri.toString());
                            BASE_DE_DATOS.child(user.getUid()).updateChildren(resultado)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(PerfilActivity.this, "La imagen ha sido cambiada", Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(PerfilActivity.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else {
                            Toast.makeText(PerfilActivity.this, "Algo salio mal", Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PerfilActivity.this, "Algo salio mal", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Este metodo abre la galeria
    private void ElegirImagendeGaleria() {
        Intent IntentGaleria = new Intent(Intent.ACTION_PICK);
        IntentGaleria.setType("image/*");
        startActivityForResult(IntentGaleria,CODIGO_SELECCION_IMAGEN);
    }
    private void gologin() {
        Intent i=new Intent(this,UsuarioActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

    }
}