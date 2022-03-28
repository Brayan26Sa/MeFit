package com.example.mefit.Music;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MusicService extends Service {

    private IBinder mBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Bind","Method");
        return mBinder;
    }
    public class MyBinder extends Binder{

        MusicService getService(){
            return MusicService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("OnStart","Method");
        return super.onStartCommand(intent, flags, startId);
    }
}
