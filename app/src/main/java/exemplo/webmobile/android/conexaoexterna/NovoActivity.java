package exemplo.webmobile.android.conexaoexterna;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NovoActivity extends ActionBarActivity {

    private Usuario usuario;
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private  ProductDAO productDAO;
    EditText edit_barcode;
    Button btn_Ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        usuario = new Usuario();
        productDAO = new ProductDAO();
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        edit_barcode = (EditText) findViewById(R.id.edit_barcode);
        btn_Ok = (Button) findViewById(R.id.btn_Ok);


        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                usuario.setId(bundle.getInt("id"));
                editTextNome.setText(bundle.getString("nome"));
                editTextEmail.setText(bundle.getString("email"));
                editTextTelefone.setText(bundle.getString("telefone"));

            }
        }
        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductSaleList productSaleList = new ProductSaleList();
                productSaleList.setId(productDAO.SearchID(edit_barcode.getText().toString()).getId());
                productSaleList.setNome(usuario.SearchID(edit_barcode.getText().toString()).getNome());

                String T = productSaleList.getNome();
                Log.d("NAME","NAME"+T);
                Toast.makeText(getApplicationContext(), "I" + T, Toast.LENGTH_LONG).show();
            }
        });
    }


    public void salvar(View view) {
        usuario.setNome(editTextNome.getText().toString());
        usuario.setEmail(editTextEmail.getText().toString());
        usuario.setTelefone(editTextTelefone.getText().toString());
        usuario.salvar();

        Toast.makeText(this, this.usuario.get_mensagem(), Toast.LENGTH_LONG).show();
        if (usuario.is_status())
            finish();
    }

    public void cancelar(View view) {
        finish();
    }
}
