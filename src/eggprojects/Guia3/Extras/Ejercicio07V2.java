/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eggprojects.Guia3.Extras;

import java.util.Scanner;

/**
 *
 * @author Jerem
 */
public class Ejercicio07V2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese la cantidad de números que se solicitarán");
        int n = leer.nextInt();

        int valorMaximo = 0, valorMinimo = 0, contador = 0;
        double promedio = 0;
        int num;
        do {
            System.out.println("Ingrese un número");
            num = leer.nextInt();
            if (contador == 0) {
                valorMaximo = num;
                valorMinimo = num;
            }
            if (valorMaximo < num) {
                valorMaximo = num;
            } else if (valorMinimo > num) {
                valorMinimo = num;
            }
            promedio += num;
            contador++;
        } while (contador < n);
        promedio /= n;
        System.out.println("El número más grande es: " + valorMaximo);
        System.out.println("El número más chico es: " + valorMinimo);
        System.out.println("El promedio de los números es: " + promedio);
    }
}
