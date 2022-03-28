package com.example.mefit.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mefit.R;
import com.example.mefit.UsuarioActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MusicPlayerActivity extends AppCompatActivity {

    TextView titleTV, currentTimeTV, totalTimeTV;
    SeekBar seekBar;
    ImageView pausePlay,nextBtn,previousBtn,musicIcon;
    ArrayList<AudioModel> songList;
    AudioModel currentSong;
    MediaPlayer mediaPlayer = MyMediaPlayer.getInstance();
    ImageView jimgArtOne,jimgArtTwo,jimgArtThree,jimgArtFor,jimgArtFive;
    String Url="";
    Animation ScaleUp,ScaleDown;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth firebaseAuth;
    DatabaseReference BASE_DE_DATOS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        titleTV = findViewById(R.id.song_title);
        currentTimeTV = findViewById(R.id.current_time);
        totalTimeTV = findViewById(R.id.total_time);
        seekBar = findViewById(R.id.seek_bar);
        pausePlay = findViewById(R.id.pause_play);
        nextBtn = findViewById(R.id.next);
        previousBtn = findViewById(R.id.previous);
        musicIcon = findViewById(R.id.music_icon_big);
        jimgArtOne = findViewById(R.id.ximgArtOne);
        jimgArtTwo = findViewById(R.id.ximgArtTwo);
        jimgArtThree = findViewById(R.id.ximgArtThree);
        jimgArtFor = findViewById(R.id.ximgArtFor);
        jimgArtFive = findViewById(R.id.ximgArtFive);

        ScaleUp= AnimationUtils.loadAnimation(MusicPlayerActivity.this,R.anim.scale_up);
        ScaleDown= AnimationUtils.loadAnimation(MusicPlayerActivity.this,R.anim.scale_down);

        firebaseAuth=FirebaseAuth.getInstance();

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("RECURCES_APP");

        BASE_DE_DATOS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String uid = ""+snapshot.child("uid").getValue();
                    String album = ""+snapshot.child("album").getValue();
                    String ArtOne = ""+snapshot.child("ArtOne").getValue();
                    String ArtTwo = ""+snapshot.child("ArtTwo").getValue();
                    String ArtThree = ""+snapshot.child("ArtThree").getValue();
                    String ArtFor = ""+snapshot.child("ArtFor").getValue();
                    String ArtFive = ""+snapshot.child("ArtFive").getValue();
                    String UriAlbum = ""+snapshot.child("UriAlbum").getValue();



                    Picasso.get().load(album).into(musicIcon);
                    Picasso.get().load(ArtOne).into(jimgArtOne);
                    Picasso.get().load(ArtTwo).into(jimgArtTwo);
                    Picasso.get().load(ArtThree).into(jimgArtThree);
                    Picasso.get().load(ArtFor).into(jimgArtFor);
                    Picasso.get().load(ArtFive).into(jimgArtFive);
                    Url=UriAlbum;



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        musicIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Url));
                startActivity(intent);
            }
        });

        songList = (ArrayList<AudioModel>) getIntent().getSerializableExtra("LIST");

        setResourcesWithMusic();

        MusicPlayerActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer!=null){
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    currentTimeTV.setText(convertToMMSS(mediaPlayer.getCurrentPosition()+""));

                    if(mediaPlayer.isPlaying()){
                        pausePlay.setAnimation(ScaleUp);
                        pausePlay.setAnimation(ScaleDown);
                        pausePlay.setImageResource(R.drawable.ic_pause);
                    }else{
                        pausePlay.setAnimation(ScaleUp);
                        pausePlay.setAnimation(ScaleDown);
                        pausePlay.setImageResource(R.drawable.ic_play);
                    }
                }
                new Handler().postDelayed(this,100);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(mediaPlayer != null && b){
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    void setResourcesWithMusic(){
        currentSong = songList.get(MyMediaPlayer.currentIndex);

        titleTV.setText(currentSong.getTitle());

        totalTimeTV.setText(convertToMMSS(currentSong.getDuration()));

        pausePlay.setOnClickListener(view -> pausePlay());
        nextBtn.setOnClickListener(view -> playNextSong());
        previousBtn.setOnClickListener(view -> playPreviousSong());

        playMusic();
    }
    private void playMusic(){
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(currentSong.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private void playNextSong(){

        if(MyMediaPlayer.currentIndex == songList.size()-1)
            return;
        MyMediaPlayer.currentIndex +=1;
        mediaPlayer.reset();
        setResourcesWithMusic();

    }
    private void playPreviousSong(){

        if(MyMediaPlayer.currentIndex == 0)
            return;
        MyMediaPlayer.currentIndex -=1;
        mediaPlayer.reset();
        setResourcesWithMusic();

    }
    private void pausePlay(){

        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }
    public static String convertToMMSS(String duration){
        Long millis = Long.parseLong(duration);
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
    }
    public void irDeezer(View view){
        Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://deezer.page.link/22m82nvTvC5Qp2X76"));
        view.setBackground(getResources().getDrawable(R.drawable.popoption));
        startActivity(i);
    }
    public void irYoutubeMusic(View view){
        Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://music.youtube.com/playlist?list=PLQov2x2vMsTVCjvnxit2oN2SntH9M1Xab&feature=share"));
        view.setBackground(getResources().getDrawable(R.drawable.popoption));
        startActivity(i);
    }
    public void irSpotify(View view){
        Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/playlist/2YVkFuJ16fSv5sQbPP3a95?si=ofe-6wE5RsulbnrL8-PVDw&utm_source=copy-link&dl_branch=1"));
        view.setBackground(getResources().getDrawable(R.drawable.popoption));
        startActivity(i);
    }
}