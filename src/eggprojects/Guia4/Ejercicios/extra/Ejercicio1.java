/*1. Implementar una función que permita obtener un número entero aleatorio 
comprendido entre dos límites que introduciremos por teclado. 
El número obtenido se debe mostrar por pantalla.*/
package eggprojects.Guia4.Ejercicios.extra;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el límite minimo");
        int min = leer.nextInt();
        System.out.println("Ingresa el límite maximo");
        int max = leer.nextInt();
        int numeroAleatorio = numAleatorio(min, max);
        System.out.println("El número aleatorio es: " + numeroAleatorio);
    }

    public static int numAleatorio(int min, int max) {
        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }
}
