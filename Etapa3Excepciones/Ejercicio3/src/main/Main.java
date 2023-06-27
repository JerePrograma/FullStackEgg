//Defina una clase llamada DivisionNumero. En el método main utilice un Scanner para leer dos
//números en forma de cadena. A continuación, utilice el método parseInt() de la clase Integer,
//para convertir las cadenas al tipo int y guardarlas en dos variables de tipo int. Por ultimo realizar
//una división con los dos numeros y mostrar el resultado.
package main;

import entidad.DivisionNumero;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Por favor, introduce el primer número:");
        String num1Str = scanner.next();

        System.out.println("Por favor, introduce el segundo número:");
        String num2Str = scanner.next();

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        try {
            int resultado = DivisionNumero.dividirNumeros(num1, num2);
            System.out.println("El resultado de la división es: " + resultado);
        } catch (Exception e) {
            
        }

    }
}
