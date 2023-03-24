/*Crea una aplicación que le pida dos números al usuario y este pueda elegir entre sumar, 
restar, multiplicar y dividir. La aplicación debe tener una función para cada operación matemática
y deben devolver sus resultados para imprimirlos en el main.  */
package eggprojects.Guia4.Ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int num1, num2, opcion;
        double resultado;

        System.out.println("Ingresar dos números:");
        num1 = leer.nextInt();
        num2 = leer.nextInt();

        System.out.println("Ingresar opcion de 1 a 4:\n"
                + "1. Sumar\n"
                + "2. Restar\n"
                + "3. Multiplicar\n"
                + "4. Dividir");
        opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                resultado = sumar(num1, num2);
                System.out.println("La suma es: " + resultado);
                break;
            case 2:
                resultado = restar(num1, num2);
                System.out.println("La resta es: " + resultado);
                break;
            case 3:
                resultado = multiplicar(num1, num2);
                System.out.println("La multiplicacion es: " + resultado);
                break;
            case 4:
                resultado = dividir(num1, num2);
                System.out.println("La division es: " + resultado);
                break;
            default:
                System.out.println("De 1 a 4 gil");
        }
    }

    public static int sumar(int num1, int num2) {
        return num1 + num2;
    }

    public static int restar(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplicar(int num1, int num2) {
        return num1 * num2;
    }

    public static double dividir(double num1, double num2) {
        return num1 / num2;
    }
}
