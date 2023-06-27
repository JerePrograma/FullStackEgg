//Escribir un programa en Java que juegue con el usuario a adivinar un número. La computadora
//debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo. Para
//ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el
//número que tiene que adivinar es mayor o menor que el que ha introducido el usuario. Cuando
//consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario
//ha intentado adivinar el número. Si el usuario introduce algo que no es un número, se debe
//controlar esa excepción e indicarlo por pantalla. En este último caso también se debe contar el
//carácter fallido como un intento.
package main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Random random = new Random();
        int aleatorio = random.nextInt(500) + 1;
        boolean noAdivina = true;
        int intentos = 0;
        int adivinar = 0;
        do {
            System.out.println("Ingresa un número entre 1 y 500 para adivinar");
            intentos++;
            try {
                String adivino = leer.next();
                adivinar = Integer.parseInt(adivino);
                if (adivinar > aleatorio) {
                    System.out.println("Te pasaste!!");
                } else if (adivinar < aleatorio) {
                    System.out.println("Todavía te falta!");
                } else {
                    System.out.println("Adivinaste!!");
                    noAdivina = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO se ingresó un número");
            }
        } while (noAdivina);
        System.out.println("Se intentó adivinar " + intentos + " veces!!");
    }
}
