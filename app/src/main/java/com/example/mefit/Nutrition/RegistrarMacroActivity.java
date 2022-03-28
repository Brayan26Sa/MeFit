package com.example.mefit.Nutrition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mefit.R;
import com.example.mefit.RegistrarActivity;
import com.example.mefit.UsuarioActivity;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegistrarMacroActivity extends AppCompatActivity {

    private EditText jtxtCaloriasD,jtxtCaloriasC,jtxtProteinasC,jtxtGrasasC,jtxtCarbohidratosC;
    private Button jbtnVale;

    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_macro);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jtxtCaloriasD=findViewById(R.id.xtxtCaloriasD);
        jtxtCaloriasC=findViewById(R.id.xtxtCaloriasC);
        jtxtProteinasC=findViewById(R.id.xtxtProteinasC);
        jtxtGrasasC=findViewById(R.id.xtxtGrasasC);
        jtxtCarbohidratosC=findViewById(R.id.xtxtCarbohidratosC);
        jbtnVale=findViewById(R.id.xbtnVale);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(RegistrarMacroActivity.this);

        jbtnVale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Registrar();
            }
        });
    }

    private void Registrar() {
        progressDialog.setTitle("Registrando");
        progressDialog.setMessage("Espere por favor...");
        progressDialog.setCancelable(true);
        progressDialog.show();
        progressDialog.dismiss();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        assert user!=null;
        String uid=user.getUid();

        String caloriasd=jtxtCaloriasD.getText().toString();
        String caloriasc=jtxtCaloriasC.getText().toString();
        String proteinasc=jtxtProteinasC.getText().toString();
        String grasasc=jtxtGrasasC.getText().toString();
        String carbohidratosc=jtxtCarbohidratosC.getText().toString();

        HashMap<Object,String> DatosUsuario = new HashMap<>();

        DatosUsuario.put("uid",uid);
        DatosUsuario.put("caloriasd",caloriasd);
        DatosUsuario.put("caloriasc",caloriasc);
        DatosUsuario.put("proteinasc",proteinasc);
        DatosUsuario.put("copyproteinasc",proteinasc);
        DatosUsuario.put("grasasc",grasasc);
        DatosUsuario.put("copygrasasc",grasasc);
        DatosUsuario.put("carbohidratosc",carbohidratosc);
        DatosUsuario.put("copycarbohidratosc",carbohidratosc);

        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("Nutrition_DE_APP");
        reference.child(uid).setValue(DatosUsuario);
        Toast.makeText(RegistrarMacroActivity.this,"Se registro exitosamente",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegistrarMacroActivity.this, CalculosActivity.class));
    }
}