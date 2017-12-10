package com.example.nelson.rappinelson;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nelson.rappinelson.Modelo.App;
import com.example.nelson.rappinelson.Modelo.AppsColeccion;

import java.util.ArrayList;

/**
 * Created by Nelson on 7/12/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<App> apps;
    Activity activity;

    public RecyclerAdapter(Context context, ArrayList<App> apps, Activity activity){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.apps = apps;
        this.activity = activity;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.t1.setText(apps.get(position).getNombre());
        holder.t2.setText(apps.get(position).getCategoria().getTipo());
        holder.im.setImageBitmap(apps.get(position).getImagenes().get(0).getImagen());
        holder.im.setOnClickListener(onClickListener);
        holder.im.setTag(holder);
    }

    View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) v.getTag();
            int position = recyclerViewHolder.getAdapterPosition();
            Bundle args = new Bundle();
            args.putInt("posicion", position);
            DescripcionApp fragment = new DescripcionApp();
            fragment.setArguments(args);
            ((MainActivity) activity).getSupportFragmentManager().
                    beginTransaction().replace(R.id.contenedor, fragment).addToBackStack(null).commit();
        }
    };

    @Override
    public int getItemCount() {
        return apps.size();
    }
}
