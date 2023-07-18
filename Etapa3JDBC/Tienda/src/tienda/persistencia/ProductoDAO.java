package tienda.persistencia;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import tienda.entidades.Producto;

public class ProductoDAO extends DAO {

    public void selectUnParametro(String parametro) throws Exception {
        try {
            String sql = "SELECT " + parametro + " FROM producto";
            consultarBase(sql);
            System.out.printf("%-20s\n", parametro.toUpperCase());
            System.out.println("------------------------------------");
            if (parametro.equalsIgnoreCase("*")) {
                selectAll();
            } else {
                while (resultado.next()) {
                    System.out.printf("%-20s\n", resultado.getString(parametro));
                }
            }
        } catch (Exception e) {
            desconectarBase();
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void selectDosParametro(String parametro1, String parametro2) throws Exception {
        try {
            String sql = "SELECT " + parametro1 + ", " + parametro2 + " FROM producto";
            consultarBase(sql);
            System.out.printf("%-40s %-40s\n", parametro1.toUpperCase(), parametro2.toUpperCase());
            System.out.println("------------------------------------------------");
            while (resultado.next()) {
                System.out.printf("%-40s %-40s\n", resultado.getString(parametro1), resultado.getDouble(parametro2));
            }
        } catch (Exception e) {
            desconectarBase();
            throw e;
        } finally {
            desconectarBase();
        }
    }

    // c) Listar aquellos productos que su precio esté entre 120 y 202.
    public void listarPorPrecio(double precioMin, double precioMax) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN " + precioMin + " AND " + precioMax;
            consultarBase(sql);
            while (resultado.next()) {
                System.out.println("Código: " + resultado.getInt("codigo")
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Precio: " + resultado.getDouble("precio")
                        + ", Código Fabricante: " + resultado.getInt("codigo_fabricante"));
            }
        } finally {
            desconectarBase();
        }
    }

    // d) Buscar y listar todos los Portátiles de la tabla producto.
    public void listarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portátil%'";
            consultarBase(sql);
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                Double precio = resultado.getDouble("precio");
                System.out.println("Nombre: " + nombre + ", Precio: " + precio);
            }
        } catch (Exception e) {
            desconectarBase();
            throw e;
        } finally {
            desconectarBase();
        }
    }

    // e) Listar el nombre y el precio del producto más barato.
    public void obtenerProductoMasBarato() throws Exception {
        try {
            String sql = "SELECT * FROM producto ORDER BY precio ASC LIMIT 1";
            consultarBase(sql);
            if (resultado.next()) {
                System.out.println("Producto más barato: "
                        + ", Nombre: " + resultado.getString("nombre")
                        + ", Precio: " + resultado.getDouble("precio"));
            } else {
                System.out.println("No se encontraron productos.");
            }
        } finally {
            desconectarBase();
        }
    }

    // f) Ingresar un producto a la base de datos.
    public void agregarProducto(Producto p) throws Exception {
        try {
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES ("
                    + "'" + p.getNombre() + "',"
                    + p.getPrecio() + ","
                    + p.getCodigoFabricante() + ")";

            insertarModificarEliminar(sql);
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Error: El código de fabricante no existe en la base de datos. Por favor, introduce un código de fabricante válido.");
        } catch (Exception e) {
            throw e;
        }
    }

    // h) Editar un producto con datos a elección.
    public void editarProducto(Producto producto) {
        try {
            String sql = "UPDATE producto SET nombre='" + producto.getNombre()
                    + "', precio=" + producto.getPrecio()
                    + ", codigo_fabricante=" + producto.getCodigoFabricante()
                    + " WHERE codigo=" + producto.getCodigo();
            insertarModificarEliminar(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: El fabricante con el código " + producto.getCodigoFabricante() + " no existe.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int codigoProducto) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE codigo=" + codigoProducto;
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void selectAll() throws Exception {
        try {
            String sql = "SELECT * FROM producto";
            consultarBase(sql);
            System.out.printf("%-6s %-35s %-10s %-15s\n", "CODIGO", "NOMBRE", "PRECIO", "COD_FABRICANTE");
            System.out.println("------------------------------------------------------------------");
            while (resultado.next()) {
                System.out.printf("%-6d %-35s %-10.2f %-15d\n",
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getInt("codigo_fabricante"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

}
