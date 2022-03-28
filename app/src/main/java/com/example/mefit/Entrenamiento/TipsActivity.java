package com.example.mefit.Entrenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.mefit.R;
import com.squareup.picasso.Picasso;

public class TipsActivity extends AppCompatActivity {

    ImageView jimgVolumen,jimgGeneral,jimgSubir,jimgDescanzo,jimgAnatomy,jimgEstimulo;
    ImageView jimgRM;
    ImageView jimgRPE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);


        jimgVolumen=findViewById(R.id.idIVVolumen);
        jimgGeneral=findViewById(R.id.idIVGeneral);
        jimgSubir=findViewById(R.id.idIVSubir);
        jimgDescanzo=findViewById(R.id.idIVDescanzo);
        jimgAnatomy=findViewById(R.id.idIVAnatomy);
        jimgEstimulo=findViewById(R.id.idIVEstimulo);
        jimgRM=findViewById(R.id.idIVRM);
        jimgRPE=findViewById(R.id.idIVRPE);

        Picasso.get()
                .load("https://hubdeportivo.com/wp-content/uploads/2021/03/rutina-de-12-semanas-para-ganar-volumen-y-fuerza-estiramientos.png")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgVolumen);
        Picasso.get()
                .load("https://www.sportlife.es/uploads/s1/76/30/13/5/article-estrategias-maxima-definicion-muscular-5873abc8450d7.jpeg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGeneral);
        Picasso.get()
                .load("https://1.bp.blogspot.com/-dY4CurR_omE/YPPhw8cAqvI/AAAAAAAAcJE/aWvTad_17rIfwpEneMcjv75nkjskCYrPwCLcBGAsYHQ/w454-h565/9812-_1_.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgSubir);
        Picasso.get()
                .load("https://countylinefitness.com/wp-content/uploads/2021/09/Young-Muscular-Fitness-Model-Near-Barbell-Bench.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgDescanzo);
        Picasso.get()
                .load("https://blogger.googleusercontent.com/img/a/AVvXsEjwC4KEk_1JLIAiMqgZmfgtuKCUmotkIGM7f2p_tXpJ9-eY4dcqIXaEqK8XDqiBVl4isxsStERNUA0FS_x_9XydyYI7JM5r1JSBwM20KbGifouUbnws02WqlwWVX3qkhGgoXqrcilBjlm-dMH8Yje1Lu7z8gs9O7DYsvrBq0OShqOFFOmhsJ4dzV0UN=w310-h388")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgAnatomy);
        Picasso.get()
                .load("https://64.media.tumblr.com/a4803f6e8a7bcbf618c116e76bc2bffd/tumblr_op6by6Bihj1r6obhzo1_1280.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgEstimulo);
        Picasso.get()
                .load("https://1.bp.blogspot.com/-_3RtcYiDrhI/YPPg8L3_bkI/AAAAAAAAcI8/hvhJCxYf9l82ZX7mXhdITB0_HB7yY1QYwCLcBGAsYHQ/w443-h462/9812.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgRM);
        Picasso.get()
                .load("https://1.bp.blogspot.com/-paca61uHfQc/YPPkinYBAfI/AAAAAAAAcJM/hymo1df5QeEcJtXoHrrQQRiOY3Fyd7g_ACLcBGAsYHQ/w497-h497/9812-_2_.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgRPE);
    }
}