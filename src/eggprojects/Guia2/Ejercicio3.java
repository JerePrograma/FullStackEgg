package eggprojects.Guia2;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String frase = leer.next();

        System.out.println(frase.toUpperCase());
        System.out.println(frase.toLowerCase());
    }
}