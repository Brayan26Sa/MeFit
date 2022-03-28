package com.example.mefit.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.mefit.Nutrition.CalculosActivity;
import com.example.mefit.Nutrition.ListFoodActivity;
import com.example.mefit.Nutrition.RegistrarMacroActivity;
import com.example.mefit.R;
import com.squareup.picasso.Picasso;

public class NutricionActivity extends AppCompatActivity {

    ImageView jimgCBUno,jimgCBDos,jimgCBTres,jimgCBCuatro,jimgCBCinco,jimgCBSeis,jimgCBSiete,jimgCBOcho,jimgCBNueve,jimgCBDies,jimgCBOnce,jimgCBDoce;
    ImageView jimgPTUno,jimgPTDos,jimgPTTres,jimgPTCuatro,jimgPTCinco,jimgPTSeis,jimgPTSiete,jimgPTOcho,jimgPTNueve,jimgPTDies,jimgPTOnce,jimgPTDoce;
    ImageView jimgGRUno,jimgGRDos,jimgGRTres,jimgGRCuatro,jimgGRCinco,jimgGRSeis,jimgGRSiete,jimgGROcho,jimgGRNueve;
    ImageView jimgIVRegister,jimgListChemistry;
    CardView jcdvRegister,jcdvListFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricion);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        jcdvRegister=findViewById(R.id.xcdvRegister);
        jimgCBUno=findViewById(R.id.idIVCBUno);
        jimgCBDos=findViewById(R.id.idIVCBDos);
        jimgCBTres=findViewById(R.id.idIVCBTres);
        jimgCBCuatro=findViewById(R.id.idIVCBCuatro);
        jimgCBCinco=findViewById(R.id.idIVCBCinco);
        jimgCBSeis=findViewById(R.id.idIVCBSeis);
        jimgCBSiete=findViewById(R.id.idIVCBSiete);
        jimgCBOcho=findViewById(R.id.idIVCBOcho);
        jimgCBNueve=findViewById(R.id.idIVCBNueve);
        jimgCBDies=findViewById(R.id.idIVCBDies);
        jimgCBOnce=findViewById(R.id.idIVCBOnce);
        jimgCBDoce=findViewById(R.id.idIVCBDoce);
        jimgPTUno=findViewById(R.id.idximgPTUno);
        jimgPTDos=findViewById(R.id.idximgPTDos);
        jimgPTTres=findViewById(R.id.idximgPTTres);
        jimgPTCuatro=findViewById(R.id.idximgPTCuatro);
        jimgPTCinco=findViewById(R.id.idximgPTCinco);
        jimgPTSeis=findViewById(R.id.idximgPTSeis);
        jimgPTSiete=findViewById(R.id.idximgPTSiete);
        jimgPTOcho=findViewById(R.id.idximgPTOcho);
        jimgPTNueve=findViewById(R.id.idximgPTNueve);
        jimgPTDies=findViewById(R.id.idximgPTDies);
        jimgPTOnce=findViewById(R.id.idximgPTOnce);
        jimgPTDoce=findViewById(R.id.idximgPTDoce);
        jimgGRUno=findViewById(R.id.idIVGRUno);
        jimgGRDos=findViewById(R.id.idIVGRDos);
        jimgGRTres=findViewById(R.id.idIVGRTres);
        jimgGRCuatro=findViewById(R.id.idIVGRCuatro);
        jimgGRCinco=findViewById(R.id.idIVGRCinco);
        jimgGRSeis=findViewById(R.id.idIVGRSeis);
        jimgGRSiete=findViewById(R.id.idIVGRSiete);
        jimgGROcho=findViewById(R.id.idIVGROcho);
        jimgGRNueve=findViewById(R.id.idIVGRNueve);
        jimgIVRegister=findViewById(R.id.idIVRegister);
        jimgListChemistry=findViewById(R.id.ximgFoodChemistry);
        jcdvListFood=findViewById(R.id.xcdvListFood);

        Picasso.get()
                .load("https://www.eluniversal.com.mx/sites/default/files/2017/03/16/arroz_el_universal_menu_istock.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBUno);
        Picasso.get()
                .load("https://www.cocinayvino.com/wp-content/uploads/2017/07/16194971_ml-e1499974317365.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBDos);
        Picasso.get()
                .load("https://encolombia.com/wp-content/uploads/2021/01/Beneficios-de-las-Lentejas.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBTres);
        Picasso.get()
                .load("https://www.pcrm.org/sites/default/files/frijoles-negros-8.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBCuatro);
        Picasso.get()
                .load("https://www.pequerecetas.com/wp-content/uploads/2021/02/cocinar-garbanzos-660x439.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBCinco);
        Picasso.get()
                .load("https://dam.cocinafacil.com.mx/wp-content/uploads/2018/03/STMetodo-para-sacar-los-chicharos-de-sus-vainas.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBSeis);
        Picasso.get()
                .load("https://static3.abc.es/media/bienestar/2019/07/25/quinoa-beneficios-2-kPJE--620x349@abc.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBSiete);
        Picasso.get()
                .load("https://i.blogs.es/4dff8b/pasta-mantequilla/840_560.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBOcho);
        Picasso.get()
                .load("https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/images/2019/08/como-elegir-elotes-en-buen-estado.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBNueve);
        Picasso.get()
                .load("https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/datos-de-la-avena-masa44_.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBDies);
        Picasso.get()
                .load("https://s1.eestatic.com/2018/11/06/ciencia/nutricion/cereales-nutricion-alimentacion_351228002_104673598_1706x960.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBOnce);
        Picasso.get()
                .load("https://www.twosisterscrafting.com/wp-content/uploads/2016/01/perfect-stovetop-popcorn-1200-featured-735x735.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgCBDoce);


        Picasso.get()
                .load("https://dam.cocinafacil.com.mx/wp-content/uploads/2021/08/pechuga-de-pollo-saludable.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTUno);
        Picasso.get()
                .load("https://saboryestilo.com.mx/wp-content/uploads/2019/05/carne-magra-de-res-cortes-saludables-1200x720.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTDos);
        Picasso.get()
                .load("https://pescadoacasa.com/wp-content/uploads/2020/10/tipos-de-pescados..jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTTres);
        Picasso.get()
                .load("https://www.ecoticias.com/userfiles/2021/Apr_30/226.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTCuatro);
        Picasso.get()
                .load("http://c.files.bbci.co.uk/16E5/production/_108916850_gettyimages-157603551.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTCinco);
        Picasso.get()
                .load("https://foodispower.org/wp-content/uploads/2019/02/1200x475-Turkeys.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTSeis);
        Picasso.get()
                .load("https://static5.depositphotos.com/1000695/535/i/600/depositphotos_5357594-stock-photo-pig-on-white.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTSiete);
        Picasso.get()
                .load("https://s1.eestatic.com/2021/01/22/ciencia/nutricion/553206479_171070440_1024x576.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTOcho);
        Picasso.get()
                .load("https://i.blogs.es/c862d6/queso-manchego/840_560.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTNueve);
        Picasso.get()
                .load("https://thefoodtech.com/wp-content/uploads/2020/05/soya-2.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTDies);
        Picasso.get()
                .load("https://i.ytimg.com/vi/v8F6yJt1ULo/maxresdefault.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTOnce);
        Picasso.get()
                .load("https://statics-cuidateplus.marca.com/cms/styles/natural/azblob/lecheok_0.jpg?itok=DKYT7dWo")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgPTDoce);


        Picasso.get()
                .load("https://www.tododisca.com/wp-content/uploads/2020/10/aguacate.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRUno);
        Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-_73yWjrziPKutWFGB9yXDgLkXek4ooTCXg&usqp=CAU")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRDos);
        Picasso.get()
                .load("https://elpoderdelconsumidor.org/wp-content/uploads/2021/04/almendras-b.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRTres);
        Picasso.get()
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Walnuts_-_whole_and_open_with_halved_kernel.jpg/800px-Walnuts_-_whole_and_open_with_halved_kernel.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRCuatro);
        Picasso.get()
                .load("https://www.costco.com.mx/medias/sys_master/products/h93/h04/62178660155422.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRCinco);
        Picasso.get()
                .load("https://www.lavanguardia.com/files/og_thumbnail/uploads/2021/04/21/607fdfeb1b48a.jpeg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRSeis);
        Picasso.get()
                .load("https://www.cocinayvino.com/wp-content/uploads/2016/08/aceitunas-1.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRSiete);
        Picasso.get()
                .load("https://deliciaskitchen.b-cdn.net/wp-content/uploads/2020/07/semillas-de-chia-propiedades-beneficios-y-recetas-480x650.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGROcho);
        Picasso.get()
                .load("https://images.theconversation.com/files/359418/original/file-20200922-20-jz9fp7.jpg?ixlib=rb-1.1.0&q=45&auto=format&w=1200&h=1200.0&fit=crop")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgGRNueve);
        Picasso.get()
                .load("https://fotografias.correryfitness.com/clipping/cmsimages02/2018/02/16/8561B41C-FB47-45FA-9F85-363FE916FD94/58.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgIVRegister);
        Picasso.get()
                .load("https://fotografias.correryfitness.com/clipping/cmsimages02/2018/02/16/8561B41C-FB47-45FA-9F85-363FE916FD94/58.jpg")
                .error(R.mipmap.ic_launcheruno)
                .into(jimgListChemistry);

        jcdvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NutricionActivity.this, CalculosActivity.class));
            }
        });
        jcdvListFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NutricionActivity.this, ListFoodActivity.class));
            }
        });

    }
}