package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(url, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {//ES LA CONSULA
        try {
            conectarBase();//esto es por si está desconectado, la conecta
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            //Acá estamos diciendo que esta sentencia, va a usar la consulta SQL que tiene por parámetro
            //INSERT INTO ....... ETC
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            //Select nombre from producto

        } catch (Exception e) {
            throw e;
        }
    }
}
