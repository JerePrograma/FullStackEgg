package servicio;
//Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
//eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
//Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
//Realizar un menú para lograr todas las acciones previamente mencionadas.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoServicio {

    public void introducirProducto(HashMap<String, Double> productos, Scanner leer) {
        boolean bucle = true;
        do {
            System.out.println("Ingrese el nombre del producto");
            String nombre = leer.next();
            System.out.println("Ingrese el precio del producto");
            double precio = leer.nextDouble();
            productos.put(nombre, precio);
            System.out.println("Desea agregar otro elemento?");
            if (leer.next().equalsIgnoreCase("N")) {
                bucle = false;
            }
        } while (bucle);
    }

    public void modificarPrecio(HashMap<String, Double> productos, Scanner leer) {
        System.out.println("Ingrese el producto que desea modificar");
        String producto = leer.next();
        System.out.println("Ingrese el precio que desea modificar");
        double precioActual = leer.nextDouble();
//key
        productos.replace(producto, precioActual);
    }

    public void eliminarProducto(HashMap<String, Double> productos, Scanner leer) {
        System.out.println("Ingrese el producto que desea elimimar");
        String producto = leer.next();
        productos.remove(producto);
    }

    public void mostrarProductos(HashMap<String, Double> productos) {
        for (Map.Entry<String, Double> producto : productos.entrySet()) {
            System.out.println("Producto: " + producto.getKey() + " precio: " + producto.getValue());
        }
    }
}
