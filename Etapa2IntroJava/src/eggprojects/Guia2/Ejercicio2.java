package eggprojects.Guia2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el valor de dos números");
        int num1 = leer.nextInt();
        int num2 = leer.nextInt();

        int suma = num1 + num2;

        System.out.println("El resultado de la suma es: " + suma);
    }
}