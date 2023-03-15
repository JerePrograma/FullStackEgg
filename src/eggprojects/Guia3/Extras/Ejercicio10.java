/*Realice un programa para que el usuario adivine el resultado de una multiplicación
entre dos números generados aleatoriamente entre 0 y 10. 
El programa debe indicar al usuario si su respuesta es o no correcta. 
En caso que la respuesta sea incorrecta se debe permitir al usuario ingresar su respuesta nuevamente. 
Para realizar este ejercicio investigue como utilizar la función Math.random() de Java.
 */
package eggprojects.Guia3.Extras;

import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int random = (int) (Math.random() * 10 * Math.random() * 10);
        int num;
        boolean adivino = false;
        do {
            System.out.println("Ingresá un número para adivinar");
            num = leer.nextInt();
            if (num == random) {
                adivino = true;
            } else {
                int diferencia = Math.abs(num - random);
                if (diferencia <= 2) {
                    System.out.println("Caliente!");
                } else if (diferencia <= 5) {
                    System.out.println("Tibio");
                } else {
                    System.out.println("Frío :c");
                }
            }
        } while (!adivino);
    }
}
