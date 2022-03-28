package com.example.mefit.PDF;

public class Modalpdf {

    private String TitlePDF;
    private String UriImgPDF;
    private String TypeDocument;
    private int ID;

    public String getTypeDocument() {
        return TypeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        TypeDocument = typeDocument;
    }

    public String getTitlePDF() {
        return TitlePDF;
    }

    public void setTitlePDF(String titlePDF) {
        TitlePDF = titlePDF;
    }

    public String getUriImgPDF() {
        return UriImgPDF;
    }

    public void setUriImgPDF(String uriImgPDF) {
        UriImgPDF = uriImgPDF;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Modalpdf(String titlePDF, String uriImgPDF, String typeDocument, int ID) {
        TitlePDF = titlePDF;
        UriImgPDF = uriImgPDF;
        TypeDocument = typeDocument;
        this.ID = ID;
    }
}
