package com.example.mefit.Notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.mefit.MainActivity;
import com.example.mefit.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Random;

public class Fcm extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s){
        super.onNewToken(s);
        Log.e("tokenMefit","mi token es: "+s);
        guardartoken(s);
    }
    private void guardartoken(String s){
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("tokenMefit");
        ref.child("TokenUser").setValue(s);
    }
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();

        if(remoteMessage.getData().size()>0){
            String titulo=remoteMessage.getData().get("Hola bienbenido");
            String detalle=remoteMessage.getData().get("detalle");
            String foto=remoteMessage.getData().get("foto");

            mayorqueoreo(titulo,detalle,foto);

        }
    }
    private void mayorqueoreo(String titulo,String detalle,String foto){
        String id="Mensaje";
        NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,id);
        NotificationChannel nc=new NotificationChannel(id,"nuevo",NotificationManager.IMPORTANCE_HIGH);
        nc.setShowBadge(true);
        nm.createNotificationChannel(nc);
        try{
            Bitmap imf_foto= Picasso.get().load(foto).get();

            builder.setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle(titulo)
                    .setSmallIcon(R.drawable.ic_logouno)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(imf_foto).bigLargeIcon(null))
                    .setContentText(detalle)
                    .setContentIntent(clickNoti())
                    .setContentInfo("nuevo");
            Random random=new Random();
            int idNotify=random.nextInt(8000);

            assert nm !=null;
            nm.notify(idNotify,builder.build());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public PendingIntent clickNoti(){
        Intent nf=new Intent(getApplicationContext(), MainActivity.class);
        nf.putExtra("color","rojo");
        nf.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        return PendingIntent.getActivity(this,0,nf,0);
    }
}
