package com.example.mefit.Entrenamiento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.mefit.EjecutableActivity;
import com.example.mefit.R;
import com.example.mefit.Settings.CategoryRVModal;
import com.example.mefit.Settings.NutricionActivity;

import java.util.ArrayList;
import java.util.List;

public class HipertrophyActivity extends AppCompatActivity {

    List<ListModal> listModalArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hipertrophy);


        getCategories();
    }
    private void getCategories(){
        listModalArrayList=new ArrayList<>();
        listModalArrayList.add(new ListModal("Parte superior","N/A","Lunes","Espalda,Bicep,Tricep","0%","https://i.blogs.es/f14344/six-pack/450_1000.jpeg",0));
        listModalArrayList.add(new ListModal("1. Empuje Horizontal, hacia el fondo","2x06","Lunes","PECTORALES,Hombros,triceps,parte del deltoides","RM: 82% y RPE: 8","https://thumbs.dreamstime.com/b/exercising-empuje-horizontal-en-el-simulador-57083857.jpg",1));
        listModalArrayList.add(new ListModal("2. Empuje Horizontal, hacia el fondo","3x06 ","Lunes","PECTORALES,Hombros,triceps,parte del deltoides","RM: 82% y RPE: 8","https://i.pinimg.com/564x/dd/d7/e5/ddd7e5c0e4053296383739e6fd3a17e9--gym-equipment-names-deck.jpg",2));
        listModalArrayList.add(new ListModal("3. Tiron horizontal, hacia el fondo","5x6","Lunes","LUMBARES,DORSALES,desltoides superior,pectoral","RM: N/A y RPE: 8","https://nutricion360.es/wp-content/uploads/2019/08/remo-en-polea-baja-sentado.jpg",3));
        listModalArrayList.add(new ListModal("4. Empuje vertical","2x10","Lunes","DELTOIDES,TRAPECIO,triceps","RM: 82% y RPE: 8","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7132lpO6VbGfuNJEzP0cIAbl4-9RMFjX_Gg&usqp=CAU",4));
        listModalArrayList.add(new ListModal("5. Empuje vertical","2x10","Lunes","DELTOIDES,TRAPECIO,triceps","RM: 82% y RPE: 8","https://eresfitness.com/wp-content/uploads/2020/12/14541105-Lever-Seated-Shoulder-Press_Shoulders_max-1.jpg",5));
        listModalArrayList.add(new ListModal("6. Tiron vertical","4x8","Lunes","DORSAL,INFRAESPINOSO,hombros","RM: N/A y RPE: 8","https://eresfitness.com/wp-content/uploads/2020/02/01971105-Cable-Pulldown-pro-lat-bar_Back_max.png",6));
        listModalArrayList.add(new ListModal("7. Biceps","3x12","Lunes","Biceps de forma aislada","RM: N/A y RPE: 8","https://eresfitness.com/wp-content/uploads/2020/12/05921105-Lever-Preacher-Curl_Upper-Arms_max.png",7));
        listModalArrayList.add(new ListModal("8. Triceps","3x12","Lunes","Triceps de forma aislada","RM: N/A y RPE: 8","https://rutinasentrenamiento.com//wp-content/uploads/triceps-cable-pressdowns.jpg",8));
        listModalArrayList.add(new ListModal("9. Face Pulls","2x12","Lunes","Hombros de forma aislada","RM: N/A y RPE: 8","https://www.soypowerlifter.com/wp-content/uploads/2019/06/face-pull.png",9));


        listModalArrayList.add(new ListModal("Parte Inferior","N/A","Martes","Espalda,Bicep,Tricep","0%","https://media.revistagq.com/photos/5e660ec7f7c7d90008fcc894/16:9/w_2560%2Cc_limit/ejercicios-piernas.jpg",10));
        listModalArrayList.add(new ListModal("1. Variante de bisagra de cadera","3x8","Martes","Espalda,Bicep,Tricep","RM: N/A y RPE: 8","https://blogger.googleusercontent.com/img/a/AVvXsEiX0DBym1cc8hUeD7B6sq6tzuSFUrrO_5sjmeQE_NBy2KO5ueL7X5uKNDMT-hSsp6Vj2bjxcHkZCuJmidEacRGtumI8RNNN7fb2yLRr2wTG_zl9cGbwmLZ9N9gm3-XUbhVQPEuPsoabRdGOIhwolVj4XY-8Na-ddN13xj5803p0fRVHHpmk4uoIZ5NY=w520-h513",11));
        listModalArrayList.add(new ListModal("2. Variante de prensa de piernas","3x8","Martes","Espalda,Bicep,Tricep","RM: N/A y RPE: 8","https://blogger.googleusercontent.com/img/a/AVvXsEiX0DBym1cc8hUeD7B6sq6tzuSFUrrO_5sjmeQE_NBy2KO5ueL7X5uKNDMT-hSsp6Vj2bjxcHkZCuJmidEacRGtumI8RNNN7fb2yLRr2wTG_zl9cGbwmLZ9N9gm3-XUbhVQPEuPsoabRdGOIhwolVj4XY-8Na-ddN13xj5803p0fRVHHpmk4uoIZ5NY=w520-h513",12));
        listModalArrayList.add(new ListModal("3. Extencion de cadera con lastre","3x8","Martes","Espalda,Bicep,Tricep","RM: N/A y RPE: 8","https://blogger.googleusercontent.com/img/a/AVvXsEiX0DBym1cc8hUeD7B6sq6tzuSFUrrO_5sjmeQE_NBy2KO5ueL7X5uKNDMT-hSsp6Vj2bjxcHkZCuJmidEacRGtumI8RNNN7fb2yLRr2wTG_zl9cGbwmLZ9N9gm3-XUbhVQPEuPsoabRdGOIhwolVj4XY-8Na-ddN13xj5803p0fRVHHpmk4uoIZ5NY=w520-h513",13));
        listModalArrayList.add(new ListModal("4. Curl femoral","3x12","Martes","Espalda,Bicep,Tricep","RM: N/A y RPE: 8","https://blogger.googleusercontent.com/img/a/AVvXsEiX0DBym1cc8hUeD7B6sq6tzuSFUrrO_5sjmeQE_NBy2KO5ueL7X5uKNDMT-hSsp6Vj2bjxcHkZCuJmidEacRGtumI8RNNN7fb2yLRr2wTG_zl9cGbwmLZ9N9gm3-XUbhVQPEuPsoabRdGOIhwolVj4XY-8Na-ddN13xj5803p0fRVHHpmk4uoIZ5NY=w520-h513",14));
        listModalArrayList.add(new ListModal("5. Elevacion de talones sentado","3x15","Martes","Espalda,Bicep,Tricep","RM: N/A y RPE: 8","https://blogger.googleusercontent.com/img/a/AVvXsEiX0DBym1cc8hUeD7B6sq6tzuSFUrrO_5sjmeQE_NBy2KO5ueL7X5uKNDMT-hSsp6Vj2bjxcHkZCuJmidEacRGtumI8RNNN7fb2yLRr2wTG_zl9cGbwmLZ9N9gm3-XUbhVQPEuPsoabRdGOIhwolVj4XY-8Na-ddN13xj5803p0fRVHHpmk4uoIZ5NY=w520-h513",15));

        listModalArrayList.add(new ListModal("Parte superior","N/A","Jueves","Espalda,Bicep,Tricep","0%","https://i.blogs.es/f14344/six-pack/450_1000.jpeg",27));
        listModalArrayList.add(new ListModal("1. Empuje vertical","2x08","Jueves","DELTOIDES,TRAPECIO,triceps","RM: 82% y RPE: 8","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7132lpO6VbGfuNJEzP0cIAbl4-9RMFjX_Gg&usqp=CAU",4));
        listModalArrayList.add(new ListModal("2. Empuje Horizontal, hacia el fondo","2x08","Jueves","PECTORALES,Hombros,triceps,parte del deltoides","RM: 82% y RPE: 8","https://thumbs.dreamstime.com/b/exercising-empuje-horizontal-en-el-simulador-57083857.jpg",1));
        listModalArrayList.add(new ListModal("3. Tiron vertical","2x08","Jueves","DORSAL,INFRAESPINOSO,hombros","RM: N/A y RPE: 8","https://eresfitness.com/wp-content/uploads/2020/02/01971105-Cable-Pulldown-pro-lat-bar_Back_max.png",6));
        listModalArrayList.add(new ListModal("4. Tiron horizontal, hacia el fondo","2x08","Jueves","LUMBARES,DORSALES,desltoides superior,pectoral","RM: N/A y RPE: 8","https://nutricion360.es/wp-content/uploads/2019/08/remo-en-polea-baja-sentado.jpg",3));
        listModalArrayList.add(new ListModal("5. Biceps","2x08","Jueves","Biceps de forma aislada","RM: N/A y RPE: 8","https://eresfitness.com/wp-content/uploads/2020/12/05921105-Lever-Preacher-Curl_Upper-Arms_max.png",7));
        listModalArrayList.add(new ListModal("6. Triceps","1x12","Jueves","Triceps de forma aislada","RM: N/A y RPE: 8","https://rutinasentrenamiento.com//wp-content/uploads/triceps-cable-pressdowns.jpg",8));

        listModalArrayList.add(new ListModal("Parte Inferior","N/A","Martes","Espalda,Bicep,Tricep","0%","https://media.revistagq.com/photos/5e660ec7f7c7d90008fcc894/16:9/w_2560%2Cc_limit/ejercicios-piernas.jpg",21));
        listModalArrayList.add(new ListModal("1. Variante de bisagra de cadera","3x8","Martes","Espalda,Bicep,Tricep","RM: N/A y RPE: 8","https://blogger.googleusercontent.com/img/a/AVvXsEiX0DBym1cc8hUeD7B6sq6tzuSFUrrO_5sjmeQE_NBy2KO5ueL7X5uKNDMT-hSsp6Vj2bjxcHkZCuJmidEacRGtumI8RNNN7fb2yLRr2wTG_zl9cGbwmLZ9N9gm3-XUbhVQPEuPsoabRdGOIhwolVj4XY-8Na-ddN13xj5803p0fRVHHpmk4uoIZ5NY=w520-h513",22));
        listModalArrayList.add(new ListModal("2. Variante de prensa de piernas","3x8","Martes","Espalda,Bicep,Tricep","RM: N/A y RPE: 8","https://blogger.googleusercontent.com/img/a/AVvXsEiX0DBym1cc8hUeD7B6sq6tzuSFUrrO_5sjmeQE_NBy2KO5ueL7X5uKNDMT-hSsp6Vj2bjxcHkZCuJmidEacRGtumI8RNNN7fb2yLRr2wTG_zl9cGbwmLZ9N9gm3-XUbhVQPEuPsoabRdGOIhwolVj4XY-8Na-ddN13xj5803p0fRVHHpmk4uoIZ5NY=w520-h513",23));

        ListAdapter listAdapter=new ListAdapter(listModalArrayList, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListModal item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView=findViewById(R.id.idRVEjercicios);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void moveToDescription(ListModal item){
                if(item.getID()==1){
                    String url="https://vm.tiktok.com/ZML1D6DWC/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==2){
                    String url="https://vm.tiktok.com/ZML1DRue9/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==3){
                    String url="https://vm.tiktok.com/ZML1AuESg/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==4){
                    String url="https://vm.tiktok.com/ZML1AXgYL/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==5){
                    String url="https://vm.tiktok.com/ZML1DYfP7/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==6){
                    String url="https://vm.tiktok.com/ZML1AxhVb/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==7){
                    String url="https://vm.tiktok.com/ZML1DVwtL/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==8){
                    String url="https://vm.tiktok.com/ZML1DVpUJ/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else if(item.getID()==9){
                    String url="https://vm.tiktok.com/ZML1DmHmY/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
    }
}