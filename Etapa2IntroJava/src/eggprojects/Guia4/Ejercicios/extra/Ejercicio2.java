/*2. Implementar una función que permita obtener el valor absoluto de un número positivo y otra que obtenga la raíz cuadrada. 
Para ello utilice los métodos abs() y sqrt() de la clase Math. */
package eggprojects.Guia4.Ejercicios.extra;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese un número");
        double numero = leer.nextInt();
        double absoluto = valorAbsoluto(numero);
        double cuadrado = valorCuadrado(numero);
        System.out.println("El valor absoluto del número es " + absoluto);
        System.out.println("El valor de la raiz del número es " + cuadrado);
        
        
    }

    public static double valorAbsoluto(double numero) {
        return Math.abs(numero);
    }

    public static double valorCuadrado(double numero) {
        return Math.sqrt(numero);
    }
}
