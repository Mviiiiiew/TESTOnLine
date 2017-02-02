package exemplo.webmobile.android.conexaoexterna;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Wasabi on 2/2/2017.
 */

public class ProductDAO extends _Default {

    public ProductSaleList SearchID(String ID) {
        ProductSaleList productSaleList = new ProductSaleList();
        DB db = new DB();
        try {
            ResultSet resultSet = db.select("SELECT * FROM usuario where id ='" + ID + "' ");
            if (resultSet != null) {
                while (resultSet.next()) {

                    productSaleList.setId(resultSet.getInt("id"));
                    productSaleList.setNome(resultSet.getString("nome"));
                    productSaleList.setEmail(resultSet.getString("email"));
                    productSaleList.setTelefone(resultSet.getString("telefone"));
                    resultSet.next();

                }
            }
        } catch (Exception ex) {
            this._mensagem = ex.getMessage();
            this._status = false;
        }


        return productSaleList;
    }

    public void salvar(ProductSaleList productSaleList) {


        String comando = "";
        comando = String.format("INSERT INTO usuario (nome, email, telefone) VALUES ('%s','%s','%s');",
                productSaleList.getNome(), productSaleList.getEmail(), productSaleList.getTelefone());


        DB db = new DB();
        db.execute(comando);
        this._mensagem = db._mensagem;
        this._status = db._status;
    }

    public void  apagar(int id) {
        String comando = String.format("DELETE FROM usuario WHERE id = %d;", id);
        DB db = new DB();
        db.execute(comando);
        this._mensagem = db._mensagem;
        this._status = db._status;
    }

    public ArrayList<UserList> getLista() {
        DB db = new DB();
        ArrayList<UserList> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select("SELECT * FROM usuario");
            if (resultSet != null) {
                while (resultSet.next()) {
                    UserList obj = new UserList();
                    obj.setId(resultSet.getInt("id"));
                    obj.setNome(resultSet.getString("nome"));
                    obj.setEmail(resultSet.getString("email"));
                    obj.setTelefone(resultSet.getString("telefone"));
                    lista.add(obj);
                    obj = null;
                }
            }
        } catch (Exception ex) {
            this._mensagem = ex.getMessage();
            this._status = false;
        }
        return lista;
    }
}
