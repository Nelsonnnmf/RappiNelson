package com.example.nelson.rappinelson.Modelo;

/**
 * Created by Nelson on 6/12/2017.
 */

public class Categoria {
    private String id;
    private String tipo;
    private String url;

    public Categoria(String id, String tipo, String url) {

        this.id = id;
        this.tipo = tipo;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

