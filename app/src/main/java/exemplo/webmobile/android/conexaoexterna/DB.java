package exemplo.webmobile.android.conexaoexterna;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by evandro on 16/03/2015.
 */
public class DB extends _Default implements Runnable {

    private Connection conn;
    private String host = "10.0.3.2";
    private String db = "DbPos";
    private int port = 5432;
    private String user = "postgres";
    private String pass = "069705489";
    private String url = "jdbc:postgresql://%s:%d/%s";

    public DB() {
        super();
        this.url = String.format(url,host, port, db);
        conecta();
        disconecta();
    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,user,pass);



        }catch (Exception e){
            _mensagem = e.getMessage();
            _status = false;
        }
    }

    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            _mensagem = e.getMessage();
            _status = false;
        }
    }

    private void disconecta(){
        if (conn!= null){
            try{
                conn.close();
            }catch (Exception e){

            }finally {
                conn = null;
            }
        }
    }

    public ResultSet select(String query){
        conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){
            _status = false;
            _mensagem = e.getMessage();
        }
        return resultSet;
    }

    public ResultSet execute(String query){
        conecta();
        ResultSet resultSet = null;
        try {

            resultSet = new ExecuteDB(conn, query).execute().get();
        }catch (Exception e){
            _status = false;
            _mensagem = e.getMessage();
        }
        return resultSet;
    }

}
