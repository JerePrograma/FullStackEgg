/*Diseñe una función que pida el nombre y la edad de N personas e imprima los datos de las personas ingresadas por teclado 
e indique si son mayores o menores de edad. Después de cada persona, el programa debe preguntarle al usuario 
si quiere seguir mostrando personas y frenar cuando el usuario ingrese la palabra “No”.
 */
package eggprojects.Guia4.Ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de personas etc");
        int N = leer.nextInt();
        edadPersonas(N);
    }

    public static void edadPersonas(int N) {
        String opcion;
        for (int i = 0; i < N; i++) {
            System.out.println("Ingrese el nombre de la persona");
            String nombrePersona = leer.next();
            System.out.println("Ingresa la edad");
            int edad = leer.nextInt();
            if (edad >= 18) {
                System.out.println("Es mayor de edad");
            } else {
                System.out.println("Es menor de edad");
            }
            System.out.println("Desea continuar?");
            opcion = leer.next();
            if (opcion.equalsIgnoreCase("NO")) {
                break;
            }
        }
    }
}
