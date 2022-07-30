package cl.desafiolatam.apprestaurantefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;



/*    String nombreMenu[] = {"Express", "Regalon", "De Lujo", "Exacto"};
    String descripcionMenu[] = {"Papas fritas, pollo, entrada y bebida", "Pure, vienesas, jugo y fruta de postre",
            "Papas fritas, filete de vacuno, entrada, postre y bebida", "Papas fritas, pollo, entrada, postre y bebida"};
    String precioMenu[] = {"$5990", "$3490", "$8990", "$7390"};
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Menu menu[] = new Menu[4];
        menu[0] = new Menu("Express","Papas fritas, pollo, entrada y bebida", "$5990");
        menu[1] = new Menu("Regalon","Pure, vienesas, jugo y fruta de postre", "$3490");
        menu[2] = new Menu("De Lujo","Papas fritas, filete de vacuno, entrada, postre y bebida", "$8990");
        menu[3] = new Menu("Exacto","Papas fritas, pollo, entrada, postre y bebida", "$7390");

        MenuDBHelper dbHelper = new MenuDBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);

        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menu[0].toContentValues());
        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menu[1].toContentValues());
        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menu[2].toContentValues());
        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menu[3].toContentValues());

        SQLiteDatabase dbReader = dbHelper.getReadableDatabase();


        listView = findViewById(R.id.simpleListView);
       // RowAdapter rowAdapter = new RowAdapter(getApplicationContext(), menu);
        RowAdapter rowAdapter = new RowAdapter(getApplicationContext(),dbReader,menu.length);
        listView.setAdapter(rowAdapter);

    }

}