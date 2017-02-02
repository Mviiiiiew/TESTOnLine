package exemplo.webmobile.android.conexaoexterna;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListaActivity extends ActionBarActivity {

    ListView listViewUsuario;

    ProductDAO productDAO;
    ProductListManualAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listViewUsuario = (ListView) findViewById(R.id.listViewUsuario);
        productDAO = new ProductDAO();
        final ArrayList<UserList> ID = productDAO.getLista();
        adapter = new ProductListManualAdapter(this, ID);

        listViewUsuario.setAdapter(adapter);
        listViewUsuario.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                productDAO.apagar(((UserList) adapter.getItem(position)).getId());
                ProductListManualAdapter adapter = new ProductListManualAdapter(ListaActivity.this, ID);
                ID.remove(position);
                listViewUsuario.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        listViewUsuario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int ID = ((UserList) adapter.getItem(position)).getId();
                Log.d("IDxxx", "ID" + ID);


            }


        });


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

      /*  listViewUsuario = (ListView) findViewById(R.id.listViewUsuario);

        listViewUsuario.setAdapter(usuarioAdapter);

        usuarioAdapter.notifyDataSetChanged();*/


    }


}
