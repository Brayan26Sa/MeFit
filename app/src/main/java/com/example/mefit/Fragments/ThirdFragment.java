package com.example.mefit.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mefit.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    private TextView jtxtAnos,jtxtResultado;
    private RadioGroup jrdbFamily,jrdbEtnia;
    int family=0,Latin=0,Anos=0,Proba=0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        jtxtAnos=view.findViewById(R.id.xtxtAnos);
        jtxtResultado=view.findViewById(R.id.xtxtResultado);
        jrdbFamily=view.findViewById(R.id.xrdbFamily);
        jrdbEtnia=view.findViewById(R.id.xrdbEtnia);

        Anos= (int) Double.parseDouble(jtxtAnos.getText().toString());
            if(Anos==0){
                jtxtAnos.setText("Pon un dato valido porfabor");
            }else if(Anos<=45){
                Proba=-1;
            }else if(Anos>=45){
                Proba=1;
            }

        jrdbFamily.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.xtxtSiF){
                    family=1;
                }else if(i==R.id.xtxtNoF){
                    family=-1;
                }
            }
        });
        jrdbEtnia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.xtxtLatino){
                     Latin=1;
                     int total= family+Latin+Proba;
                        if(total<=0){
                            jtxtResultado.setText("La probabilidad de que sufras diabetes es muy poca");
                        }else if(total>=0){
                            jtxtResultado.setText("La probabilidad de que sufras diabetes es Media-Alta");
                        }

                }else if(i==R.id.xtxtAmericana){
                     Latin=1;
                    int total= family+Latin+Proba;
                    if(total<=0){
                        jtxtResultado.setText("La probabilidad de que sufras diabetes es muy poca");
                    }else if(total>=0){
                        jtxtResultado.setText("La probabilidad de que sufras diabetes es Media-Alta");
                    }

                }else if(i==R.id.xtxtEuropea){
                     Latin=-1;
                    int total= family+Latin+Proba;
                    if(total<=0){
                        jtxtResultado.setText("La probabilidad de que sufras diabetes es muy poca");
                    }else if(total>=0){
                        jtxtResultado.setText("La probabilidad de que sufras diabetes es Media-Alta");
                    }

                }
            }
        });

        return view;
    }
}