package com.example.mefit.Contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.mefit.R;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    List<ModalContact> modalContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getCategories();
    }
    private void getCategories(){
        modalContactList = new ArrayList<>();
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",0));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",1));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",2));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",3));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",4));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",5));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",6));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",7));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",8));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",9));
        modalContactList.add(new ModalContact("https://lh3.googleusercontent.com/-BYEF0dI0X9U/YfT1tCd_SRI/AAAAAAAAfDQ/IHqkskQYtBoX6XKfmseBd2n6Y8JxPUDiQCNcBGAsYHQ/s1600/1643443634077766-0.png"
                ,"Medico cirujano y partero","CDMX, Tlahuac","https://blogger.googleusercontent.com/img/a/AVvXsEjCSJX_NMUwmJlPO-ggSAc3BJKk_MPp5LyFcrZDX79I5k4R0W73RJMx_Qk0VJcXQueDIqABpp4Hmiaovwf-DMMvteM0Fit7Eo-jOXZzdgkLqNqVzoMPeUYmpX0fJydZO5m2lheo1XB9w_BGojloGMAuLl_nkB1bJPAobTnB5rJqKuY-FyT_JuzsXamA=s320"
                ,"Agendar cita",10));

        AdapterContact adapterContact = new AdapterContact(modalContactList, this, new AdapterContact.OnItemClickListener() {
            @Override
            public void OnItemClick(ModalContact item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.idRVContacts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterContact);
    }
    public void moveToDescription(ModalContact item){
        if(item.getID()==0){
            Toast.makeText(ContactActivity.this, "Hola prro", Toast.LENGTH_SHORT).show();
        }
    }

}