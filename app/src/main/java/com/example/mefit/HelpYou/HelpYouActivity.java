package com.example.mefit.HelpYou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mefit.R;
import com.squareup.picasso.Picasso;

public class HelpYouActivity extends AppCompatActivity {

    TextView jtxtInfoDeprecion,jtxtDeprecion;
    ImageView jimgDeprecion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_you);


        jtxtDeprecion = findViewById(R.id.xtxtDeprecion);
        jtxtInfoDeprecion = findViewById(R.id.xtxtInfoDeprecion);
        jimgDeprecion = findViewById(R.id.ximgDeprecion);

        jtxtDeprecion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jtxtInfoDeprecion.setText("Algunos sintomas de la depresión son: \n"+
                        "- Sentimientos de tristesa, ganas de llorar o vacio profundo.\n"+
                        "- Arrebatos de enojo, irritabilidad o frustración.\n"+
                        "- Perdida de interes o pación por la mayoria de las actividades habituales.\n"+
                        "- Alteraciones del sueño, como insomnio o dormir demaciado.\n"+
                        "- Cansancio y falta de energía, todo requiere de mucho esfuerzo.\n"+
                        "- Lentitud para razonar, hablar o hacer cualquier movimiento.\n"+
                        "\n"+"\n"+
                        "ACUDE DE IMEDIATO CON UN ESPECIALISTA SI TIENES ALGUNO DE ESTOS SINTOMAS O AYUDA A QUIEN" +
                        "LOS TENGA");
                jtxtInfoDeprecion.setVisibility(View.VISIBLE);

                Picasso.get().load("https://www.hopkinsmedicine.org/sebin/l/d/depression_2_pyramid.jpg")
                        .error(R.drawable.ic_nowifi)
                        .into(jimgDeprecion);
            }
        });
    }
}