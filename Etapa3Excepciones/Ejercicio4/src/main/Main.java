//Todas estas operaciones puede tirar excepciones a manejar, el ingreso por teclado puede
//causar una excepción de tipo InputMismatchException, el método Integer.parseInt() si la cadena
//no puede convertirse a entero, arroja una NumberFormatException y además, al dividir un
//número por cero surge una ArithmeticException. Manipule todas las posibles excepciones
//utilizando bloques try/catch para las distintas excepciones
package main;

import entidad.DivisionNumero;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Por favor, introduce el primer número:");
        String num1Str = scanner.next();

        System.out.println("Por favor, introduce el segundo número:");
        String num2Str = scanner.next();

        try {

            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            int resultado = DivisionNumero.dividirNumeros(num1, num2);

            System.out.println("El resultado de la división es: " + resultado);

        } catch (NumberFormatException e) {
            System.out.println("Por favor, asegúrate de introducir números válidos.");

        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero.");
        }
    }
}
