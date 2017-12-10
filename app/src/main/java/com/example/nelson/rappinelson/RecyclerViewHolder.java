package com.example.nelson.rappinelson;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nelson on 7/12/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView t1, t2;
    ImageView im;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        t1 = (TextView) itemView.findViewById(R.id.titulo);
        t2 = (TextView) itemView.findViewById(R.id.texto);
        im = (ImageView) itemView.findViewById(R.id.imagenlista);
    }
}
