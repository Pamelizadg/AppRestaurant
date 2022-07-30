package cl.desafiolatam.apprestaurantefinal;

import android.provider.BaseColumns;

public final class MenuContract {
    private MenuContract() {}

    public static class MenuDatos implements BaseColumns{
        public static final String TABLE_NAME = "menu";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_DESCRIPCION = "descripcion";
        public static final String COLUMN_NAME_PRECIO = "precio";

    }
}
