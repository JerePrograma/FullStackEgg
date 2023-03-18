/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eggprojects.guia5.Extras;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jerem
 */
public class Ejercicio6V2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char[][] matriz = new char[20][20];
        String palabra;
        Random random = new Random();
        int aleatorio;
        //pide palabras y las ingresa a la matriz
        for (int i = 0; i < 5; i++) {
            aleatorio = random.nextInt(20);
            do {
                System.out.println("Ingresa una palabra de 3 a 5 caracteres");
                palabra = leer.next();
            } while (palabra.length() > 5 || palabra.length() < 3);
            for (int j = 0; j < palabra.length(); j++) {
                matriz[aleatorio][j] = palabra.charAt(j);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == '\u0000') {
                    matriz[i][j] = (char) ('0' + random.nextInt(10));
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
