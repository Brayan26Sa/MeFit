package com.example.mefit.Aprende;

import android.widget.ImageView;
import android.widget.TextView;

public class ModalAprende {

    private String TitleA,InfoA;
    private String Aprende;
    private int ID;

    public ModalAprende(String titleA, String infoA, String aprende, int ID) {
        TitleA = titleA;
        InfoA = infoA;
        Aprende = aprende;
        this.ID = ID;
    }

    public String getTitleA() {
        return TitleA;
    }

    public void setTitleA(String titleA) {
        TitleA = titleA;
    }

    public String getInfoA() {
        return InfoA;
    }

    public void setInfoA(String infoA) {
        InfoA = infoA;
    }

    public String getAprende() {
        return Aprende;
    }

    public void setAprende(String aprende) {
        Aprende = aprende;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
