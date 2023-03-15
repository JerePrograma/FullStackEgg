/*Realizar un programa que lea 4 números (comprendidos entre 1 y 20) 
e imprima el número ingresado seguido de tantos asteriscos como indique su valor. */
package eggprojects.Guia3.Guia;

import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int cantidad = 10;
        String numCadena = "";
        String num;
        int valorCadena;
        for (int j = 0; j < cantidad; j++) {
            System.out.println("Ingrese un número");
            num = leer.next();
            numCadena += num;
        }
        for (int i = 0; i < cantidad; i++) {
            System.out.print(Integer.valueOf(numCadena.substring(i, i + 1)));
            for (int j = 0; j < Integer.valueOf(numCadena.substring(i, i + 1)); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}