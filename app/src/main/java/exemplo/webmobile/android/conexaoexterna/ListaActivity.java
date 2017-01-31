package exemplo.webmobile.android.conexaoexterna;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class ListaActivity extends ActionBarActivity {

    private ListView listViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(this,new Usuario().getLista());
        listViewUsuario = (ListView) findViewById(R.id.listViewUsuario);
        listViewUsuario.setAdapter( usuarioAdapter);


    }



}
