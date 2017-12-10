package com.example.nelson.rappinelson.Modelo;

import java.util.ArrayList;

/**
 * Created by Nelson on 7/12/2017.
 */

public class AppsColeccion {
    private static AppsColeccion appsColeccion;
    private ArrayList<App> apps;

    private AppsColeccion() {
        this.apps = new ArrayList<>();
    }

    public static AppsColeccion getInstance(){
        if (appsColeccion == null) appsColeccion = new AppsColeccion();
        return appsColeccion;
    }

    public ArrayList<App> getApps() {
        return apps;
    }

    public void setApps(ArrayList<App> apps) {
        this.apps = apps;
    }

    public ArrayList<App> buscarPorCategoria(String categoria){
        ArrayList<App> list = new ArrayList<>();
        for (int i = 0; i < this.apps.size(); i++){
            if (this.apps.get(i).getCategoria().getTipo().equals(categoria)) list.add(this.apps.get(i));
        }
        return list;
    }
}
