package eggprojects.guia5.Extras;

import java.util.Scanner;

/*Escriba un programa que averigüe si dos vectores de N enteros son iguales 
(la comparación deberá detenerse en cuanto se detecte alguna diferencia entre los elementos).*/
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");// \ = alt + 92

        System.out.println("Tamaño del vector:");

        int n = leer.nextInt();
        int[] vec1 = new int[n];
        int[] vec2 = new int[n];

        for (int i = 0; i < vec1.length; i++) {
            System.out.println("Ingresa los numeros del vector 1:");
            vec1[i] = leer.nextInt();
            System.out.println("Ingresa los numeros del vector 2:");
            vec2[i] = leer.nextInt();

        }
        boolean comparacion = true;

        for (int i = 0; i < vec2.length; i++) {
            if (vec1[i] != vec2[i]) {
                comparacion = false;
                System.out.println("No son iguales!");
                break;

            }

        }
        if (comparacion) {

            System.out.println("Son iguales!");
        }
    }
}
