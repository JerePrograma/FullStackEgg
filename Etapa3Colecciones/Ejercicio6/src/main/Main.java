/*Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.*/
package main;

import java.util.HashMap;
import servicio.ProductosServicio;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Double> productos = new HashMap();
        ProductosServicio ps = new ProductosServicio();
        for (int i = 0; i < 3; i++) {
            ps.introducirElemento(productos);
        }
        System.out.println("Mostrar productos");
        ps.mostrarProductosConPrecio(productos);
        System.out.println("Modificar precio");
        ps.modificarPrecio(productos);
        System.out.println("Mostrar productos");
        ps.mostrarProductosConPrecio(productos);
        System.out.println("Eliminar producto");
        ps.eliminarProducto(productos);
        System.out.println("Mostrar productos");
        ps.mostrarProductosConPrecio(productos);
    }
}
