package com.example.nelson.rappinelson.Modelo;

/**
 * Created by Nelson on 6/12/2017.
 */

public class FechaLanzamiento {

    private String fecha;
    private String date;

    public FechaLanzamiento(String fecha, String date) {
        this.fecha = fecha;
        this.date = date;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
