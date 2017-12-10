package com.example.nelson.rappinelson;

import android.provider.BaseColumns;

/**
 * Created by Nelson on 9/12/2017.
 */

public class Estructura {

    public Estructura(){


    }

    public static abstract class EstructuraBase implements BaseColumns
    {
        public static final String PRECIOTABLE_NAME = "Precio";
        public static final String PRECIOCOLUMNA_CANTIDAD = "Cantidad";
        public static final String PRECIOCOLUMNA_MONEDA = "Moneda";

        public static final String IMAGENTABLE_NAME = "Imagen";
        public static final String IMAGENCOLUMNA_URL = "Url";
        public static final String IMAGENCOLUMNA_IMAGEN = "Imagen";

        public static final String FECHALANZAMIENTOTABLE_NAME = "FechaLanzamiento";
        public static final String FECHALANZAMIENTOCOLUMNA_FECHA = "Fecha";
        public static final String FECHALANZAMIENTOCOLUMNA_DATE = "Date";

        public static final String DESCRIPCIONTABLE_NAME = "Descripcion";
        public static final String DESCRIPCIONCOLUMNA_CONTENIDO = "Contenido";
        public static final String DESCRIPCIONCOLUMNA_DERECHOSAUTOR = "DerechosAutor";
        public static final String DESCRIPCIONTABLE_TITULO = "Titulo";
        public static final String DESCRIPCIONCOLUMNA_IDDESCRIPCION = "IdDescripcion";
        public static final String DESCRIPCIONCOLUMNA_LINK = "Link";

        public static final String CATEGORIATABLE_NAME = "Categoria";
        public static final String CATEGORIACOLUMNA_IDCATEGORIA = "IdCategoria";
        public static final String CATEGORIACOLUMNA_TIPO = "Tipo";
        public static final String CATEGORIATABLE_URL = "Url";

        public static final String ARTISTATABLE_NAME = "Artista";
        public static final String ARTISTACOLUMNA_URL = "Url";
        public static final String ARTISTACOLUMNA_NOMBRE = "Nombre";

        public static final String APPTABLE_NAME = "App";
        public static final String APPCOLUMNA_IMAGENID = "ImagenId";
        public static final String APPCOLUMNA_PRECIOID = "PrecioId";
        public static final String APPTABLE_FECHALANZAMIENTOID = "FechaLanzamientoId";
        public static final String APPCOLUMNA_NOMBRE = "Nombre";
        public static final String APPCOLUMNA_DESCRIPCION = "DrescripcionId";
        public static final String APPCOLUMNA_CATEGORIA = "CategoriaId";
        public static final String APPCOLUMNA_ARTISTA = "ArtistaId";

    }
}
