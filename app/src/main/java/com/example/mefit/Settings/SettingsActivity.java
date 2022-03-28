package com.example.mefit.Settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mefit.Ambiental.AmbientalActivity;
import com.example.mefit.Aprende.AprendeActivity;
import com.example.mefit.Comunicados.ComunicadosActivity;
import com.example.mefit.Contact.ContactActivity;
import com.example.mefit.CovidActivity;
import com.example.mefit.HelpYou.HelpYouActivity;
import com.example.mefit.IndexActivity;
import com.example.mefit.Music.MusicPruebaActivity;
import com.example.mefit.PDF.ViewPdfActivity;
import com.example.mefit.PerfilActivity;
import com.example.mefit.PlanAlimenticioReceta.RecetaAlimenticioActivity;
import com.example.mefit.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingsActivity extends AppCompatActivity {

    List<SettingsModel> listModalArrayList;
    ImageView jimgPerfilPhoto;
    TextView jtxtEmail,jtxtNSS;
    SwitchCompat jswhNotification;
    LinearLayout jlnyThemes;
    Animation ScaleUp,ScaleDown;

    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    DatabaseReference BASE_DE_DATOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        ScaleUp= AnimationUtils.loadAnimation(SettingsActivity.this,R.anim.scale_up);
        ScaleDown= AnimationUtils.loadAnimation(SettingsActivity.this,R.anim.scale_down);

        getCategories();

        jswhNotification=findViewById(R.id.xswhNotification);
        jimgPerfilPhoto=findViewById(R.id.ximgPerfilPhoto);
        jtxtEmail=findViewById(R.id.xtxtEmail);
        jtxtNSS=findViewById(R.id.xtxtNSS);


        //Pedir permisos firebase
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();

        BASE_DE_DATOS= FirebaseDatabase.getInstance().getReference("USUARIOS_DE_APP");

        BASE_DE_DATOS.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String imagen = ""+snapshot.child("imagen").getValue();
                    String email = ""+snapshot.child("correo").getValue();
                    String nss= ""+snapshot.child("nss").getValue();

                    jtxtEmail.setText(email);
                    jtxtNSS.setText("NSS: "+nss);

                    /*Mostrar foto Perfil*/

                    try{
                        Picasso.get().load(imagen).placeholder(R.drawable.kaleb).into(jimgPerfilPhoto);
                    }catch (Exception e){
                        Picasso.get().load(R.drawable.profile).into(jimgPerfilPhoto);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        jimgPerfilPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jimgPerfilPhoto.startAnimation(ScaleUp);
                startActivity(new Intent(SettingsActivity.this, PerfilActivity.class));
            }
        });

        jswhNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jswhNotification.isChecked()){
                    RequestQueue myrequest= Volley.newRequestQueue(getApplicationContext());
                    JSONObject json=new JSONObject();
                    try {
                        String urifoto="https://1.bp.blogspot.com/-q2cRULQ6DRU/YLW03OgpBFI/AAAAAAAAbiA/zIwV02GaXCc8VpcYWuBL4r6gWWHZgVE3ACLcBGAsYHQ/w545-h370/16225188545408764705003928266314.png";
                        //String token="fsPaGy4WRfqfkHX0kZFTGs:APA91bFhjMcqZwh9vAlhcHEEXPlJ74735_dkGPP8t2OWOF-rxU5Crnd302XTBuYsz1jL9n0K6Lu-6Qfa3v5tNgDRwU4wOq3GgiSHBqkn2fTwJ3rcg-hgc8OUB_Cxuv8F5wnqVmLnWrds";

                        json.put("to","/topics/"+"enviaratodos");
                        JSONObject notificacion=new JSONObject();
                        notificacion.put("Hola, bienbenido","Soy un titulo");
                        notificacion.put("Detalle","Soy un detalle");
                        notificacion.put("foto",urifoto);

                        json.put("data",notificacion);

                        String URL="https://fcm.googleapis.com/fcm/send";

                        JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST,URL,json,null,null){
                            @Override
                            public Map<String, String> getHeaders() {
                                Map<String,String> header= new HashMap<>();

                                header.put("content-type", "application/json");
                                header.put("authorization", "key=BHuhDLP3fg3xkpJ-vnmhQeK1NJpRygNXA36HZ83viq_ku0iDzdiAYM_EVxB-EOUQ8Iap_ngIv7ZvQkW7rYLQ1WA");
                                return header;
                            }
                        };
                        myrequest.add(request);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(SettingsActivity.this, "No recibido", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void getCategories(){
        listModalArrayList=new ArrayList<>();
        listModalArrayList.add(new SettingsModel("Citas","https://blogger.googleusercontent.com/img/a/AVvXsEiueiL9yYIXT_mTisf5CIsFju1O4Tn3UjS9ZdUMXweo5A9Z0CYFRmFpHYAPzpa1dvz36ZvMstw16HZP-tpIC4y50CgvDBF_voQLZkwYXgQY28JUVJETrwQMHf_GJD8EB6a7OUJuoHsvjGZiexrXkFhI7zRXDMZwZGi2SF5RTLPXqLeKqMxQl8s0c033",0));
        listModalArrayList.add(new SettingsModel("Covid-19","https://blogger.googleusercontent.com/img/a/AVvXsEgN6U1A4Avt65KhFem8f55bH1_UttwXaN8NiIH0EM__L9CZbXucQKXWUlbHBPRpttE79x6a6_dnbeNITEY0DBgtK2kA5JQ4KKeLRNCQ-PL-9QnVHaPUppaHa2OfNUM9kEX5nUswIesJv2U-9jPW96XIAFESSdXZU-iI9p98zNPzWaQDpLvV6cjjGrK1",1));
        listModalArrayList.add(new SettingsModel("Ayud@ te","https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEilItffVJvgXDtJKY81aAVoYgcWc40i-f6dBgzcZoFiZDqnXdd9LVDHkkfOWP1Mds6qqrfVjCGCoSEEO-rpEq-R8NixRYSG0WwQpVa--b7HpP6EiwWe0stctqsMx5bWkunhyQFWjwO1GbQi2y0aqaYAP6pkHw9xlhk6RwA-0aSr9BxlAYVIGd7Sn-VX/s1600/ayuda.png",12));
        listModalArrayList.add(new SettingsModel("Entrenamiento","https://blogger.googleusercontent.com/img/a/AVvXsEhsroWvYVtSHLfxB5EHZA4rZS_TZ8a3dKLtRBeWsOWP390jNI1us0bF4aw0MIkB0KcCWy4OkYqh9INHzi42ws8K1Sn2u0IlQBnPa4d86POg_thbJj5aGI3Ikdah71Whtma6wo5IcBIBdhfIg0GG2g26Vf3fnAES-Gwz2SgOL9JH5FBMMxan-NjzUomg",2));
        listModalArrayList.add(new SettingsModel("Nutrición","https://blogger.googleusercontent.com/img/a/AVvXsEhMocWxfmJk7S0SZIh0XmTcTN25sLouMIBKQeV0OYnRQxDaBU2VKeW2dhuYNiQiHLm03UNWKeeJKWXUrapzzuJ-1Bqajs9wG5fsitorH1y-JURW-osRBO8b4n3fNYmifMxcNxsXbEUQSvEgGHZ3qFvoIC1l2Ba5I9qnG9vTAhbSX92iBPDXUyr0C7Sj",3));
        listModalArrayList.add(new SettingsModel("Receta/P.Alm.","https://blogger.googleusercontent.com/img/a/AVvXsEijEYNbIwzZMzkhLUDXepvNSWmZFYSu_xE3iLxWo_Z-02yndZiOk63C3wSms34wHw2qUovER9WR_EUb24u_G88XYRSd_aJaEv_DdZWydvp9t6J6_rn-SsmzhnFyAIoBL9z9GWFPWnkRZdmxfDhOTvZBowOdTkwcAEPQ1B8W0QH-RpICwjf0wOIq_GP5",10));
        listModalArrayList.add(new SettingsModel("Aprender","https://blogger.googleusercontent.com/img/a/AVvXsEjh1pISvn2M4VOmew0kPGw43ruhliXgv5l8xsnvrI2nOvIbs0KMG_IqkNhd0ALgPULzgYSBqUn0WKR5lu--Nq4SAGcHT5eqPPL-xOOkrswcwdGjOpDvl8h9rzixFBZu-P1-8fl6jXZuLi41gmmGsFSVAKTYDZAX-K3oHeBP-0AGHFRHSMYiIrMoMGYw",4));
        listModalArrayList.add(new SettingsModel("Noticias","https://blogger.googleusercontent.com/img/a/AVvXsEjXLcRprZ5vLUqGmsQ6x8KkT8qB0cI71TYZ0LXBN-V-gBH4ayUHR_-D8pNP25vwC3zQ0VfuI-L6Rlq3OU7DO_LhGDIjjQafdyv15cdptfikCoAY7oMx9qzQHbVRLdR6GazMNBoLdTEPs-8_lgK8ve2qqlLybIpyjGV4IYJY15RVB6Q7lEzBitlMoaQn",5));
        listModalArrayList.add(new SettingsModel("Material de apoyo","https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhwJHw_h_B1ggTxp1sTlmAQxekaQEat2msATrYEp_obMICHaPGA7zcGdwQUXMX9ZrPVP_VXFi6WuV8geXzbLtgkNkAdArqjgo-qgqczozJKUAD5qqgVCX216_d-cUtBsxeCF29kzb-Z795JsJSkyzyeAPOjb9-_Qe8EYfSz8kD7XuywkR3uHjZB5dqB/s1600/material.png",13));
        listModalArrayList.add(new SettingsModel("Comunicados","https://blogger.googleusercontent.com/img/a/AVvXsEjXLcRprZ5vLUqGmsQ6x8KkT8qB0cI71TYZ0LXBN-V-gBH4ayUHR_-D8pNP25vwC3zQ0VfuI-L6Rlq3OU7DO_LhGDIjjQafdyv15cdptfikCoAY7oMx9qzQHbVRLdR6GazMNBoLdTEPs-8_lgK8ve2qqlLybIpyjGV4IYJY15RVB6Q7lEzBitlMoaQn",9));
        listModalArrayList.add(new SettingsModel("Música","https://blogger.googleusercontent.com/img/a/AVvXsEgkBOZxiYsT2DU4LyXVTbFIGUQi0Dz4Hm5fNgDYeX3of432dGQkecfndCcDV7J2A5qPSkLianW4FtlZ6dSTBw3DyGrw6k5umsddSb-ylnHAXjIssGUQ369JUorn2PFYB4gCHaug5a3Nnk_67K14V_G3n4j6Q_8_5W69Ra-dQLYuLr9EejSaT2zLdCkg",6));
        listModalArrayList.add(new SettingsModel("Soporte","https://blogger.googleusercontent.com/img/a/AVvXsEjYdImYgjlEMO4_Sa990f6kWbnB8zlN1_nILmC6FadNjzwwB1zfykrD6x3Lewu8rdjKts2E6_AXMg39WYcVhtFp_Smya44DiIemAD_jqrTJMEG5a5eUq5uzhBi-W2La9vT64TAFatjlRNNVsy8U-qYYTkzjgF-uHMoRk7lalyzYcmviCnMnqqFjs_aI",7));
        listModalArrayList.add(new SettingsModel("C.Ambiental","https://blogger.googleusercontent.com/img/a/AVvXsEjaPP5emczFe5k33-6XWiwshipjDNVC3CjlT0mVl_Y6tRKXkzT4Pfu4A4SnijjE3hVZ-I-xos9QgKI5SsOR6eO921igEQcNUApsHkxnDdV71kZFfHd2CWV91i8nTlgCH7O3NqsXb10zgWM4eL9A6ShCBYiGVb094R24j3-7SAKiD5Bq0Z1-YPmuwSa1",11));
        listModalArrayList.add(new SettingsModel("Acerca de la app","https://blogger.googleusercontent.com/img/a/AVvXsEi95lV9kKa4D0a6NzP26fcGe3M0kDCnvOngF8hM4Z-LUVam6bTXGYg05hONhVzIhIDSZ-Usdl3CDLq3B1l8ISoCpAlogHXLCYORuFZ_O4aMryCaQ1y6BeHIX8d5nxLCRzupRqg7u-dnE9zxepJcIkh5q4h1tCVa7UniHd5S9f-VRnk8R7pfhzsSQBLC",8));

        AdapterSettings adapterSettings = new AdapterSettings(listModalArrayList,this, new AdapterSettings.OnItemClickListener() {
            @Override
            public void onItemClick(SettingsModel item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.idRVSettings);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterSettings);
    }

    private void moveToDescription(SettingsModel item) {
        if(item.getID()==0){
            startActivity(new Intent(SettingsActivity.this, ContactActivity.class));
        }else if(item.getID()==1){
            startActivity(new Intent(SettingsActivity.this, CovidActivity.class));
        }else if(item.getID()==2){
            startActivity(new Intent(SettingsActivity.this, EntrenamientoActivity.class));
        }else if(item.getID()==3){
            startActivity(new Intent(SettingsActivity.this, NutricionActivity.class));
        }else if(item.getID()==4){
            startActivity(new Intent(SettingsActivity.this, AprendeActivity.class));
        }else if(item.getID()==5){
            startActivity(new Intent(SettingsActivity.this, NewsActivity.class));
        }else if(item.getID()==6){
            startActivity(new Intent(SettingsActivity.this, MusicActivity.class));
        }else if(item.getID()==7){
            startActivity(new Intent(SettingsActivity.this, SupportActivity.class));
        }else if(item.getID()==8){
            startActivity(new Intent(SettingsActivity.this, IndexActivity.class));
        }else if(item.getID()==9){
            startActivity(new Intent(SettingsActivity.this, ComunicadosActivity.class));
        }else if(item.getID()==10){
            startActivity(new Intent(SettingsActivity.this, RecetaAlimenticioActivity.class));
        }else if(item.getID()==11){
            startActivity(new Intent(SettingsActivity.this, AmbientalActivity.class));
        }else if(item.getID()==12){
            startActivity(new Intent(SettingsActivity.this, HelpYouActivity.class));
        }else if(item.getID()==13){
            startActivity(new Intent(SettingsActivity.this, ViewPdfActivity.class));
        }
    }

}