/*Escriba un programa que lea números enteros. 
Si el número es múltiplo de cinco debe detener la lectura y mostrar la cantidad de números leídos,
la cantidad de números pares y la cantidad de números impares. Al igual que en el ejercicio anterior los números negativos no deben sumarse. 
Nota: recordar el uso de la sentencia break. */
package eggprojects.Guia3.Extras;

import java.util.Scanner;

public class Ejercicio08 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int num;
        int contadorPar = 0;
        int contadorImpar = 0;
        int contador = 0;
        do {
            System.out.println("Ingrese un número");
            num = leer.nextInt();
            if (num > 0) {
                if (num % 2 == 0) {
                    contadorPar++;
                } else {
                    contadorImpar++;
                }
            }
            contador++;
        } while (!(num % 5 == 0));
        System.out.println("Se leyeron " + contador + " números");
        System.out.println("Se leyeron " + contadorPar + " números pares");
        System.out.println("Se leyeron " + contadorImpar + " números impares");
    }
}
