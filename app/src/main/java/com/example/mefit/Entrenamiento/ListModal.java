package com.example.mefit.Entrenamiento;

import android.icu.text.CaseMap;

import java.io.Serializable;

public class ListModal {

    private String Title;
    private String Series;
    private String Day;
    private String Muscle;
    private String RM;
    private String urlToImage;
    private int ID;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSeries() {
        return Series;
    }

    public void setSeries(String series) {
        Series = series;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getMuscle() {
        return Muscle;
    }

    public void setMuscle(String muscle) {
        Muscle = muscle;
    }

    public String getRM() {
        return RM;
    }

    public void setRM(String RM) {
        this.RM = RM;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ListModal(String title, String series, String day, String muscle, String RM, String urlToImage, int ID) {
        Title = title;
        Series = series;
        Day = day;
        Muscle = muscle;
        this.RM = RM;
        this.urlToImage = urlToImage;
        this.ID = ID;
    }
}
