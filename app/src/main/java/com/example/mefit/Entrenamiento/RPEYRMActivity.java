package com.example.mefit.Entrenamiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.R;
import com.squareup.picasso.Picasso;

public class RPEYRMActivity extends AppCompatActivity {

    private CardView jcdvCalcular,jcdvCalcularRPE;
    private ImageView jimgDynamicPicture,jimgDynamicPictureRPE;
    private TextView jtxtMensaje, jtxtResultado,jtxtResultadoRPE,jtxtMasa,jtxtMasaLB,jtxtResultadoMasa,jtxtResultadoMasaLB;
    private EditText jtxtPesoCarga,jtxtMasaRPE,jtxtRepeticiones,jtxtRPE;
    private Animation ScaleUp,ScaleDown;
    private SwitchCompat jwhSwitch,jwhSwitchLB;
    private float xPeso=0,xRepeticiones=0,xMasa=0,xMasaLB=0,xRPE=0,xNumRPE=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpeyrmactivity);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jcdvCalcular=findViewById(R.id.xcdvCalcular);
        jcdvCalcularRPE=findViewById(R.id.xcdvCalcularRPE);
        jtxtMensaje=findViewById(R.id.xtxtMensaje);
        jtxtPesoCarga=findViewById(R.id.xtxtPesoCarga);
        jtxtRPE=findViewById(R.id.xtxtRPE);
        jtxtResultado=findViewById(R.id.xtxtResultado);
        jtxtResultadoRPE=findViewById(R.id.xtxtResultadoRPE);
        jtxtMasa=findViewById(R.id.xtxtMasa);
        jtxtMasaRPE=findViewById(R.id.xtxtMasaRPE);
        jtxtMasaLB=findViewById(R.id.xtxtMasaLB);
        jtxtRepeticiones=findViewById(R.id.xtxtRepeticiones);
        jtxtResultadoMasa=findViewById(R.id.xtxtResultadoMasa);
        jtxtResultadoMasaLB=findViewById(R.id.xtxtResultadoMasaLB);
        jimgDynamicPicture=findViewById(R.id.ximgDynamicPicture);
        jimgDynamicPictureRPE=findViewById(R.id.ximgDynamicPictureRPE);
        jwhSwitch=findViewById(R.id.xswhConvercion);
        jwhSwitchLB=findViewById(R.id.xswhConvercionLB);

        jwhSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xMasa=(float) Double.parseDouble(jtxtMasa.getText().toString());
                if(jwhSwitch.isChecked()){
                    float Total=Math.round(xMasa/(float) 2.205);
                    jtxtResultadoMasa.setText(Total+"kg");
                }else{
                    float Total=xMasa*1;
                    jtxtResultadoMasa.setText(Total+"lb");
                }
            }
        });

        jwhSwitchLB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xMasaLB=(float) Double.parseDouble(jtxtMasaLB.getText().toString());
                if(jwhSwitchLB.isChecked()){
                    float Total=Math.round(xMasaLB*(float) 2.205);
                    jtxtResultadoMasaLB.setText(Total+"lb");
                }else{
                    float Total=xMasaLB*1;
                    jtxtResultadoMasaLB.setText(Total+"kg");
                }
            }
        });

        jcdvCalcularRPE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xRPE= (float) Double.parseDouble(jtxtMasaRPE.getText().toString());
                xNumRPE= (float) Double.parseDouble(jtxtRPE.getText().toString());
                if(xRPE<=0){
                    Toast.makeText(getApplicationContext(), "Pon una cantidad valida", Toast.LENGTH_SHORT).show();
                }else{
                    float Total=(xRPE-xNumRPE)+xRPE;

                    jtxtResultadoRPE.setText("En tu ultima serie tienes que hacer "+ Total + " repeticiones con un peso X, " +
                            "de tal forma que las puedas hacer exactas y consecutivas hasta llegar al fallo." +"\n"+"\n"+
                            "Puedes ir aumentando y disminullendo el peso hasta que lo logres (Si no logras las "+ Total +" repeticiones " +
                            "exactas para esta serie, sigue intentando en la siguiente rutina hasta que lo logres)."+"\n"+"\n"+
                            "Te aconsejo que anotes el peso , para que a la otra sea mas facil encontrar tu peso ideal");

                    Picasso.get()
                            .load("https://www.stay-trained.com/wp-content/uploads/2018/04/Supplement-Fitness.jpg")
                            .error(R.mipmap.ic_launcheruno)
                            .into(jimgDynamicPictureRPE);
                }
            }
        });

        jcdvCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xPeso= (float) Double.parseDouble(jtxtPesoCarga.getText().toString());
                xRepeticiones=(float) Double.parseDouble(jtxtRepeticiones.getText().toString());
                if(xRepeticiones <= 0 && xPeso<= 0){
                    jtxtResultado.setText("Error");

                    Picasso.get()
                            .load("https://definicion.de/wp-content/uploads/2009/02/error.png")
                            .error(R.mipmap.ic_launcheruno)
                            .into(jimgDynamicPicture);


                }if(xRepeticiones<=10){
                    //Formula para repeticiones menores a 10
                    float Total = (float) (102.78-2.78*xRepeticiones);
                    jtxtResultado.setText("");
                    jtxtResultado.setText("%1RM= "+Total);
                    //Limpiar cajas de texto
                    jtxtRepeticiones.setText("");
                    jtxtPesoCarga.setText("");

                    Picasso.get()
                            .load("https://orientacion.universia.edu.pe/imgs2011/imagenes/metas-2020_01_18_190213@2x.jpg")
                            .error(R.mipmap.ic_launcheruno)
                            .into(jimgDynamicPicture);

                }if(xRepeticiones>=10){
                    //Formula para repeticiones mayores a 10
                    float Total = (float) ((float) xPeso*(1+0.025*xRepeticiones));
                    jtxtResultado.setText("");
                    jtxtResultado.setText("%1RM= "+Total);
                    //Limpiar cajas de texto
                    jtxtRepeticiones.setText("");
                    jtxtPesoCarga.setText("");

                    Picasso.get()
                            .load("http://cursodeadministraciondeempresas.com/wp-content/uploads/2020/09/las-metas.jpg")
                            .error(R.mipmap.ic_launcheruno)
                            .into(jimgDynamicPicture);

                }if(xRepeticiones>=30){
                    //Formula para repeticiones mayores a 10
                    jtxtResultado.setText("");
                    //Limpiar cajas de texto
                    jtxtRepeticiones.setText("");
                    jtxtPesoCarga.setText("");

                    Picasso.get()
                            .load("https://www.sdpnoticias.com/resizer/rhUgMxsn4pOj8fj1DYP8iwUZycQ=/1440x810/filters:format(jpg):quality(70):focal(335x222:345x232)/cloudfront-us-east-1.images.arcpublishing.com/sdpnoticias/KA5YJ4M6XBAFTPH36VJ4EFPPRM.jpeg")
                            .error(R.mipmap.ic_launcheruno)
                            .into(jimgDynamicPicture);

                    jtxtMensaje.setText("Checate");
                }
            }
        });


    }
}