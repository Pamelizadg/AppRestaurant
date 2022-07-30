package cl.desafiolatam.apprestaurantefinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MenuDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Menu.db";

    private static final String SQL_CREATE_MENU =
            "CREATE TABLE " + MenuContract.MenuDatos.TABLE_NAME + " (" +
                    MenuContract.MenuDatos._ID + " INTEGER PRIMARY KEY," +
                    MenuContract.MenuDatos.COLUMN_NAME_NOMBRE + " TEXT," +
                    MenuContract.MenuDatos.COLUMN_NAME_DESCRIPCION + " TEXT," +
                    MenuContract.MenuDatos.COLUMN_NAME_PRECIO + " TEXT)";

    private static final String SQL_DELETE_PERSONAS =
            "DROP TABLE IF EXISTS " + MenuContract.MenuDatos.TABLE_NAME;

    public MenuDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_DELETE_PERSONAS);
        db.execSQL(SQL_CREATE_MENU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PERSONAS);
        onCreate(db);
    }
}
