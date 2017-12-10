package com.example.nelson.rappinelson.Modelo;

import java.util.ArrayList;

/**
 * Created by Nelson on 6/12/2017.
 */

public class App {

    private String nombre;
    private ArrayList<Imagen> imagenes;
    private Precio precio;
    private FechaLanzamiento fechaLanzamiento;
    private Descripcion descripcion;
    private Categoria categoria;
    private Artista artista;

    public App(String nombre, ArrayList<Imagen> imagenes, Precio precio, FechaLanzamiento fechaLanzamiento, Descripcion descripcion, Categoria categoria, Artista artista) {
        this.nombre = nombre;
        this.imagenes = imagenes;
        this.precio = precio;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public FechaLanzamiento getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(FechaLanzamiento fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
