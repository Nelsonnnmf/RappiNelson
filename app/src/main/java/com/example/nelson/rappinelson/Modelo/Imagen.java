package com.example.nelson.rappinelson.Modelo;

import android.graphics.Bitmap;

/**
 * Created by Nelson on 6/12/2017.
 */

public class Imagen {

    private String url;
    private Bitmap imagen;

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public Imagen(String url, Bitmap imagen, int altura) {

        this.url = url;
        this.imagen = imagen;
        this.altura = altura;
    }

    private int altura;

    public Imagen(String url, int altura) {
        this.url = url;
        this.altura = altura;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
