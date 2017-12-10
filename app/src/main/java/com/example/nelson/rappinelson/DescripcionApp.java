package com.example.nelson.rappinelson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nelson.rappinelson.Modelo.AppsColeccion;


public class DescripcionApp extends Fragment {

    View view;
    ImageView imagen;
    TextView titulo, descripcion, creador, fecha_lanzamiento, url, precio, derechos_autor;
    int pos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_descripcion_app, container, false);

        titulo = (TextView) view.findViewById(R.id.titulo);
        descripcion = (TextView) view.findViewById(R.id.descripcion);
        url = (TextView) view.findViewById(R.id.url);
        creador = (TextView) view.findViewById(R.id.creador);
        fecha_lanzamiento = (TextView) view.findViewById(R.id.fecha_lanzamiento);
        precio = (TextView) view.findViewById(R.id.precio);
        derechos_autor = (TextView) view.findViewById(R.id.derechos_autor);
        imagen = (ImageView) view.findViewById(R.id.imagen);

        pos = getArguments().getInt("posicion");

        refresh();

        return view;
    }

    public void refresh(){
        titulo.setText("titulo: "+AppsColeccion.getInstance().getApps().get(pos).getDescripcion().getTitulo());
        descripcion.setText("Descripcion: "+AppsColeccion.getInstance().getApps().get(pos).getDescripcion().getContenido());
        url.setText("Link: "+AppsColeccion.getInstance().getApps().get(pos).getDescripcion().getLink());
        creador.setText("Creador: "+AppsColeccion.getInstance().getApps().get(pos).getArtista().getNombre());
        fecha_lanzamiento.setText("Fecha de lanzamiento: "+AppsColeccion.getInstance().getApps().get(pos).getFechaLanzamiento().getFecha());
        precio.setText("Precio: "+AppsColeccion.getInstance().getApps().get(pos).getPrecio().getCantidad()+ " "+
                AppsColeccion.getInstance().getApps().get(pos).getPrecio().getMoneda());
        derechos_autor.setText("Derechos de autor: "+AppsColeccion.getInstance().getApps().get(pos).getDescripcion().getDerechosAutor());
        imagen.setImageBitmap(AppsColeccion.getInstance().getApps().get(pos).getImagenes().get(0).getImagen());
    }
}
