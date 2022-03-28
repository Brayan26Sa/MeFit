package com.example.mefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        //Agregar animaciones
        Animation animacion1= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        LottieAnimationView xLogo=findViewById(R.id.xLogo);
        ImageView xLogoUniversal=findViewById(R.id.xLogoUni);

        xLogoUniversal.setAnimation(animacion2);
        xLogo.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,UsuarioActivity.class));
                overridePendingTransition(R.anim.trancicion_layout,R.anim.trancicion_layout_exit);
                finish();
            }
        },3000);
    }
}