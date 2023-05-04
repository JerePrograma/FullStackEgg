/*1. Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.*/
package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercio1y2 {

    public static void main(String[] args) {
        ArrayList<String> razaPerros = new ArrayList();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String respuesta;
        do {
            System.out.println("Ingrese la raza de perro que desea guardar");
            razaPerros.add(leer.next());
            System.out.println("Desea ingresar otro perro? S/N");
            respuesta = leer.next();
        } while (!respuesta.equals("N"));

        for (String razaPerro : razaPerros) {
            System.out.println(razaPerro);
        }
        System.out.println("Ingrese un perro a ELIMINAR");
        String perroEliminar = leer.next();
        Iterator iterador = razaPerros.iterator();
        boolean noEncontrado = true;
        while (iterador.hasNext()) {
            if (iterador.next().equals(perroEliminar)) {
                iterador.remove();
                noEncontrado = false;
            }
        }
        System.out.println("-----------------------------");
        if (noEncontrado) {
            System.out.println("NO se encontró el perro a eliminar");
        }
        Collections.sort(razaPerros);
        for (String razaPerro : razaPerros) {
            System.out.println(razaPerro);
        }
    }
//Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
//un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
//está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
//ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
//la lista ordenada.
}
