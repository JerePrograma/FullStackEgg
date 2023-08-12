/*Escriba un programa que valide si una nota está entre 0 y 10, 
sino esta entre 0 y 10 la nota se pedirá de nuevo hasta que la nota sea correcta. */
package eggprojects.Guia3.Guia;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int nota = 6;
        while (nota > 0 && nota < 10) {
            System.out.println("Ingrese una nota");
            nota = leer.nextInt();
        }
    }
}
