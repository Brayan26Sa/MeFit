package com.example.mefit.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.Nutrition.CalculosActivity;
import com.example.mefit.Nutrition.RegistrarMacroActivity;
import com.example.mefit.R;
import com.example.mefit.Settings.SettingsActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    Animation spinAlbum;
    LinearLayout LnyBackground;
    ScrollView ScrollColor;
    ImageView jbtnSettings,jimgInfo;
    CardView jcdvDies,jcdvVeinte,jcdvTreinta;
    Animation ScaleUp,ScaleDown;
    EditText jtxtPesoKg;
    TextView jtxtInfo;
    RadioGroup RgpoFactor,RgpoBajar;
    String Mensaje="",Opcion;
    float FA=0,ID=0;
    float caloriasdiarias=0,caloriastotales=0,porcentaje=0,proteinas=0,proteinaskcal=0,grasas=0
            ,grasaskcal=0,carbohidratos=0,carbohidratoskcal=0;
    float ct2,grasas2,proteinas2,pt2,gt2,carb12,carb22,Porcentaje2;
    float ct3,grasas3,proteinas3,pt3,gt3,carb3,carb33,Porcentaje3;
    float Pesokilos=0,Factor;

    FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        jtxtPesoKg=view.findViewById(R.id.xtxtPesoKg);
        jtxtInfo=view.findViewById(R.id.xtxtInfo);
        jcdvDies=view.findViewById(R.id.xcdvDies);
        jcdvVeinte=view.findViewById(R.id.xcdvVeinte);
        jcdvTreinta=view.findViewById(R.id.xcdvTreinta);
        jbtnSettings=view.findViewById(R.id.xbtnSettings);
        RgpoFactor=view.findViewById(R.id.RgpoFactor);
        RgpoBajar=view.findViewById(R.id.RgpoBajar);
        jimgInfo=view.findViewById(R.id.ximgInfo);
        LnyBackground = view.findViewById(R.id.lnyBackgound);
        ScrollColor = view.findViewById(R.id.ScrollColor);

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(getContext());

        spinAlbum= AnimationUtils.loadAnimation(getContext(),R.anim.girar_album);
        ScaleUp= AnimationUtils.loadAnimation(getContext(),R.anim.scale_up);
        ScaleDown= AnimationUtils.loadAnimation(getContext(),R.anim.scale_down);

        RgpoFactor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rdbNinguna){
                    RgpoFactor.startAnimation(ScaleUp);
                    RgpoFactor.startAnimation(ScaleDown);
                    FA= (float) 1.2;
                }else if(checkedId==R.id.rdbTres){
                    RgpoFactor.startAnimation(ScaleUp);
                    RgpoFactor.startAnimation(ScaleDown);
                    FA= (float) 1.4;
                }else if(checkedId==R.id.rdbCinco){
                    RgpoFactor.startAnimation(ScaleUp);
                    RgpoFactor.startAnimation(ScaleDown);
                    FA= (float) 1.6;
                }else if(checkedId==R.id.rdbSiete){
                    RgpoFactor.startAnimation(ScaleUp);
                    RgpoFactor.startAnimation(ScaleDown);
                    FA= (float) 1.8;
                }else if(checkedId==R.id.rdbSiempre){
                    RgpoFactor.startAnimation(ScaleUp);
                    RgpoFactor.startAnimation(ScaleDown);
                    FA= (float) 2.0;
                }
            }
        });

        RgpoBajar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rdbBajar){
                     jcdvDies.setVisibility(View.VISIBLE);
                     jcdvVeinte.setVisibility(View.VISIBLE);
                     jcdvTreinta.setVisibility(View.VISIBLE);
                     ID=1;
                }else if(checkedId==R.id.rdbSubir){
                    jcdvDies.setVisibility(View.VISIBLE);
                    jcdvVeinte.setVisibility(View.VISIBLE);
                    jcdvTreinta.setVisibility(View.VISIBLE);
                    ID=2;
                }else if(checkedId==R.id.rdbMantenerme){
                    jcdvDies.setVisibility(View.VISIBLE);
                    jcdvVeinte.setVisibility(View.VISIBLE);
                    jcdvTreinta.setVisibility(View.VISIBLE);
                    ID=3;
                }
            }
        });

        jcdvDies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animaciones
                jcdvDies.startAnimation(ScaleUp);
                jcdvDies.startAnimation(ScaleDown);
                //Permanece sin cambio alguno
                Pesokilos= (float) Double.parseDouble(jtxtPesoKg.getText().toString());
                caloriasdiarias= Math.round(Pesokilos*FA*22);
                //Cambia el porcentaje por 0.10 o 0.20 o 0.30
                porcentaje= (float) (caloriasdiarias*0.10);

                    if(ID==1){
                        //Cambia el signo
                        caloriastotales=Math.round(caloriasdiarias-porcentaje);
                        proteinas= Math.round((float) (1.8*Pesokilos));
                        proteinaskcal=(float) (proteinas*4);
                        grasas= Math.round((float) (0.5*Pesokilos));
                        grasaskcal= Pesokilos*9;
                        carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                        carbohidratos=Math.round(carbohidratoskcal/4);

                        Picasso.get()
                                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/24701-nature-natural-beauty.jpg/1280px-24701-nature-natural-beauty.jpg")
                                .error(R.drawable.ic_nowifi)
                                .into(jimgInfo);

                        Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                                "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                                "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                                "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                                "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                        jtxtInfo.setText(Mensaje);

                        Registrar();
                    }else if(ID==2){
                        //Cambia el signo
                        caloriastotales=Math.round(caloriasdiarias+porcentaje);
                        proteinas=Math.round ((float) (2.5*Pesokilos));
                        proteinaskcal=(float) (proteinas*4);
                        grasas= Math.round((float) (1.5*Pesokilos));
                        grasaskcal= Pesokilos*9;
                        carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                        carbohidratos=Math.round(carbohidratoskcal/4);


                        Picasso.get()
                                .load("https://verdecora.es/blog/wp-content/uploads/2016/01/arbustos-invierno-verdecora.jpg")
                                .error(R.drawable.ic_nowifi)
                                .into(jimgInfo);


                        Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                                "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                                "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                                "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                                "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                        jtxtInfo.setText(Mensaje);
                        Registrar();
                    }else if(ID==3){
                        //Cambia el signo
                        caloriastotales=caloriasdiarias+0;
                        proteinas= (float) (2.1*Pesokilos);
                        proteinaskcal=(float) (proteinas*4);
                        grasas= (float) (1.0*Pesokilos);
                        grasaskcal= Pesokilos*9;
                        carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                        carbohidratos=carbohidratoskcal/4;

                        Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                                "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                                "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                                "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                                "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                        jtxtInfo.setText(Mensaje);
                        Registrar();
                    }


            }
        });
        jcdvVeinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animaciones
                jcdvDies.startAnimation(ScaleUp);
                jcdvDies.startAnimation(ScaleDown);
                //Permanece sin cambio alguno
                Pesokilos= (float) Double.parseDouble(jtxtPesoKg.getText().toString());
                caloriasdiarias= Math.round(Pesokilos*FA*22);
                //Cambia el porcentaje por 0.10 o 0.20 o 0.30
                porcentaje= (float) (caloriasdiarias*0.20);

                if(ID==1){
                    //Cambia el signo
                    caloriastotales=Math.round(caloriasdiarias-porcentaje);
                    proteinas= (float) (1.8*Pesokilos);
                    proteinaskcal=Math.round((float) (proteinas*4));
                    grasas= Math.round((float) (0.5*Pesokilos));
                    grasaskcal= Pesokilos*9;
                    carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                    carbohidratos=Math.round(carbohidratoskcal/4);

                    Picasso.get()
                            .load("https://s3-eu-west-1.amazonaws.com/yara-links/tit6.jpg")
                            .error(R.drawable.ic_nowifi)
                            .into(jimgInfo);

                    Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                            "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                            "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                            "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                            "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                    jtxtInfo.setText(Mensaje);
                    Registrar();
                }else if(ID==2){
                    //Cambia el signo
                    caloriastotales=Math.round(caloriasdiarias+porcentaje);
                    proteinas= (float) (2.5*Pesokilos);
                    proteinaskcal=Math.round((float) (proteinas*4));
                    grasas= Math.round((float) (1.5*Pesokilos));
                    grasaskcal= Pesokilos*9;
                    carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                    carbohidratos=Math.round(carbohidratoskcal/4);

                    Picasso.get()
                            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Eiche_bei_Graditz.jpg/1200px-Eiche_bei_Graditz.jpg")
                            .error(R.drawable.ic_nowifi)
                            .into(jimgInfo);

                    Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                            "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                            "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                            "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                            "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                    jtxtInfo.setText(Mensaje);
                    Registrar();
                }else if(ID==3){
                    //Cambia el signo
                    caloriastotales=Math.round(caloriasdiarias+0);
                    proteinas= Math.round((float) (2.2*Pesokilos));
                    proteinaskcal=(float) (proteinas*4);
                    grasas= Math.round((float) (1.0*Pesokilos));
                    grasaskcal= Pesokilos*9;
                    carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                    carbohidratos=Math.round(carbohidratoskcal/4);

                    Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                            "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                            "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                            "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                            "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                    jtxtInfo.setText(Mensaje);
                    Registrar();
                }


            }
        });
        jcdvTreinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animaciones
                jcdvDies.startAnimation(ScaleUp);
                jcdvDies.startAnimation(ScaleDown);
                //Permanece sin cambio alguno
                Pesokilos= (float) Double.parseDouble(jtxtPesoKg.getText().toString());
                caloriasdiarias= Pesokilos*FA*22;
                //Cambia el porcentaje por 0.10 o 0.20 o 0.30
                porcentaje= (float) (caloriasdiarias*0.30);

                if(ID==1){
                    //Cambia el signo
                    caloriastotales=Math.round(caloriasdiarias-porcentaje);
                    proteinas=Math.round ((float) (1.8*Pesokilos));
                    proteinaskcal=(float) (proteinas*4);
                    grasas= Math.round((float) (0.5*Pesokilos));
                    grasaskcal= Pesokilos*9;
                    carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                    carbohidratos=Math.round(carbohidratoskcal/4);

                    Picasso.get()
                            .load("https://img.gruporeforma.com/imagenes/960x640/3/709/2708818.jpg")
                            .error(R.drawable.ic_nowifi)
                            .into(jimgInfo);

                    Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                            "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                            "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                            "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                            "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                    jtxtInfo.setText(Mensaje);
                    Registrar();
                }else if(ID==2){
                    //Cambia el signo
                    caloriastotales=Math.round(caloriasdiarias+porcentaje);
                    proteinas= Math.round((float) (2.5*Pesokilos));
                    proteinaskcal=(float) (proteinas*4);
                    grasas= Math.round((float) (1.5*Pesokilos));
                    grasaskcal= Pesokilos*9;
                    carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                    carbohidratos=Math.round(carbohidratoskcal/4);

                    Picasso.get()
                            .load("https://thumbs.dreamstime.com/b/%C3%A1rbol-gigante-de-sequia-con-agujero-general-sherman-un-164146526.jpg")
                            .error(R.drawable.ic_nowifi)
                            .into(jimgInfo);

                    Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                            "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                            "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                            "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                            "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                    jtxtInfo.setText(Mensaje);
                    Registrar();
                }else if(ID==3){
                    //Cambia el signo
                    caloriastotales=Math.round(caloriasdiarias+0);
                    proteinas= Math.round((float) (2.2*Pesokilos));
                    proteinaskcal=(float) (proteinas*4);
                    grasas= Math.round((float) (1.0*Pesokilos));
                    grasaskcal= Pesokilos*9;
                    carbohidratoskcal=caloriastotales-(proteinaskcal+grasaskcal);
                    carbohidratos=Math.round(carbohidratoskcal/4);

                    Mensaje = "Calorias diarias: "+caloriasdiarias+"Kcal."+"\n"+
                            "Superdeficit: "+caloriastotales+"Kcal."+"\n"+
                            "Proteinas: "+proteinas+"gr/Pdía"+" ("+proteinaskcal+"Kcal.)"+"\n"+
                            "Grasas: "+grasas+"gr/Pdía"+" ("+grasaskcal+"Kcal.)"+"\n"+
                            "Carbohidratos: "+carbohidratos+"gr/Pdía"+" ("+carbohidratoskcal+"Kcal.)";
                    jtxtInfo.setText(Mensaje);
                    Registrar();
                }


            }
        });
        jbtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jbtnSettings.startAnimation(ScaleUp);
                jbtnSettings.startAnimation(ScaleDown);
                startActivity(new Intent(getContext(), SettingsActivity.class));
            }
        });

    return view;
    }
    private void Registrar(){
        progressDialog.setTitle("Registrando");
        progressDialog.setMessage("Espere por favor...");
        progressDialog.setCancelable(true);
        progressDialog.show();
        progressDialog.dismiss();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        assert user!=null;
        String uid=user.getUid();

        float caloriasd=caloriasdiarias;
        float caloriasc=caloriastotales;
        float proteinasc=proteinas;
        float grasasc=grasas;
        float carbohidratosc=carbohidratos;

        HashMap<String, Float> DatosUsuario = new HashMap<>();


        DatosUsuario.put("caloriasd",caloriasd);
        DatosUsuario.put("caloriasc",caloriasc);
        DatosUsuario.put("proteinasc",proteinasc);
        DatosUsuario.put("copyproteinasc",proteinasc);
        DatosUsuario.put("grasasc",grasasc);
        DatosUsuario.put("copygrasasc",grasasc);
        DatosUsuario.put("carbohidratosc",carbohidratosc);
        DatosUsuario.put("copycarbohidratosc",carbohidratosc);

        FirebaseDatabase database= FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("Nutrition_DE_APP");
        reference.child(uid).setValue(DatosUsuario);
        Toast.makeText(getContext(),"Se registro exitosamente",Toast.LENGTH_SHORT).show();
    }
}