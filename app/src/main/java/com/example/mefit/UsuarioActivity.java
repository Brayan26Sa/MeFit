package com.example.mefit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.mefit.Utility.NetworkChangeListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioActivity extends AppCompatActivity {

    LinearLayout jimgRegresar;
    EditText jtxtMail,jtxtPassword;
    TextView jtxtNoContra,jtxtNoRegister;
    ImageView jbtnIniciar;
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();
    Animation ScaleUp,ScaleDown;

    //Declaracion de variables Firebase
    AwesomeValidation awesomeValidation;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        jtxtMail=findViewById(R.id.xtxtCorreo);
        jtxtPassword=findViewById(R.id.xtxtContraseña);
        jtxtNoContra=findViewById(R.id.xtxtNocontra);
        jtxtNoRegister=findViewById(R.id.xtxtNoregister);
        jbtnIniciar=findViewById(R.id.xbtnIniciar);

        firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.xtxtCorreo, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);
        awesomeValidation.addValidation(this,R.id.xtxtContraseña,".{6,}",R.string.invalid_password);

        progressDialog = new ProgressDialog(UsuarioActivity.this); /*INICIALIZAMOS EL PROGRESS DIALOG*/
        dialog = new Dialog(UsuarioActivity.this);                 /*INICIALIZAMOS EL DIALOG*/

        //Evitar cerrar seción
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null){
            irahome();
        }

        ScaleUp= AnimationUtils.loadAnimation(UsuarioActivity.this,R.anim.scale_up);
        ScaleDown= AnimationUtils.loadAnimation(UsuarioActivity.this,R.anim.scale_down);


        //Asignamos un evento al boton Iniciar
        jbtnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jbtnIniciar.startAnimation(ScaleUp);
                jbtnIniciar.startAnimation(ScaleDown);

                if(awesomeValidation.validate()){
                    String correo = jtxtMail.getText().toString();
                    String pass = jtxtPassword.getText().toString();

                    firebaseAuth.signInWithEmailAndPassword(correo,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                irahome();
                            }else{
                                Toast.makeText(UsuarioActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Dialog_No_Inicio();
                                //String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                                //dameToastdeerror(errorCode);
                            }
                        }
                    });
                }
            }
        });

        jtxtNoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UsuarioActivity.this,RegistrarActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onStart(){
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        super.onStart();
    }
    @Override
    protected void onStop(){
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }
    private void irahome() {
        progressDialog.dismiss(); //El progress se cierra
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(!user.isEmailVerified()){
            Toast.makeText(UsuarioActivity.this, "Verifica tu correo", Toast.LENGTH_SHORT).show();
        }else{
            //Cuando iniciemos secion nos manda a la actividad
            startActivity(new Intent(UsuarioActivity.this, EjecutableActivity.class));
            assert user != null; //Afirmamos que el usuario no es null
            Toast.makeText(UsuarioActivity.this, "Hola!,  Bienvenido "+user.getEmail(),Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    //Mostramos el mensaje de error
    private void Dialog_No_Inicio(){
        Button ok_no_inicio;

        dialog.setContentView(R.layout.no_sesion);

        ok_no_inicio=dialog.findViewById(R.id.ok_no_inicio);

        ok_no_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }


}