package com.example.mefit.Settings;

public class SettingsModel {

    private String NameSettings;
    private String UrlImageSettings;
    private int ID;

    public String getNameSettings() {
        return NameSettings;
    }

    public void setNameSettings(String nameSettings) {
        NameSettings = nameSettings;
    }

    public String getUrlImageSettings() {
        return UrlImageSettings;
    }

    public void setUrlImageSettings(String urlImageSettings) {
        UrlImageSettings = urlImageSettings;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public SettingsModel(String nameSettings, String urlImageSettings, int ID) {
        NameSettings = nameSettings;
        UrlImageSettings = urlImageSettings;
        this.ID = ID;
    }
}
