package exemplo.webmobile.android.conexaoexterna;

import java.sql.ResultSet;

/**
 * Created by Wasabi on 2/2/2017.
 */

public class ProductDAO extends _Default{

    public ProductSaleList SearchID(String ID) {
        ProductSaleList productSaleList = new ProductSaleList();
        DB db = new DB();
        try {
            ResultSet resultSet = db.select("SELECT * FROM usuario where id ='" + ID + "' ");
            if (resultSet != null) {
                while (resultSet.next ()) {

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
}
