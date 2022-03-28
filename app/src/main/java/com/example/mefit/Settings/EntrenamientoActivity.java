package com.example.mefit.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.mefit.Entrenamiento.HipertrophyActivity;
import com.example.mefit.Entrenamiento.RPEYRMActivity;
import com.example.mefit.Entrenamiento.TipsActivity;
import com.example.mefit.R;
import com.squareup.picasso.Picasso;

public class EntrenamientoActivity extends AppCompatActivity {

    ImageView jimgFuerza,jimgHipertrofia,jimgDefinicion, jimgPerderP,jimgTips;
    ImageView jimgPecho, jimgEspalda, jimgPierna, jimgBrazos, jimgAbdomen, jimgGluteos, jimgHombros;
    ImageView jimgRPEYRM, jimgRPEORM;
    CardView jcdvHiper,jcdvTips,jcdvRPEYRM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);


        jimgFuerza=findViewById(R.id.idximgFuerza);
        jimgHipertrofia=findViewById(R.id.idximgHiper);
        jimgDefinicion=findViewById(R.id.idximgDefinicion);
        jimgPerderP=findViewById(R.id.idximgPerder);
        jimgTips=findViewById(R.id.idximgTips);
        jimgPecho=findViewById(R.id.idximgPecho);
        jimgEspalda=findViewById(R.id.idximgEspalda);
        jimgPierna=findViewById(R.id.idximgPiernas);
        jimgBrazos=findViewById(R.id.idximgBrazos);
        jimgAbdomen=findViewById(R.id.idximgAbdomen);
        jimgGluteos=findViewById(R.id.idximgGluteos);
        jimgRPEYRM=findViewById(R.id.idIVRPEYRM);
        jimgRPEORM=findViewById(R.id.idIVRegistrarROP);
        jcdvHiper=findViewById(R.id.xcdvHiper);
        jcdvRPEYRM=findViewById(R.id.idCDVRPEYRM);
        jcdvTips=findViewById(R.id.xcdvTips);

        Picasso.get()
                .load("https://lh3.googleusercontent.com/-xjn2n0dC4S0/Yc31MI2VNLI/AAAAAAAAebI/I-tuQle4VvImek1l2Zym9af1n3Ik0iPnwCNcBGAsYHQ/w557-h314/1640887599246335-0.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgHipertrofia);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-FfNkEXdUrjw/Yc9uWEjhTLI/AAAAAAAAee4/yQB0sPKeJVQSHHlLOsuxZlOLFP3xOSTVACNcBGAsYHQ/s1600/1640984150606299-0.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgDefinicion);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-mau1uxDeGGo/Yc9uVHyNEyI/AAAAAAAAeew/_3qevAj-NVsOS_AF4_Jh9njoppFAg2Q3gCNcBGAsYHQ/s1600/1640984146564527-2.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgFuerza);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-IZoNfZZCEBY/Yc9uVoFMGUI/AAAAAAAAee0/UjqlcOJZ0BYZPqXrt_TwURK3YZT60QpxACNcBGAsYHQ/s1600/1640984148906482-1.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPerderP);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-vQ2N_4TSHyk/YdEB79pdeRI/AAAAAAAAegU/6TNWM6Upf1oPi1j9A7MhpYbGHFNP9qptwCNcBGAsYHQ/s1600/1641087469928429-0.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPecho);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-DCWSn4yLepY/Yc-0VAjpvsI/AAAAAAAAefQ/SC8Dc45ntrU1shW_ytG79dP-iSp4XoWQQCNcBGAsYHQ/s1600/1641002067128115-4.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgEspalda);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-hNPGq_iboN4/Yc-0WFpgU7I/AAAAAAAAefU/p-i5JaV2QPgtnbB04t-VD621PLDPVJFvQCNcBGAsYHQ/s1600/1641002068872544-3.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPierna);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-et_4ErNkTDk/YdEB7V_NZjI/AAAAAAAAegQ/DkmyCzYFh3sowX4ozFEi0MAeAOa0MitegCNcBGAsYHQ/s1600/1641087467931191-1.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgBrazos);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-N-J7fQ-hBUc/YdEXSeIEQGI/AAAAAAAAegk/yvOQc2rtPTIIoCO37S5lvhsQe45k7N_GACNcBGAsYHQ/s1600/1641092935791807-0.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgAbdomen);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-a-G5iIj4JP8/Yc-0Xus8vWI/AAAAAAAAefc/Ok2tW_ffOtAfQj-m0kRVaz0UwFconi7IwCNcBGAsYHQ/s1600/1641002076018446-1.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGluteos);
        Picasso.get()
                .load("https://lh3.googleusercontent.com/-a-G5iIj4JP8/Yc-0Xus8vWI/AAAAAAAAefc/Ok2tW_ffOtAfQj-m0kRVaz0UwFconi7IwCNcBGAsYHQ/s1600/1641002076018446-1.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgTips);
        Picasso.get()
                .load("https://blogger.googleusercontent.com/img/a/AVvXsEgXFmCWq8tk5sy6rXGhN482jd7HQqZ1RMqc6ArkjNvoqTVCQZGAB0L74qa1nK8YiZJw7JHNpLPJ2AUqLtyicTfsfFB346wPJeaw2nLydFoaa_S35nuWT2UtFSqA9LygwRmkzk-Z3fkP0YLebZs5l3aNrbtuO8-U3WjnAW1YwaWRT-r_LzphHcdt8P6W")
                .error(R.drawable.ic_logouno)
                .into(jimgRPEYRM);
        Picasso.get()
                .load("https://blogger.googleusercontent.com/img/a/AVvXsEh81X69SLLzolbHbi0vg8N2X33nLQkWctNTgIQdQHTEOI2df5zOngM7C2ui4hqofwdGryqqWUaRdpWJvxib53MtpofjlvRIJVHTBfP1y186hRYygWnAQHxj_On9SlqxmSDBSI6cq0pNFVRfNeZbFe6A7KxeSVdxgUM4dshGKGNIvoKSvI84c1j_uuyQ")
                .error(R.drawable.ic_logouno)
                .into(jimgRPEORM);

        jcdvHiper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntrenamientoActivity.this, HipertrophyActivity.class));
            }
        });
        jcdvRPEYRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntrenamientoActivity.this, RPEYRMActivity.class));
            }
        });
        jcdvTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntrenamientoActivity.this, TipsActivity.class));
            }
        });

    }
}