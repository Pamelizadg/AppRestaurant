package cl.desafiolatam.apprestaurantefinal;

import android.content.ContentValues;

public class Menu {
    String nombre;
    String descripcion;
    String precio;

    public Menu(String nombre, String descripcion, String precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(MenuContract.MenuDatos.COLUMN_NAME_NOMBRE, nombre);
        values.put(MenuContract.MenuDatos.COLUMN_NAME_DESCRIPCION, descripcion);
        values.put(MenuContract.MenuDatos.COLUMN_NAME_PRECIO, precio);

        return values;
    }
}
