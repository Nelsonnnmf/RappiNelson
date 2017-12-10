package com.example.nelson.rappinelson.Modelo;

/**
 * Created by Nelson on 6/12/2017.
 */

public class Precio {

    private double cantidad;
    private String moneda;

    public Precio(double cantidad, String moneda) {
        this.cantidad = cantidad;
        this.moneda = moneda;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
