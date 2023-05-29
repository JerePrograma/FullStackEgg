package main;

import java.util.HashMap;
import java.util.Scanner;
import servicio.ProductoServicio;
//Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
//productos que venderemos y el precio que tendrán. Además, se necesita que la
//aplicación cuente con las funciones básicas.

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashMap<String, Double> productos = new HashMap();

        ProductoServicio ps = new ProductoServicio();
        boolean bandera = true;
        do {
            System.out.println("1- Introducir productos");
            System.out.println("2- Modificar precio");
            System.out.println("3- Eliminar producto");
            System.out.println("4- Mostrar productos");
            System.out.println("5- Salir");
            switch (leer.nextInt()) {
                case 1:
                    ps.introducirProducto(productos, leer);
                    break;
                case 2:
                    ps.modificarPrecio(productos, leer);
                    break;
                case 3:
                    ps.eliminarProducto(productos, leer);
                    break;
                case 4:
                    ps.mostrarProductos(productos);
                    break;
                case 5:
                    System.out.println("Desea continuar? S/N");
                    if (leer.next().equalsIgnoreCase("N")) {
                        bandera = false;
                    }
                    break;
                default:
                    System.out.println("NO se reconoce la opción ingresada");
            }
        } while (bandera);

    }
}
