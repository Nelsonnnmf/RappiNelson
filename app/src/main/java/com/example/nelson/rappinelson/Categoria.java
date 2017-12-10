package com.example.nelson.rappinelson;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Categoria extends Fragment {

    View view;
    ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_categorias, container, false);
        lista = (ListView) view.findViewById(R.id.listView);
        lista.setAdapter(
                new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_list_item_1,
                        getActivity().getResources().getStringArray(R.array.cat)));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)adapterView.getItemAtPosition(i);
                ListaApp listaApp = new ListaApp();
                Bundle args = new Bundle();
                args.putString("categoria", value);
                getActivity().getSupportFragmentManager()
                        .beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit).
                        replace(R.id.contenedor, new ListaApp()).commit();
            }
        });
        return view;
    }
}
