package com.example.nelson.rappinelson.Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nelson.rappinelson.Estructura;


/**
 * Created by Nelson on 9/12/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private static final String tipo = " TEXT";
    private static final String tipoint = " INTEGER";
    private static final String Coma = ",";

    //sentencia de cracion de base de datos (implementendo la estructura)
    private static final String PrecioSentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.PRECIOTABLE_NAME + " ("
                    + Estructura.EstructuraBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.PRECIOCOLUMNA_CANTIDAD + tipo + Coma +
                    Estructura.EstructuraBase.PRECIOCOLUMNA_MONEDA + tipo + " )";

    private static final String ImagenSentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.IMAGENTABLE_NAME + " ("
                    + Estructura.EstructuraBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.IMAGENCOLUMNA_URL + tipo + Coma +
                    Estructura.EstructuraBase.IMAGENCOLUMNA_IMAGEN + tipo + " )";

    private static final String FechaLanzamientoSentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.FECHALANZAMIENTOTABLE_NAME + " ("
                    + Estructura.EstructuraBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.FECHALANZAMIENTOCOLUMNA_FECHA + tipo + Coma +
                    Estructura.EstructuraBase.FECHALANZAMIENTOCOLUMNA_DATE + tipo + " )";

    private static final String DescripcionSentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.DESCRIPCIONTABLE_NAME + " ("
                    + Estructura.EstructuraBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.DESCRIPCIONCOLUMNA_CONTENIDO + tipo + Coma +
                    Estructura.EstructuraBase.DESCRIPCIONTABLE_TITULO + tipo + Coma +
                    Estructura.EstructuraBase.DESCRIPCIONCOLUMNA_IDDESCRIPCION + tipo + Coma +
                    Estructura.EstructuraBase.DESCRIPCIONCOLUMNA_LINK + tipo + Coma +
                    Estructura.EstructuraBase.DESCRIPCIONCOLUMNA_DERECHOSAUTOR + tipo + " )";

    private static final String CategoriaSentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.CATEGORIATABLE_NAME + " ("
                    + Estructura.EstructuraBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.CATEGORIACOLUMNA_IDCATEGORIA + tipo + Coma +
                    Estructura.EstructuraBase.CATEGORIACOLUMNA_TIPO + tipo + Coma +
                    Estructura.EstructuraBase.CATEGORIATABLE_URL + tipo + " )";

    private static final String ArtistaSentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.ARTISTATABLE_NAME + " ("
                    + Estructura.EstructuraBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.ARTISTACOLUMNA_NOMBRE + tipo + Coma +
                    Estructura.EstructuraBase.ARTISTACOLUMNA_URL + tipo + " )";

    private static final String AppSentencia =
            "CREATE TABLE " + Estructura.EstructuraBase.APPTABLE_NAME + " ("
                    + Estructura.EstructuraBase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Estructura.EstructuraBase.APPCOLUMNA_IMAGENID + tipo + Coma +
                    Estructura.EstructuraBase.APPCOLUMNA_PRECIOID + tipo + Coma +
                    Estructura.EstructuraBase.APPTABLE_FECHALANZAMIENTOID + tipo + Coma +
                    Estructura.EstructuraBase.APPCOLUMNA_NOMBRE + tipo + Coma +
                    Estructura.EstructuraBase.APPCOLUMNA_DESCRIPCION + tipo + Coma +
                    Estructura.EstructuraBase.APPCOLUMNA_CATEGORIA + tipo + Coma +
                    Estructura.EstructuraBase.APPCOLUMNA_ARTISTA + tipo + " )";

    //propiedades de base de datos

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ListaRegistros.sqlite";
    //si la tabla existe
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Estructura.EstructuraBase.PRECIOTABLE_NAME;


    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(PrecioSentencia);
        db.execSQL(ImagenSentencia);
        db.execSQL(FechaLanzamientoSentencia);
        db.execSQL(DescripcionSentencia);
        db.execSQL(CategoriaSentencia);
        db.execSQL(ArtistaSentencia);
        db.execSQL(AppSentencia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
