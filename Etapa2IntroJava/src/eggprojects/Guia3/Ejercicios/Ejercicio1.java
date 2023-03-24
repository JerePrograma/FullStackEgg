package eggprojects.Guia3.Ejercicios;

import java.util.Scanner;
/*Crear un programa que dado un número determine si es par o impar.*/
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un número");
        int num = leer.nextInt();
        if (num % 2 != 0) {
      //Si el número dividido por 2 su resto NO da 0, entonces:       
            System.out.println("El número es impar");
        } else {
            System.out.println("El número es par");
        }
    }
}