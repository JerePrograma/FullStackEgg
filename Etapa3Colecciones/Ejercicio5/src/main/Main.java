package main;

import java.util.HashSet;
import java.util.Scanner;
import servicio.PaisServicio;
//Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
//usaremos un conjunto.

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PaisServicio ps = new PaisServicio();
        HashSet<String> paises = ps.cargarPaises(leer);
        System.out.println("Ordenar y mostrar");
        System.out.println("------------------------");
        ps.ordernarYmostrar(paises);
        System.out.println("Eliminar pais");
        System.out.println("------------------------");
        ps.eliminarPais(paises, leer);
        System.out.println("Mostrar");
        System.out.println("------------------------");
        ps.ordernarYmostrar(paises);
    }
}
