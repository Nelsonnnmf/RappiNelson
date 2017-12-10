package com.example.nelson.rappinelson.RestClient;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.nelson.rappinelson.ListaApp;
import com.example.nelson.rappinelson.Modelo.App;
import com.example.nelson.rappinelson.Modelo.AppsColeccion;
import com.example.nelson.rappinelson.Modelo.Artista;
import com.example.nelson.rappinelson.Modelo.Categoria;
import com.example.nelson.rappinelson.Modelo.Descripcion;
import com.example.nelson.rappinelson.Modelo.FechaLanzamiento;
import com.example.nelson.rappinelson.Modelo.Imagen;
import com.example.nelson.rappinelson.Modelo.Precio;
import com.example.nelson.rappinelson.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Nelson on 5/12/2017.
 */
public class ArticuloRestClient {

    private static String urlMovie;
    private static ArticuloRestClient articuloRestClient;
    private ListaApp fragment;

    /*
    * Create un fragmento ahi que sera el que tenga esperate ahi,
     * solo se va a mostrar esa vuelta, porque si es asi entonces pongamos esa monda en
    * */

    private ArticuloRestClient(ListaApp fragment) {
        this.fragment = fragment;

    }

    public static ArticuloRestClient getInstance(ListaApp fragment){
        if( articuloRestClient == null ) articuloRestClient = new ArticuloRestClient(fragment);
        return articuloRestClient;
    }


    public void getArticulosRequest() {
        urlMovie = "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";
        RequestQueue requestQueue = Volley.newRequestQueue(fragment.getActivity());
        final ProgressDialog progressDialog = new ProgressDialog(fragment.getActivity());
        progressDialog.setMessage(fragment.getActivity().getResources().getString(R.string.loading));
        progressDialog.show();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlMovie, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        deserializeJSONObject(response);
                        //Log.i("peticion", response.toString());
                        progressDialog.dismiss();
                        fragment.refresh();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(fragment.getActivity(), "Error on request", Toast.LENGTH_SHORT).show();
                Log.e("getMoviesError", error.toString());
            }
        });
        requestQueue.add(request);
    }

    //deserialize json object and add it to model
    public void deserializeJSONObject(JSONObject object) {
        try {
            JSONObject appResults = object.getJSONObject("feed");
            JSONArray results = appResults.getJSONArray("entry");

            for (int i = 0; i < results.length(); i++) {
                String nombre = results.getJSONObject(i).getJSONObject("im:name").getString("label");
                JSONArray imagenesResult = results.getJSONObject(i).getJSONArray("im:image");
                ArrayList<Imagen> imagenes = new ArrayList<>();
                for (int j = 0; j < imagenesResult.length(); j++){
                    Imagen image = new Imagen(
                            imagenesResult.getJSONObject(j).getString("label"),
                            loadBitmap(imagenesResult.getJSONObject(j).getString("label")),
                            Integer.parseInt(imagenesResult.getJSONObject(j).getJSONObject("attributes").getString("height"))
                    );
                    imagenes.add(image);
                }
                Precio precio = new Precio(
                        Double.parseDouble(results.getJSONObject(i).getJSONObject("im:price").getJSONObject("attributes").getString("amount")),
                        results.getJSONObject(i).getJSONObject("im:price").getJSONObject("attributes").getString("currency")
                );
                Artista artista = new Artista(
                        results.getJSONObject(i).getJSONObject("im:artist").getString("label"),
                        results.getJSONObject(i).getJSONObject("im:artist").getJSONObject("attributes").getString("href")
                );
                FechaLanzamiento fechaLanzamiento = new FechaLanzamiento(
                        results.getJSONObject(i).getJSONObject("im:releaseDate").getString("label"),
                        results.getJSONObject(i).getJSONObject("im:releaseDate").getJSONObject("attributes").getString("label")
                );
                Categoria categoria = new Categoria(
                        results.getJSONObject(i).getJSONObject("category").getJSONObject("attributes").getString("im:id"),
                        results.getJSONObject(i).getJSONObject("category").getJSONObject("attributes").getString("term"),
                        results.getJSONObject(i).getJSONObject("category").getJSONObject("attributes").getString("scheme")

                );
                Descripcion descripcion = new Descripcion(
                        results.getJSONObject(i).getJSONObject("summary").getString("label"),
                        results.getJSONObject(i).getJSONObject("rights").getString("label"),
                        results.getJSONObject(i).getJSONObject("title").getString("label"),
                        results.getJSONObject(i).getJSONObject("id").getJSONObject("attributes").getString("im:id"),
                        results.getJSONObject(i).getJSONObject("link").getJSONObject("attributes").getString("href")
                );

                AppsColeccion.getInstance().getApps().add(new App(
                        nombre,
                        imagenes,
                        precio,
                        fechaLanzamiento,
                        descripcion,
                        categoria,
                        artista
                ));
            }

            Log.i("nombre de la app", AppsColeccion.getInstance().getApps().get(0).getNombre());


        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("jsonErrorDes", e.getMessage());
        }



    }

    //load image from url and convert it on Bitmap to be able to show it in ImageView
    public Bitmap loadBitmap(String url) {
        URL newurl = null;
        try {
            newurl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap mIcon_val = null;
        try {
            mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = mIcon_val.getWidth();
        int height = mIcon_val.getHeight();
        float scaleWidth = ((float) 50) / width;
        float scaleHeight = ((float) 50) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                mIcon_val, 0, 0, width, height, matrix, false);
        mIcon_val.recycle();
        return resizedBitmap;
    }



}
