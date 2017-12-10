package com.example.nelson.rappinelson;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nelson.rappinelson.Modelo.App;
import com.example.nelson.rappinelson.Modelo.AppsColeccion;
import com.example.nelson.rappinelson.RestClient.ArticuloRestClient;

import java.util.ArrayList;


public class ListaApp extends Fragment {

    View view;
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    boolean dinamico=false;
    String categoria = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lista_app, container, false);
        recyclerView = view.findViewById(R.id.recycler_view1);
        if (recyclerView == null){
            dinamico = true;
            recyclerView = view.findViewById(R.id.recycler_view2);
        }

        if (getArguments() != null) {
            categoria = getArguments().getString("categiroa");
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        if(AppsColeccion.getInstance().getApps().isEmpty())
        ArticuloRestClient.getInstance(this).getArticulosRequest();
        else refresh();
        return view;
    }

    public void refresh(){
        if(categoria.equals(""))
        adapter = new RecyclerAdapter(getContext(), AppsColeccion.getInstance().getApps(), getActivity());
        else adapter = new RecyclerAdapter(getContext(), AppsColeccion.getInstance().buscarPorCategoria(categoria), getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        if (dinamico == false)
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        else recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }
}
