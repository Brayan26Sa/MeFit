package com.example.mefit.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

import io.alterac.blurkit.BlurLayout;

public class MusicActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView noMusicTextView;
    SearchView jtxtSearch;
    ArrayList<AudioModel> songslist = new ArrayList<>();
    ImageView jimgSearch,jimgMusicArts;
    LinearLayout jlnySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jlnySearch = findViewById(R.id.xlnySearch);
        recyclerView = findViewById(R.id.recycler_view);
        noMusicTextView = findViewById(R.id.no_songs_text);
        jtxtSearch = findViewById(R.id.xtxtSearch);
        jimgSearch = findViewById(R.id.ximgSearch);
        jimgMusicArts = findViewById(R.id.ximgMusicArts);

        jimgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jlnySearch.setVisibility(View.VISIBLE);
            }
        });

        jimgMusicArts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MusicActivity.this,MusicArtsActivity.class));
            }
        });


        if(checkPermission()==false){
            requestPermission();
            return;
        }

        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        };

        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";

        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
        while (cursor.moveToNext()){
            AudioModel songData = new AudioModel(cursor.getString(1),cursor.getString(0),cursor.getString(2));

            if(new File(songData.getPath()).exists())
                songslist.add(songData);
        }

        if(songslist.size()==0){
            noMusicTextView.setVisibility(View.VISIBLE);
        }else{
            //Recycler View
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new MusicAdapter(songslist,getApplicationContext()));
        }

    }
    boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(MusicActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE);
        if(result == PackageManager.PERMISSION_GRANTED){
            return true;
        }else {
            return false;
        }
    }
    void requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(MusicActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            Toast.makeText(MusicActivity.this, "Read permission is required", Toast.LENGTH_SHORT).show();
        }else
        ActivityCompat.requestPermissions(MusicActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(recyclerView!=null){
            recyclerView.setAdapter(new MusicAdapter(songslist,getApplicationContext()));
        }
    }
}