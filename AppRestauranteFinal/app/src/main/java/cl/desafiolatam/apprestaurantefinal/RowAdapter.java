package cl.desafiolatam.apprestaurantefinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RowAdapter extends BaseAdapter {
    Context context;
//    String nombreMenu[];
//    String descripcionMenu[];
//    String precioMenu[];
    LayoutInflater inflater;
    Menu menu[];
    SQLiteDatabase db;
    Integer count;
    Cursor cursor;

   /* public RowAdapter(Context context, String nombreMenu[], String descripcionMenu[], String precioMenu[]){
        this.context = context;
        this.nombreMenu = nombreMenu;
        this.descripcionMenu = descripcionMenu;
        this.precioMenu = precioMenu;
        this.inflater = (LayoutInflater.from(context));
    }

    public RowAdapter(Context context, Menu menu[]) {
        this.context = context;
        this.menu = menu;
        this.inflater = (LayoutInflater.from(context));
    }*/

    public RowAdapter(Context context, SQLiteDatabase db, Integer count){
        this.context = context;
        this.db = db;
        this.count = count;

        this.inflater = (LayoutInflater.from(context));

        String[] projection = {
                BaseColumns._ID,
                MenuContract.MenuDatos.COLUMN_NAME_NOMBRE,
                MenuContract.MenuDatos.COLUMN_NAME_DESCRIPCION,
                MenuContract.MenuDatos.COLUMN_NAME_PRECIO,
        };

        this.cursor = db.query(MenuContract.MenuDatos.TABLE_NAME,projection,null,null,null,null,null);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView = inflater.inflate(R.layout.list_row, null);

        TextView nombre = convertView.findViewById(R.id.nombre_menu);
        TextView descripcion = convertView.findViewById(R.id.descripcion_menu);
        TextView precio = convertView.findViewById(R.id.precio_menu);

            if(cursor != null){
                if(cursor.moveToPosition(position)){
                    nombre.setText(cursor.getString(cursor.getColumnIndexOrThrow(MenuContract.MenuDatos.COLUMN_NAME_NOMBRE)));
                    descripcion.setText(cursor.getString(cursor.getColumnIndexOrThrow(MenuContract.MenuDatos.COLUMN_NAME_DESCRIPCION)));
                    precio.setText(cursor.getString(cursor.getColumnIndexOrThrow(MenuContract.MenuDatos.COLUMN_NAME_PRECIO)));
                }
            }
       /* nombre.setText(menu[position].getNombre());
        descripcion.setText(menu[position].getDescripcion());
        precio.setText(menu[position].getPrecio());
        */
       /* nombre.setText(nombreMenu[position]);
        descripcion.setText(descripcionMenu[position]);
        precio.setText(precioMenu[position]);
        */
        return convertView;
    }
}
