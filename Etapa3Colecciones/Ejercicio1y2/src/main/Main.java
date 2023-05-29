/*Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.*/
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> razas = new ArrayList();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean confirmacion = true;
        do {
            System.out.println("Ingrese la raza del perro");
            razas.add(leer.next().toUpperCase());
            System.out.println("Desea agregar otro perro? S/N");
            if (leer.next().equalsIgnoreCase("N")) {
                confirmacion = false;
            }
        } while (confirmacion);

        for (String raza : razas) {
            System.out.println(raza);
        }
        System.out.println("Ingrese el perro que desea ELIMINAR");
        String perroELIMINAR = leer.next();
        boolean noEncotrado = true;
        Iterator it = razas.iterator();
        while (it.hasNext()) {
            if (it.next().equals(perroELIMINAR)) {
                it.remove();
                noEncotrado = false;
            }
        }

        if (noEncotrado) {
            System.out.println("NO se encontró el perro a eliminar");
        }
        Collections.sort(razas);
        for (String raza : razas) {
            System.out.println(raza);
        }
    }
//Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
//un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
//está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
//ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
//la lista ordenada.
}
