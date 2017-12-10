package com.example.nelson.rappinelson.Modelo;

/**
 * Created by Nelson on 6/12/2017.
 */

public class Artista {

    private String nombre;
    private String url;

    public Artista(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
