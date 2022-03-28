package com.example.mefit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.mefit.Fragments.FirstFragment;
import com.example.mefit.Fragments.SecondFragment;
import com.example.mefit.Fragments.ThirdFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class EjecutableActivity extends AppCompatActivity {

    private static final String TAG = EjecutableActivity.class.getSimpleName();
    ChipNavigationBar bottom_navigation;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejecutable);


        bottom_navigation=findViewById(R.id.bottom_navigation);

        if(savedInstanceState==null){
            bottom_navigation.setItemSelected(R.id.firstFragment,true);
            fragmentManager = getSupportFragmentManager();
            FirstFragment firstFragment = new FirstFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container,firstFragment)
                    .commit();
        }

        bottom_navigation.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch(id){
                    case R.id.firstFragment:
                        fragment = new FirstFragment();
                        break;
                    case R.id.SecondFragment:
                        fragment = new SecondFragment();
                        break;
                    case R.id.ThirdFragment:
                        fragment = new ThirdFragment();
                        break;
                }
                if(fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container,fragment)
                            .commit();
                }else {
                    Log.e(TAG,"ERROR in creating fragment");
                }
            }
        });
    }
}