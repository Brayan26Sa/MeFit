package com.example.mefit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.Music.TrackFiles;
import com.example.mefit.Settings.TapOnTapActivity;

import java.util.ArrayList;

public class IndexActivity extends AppCompatActivity {

    ArrayList<TrackFiles> trackFilesArrayList = new ArrayList<>();
    TextView jbtnRegistrar;
    MediaPlayer mp;
    CardView jcdvIniciar;
    ImageView jimgIpn,jimgLogo;
    SoundPool sp;
    int sonido_de_reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jbtnRegistrar=findViewById(R.id.xbtnRegistrar);
        jcdvIniciar=findViewById(R.id.xcdvIniciar);
        jimgIpn=findViewById(R.id.ximgIpn);
        jimgLogo=findViewById(R.id.ximgLogo);

        jbtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IndexActivity.this,EjecutableActivity.class));
                mp.stop();
            }
        });

        jcdvIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IndexActivity.this, "La tecnica al servicio de la patria", Toast.LENGTH_SHORT).show();
            }
        });

        jimgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IndexActivity.this, TapOnTapActivity.class));
            }
        });

        poppulateFiles();

    }

    private void poppulateFiles() {
        TrackFiles trackFiles = new TrackFiles("Himno IPN","IPN",
                R.drawable.adele);
        trackFilesArrayList.add(trackFiles);
        TrackFiles trackFiles1 = new TrackFiles("Himno IPN","IPN",
                R.drawable.adele);
        trackFilesArrayList.add(trackFiles1);
        TrackFiles trackFiles2 = new TrackFiles("Himno IPN","IPN",
                R.drawable.adele);
        trackFilesArrayList.add(trackFiles2);
    }

    public void AudioMediaPlayer(View view){
        mp = MediaPlayer.create(this, R.raw.mambo);
        mp.start();
    }
}