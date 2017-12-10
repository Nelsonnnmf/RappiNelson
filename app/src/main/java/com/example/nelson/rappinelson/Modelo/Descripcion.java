package com.example.nelson.rappinelson.Modelo;

/**
 * Created by Nelson on 6/12/2017.
 */

public class Descripcion {

    private String contenido;
    private String derechosAutor;
    private String titulo;
    private String id;
    private String link;

    public Descripcion(String contenido, String derechosAutor, String titulo, String id, String link) {
        this.contenido = contenido;
        this.derechosAutor = derechosAutor;
        this.titulo = titulo;
        this.id = id;
        this.link = link;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDerechosAutor() {
        return derechosAutor;
    }

    public void setDerechosAutor(String derechosAutor) {
        this.derechosAutor = derechosAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
