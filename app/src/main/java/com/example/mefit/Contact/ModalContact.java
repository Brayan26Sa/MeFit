package com.example.mefit.Contact;

public class ModalContact {

    private String UrlImagePerson;
    private String Espe;
    private String Ubica;
    private String UrlImageUni;
    private String Agenda;
    private int ID;

    public String getUrlImagePerson() {
        return UrlImagePerson;
    }

    public void setUrlImagePerson(String urlImagePerson) {
        UrlImagePerson = urlImagePerson;
    }

    public String getEspe() {
        return Espe;
    }

    public void setEspe(String espe) {
        Espe = espe;
    }

    public String getUbica() {
        return Ubica;
    }

    public void setUbica(String ubica) {
        Ubica = ubica;
    }

    public String getUrlImageUni() {
        return UrlImageUni;
    }

    public void setUrlImageUni(String urlImageUni) {
        UrlImageUni = urlImageUni;
    }

    public String getAgenda() {
        return Agenda;
    }

    public void setAgenda(String agenda) {
        Agenda = agenda;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ModalContact(String urlImagePerson, String espe, String ubica, String urlImageUni, String agenda, int ID) {
        UrlImagePerson = urlImagePerson;
        Espe = espe;
        Ubica = ubica;
        UrlImageUni = urlImageUni;
        Agenda = agenda;
        this.ID = ID;
    }
}
